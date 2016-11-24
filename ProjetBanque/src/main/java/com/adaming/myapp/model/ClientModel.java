package com.adaming.myapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class ClientModel {
	private Long idClient;
	private String Nom;
	private String Prenom;
	private Date date_naisssance;
	private String adresse;
	private String mc;
	
	private List<Banque> listeBanques = new ArrayList<Banque>();
	private List<Compte> listeComptes = new ArrayList<Compte>();
	
	private List<Client> listeClients;

	public ClientModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}
	
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Date getDate_naisssance() {
		return date_naisssance;
	}

	public void setDate_naisssance(Date date_naisssance) {
		this.date_naisssance = date_naisssance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Banque> getListeBanques() {
		return listeBanques;
	}

	public void setListeBanques(List<Banque> listeBanques) {
		this.listeBanques = listeBanques;
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	

}
