package ahuja.shivam.movielistview_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView myListView;
private static String url="https://api.androidhive.info/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView=(ListView)findViewById(R.id.myListView);
       jsonList();

    }

    private void jsonList() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiinterface=retrofit.create(ApiInterface.class);
        Call<List<Movie>> call=apiinterface.getStudentDetails();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
               ArrayList<Movie> moviearraylist= (ArrayList<Movie>) response.body();
                MyAdapter myadapter=new MyAdapter(MainActivity.this,moviearraylist);
                myListView.setAdapter(myadapter);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }


}
