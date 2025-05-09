package com.example.dentalnexus.database.dao.patient;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.patient.Patient;
import java.util.List;

@Dao
public interface PatientDao {

    @Insert
    void insert(Patient patient);

    @Update
    void update(Patient patient);

    @Delete
    void delete(Patient patient);

    @Query("SELECT * FROM patients")
    List<Patient> getAllPatients();

    @Query("SELECT * FROM patients WHERE id = :id")
    Patient getPatientById(int id);
}
