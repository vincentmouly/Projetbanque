/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.*;
import com.adaming.myapp.exception.ExceptionClient;

public interface IClientService extends IGeneriqueService<Client>{

	Set<Compte> getComptes(Client c);
	
	Set<Client> getClientByMc(String mc);
	
	Set<Banque> getBanque(Client c);
	
	Client addClient(Client c, Long IdBanque) throws ExceptionClient;
}
