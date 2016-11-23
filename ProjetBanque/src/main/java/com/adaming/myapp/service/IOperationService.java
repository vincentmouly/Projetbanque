/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IOperationService extends IGeneriqueService<Operations>{

	List<Compte> getComptes(Operations o);
	
	Employe getEmploye(Operations o);
}
