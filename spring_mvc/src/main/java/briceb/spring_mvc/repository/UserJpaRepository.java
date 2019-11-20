package briceb.spring_mvc.repository;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import briceb.spring_mvc.domain.User;

@Repository
@Transactional
public class UserJpaRepository extends AbstractJpaRepository<User> {

	public UserJpaRepository() {
		super(User.class);
	}
	
	public User findOneByLogin(String login) {
		String qlString = "from User u where u.login = :login";
		TypedQuery<User> query = entityManager.createQuery(qlString, User.class);
		query.setParameter("login", login);
		
		return query.getSingleResult();
	}
}
