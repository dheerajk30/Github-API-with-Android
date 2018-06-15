package com.example.dheeraj.loktratask.api;

import com.example.dheeraj.loktratask.models.CommitData;
import com.example.dheeraj.loktratask.models.CommitInfoRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by dheeraj on 15/6/18.
 */

public interface GithubAPI {


    final String accept="application/vnd.github.cloak-preview";

    @GET("/repos/rails/rails/commits")
    Call<CommitData[]> viewCommitInfo(@Header("Accept") String accept);

}
