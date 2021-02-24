package com.ibm.dao;

import com.ibm.eis.bean.Employee;

public interface DaoInterface {
	public void addEmployeeDetails(Employee employee);
	String findScheme(Employee employee);
	void displayEmployees();
}
