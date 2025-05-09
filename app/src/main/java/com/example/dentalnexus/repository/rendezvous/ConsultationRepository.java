package com.example.dentalnexus.repository.rendezvous;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.rendezvous.ConsultationDao;
import com.example.dentalnexus.model.rendezvous.Consultation;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsultationRepository {

    private final ConsultationDao consultationDao;
    private final ExecutorService executorService;

    public ConsultationRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        consultationDao = db.consultationDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Consultation consultation) {
        executorService.execute(() -> consultationDao.insert(consultation));
    }

    public void update(Consultation consultation) {
        executorService.execute(() -> consultationDao.update(consultation));
    }

    public void delete(Consultation consultation) {
        executorService.execute(() -> consultationDao.delete(consultation));
    }

    public LiveData<List<Consultation>> getConsultationsByRendezVousId(int rendezVousId) {
        return consultationDao.getConsultationsByRendezVousId(rendezVousId);
    }

    public LiveData<Consultation> getConsultationById(int id) {
        return consultationDao.getConsultationById(id);
    }
}
