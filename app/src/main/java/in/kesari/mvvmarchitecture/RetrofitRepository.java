package in.kesari.mvvmarchitecture;

import android.app.Activity;
import android.util.Log;

import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import in.kesari.mvvmarchitecture.Profile.Profile;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {
    public static final String BASE_URL = "http://54.207.7.108:3000/moofwd/";

    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    //execute call back in background thread
                    .callbackExecutor(Executors.newSingleThreadExecutor())
                    .build();
        }
        return retrofit;
    }


    public LiveData<Profile> getTopCoupon(Activity activity) {
        final MutableLiveData<Profile> coupon = new MutableLiveData<Profile>();
        getRetrofitClient().create(Webservice.class).getProfile().enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Profile cpn = response.body();
                        coupon.setValue(cpn);
                    }
                });
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Log.e("", "Error Getting TOP COUPON Data Retrofit");
            }
        });
        return coupon;
    }
}
