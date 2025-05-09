package com.example.dentalnexus.database.dao.rendezvous;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.dentalnexus.model.rendezvous.RendezVous;

import java.util.List;

@Dao
public interface RendezVousDao {

    @Insert
    void insert(RendezVous rendezVous);

    @Update
    void update(RendezVous rendezVous);

    @Delete
    void delete(RendezVous rendezVous);

    @Query("SELECT * FROM rendezvous")
    LiveData<List<RendezVous>> getAllRendezVous();

    @Query("SELECT * FROM rendezvous WHERE id = :id")
    LiveData<RendezVous> getRendezVousById(int id);
}
