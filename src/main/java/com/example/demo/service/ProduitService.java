package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Produit;
import com.example.demo.repository.ProduitRepository;


@Service
public class ProduitService {

	private ProduitRepository produitRepository;

	//Ingection des dependances 
	public ProduitService(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;
		
	}
	
	//1.list all products
	
	public List<Produit>getAllProduits(){
		return produitRepository.findAll();
	}
	
	 // 2. search client par ID
	
	public Produit getProduitById(Long id) {
		return produitRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Produit Introuvable"));
	}
	//3.add product
	
	 public Produit ajouterProduit(Produit produit){
		 return produitRepository.save(produit);
	 }
	 //4.Edit Product
	 
	 public Produit modifierProduit(Long id , Produit nouveauProduit) {
		 	Produit produit =getProduitById(id);
		 	produit.setNomp(nouveauProduit.getNomp());
		 	produit.setDescription(nouveauProduit.getDescription());
		 	produit.setQuantiteStock(nouveauProduit.getQuantiteStock());
		 	produit.setPrixUnitaire(nouveauProduit.getPrixUnitaire());
		 	produit.setRemise(nouveauProduit.getRemise());
		 	produit.setTauxTaxe(nouveauProduit.getTauxTaxe());
		 	
		 	 return produitRepository.save(produit);
	 }
	 
	 //5.Delete product
	 
	 public void SupprimerProduit(Long id) {
		 Produit produit = getProduitById(id);
		 produitRepository.delete(produit);
	 }
	
}
