package com.tpweb.models;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @ManyToOne
    //@JsonManagedReference
    private Equipe equipe;

    public Staff() {
        super();
    }

    public Staff(Long id, String nom, Equipe equipe) {
        super();
        this.id = id;
        this.nom = nom;
        this.equipe = equipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(
            Equipe equipe) {
        this.equipe = equipe;
    }
}

