/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Employe;

public interface IServiceEmploye extends IGeneriqueService<Employe> {
	
	List<Employe> getEmployeByMc(String mc);
	
	Employe addEmploye(String nom, Long idBanque);

}
