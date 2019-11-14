package briceb.employee;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

	String getPassword(String login);
}
