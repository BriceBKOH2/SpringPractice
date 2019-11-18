package briceb.spring_jpa.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import briceb.spring_jpa.dao.EmployeeJpaRepository;
import briceb.spring_jpa.exception.EmployeeNotFoundException;
import briceb.spring_jpa.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeJpaRepository employeeJpaRep;
	
	/* Methods */
	
	@Transactional
	public void save(Employee employee) {
		employeeJpaRep.save(employee);
	}
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public void update(Employee... employees) throws EmployeeNotFoundException {
		for (Employee employee : employees) {
			employeeJpaRep.update(employee);	
		}
	}
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public void update(List<Employee> employees) throws EmployeeNotFoundException {
		for (Employee employee : employees) {
			employeeJpaRep.update(employee);	
		}
	}
	
	
	@Transactional(rollbackFor = EmployeeNotFoundException.class)
	public void delete(Employee employee) throws EmployeeNotFoundException {
		employeeJpaRep.delete(employee);
	}
	
	@Transactional
	public void deleteAll() {
		employeeJpaRep.deleteAll();
	}
	
	@Transactional
	public List<Employee> findAll() {
		return employeeJpaRep.findAll();
	}
	
	@Transactional(rollbackFor = PersistenceException.class)
	public Employee findBySsn(String ssn) throws EmployeeNotFoundException{
		return employeeJpaRep.findBySsn(ssn);
	}
	
}
