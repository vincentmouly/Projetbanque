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

import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

@Transactional
public class ImpServiceClient implements IClientService{
	
	//=========================
	// Attributes
	//=========================
	
	private IClientDao dao;
	@SuppressWarnings("unused")
	private final Logger LOGGER = Logger.getLogger("ImpServiceClient");
	
	//=========================
	// Setter
	//=========================
	
	public void setDao(IClientDao dao) {
		this.dao = dao;
	}
	
	//=========================
	// Methods
	//=========================
	
	
	@Override
	public Client add(Client c) throws Exception{
		List<Client> clients = getAll();
		for(Client c1:clients){
			if(c1.getNom().equals(c.getNom()) && c1.getPrenom().equals(c.getPrenom()) && c1.getDate_naisssance().equals(c.getDate_naisssance())){
				throw new Exception("le client : "+c.getNom()+" "+c.getPrenom()+" existe déja!!");
			}
		}
		dao.add(c);
		return c;
	}

	@Override
	public Client get(long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public Client remove(long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Client update(Client entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Compte> getComptes(Client c) {
		// TODO Auto-generated method stub
		return c.getComptes();
	}

	@Override
	public List<Client> getClientByMc(String mc) {
		// TODO Auto-generated method stub
		return dao.getClientByMc(mc);
	}

	@Override
	public List<Banque> getBanque(Client c) {
		// TODO Auto-generated method stub
		return c.getBanques();
	}
	@Override
	public Client addClient(String nom, String prenom, Date dateDeNaissance,
			String adresse, Long IdBanque) {

		return dao.addClient(new Client(nom, prenom, dateDeNaissance, adresse), IdBanque);
	}
}
