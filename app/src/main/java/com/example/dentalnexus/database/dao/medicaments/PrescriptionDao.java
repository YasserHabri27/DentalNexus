package com.example.dentalnexus.database.dao.medicaments;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dentalnexus.model.medicaments.Prescription;

import java.util.List;

@Dao
public interface PrescriptionDao {

    @Insert
    void insert(Prescription prescription);

    @Update
    void update(Prescription prescription);

    @Delete
    void delete(Prescription prescription);

    @Query("SELECT * FROM prescriptions WHERE medicamentId = :medicamentId")
    LiveData<List<Prescription>> getPrescriptionsByMedicamentId(int medicamentId);

    @Query("SELECT * FROM prescriptions")
    LiveData<List<Prescription>> getAllPrescriptions();
}
