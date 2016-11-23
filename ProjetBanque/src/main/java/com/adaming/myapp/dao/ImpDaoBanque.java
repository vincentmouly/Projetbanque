package com.adaming.myapp.dao;

import java.util.List;
import com.adaming.myapp.entities.*;

public class ImpDaoBanque extends AbstractJpa<Banque> implements IBanqueDao{

	@Override
	public Banque add(Banque entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Banque get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Banque remove(long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Banque update(Banque entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Banque> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}

	@Override
	public List<Client> getClients(Banque b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groupe> getGroupes(Banque b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> getComptes(Banque b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employe> getEmployes(Banque b) {
		// TODO Auto-generated method stub
		return null;
	}

}
