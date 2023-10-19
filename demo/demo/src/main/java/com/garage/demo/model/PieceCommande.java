package com.garage.demo.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "piece_commande")

public class PieceCommande implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "piece_id")
    private Piece piece;

    @Id
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @Column(name = "quantite")
    private int quantite;

    // Getters, setters et autres méthodes
}

