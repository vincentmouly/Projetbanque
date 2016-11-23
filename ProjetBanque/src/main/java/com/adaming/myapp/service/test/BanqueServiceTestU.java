package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.service.IServiceBanque;

public class BanqueServiceTestU {
	
	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("BanqueServiceTestU");
	private static ClassPathXmlApplicationContext context;
	private static IServiceBanque service;

	//=========================
	// Methods
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IServiceBanque) context.getBean("ImpServiceBanque");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	context.close();
	}

	@Test
	public void testAdd() {
		Banque b = new Banque("LCL", "24 rue General de Gaulle", "95880");
		try {
			service.add(b);
			assertNotNull(b.getIdBanque());
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}

	@Test
	public void testGet() {
		Banque b = service.get(1L);
		assertTrue(b !=null);
	}
	@Test
	public void testRemove() {
		List<Banque> banques = service.getAll();
		service.remove(1L);
		List<Banque> banques2 = service.getAll();
		assertTrue(banques.size()-1 == banques2.size());
	}

	@Test
	public void testUpdate() {
		Banque b1 = service.get(1L);
		b1.setNomAgence("La Poste");
		service.update(b1);
		Banque b2 = service.get(1L);
		Assert.assertThat("La Poste", IsEqual.equalTo(b2.getNomAgence()));	
	}

	@Test
	public void testGetAll() {
		List<Banque> banques = service.getAll();
		assertTrue(banques.size()>0);
	}

	@Test
	@Ignore
	public void testGetClients() {
		Client c = new Client("Goutin", "florian", new Date());
		Banque b = service.get(1L);
		List<Client> clients0 = new ArrayList<Client>();
		clients0.add(c);
		List<Client> clients = service.getClients(b);
		
	}

	@Test
	@Ignore
	public void testGetGroupes() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetComptes() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testGetEmployes() {
		fail("Not yet implemented");
	}

}
