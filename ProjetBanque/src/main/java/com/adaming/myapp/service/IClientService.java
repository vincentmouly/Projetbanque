/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IClientService extends IGeneriqueService<Client>{

	List<Compte> getComptes(Client c);
	
	List<Client> getClientByMc(String mc);
	
	List<Banque> getBanque(Client c);
}
