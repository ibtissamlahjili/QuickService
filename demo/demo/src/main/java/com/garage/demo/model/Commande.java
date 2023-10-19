package com.garage.demo.model;

import com.garage.demo.Enum.Statut;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "piece_commande",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "piece_id")
    )
    private Set<Piece> pieces = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDtls user;

    @OneToOne(mappedBy = "commande")
    private FactureCommande factureCommande;

}
