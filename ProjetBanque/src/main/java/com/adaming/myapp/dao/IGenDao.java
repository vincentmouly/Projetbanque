package com.adaming.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenDao<T extends Serializable> {
	
	T add( final T entity);
	
	T get( final long id);
	
	T remove( final long id);
	
	T update( final T entity);

	List<T> getAll();
}
