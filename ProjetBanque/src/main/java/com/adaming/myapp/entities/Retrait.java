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
@DiscriminatorValue("Retrait")
public class Retrait extends Operations {

	//=========================
	// Attributes
	//=========================
					
	//=========================
	// Constructor
	//=========================
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date date, double montant) {
		super(date, montant);
		// TODO Auto-generated constructor stub
	}

	//=========================
	// Getter / Setter
	//=========================
			
	
	//=========================
	// Methods
	//=========================
}
