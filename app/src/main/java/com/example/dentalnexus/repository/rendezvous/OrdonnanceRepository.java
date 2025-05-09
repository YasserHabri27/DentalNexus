package com.example.dentalnexus.repository.rendezvous;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.rendezvous.OrdonnanceDao;
import com.example.dentalnexus.model.rendezvous.Ordonnance;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrdonnanceRepository {

    private final OrdonnanceDao ordonnanceDao;
    private final ExecutorService executorService;

    public OrdonnanceRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        ordonnanceDao = db.ordonnanceDao();  // Correct usage of DAO
        executorService = Executors.newSingleThreadExecutor();
    }


    public void insert(Ordonnance ordonnance) {
        executorService.execute(() -> ordonnanceDao.insert(ordonnance));
    }


    public void update(Ordonnance ordonnance) {
        executorService.execute(() -> ordonnanceDao.update(ordonnance));
    }


    public void delete(Ordonnance ordonnance) {
        executorService.execute(() -> ordonnanceDao.delete(ordonnance));
    }


    public LiveData<List<Ordonnance>> getOrdonnancesByConsultationId(int consultationId) {
        return ordonnanceDao.getOrdonnancesByConsultationId(consultationId);
    }


    public LiveData<Ordonnance> getOrdonnanceById(int id) {
        return ordonnanceDao.getOrdonnanceById(id);
    }
}
