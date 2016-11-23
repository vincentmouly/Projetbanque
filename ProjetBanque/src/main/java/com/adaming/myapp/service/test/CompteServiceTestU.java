package com.adaming.myapp.service.test;

import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.service.ICompteService;


public class CompteServiceTestU {

	private final Logger LOGGER = Logger.getLogger("CompteServiceTestU");
	private static ClassPathXmlApplicationContext context;
	private static ICompteService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (ICompteService) context.getBean("ImpServiceCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() {
		Compte c = new CompteCourant(100, new Date(), 300);
		try {
			service.add(c);
			assertNotNull(c.getIdCompte());
			
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
	}

	@Test
	public void testGet() {
		Compte c = service.get(1L);
		assertTrue(c != null);
	}

	@Test
	public void testRemove() {
		List<Compte> comptes = service.getAll();
		service.remove(1L);
		List<Compte> comptes2 = service.getAll();
		assertTrue(comptes.size()-1 == comptes2.size());
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
