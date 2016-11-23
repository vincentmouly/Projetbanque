package com.adaming.myapp.dao;

import com.adaming.myapp.entities.*;

public interface ICompteDao extends IGenDao<Compte>{
	
	Compte addCompte ( Compte c, Long Idclient, Long Idbanque);

}
