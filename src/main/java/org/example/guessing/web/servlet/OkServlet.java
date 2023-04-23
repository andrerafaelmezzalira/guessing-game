package org.example.guessing.web.servlet;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import org.example.guessing.GuessingGame;
import org.example.guessing.Node;
import org.example.guessing.utils.PropertyUtils;

public class OkServlet extends HttpServlet {

    private static final ResourceBundle resourceBundle = PropertyUtils.readProperties();

    @Override
    public void init(ServletConfig config) {
        String root = resourceBundle.getString("guessing.root");
        String next = resourceBundle.getString("guessing.next");
        String other = resourceBundle.getString("guessing.other");
        config.getServletContext().setAttribute("guessing", new GuessingGame(Node.of(root, next, other)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuessingGame guessingGame = (GuessingGame) request.getSession().getServletContext().getAttribute("guessing");
        Node node = guessingGame.ok();
        String nodeJson = new Gson().toJson(node);
        request.getSession().setAttribute("node", nodeJson);
        request.getRequestDispatcher("/ask.jsp").forward(request, response);
    }
}
