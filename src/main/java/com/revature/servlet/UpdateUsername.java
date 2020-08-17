package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Request;
import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

/**
 * Servlet implementation class UpdateUsername
 */
@WebServlet("/UpdateUsername")
public class UpdateUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUsername() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShaneScriptService s = new ShaneScriptServiceImpl();
		HttpSession session=request.getSession(false);
		String newuser= (request.getParameter("newuser").toString());
		int id= Integer.parseInt(session.getAttribute("USERID").toString());
		
		s.updateEmail(newuser, id);
		String output=s.updateUsername(newuser, id);
		String resp = (new ObjectMapper()).writeValueAsString(output);
		response.getWriter().write(resp);
		

		//response.getWriter().write(om.writeValueAsString(s.viewResolved(user)));
		//s.viewResolved(user)
		//response.getWriter().write((new ObjectMapper()).writeValueAsString(u));
		
		/*
		 * 			ArrayList<Requests> list = es.viewAll(userId);
					String resp = new ObjectMapper().writeValueAsString(list);
					response.getWriter().write(resp);
					break;
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
