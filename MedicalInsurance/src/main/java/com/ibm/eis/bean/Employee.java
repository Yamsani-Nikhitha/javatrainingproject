package com.ibm.eis.bean;

public class Employee {
	int id;
	String name;
	String designation;
	double salary;
	String scheme;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	public String getScheme() {
		return scheme;
	}
	public String toString() {
		return "Employee[ name = " +name+ ", salary = " +salary+ " , designation = " +designation+ "]";
	}
}
