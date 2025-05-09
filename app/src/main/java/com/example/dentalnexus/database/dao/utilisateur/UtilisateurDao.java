package com.example.dentalnexus.database.dao.utilisateur;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import com.example.dentalnexus.model.utilisateur.Utilisateur;
import java.util.List;

@Dao
public interface UtilisateurDao {

    @Insert
    void insert(Utilisateur utilisateur);

    @Update
    void update(Utilisateur utilisateur);

    @Delete
    void delete(Utilisateur utilisateur);

    @Query("SELECT * FROM utilisateurs WHERE id = :id")
    Utilisateur getUtilisateurById(int id);

    @Query("SELECT * FROM utilisateurs WHERE email = :email")
    Utilisateur getUtilisateurByEmail(String email);

    @Query("SELECT * FROM utilisateurs")
    List<Utilisateur> getAllUtilisateurs();
}
