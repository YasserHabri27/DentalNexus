package com.example.dentalnexus.repository.medicaments;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.medicaments.PrescriptionDao;
import com.example.dentalnexus.model.medicaments.Prescription;

import java.util.List;

public class PrescriptionRepository {

    private final PrescriptionDao prescriptionDao;

    public PrescriptionRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        prescriptionDao = db.prescriptionDao();
    }

    public void insert(Prescription prescription) {
        AppDatabase.databaseWriteExecutor.execute(() -> prescriptionDao.insert(prescription));
    }

    public void update(Prescription prescription) {
        AppDatabase.databaseWriteExecutor.execute(() -> prescriptionDao.update(prescription));
    }

    public void delete(Prescription prescription) {
        AppDatabase.databaseWriteExecutor.execute(() -> prescriptionDao.delete(prescription));
    }

    public LiveData<List<Prescription>> getPrescriptionsByMedicamentId(int medicamentId) {
        return prescriptionDao.getPrescriptionsByMedicamentId(medicamentId);
    }

    public LiveData<List<Prescription>> getAllPrescriptions() {
        return prescriptionDao.getAllPrescriptions();
    }
}
