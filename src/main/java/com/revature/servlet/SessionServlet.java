//package com.revature.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.revature.beans.Login;
//
//
//@WebServlet("/session")
///**
// * Servlet implementation class SessionServlet
// */
//public class SessionServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public SessionServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//grab current session, if it exists
//		//response.setContentType("application/json");
//		HttpSession session = request.getSession(false);
//		
//		if (session != null && session.getAttribute("username") != null) {
//			try {
//				int userId = Integer.parseInt(session.getAttribute("userId").toString());
//				String username = session.getAttribute("username").toString();
//				String firstname = session.getAttribute("firstname").toString();
//				String lastname = session.getAttribute("lastname").toString();
//				String email = session.getAttribute("email").toString();
//				Login log = new Login(username, firstname,5);
//				response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
//			} catch (Exception e) {
//				e.printStackTrace();
//				response.getWriter().write("{\"session\":null}");
//			}
//		} else {
//			response.getWriter().write("{\"session\":null}");
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
