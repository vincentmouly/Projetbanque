/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

public class Employe {
	
	//=========================
	// Attributes
	//=========================
	
	private Long Ide;
	private String nom;
	@OneToMany
	@JoinTable(name="TB_EMPLOYE_OPERATIONS")
	private List<Operations> operations = new ArrayList<Operations>();
	
	//=========================
	// Constructor
	//=========================
	
	public Employe() {
		// TODO Auto-generated constructor stub
	}

	public Employe(Long ide, String nom) {
		super();
		Ide = ide;
		this.nom = nom;
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

	public List<Operations> getOperations() {
		return operations;
	}

	public void setOperations(List<Operations> operations) {
		this.operations = operations;
	}
	
	//=========================
	// Methods
	//=========================
	
}
