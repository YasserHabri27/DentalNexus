package com.example.dentalnexus.model.medicaments;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medicaments")
public class Medicament {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nom;
    private String description;
    private String dosage;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
