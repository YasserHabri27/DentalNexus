package com.example.dentalnexus.database.dao.finances;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.finances.Caisse;

import java.util.List;

@Dao
public interface CaisseDao {

    @Insert
    void insert(Caisse caisse);

    @Update
    void update(Caisse caisse);

    @Delete
    void delete(Caisse caisse);

    @Query("SELECT * FROM caisse")
    LiveData<List<Caisse>> getAllCaisses();

    @Query("SELECT * FROM caisse WHERE id = :id")
    LiveData<Caisse> getCaisseById(int id);

    @Query("SELECT SUM(solde) FROM caisse")
    LiveData<Double> getTotalCaisse();
}
