package com.example.dentalnexus.database.dao.rendezvous;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import com.example.dentalnexus.model.rendezvous.RappelNotification;
import java.util.List;

@Dao
public interface RappelNotificationDao {

    @Insert
    void insert(RappelNotification rappelNotification);

    @Update
    void update(RappelNotification rappelNotification);

    @Delete
    void delete(RappelNotification rappelNotification);

    @Query("SELECT * FROM rappel_notifications WHERE rendezVousId = :rendezVousId")
    List<RappelNotification> getRappelNotificationsByRendezVousId(int rendezVousId);

    @Query("SELECT * FROM rappel_notifications WHERE id = :id")
    RappelNotification getRappelNotificationById(int id);
}
