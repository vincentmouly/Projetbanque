package com.adaming.myapp.dao;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.*;

public interface IBanqueDao extends IGenDao<Banque>{

	
	Set<Client> getClients(Long idB);
	
	List<Groupe> getGroupes(Banque b);
	
	List<Compte> getComptes(Banque b);
	
	List<Employe> getEmployes(Banque b);
}
