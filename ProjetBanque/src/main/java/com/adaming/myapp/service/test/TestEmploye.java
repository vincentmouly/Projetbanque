package com.adaming.myapp.service.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.service.IServiceEmploye;

public class TestEmploye {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Logger LOGGER = Logger.getLogger("EmployeServiceTestU");
		 ClassPathXmlApplicationContext context;
		 IServiceEmploye serviceEmploye;
		
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceEmploye = (IServiceEmploye) context.getBean("ImpServiceEmploye");

		/*Employe e = serviceEmploye.get(1L);
		assertTrue(e!=null);
		*/
		
		
		List<Employe> employes = serviceEmploye.getAll();
		int s1 = employes.size();
		serviceEmploye.remove(1L);
		int s2 = employes.size();
		assert(s1-s2==1);
		
		
		/*Employe e = new Employe("Goutin");
		try {
			serviceEmploye.add(e);
			assertNotNull(e.getIde());
		} catch (Exception e2) {
			LOGGER.warning(e2.getMessage());
	}*/
		
	}
}