package com.example.dentalnexus.model.rendezvous;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "consultation")
public class Consultation {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int rendezVousId;

    private String details;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRendezVousId() {
        return rendezVousId;
    }

    public void setRendezVousId(int rendezVousId) {
        this.rendezVousId = rendezVousId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
