package com.adaming.myapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class ClientModel {
	private Long idClient;
	private String Nom;
	private String Prenom;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;
	private String adresse;
	private String mc;
	private Long idBanque;
	
	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	private Set<Banque> listeBanques = new HashSet<Banque>();
	private Set<Compte> listeComptes = new HashSet<Compte>();
	
	private Set<Client> listeClients;
	private String ExceptionClient;

	public String getExceptionClient() {
		return ExceptionClient;
	}

	public void setExceptionClient(String exceptionClient) {
		ExceptionClient = exceptionClient;
	}

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

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Banque> getListeBanques() {
		return listeBanques;
	}

	public void setListeBanques(Set<Banque> banques) {
		this.listeBanques = banques;
	}

	public Set<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(Set<Compte> comptes) {
		this.listeComptes = comptes;
	}

	public Set<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(Set<Client> clients) {
		this.listeClients = clients;
	}
	
	

}
