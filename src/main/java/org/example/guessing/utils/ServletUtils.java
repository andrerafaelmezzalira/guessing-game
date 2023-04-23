package org.example.guessing.utils;

import org.example.guessing.GuessingGame;
import org.example.guessing.Node;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.guessing.utils.GsonUtils.toJson;

public class ServletUtils {

    public static GuessingGame getGameGuessing(HttpServletRequest request) {
        return (GuessingGame) request.getSession().getServletContext().getAttribute("guessing");
    }

    public static void restart(HttpServletRequest request,
                               HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("node");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    public static void dispatcher(HttpServletRequest request, HttpServletResponse response, Node node, String dispatcher)
            throws ServletException, IOException {
        if (node == null) {
            request.getRequestDispatcher(dispatcher).forward(request, response);
        } else {
            String json = toJson(node);
            request.getSession().setAttribute("node", json);
            request.getRequestDispatcher("/ask.jsp").forward(request, response);
        }
    }
}
