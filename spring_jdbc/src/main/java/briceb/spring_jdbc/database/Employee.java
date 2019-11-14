package briceb.spring_jdbc.database;

import java.sql.Timestamp;

public class Employee {
	private Long id;
	private String firstname;
	private Timestamp timestamp;
	private String lastname;
	private Integer salary;
	private String ssn;

	/* Constructor */
	public Employee() {
		
	}

	public Employee(Long id, String firstname, Timestamp timestamp, String lastname, Integer salary, String ssn) {
		this.id = id;
		this.firstname = firstname;
		this.timestamp = timestamp;
		this.lastname = lastname;
		this.salary = salary;
		this.ssn = ssn;
	}

	public Employee(String firstname, Timestamp timestamp, String lastname, Integer salary, String ssn) {
		this.firstname = firstname;
		this.timestamp = timestamp;
		this.lastname = lastname;
		this.salary = salary;
		this.ssn = ssn;
	}

	/* Getters and Setters */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", timestamp=" + timestamp + ", lastname=" + lastname
				+ ", salary=" + salary + ", ssn=" + ssn + "]";
	}
	
	
}
