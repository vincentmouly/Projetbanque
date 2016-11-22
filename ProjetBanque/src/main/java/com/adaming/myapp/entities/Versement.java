/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
package com.adaming.myapp.entities;

import java.util.Date;

public class Versement extends Operations {

	//=========================
	// Attributes
	//=========================
	
	//=========================
	// Constructor
	//=========================
	
	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Versement(Date date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	public Versement(Long ido, Date date, double montant) {
		super(ido, date, montant);
		// TODO Auto-generated constructor stub
	}
	
	//=========================
	// Getter / Setter
	//=========================
			
	//=========================
	// Methods
	//=========================
}
