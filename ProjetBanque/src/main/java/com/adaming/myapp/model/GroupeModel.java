package com.adaming.myapp.model;

import java.util.ArrayList;
import java.util.List;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;

public class GroupeModel {
	//
	private long idGroupe;
	private String Nom;
	
	private List<Employe> employes = new ArrayList<Employe>();
	
	private List<Groupe> listeEmployes;

	public GroupeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(long idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Groupe> getListeEmployes() {
		return listeEmployes;
	}

	public void setListeEmployes(List<Groupe> listeEmployes) {
		this.listeEmployes = listeEmployes;
	}
	
	
	

}
