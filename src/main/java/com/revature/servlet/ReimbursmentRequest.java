package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

/**
 * Servlet implementation class ReimbursmentRequest
 */
@WebServlet("/ReimbursmentRequest")
public class ReimbursmentRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursmentRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Emphome.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShaneScriptService s = new ShaneScriptServiceImpl();
		HttpSession session=request.getSession(false);
		int empId= Integer.parseInt(session.getAttribute("USERID").toString());
		double amt= Double.parseDouble(request.getParameter("amt").toString());
		int day= Integer.parseInt(request.getParameter("day").toString());
		int month= Integer.parseInt(request.getParameter("month").toString());
		int year= Integer.parseInt(request.getParameter("year").toString());
		s.makeRequest(amt, day, month, year, empId);
		System.out.println("request has been made!");
		response.sendRedirect("profile");
	}

}
