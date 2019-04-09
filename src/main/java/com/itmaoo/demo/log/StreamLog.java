package com.itmaoo.demo.log;

import org.apache.commons.lang.StringUtils;

public class StreamLog {
    //
    private String sourceId;
    private String type;
    private String duration;
    // yyyy-MM-dd HH:mm:ss.S
    private String datetime;
    private String status;
    private String response;
    private String errorMsg;
    private String url;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {

        return (sourceId == null ? StringUtils.EMPTY : sourceId) +
                "|" + (type == null ? StringUtils.EMPTY : type) +
                "|" + (duration == null ? StringUtils.EMPTY : duration) +
                "|" + (datetime == null ? StringUtils.EMPTY : datetime) +
                "|" + (status == null ? StringUtils.EMPTY : status) +
                "|" + (url == null ? StringUtils.EMPTY : url) +
                "|" + (response == null ? StringUtils.EMPTY : response) +
                "|" + (errorMsg == null ? StringUtils.EMPTY : errorMsg);

    }
}
