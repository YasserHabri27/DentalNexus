package com.example.dentalnexus.model.finances;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.example.dentalnexus.utils.Converters;

@Entity(tableName = "facture")
@TypeConverters(Converters.class)
public class Facture {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private double montant;
    private String description;
    private String dateEmission;

    private ModePaiement modePaiement;

    private StatutFacture statut;

    public Facture(double montant, String description, String dateEmission, ModePaiement modePaiement, StatutFacture statut) {
        this.montant = montant;
        this.description = description;
        this.dateEmission = dateEmission;
        this.modePaiement = modePaiement;
        this.statut = statut;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDateEmission() { return dateEmission; }
    public void setDateEmission(String dateEmission) { this.dateEmission = dateEmission; }

    public ModePaiement getModePaiement() { return modePaiement; }
    public void setModePaiement(ModePaiement modePaiement) { this.modePaiement = modePaiement; }

    public StatutFacture getStatut() { return statut; }
    public void setStatut(StatutFacture statut) { this.statut = statut; }
}
