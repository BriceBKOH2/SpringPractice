package briceb.spring_jpa.dao;

import java.util.*;

import briceb.spring_jpa.exception.EmployeeNotFoundException;
import briceb.spring_jpa.model.Employee;

public interface EmployeeRepository {
	public void save(Employee employee);
	
	public void update(Employee employee) throws EmployeeNotFoundException;
	
	public void deleteAll() throws EmployeeNotFoundException;
	
	public void delete(Employee employee) throws EmployeeNotFoundException;
	
	public List<Employee> findAll();
	
	public Employee findBySsn(String ssn) throws EmployeeNotFoundException;
	
}
