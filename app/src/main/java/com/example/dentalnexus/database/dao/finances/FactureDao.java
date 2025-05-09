package com.example.dentalnexus.database.dao.finances;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.dentalnexus.model.finances.Facture;

import java.util.List;

@Dao
public interface FactureDao {

    @Insert
    void insert(Facture facture);

    @Update
    void update(Facture facture);

    @Delete
    void delete(Facture facture);

    @Query("SELECT * FROM facture")
    LiveData<List<Facture>> getAllFactures();

    @Query("SELECT * FROM facture WHERE id = :id")
    LiveData<Facture> getFactureById(int id);

    @Query("SELECT * FROM facture WHERE statut = :statut")
    LiveData<List<Facture>> getFacturesByStatut(String statut);

    @Query("SELECT SUM(montant) FROM facture")
    LiveData<Double> getTotalFactures();
}
