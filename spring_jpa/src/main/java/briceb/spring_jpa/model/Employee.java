package briceb.spring_jpa.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String firstname;
	
	@Column
	private Timestamp timestamp;

	@Column
	private String lastname;

	@Column
	private Integer salary;
	
	@Column(unique=true)
	private String ssn;
	
//	@ManyToOne
//	private Company company;

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

//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", timestamp=" + timestamp + ", lastname=" + lastname
				+ ", salary=" + salary + ", ssn=" + ssn + "]";
	}
	
	
}
