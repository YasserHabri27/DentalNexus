package com.example.dentalnexus.repository.rendezvous;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.rendezvous.RappelNotificationDao;
import com.example.dentalnexus.model.rendezvous.RappelNotification;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RappelNotificationRepository {

    private final RappelNotificationDao rappelNotificationDao;
    private final ExecutorService executorService;

    public RappelNotificationRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        rappelNotificationDao = db.rappelNotificationDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(RappelNotification rappel) {
        executorService.execute(() -> rappelNotificationDao.insert(rappel));
    }

    public void update(RappelNotification rappel) {
        executorService.execute(() -> rappelNotificationDao.update(rappel));
    }

    public void delete(RappelNotification rappel) {
        executorService.execute(() -> rappelNotificationDao.delete(rappel));
    }

    public LiveData<List<RappelNotification>> getRappelsByRendezVousId(int rendezVousId) {
        MutableLiveData<List<RappelNotification>> data = new MutableLiveData<>();
        executorService.execute(() -> {
            List<RappelNotification> rappels = rappelNotificationDao.getRappelNotificationsByRendezVousId(rendezVousId);
            data.postValue(rappels);
        });
        return data;
    }

    public LiveData<RappelNotification> getRappelById(int id) {
        MutableLiveData<RappelNotification> data = new MutableLiveData<>();
        executorService.execute(() -> {
            RappelNotification rappel = rappelNotificationDao.getRappelNotificationById(id);
            data.postValue(rappel);
        });
        return data;
    }
}

