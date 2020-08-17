package com.revature.beans;

public class Employee {
	public Employee() {
		super();
	}
	public Employee( int empId, String firstname, String lastname, int repsTo, String email, int isMan) {
		this.empId=empId;
		this.firstname=firstname;
		this.lastname=lastname;
		this.repsTo=repsTo;
		this.email=email;
		this.isMan=isMan;
		
	}
	private int empId;
	private String firstname;
	private String lastname;
	private int repsTo;
	private String email;
	private int isMan;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getRepsTo() {
		return repsTo;
	}
	public void setRepsTo(int repsTo) {
		this.repsTo = repsTo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsMan() {
		return isMan;
	}
	public void setIsMan(int isMan) {
		this.isMan = isMan;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstname=" + firstname + ", lastname=" + lastname + ", repsTo=" + repsTo
				+ ", email=" + email + ", isMan=" + isMan + "]";
	}

	
}
