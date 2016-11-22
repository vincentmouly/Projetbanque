package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.Query;

import com.adaming.myapp.entities.Client;

public class ImpDaoClient extends AbstractJpa<Client> implements IClientDao{

	@Override
	public Client add(Client entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Client get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Client remove(long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Client update(Client entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getClientByMc(String mc) {
		Query query = em.createQuery("from Client c where c.nom like :x");
		query.setParameter("x","%"+mc+"%");
		return query.getResultList();
	}
}