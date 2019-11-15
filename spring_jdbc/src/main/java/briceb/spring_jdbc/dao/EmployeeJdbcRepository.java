package briceb.spring_jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.*;

import briceb.spring_jdbc.exception.EmployeeNotFoundException;
import briceb.spring_jdbc.model.Employee;

@Repository
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {

	/* Mapper to parse query */

	public final class EmployeeMapper implements RowMapper<Employee> {

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();

			employee.setId(rs.getLong("id"));
			employee.setFirstname(rs.getString("firstname"));
			employee.setTimestamp(rs.getTimestamp("hiredate"));
			employee.setLastname(rs.getString("lastname"));
			employee.setSalary(rs.getInt("salary"));
			employee.setSsn(rs.getString("ssn"));

			return employee;
		}

	}

	/* Interface EmployeeRepository */

	public void save(Employee employee) {
		this.jdbcTemplate.update("insert into employee (firstname,hiredate,lastname,salary,ssn) values (?,?,?,?,?)",
				employee.getFirstname(), employee.getTimestamp(), employee.getLastname(), employee.getSalary(),
				employee.getSsn());

	}

	public void update(Employee employee) throws EmployeeNotFoundException {
		if (this.jdbcTemplate.update("update employee set firstname=?, hiredate=?, lastname=?, salary=?, ssn=? where id=?",
				employee.getFirstname(), employee.getTimestamp(), employee.getLastname(), employee.getSalary(),
				employee.getSsn(), employee.getId()) == 0) {
			throw new EmployeeNotFoundException(employee.getId());
		}
	}

	public void delete(Employee employee) throws EmployeeNotFoundException {
		if (this.jdbcTemplate.update("delete * from employee where id=?", employee.getId()) == 0) {
			throw new EmployeeNotFoundException(employee.getId());
		}
		
	}
	
	public void deleteAll() {
		this.jdbcTemplate.update("delete from employee");
		
	}
	
	public List<Employee> findAll() {
		return this.jdbcTemplate.query("select * from employee", new EmployeeMapper());
	}

	public List<Employee> findBySsn(String ssn) throws EmployeeNotFoundException{
		List<Employee> employees = this.jdbcTemplate.query("select * from employee where ssn=?", new Object[] { ssn },
				new EmployeeMapper());
		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException(ssn);
		}
		return employees;
	}

}
