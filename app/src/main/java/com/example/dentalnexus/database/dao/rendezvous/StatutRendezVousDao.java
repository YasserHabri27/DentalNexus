package com.example.dentalnexus.database.dao.rendezvous;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.rendezvous.StatutRendezVous;
import java.util.List;

@Dao
public interface StatutRendezVousDao {

    @Insert
    void insert(StatutRendezVous statutRendezVous);

    @Update
    void update(StatutRendezVous statutRendezVous);

    @Delete
    void delete(StatutRendezVous statutRendezVous);

    @Query("SELECT * FROM statut_rendezvous")
    List<StatutRendezVous> getAllStatutRendezVous();

    @Query("SELECT * FROM statut_rendezvous WHERE id = :id")
    StatutRendezVous getStatutRendezVousById(int id);
}
