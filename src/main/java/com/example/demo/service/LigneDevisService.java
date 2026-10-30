package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LigneDevis;
import com.example.demo.repository.LigneDevisRepository;

@Service

public class LigneDevisService {

	private LigneDevisRepository ligneDevisRepository;
	
	public LigneDevisService(LigneDevisRepository ligneDevisRepository) {
		this.ligneDevisRepository = ligneDevisRepository;
	}
	
	public LigneDevis ajouterLigneDevis(LigneDevis ligneDevis) {
		return ligneDevisRepository.save(ligneDevis);
	}
	
	public List<LigneDevis>getAllLigneDevis(Long id){
		return ligneDevisRepository.findAll();
	}
	
	public LigneDevis getLigneDevisById(Long id ) {
		return ligneDevisRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("LigneDevis Introuvable"));
	}
	
	public LigneDevis modifierLigneDevis(Long id, LigneDevis nouveauLigneDevis) {
		LigneDevis ligneDevis = getLigneDevisById(id);
		ligneDevis.setDevis(nouveauLigneDevis.getDevis());
		ligneDevis.setProduit(nouveauLigneDevis.getProduit());
		ligneDevis.setDescription(nouveauLigneDevis.getDescription());
		ligneDevis.setQuantite(nouveauLigneDevis.getQuantite());
		ligneDevis.setPrixUnitaire(nouveauLigneDevis.getPrixUnitaire());
		ligneDevis.setRemise(nouveauLigneDevis.getRemise());
		ligneDevis.setTauxTaxe(nouveauLigneDevis.getTauxTaxe());
		ligneDevis.setMontant(nouveauLigneDevis.getMontant());
		return ligneDevisRepository.save(ligneDevis);

	}
	public void supprimerLigneDevis(Long id) {
		LigneDevis ligneDevis = getLigneDevisById(id);
		ligneDevisRepository.delete(ligneDevis);
	}
	
}
