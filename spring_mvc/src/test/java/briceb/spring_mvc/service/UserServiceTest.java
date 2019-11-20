package briceb.spring_mvc.service;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import briceb.spring_mvc.App;
import briceb.spring_mvc.domain.User;
import briceb.spring_mvc.exception.BadRequestException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { App.class })
@Transactional
public class UserServiceTest {
    
    @Autowired
    private UserService userService;

	@Test
	public void saveTest() throws BadRequestException {
		User user = new User("brice", "userBrice", "passBrice");
		user = userService.save(user);
		assertNotNull("Id should be set after save.", user.getId());
	}
	
	@Test(expected = BadRequestException.class)
	public void saveExistingTest() throws BadRequestException {
		User user = new User("brice", "userBrice", "passBrice");
		user.setId(1L);
		user = userService.save(user);
	}
}

