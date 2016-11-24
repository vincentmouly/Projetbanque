package com.adaming.myapp.model;

import java.util.ArrayList;
import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;

public class BanqueModel {
	
	private long idBanque;
	private String NomAgence;
	private String Adresse;
	private String CodePostale;
	
	private List<Client> listeClients = new ArrayList<Client>();
	private List<Compte> listeComptes = new ArrayList<Compte>();
	private List<Employe> listeEmployes = new ArrayList<Employe>();
	private List<Groupe> listeGroupes = new ArrayList<Groupe>();
	
	private List<Banque> listeBanques;

	public BanqueModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(long idBanque) {
		this.idBanque = idBanque;
	}

	public String getNomAgence() {
		return NomAgence;
	}

	public void setNomAgence(String nomAgence) {
		NomAgence = nomAgence;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getCodePostale() {
		return CodePostale;
	}

	public void setCodePostale(String codePostale) {
		CodePostale = codePostale;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public List<Employe> getListeEmployes() {
		return listeEmployes;
	}

	public void setListeEmployes(List<Employe> listeEmployes) {
		this.listeEmployes = listeEmployes;
	}

	public List<Groupe> getListeGroupes() {
		return listeGroupes;
	}

	public void setListeGroupes(List<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
	}

	public List<Banque> getListeBanques() {
		return listeBanques;
	}

	public void setListeBanques(List<Banque> listeBanques) {
		this.listeBanques = listeBanques;
	}
	

}
