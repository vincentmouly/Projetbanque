package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IBanqueDao extends IGenDao<Banque>{

	
	List<Client> getClients(Banque b);
	
	List<Groupe> getGroupes(Banque b);
	
	List<Compte> getComptes(Banque b);
	
	List<Employe> getEmployes(Banque b);
}
