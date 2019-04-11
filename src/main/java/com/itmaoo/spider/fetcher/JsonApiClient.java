package com.itmaoo.spider.fetcher;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;

import com.itmaoo.spider.log.StreamLog;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class JsonApiClient {


    private final static int SUCCESS = 200;
    private final static String UTF8 = "UTF-8";

    /**
     * post 请求
     */
    public static String post(String url, Map<String, String> param, String sourceId) {
        return send(url, param, true, sourceId);

    }

    /**
     * get 请求
     */
    public static String get(String url, Map<String, String> param, String sourceId) {
        StringBuffer uri = new StringBuffer();
        if (param != null) {
            uri.append("?");
            for (Map.Entry<String, String> mapEntry : param.entrySet()) {
                if (!uri.toString().endsWith("?") && !uri.toString().endsWith("&")) {
                    uri.append("&");
                }
                uri.append(mapEntry.getKey() + "=" + mapEntry.getValue());
            }
        }

        return send(url + uri.toString(), null, false, sourceId);

    }
    public static String get(String url, String sourceId) {
        return send(url, null, false, sourceId);

    }

    private static String send(String url, Map<String, String> map, Boolean isPost, String sourceId) {
        //sourceId, type, duration, datetime, status, response, errorMsg
        StreamLog streamLog = new StreamLog();
        streamLog.setSourceId(sourceId);
        streamLog.setType(isPost ? "POST" : "GET");
        streamLog.setStatus("Success");
        DateTime requestStart = new DateTime();

        streamLog.setDatetime(requestStart.toString("yyyy-MM-dd HH:mm:sss.S"));
        streamLog.setUrl(url);
        try {
            String body = "";
            //采用绕过验证的方式处理https请求
            SSLContext sslcontext = createIgnoreVerifySSL();

            // 设置协议http和https对应的处理socket链接工厂的对�?
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext))
                    .build();
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            HttpClients.custom().setConnectionManager(connManager);

            //创建自定义的httpclient对象
            CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
//		    CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response;

            if (isPost) {
                //创建post方式请求对象
                HttpPost httpPost = new HttpPost(url);

                //装填参数
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                    }
                }

                //设置参数到请求对象中
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, UTF8));


                //设置header信息
                //指定报文头�?�Content-type】�?��?�User-Agent�?
                httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
                httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

                //执行请求操作，并拿到结果（同步阻塞）
                response = client.execute(httpPost);
                streamLog.setUrl(url + nvps.toString());
            } else {

                //创建post方式请求对象
                HttpGet httpGet = new HttpGet(url);

                //装填参数
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                    }
                }

                //设置header信息
                //指定报文头�?�Content-type】�?��?�User-Agent�?
                httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
                httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

                //执行请求操作，并拿到结果（同步阻塞）
                response = client.execute(httpGet);
            }
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, UTF8);
            }
            EntityUtils.consume(entity);
            //释放链接
            response.close();
            DateTime requestEnd = new DateTime();
            streamLog.setDuration(String.valueOf(requestEnd.getMillis() - requestStart.getMillis()));
            streamLog.setResponse(body);
            return body;
        } catch (NoSuchAlgorithmException e) {
            streamLog.setStatus("Fail");
            streamLog.setErrorMsg(e.getMessage());
            log.error(sourceId, e.getStackTrace());
        } catch (KeyManagementException e) {
            streamLog.setStatus("Fail");
            streamLog.setErrorMsg(e.getMessage());
            log.error(sourceId, e.getStackTrace());
        } catch (IOException e) {
            streamLog.setStatus("Fail");
            streamLog.setErrorMsg(e.getMessage());
            log.error(sourceId, e.getStackTrace());
        } finally {
            log.info(streamLog.toString());
        }
        return null;
    }

    /**
     * HTTPS 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现�?个X509TrustManager接口，用于绕过验证，不用修改里面的方�?
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

}