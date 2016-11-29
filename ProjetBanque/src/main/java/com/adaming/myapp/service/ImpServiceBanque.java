/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IBanqueDao;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.ExceptionBanque;

@Transactional
public class ImpServiceBanque implements IServiceBanque {
	
	//=========================
	// Attributes
	//=========================
	
	private IBanqueDao dao;
	@SuppressWarnings("unused")
	private final Logger LOGGER = Logger.getLogger("ImpServiceBanque");
	
	//=========================
	// Setter
	//=========================
	
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}
	
	//=========================
	// Methods
	//=========================
	
	@Override
	public Banque add(Banque b)throws ExceptionBanque {
		Set<Banque> banques = getAll();
		for (Banque b1:banques){
			if(b.getNomAgence()==b1.getNomAgence()){
				throw new ExceptionBanque("la banque " + b.getNomAgence() + "existe déja");
			}
		}
		dao.add(b);
		return b;
	}

	@Override
	public Banque get(long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public Banque remove(long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Banque update(Banque banque) {
		// TODO Auto-generated method stub
		return dao.update(banque);
	}

	@Override
	public Set<Banque> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	
	@Override
	public List<Groupe> getGroupes(Banque b) {
		// TODO Auto-generated method stub
		return dao.getGroupes(b);
	}

	@Override
	public List<Compte> getComptes(Banque b) {
		// TODO Auto-generated method stub
		return dao.getComptes(b);
	}

	@Override
	public List<Employe> getEmployes(Banque b) {
		// TODO Auto-generated method stub
		return dao.getEmployes(b);
	}

	@Override
	public Banque addBanque(String NomAgence, String Adresse, String CodePostale) throws ExceptionBanque {
		Set<Banque> banques = getAll();
		for (Banque b1:banques){
			if(NomAgence == b1.getNomAgence()){
				throw new ExceptionBanque("la banque " + b1.getNomAgence() + "existe déja");
			}
		}
		return dao.add(new Banque(NomAgence, Adresse, CodePostale));
	}

	@Override
	public Set<Client> getClients(Long idB) {
		// TODO Auto-generated method stub
		return dao.getClients(idB);
	}
}
