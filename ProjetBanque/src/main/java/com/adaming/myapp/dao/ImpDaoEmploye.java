package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.Query;

import com.adaming.myapp.entities.Client;

public class ImpDaoEmploye extends AbstractJpa<Employe> implements IEmployeDao{

	@Override
	public Employe add(Employe entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Employe get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Employe remove(long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Employe update(Employe entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Employe> getAll() {
		// TODO Auto-generated method stub
		return getAbstractJpa();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getClientByMc(String mc) {
		Query query = em.createQuery("from Employe e where e.nom like :x");
		query.setParameter("x","%"+mc+"%");
		return query.getResultList();
	}

}
