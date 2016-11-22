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
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//=========================
	// Attributes
	//=========================
	private double tauxinteret;

	
	//=========================
	// Constructor
	//=========================
	
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CompteEpargne(double solde, Date date_creation,double tauxinteret) {
		super(solde, date_creation);
		this.tauxinteret = tauxinteret;
		// TODO Auto-generated constructor stub
	}
	
	//=========================
	// Getter / Setter
	//=========================
	public double getTauxinteret() {
		return tauxinteret;
	}

	public void setTauxinteret(double tauxinteret) {
		this.tauxinteret = tauxinteret;
	}

	//=========================
	// Getter / Setter
	//=========================
	
	@Override
	public String toString() {
		return "CompteEpargne [tauxinteret=" + tauxinteret + "]";
	}
}
