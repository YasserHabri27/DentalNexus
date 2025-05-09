package com.example.dentalnexus.model.rendezvous;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rendezvous")
public class RendezVous {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String patientId;
    private String dateHeure;
    private String statut;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
