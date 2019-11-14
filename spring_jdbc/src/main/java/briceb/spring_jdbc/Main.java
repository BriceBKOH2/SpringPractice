package briceb.spring_jdbc;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import briceb.spring_jdbc.database.Employee;
import briceb.spring_jdbc.database.EmployeeJdbcRepository;

public class Main 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        System.out.println("Context loaded!");
        
        EmployeeJdbcRepository empJdbcRep = context.getBean(EmployeeJdbcRepository.class);
        
        Employee employee1 = new Employee("Test",new Timestamp(new Date().getTime()) , "Test", 1, "01020304Bonjour");
        Employee employee2 = new Employee("jean",new Timestamp(new Date().getTime()) , "coco", 10, "01020304Bonjour");
        Employee employee3 = new Employee("brice",new Timestamp(new Date().getTime()) , "beteille", 40000, "57");
//        System.out.println("\nsave method");
//        empJdbcRep.save(employee1);
//        empJdbcRep.save(employee2);        
//        empJdbcRep.save(employee3);
        System.out.println(employee3);
        
        System.out.println("\nupdate method");
        employee3.setId(7L);
        employee3.setSalary(employee3.getSalary()+3210);
        empJdbcRep.update(employee3);
        System.out.println(employee3);
        
        System.out.println("\nFindAll method");
        List<Employee> employees = new ArrayList<Employee>();
        employees = empJdbcRep.findAll();
        
        for (Employee employee : employees) {
			System.out.println(employee);
		}
        
        System.out.println("\nFindBySsn method");
        employees = empJdbcRep.findBySsn(employee3.getSsn());
        
        for (Employee employee : employees) {
			System.out.println(employee);
		}
        
    }
}
