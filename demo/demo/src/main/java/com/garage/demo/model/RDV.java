package com.garage.demo.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class RDV {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String date;
        private String heure;
        private String service;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserDtls user;





    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
