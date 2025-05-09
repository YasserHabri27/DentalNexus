package com.example.dentalnexus.model.patient;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(tableName = "dossier_medical", foreignKeys = @ForeignKey(entity = Patient.class, parentColumns = "id", childColumns = "patientId"))
public class DossierMedical {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int patientId;
    private String pathologie;
    private String traitementsEnCours;
    private String allergies;


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

    public String getPathologie() {
        return pathologie;
    }

    public void setPathologie(String pathologie) {
        this.pathologie = pathologie;
    }

    public String getTraitementsEnCours() {
        return traitementsEnCours;
    }

    public void setTraitementsEnCours(String traitementsEnCours) {
        this.traitementsEnCours = traitementsEnCours;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
