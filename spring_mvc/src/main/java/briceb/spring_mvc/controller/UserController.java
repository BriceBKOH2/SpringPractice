package briceb.spring_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import briceb.spring_mvc.domain.User;
import briceb.spring_mvc.exception.BadRequestException;
import briceb.spring_mvc.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) throws BadRequestException {
		return userService.save(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable Long id) {
		return userService.find(id);
	}
	
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public User findOneByLogin(@PathVariable String login) {
		return userService.findOneByLogin(login);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> search(@RequestParam(required = false) String login,
			@RequestParam(required = false) String name) {
		return userService.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public User update(@PathVariable Long id, 
			@RequestBody User user) {
		user.setId(id);
		return userService.update(user);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public User delete(@PathVariable Long id) {
		return userService.delete(id);
	}

}
