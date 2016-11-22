package com.adaming.myapp.dao;

import java.util.List;

public class ImpDaoOperation extends AbstractJpa<Operation> implements IOperationDao{

	@Override
	public Operation add(Operation entity) {
		// TODO Auto-generated method stub
		return addAbstractJpa(entity);
	}

	@Override
	public Operation get(long id) {
		// TODO Auto-generated method stub
		return getAbstractJpa(id);
	}

	@Override
	public Operation remove(long id) {
		// TODO Auto-generated method stub
		return removeAbstractJpa(id);
	}

	@Override
	public Operation update(Operation entity) {
		// TODO Auto-generated method stub
		return updateAbstractJpa(entity);
	}

	@Override
	public List<Operation> getAll() {
		// TODO Auto-generated method stub
		return getAllAbstractJpa();
	}
}
