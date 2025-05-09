package com.example.dentalnexus.model.medicaments;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "prescriptions", foreignKeys = @ForeignKey(entity = Medicament.class, parentColumns = "id", childColumns = "medicamentId"))
public class Prescription {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int medicamentId;
    private int quantity;
    private String instructions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
