/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Groupe {

	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idGroupe;
	private String Nom;
	
	//=========================
	// Associations
	//=========================
	
	@ManyToOne
	@JoinTable(name="TB_GROUPE_BANQUE")
	private Banque banque;
	
	@ManyToMany(mappedBy="groupes")
	private List<Employe> employes = new ArrayList<Employe>();
	
	//=========================
	// Constructor
	//=========================
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groupe(String nom) {
		super();
		Nom = nom;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
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
	public Banque getBanque() {
		return banque;
	}
	public void setBanque(Banque banque) {
		this.banque = banque;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	@Override
	public String toString() {
		return "Groupe [idGroupe=" + idGroupe + ", Nom=" + Nom + ", banque="
				+ banque + ", employes=" + employes + "]";
	}
}
