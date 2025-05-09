package com.example.dentalnexus.repository.finances;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.dentalnexus.database.dao.finances.FactureDao;
import com.example.dentalnexus.model.finances.Facture;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FactureRepository {

    private FactureDao factureDao;
    private Executor executor;

    public FactureRepository(FactureDao factureDao) {
        this.factureDao = factureDao;
        this.executor = Executors.newSingleThreadExecutor();
    }


    public void insert(Facture facture) {
        executor.execute(() -> factureDao.insert(facture));
    }


    public void update(Facture facture) {
        executor.execute(() -> factureDao.update(facture));
    }


    public void delete(Facture facture) {
        executor.execute(() -> factureDao.delete(facture));
    }


    public LiveData<List<Facture>> getAllFactures() {
        return factureDao.getAllFactures();
    }


    public LiveData<Facture> getFactureById(int id) {
        return factureDao.getFactureById(id);
    }


    public LiveData<List<Facture>> getFacturesByStatut(String statut) {
        return factureDao.getFacturesByStatut(statut);
    }


    public LiveData<Double> getTotalFactures() {
        return factureDao.getTotalFactures();
    }
}
