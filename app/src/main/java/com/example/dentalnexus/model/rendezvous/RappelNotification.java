package com.example.dentalnexus.model.rendezvous;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(tableName = "rappel_notifications", foreignKeys = @ForeignKey(entity = RendezVous.class, parentColumns = "id", childColumns = "rendezVousId"))
public class RappelNotification {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int rendezVousId;
    private String message;
    private String dateHeure;


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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(String dateHeure) {
        this.dateHeure = dateHeure;
    }
}
