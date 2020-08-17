package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sq")
public class SqServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8940027114670341333L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, NumberFormatException{
		
		
		HttpSession session = req.getSession();
		
		int k = (int)session.getAttribute("k");
		 k = k*k;
		 
		PrintWriter out = res.getWriter();
		out.println(k);
		out.println("sq called");
	}
}
