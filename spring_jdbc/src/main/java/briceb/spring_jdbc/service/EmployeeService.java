package briceb.spring_jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import briceb.spring_jdbc.dao.EmployeeJdbcRepository;
import briceb.spring_jdbc.exception.EmployeeNotFoundException;
import briceb.spring_jdbc.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeJdbcRepository employeeJdbcRep;
	
	/* Methods */
	
	@Transactional
	public void save(Employee employee) {
		employeeJdbcRep.save(employee);
	}
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public void update(Employee... employees) throws EmployeeNotFoundException {
		for (Employee employee : employees) {
			employeeJdbcRep.update(employee);	
		}
	}
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public void update(List<Employee> employees) throws EmployeeNotFoundException {
		for (Employee employee : employees) {
			employeeJdbcRep.update(employee);	
		}
	}
	
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public void delete(Employee employee) throws EmployeeNotFoundException {
		employeeJdbcRep.delete(employee);
	}
	
	@Transactional
	public void deleteAll() {
		employeeJdbcRep.deleteAll();
	}
	
	@Transactional
	public List<Employee> findAll() {
		return employeeJdbcRep.findAll();
	}
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public List<Employee> findBySsn(String ssn) throws EmployeeNotFoundException{
		return employeeJdbcRep.findBySsn(ssn);
	}
	
}
