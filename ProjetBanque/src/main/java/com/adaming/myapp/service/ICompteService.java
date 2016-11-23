package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface ICompteService extends IGenService<Compte>{

	Employe getEmploye(Compte c);
	
	Client getClient(Compte c);
	
	List<Operations> getOperations(Compte c);
	
	Banque getBanque(Compte c);
}
