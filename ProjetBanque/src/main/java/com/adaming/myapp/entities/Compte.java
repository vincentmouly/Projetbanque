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

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Type_Comptes", discriminatorType=DiscriminatorType.STRING)

public abstract class Compte implements Serializable {
	
	/**
	 * 
	 */
	private static final Long serialVersionUID = 1L;
	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompte;
	private double solde;
	private Date date_creation;
	
	//=========================
	// Associations
	//=========================
	@ManyToOne
	@JoinColumn(name="idBanque")
	private Banque banque;
	
	@ManyToOne
	@JoinColumn(name="IdEmploye")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="IdClient")
	private Client client;
	
	@ManyToMany(mappedBy="comptes", fetch=FetchType.EAGER)
	private List<Operations> operations = new ArrayList<Operations>();
	
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
		this.date_creation = date_creation;
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
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Operations> getOperations() {
		return operations;
	}

	public void setOperations(List<Operations> operations) {
		this.operations = operations;
	}
	
	//=========================
	// Methodes
	//=========================
	
	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", solde=" + solde
				+ ", Date_creation=" + date_creation + ", banque=" + banque
				+ ", employe=" + employe + ", client=" + client
				+ ", operations=" + operations + "]";
	}

	
}
