package briceb.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import briceb.springaop.aspect.AspectLog;
import briceb.springaop.utils.dummy.Dummy;
import briceb.springaop.utils.dummy.DummyAlreadyExistsException;
import briceb.springaop.utils.dummy.DummyService;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        
        DummyService dumServ = context.getBean(DummyService.class);
        
        System.out.println(dumServ.getClass()); // Should not work, its not a method in the package watch by @ComponentScan
        System.out.println(dumServ.getDummy(1L));
        System.out.println(dumServ.getDummies());

        Dummy dumNew = new Dummy(50L, "test");
        Dummy dumOld = dumServ.getDummy(1L);
        try {
			dumServ.saveDummy(dumNew);
		} catch (DummyAlreadyExistsException e) {
			System.err.println("dummy already exist");
		}
        
        try {
			dumServ.saveDummy(dumOld);
		} catch (DummyAlreadyExistsException e) {
			System.err.println("dummy already exist");
		}
   
    }
}
