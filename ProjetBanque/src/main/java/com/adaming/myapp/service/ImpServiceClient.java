/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
		Set<Client> clients = getAll();
		for(Client c1:clients){
			if(c1.getNom().equals(c.getNom()) && c1.getPrenom().equals(c.getPrenom()) && c1.getDate_naissance().equals(c.getDate_naissance())){
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
	public Set<Client> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Set<Compte> getComptes(Client c) {
		// TODO Auto-generated method stub
		return c.getComptes();
	}

	@Override
	public Set<Client> getClientByMc(String mc) {
		// TODO Auto-generated method stub
		return dao.getClientByMc(mc);
	}

	@Override
	public Set<Banque> getBanque(Client c) {
		// TODO Auto-generated method stub
		return c.getBanques();
	}
	@Override
	public Client addClient(Client c, Long IdBanque) {

		return dao.addClient(new Client(c.getNom(),c.getPrenom(), c.getDate_naissance(), c.getAdresse()), IdBanque);
	}
}
