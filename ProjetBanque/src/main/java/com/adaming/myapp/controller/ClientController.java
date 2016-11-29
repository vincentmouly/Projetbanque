package com.adaming.myapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
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
import com.adaming.myapp.entities.Operations;
import com.adaming.myapp.exception.ExceptionClient;
import com.adaming.myapp.exception.ExceptionCompte;
import com.adaming.myapp.model.BanqueModel;
import com.adaming.myapp.model.ClientModel;
import com.adaming.myapp.model.CompteModel;
import com.adaming.myapp.service.IClientService;
import com.adaming.myapp.service.ICompteService;
import com.adaming.myapp.service.IServiceBanque;

@Controller
public class ClientController {
	
	//=========================
	// Attributes
	//=========================
	
	private final Logger LOGGER = Logger.getLogger("ClientController");
	@Inject
	private IClientService service;
	@Inject
	private IServiceBanque serviceb;
	@Inject
	private ICompteService servicec;
	
	//=========================
	// Methodes
	//=========================
	
	@RequestMapping(value="/ClientsBanques", method=RequestMethod.GET)
	public String init(Model model, Model model1, Model model2, Model model3, Model model4){
		Set<Banque> banques = serviceb.getAll();
		ClientModel clModel = new ClientModel();
		clModel.setListeBanques(banques);
		model.addAttribute("clModel", clModel);
		
		//Obtentions des Clients LCL
		Set<Client> clients = serviceb.getClients(3L);
		BanqueModel coml = new BanqueModel();
		coml.setListeClients(clients);
		model1.addAttribute("cbModel", coml);
		
		//Obtentions des Clients BNP
		Set<Client> clientsb = serviceb.getClients(2L);
		BanqueModel comb = new BanqueModel();
		comb.setListeClients(clientsb);
		model2.addAttribute("cobModel", comb);
		
		//Obtentions des Clients CIC
		Set<Client> clientsc = serviceb.getClients(1L);
		BanqueModel comc = new BanqueModel();
		comc.setListeClients(clientsc);
		model3.addAttribute("cbcModel", comc);
		
		//obtentions des Clients sans banques
		Set<Client> clients0 = service.getAll();
		BanqueModel coms = new BanqueModel();
		for(Client c:clients0){
			if(c.getBanques().size()==0){
				coms.getListeClients().add(c);
				model4.addAttribute("comsModel", coms);
			}
		}
		LOGGER.info("sans banque"+coms.getListeClients().size());
		return "ClientsBanques";
	}
	@RequestMapping(value="/addClient", method=RequestMethod.GET)
	public String addClient(Model model, @ModelAttribute("clModel") 
	@Valid ClientModel clModel, BindingResult result){
		if (result.hasErrors()){
			Set<Client> clients = service.getAll();
			clModel.setListeClients(clients);
			model.addAttribute("clModel", clModel);
			return "ClientsBanques";
		}
		try {
			service.addClient(new Client(clModel.getNom() , clModel.getPrenom(), clModel.getDate_naissance(), clModel.getAdresse()), clModel.getIdBanque());
			Set<Client> c2 = service.getAll();
			clModel.setListeClients(c2);
			model.addAttribute("clModel",clModel);
			LOGGER.info("Nom :"+clModel.getNom());
			return "redirect:/";
		} catch (ExceptionClient e) {
			clModel.setExceptionClient(e.getMessage());
			model.addAttribute("clModel", clModel);
			LOGGER.info(" exception " + clModel.getExceptionClient());
			Set<Client> clients = service.getAll();
			clModel.setListeClients(clients);
			return "ClientsBanques";
		}
	}
	@RequestMapping(value="/getByMc",method=RequestMethod.GET)
	public String getByMc(Model model, String mc){
		
		ClientModel cmModel = new ClientModel();
		cmModel.setMc(mc);
		Set<Client> clientsMc = service.getClientByMc(cmModel.getMc());
		cmModel.setListeClients(clientsMc);
		model.addAttribute("clModel2",cmModel);
		return "ClientsBanques";
	}
	@RequestMapping(value="/RemoveClient",method=RequestMethod.GET)
	public String getRemove(Model model, ClientModel com,Long id){
		service.remove(id);
		Set<Client> clients = service.getAll();
		com.setListeClients(clients);
		model.addAttribute("coModel", com);
		
		return "ClientsBanques";
	}
	@RequestMapping(value="/Client",method=RequestMethod.GET)
	public String getClient(Model model, ClientModel com, Long id){
		Client c = service.get(id);
		Set<Banque> banques = c.getBanques();
		LOGGER.info("nbr banques:"+banques.size());
		com.setListeBanques(banques);
		com.setIdClient(id);
		com.setNom(c.getNom());
		com.setPrenom(c.getPrenom());
		com.setDate_naissance(c.getDate_naissance());
		com.setAdresse(c.getAdresse());
		Set<Compte> comptes = service.getComptes(service.get(id));
		com.setListeComptes(comptes);
		model.addAttribute("clModel", com);
		return "Client";	
	}
	@RequestMapping(value="/updateClient",method=RequestMethod.GET)
	public String update(Model model, Long id, String nom, String prenom, String date_naissance, String adresse){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM--dd");
		Date date = new Date();
		try {
			date  = sf.parse(date_naissance);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClientModel cm = new ClientModel();
		Client c = service.get(id);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setDate_naissance(date);
		c.setAdresse(adresse);
		service.update(c);
		cm.setIdClient(c.getIdClient());
		cm.setNom(c.getNom());
		cm.setPrenom(c.getPrenom());
		cm.setDate_naissance(c.getDate_naissance());
		cm.setAdresse(c.getAdresse());
		Set<Compte> comptes = service.getComptes(c);
		cm.setListeComptes(comptes);
		model.addAttribute("clModel",cm);
		return "Client";
	}
	@RequestMapping(value="/CreateCompte",method=RequestMethod.GET)
	public String CreateClient(Model model, Long idClient, Long idBanque, String Compte){
		Client c = service.get(idClient);
		Banque b = serviceb.get(idBanque);
		CompteModel ccModel = new CompteModel();
		LOGGER.info("idClient : "+idClient+" idBanque : "+idBanque+" Compte : "+Compte);
		if(Compte.equals("Courant")){
			try {
				servicec.addCompteCourant(idClient, idBanque);
			} catch (ExceptionCompte e) {
				ccModel.setExceptionCompte(e.getMessage());
				model.addAttribute("clModel", ccModel);
				LOGGER.info(" exception " + ccModel.getExceptionCompte());
				ccModel.setClient(c);
				
			}
		}else if(Compte.equals("Epargne")){
			try {
				servicec.addCompteEpargne(idClient, idBanque);
			} catch (ExceptionCompte e) {
				ccModel.setExceptionCompte(e.getMessage());
				model.addAttribute("clModel", ccModel);
				LOGGER.info(" exception " + ccModel.getExceptionCompte());
				ccModel.setClient(c);
			}
		}
		return "Client";
	}
}
