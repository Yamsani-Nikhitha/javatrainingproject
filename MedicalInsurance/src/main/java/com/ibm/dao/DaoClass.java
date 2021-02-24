package com.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.eis.bean.Employee;

public class DaoClass implements DaoInterface{
	Connection dbcon;
	String query;
	ResultSet resultSet;
	Statement theStatement;
	public DaoClass(){
		String url = "jdbc:mysql://localhost:3306/assignment";
		String userName = "root";
		String userPassword = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbcon = DriverManager.getConnection(url, userName, userPassword);
			theStatement = dbcon.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot load the Driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("cannot connect to db : " + e.getMessage());
		}

	}
	
	public void addEmployeeDetails(Employee employee) {
		
		query = "insert into employees(Id,Name,Salary,Designation,Scheme) values (?,?,?,?,?)";
		try {
			PreparedStatement pStatement = dbcon.prepareStatement(query);
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getName());
			pStatement.setDouble(3, employee.getSalary());
			pStatement.setString(4, employee.getDesignation());
			pStatement.setString(5, employee.getScheme());
			if(pStatement.executeUpdate()>0) {
				System.out.println("successfully added.");
			}
			else {
				System.out.println("adding employee details failed ");
			}
		}catch(SQLException e)
		{
			System.out.println("isues in addEmployeeDetails "+e.getMessage());
		}
		
	}
	public String findScheme(Employee employee) {
		String scheme;
		if((employee.getSalary()>5000) && (employee.getSalary()<20000) && (employee.getDesignation().equals("System Associate"))) {
			//System.out.println("Scheme C is applied");
			
			scheme = "Scheme C";
			employee.setScheme(scheme);
		}
		else if((employee.getSalary()>= 20000) && (employee.getSalary()<40000) && (employee.getDesignation().equals("Programmer"))){
			//System.out.println("Schem B is applied");
			 scheme="Schem B";
			 employee.setScheme(scheme);
		}
		else if((employee.getSalary() >= 40000) && (employee.getDesignation().equals("Manager"))) {
			//System.out.println("Scheme A is applied");
			 scheme= "Scheme A";
			 employee.setScheme(scheme);
		}
		else if((employee.getSalary() < 5000) && (employee.getDesignation().equals("Clerk"))) {
			//System.out.println("No Scheme");
			 scheme= "No Scheme";
			 employee.setScheme(scheme);
		}
		else {
			//System.out.println("wrong input");
			 scheme= "";
		}
		return scheme;
			
	}
	public void displayEmployees() {
		query="select *from Employees";
		//String dis;
		try {
			resultSet = theStatement.executeQuery(query);
			while (resultSet.next()) {
				System.out.print("Id : "+resultSet.getInt("Id"));
				System.out.print(", Name : " + resultSet.getString("Name"));
				System.out.print(", Salary : " + resultSet.getInt("Salary"));
				System.out.print(", Designation : " + resultSet.getString("Designation"));
				System.out.println(", Scheme : "+resultSet.getString("Scheme"));
	
			 //dis="Id : "+resultSet.getInt("Id")+", Name : "+resultSet.getString("Name")+", Salary : "+resultSet.getInt("Salary")+", Designation : "+resultSet.getString("Designation");
			}
		}catch(SQLException e) {
			System.out.println("issues while displaying details "+e.getMessage());
		}
		 
		
	}
	
}
