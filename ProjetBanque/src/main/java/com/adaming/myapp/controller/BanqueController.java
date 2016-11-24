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
import com.adaming.myapp.exception.ExceptionBanque;
import com.adaming.myapp.service.IServiceBanque;

@Controller
public class BanqueController {
	
	private final Logger LOGGER = Logger.getLogger("BanqueController");
	@Inject
	private IServiceBanque service;
	
	@RequestMapping(value="/Banque", method=RequestMethod.GET)
	public String init(Model model){
		List<Banque> banques = service.getAll();
		BanqueModel bm = new BanqueModel();
		bm.setBanques(banques);
		model.addAllAttributes("bmModel", bm);
		return "Banques";	
	}
	@RequestMapping(value="/addBanque", method=RequestMethod.GET)
	public String add(Model model, @ModelAttribute("bm model") 
	@Valid BanqueModel bm, BindingResult result){
		if (result.hasErrors()){
			List<Banque> banques = service.getAll();
			bm.setBanques(banques);
			model.addAllAttributes("bmModel", bm);
			return "Banques";
		}
		try {
			Banque b = new Banque(bm.getNomAgence, bm.getAdresse, bm.getCodePostale);
			service.add(b);
			List<Banque> b2 = service.getAll();
			bm.setBanques(b2);
			model.addAttribute("bmModel",bm);
			return "redirect:/";
		} catch (ExceptionBanque e) {
			bm.setExceptionBanque(e.getMessage());
			model.addAllAttributes("bmModel", bm);
			LOGGER.info(" exception " + bm.getExceptionBanque());
			List<Banque> banques = service.getAll();
			bm.setBanques(banques);
			return "Banques";
		}
	}
	
	

}
