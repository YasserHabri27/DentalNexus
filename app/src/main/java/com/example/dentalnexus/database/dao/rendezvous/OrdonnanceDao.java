package com.example.dentalnexus.database.dao.rendezvous;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.dentalnexus.model.rendezvous.Ordonnance;

import java.util.List;

@Dao
public interface OrdonnanceDao {

    @Insert
    void insert(Ordonnance ordonnance);

    @Update
    void update(Ordonnance ordonnance);

    @Delete
    void delete(Ordonnance ordonnance);

    @Query("SELECT * FROM ordonnances WHERE consultationId = :consultationId")
    LiveData<List<Ordonnance>> getOrdonnancesByConsultationId(int consultationId);

    @Query("SELECT * FROM ordonnances WHERE id = :id")
    LiveData<Ordonnance> getOrdonnanceById(int id);
}
