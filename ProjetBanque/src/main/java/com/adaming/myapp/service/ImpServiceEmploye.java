/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import com.adaming.myapp.dao.IEmployeDao;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.ExceptionEmploye;

public class ImpServiceEmploye implements IServiceEmploye{
	
	//=========================
	// Attributes
	//=========================
	
	private IEmployeDao dao;
	@SuppressWarnings("unused")
	private final Logger LOGGER = Logger.getLogger("ImpServiceEmploye");
	
	//=========================
	// Setter
	//=========================
	
	public void setDao(IEmployeDao dao) {
		this.dao = dao;
	}
	
	//=========================
	// Methods
	//=========================
	
	@Override
	public Employe add(Employe employe)throws Exception {
		List<Employe> employes = getAll();
		for (Employe e:employes){
			if(employe.getNom()==e.getNom()){
				throw new ExceptionEmploye("L'employe " +employe.getNom() + "existe deja");
			}
		}
		dao.add(employe);
		return employe;
	}

	@Override
	public Employe get(long id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public Employe remove(long id) {
		// TODO Auto-generated method stub
		return dao.remove(id);
	}

	@Override
	public Employe update(Employe employe) {
		// TODO Auto-generated method stub
		return update(employe);
	}

	@Override
	public List<Employe> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public List<Employe> getEmployeByMc(String mc) {
		// TODO Auto-generated method stub
		return dao.getEmployeByMc(mc);
	}

	@Override
	public Employe addEmploye(String nom, Long idBanque) {
		// TODO Auto-generated method stub
		return dao.addEmploye(new Employe(nom), idBanque);
	}
}
