package com.example.dentalnexus.model.rendezvous;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(
        tableName = "ordonnances",
        foreignKeys = @ForeignKey(entity = Consultation.class, parentColumns = "id", childColumns = "consultationId")
)
public class Ordonnance {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int consultationId;
    private String medicament;
    private String dosage;
    private String instructions;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public String getMedicament() {
        return medicament;
    }

    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
