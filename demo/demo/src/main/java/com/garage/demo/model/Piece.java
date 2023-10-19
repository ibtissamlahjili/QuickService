package com.garage.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private double price;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    @ManyToMany(mappedBy = "pieces")
    private Set<Commande> commandes = new HashSet<>();

    public Piece() {
    }

    public Piece(String nom, String description, Double prix) {
        super();
        this.name = nom;
        this.description = description;
        this.price = price;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public byte[] getImage() {
        return image;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description="
                + description + ", price=" + price + ", image="
                + image + "]";
    }
}