package com.adaming.myapp.entities;

import java.util.Date;
/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
public class Client {
	
	//=========================
	// Attributes
	//=========================
	private Long idClient;
	private String Nom;
	private String Prenom;
	private Date date_naisssance;
	
	//=========================
	// Constructor
	//=========================
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String prenom, Date date_naisssance) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.date_naisssance = date_naisssance;
	}
	
	//=========================
	// Getter / Setter
	//=========================
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

}
