package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LigneFacture;
import com.example.demo.repository.LigneFactureRepository;

@Service
public class LigneFactureService {
	
	private LigneFactureRepository ligneFactureRepository;
	
	public LigneFactureService(LigneFactureRepository ligneFactureRepository) {
		this.ligneFactureRepository =ligneFactureRepository;
	}
	
	//ADD
	
	public LigneFacture ajouterFacture(LigneFacture ligneFacture){
		return ligneFactureRepository.save(ligneFacture);
	}
	//LIST
	
	public List<LigneFacture>getAllLigneFacture(){
		return ligneFactureRepository.findAll();
		
	}
	//SEARCH
	public LigneFacture getLigneFactureById(Long id) {
		return ligneFactureRepository.findById(id).orElseThrow(() -> new RuntimeException("LigneFacture Introuvable"));
	}
	//EDIT
	public LigneFacture modifierLigneFacture(Long id, LigneFacture nouveauLigneFacture) {
		LigneFacture ligneFacture = getLigneFactureById(id);
		ligneFacture.setFacture(nouveauLigneFacture.getFacture());
		ligneFacture.setProduit(nouveauLigneFacture.getProduit());
		ligneFacture.setDescription(nouveauLigneFacture.getDescription());
		ligneFacture.setQuantite(nouveauLigneFacture.getQuantite());
		ligneFacture.setPrixUnitaire(nouveauLigneFacture.getPrixUnitaire());
		ligneFacture.setRemise(nouveauLigneFacture.getRemise());
		ligneFacture.setMontantTaxe(nouveauLigneFacture.getMontantTaxe());
		ligneFacture.setMontant(nouveauLigneFacture.getMontant());
		
		return ligneFactureRepository.save(ligneFacture);
	}

	//Delete
	
	public void supprimerLigneFacture(Long id) {
		LigneFacture ligneFacture = getLigneFactureById(id);
		 ligneFactureRepository.delete(ligneFacture);
	}
	

}
