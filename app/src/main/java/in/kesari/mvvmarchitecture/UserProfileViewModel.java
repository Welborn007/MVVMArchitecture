package in.kesari.mvvmarchitecture;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import in.kesari.mvvmarchitecture.Profile.Profile;

public class UserProfileViewModel extends ViewModel {

    private LiveData<Profile> profile;
    private RetrofitRepository retrofitRepository = new RetrofitRepository();

    public LiveData<Profile> getProfile(Activity activity) {
        if(profile == null){
            profile = retrofitRepository.getTopCoupon(activity);
        }
        return profile;
    }
}

