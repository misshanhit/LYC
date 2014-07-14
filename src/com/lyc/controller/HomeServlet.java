package com.lyc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyc.model.Member;
import com.lyc.model.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getContentType();
		PrintWriter writer = response.getWriter();
		writer.println("Full Name: " + request.getParameter("firstName") + " " + request.getParameter("lastName"));
		writer.println("<br>Email: " + request.getParameter("email"));
		writer.println("<br>Birthday: " + request.getParameter("monthOfBirth") + 
								"/"  + request.getParameter("dayOfBirth") + 
								"/"  + request.getParameter("yearOfBirth"));
		User user = new User(request.getParameter("email"), request.getParameter("password"));
		Member member = new Member(request.getParameter("firstName"));
		
		request.setAttribute("user", user);
		request.setAttribute("member", member);
		RequestDispatcher view = request.getRequestDispatcher("desktop_web/frontend/new_feed/NewFeed.jsp");
		view.forward(request, response);
	}

}
