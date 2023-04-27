package org.example.guessing.utils;

import org.example.guessing.Node;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.guessing.utils.GsonUtils.toJson;

public class ServletUtils {

    public static void dispatcher(HttpServletRequest request, HttpServletResponse response, Node node)
            throws ServletException, IOException {
        dispatcher(request, response, node, null);
    }

    public static void dispatcher(HttpServletRequest request, HttpServletResponse response, Node node, String dispatcher)
            throws ServletException, IOException {
        if (node == null) {
            request.getRequestDispatcher(dispatcher).forward(request, response);
        } else {
            request.getSession().setAttribute("nodeObject", node);
            String json = toJson(node);
            request.getSession().setAttribute("node", json);
            request.getRequestDispatcher("/ask.jsp").forward(request, response);
        }
    }
}
