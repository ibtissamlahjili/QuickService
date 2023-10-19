package com.garage.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "facture_type")
public class Facture {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Id;
    private Double montant;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDtls user;
}
