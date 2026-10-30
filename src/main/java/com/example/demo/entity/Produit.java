
package com.example.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produit")
public class Produit {

    // Attributs

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit")
    private Long idProduit;

    @Column(name = "nomp", nullable = false)
    private String nomp;

    @Column(name = "description")
    private String description;

    @Column(name = "quantite_stock")
    private Integer quantiteStock;

    @Column(name = "prix_unitaire", nullable = false,
            precision = 12, scale = 2)
    private BigDecimal prixUnitaire;

    @Column(name = "remise", precision = 5, scale = 2)
    private BigDecimal remise;

    @Column(name = "taux_taxe", precision = 5, scale = 2)
    private BigDecimal tauxTaxe;

    // Constructeur vide obligatoire pour JPA

    public Produit() {
    }

    // Getters et Setters

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(Integer quantiteStock) {
        this.quantiteStock = quantiteStock;
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
}
