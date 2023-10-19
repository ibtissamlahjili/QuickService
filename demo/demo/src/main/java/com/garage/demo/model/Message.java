package com.garage.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contenu;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDtls user;

    public Message() {
    }
}
