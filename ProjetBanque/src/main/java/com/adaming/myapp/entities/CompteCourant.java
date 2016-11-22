package com.adaming.myapp.entities;

import java.util.Date;

/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
public class CompteCourant extends Compte{
	
	//=========================
	// Attributes
	//=========================
	private double decouvert;

	//=========================
	// Constructor
	//=========================
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompteCourant(double solde, Date date_creation, double decouvert) {
		super(solde, date_creation);
		this.decouvert = decouvert;
		// TODO Auto-generated constructor stub
	}
	
	//=========================
	// Getter / Setter
	//=========================
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
}
