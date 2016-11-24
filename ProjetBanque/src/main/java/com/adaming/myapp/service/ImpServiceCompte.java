/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.ICompteDao;
import com.adaming.myapp.entities.*;

@Transactional
public class ImpServiceCompte implements ICompteService{
	
	//=========================
	// Attributes
	//=========================
		
		private ICompteDao dao;
		@SuppressWarnings("unused")
		private final Logger LOGGER = Logger.getLogger("ImpServiceCompte");
		
	//=========================
	// Setter
	//=========================
	
		public void setDao(ICompteDao dao) {
			this.dao = dao;
		}
		
	//=========================
	// Methods
	//=========================
		
	@Override
	public Compte add(Compte entity) {
		// TODO Auto-generated method stub
		return dao.add(entity);
	}

	@Override
	public Compte get(long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public Compte remove(long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Compte update(Compte entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Compte> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
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

	@Override
	public Compte addCompteCourant(Long Idclient, Long idbanque) {
		// TODO Auto-generated method stub
		return dao.addCompte(new CompteCourant(100, new Date(), -100), Idclient, idbanque);
	}

	@Override
	public Compte addCompteEpargne(Long Idclient, Long idbanque) {
		// TODO Auto-generated method stub
		return dao.addCompte(new CompteEpargne(100, new Date(), 0.03), Idclient, idbanque);
	}
}
