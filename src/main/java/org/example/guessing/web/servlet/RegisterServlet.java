package org.example.guessing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.guessing.Node;

import static org.example.guessing.utils.GuessingGameUtils.getGuessingGame;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createNode(request);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void createNode(HttpServletRequest request) {
        Node node = (Node) request.getSession().getAttribute("nodeObject");
        String characteristic = request.getParameter("characteristic");
        String name = request.getParameter("name");
        getGuessingGame().addNode(node, name, characteristic);
    }
}
