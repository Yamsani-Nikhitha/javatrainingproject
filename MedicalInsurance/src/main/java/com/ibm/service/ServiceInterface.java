package com.ibm.service;

import java.util.Set;

import com.ibm.eis.bean.Employee;

public interface ServiceInterface {
	 void addEmployee(Employee employee);
	 String findScheme(Employee employee);
	 void displayEmployees();
}
