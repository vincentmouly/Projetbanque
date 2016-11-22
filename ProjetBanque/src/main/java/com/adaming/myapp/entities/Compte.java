package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.*;
/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */
@Entity
public class Compte {
	
	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idCompte;
	private double solde;
	private Date Date_creation;
	
	//=========================
	// Constructor
	//=========================
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(double solde, Date date_creation) {
		super();
		this.solde = solde;
		Date_creation = date_creation;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	public long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(long idCompte) {
		this.idCompte = idCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDate_creation() {
		return Date_creation;
	}
	public void setDate_creation(Date date_creation) {
		Date_creation = date_creation;
	}
	
	
}
