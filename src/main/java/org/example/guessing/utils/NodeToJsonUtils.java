package org.example.guessing.utils;

import com.google.gson.Gson;
import org.example.guessing.Node;

public class NodeToJsonUtils {

    private static final Gson gson = new Gson();

    public static String toJson(Node node) {
        return gson.toJson(node);
    }
}
