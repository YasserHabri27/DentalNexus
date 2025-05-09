package com.example.dentalnexus.database.dao.patient;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.dentalnexus.model.patient.DossierMedical;

import java.util.List;

@Dao
public interface DossierMedicalDao {

    @Insert
    void insert(DossierMedical dossierMedical);

    @Update
    void update(DossierMedical dossierMedical);

    @Delete
    void delete(DossierMedical dossierMedical);

    @Query("SELECT * FROM dossier_medical WHERE patientId = :patientId")
    LiveData<List<DossierMedical>> getDossiersByPatientId(int patientId);

    @Query("SELECT * FROM dossier_medical WHERE id = :id")
    LiveData<DossierMedical> getDossierById(int id);

    @Query("SELECT * FROM dossier_medical")
    LiveData<List<DossierMedical>> getAllDossiers();
}
