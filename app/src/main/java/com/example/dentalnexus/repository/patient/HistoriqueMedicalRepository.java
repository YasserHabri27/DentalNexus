package com.example.dentalnexus.repository.patient;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.patient.HistoriqueMedicaleDao;
import com.example.dentalnexus.model.patient.HistoriqueMedical;

import java.util.List;

public class HistoriqueMedicalRepository {

    private final HistoriqueMedicaleDao historiqueDao;

    public HistoriqueMedicalRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        historiqueDao = db.historiqueMedicaleDao();
    }

    public void insert(HistoriqueMedical historique) {
        AppDatabase.databaseWriteExecutor.execute(() -> historiqueDao.insert(historique));
    }

    public void update(HistoriqueMedical historique) {
        AppDatabase.databaseWriteExecutor.execute(() -> historiqueDao.update(historique));
    }

    public void delete(HistoriqueMedical historique) {
        AppDatabase.databaseWriteExecutor.execute(() -> historiqueDao.delete(historique));
    }

    public LiveData<List<HistoriqueMedical>> getHistoriquesByPatientId(int patientId) {
        MutableLiveData<List<HistoriqueMedical>> data = new MutableLiveData<>();
        AppDatabase.databaseWriteExecutor.execute(() -> data.postValue(historiqueDao.getHistoriquesByPatientId(patientId)));
        return data;
    }

    public LiveData<HistoriqueMedical> getHistoriqueById(int id) {
        MutableLiveData<HistoriqueMedical> data = new MutableLiveData<>();
        AppDatabase.databaseWriteExecutor.execute(() -> data.postValue(historiqueDao.getHistoriqueById(id)));
        return data;
    }
}
