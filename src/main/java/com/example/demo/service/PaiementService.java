package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Paiement;
import com.example.demo.repository.PaiementRepository;

@Service
public class PaiementService {

	private PaiementRepository paiementRepository;
	
	//Ingection dependances
	public PaiementService(PaiementRepository paiementRepository) {
		this.paiementRepository = paiementRepository;
	}
	
	//ADD
	public Paiement ajouterPaie(Paiement paiement) {
		return paiementRepository.save(paiement);
	}
	//List
	public List<Paiement>getAllPaiement(){
		return paiementRepository.findAll();
	}
	//SEARCH
	public Paiement getPaiementById(Long id) {
		return paiementRepository.findById(id)
				.orElseThrow(() ->new RuntimeException ("Paiement Impossible"));	
		}
	
	//EDIT
	
	public Paiement modifierpaie(Long id , Paiement nouveaupae){
		Paiement paiement = getPaiementById(id);
		paiement.setFacture(nouveaupae.getFacture());
		paiement.setDatePaiement(nouveaupae.getDatePaiement());
		paiement.setMontant(nouveaupae.getMontant());
		paiement.setMethode(nouveaupae.getMethode());
		paiement.setReference(nouveaupae.getReference());
		return paiementRepository.save(paiement);
	}
	//DELETE
	public void supprimerPaie(Long id) {
		Paiement paiement=getPaiementById(id);
		 paiementRepository.delete(paiement);
	}
	
}
