package com.example.dentalnexus.model.rendezvous;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "statut_rendezvous")
public class StatutRendezVous {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String statut;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
