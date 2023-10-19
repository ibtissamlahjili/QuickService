package com.garage.demo.model;

import javax.persistence.*;

@Entity
public class MyCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String name;
    private String description;
    private double price;


    private String imageName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDtls user;
    public MyCommande() {
    }
    public MyCommande(Long id,String nom, String description, Double price, String imageName) {
        super();
        this.id = id;
        this.name = nom;
        this.description = description;
        this.price = price;
        this.imageName=imageName;

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

    public UserDtls getUser() {
        return user;
    }

    public void setUser(UserDtls user) {
        this.user = user;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }



}