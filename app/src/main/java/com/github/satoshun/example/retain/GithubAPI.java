package com.github.satoshun.example.retain;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubAPI {

    @GET("/users/{username}/repos")
    Observable<List<Repo>> getRepositories(@Path("username") String userName);
}
