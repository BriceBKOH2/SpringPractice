package briceb.spring_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import briceb.spring_mvc.domain.IdEntity;

@Repository
@Transactional
public abstract class AbstractJpaRepository<T extends IdEntity> {

	@PersistenceContext
	protected EntityManager entityManager;
	
	private Class<T> type;
	
	protected AbstractJpaRepository(Class<T> type) {
		this.type = type;
	}
	
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	public T update(T entity) {
		return entityManager.merge(entity);
	}
	
	public T find(Long id) {
		return entityManager.find(type, id);
	}
	
	public List<T> findAll() {
		return entityManager.createQuery("FROM " + type.getSimpleName(), type).getResultList();
	}
	
	public T delete(Long id) {
		T entity = find(id);
		
		if (entity != null) {
			entityManager.remove(entity);
		}
		
		return entity;
	}
	
	public List<T> deleteAll() {
		return entityManager.createQuery("DELETE FROM " + type.getSimpleName(), type).getResultList();
	}
	
	public void drop() {
		entityManager.createQuery("DROP " + type.getSimpleName(), type);
	}
	
}
