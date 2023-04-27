package org.example.guessing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.example.guessing.utils.ServletUtils.dispatcher;
import static org.example.guessing.utils.GuessingGameUtils.getGuessingGame;

public class YesServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dispatcher(request, response, getGuessingGame().yes(), "/end.jsp");
	}
}
