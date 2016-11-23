package com.adaming.myapp.dao;

import java.util.List;
import javax.persistence.Query;
import com.adaming.myapp.entities.Groupe;

import com.adaming.myapp.entities.Groupe;

public class ImpDaoGroupe extends AbstractJpa<Groupe> implements IGroupeDao{

	@Override
	public Groupe add(Groupe entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Groupe get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Groupe remove(long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Groupe update(Groupe entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Groupe> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Groupe> getGroupeByMc(String mc) {
		Query query = em.createQuery("from Groupe g where g.nom like :x");
		query.setParameter("x","%"+mc+"%");
		return query.getResultList();
	}

}
