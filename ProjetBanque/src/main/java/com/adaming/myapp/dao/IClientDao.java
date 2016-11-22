package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IClientDao extends IGenDao<Client>{

	List<Client> getClientByMc(String mc);
	
}
