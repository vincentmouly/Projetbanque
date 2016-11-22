package com.adaming.myapp.entities;
/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
public class Groupe {

	//=========================
	// Attributes
	//=========================
	private long idGroupe;
	private String Nom;
	
	//=========================
	// Constructor
	//=========================
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(String nom) {
		super();
		Nom = nom;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	public long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(long idGroupe) {
		this.idGroupe = idGroupe;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
}
