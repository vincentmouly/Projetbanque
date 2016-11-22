package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;

public interface IEmployeDao extends IGenDao<Employe>{
	
	List<Client> getClientByMc(String mc);

}
