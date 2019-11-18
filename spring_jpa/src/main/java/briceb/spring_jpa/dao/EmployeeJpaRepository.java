package briceb.spring_jpa.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import briceb.spring_jpa.exception.EmployeeNotFoundException;
import briceb.spring_jpa.model.Employee;

@Repository
public class EmployeeJpaRepository extends AbstractJpaRepository implements EmployeeRepository {

	/* Interface EmployeeRepository */

	public void save(Employee employee) {
		persist(employee);
	}

	public void update(Employee employee) throws EmployeeNotFoundException {
		Session session = getSession();
		Long id = employee.getId();
		if (id == null) {
			throw new EmployeeNotFoundException(id);
		} else if (session.find(Employee.class, employee.getId()) == null) {
			throw new EmployeeNotFoundException(id);
		}
		session.merge(employee);
	}

	public void delete(Employee employee) throws EmployeeNotFoundException {
		Session session = getSession();
		Long id = employee.getId();
		if (id == null) {
			throw new EmployeeNotFoundException(id);
		} else if (session.find(Employee.class, employee.getId()) == null) {
			throw new EmployeeNotFoundException(id);
		}
		session.delete(employee);
	}
	
	public void deleteAll() {
		Session session = getSession();
		session.createQuery("DELETE FROM Employee").executeUpdate();
	}
	
	public List<Employee> findAll() {
		Session session = getSession();
		return session.createQuery("FROM Employee", Employee.class).getResultList();
	}

	public Employee findBySsn(String ssn) throws EmployeeNotFoundException{
		Session session = getSession();
		TypedQuery<Employee> query = session.createQuery("FROM Employee emp WHERE emp.ssn=:ssn",Employee.class);
		query.setParameter("ssn", ssn);
		Employee employee;
		try {
			employee = query.getSingleResult();
		} catch (NoResultException  e) {
			throw new EmployeeNotFoundException(ssn);
		}
		return employee;
		
	}

}
