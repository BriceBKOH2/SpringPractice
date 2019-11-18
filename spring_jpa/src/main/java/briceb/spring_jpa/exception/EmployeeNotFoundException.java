package briceb.spring_jpa.exception;

public class EmployeeNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9020672490281873020L;

	public EmployeeNotFoundException(Long id) {
		System.err.println("Employee id : " + id + " not found in database");
	}
	
	public EmployeeNotFoundException(String ssn) {
		System.err.println("Employee ssn : " + ssn + " not found in database");
	}

}
