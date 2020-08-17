package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Answer;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.dao.ShaneScriptDAO;
import com.revature.dao.ShaneScriptDAOImpl;

public class ShaneScriptServiceImpl implements ShaneScriptService {

	private ShaneScriptDAO ssd = new ShaneScriptDAOImpl();
	
	@Override
	public boolean Employeelogin(String username, String password) {
		return ssd.Employeelogin(username, password);
	}

	@Override
	public boolean isManager(int empid) {
		return ssd.isManager(empid);
	}

	@Override
	public int getIdFromLogin(String username, String password) {
		// TODO Auto-generated method stub
		return ssd.getIdFromLogin(username, password);
	}

	@Override
	public Employee viewMyInfo(int empId) {
		// TODO Auto-generated method stub
		
		return ssd.viewMyInfo(empId);
	}

	@Override
	public void updatePassword(String pass, int empId) {
		ssd.updatePassword(pass, empId);
		
	}

	@Override
	public String updateUsername(String user, int empId) {
		return ssd.updateUsername(user, empId);
	}

	@Override
	public String updateEmail(String email, int empId) {
		return ssd.updateEmail(email, empId);
	}

	@Override
	public void makeRequest(double amt, int day, int month, int year, int empId) {
		ssd.makeRequest(amt, day, month, year, empId);
		
	}

	@Override
	public ArrayList<Request> viewPending(int emp_id) {
		return ssd.viewPending(emp_id)		;
	}

	@Override
	public ArrayList<Request> viewResolved(int emp_id) {
		return ssd.viewResolved(emp_id);
	}

	@Override
	public ArrayList<Request> viewAllRequests() {
		return ssd.viewAllRequests();
	}

	@Override
	public ArrayList<Employee> viewAllEmployeesInfo() {
		return ssd.viewAllEmployeesInfo();
	}

	@Override
	public void RespondtoRequest(String answer,int reqId) {
		ssd.RespondtoRequest( answer, reqId);
		
	}

	@Override
	public boolean YouManageThatEmployee(int empid, int manId) {
		return ssd.YouManageThatEmployee(empid, manId);
	}

	@Override
	public Answer getans() {
		return  getans();
	}

	@Override
	public int getEmpIdFromReqNum(int reqNum) {
return ssd.getEmpIdFromReqNum(reqNum);
	}
	
}