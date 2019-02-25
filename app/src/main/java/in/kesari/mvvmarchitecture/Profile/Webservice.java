package in.kesari.mvvmarchitecture.Profile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Webservice {



    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("users")
    Call<Profile> getProfile();
}
