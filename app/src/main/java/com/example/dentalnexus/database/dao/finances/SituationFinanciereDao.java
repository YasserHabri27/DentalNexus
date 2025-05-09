package com.example.dentalnexus.database.dao.finances;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.finances.SituationFinanciere;
import java.util.List;

@Dao
public interface SituationFinanciereDao {

    @Insert
    void insert(SituationFinanciere situationFinanciere);

    @Update
    void update(SituationFinanciere situationFinanciere);

    @Delete
    void delete(SituationFinanciere situationFinanciere);

    @Query("SELECT * FROM situation_financiere WHERE patient_id = :patientId")
    SituationFinanciere getSituationFinanciereByPatientId(int patientId);

    @Query("SELECT * FROM situation_financiere")
    List<SituationFinanciere> getAllSituationsFinancieres();
}
