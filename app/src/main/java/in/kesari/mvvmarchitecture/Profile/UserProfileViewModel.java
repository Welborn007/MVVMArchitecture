package in.kesari.mvvmarchitecture.Profile;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import in.kesari.mvvmarchitecture.Contacts.RetrofitRepository;

public class UserProfileViewModel extends ViewModel {

    private LiveData<Profile> profile;
    private RetrofitRepository retrofitRepository = new RetrofitRepository();

    public LiveData<Profile> getProfile(Activity activity) {
        if(profile == null){
            profile = retrofitRepository.getTopCoupon(activity);
        }
        return profile;
    }

  /*  private MutableLiveData<Profile> profileLiveData;
    //this is the data that we will fetch asynchronously
    private static MutableLiveData<Profile> getallProfile = new MutableLiveData<Profile>();
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

    public MutableLiveData<Profile> getAllNotes() {
        return profileLiveData;
    }

    public LiveData<Profile> getUser() {

        getallProfile = getAllNotes();

        if (getallProfile == null) {
            getallProfile = new MutableLiveData<Profile>();
            //we will load it asynchronously from server in this method

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Webservice.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Webservice api = retrofit.create(Webservice.class);
            Call<Profile> call = api.getProfile();


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

