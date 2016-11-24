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
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.service.IServiceBanque;

public class BanqueServiceTestU {

	//=========================
	// Attributes
	//=========================
		
		private final Logger LOGGER = Logger.getLogger("BanqueServiceTestU");
		private static ClassPathXmlApplicationContext context;
		private static IServiceBanque serviceBanque;

	//=========================
	// Methods
	//=========================
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		serviceBanque = (IServiceBanque) context.getBean("ImpServiceBanque");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	@Ignore
	public void testAdd() {
		Banque b = new Banque("LCL", "24 rue General de Gaulle", "95880");
		try {
			serviceBanque.add(b);
			assertNotNull(b.getIdBanque());		
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testGet() {
		Banque b = serviceBanque.get(1L);
		assertTrue(b !=null);
	}
	
	@Test
	@Ignore
	public void testGetAll() {
		List<Banque> banques = serviceBanque.getAll();
		assertTrue(banques.size()>0);
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		Banque b1 = serviceBanque.get(1L);
		b1.setNomAgence("La Poste");
		serviceBanque.update(b1);
		Banque b2 = serviceBanque.get(1L);
		Assert.assertThat("La Poste", IsEqual.equalTo(b2.getNomAgence()));
	}
	
	@Test
	@Ignore
	public void testRemove() {
		List<Banque> banques = serviceBanque.getAll();
		int s1 = banques.size();
		serviceBanque.remove(1L);
		int s2 = banques.size();
		assert(s1-s2==1);
	}

	

	

	/*@Test
	public void testGetClients() {
		Banque banque = serviceBanque.get(2L);
		banque.getClients();
		clients.add(c);
		List<Client> clients1 = serviceBanque.getClients(b);	
	}

	@Test
	public void testGetGroupes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetComptes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployes() {
		fail("Not yet implemented");
	}
	*/

}
