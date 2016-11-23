package com.adaming.myapp.dao;

import java.util.List;
import com.adaming.myapp.entities.Employe;

public interface IEmployeDao extends IGenDao<Employe>{
	
	List<Employe> getEmployeByMc(String mc);
	
	Employe addEmploye( Employe e, Long idBanque);
	
	Employe addEmployeToGroupe(Long Ide, Long Idgroupe);

}
