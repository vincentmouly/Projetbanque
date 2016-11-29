package com.adaming.myapp.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operations;
import com.adaming.myapp.model.CompteModel;
import com.adaming.myapp.service.ICompteService;
import com.adaming.myapp.service.IServiceBanque;

@Controller
//@RequestMapping(value="/ClientsBanques")
public class CompteController {

	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("BanqueController");
	@Inject
	private ICompteService service;
	@Inject
	private IServiceBanque serviceb;
	
	//=================== ======
	// Methodes
	//=========================
	
	@RequestMapping(value="/Comptes", method=RequestMethod.GET)
	public String init(Model model, Model model2, Model model3){
		
		//Obtentions des Comptes LCL
		CompteModel coml = new CompteModel();
		coml.setBanque(serviceb.get(3L));
		Set<Compte> comptes = coml.getBanque().getComptes();
		coml.setListeComptes(comptes);
		model.addAttribute("coModel", coml);
		
		//Obtentions des Comptes BNP
		CompteModel comb = new CompteModel();
		comb.setBanque(serviceb.get(2L));
		Set<Compte> comptesb = comb.getBanque().getComptes();
		comb.setListeComptes(comptesb);
		model2.addAttribute("coModelb", comb);
		
		//Obtentions des Comptes CIC
		CompteModel comc = new CompteModel();
		comc.setBanque(serviceb.get(1L));
		Set<Compte> comptesc = comc.getBanque().getComptes();
		comc.setListeComptes(comptesc);
		model3.addAttribute("coModelc", comc);
		return "Comptes";	
	}
	@RequestMapping(value="/updateCompte",method=RequestMethod.GET)
	public String update(Model model,CompteModel com, Long id, String soldeup){ 
		Double montant = Double.parseDouble(soldeup);
		Compte co = service.get(id);
		co.setSolde(montant);
		service.update(co);
		Set<Operations> ops = service.getOperations(co);
		com.setIdCompte(co.getIdCompte());
		com.setSolde(co.getSolde());
		com.setDate_creation(co.getDate_creation());
		com.setOperations(ops);
		model.addAttribute("comModel",com);
		return "Compte";
		
	}
	@RequestMapping(value="/RemoveCompte",method=RequestMethod.GET)
	public String getRemove(Model model, CompteModel com,Long id){
		service.remove(id);
		Set<Compte> comptes = service.getAll();
		com.setListeComptes(comptes);
		model.addAttribute("coModel", com);
		
		return "Comptes";
		
	}
	@RequestMapping(value="/Compte",method=RequestMethod.GET)
	public String getCompte(Model model, CompteModel com, Long id){
		Compte c = service.get(id);
		com.setIdCompte(id);
		com.setSolde(c.getSolde());
		com.setDate_creation(c.getDate_creation());
		Set<Operations> operations = service.getOperations(service.get(id));
		com.setOperations(operations);
		model.addAttribute("comModel", com);
		return "Compte";	
	}
}
