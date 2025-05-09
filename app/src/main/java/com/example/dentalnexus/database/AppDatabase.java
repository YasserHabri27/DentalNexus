package com.example.dentalnexus.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.dentalnexus.database.dao.finances.CaisseDao;
import com.example.dentalnexus.database.dao.finances.FactureDao;
import com.example.dentalnexus.database.dao.finances.SituationFinanciereDao;
import com.example.dentalnexus.database.dao.medicaments.MedicamentDao;
import com.example.dentalnexus.database.dao.medicaments.PrescriptionDao;
import com.example.dentalnexus.database.dao.patient.DossierMedicalDao;
import com.example.dentalnexus.database.dao.patient.HistoriqueMedicaleDao;
import com.example.dentalnexus.database.dao.patient.PatientDao;
import com.example.dentalnexus.database.dao.rendezvous.ConsultationDao;
import com.example.dentalnexus.database.dao.rendezvous.OrdonnanceDao;
import com.example.dentalnexus.database.dao.rendezvous.RappelNotificationDao;
import com.example.dentalnexus.database.dao.rendezvous.RendezVousDao;
import com.example.dentalnexus.database.dao.rendezvous.StatutRendezVousDao;
import com.example.dentalnexus.database.dao.utilisateur.AuthTokenDao;
import com.example.dentalnexus.database.dao.utilisateur.UtilisateurDao;
import com.example.dentalnexus.model.finances.Caisse;
import com.example.dentalnexus.model.finances.Facture;
import com.example.dentalnexus.model.finances.SituationFinanciere;
import com.example.dentalnexus.model.medicaments.Medicament;
import com.example.dentalnexus.model.medicaments.Prescription;
import com.example.dentalnexus.model.patient.DossierMedical;
import com.example.dentalnexus.model.patient.HistoriqueMedical;
import com.example.dentalnexus.model.patient.Patient;
import com.example.dentalnexus.model.rendezvous.Consultation;
import com.example.dentalnexus.model.rendezvous.Ordonnance;
import com.example.dentalnexus.model.rendezvous.RappelNotification;
import com.example.dentalnexus.model.rendezvous.RendezVous;
import com.example.dentalnexus.model.rendezvous.StatutRendezVous;
import com.example.dentalnexus.model.utilisateur.AuthToken;
import com.example.dentalnexus.model.utilisateur.Utilisateur;
import com.example.dentalnexus.utils.Converters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(
        entities = {
                Patient.class,
                DossierMedical.class,
                HistoriqueMedical.class,
                RendezVous.class,
                Consultation.class,
                Ordonnance.class,
                RappelNotification.class,
                StatutRendezVous.class,
                Utilisateur.class,
                AuthToken.class,
                Medicament.class,
                Prescription.class,
                Caisse.class,
                Facture.class,
                SituationFinanciere.class,
        },
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract PatientDao patientDao();
    public abstract DossierMedicalDao dossierMedicalDao();
    public abstract HistoriqueMedicaleDao historiqueMedicaleDao();
    public abstract RendezVousDao rendezVousDao();
    public abstract ConsultationDao consultationDao();
    public abstract OrdonnanceDao ordonnanceDao();
    public abstract RappelNotificationDao rappelNotificationDao();
    public abstract StatutRendezVousDao statutRendezVousDao();
    public abstract UtilisateurDao utilisateurDao();
    public abstract AuthTokenDao authTokenDao();
    public abstract MedicamentDao medicamentDao();
    public abstract PrescriptionDao prescriptionDao();
    public abstract CaisseDao caisseDao();
    public abstract FactureDao factureDao();
    public abstract SituationFinanciereDao situationFinanciereDao();

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "dentalnexus_db"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
