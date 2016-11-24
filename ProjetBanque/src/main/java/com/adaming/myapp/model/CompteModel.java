package com.adaming.myapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operations;

public class CompteModel {
	//
	private long idCompte;
	private double solde;
	private Date Date_creation;
	private Banque banque;
	private Employe employe;
	private Client client;
	
	private List<Operations> operations = new ArrayList<Operations>();
	
	private List<Compte> listeComptes;

	public CompteModel() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
	
	
	
	
	
	
}
