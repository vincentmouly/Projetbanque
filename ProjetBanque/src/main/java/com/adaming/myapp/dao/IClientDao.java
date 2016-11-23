package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IClientDao extends IGenDao<Client>{

	List<Compte> getComptes(Client c);
	
	List<Client> getClientByMc(String mc);
	
	List<Banque> getBanque(Client c);
	
	Client addClient(Client c, Long IdBanque);
	
}
