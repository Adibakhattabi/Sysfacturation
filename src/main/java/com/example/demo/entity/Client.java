package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="client")

public class Client {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id_client")
	private Long idClient;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String telephone;
	private String ville;
	
	public Client() {
		
	}
	
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Utilisateur getUtilisateur() {
	    return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
	    this.utilisateur = utilisateur;
	}

	
	
}
