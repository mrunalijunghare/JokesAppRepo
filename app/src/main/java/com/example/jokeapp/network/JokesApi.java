package com.example.jokeapp.network;

import com.example.jokeapp.model.JokeClass;
import com.example.jokeapp.model.JokesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JokesApi {
    @GET("joke/{category}")
    Call<JokesResponse> getJokes(
            @Path("category") String category,
            @Query("type") String jokeType,
            @Query("amount") String amount
    );

    @GET("joke/{category}")
    Call<JokeClass> getSingleJoke(
            @Path("category") String category,
            @Query("type") String jokeType,
            @Query("amount") String amount
    );
}
