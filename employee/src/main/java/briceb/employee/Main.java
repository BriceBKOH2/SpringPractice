package briceb.employee;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {	
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println( "Context correctly loaded !" );
        	
        AuthenticationService autServ = (AuthenticationService) context.getBean(AuthenticationService.class);
        System.out.println(autServ.authenticate("nom", "123"));
        System.out.println(autServ.authenticate("test", "123"));
        System.out.println(autServ.authenticate("test", "test"));
        
    }
}
