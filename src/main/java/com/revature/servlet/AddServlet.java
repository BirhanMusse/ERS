package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")

public class AddServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6961179325215119147L;

	
	
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		try {
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		//int j=1;
		int k = i+j;
		
//		 HttpSession session = req.getSession();
//				 session.setAttribute("k", k);
//				 session.getAttribute("k").toString();
//				 session.setAttribute(name, value);
//				 Integer.par
//		//req dis and redirect
//		res.sendRedirect("sq");
//		 
//		//RequestDispatcher rd = req.getRequestDispatcher("sq");
//		// rd.forward(req, res); 
		 

		}
		
		
		catch(NumberFormatException e) {
			PrintWriter out = res.getWriter();
			out.println("nah bruh");
		}
	}
	
}
