package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.service.IServiceEmploye;


public class EmployeServiceTestU {
	
	private final Logger LOGGER = Logger.getLogger("BanqueServiceTestU");
	private static ClassPathXmlApplicationContext context;
	private static IServiceEmploye service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IServiceEmploye) context.getBean("ImpServiceEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() {
		Employe e = new Employe("Goutin");
		try {
			service.add(e);
			assertNotNull(e.getIde());
		} catch (Exception e2) {
			LOGGER.warning(e2.getMessage());
		}
	}

	@Test
	public void testGet() {
		Employe e = service.get(1L);
		assertTrue(e!=null);
	}

	@Test
	public void testRemove() {
		List<Employe> employes = service.getAll();
		service.remove(1L);
		List<Employe> employes1 = service.getAll();
		assertTrue(employes.size()-1 ==employes.size());
	}

	@Test
	public void testUpdate() {
		Employe e = service.get(1L);
		e.setNom("jose");
		service.update(e);
		Employe e1 = service.get(1L);
		Assert.assertThat("jose", IsEqual.equalTo(e1.getNom()));
	}

	@Test
	public void testGetAll() {
		List<Employe> employes = service.getAll();
		assertTrue(employes.size()>0);
	}

	@Test
	public void testGetEmployeByMc() {
		List<Employe> employes = service.getEmployeByMc("o");
		for(Employe e:employes){
			if(e.getNom().equals("o")){
				assert(true);
			}
		}
	}

}
