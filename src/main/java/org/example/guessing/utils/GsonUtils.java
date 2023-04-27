package org.example.guessing.utils;

import com.google.gson.Gson;

public class GsonUtils {

    private static final Gson gson = new Gson();

    public static <T> String toJson(T t) {
        return gson.toJson(t);
    }
}
