package in.kesari.mvvmarchitecture.Profile;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://54.207.7.108:3000/moofwd/")
            .addConverterFactory(GsonConverterFactory.create()
            ).build();
}
