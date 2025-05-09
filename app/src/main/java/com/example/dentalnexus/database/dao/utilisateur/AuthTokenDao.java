package com.example.dentalnexus.database.dao.utilisateur;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.utilisateur.AuthToken;

@Dao
public interface AuthTokenDao {

    @Insert
    void insert(AuthToken authToken);

    @Update
    void update(AuthToken authToken);

    @Delete
    void delete(AuthToken authToken);

    @Query("SELECT * FROM auth_tokens WHERE utilisateurId = :utilisateurId")
    AuthToken getAuthTokenByUtilisateurId(String utilisateurId);

    @Query("SELECT * FROM auth_tokens WHERE id = :id")
    AuthToken getAuthTokenById(int id);
}
