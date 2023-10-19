package com.garage.demo.Enum;

public enum Statut {

    EN_ATTENTE("en_attente"),
    EN_COURS("en_cours"),
    LIVREE("livree");

    private final String value;

    Statut(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}