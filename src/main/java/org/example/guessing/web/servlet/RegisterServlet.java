package org.example.guessing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.guessing.GuessingGame;
import org.example.guessing.Node;
import org.example.guessing.exception.ValueUniqueException;

import static org.example.guessing.utils.GsonUtils.fromJson;
import static org.example.guessing.utils.ServletUtils.getGameGuessing;
import static org.example.guessing.utils.ServletUtils.restart;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuessingGame guessingGame = getGameGuessing(request);
		String json = (String) request.getSession().getAttribute("node");
		Node node = fromJson(json);
		String characteristic = request.getParameter("characteristic");
		String name = request.getParameter("name");
		try {
			guessingGame.addNode(node, name, characteristic);
			restart(request, response);
		} catch (ValueUniqueException e) {
			request.getSession().setAttribute("error", e.getMessage());
			request.getSession().setAttribute("node", json);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
}
