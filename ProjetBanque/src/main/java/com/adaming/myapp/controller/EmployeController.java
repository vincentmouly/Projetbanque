/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.ExceptionBanque;
import com.adaming.myapp.exception.ExceptionEmploye;
import com.adaming.myapp.service.IServiceEmploye;


public class EmployeController {
	
	//=========================
	// Attributes
	//=========================
		
		private final Logger LOGGER = Logger.getLogger("GroupeController");
		@Inject
		private IServiceEmploye service;
			
	//=========================
	// Methodes
	//=========================
		
		@RequestMapping(value="/Employes", method=RequestMethod.GET)
		public String init(Model model){
			List<Employe> employes = service.getAll();
			EmployeModel em = new EmployeModel();
			em.setEmployes(employes);
			model.addAllAttributes("emModel", em);
			return "Employes";
		}
		
		@RequestMapping(value="/addEmploye", method=RequestMethod.GET)
		public String add(Model model, @ModelAttribute("emModel") 
		@Valid EmployeModel em, BindingResult result){
			if (result.hasErrors()){
				List<Employe> employes = service.getAll();
				em.setBanques(employes);
				model.addAllAttributes("emModel", em);
				return "Employes";
			}
			try {
				Employe e = new Employe(em.getNom);
				service.add(e);
				List<Employe> e2 = service.getAll();
				em.setBanques(e2);
				model.addAttribute("emModel",em);
				return "redirect:/";
			} catch (ExceptionEmploye e) {
				em.setExceptionEmploye(e.getMessage());
				model.addAllAttributes("emModel", em);
				LOGGER.info(" exception " + em.getExceptionBanque());
				List<Employe> employes = service.getAll();
				em.setBanques(employes);
				return "Employes";
			}
		}
		@RequestMapping(value="/updateEmploye",method=RequestMethod.GET)
		public String Update (Model model, Employemodel em, Employe e){
			service.update(e);
			List<Employe> employes = service.getAll();
			em.setBanques(employes);
			model.addAttribute("emModel", em);
			return "Employes";
		}
}
