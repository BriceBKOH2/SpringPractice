package briceb.employee;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public String getPassword(String login) {
		switch(login) {
		case "nom" :
			return "123";
		case "test" :
			return "test";
		default :
			return null;
		}
	}

}
