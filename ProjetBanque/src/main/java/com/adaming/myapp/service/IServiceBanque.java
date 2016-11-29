/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.ExceptionBanque;



public interface IServiceBanque extends IGeneriqueService<Banque> {
	

	Banque addBanque (String NomAgence, String Adresse, String CodePostale) throws ExceptionBanque;
	
	Set<Client> getClients(Long idB);
	
	List<Groupe> getGroupes(Banque b);
	
	List<Compte> getComptes(Banque b);
	
	List<Employe> getEmployes(Banque b);
}
