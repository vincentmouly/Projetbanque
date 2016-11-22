	/*
	 * Version: 1.0.0
	 * Date: 22-11-2016
	 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
	 */

package com.adaming.myapp.entities;

import java.util.Date;


public abstract class  Operations {
	
	//=========================
	// Attributes
	//=========================
	
	private Long Ido;
	private Date date;
	private double montant;

	//=========================
	// Constructor
	//=========================
	
	public Operations() {
		// TODO Auto-generated constructor stub
	}

	public Operations(Long ido, Date date, double montant) {
		super();
		Ido = ido;
		this.date = date;
		this.montant = montant;
	}

	public Operations(Date date, double montant) {
		super();
		this.date = date;
		this.montant = montant;
	}

	//=========================
	// Getter / Setter
	//=========================
	
	public Long getIdo() {
		return Ido;
	}

	public void setIdo(Long ido) {
		Ido = ido;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	//=========================
	// Methods
	//=========================

}
