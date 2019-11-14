package briceb.spring_jdbc.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.*;

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

	public void update(Employee employee) {
		this.jdbcTemplate.update("update employee set firstname=?, hiredate=?, lastname=?, salary=?, ssn=? where id=?",
				employee.getFirstname(), employee.getTimestamp(), employee.getLastname(), employee.getSalary(),
				employee.getSsn(), employee.getId());
	}

	public List<Employee> findAll() {
		return this.jdbcTemplate.query("select * from employee", new EmployeeMapper());
	}

	public List<Employee> findBySsn(String ssn) {
		return this.jdbcTemplate.query("select * from employee where ssn=?", new Object[] { ssn },
				new EmployeeMapper());
	}

}
