package org.example.guessing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.guessing.Node;

import static org.example.guessing.utils.ServletUtils.dispatcher;
import static org.example.guessing.utils.ServletUtils.setSessionNodeObject;
import static org.example.guessing.web.BuildGuessingGame.guessingGame;

public class NoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Node node = guessingGame.no();
		setSessionNodeObject(request, node);
		dispatcher(request, response, node, "/register.jsp");
	}
}