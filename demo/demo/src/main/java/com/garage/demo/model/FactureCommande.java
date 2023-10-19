package com.garage.demo.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("COMMANDE")
public class FactureCommande extends Facture {

    @OneToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;
}
