package com.example.dentalnexus.database.dao.medicaments;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import com.example.dentalnexus.model.medicaments.Medicament;
import java.util.List;

@Dao
public interface MedicamentDao {

    @Insert
    void insert(Medicament medicament);

    @Update
    void update(Medicament medicament);

    @Delete
    void delete(Medicament medicament);

    @Query("DELETE FROM medicaments WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT * FROM medicaments")
    LiveData<List<Medicament>> getAllMedicaments();
    @Query("SELECT * FROM medicaments WHERE id = :id")
    LiveData<Medicament> getMedicamentById(int id);
}
