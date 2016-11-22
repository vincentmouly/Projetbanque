/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Employe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Ide;
	private String nom;
	
	//=========================
	// Associations
	//=========================
	
	@ManyToOne
	@JoinColumn(name="IdBanque")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="TB_EMPLOYE_GROUPE")
	private List<Groupe> groupes = new ArrayList<Groupe>();
	
	@OneToMany(mappedBy="employe")
	private List<Operations> operations = new ArrayList<Operations>();
	
	@OneToMany(mappedBy="employe")
	private List<Compte> comptes = new ArrayList<Compte>();
	
	//=========================
	// Constructor
	//=========================
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public Employe(String nom) {
		super();
		this.nom = nom;
	}
	
	//=========================
	// Getter / Setter
	//=========================

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

	//=========================
	// Methods
	//=========================
	
	@Override
	public String toString() {
		return "Employe [Ide=" + Ide + ", nom=" + nom + ", banque=" + banque
				+ ", groupes=" + groupes + ", operations=" + operations
				+ ", comptes=" + comptes + "]";
	}
}
