package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class ImpDaoCompte extends AbstractJpa<Compte> implements ICompteDao{

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
		return removeAbstractJpa(id);
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
	public Compte addCompte(Compte c, Long Idclient, Long Idbanque) {
		Banque b = em.find(Banque.class, Idbanque);
		Client client = em.find(Client.class, Idclient);
		c.setBanque(b);
		c.setClient(client);
		em.persist(c);
		return c;
	}
}
