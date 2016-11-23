package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.dao.AbstractJpa;
import com.adaming.myapp.entities.*;

public class ImpServiceCompte extends AbstractJpa<Compte> implements ICompteService{

	@Override
	public Compte add(Compte entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Compte get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Compte remove(long id) {
		// TODO Auto-generated method stub
		return remove(id);
	}

	@Override
	public Compte update(Compte entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Compte> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public Employe getEmploye(Compte c) {
		// TODO Auto-generated method stub
		return c.getEmploye();
	}

	@Override
	public Client getClient(Compte c) {
		// TODO Auto-generated method stub
		return c.getClient();
	}

	@Override
	public List<Operations> getOperations(Compte c) {
		// TODO Auto-generated method stub
		return c.getOperations();
	}

	@Override
	public Banque getBanque(Compte c) {
		// TODO Auto-generated method stub
		return c.getBanque();
	}

}
