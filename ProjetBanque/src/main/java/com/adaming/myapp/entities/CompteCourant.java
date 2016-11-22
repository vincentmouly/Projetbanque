/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CompteCourant")
public class CompteCourant extends Compte{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	//=========================
	// Getter / Setter
	//=========================
	
	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + "]";
	}
}
