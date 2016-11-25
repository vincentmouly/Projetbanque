package com.adaming.myapp.service.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsEqual;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.ExceptionClient;
import com.adaming.myapp.service.IClientService;

public class ClientServiceTestU {

	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("ClientServiceTestU");
	private static ClassPathXmlApplicationContext context;
	private static IClientService service;

	//=========================
	// Methods
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IClientService) context.getBean("ImpServiceClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	@Test
	@Ignore
	public void testAdd() {
		Client c = new Client("aa", "aa", new Date(), "abc");
		try{
			service.add(c);
			assertNotNull(c.getIdClient());
		}catch (Exception e){
			LOGGER.warn(e.getMessage());
		}
			
	}

	@Test
	public void testGet() {
		Client c = service.get(1L);
		assertTrue(c !=null);
	}
	@Test
	@Ignore
	public void testRemove() {
		List<Client> Clients = service.getAll();
		service.remove(1L);
		List<Client> Clients2 = service.getAll();
		assertTrue(Clients.size()-1 == Clients2.size());
	}

	@Test
	public void testUpdate() {
		Client b1 = service.get(2L);
		b1.setNom("aa");
		service.update(b1);
		Client b2 = service.get(2L);
		Assert.assertThat("aa", IsEqual.equalTo(b2.getNom()));	
	}

	@Test
	public void testGetAll() {
		List<Client> Clients = service.getAll();
		assertTrue(Clients.size()>0);
	}

	@Test
	public void getComptes(){
		Client c = service.get(1L);
		List<Compte> comptes = c.getComptes();
		assertTrue(comptes.size()>0);
	}
	
	@Test
	public void getClientByMc(){
		List<Client> clients =service.getClientByMc("a");
		for(Client c:clients){
			if(c.getNom().contains("a")){
				assert(true);
			}
		}
	}
	
	@Test
	public void getBanque(){
		Client c = service.get(1L);
		List<Banque> banques = c.getBanques();
		assertTrue(banques.size()>0);
	}
	
	@Test
	public void addClient() {
		Client c = new Client("aa", "aa", new Date(), "acb");
		try {
			service.addClient("aa", "aa", new Date(), "acb", 1L);
		} catch (ExceptionClient e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Banque> b = c.getBanques();
		assertNotNull(c.getIdClient());
		assertTrue(b.size()>0);
		
			}
}