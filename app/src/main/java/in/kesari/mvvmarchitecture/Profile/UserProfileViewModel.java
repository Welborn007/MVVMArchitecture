package in.kesari.mvvmarchitecture.Profile;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserProfileViewModel extends AndroidViewModel {

    private LiveData<List<Profile>> profileLiveData;
    //this is the data that we will fetch asynchronously
    private LiveData<List<Profile>> getallProfile;
    private UserRepository repository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        profileLiveData = repository.getAllProfile();
    }

    public void insert(Profile profile) {
        repository.insert(profile);
    }

    public void update(Profile profile) {
        repository.update(profile);
    }

    public void delete(Profile profile) {
        repository.delete(profile);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<Profile>> getAllNotes() {
        return profileLiveData;
    }

   /* public LiveData<List<Profile>> getUser() {

        getallProfile = getAllNotes();

        if (getallProfile == null) {
            getallProfile = new MutableLiveData<List<Profile>>();
            //we will load it asynchronously from server in this method

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Webservice.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Webservice api = retrofit.create(Webservice.class);
            Call<List<Profile>> call = api.getProfile();


            call.enqueue(new Callback<Profile>() {
                @Override
                public void onResponse(Call<Profile> call, Response<Profile> response) {

                    //finally we are setting the list to our MutableLiveData
                    getallProfile.setValue(response.body());
                    insert(response.body());
                }

                @Override
                public void onFailure(Call<Profile> call, Throwable t) {

                }
            });
        }

        return getallProfile;
    }*/
}

