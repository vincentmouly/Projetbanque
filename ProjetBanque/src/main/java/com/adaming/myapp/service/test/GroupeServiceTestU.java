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
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.service.IServiceGroupe;

public class GroupeServiceTestU {
	
	//=========================
	// Attributes
	//=========================
		
		private final Logger LOGGER = Logger.getLogger("BanqueServiceTestU");
		private static ClassPathXmlApplicationContext context;
		private static IServiceGroupe service;


	//=========================
	// Methods
	//=========================

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IServiceGroupe) context.getBean("ImpServiceGroupe");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		Groupe g = service.get(1L);
		assertTrue(g!=null);
	}

	@Test
	public void testRemove() {
		List<Groupe> groupes = service.getAll();
		service.remove(1L);
		List<Groupe> groupes1 = service.getAll();
		assertTrue(groupes.size()-1 ==groupes1.size());
	}

	@Test
	public void testUpdate() {
		Groupe g = service.get(1L);
		g.setNom("market");
		service.update(g);
		Groupe g1 = service.get(1L);
		Assert.assertThat("market", IsEqual.equalTo(g1.getNom()));
	}

	@Test
	public void testGetAll() {
		List<Groupe> groupes = service.getAll();
		assertTrue(groupes.size()>0);
	}

	@Test
	public void testGetGroupeByMc() {
		List<Groupe> groupes = service.getGroupeByMc("m");
		for(Groupe g:groupes){
			if(g.getNom().equals("m")){
				assert(true);
			}
		}
	}

	@Test
	public void testAddGroupe() {
		Groupe g = new Groupe("developpement");
		try {
			service.add(g);
			assertNotNull(g.getIdGroupe());
		} catch (Exception e) {
			LOGGER.warning(e.getMessage());
		}
	}

}
