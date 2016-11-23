/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;
import com.adaming.myapp.dao.IOperationDao;
import com.adaming.myapp.entities.*;

public class ImpServiceOperation  implements IOperationService{

	//=========================
	// Attributes
	//=========================
		
		private IOperationDao dao;
		@SuppressWarnings("unused")
		private final Logger LOGGER = Logger.getLogger("ImpServiceOperation");
		
	//=========================
	// Setter
	//=========================
		
		public void setDao(IOperationDao dao) {
			this.dao = dao;
		}

	//=========================
	// Methods
	//=========================
		
	@Override
	public Operations add(Operations entity) {
		// TODO Auto-generated method stub
		return dao.add(entity);
	}

	
	@Override
	public Operations get(long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public Operations remove(long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Operations update(Operations entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Operations> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Compte> getComptes(Operations o) {
		// TODO Auto-generated method stub
		return o.getComptes();
	}

	@Override
	public Employe getEmploye(Operations o) {
		// TODO Auto-generated method stub
		return o.getEmploye();
	}
}
