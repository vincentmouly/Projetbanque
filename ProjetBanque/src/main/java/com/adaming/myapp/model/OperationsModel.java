package com.adaming.myapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Operations;

public class OperationsModel {
	//
	private Long Ido;
	private Date date;
	private double montant;
	private Employe employe;
	
	private List<Compte> comptes = new ArrayList<Compte>();
	
	private List<Operations> listeOperations;

	public OperationsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<Operations> getListeOperations() {
		return listeOperations;
	}

	public void setListeOperations(List<Operations> listeOperations) {
		this.listeOperations = listeOperations;
	}
	
	
	

}
