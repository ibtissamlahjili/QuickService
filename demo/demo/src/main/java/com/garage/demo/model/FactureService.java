package com.garage.demo.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("SERVICE")
public class FactureService extends Facture{


    @OneToOne
    @JoinColumn(name = "RDV_id")
    private com.garage.demo.model.RDV service;
}
