package com.prottonne.json.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    public static <T> T setObject(Class<T> typeClass, String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, typeClass);
    }

    public static <T> String toJson(T instanceClass) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(instanceClass);
    }
}
