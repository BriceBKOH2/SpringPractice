package briceb.spring_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import briceb.spring_mvc.domain.User;
import briceb.spring_mvc.exception.BadRequestException;
import briceb.spring_mvc.repository.UserJpaRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserJpaRepository userRepository;	
	
	public User find(Long id) {
		return userRepository.find(id);
	}
	
	public User findOneByLogin(String login) {
		return userRepository.findOneByLogin(login);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional(readOnly = false)
	public User save(User user) throws BadRequestException {
		try {
			return userRepository.save(user);
		} catch (InvalidDataAccessApiUsageException e) {
			throw new BadRequestException("User cannot be created with an id.", e);
		}
	}
	
	public User update(User user) {
		return userRepository.update(user);
	}
	
	public User delete(Long id) {
		return userRepository.delete(id);
	}
	
	public List<User> deleteAll() {
		return userRepository.deleteAll();
	}
	
	public void drop() {
		userRepository.drop();
	}
}
