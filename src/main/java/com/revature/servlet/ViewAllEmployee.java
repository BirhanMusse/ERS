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
import com.revature.beans.Answer;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

/**
 * Servlet implementation class ViewAllEmployee
 */
@WebServlet("/ViewAllEmployee")
public class ViewAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShaneScriptService s = new ShaneScriptServiceImpl();
		HttpSession session=request.getSession(false);
		int user= Integer.parseInt(session.getAttribute("USERID").toString());
		
		if (s.isManager(user)) {
			ArrayList<Employee> list =s.viewAllEmployeesInfo();
			String resp = (new ObjectMapper()).writeValueAsString(list);
			response.getWriter().write(resp);
			
		}
//		else {
//		Answer ans = s.getans();
//		String resp = (new ObjectMapper()).writeValueAsString(ans);
//		response.getWriter().write(resp);
//		}
		
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

	private String Answer(String string) {
		// TODO Auto-generated method stub
		return string;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
