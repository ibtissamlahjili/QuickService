package com.garage.demo.model;

import lombok.Data;

import javax.persistence.*;



@Entity
@Data
public class Vehicule {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String marque;
    private String model;
    private String matricule;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDtls user;
}
