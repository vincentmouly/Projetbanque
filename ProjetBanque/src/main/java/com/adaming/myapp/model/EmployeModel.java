package com.adaming.myapp.model;

import java.util.ArrayList;
import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.entities.Operations;

public class EmployeModel {
	//
	private Long Ide;
	private String nom;
	
	private Banque banque;
	private List<Groupe> groupes = new ArrayList<Groupe>();
	private List<Operations> operations = new ArrayList<Operations>();
	private List<Compte> comptes = new ArrayList<Compte>();
	
	private List<Employe> listeEmployes;

	public EmployeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIde() {
		return Ide;
	}

	public void setIde(Long ide) {
		Ide = ide;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public List<Operations> getOperations() {
		return operations;
	}

	public void setOperations(List<Operations> operations) {
		this.operations = operations;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public List<Employe> getListeEmployes() {
		return listeEmployes;
	}

	public void setListeEmployes(List<Employe> listeEmployes) {
		this.listeEmployes = listeEmployes;
	}
	
	

}
