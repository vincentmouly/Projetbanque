/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface ICompteService extends IGeneriqueService<Compte>{

	Employe getEmploye(Compte c);
	
	Client getClient(Compte c);
	
	List<Operations> getOperations(Compte c);
	
	Banque getBanque(Compte c);
	
	Compte addCompteCourant(Long Idclient, Long idbanque);
	
	Compte addCompteEpargne(Long Idclient, Long idbanque);
	
}
