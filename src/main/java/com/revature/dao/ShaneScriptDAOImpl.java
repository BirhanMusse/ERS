package com.revature.dao;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.revature.beans.Answer;
import com.revature.beans.Employee;
import com.revature.beans.Request;
import com.revature.util.ConnectionUtil;

public class ShaneScriptDAOImpl implements ShaneScriptDAO{

	
	String url = "//Users//birhan//eclipse-workspace3//birhanproject1//src//main//resources//connection.properties";
	
	
	@Override
	public ArrayList<Employee> viewAllEmployeesInfo() {
		ArrayList<Employee> li= new ArrayList<>();
		System.out.println("testing");
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
		String query = "SELECT * FROM EMPLOYEE";
		PreparedStatement stmt = con.prepareStatement(query);
		
		ResultSet rs=stmt.executeQuery();
		while (rs.next()) {
			int id=rs.getInt("EMP_ID");
			String firstname = rs.getString("FIRSTNAME");
			String lastname = rs.getString("LASTNAME");
			int reps = rs.getInt("REPORTSTO");
			String email = rs.getString("EMAIL");
			int man = rs.getInt("IS_MANAGER");
			 li.add(new Employee(id, firstname, lastname, reps, email, man));
		} 
}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}		
		return li;

}

	@Override
	public Employee viewMyInfo(int empid) {
		Employee emp = new Employee();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "SELECT * FROM EMPLOYEE where emp_id="+empid;
			PreparedStatement stmt = con.prepareStatement(query);
			
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("EMP_ID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				int reps = rs.getInt("REPORTSTO");
				String email = rs.getString("EMAIL");
				int man = rs.getInt("IS_MANAGER");
				 emp= (new Employee(id, firstname, lastname, reps, email, man));
				 
			} 
	}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
			
		
		
		return emp;
		
	}
	
	@Override
	public Answer getans() {
		Answer ans = new Answer("You Are Not a Manager! You do not have access to this part of the Homepage");
		return ans;
	}
	
	@Override
	public boolean Employeelogin(String username, String password) {
		boolean x = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
		String query = "SELECT * FROM LOGIN WHERE USERNAME=? AND PASS=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			x=true;
		}
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}return x;
	}

	
	@Override
	public boolean isManager( int empid) {
		boolean man = false;
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
		String query = "SELECT IS_MANAGER FROM EMPLOYEE WHERE EMP_ID=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, empid);
		
		ResultSet rs= stmt.executeQuery();
		
		if(rs.next() && rs.getInt("IS_MANAGER")==1) {
			man=true;
		}
		
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}
		return man;
	}

	@Override
	public int getIdFromLogin(String username, String password) {
		int x = 0;
		try(Connection con = ConnectionUtil.getConnectionFromFile("//Users//birhan//eclipse-workspace3//birhanproject1//src//main//resources//connection.properties")){
		String query = "SELECT EMP_ID FROM LOGIN WHERE USERNAME=? AND PASS=?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		x=rs.getInt("EMP_ID");
	}
	catch (SQLException | IOException e) {
		e.printStackTrace();
	}
		return x;
	}

	@Override
	public void updatePassword(String pass, int empId) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "UPDATE LOGIN SET PASS=? WHERE EMP_ID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, pass);
			stmt.setInt(2, empId);
			

			
			stmt.executeUpdate();
			stmt.close();			
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String updateUsername(String user, int empId) {
		String str = "Your new username is: "+user + "...Click backspace to return to the homepage";
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "UPDATE LOGIN SET USERNAME=? WHERE EMP_ID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, user);
			stmt.setInt(2, empId);
			

			
			stmt.executeUpdate();
			stmt.close();			
			
		}catch (SQLIntegrityConstraintViolationException reason ) { 
			str="[ERROR] - Username already taken!"+ "...Click backspace to return to the homepage";
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
		return str;
	}

	@Override
	public String updateEmail(String email, int empId) {
		String str = "Your new email is: "+email;
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "UPDATE EMPLOYEE SET EMAIL=? WHERE EMP_ID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setInt(2, empId);
			

			
			stmt.executeUpdate();
			stmt.close();			
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
		return str;		
	}

	@Override
	public void makeRequest(double amt, int day, int month, int year,int empId) {
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "INSERT INTO REQUEST (AMOUNT, DAY_OF, MONTH_OF, YEAR_OF, EMP_ID) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, amt);;
			stmt.setInt(2, day);
			stmt.setInt(3, month);
			stmt.setInt(4, year);
			stmt.setInt(5, empId);

			
			stmt.executeUpdate();
			stmt.close();			
			
		}catch (SQLIntegrityConstraintViolationException reason ) { 
			String str="[ERROR] - please enter a valid date!";
			System.out.println(str);
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
		
	}
	

	@Override
	public ArrayList<Request> viewPending(int empid) {
		ArrayList <Request> li= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "Select * from Request WHERE EMP_ID=" + empid + "AND STATUS= 'PENDING'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			


			
			while(rs.next()) {
				
				 int reqId = rs.getInt("REQ_NUM");
				 double amount = rs.getDouble("AMOUNT");
				 int day= rs.getInt("DAY_OF");
				 int month= rs.getInt("MONTH_OF");
				 int year= rs.getInt("YEAR_OF");
				 String stat=rs.getString("STATUS");
				 String ans=rs.getString("REQ_ANSWER");
				 int empId= rs.getInt("EMP_ID");
				 
				 li.add(new Request(reqId,amount,day,month,year,stat,ans,empId));
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
	return li;
	}

	@Override
	public ArrayList<Request> viewAllRequests() {
		ArrayList <Request> li= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "Select * from Request";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			


			
			while(rs.next()) {
				
				 
				 int reqId = rs.getInt("REQ_NUM");
				 double amount = rs.getDouble("AMOUNT");
				 int day= rs.getInt("DAY_OF");
				 int month= rs.getInt("MONTH_OF");
				 int year= rs.getInt("YEAR_OF");
				 String stat=rs.getString("STATUS");
				 String ans=rs.getString("REQ_ANSWER");
				 int empId= rs.getInt("EMP_ID");
				 
				 li.add(new Request(reqId,amount,day,month,year,stat,ans,empId));
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
	return li;
	}
	
	
	@Override
	public ArrayList<Request> viewResolved(int empid) {
		ArrayList <Request> li= new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "Select * from Request Where EMP_ID= "+empid+" AND status='RESOLVED'";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			


			
			while(rs.next()) {
				
				 
				 int reqId = rs.getInt("REQ_NUM");
				 double amount = rs.getDouble("AMOUNT");
				 int day= rs.getInt("DAY_OF");
				 int month= rs.getInt("MONTH_OF");
				 int year= rs.getInt("YEAR_OF");
				 String stat=rs.getString("STATUS");
				 String ans=rs.getString("REQ_ANSWER");
				 int empId= rs.getInt("EMP_ID");
				 
				 li.add(new Request(reqId,amount,day,month,year,stat,ans,empId));
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		
	return li;
	}

	@Override
	public void RespondtoRequest(String answer,int reqId) {
		
		
		
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query="UPDATE REQUEST SET STATUS= 'RESOLVED', REQ_ANSWER= ? WHERE REQ_NUM= ?";

			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, answer);
			stmt.setInt(2, reqId);

			

			stmt.executeUpdate();
			
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		

		}
	

	@Override
	public boolean YouManageThatEmployee(int empid, int manId) {
		boolean x=false;
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "Select * from employee WHERE EMP_ID="+empid+"AND REPORTSTO ="+manId;
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
//			stmt.setInt(1, empid);
//			stmt.setInt(2, manId);


			
			if(rs.next()) {
				x=true;
				 
			}
			
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return x;
				
	}

	@Override
	public int getEmpIdFromReqNum(int reqNum) {
		int x=0;
		try(Connection con = ConnectionUtil.getConnectionFromFile(url)){
			String query = "Select EMP_ID from REQUEST WHERE REQ_NUM="+reqNum;
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
			x=rs.getInt("EMP_ID");
//			
			}
		}
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}		return x;
	}



	







	




}
