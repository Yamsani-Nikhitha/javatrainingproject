package com.ibm.service;

import com.ibm.dao.DaoClass;
import com.ibm.eis.bean.Employee;

public class ServiceClass implements ServiceInterface {

	DaoClass dao = new DaoClass();
	
	@Override
	public void addEmployee(Employee employee) {
		dao.addEmployeeDetails(employee);
	}
	
	@Override
	public String findScheme(Employee employee) {
		String scheme = dao.findScheme(employee);
		return scheme;
	}
	
	@Override
	public void displayEmployees() {
		dao.displayEmployees();
		 
	}
	
}
