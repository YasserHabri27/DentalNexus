package com.example.dentalnexus.model.utilisateur;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "auth_tokens")
public class AuthToken {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String token;
    private String utilisateurId;
    private String dateExpiration;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(String utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
