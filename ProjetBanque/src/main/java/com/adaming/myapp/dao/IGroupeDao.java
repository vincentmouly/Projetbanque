package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Groupe;

public interface IGroupeDao extends IGenDao<Groupe>{

	List<Groupe> getGroupeByMc(String mc);
	
	Groupe addGroupe(Groupe g, Long idBanque);
}
