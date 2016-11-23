/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Groupe;

public interface IServiceGroupe extends IGeneriqueService<Groupe>{
	
	List<Groupe> getGroupeByMc(String mc);
	
	Groupe addGroupe(String nom, Long idBanque);

}
