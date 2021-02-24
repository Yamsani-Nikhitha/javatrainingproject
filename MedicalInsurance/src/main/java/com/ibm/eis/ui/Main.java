package com.ibm.eis.ui;

import java.util.Scanner;

import com.ibm.eis.bean.Employee;
import com.ibm.service.ServiceClass;
import com.ibm.service.ServiceInterface;

public class Main {
	public static void main(String args[]) {
		
		ServiceInterface service =  new ServiceClass();
		while (true) {

			System.out.println("1 Get Employee Details");
			System.out.println("2 Find the Insurance Scheme");
			System.out.println("3 Display Employee Details");
			System.out.println("Enter the number");
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();

			switch (n) {
			case 1:
				Employee emp = new Employee();
				System.out.println("Enter Id : ");
				int id = scan.nextInt();
				scan.nextLine();
				emp.setId(id);
				System.out.println("Enter name ");
				String name = scan.nextLine();
				emp.setName(name);
				System.out.println("Enter salary");
				Double salary = scan.nextDouble();
				emp.setSalary(salary);
				scan.nextLine();
				System.out.println("Enter designation of an employee ");
				String designation = scan.nextLine();
				
				emp.setDesignation(designation);
				String scheme = service.findScheme(emp);
				//System.out.println(scheme);
				emp.setScheme(scheme);
				service.addEmployee(emp);

				break;
			case 2: emp = new Employee();
					System.out.println("enter salary ");
					 salary=scan.nextDouble();
					 scan.nextLine();
					 emp.setSalary(salary);
					 System.out.println("Enter designation");
					 designation = scan.nextLine();
					 emp.setDesignation(designation);
					  scheme = service.findScheme(emp);
					 System.out.println(scheme);
				break;
			case 3:
				service.displayEmployees();
					
					
				break;
			default:
				System.exit(0);
			}
		}

	}
}
