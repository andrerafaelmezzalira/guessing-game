package org.example.guessing.utils;

import com.google.gson.Gson;
import org.example.guessing.Node;

public class GsonUtils {

    private static final Gson gson = new Gson();

    public static String toJson(Node node) {
        return gson.toJson(node);
    }

    public static Node fromJson(String json) {
        return gson.fromJson(json, Node.class);
    }
}
