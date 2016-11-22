package com.adaming.myapp.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractJpa<T extends Serializable> {
	
	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> clazz;
	
	public T addAbstractJpa(T entity){
		em.persist(entity);
		return entity;
	}
	
	public T getAbstractJpa(long id){
		T t = em.find(clazz, id);
		return t;
	}
	
	public T removeAbstractJpa(long id){
		T t = getAbstractJpa(id);
		em.remove(t);
		return t;
	}
	
	public T updateAbstractJpa(T entity){
		em.merge(entity);
		return entity;
	}
	@SuppressWarnings("unchecked")
	public List<T> getAllAbstractJpa(){
		return em.createQuery("from "+clazz.getName()).getResultList();
	}
}
