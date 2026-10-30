package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Utilisateur;
import com.example.demo.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	public UtilisateurRepository utilisateurRepository;
	
	//Dependances
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	//1.Add
	
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur){
		return utilisateurRepository.save(utilisateur);
	}
	//List
	public List<Utilisateur>getAllUtilisateur(){
		return utilisateurRepository.findAll();
	}
	//Search
	public Utilisateur getUtilisateurById(Long id) {
		return utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur Introuvable"));
	}
	//EDIT
	public Utilisateur modifierUtilisateur(Long id, Utilisateur nouveauUtilisateur){
		Utilisateur utilisateur = getUtilisateurById(id);
		utilisateur.setNom(nouveauUtilisateur.getNom());
		utilisateur.setPrenom(nouveauUtilisateur.getPrenom());
		utilisateur.setEmail(nouveauUtilisateur.getEmail());
		utilisateur.setMot_de_passe(nouveauUtilisateur.getMot_de_passe());
		utilisateur.setTelephone(nouveauUtilisateur.getTelephone());
		utilisateur.setRole(nouveauUtilisateur.getRole());
		utilisateur.setClients(nouveauUtilisateur.getClients());
		
		return utilisateurRepository.save(utilisateur);
	}
	
	//DELETE
	public void supprimerUtil(Long id) {
		Utilisateur utilisateur = getUtilisateurById(id);
		utilisateurRepository.delete(utilisateur);
	}
	
	 
}
