package com.adaming.myapp.dao;


import com.adaming.myapp.entities.Operations;



public interface IOperationDao extends IGenDao<Operations>{
	
	Operations addOperationSimple(Operations op, Long idCompte);

}
