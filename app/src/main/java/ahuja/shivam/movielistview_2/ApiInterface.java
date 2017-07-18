package ahuja.shivam.movielistview_2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 18/7/17.
 */

public interface ApiInterface {
    @GET("json/movies.json")
    Call<List<Movie>> getStudentDetails();
}
