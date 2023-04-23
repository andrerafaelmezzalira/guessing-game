package org.example.guessing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import org.example.guessing.GuessingGame;
import org.example.guessing.Node;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuessingGame guessingGame = (GuessingGame) request.getSession().getServletContext().getAttribute("guessing");
		String inputJsonNode = (String) request.getSession().getAttribute("node");
		Node node = new Gson().fromJson(inputJsonNode, Node.class);

		String characteristic = request.getParameter("characteristic");
		String name = request.getParameter("name");

		guessingGame.addNode(node, characteristic, name);

		request.getSession().removeAttribute("node");
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	}
}
