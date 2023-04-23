package org.example.guessing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import org.example.guessing.GuessingGame;
import org.example.guessing.Node;

public class YesServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuessingGame guessingGame = (GuessingGame) request.getSession().getServletContext().getAttribute("guessing");
		Node node = guessingGame.yes();
		if (node == null) {
			request.getRequestDispatcher("/end.jsp").forward(request, response);
		} else {
			String nodeJson = new Gson().toJson(node);
			request.getSession().setAttribute("node", nodeJson);
			request.getRequestDispatcher("/ask.jsp").forward(request, response);
		}
	}
}
