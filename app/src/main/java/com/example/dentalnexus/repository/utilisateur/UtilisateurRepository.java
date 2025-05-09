package com.example.dentalnexus.repository.utilisateur;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.utilisateur.UtilisateurDao;
import com.example.dentalnexus.model.utilisateur.Utilisateur;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UtilisateurRepository {

    private final UtilisateurDao utilisateurDao;
    private final ExecutorService executorService;

    public UtilisateurRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        utilisateurDao = db.utilisateurDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Utilisateur utilisateur) {
        executorService.execute(() -> utilisateurDao.insert(utilisateur));
    }

    public void update(Utilisateur utilisateur) {
        executorService.execute(() -> utilisateurDao.update(utilisateur));
    }

    public void delete(Utilisateur utilisateur) {
        executorService.execute(() -> utilisateurDao.delete(utilisateur));
    }

    public LiveData<Utilisateur> getUtilisateurById(int id) {
        MutableLiveData<Utilisateur> data = new MutableLiveData<>();
        executorService.execute(() -> data.postValue(utilisateurDao.getUtilisateurById(id)));
        return data;
    }

    public LiveData<Utilisateur> getUtilisateurByEmail(String email) {
        MutableLiveData<Utilisateur> data = new MutableLiveData<>();
        executorService.execute(() -> data.postValue(utilisateurDao.getUtilisateurByEmail(email)));
        return data;
    }

    public LiveData<List<Utilisateur>> getAllUtilisateurs() {
        MutableLiveData<List<Utilisateur>> data = new MutableLiveData<>();
        executorService.execute(() -> data.postValue(utilisateurDao.getAllUtilisateurs()));
        return data;
    }
}
