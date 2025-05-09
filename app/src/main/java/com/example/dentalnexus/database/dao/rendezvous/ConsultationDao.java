package com.example.dentalnexus.database.dao.rendezvous;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;

import com.example.dentalnexus.model.rendezvous.Consultation;

import java.util.List;

@Dao
public interface ConsultationDao {

    @Insert
    void insert(Consultation consultation);

    @Update
    void update(Consultation consultation);

    @Delete
    void delete(Consultation consultation);

    @Query("SELECT * FROM consultation WHERE rendezVousId = :rendezVousId")
    LiveData<List<Consultation>> getConsultationsByRendezVousId(int rendezVousId);

    @Query("SELECT * FROM consultation WHERE id = :id")
    LiveData<Consultation> getConsultationById(int id);
}
