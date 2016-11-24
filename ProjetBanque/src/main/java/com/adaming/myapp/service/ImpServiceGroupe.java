/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IGroupeDao;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.ExceptionGroupe;

@Transactional
public class ImpServiceGroupe implements IServiceGroupe {
	
	//=========================
	// Attributes
	//=========================
	
	private IGroupeDao dao;
	@SuppressWarnings("unused")
	private final Logger LOGGER = Logger.getLogger("ImpServiceGroupe");

	//=========================
	// Setter
	//=========================
	
	public void setDao(IGroupeDao dao) {
		this.dao = dao;
	}

	//=========================
	// Methods
	//=========================
	
	@Override
	public Groupe add(Groupe groupe)throws ExceptionGroupe {
		List<Groupe> groupes = getAll();
		for (Groupe g:groupes){
			if (groupe.getNom()==g.getNom()){
				throw new ExceptionGroupe("le groupe " + groupe.getNom() + "existe deja ");
			}
		}
		dao.add(groupe);
		return groupe;
	}

	@Override
	public Groupe get(long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public Groupe remove(long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Groupe update(Groupe groupe) {
		// TODO Auto-generated method stub
		return dao.update(groupe);
	}

	@Override
	public List<Groupe> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Groupe> getGroupeByMc(String mc) {
		// TODO Auto-generated method stub
		return dao.getGroupeByMc(mc);
	}

	@Override
	public Groupe addGroupe(String nom, Long idBanque) {
		// TODO Auto-generated method stub
		return dao.addGroupe(new Groupe(nom), idBanque);
	}
}
