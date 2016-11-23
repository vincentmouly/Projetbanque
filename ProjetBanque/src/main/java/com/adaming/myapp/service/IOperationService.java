package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IOperationService extends IGenService<Operations>{

	List<Compte> getComptes(Operations o);
	
	Employe getEmploye(Operations o);
}
