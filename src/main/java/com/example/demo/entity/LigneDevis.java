package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "ligne_devis")

public class LigneDevis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ligne_devis")
    private Long idLigneDevis;

    // Relation avec Devis
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_devis", nullable = false)
    private Devis devis;

    // Relation avec Produit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @Column(name = "description")
    private String description;

    @Column(name = "quantite", precision = 12, scale = 3)
    private BigDecimal quantite;

    @Column(name = "prix_unitaire", precision = 12, scale = 2)
    private BigDecimal prixUnitaire;

    @Column(name = "remise", precision = 5, scale = 2)
    private BigDecimal remise;

    @Column(name = "taux_taxe", precision = 5, scale = 2)
    private BigDecimal tauxTaxe;

    @Column(name = "montant", precision = 12, scale = 2)
    private BigDecimal montant;

    // Constructeur vide pour JPA
    
    public LigneDevis() {
    }

    // Getters et Setters

    public Long getIdLigneDevis() {
        return idLigneDevis;
    }

    public void setIdLigneDevis(Long idLigneDevis) {
        this.idLigneDevis = idLigneDevis;
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
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

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}
