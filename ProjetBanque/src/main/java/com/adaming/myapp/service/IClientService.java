package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IClientService extends IGenService<Client>{

	List<Compte> getComptes(Client c);
	
	List<Client> getClientByMc(String mc);
	
	List<Banque> getBanque(Client c);
}
