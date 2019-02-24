package in.kesari.mvvmarchitecture.Profile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Webservice {

    String BASE_URL = "http://54.207.7.108:3000/moofwd/";

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("users")
    Call<List<Profile>> getProfile();
}
