/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.service.test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.logging.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.service.IServiceEmploye;

public class EmployeServiceTestU {
	
	//=========================
	// Attributes
	//=========================
		
		private final Logger LOGGER = Logger.getLogger("BanqueServiceTestU");
		private static ClassPathXmlApplicationContext context;
		private static IServiceEmploye serviceEmploye;
		
	//=========================
	// Methods
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceEmploye = (IServiceEmploye) context.getBean("ImpServiceEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAddEmploye() {
		Employe e = new Employe("Goutin");
		try {
			serviceEmploye.add(e);
			assertNotNull(e.getIde());
		} catch (Exception e2) {
			LOGGER.warning(e2.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testAddEmployeToGroupe() throws Exception {
		Employe e = serviceEmploye.add(new Employe("Goutin"));
		e.getIde();
		Groupe g = new Groupe("Developpement");
		g.getIdGroupe();
		serviceEmploye.addEmployeToGroupe(1L, 1L);
		if(e.getNom().equals(g.getEmployes().getClass().getName())){
			assert(true);
		}
	}
	
	@Test
	@Ignore
	public void testGet() {
		Employe e = serviceEmploye.get(1L);
		assertTrue(e!=null);
	}
	
	@Test
	@Ignore
	public void testGetAll() {
		List<Employe> employes = serviceEmploye.getAll();
		assertTrue(employes.size()>0);
	}
	
	@Test
	@Ignore
	public void testGetEmployeByMc() {
		List<Employe> employes = serviceEmploye.getEmployeByMc("o");
		for(Employe e:employes){
			if(e.getNom().equals("o")){
				assert(true);
			}
		}
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Employe e = serviceEmploye.get(2L);
		e.setNom("jose");
		serviceEmploye.update(e);
		Employe e1 = serviceEmploye.get(2L);
		Assert.assertThat("jose", IsEqual.equalTo(e1.getNom()));
	}
	
	@Test
	@Ignore
	public void testRemove() {
		List<Employe> employes = serviceEmploye.getAll();
		int s1 = employes.size();
		serviceEmploye.remove(2L);
		int s2 = employes.size();
		assert(s1-s2==1);
	}
}
