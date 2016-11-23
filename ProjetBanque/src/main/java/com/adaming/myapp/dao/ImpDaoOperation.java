package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operations;

public class ImpDaoOperation extends AbstractJpa<Operations> implements IOperationDao{

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
	public Operations addOperationSimple(Operations op, Long idCompte, Long idEmploye) {

		Compte c = em. find(Compte.class, idCompte);
		Employe e = em.find(Employe.class, idEmploye);
		
		op.getComptes().add(c);
		op.setEmploye(e);
		
		c.setSolde(c.getSolde() + op.getMontant());
		c.getOperations().add(op);
		
		e.getOperations().add(op);
		
		em.persist(op);

		return null;
	}

	@Override
	public Compte GetCompte(Long idCompte) {
		Compte c = em.find(Compte.class, idCompte);
		return c ;
	}

	
}
