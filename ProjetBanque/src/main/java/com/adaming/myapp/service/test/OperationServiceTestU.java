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

import com.adaming.myapp.dao.IOperationDao;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operations;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.ICompteService;
import com.adaming.myapp.service.IOperationService;
import com.adaming.myapp.service.IServiceBanque;
import com.adaming.myapp.service.IServiceEmploye;

public class OperationServiceTestU {

	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("OperationsServiceTestU");
	private static ClassPathXmlApplicationContext context;
	private static IOperationService service;
	private static ICompteService daoc;
	private static IServiceEmploye daoe;
	
	//=========================
	// Methods
	//=========================
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("app.xml");
		service = (IOperationService) context.getBean("ImpServiceOperation");
		daoc = (ICompteService) context.getBean("ImpServiceCompte");
		daoe = (IServiceEmploye) context.getBean("ImpServiceEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		context.close();
	}
	@Test
	@Ignore
	public void testAdd() {
		Operations c = new Versement(new Date(), 200);
		try{
			service.add(c);
			assertNotNull(c.getIdo());
		}catch (Exception e){
			LOGGER.warn(e.getMessage());
		}
			
	}

	@Test
	public void testGet() {
		Operations b = service.get(1L);
		assertTrue(b !=null);
	}
	@Test
	@Ignore
	public void testRemove() {
		List<Operations> Operationss = service.getAll();
		service.remove(2L);
		List<Operations> Operationss2 = service.getAll();
		assertTrue(Operationss.size()-1 == Operationss2.size());
	}

	@Test
	@Ignore
	public void testUpdate() {
		Operations o1 = service.get(1L);
		o1.setMontant(200);
		service.update(o1);
		Operations o2 = service.get(1L);
		Assert.assertTrue(200 == o2.getMontant());	
	}

	@Test
	public void testGetAll() {
		List<Operations> Operations = service.getAll();
		assertTrue(Operations.size()>0);
	}

	@Test
	public void getComptes(){
		Operations o = service.get(3L);
		List<Compte> comptes = o.getComptes();
		assertTrue(comptes.size()>0);
	}
	
	@Test
	public void getEmploye(){
		Operations o = service.get(3L);
		Employe e = o.getEmploye();
		assertTrue(e != null);
	}
	
	@Test
	@Ignore
	public void Versement(){
		Compte c = daoc.get(2L);
		List<Operations> ops =c.getOperations();
		Employe e = daoe.get(1L);
		List<Operations> es = e.getOperations();
		service.Versement(2L, 100, 1L);
		Compte c2 = daoc.get(2L);
		Employe e2 = daoe.get(1L);
		List<Operations> es2 = e2.getOperations();
		List<Operations> ops2 =c2.getOperations();
		assertTrue(c.getSolde() != c2.getSolde());
		assertTrue(ops2.size() == ops.size()+1);
		assertTrue(es2.size() == es.size()+1);
	}
	
	@Test
	@Ignore
	public void Retrait() throws Exception{
		Compte c = daoc.get(2L);
		List<Operations> ops =c.getOperations();
		Employe e = daoe.get(1L);
		List<Operations> es = e.getOperations();
		service.Retrait(2L, 100, 1L);
		Compte c2 = daoc.get(2L);
		Employe e2 = daoe.get(1L);
		List<Operations> es2 = e2.getOperations();
		List<Operations> ops2 =c2.getOperations();
		assertTrue(c.getSolde() != c2.getSolde());
		assertTrue(ops2.size() == ops.size()+1);
		assertTrue(es2.size() == es.size()+1);
	}
	
	@Test
	public void GetCompte(){
		Compte c = service.GetCompte(2L);
		assertTrue(c != null);
	}
	
	@Test
	public void Virement() throws Exception {
		Compte c = service.GetCompte(2L);
		List<Operations> ops =c.getOperations();
		Employe e = daoe.get(1L);
		List<Operations> es = e.getOperations();
		Compte c2 = service.GetCompte(8L);
		List<Operations> ops2 =c2.getOperations();
		service.Virement(2L, 8L, 50, 1L);
		Compte c3 = service.GetCompte(2L);
		List<Operations> ops3 =c3.getOperations();
		Employe e2 = daoe.get(1L);
		List<Operations> es2 = e2.getOperations();
		Compte c4 = service.GetCompte(8L);
		List<Operations> ops4 =c4.getOperations();
		assertTrue(c.getSolde() == c3.getSolde()+50 && c2.getSolde() == c4.getSolde()-50 && 
				ops3.size() == ops.size()+1 && ops4.size() == ops2.size()+1 && es2.size() == es.size()+2);
	}
}