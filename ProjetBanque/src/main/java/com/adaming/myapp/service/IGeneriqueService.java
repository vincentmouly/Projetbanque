/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.io.Serializable;
import java.util.List;

public interface IGeneriqueService<T extends Serializable> {
	
	T add( final T entity) throws Exception;
	
	T get( final long id);
	
	T remove( final long id);
	
	T update( final T entity);

	List<T> getAll();

}
