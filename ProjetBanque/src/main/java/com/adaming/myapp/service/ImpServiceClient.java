package com.adaming.myapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.adaming.myapp.dao.AbstractJpa;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class ImpServiceClient extends AbstractJpa<Client> implements IClientService{
	EntityManager em;
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
	public List<Compte> getComptes(Client c) {
		// TODO Auto-generated method stub
		return c.getComptes();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getClientByMc(String mc) {
		Query query = em.createQuery("from Client c where c.nom like :x");
		query.setParameter("x","%"+mc+"%");
		return query.getResultList();
	}

	@Override
	public List<Banque> getBanque(Client c) {
		// TODO Auto-generated method stub
		return c.getBanques();
	}
}
