package in.kesari.mvvmarchitecture.Profile;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.kesari.mvvmarchitecture.ProfileDao;
import in.kesari.mvvmarchitecture.UserDatabase;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private Webservice webservice;
    ProfileDao profileDao;
    private LiveData<List<Profile>> allProfile;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        profileDao = database.noteDao();
        allProfile = profileDao.getallProfile();
    }

    public void insert(Profile profile) {
        new InsertNoteAsyncTask(profileDao).execute(profile);
    }

    public void update(Profile profile) {
        new UpdateNoteAsyncTask(profileDao).execute(profile);
    }

    public void delete(Profile profile) {
        new DeleteNoteAsyncTask(profileDao).execute(profile);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(profileDao).execute();
    }

    public LiveData<List<Profile>> getAllProfile() {
        return allProfile;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProfileDao profileDao;

        private InsertNoteAsyncTask(ProfileDao profileDao) {
            this.profileDao = profileDao;
        }

        @Override
        protected Void doInBackground(Profile... notes) {
            profileDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProfileDao profileDao;

        private UpdateNoteAsyncTask(ProfileDao profileDao) {
            this.profileDao = profileDao;
        }

        @Override
        protected Void doInBackground(Profile... notes) {
            profileDao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProfileDao profileDao;

        private DeleteNoteAsyncTask(ProfileDao profileDao) {
            this.profileDao = profileDao;
        }

        @Override
        protected Void doInBackground(Profile... notes) {
            profileDao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProfileDao profileDao;

        private DeleteAllNotesAsyncTask(ProfileDao profileDao) {
            this.profileDao = profileDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            profileDao.deleteAllNotes();
            return null;
        }
    }
}
