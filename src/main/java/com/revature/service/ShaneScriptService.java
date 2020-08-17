package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Answer;
import com.revature.beans.Employee;
import com.revature.beans.Request;

public interface ShaneScriptService {
	public Employee viewMyInfo(int empId);
	public boolean Employeelogin(String username, String password);
	public boolean isManager(int empid);
	public int getIdFromLogin(String username, String password);
	public void updatePassword(String pass, int empId);
	public String updateUsername(String user, int empId);
	public String updateEmail(String email, int empId);
	public void makeRequest(double amt, int day, int month, int year, int empId);
	public ArrayList<Request> viewPending(int emp_id);
	public ArrayList<Request> viewResolved(int emp_id);
	public Answer getans();
	/*
	 * Manager methods
	 */
	public ArrayList<Request> viewAllRequests();
	public ArrayList<Employee> viewAllEmployeesInfo();
	public void RespondtoRequest(String answer,int reqId);
	public boolean YouManageThatEmployee(int empid, int manId);
	public int getEmpIdFromReqNum (int reqNum);

}