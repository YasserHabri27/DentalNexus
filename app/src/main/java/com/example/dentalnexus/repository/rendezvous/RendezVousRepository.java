package com.example.dentalnexus.repository.rendezvous;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.rendezvous.RendezVousDao;
import com.example.dentalnexus.model.rendezvous.RendezVous;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RendezVousRepository {

    private final RendezVousDao rendezVousDao;
    private final ExecutorService executorService;

    public RendezVousRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        rendezVousDao = db.rendezVousDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(RendezVous rendezVous) {
        executorService.execute(() -> rendezVousDao.insert(rendezVous));
    }

    public void update(RendezVous rendezVous) {
        executorService.execute(() -> rendezVousDao.update(rendezVous));
    }

    public void delete(RendezVous rendezVous) {
        executorService.execute(() -> rendezVousDao.delete(rendezVous));
    }

    public LiveData<List<RendezVous>> getAllRendezVous() {
        return rendezVousDao.getAllRendezVous();
    }

    public LiveData<RendezVous> getRendezVousById(int id) {
        return rendezVousDao.getRendezVousById(id);
    }
}
