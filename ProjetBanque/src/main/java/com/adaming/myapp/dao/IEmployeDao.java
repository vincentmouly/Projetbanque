package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Client;

public interface IEmployeDao extends IGenDao<Employe>{
	
	List<Client> getClientByMc(String mc);

}
