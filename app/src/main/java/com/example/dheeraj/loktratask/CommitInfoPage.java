package com.example.dheeraj.loktratask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dheeraj.loktratask.adapters.CommitAdapter;
import com.example.dheeraj.loktratask.api.GithubAPI;
import com.example.dheeraj.loktratask.models.CommitData;
import com.example.dheeraj.loktratask.models.CommitInfoRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommitInfoPage extends AppCompatActivity {


    GithubAPI service;
    RecyclerView rvdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_info_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvdata=(RecyclerView) findViewById(R.id.rvdata);
        rvdata.setLayoutManager(new LinearLayoutManager(CommitInfoPage.this));

        Gson gson =new GsonBuilder().create();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        service=retrofit.create(GithubAPI.class);


        Call<CommitData[]> call=service.viewCommitInfo("application/vnd.github.cloak-preview");
        call.enqueue(new Callback<CommitData[]>() {
            @Override
            public void onResponse(Call<CommitData[]> call, Response<CommitData[]> response) {
               CommitData[] data= response.body();
               CommitAdapter adapter=new CommitAdapter(CommitInfoPage.this,data);
               rvdata.setAdapter(adapter);

                Toast.makeText(CommitInfoPage.this,"SUCCESS",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CommitData[]> call, Throwable t) {

                Toast.makeText(CommitInfoPage.this,"FAILED",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_commit_info_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
