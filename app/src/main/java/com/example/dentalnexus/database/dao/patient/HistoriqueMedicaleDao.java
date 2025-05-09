package com.example.dentalnexus.database.dao.patient;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.patient.HistoriqueMedical;
import java.util.List;

@Dao
public interface HistoriqueMedicaleDao {

    @Insert
    void insert(HistoriqueMedical historiqueMedical);

    @Update
    void update(HistoriqueMedical historiqueMedical);

    @Delete
    void delete(HistoriqueMedical historiqueMedical);

    @Query("SELECT * FROM historique_medical WHERE patientId = :patientId")
    List<HistoriqueMedical> getHistoriquesByPatientId(int patientId);

    @Query("SELECT * FROM historique_medical WHERE id = :id")
    HistoriqueMedical getHistoriqueById(int id);
}
