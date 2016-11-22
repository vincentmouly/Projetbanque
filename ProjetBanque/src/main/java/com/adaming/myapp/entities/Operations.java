	/*
	 * Version: 1.0.0
	 * Date: 22-11-2016
	 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
	 */

package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Operations", discriminatorType=DiscriminatorType.STRING)

public abstract class  Operations implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Ido;
	private Date date;
	private double montant;
	
	//=========================
	// Associations
	//=========================

	@ManyToOne
	@JoinColumn(name="IdEmploye")
	private Employe employe;
	
	@ManyToMany
	@JoinTable(name="TB_OPERATIONS_COMPTES")
	private List<Compte> comptes = new ArrayList<Compte>();
	//=========================
	// Constructor
	//=========================
	
	public Operations() {
		// TODO Auto-generated constructor stub
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	//=========================
	// Methods
	//=========================
	
	@Override
	public String toString() {
		return "Operations [Ido=" + Ido + ", date=" + date + ", montant="
				+ montant + ", employe=" + employe + ", comptes=" + comptes
				+ "]";
	}
}
