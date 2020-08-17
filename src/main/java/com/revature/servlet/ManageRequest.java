package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

/**
 * Servlet implementation class ManageRequest
 */
@WebServlet("/ManageRequest")
public class ManageRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRequest() {
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
		
		
		
		int manId= Integer.parseInt(session.getAttribute("USERID").toString());
		if(s.isManager(manId)) {
			String answer=request.getParameter("response").toString();
			
			
			int reqNum=Integer.parseInt(request.getParameter("reqnum").toString());
			int empId=s.getEmpIdFromReqNum(reqNum);
			
			if(s.YouManageThatEmployee(empId, manId)) {
				s.RespondtoRequest(answer, reqNum);
				PrintWriter out = response.getWriter();
				out.println("Your Response has been recorded!");
				
			}
			
			
		}
	
		
		
		
		
		//s.makeRequest(amt, day, month, year, empId);
		System.out.println("request made!");
		response.sendRedirect("profile");
	}


}
