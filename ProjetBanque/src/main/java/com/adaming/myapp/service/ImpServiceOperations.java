package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.dao.AbstractJpa;
import com.adaming.myapp.entities.*;

public class ImpServiceOperations extends AbstractJpa<Operations> implements IOperationService{

	@Override
	public Operations add(Operations entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Operations get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Operations remove(long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Operations update(Operations entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Operations> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public List<Compte> getComptes(Operations o) {
		// TODO Auto-generated method stub
		return o.getComptes();
	}

	@Override
	public Employe getEmploye(Operations o) {
		// TODO Auto-generated method stub
		return o.getEmploye();
	}

}
