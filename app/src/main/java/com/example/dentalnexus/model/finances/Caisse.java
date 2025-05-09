package com.example.dentalnexus.model.finances;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "caisse")
public class Caisse {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double solde;

    public Caisse(double solde) {
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
