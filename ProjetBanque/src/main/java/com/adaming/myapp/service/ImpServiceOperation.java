/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;
import com.adaming.myapp.dao.IOperationDao;
import com.adaming.myapp.entities.*;

@Transactional
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
	public Operations add(Operations o1) throws Exception{
		List<Operations> ops = getAll();
		for(Operations o:ops){
			if(o1.getDate().equals(o.getDate()) && o1.getMontant() == o.getMontant()){
				throw new Exception("L'opération du "+o1.getDate()+" d'unmontant de "+o1.getMontant()+" existe déja!");
			}
		}
		dao.add(o1);
		return o1;
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

	@Override
	public Operations Versement(Long idCompte, double montant, Long idEmploye) {
		Compte c = dao.GetCompte(idCompte);
		Operations op = new Versement(new Date(), montant);		
		return dao.addOperationSimple(op, idCompte, idEmploye);
	}

	@Override
	public Operations Retrait(Long idCompte, double montant, Long idEmploye) throws Exception {
		
		Compte c = dao.GetCompte(idCompte);
		
		if (c.getSolde() < montant) {
			throw new Exception("Retrait trop important");
		}
		
		Operations op = new Retrait(new Date(), montant);		
		return dao.addOperationSimple(op, idCompte, idEmploye);
	}
	
	@Override
	public Compte GetCompte(Long idCompte) {
		
		return dao.GetCompte(idCompte);
	}

	@Override
	public Operations Virement(Long idCompte, Long idCompte2,  double montant, Long idEmploye) throws Exception {

		Retrait(idCompte, montant, idEmploye);
		
		Operations op = Versement(idCompte2, montant, idEmploye);
		
		return op;

	}
}
