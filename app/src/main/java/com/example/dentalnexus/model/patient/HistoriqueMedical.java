package com.example.dentalnexus.model.patient;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(tableName = "historique_medical", foreignKeys = @ForeignKey(entity = Patient.class, parentColumns = "id", childColumns = "patientId"))
public class HistoriqueMedical {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int patientId;
    private String date;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
