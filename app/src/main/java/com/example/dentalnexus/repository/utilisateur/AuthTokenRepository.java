package com.example.dentalnexus.repository.utilisateur;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.dentalnexus.database.AppDatabase;
import com.example.dentalnexus.database.dao.utilisateur.AuthTokenDao;
import com.example.dentalnexus.model.utilisateur.AuthToken;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthTokenRepository {

    private final AuthTokenDao authTokenDao;
    private final ExecutorService executorService;

    public AuthTokenRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        authTokenDao = db.authTokenDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(AuthToken token) {
        executorService.execute(() -> authTokenDao.insert(token));
    }

    public void update(AuthToken token) {
        executorService.execute(() -> authTokenDao.update(token));
    }

    public void delete(AuthToken token) {
        executorService.execute(() -> authTokenDao.delete(token));
    }

    public LiveData<AuthToken> getAuthTokenByUtilisateurId(String utilisateurId) {
        MutableLiveData<AuthToken> data = new MutableLiveData<>();
        executorService.execute(() -> data.postValue(authTokenDao.getAuthTokenByUtilisateurId(utilisateurId)));
        return data;
    }

    public LiveData<AuthToken> getAuthTokenById(int id) {
        MutableLiveData<AuthToken> data = new MutableLiveData<>();
        executorService.execute(() -> data.postValue(authTokenDao.getAuthTokenById(id)));
        return data;
    }
}
