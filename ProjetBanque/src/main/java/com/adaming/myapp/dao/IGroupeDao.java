package com.adaming.myapp.dao;

import java.util.List;

public interface IGroupeDao extends IGenDao<Groupe>{

	List<Groupe> getByMc(String mc);
}
