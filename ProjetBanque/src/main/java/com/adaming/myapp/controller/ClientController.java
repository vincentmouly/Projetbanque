package com.adaming.myapp.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.ExceptionClient;
import com.adaming.myapp.model.ClientModel;
import com.adaming.myapp.service.IClientService;

@Controller
public class ClientController {
	
	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("BanqueController");
	@Inject
	private IClientService service;
	
	//=========================
	// Methodes
	//=========================
	
	@RequestMapping(value="/Client", method=RequestMethod.GET)
	public String init(Model model){
		List<Client> clients = service.getAll();
		ClientModel cm = new ClientModel();
		cm.setListeClients(clients);
		model.addAttribute("clModel", cm);
		return "clients";	
	}
	@RequestMapping(value="/addClient", method=RequestMethod.GET)
	public String addClient(Model model, @ModelAttribute("cmModel") 
	@Valid ClientModel cm, BindingResult result){
		if (result.hasErrors()){
			List<Client> clients = service.getAll();
			cm.setListeClients(clients);
			model.addAttribute("cmModel", cm);
			return "Clients";
		}
		try {
			service.addClient(cm.getNom() , cm.getPrenom(), cm.getDate_naisssance(), cm.getAdresse(), cm.getIdBanque());
			List<Client> c2 = service.getAll();
			cm.setListeClients(c2);
			model.addAttribute("cmModel",cm);
			return "redirect:/";
		} catch (ExceptionClient e) {
			cm.setExceptionClient(e.getMessage());
			model.addAttribute("cmModel", cm);
			LOGGER.info(" exception " + cm.getExceptionClient());
			List<Client> clients = service.getAll();
			cm.setListeClients(clients);
			return "Clients";
		}
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(Model model,ClientModel cm,Client c){
		service.update(c);
		List<Client> clients = service.getAll();
		cm.setListeClients(clients);
		model.addAttribute("clModel",cm);
		return "Clients";
	}
	@RequestMapping(value="/getByMc",method=RequestMethod.GET)
	public String getByMc(Model model,ClientModel cm){
		
		model.addAttribute("cmModel",new ClientModel());

		
		List<Client> clientsMc = service.getClientByMc(cm.getMc());
		cm.setListeClients(clientsMc);
		model.addAttribute("clModel2",cm);
		return "Clients";
	}
	@RequestMapping(value="/getComptes",method=RequestMethod.GET)
	public String getComptes(Model model, ClientModel cm){
		
		model.addAttribute("cmModel",new ClientModel());
		List<Compte> comptes = service.getComptes(service.get(cm.getIdClient()));
		cm.setListeComptes(comptes);
		return "Clients";
		
	}
	@RequestMapping(value="/getBanque",method=RequestMethod.GET)
	public String getBanque(Model model, ClientModel cm){
		
		model.addAttribute("cmModel", new ClientModel());
		List<Banque> banques = service.getBanque(service.get(cm.getIdClient()));
		cm.setListeBanques(banques);
		return "Clients";
		
	}
}
