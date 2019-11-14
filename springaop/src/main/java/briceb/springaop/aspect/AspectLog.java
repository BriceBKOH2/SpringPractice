package briceb.springaop.aspect;	

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLog {
	
	@After("execution(* get*(..))")
	public void logAfterGet(JoinPoint joinPoint) {
		System.out.println("Getter method used : " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* *(..))")
	public void logBeforeMethod(JoinPoint joinPoint) {
		System.out.println("\nMethod used : " + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution(* briceb.springaop.utils.dummy.DummyService.saveDummy(..))", throwing = "ex")
	public void logAfterThrowingSaveDummy(DataAccessException ex) {
		System.out.println("Exception thrown by saveDummy" + ex.getMessage());
	}
	
	@Around("execution(* briceb.springaop.utils.dummy.DummyService.saveDummy(..))")
	public void logAroundExecutionTimeSaveDummy(ProceedingJoinPoint procJoinPoint) throws Throwable {
		long result = System.nanoTime();
		procJoinPoint.proceed();
		System.out.println(System.nanoTime() - result); 
	}
}
