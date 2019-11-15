package briceb.spring_jdbc.dao;

import java.util.*;

import briceb.spring_jdbc.exception.EmployeeNotFoundException;
import briceb.spring_jdbc.model.Employee;

public interface EmployeeRepository {
	public void save(Employee employee);
	
	public void update(Employee employee) throws EmployeeNotFoundException;
	
	public void deleteAll();
	
	public void delete(Employee employee) throws EmployeeNotFoundException;
	
	public List<Employee> findAll();
	
	public List<Employee> findBySsn(String ssn) throws EmployeeNotFoundException;
	
}
