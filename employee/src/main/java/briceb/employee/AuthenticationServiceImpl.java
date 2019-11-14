package briceb.employee;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	private UserService userService;

	public boolean authenticate(String login, String password) {
		return password.equals(userService.getPassword(login));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
