package com.itmaoo.spider.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ContainerNode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private final static ObjectMapper objectMapper2 = new ObjectMapper();
    private static final String ERROR_TXT = "error";

    public static String objectToJson(Object object) {
        try {
            return objectMapper2.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("to json exception", e);
            return null;
        }
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper2.readValue(json, clazz);
        } catch (Exception e) {
            logger.error(JsonUtils.ERROR_TXT + json, e);
            return null;
        }
    }
    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper2.readValue(json, typeReference);
        } catch (Exception e) {
            logger.error(JsonUtils.ERROR_TXT + json, e);
            return null;
        }
    }

    //获取指定路径下的Json字符串
    public static String getSubString(String json, String path) {
        if (StringUtils.isBlank(json) || StringUtils.isBlank(path)) {
            return null;
        }
        try {
            JsonNode node = objectMapper2.readTree(json);
            JsonNode targetNode = node.at(JsonPointer.compile(path));
            return (targetNode instanceof ContainerNode) ? targetNode.toString() : targetNode.asText();
        } catch (Exception e) {
            logger.error(JsonUtils.ERROR_TXT + json, e);
            return null;
        }
    }

    public static <T> T jsonToObject(String json, Class<T> clazz, String path) {
        String subString = getSubString(json, path);
        if (StringUtils.isNotBlank(subString)) {
            return jsonToObject(subString, clazz);
        }
        return null;
    }

    public static <T> List<T> jsonToList(String json, Class clazz) {
        if (StringUtils.isEmpty(json)) {
            return Collections.emptyList();
        }
        try {
            JavaType javaType = objectMapper2.getTypeFactory()
                    .constructParametricType(ArrayList.class, clazz);
            return objectMapper2.readValue(json, javaType);
        } catch (IOException e) {
            logger.error(JsonUtils.ERROR_TXT + e.getMessage(), e);
            return Collections.emptyList();
        }
    }

   
    static {

        objectMapper2.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper2.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper2.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper2.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper2.setLocale(Locale.CHINA);
    }
}
