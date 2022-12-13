package com.example.jokeapp.network;

import com.example.jokeapp.model.Joke;
import com.example.jokeapp.model.JokesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JokesApi {
    @GET("joke/{category}")
    Call<JokesResponse> getJokes(
            @Path("category") String category,
            @Query("type") String jokeType,
            @Query("amount") Integer amount
    );

    @GET("joke/{category}")
    Call<Joke> getSingleJoke(
            @Path("category") String category,
            @Query("type") String jokeType,
            @Query("amount") Integer amount
    );
}
