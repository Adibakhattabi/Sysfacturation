
package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ligne_facture")
public class LigneFacture {

    // Clé primaire
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ligne_facture")
    private Long idLigneFacture;

    // Relation avec Facture
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_facture", nullable = false)
    private Facture facture;

    // Relation avec Produit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit produit;

    // Attributs
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "quantite", precision = 12, scale = 3,
            nullable = false)
    private BigDecimal quantite;

    @Column(name = "prix_unitaire", precision = 12, scale = 2,
            nullable = false)
    private BigDecimal prixUnitaire;

    @Column(name = "remise", precision = 5, scale = 2)
    private BigDecimal remise;

    @Column(name = "taux_taxe", precision = 5, scale = 2)
    private BigDecimal tauxTaxe;

    @Column(name = "montant_taxe", precision = 12, scale = 2)
    private BigDecimal montantTaxe;

    @Column(name = "montant", precision = 12, scale = 2)
    private BigDecimal montant;

    // Constructeur vide obligatoire pour JPA
    public LigneFacture() {
    }

    // Getters et Setters

    public Long getIdLigneFacture() {
        return idLigneFacture;
    }

    public void setIdLigneFacture(Long idLigneFacture) {
        this.idLigneFacture = idLigneFacture;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public BigDecimal getTauxTaxe() {
        return tauxTaxe;
    }

    public void setTauxTaxe(BigDecimal tauxTaxe) {
        this.tauxTaxe = tauxTaxe;
    }

    public BigDecimal getMontantTaxe() {
        return montantTaxe;
    }

    public void setMontantTaxe(BigDecimal montantTaxe) {
        this.montantTaxe = montantTaxe;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
