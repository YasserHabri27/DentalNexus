package com.example.dentalnexus.repository.finances;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.dao.finances.CaisseDao;
import com.example.dentalnexus.model.finances.Caisse;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CaisseRepository {

    private CaisseDao caisseDao;
    private Executor executor;

    public CaisseRepository(CaisseDao caisseDao) {
        this.caisseDao = caisseDao;
        executor = Executors.newSingleThreadExecutor();
    }


    public void insert(Caisse caisse) {
        executor.execute(() -> caisseDao.insert(caisse));
    }


    public void update(Caisse caisse) {
        executor.execute(() -> caisseDao.update(caisse));
    }


    public void delete(Caisse caisse) {
        executor.execute(() -> caisseDao.delete(caisse));
    }


    public LiveData<List<Caisse>> getAllCaisses() {
        return caisseDao.getAllCaisses();
    }


    public LiveData<Caisse> getCaisseById(int id) {
        return caisseDao.getCaisseById(id);
    }


    public LiveData<Double> getTotalCaisse() {
        return caisseDao.getTotalCaisse();
    }
}
