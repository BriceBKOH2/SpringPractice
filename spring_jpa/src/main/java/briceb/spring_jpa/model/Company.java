//package briceb.spring_jpa.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.*;
//
//@Entity
//public class Company {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	
//	@Column
//	private String name;
//	
//	@Column
//	private Long netWorse;
//
////	@OneToMany(mappedBy="employee")
////	private List<Employee> employees;
//	
//	/* Constructor */
//	
//	public Company() {
//		
//	}
//	
//	public Company(String name) {
//		super();
//		this.name = name;
//		this.netWorse = 0L;
//		this.employees = new ArrayList<Employee>();
//	}
//	
//	public Company(String name,Long netWorse) {
//		super();
//		this.name = name;
//		this.netWorse = netWorse;
//		this.employees = new ArrayList<Employee>();
//	}
//
//	public Company(String name, Long netWorse, List<Employee> employees) {
//		super();
//		this.name = name;
//		this.netWorse = netWorse;
//		this.employees = employees;
//	}
//
//	/* Getters and Setters */
//	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Long getNetWorse() {
//		return netWorse;
//	}
//
//	public void setNetWorse(Long netWorse) {
//		this.netWorse = netWorse;
//	}
//
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}
//	
//	/* Methods */
//	
//	public void addEmployee(Employee... employees) {
//		for (Employee employee : employees) {
//			this.employees.add(employee);
//		}
//	}
//	
//	public void addEmployee(List<Employee> employees) {
//		for (Employee employee : employees) {
//			this.employees.add(employee);
//		}
//	}
//}
