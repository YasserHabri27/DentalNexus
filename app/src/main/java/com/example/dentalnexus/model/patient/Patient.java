package com.example.dentalnexus.model.patient;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
