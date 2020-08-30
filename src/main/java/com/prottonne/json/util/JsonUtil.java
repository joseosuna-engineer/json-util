package com.prottonne.json.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prottonne.json.dto.Request;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonUtil {

    public static <T> T toObject(Class<T> typeClass, String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeClass);
    }

    public static <T> String toJson(T instanceClass) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(instanceClass);
    }

    public static Request toObject(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Request request = mapper.readValue(json, Request.class);
            return request;
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
