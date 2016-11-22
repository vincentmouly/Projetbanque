/*
 * Version: 1.0.0
 * Date: 22-11-2016
 * Author: Florian Goutin / Vincent Mouly / Loic Laugerette
 */

package com.adaming.myapp.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String Nom;
	private String Prenom;
	private Date date_naisssance;
	
	//=========================
	// Associations
	//=========================
	@ManyToMany(mappedBy="clients")
	private List<Banque> banques = new ArrayList<Banque>();
	
	@OneToMany(mappedBy="client")
	private List<Compte> comptes = new ArrayList<Compte>();
	
	
	
	//=========================
	// Constructor
	//=========================
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nom, String prenom, Date date_naisssance) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.date_naisssance = date_naisssance;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Date getDate_naisssance() {
		return date_naisssance;
	}
	public void setDate_naisssance(Date date_naisssance) {
		this.date_naisssance = date_naisssance;
	}
	public List<Banque> getBanques() {
		return banques;
	}
	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", Nom=" + Nom + ", Prenom="
				+ Prenom + ", date_naisssance=" + date_naisssance
				+ ", banques=" + banques + ", comptes=" + comptes + "]";
	}	
}
