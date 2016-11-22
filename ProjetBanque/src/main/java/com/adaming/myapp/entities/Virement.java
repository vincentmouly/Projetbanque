/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.entities;

import java.util.Date;

public class Virement extends Operations{


	//=========================
	// Attributes
	//=========================
	
	//=========================
	// Constructor
	//=========================
	public Virement() {
		// TODO Auto-generated constructor stub
	}

	public Virement(Date date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	public Virement(Long ido, Date date, double montant) {
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
