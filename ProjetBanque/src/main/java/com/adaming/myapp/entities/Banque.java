package com.adaming.myapp.entities;
/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
public class Banque {

	//=========================
	// Attributes
	//=========================
	private long idBanque;
	private String NomAgence;
	private String Adresse;
	private String CodePostale;
	
	//=========================
	// Constructor
	//=========================
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banque(String nomAgence, String adresse, String codePostale) {
		super();
		NomAgence = nomAgence;
		Adresse = adresse;
		CodePostale = codePostale;
	}
	
	//=========================
	// Getter / Setter
	//=========================
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
	
}
