package com.revature.main;

import com.revature.beans.Employee;
import com.revature.dao.ShaneScriptDAO;
import com.revature.dao.ShaneScriptDAOImpl;
import com.revature.service.ShaneScriptService;
import com.revature.service.ShaneScriptServiceImpl;

public class Driver {
	
	
	public static void main(String[] args) {
		ShaneScriptDAO ssd = new ShaneScriptDAOImpl();
	 ShaneScriptService s = new ShaneScriptServiceImpl();

		
		String user="BIRHAN";
		String pass="BIRHAN";
		//System.out.println("Resolved DAO sheebla: " + ssd.viewResolved(2022));
		//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Whats it say?");
//		System.out.println("Resolved sheebla: " + s.viewResolved(2022)+"  "+ssd.viewResolved(2022));
//		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Whats it say?");
//		System.out.println("is manager: "+ssd.isManager(2022));
		//System.out.println(ssd.viewAllRequests());
		//System.out.println(ssd.viewResolved(2022));
		String answer= "LOLOL";
		int reqId=2042;
		int empId=2060;
		int amt=2222;
		int day=4;
		int month=4;
				int year=4444;
		ssd.makeRequest(amt, day, month, year, empId);
		System.out.println(s.viewAllRequests());
		//ssd.RespondtoRequest(answer, reqId);
		//System.out.println(s.viewAllRequests());
//		System.out.println("plz wrk");
//		System.out.println("INTERN is manager: "+ s.isManager(2060));
//		System.out.println("is manager dao: "+ ssd.isManager(2022));
//		System.out.println("Bir manages Intern: (should be true)  "+ssd.YouManageThatEmployee(2060, 2022));
//		System.out.println("Intern manages Bir: (should be false)  "+ssd.YouManageThatEmployee(2022, 2060));
//		System.out.println(ssd.getEmpIdFromReqNum(2041));
////		System.out.println(ssd.viewAllEmployeesInfo());
//		System.out.println(ssd.Employeelogin(user, pass));
//		System.out.println(ssd.getIdFromLogin(user, pass));
	}

}
