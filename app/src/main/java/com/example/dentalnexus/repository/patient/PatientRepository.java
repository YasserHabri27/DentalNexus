package com.example.dentalnexus.repository.patient;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.patient.PatientDao;
import com.example.dentalnexus.model.patient.Patient;

import java.util.List;

public class PatientRepository {

    private final PatientDao patientDao;

    public PatientRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        patientDao = db.patientDao();
    }

    public void insert(Patient patient) {
        AppDatabase.databaseWriteExecutor.execute(() -> patientDao.insert(patient));
    }

    public void update(Patient patient) {
        AppDatabase.databaseWriteExecutor.execute(() -> patientDao.update(patient));
    }

    public void delete(Patient patient) {
        AppDatabase.databaseWriteExecutor.execute(() -> patientDao.delete(patient));
    }

    public LiveData<List<Patient>> getAllPatients() {
        MutableLiveData<List<Patient>> data = new MutableLiveData<>();
        AppDatabase.databaseWriteExecutor.execute(() -> data.postValue(patientDao.getAllPatients()));
        return data;
    }

    public LiveData<Patient> getPatientById(int id) {
        MutableLiveData<Patient> data = new MutableLiveData<>();
        AppDatabase.databaseWriteExecutor.execute(() -> data.postValue(patientDao.getPatientById(id)));
        return data;
    }
}
