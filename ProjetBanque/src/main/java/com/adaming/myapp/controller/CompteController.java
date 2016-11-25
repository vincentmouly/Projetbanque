package com.adaming.myapp.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operations;
import com.adaming.myapp.model.CompteModel;
import com.adaming.myapp.service.ICompteService;

@Controller
//@RequestMapping(value="/Comptes")
public class CompteController {

	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("BanqueController");
	@Inject
	private ICompteService service;
	
	//=========================
	// Methodes
	//=========================
	
	@RequestMapping(value="/Comptes", method=RequestMethod.GET)
	public String init(Model model){
		List<Compte> Comptes = service.getAll();
		CompteModel com = new CompteModel();
		com.setListeComptes(Comptes);
		model.addAttribute("coModel", com);
		return "Comptes";	
	}/*
	@RequestMapping(value="/addCompteCourant", method=RequestMethod.GET)
	public String addCompteCourant(Model model, @ModelAttribute("cmModel") 
	@Valid CompteModel com, BindingResult result){
		if (result.hasErrors()){
			List<Compte> Comptes = service.getAll();
			com.setListeComptes(Comptes);
			model.addAttribute("coModel", com);
			return "Comptes";
		}
		try {
			service.addCompteCourant(com.getIdClient(), com.getIdBanque());
			List<Compte> c2 = service.getAll();
			com.setListeComptes(c2);
			model.addAttribute("coModel",com);
			return "redirect:/";
		} catch (ExceptionCompte e) {
			com.setExceptionCompte(e.getMessage());
			model.addAttribute("coModel", com);
			LOGGER.info(" exception " + com.getExceptionCompte());
			List<Compte> Comptes = service.getAll();
			com.setListeComptes(Comptes);
			return "Comptes";
		}
	}
	@RequestMapping(value="/addCompteEpargne", method=RequestMethod.GET)
	public String addCompteEpargne(Model model, @ModelAttribute("cmModel") 
	@Valid CompteModel com, BindingResult result){
		if (result.hasErrors()){
			List<Compte> Comptes = service.getAll();
			com.setListeComptes(Comptes);
			model.addAttribute("coModel", com);
			return "Comptes";
		}
		try {
			service.addCompteEpargne(com.getIdClient(), com.getIdBanque());
			List<Compte> c2 = service.getAll();
			com.setListeComptes(c2);
			model.addAttribute("coModel",com);
			return "redirect:/";
		} catch (ExceptionCompte e) {
			com.setExceptionCompte(e.getMessage());
			model.addAttribute("coModel", com);
			LOGGER.info(" exception " + com.getExceptionCompte());
			List<Compte> Comptes = service.getAll();
			com.setListeComptes(Comptes);
			return "Comptes";
		}
	}*/
	@RequestMapping(value="/updateCompte",method=RequestMethod.GET)
	public String update(Model model,CompteModel com,Compte co){
		service.update(co);
		List<Compte> Comptes = service.getAll();
		com.setListeComptes(Comptes);
		model.addAttribute("clModel",com);
		return "Comptes";
		
	}
	@RequestMapping(value="/getEmploye",method=RequestMethod.GET)
	public String getEmploye(Model model, CompteModel com){
		
		model.addAttribute("coModel", new CompteModel());
		Employe employe = service.getEmploye(service.get(com.getIdCompte()));
		com.setEmploye(employe);
		return "Comptes";
		
	}
	@RequestMapping(value="/RemoveCompte",method=RequestMethod.GET)
	public String getRemove(Model model, CompteModel com,Long id){
		service.remove(id);
		List<Compte> comptes = service.getAll();
		com.setListeComptes(comptes);
		model.addAttribute("coModel", com);
		
		return "Comptes";
		
	}
	@RequestMapping(value="/Compte",method=RequestMethod.GET)
	public String getCompte(Model model, CompteModel com, Long id, Double solde, Date date_creation){
		
		com.setIdCompte(id);
		com.setSolde(solde);
		com.setDate_creation(date_creation);
		model.addAttribute("comModel", com);
		List<Operations> operations = service.getOperations(service.get(id));
		com.setOperations(operations);
		return "Compte";	
	}
}
