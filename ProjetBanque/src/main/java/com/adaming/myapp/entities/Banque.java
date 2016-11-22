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
import javax.persistence.OneToMany;


@Entity
public class Banque {

	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idBanque;
	private String NomAgence;
	private String Adresse;
	private String CodePostale;
	
	//=========================
	// Associations
	//=========================
	
	@ManyToMany
	@JoinTable(name="TB_BANQUE_CLIENT")
	private List<Client> clients = new ArrayList<Client>();
	
	@OneToMany(mappedBy="banque")
	private List<Compte> comptes = new ArrayList<Compte>();
	
	@OneToMany(mappedBy="banque")
	private List<Employe> employes = new ArrayList<Employe>();
	
	//=========================
	// Constructor
	//=========================
	
	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Banque(String nomAgence, String adresse, String codePostale) {
		super();
		NomAgence = nomAgence;
		Adresse = adresse;
		CodePostale = codePostale;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	public long getIdBanque() {
		return idBanque;
	}
	public void setIdBanque(long idBanque) {
		this.idBanque = idBanque;
	}
	public String getNomAgence() {
		return NomAgence;
	}
	public void setNomAgence(String nomAgence) {
		NomAgence = nomAgence;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getCodePostale() {
		return CodePostale;
	}
	public void setCodePostale(String codePostale) {
		CodePostale = codePostale;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	
	//=========================
	// Methodes
	//=========================
	
	@Override
	public String toString() {
		return "Banque [idBanque=" + idBanque + ", NomAgence=" + NomAgence
				+ ", Adresse=" + Adresse + ", CodePostale=" + CodePostale
				+ ", clients=" + clients + ", comptes=" + comptes
				+ ", employes=" + employes + "]";
	}
}
