package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureRepository;

@Service
public class FactureService {
	
	private FactureRepository factureRepository;
	
	public FactureService(FactureRepository factureRepository) {
		this.factureRepository = factureRepository;
	}
	
	public List<Facture>getAllFacture(){
		return factureRepository.findAll();
	}
	
	public Facture getFactureById(Long id) {
		return factureRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Facture Introuvable"));
	}
	
	
	
	public Facture ajouterFacture(Facture facture) {
		return factureRepository.save(facture);
	}
	
	public Facture modifierFacture(Long id , Facture nouveauFacture) {
		Facture facture = getFactureById(id);
		facture.setNumeroFacture(nouveauFacture.getNumeroFacture());
		facture.setDateFacture(nouveauFacture.getDateFacture());
		facture.setDateEcheance(nouveauFacture.getDateEcheance());
		facture.setClient(nouveauFacture.getClient());
		facture.setDevis(nouveauFacture.getDevis());
		facture.setSousTotal(nouveauFacture.getSousTotal());
		facture.setRemise(nouveauFacture.getRemise());
		facture.setTaxe(nouveauFacture.getTaxe());
		facture.setTotal(nouveauFacture.getRemise());
		facture.setStatut(nouveauFacture.getStatut());
		
		return factureRepository.save(facture);
	}
	
	public void  SupprimerFacture(Long id) {
		Facture facture = getFactureById(id);
		factureRepository.delete(facture);
	}

}
