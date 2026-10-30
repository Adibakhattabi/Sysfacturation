package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Devis;
import com.example.demo.repository.DevisRepository;

@Service
public class DevisService {
	
	private DevisRepository devisRepository;
	
	//Ingection dependances
	
	public DevisService(DevisRepository devisRepository) {
		this.devisRepository = devisRepository;
	}
	
	//1-Liste Devis
	
	public List<Devis>getAllDevis(){
		return devisRepository.findAll();
	}
	
	//2.Ajouter Devis
	
	public Devis ajouterdevis(Devis devis) {
		return devisRepository.save(devis);
	}
	//3.Rechercher Devis
	public Devis getDevisById(Long Id) {
		return devisRepository.findById(Id)
				.orElseThrow(() -> new RuntimeException("Devis Introuvable"));
				}
	//4.Modifier Devis 
	public Devis modifierDevis(Long id , Devis nouveauDevis) {
		Devis devis = getDevisById(id);
		devis.setNumeroDevis(nouveauDevis.getNumeroDevis());
		devis.setDateDevis(nouveauDevis.getDateDevis());
		devis.setDateValidite(nouveauDevis.getDateValidite());
		devis.setClient(nouveauDevis.getClient());
		devis.setSousTotal(nouveauDevis.getSousTotal());
		devis.setRemise(nouveauDevis.getRemise());
		devis.setTaxe(nouveauDevis.getTaxe());
		devis.setTotal(nouveauDevis.getTotal());
		devis.setStatut(nouveauDevis.getStatut());
		
		return devisRepository.save(devis);
	}
	
	//5.Supprimer Devis
	
	public void SupprimerDevis(Long id) {
		Devis devis =getDevisById(id);
		 devisRepository.delete(devis);
	}
}
