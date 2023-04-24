package org.example.guessing.web.servlet;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.guessing.GuessingGame;
import org.example.guessing.Node;

import static org.example.guessing.utils.PropertyUtils.readProperties;
import static org.example.guessing.utils.ServletUtils.dispatcher;
import static org.example.guessing.utils.ServletUtils.getGameGuessing;

public class OkServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) {
        ResourceBundle resourceBundle = readProperties();
        String root = resourceBundle.getString("guessing.root");
        String next = resourceBundle.getString("guessing.next");
        String other = resourceBundle.getString("guessing.other");
        config.getServletContext().setAttribute("guessing", new GuessingGame(Node.of(root, next, other)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GuessingGame guessingGame = getGameGuessing(request);
        Node node = guessingGame.ok();
        dispatcher(request, response, node);
    }
}
