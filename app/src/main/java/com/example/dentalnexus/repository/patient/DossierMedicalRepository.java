package com.example.dentalnexus.repository.patient;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.patient.DossierMedicalDao;
import com.example.dentalnexus.model.patient.DossierMedical;

import java.util.List;

public class DossierMedicalRepository {

    private final DossierMedicalDao dossierDao;

    public DossierMedicalRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        dossierDao = db.dossierMedicalDao();
    }

    public void insert(DossierMedical dossier) {
        AppDatabase.databaseWriteExecutor.execute(() -> dossierDao.insert(dossier));
    }

    public void update(DossierMedical dossier) {
        AppDatabase.databaseWriteExecutor.execute(() -> dossierDao.update(dossier));
    }

    public void delete(DossierMedical dossier) {
        AppDatabase.databaseWriteExecutor.execute(() -> dossierDao.delete(dossier));
    }

    public LiveData<List<DossierMedical>> getDossiersByPatientId(int patientId) {
        return dossierDao.getDossiersByPatientId(patientId);
    }

    public LiveData<DossierMedical> getDossierById(int id) {
        return dossierDao.getDossierById(id);
    }

    public LiveData<List<DossierMedical>> getAllDossiers() {
        return dossierDao.getAllDossiers();
    }
}
