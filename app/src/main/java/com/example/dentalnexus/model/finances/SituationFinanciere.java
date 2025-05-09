package com.example.dentalnexus.model.finances;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "situation_financiere")
public class SituationFinanciere {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double soldeTotal;
    private double dettes;
    private double recettes;

    private int patient_id;

    public SituationFinanciere(double soldeTotal, double dettes, double recettes, int patient_id) {
        this.soldeTotal = soldeTotal;
        this.dettes = dettes;
        this.recettes = recettes;
        this.patient_id = patient_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSoldeTotal() {
        return soldeTotal;
    }

    public void setSoldeTotal(double soldeTotal) {
        this.soldeTotal = soldeTotal;
    }

    public double getDettes() {
        return dettes;
    }

    public void setDettes(double dettes) {
        this.dettes = dettes;
    }

    public double getRecettes() {
        return recettes;
    }

    public void setRecettes(double recettes) {
        this.recettes = recettes;
    }

    public int getPatientId() {
        return patient_id;
    }

    public void setPatientId(int patient_id) {
        this.patient_id = patient_id;
    }
}
