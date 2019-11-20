package briceb.spring_mvc.repository;

//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import briceb.spring_mvc.domain.User;
//import briceb.spring_mvc.exception.BadRequestException;
//import briceb.spring_mvc.service.UserService;
//
//@Component
//public class InitializeDB {
//
//	@Autowired
//	UserService userServ;
//	
//	@PostConstruct
//	public void init() {
//		User user1 = new User("Brice","userBrice","passBrice");
//		try {
//			userServ.save(user1);
//		} catch (BadRequestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		User user2 = new User("Test","userTest","passTest");
//		try {
//			userServ.save(user2);
//		} catch (BadRequestException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
