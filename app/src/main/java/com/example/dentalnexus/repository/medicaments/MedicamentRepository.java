package com.example.dentalnexus.repository.medicaments;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.medicaments.MedicamentDao;
import com.example.dentalnexus.model.medicaments.Medicament;

import java.util.List;

public class MedicamentRepository {

    private MedicamentDao medicamentDao;
    private LiveData<List<Medicament>> allMedicaments;

    public MedicamentRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        medicamentDao = db.medicamentDao();
        allMedicaments = medicamentDao.getAllMedicaments();
    }

    public void insert(Medicament medicament) {
        AppDatabase.databaseWriteExecutor.execute(() -> medicamentDao.insert(medicament));
    }

    public void update(Medicament medicament) {
        AppDatabase.databaseWriteExecutor.execute(() -> medicamentDao.update(medicament));
    }

    public void delete(Medicament medicament) {
        AppDatabase.databaseWriteExecutor.execute(() -> medicamentDao.delete(medicament));
    }

    public LiveData<List<Medicament>> getAllMedicaments() {
        return allMedicaments;
    }

    public LiveData<Medicament> getMedicamentById(int id) {
        return medicamentDao.getMedicamentById(id);
    }
}
