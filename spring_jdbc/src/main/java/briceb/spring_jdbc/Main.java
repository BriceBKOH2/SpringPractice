package briceb.spring_jdbc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import briceb.spring_jdbc.dao.EmployeeJdbcRepository;
import briceb.spring_jdbc.exception.EmployeeNotFoundException;
import briceb.spring_jdbc.model.Employee;
import briceb.spring_jdbc.service.EmployeeService;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		System.out.println("Context loaded!");

		EmployeeService empServ = context.getBean(EmployeeService.class);
		
		System.out.println("Reset DataBase");
		empServ.deleteAll();
		
		Employee employee1 = new Employee("Test", new Timestamp(System.currentTimeMillis()), "Test", 1, "01020304Bonjour");
		Employee employee2 = new Employee("jean", new Timestamp(System.currentTimeMillis()), "coco", 10, "01020304Bonjour");
		Employee employee3 = new Employee("brice", new Timestamp(System.currentTimeMillis()), "beteille", 40000, "57");
        System.out.println("\nsave method");
        empServ.save(employee1);
        empServ.save(employee2);        
        empServ.save(employee3);

		List<Employee> employees = new ArrayList<Employee>();
//		System.out.println("\nupdate method");
//		/* Create exception */
//		employee3.setId(1000L);
//		employee3.setSalary(employee3.getSalary() + 3210);
//		try {
//			empServ.update(employee3);
//		} catch (EmployeeNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("\nFindAll method");
//		employees = empServ.findAll();
//
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
//
//		System.out.println("\nFindBySsn method");
//		try {
//			employees = empServ.findBySsn("1");
//		} catch (EmployeeNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		for (Employee employee : employees) {
//			System.out.println(employee);
//		}
		
		employees = empServ.findAll();
        
        employee1.setId(employees.get(0).getId());
        employee2.setId(employees.get(1).getId());
        employee3.setId(employees.get(2).getId());
		
		// Changing object value to test if changes are updated or not on rollbackfor exception
		employee1.setFirstname("CHANGED");
		employee2.setLastname("CHANGED");
		employee3.setSsn("CHANGED");
		
        // Employee not in database
        Employee employeeNotSaved = new Employee("Error", new Timestamp(System.currentTimeMillis()), "superError", 50, "449798798");
        
        employees = new ArrayList<Employee>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employeeNotSaved);
        employees.add(employee3);
        
        try {
			empServ.update(employees);
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        employees = empServ.findAll();
        
        for (Employee employee : employees) {
			System.out.println(employee);
		}
        
		
		

	}
}
