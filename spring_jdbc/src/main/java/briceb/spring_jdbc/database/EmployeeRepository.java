package briceb.spring_jdbc.database;

import java.util.*;

public interface EmployeeRepository {
	public void save(Employee employee);
	
	public void update(Employee employee);
	
	public List<Employee> findAll();
	
	public List<Employee> findBySsn(String ssn);

}
