package com.example.jokeapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jokeapp.model.Joke;
import com.example.jokeapp.model.JokesResponse;
import com.example.jokeapp.network.JokesApi;
import com.example.jokeapp.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokesRepository {
    private static final String TAG = JokesRepository.class.getSimpleName();
    private JokesApi jokesApi;
    public JokesRepository() {
        jokesApi = RetrofitClient.getRetrofitInstance().create(JokesApi.class);
    }
    public LiveData<JokesResponse> getJokesList(String category, String jokeType, Integer amount) {
        final MutableLiveData<JokesResponse> data = new MutableLiveData<>();
        jokesApi.getJokes(category, jokeType, amount).enqueue(new Callback<JokesResponse>() {
            @Override
            public void onResponse(Call<JokesResponse> call, Response<JokesResponse> response) {
                if (response.body() != null) {
                    data.setValue(response.body());

                    Log.d(TAG, "jokes response: " + response.toString());
                    Log.d(TAG, "jokes response: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<JokesResponse> call, Throwable t) {
                data.setValue(null);
                Log.d(TAG, " jokes response: null");
            }
        });
        return data;
    }
    public LiveData<Joke> getSingleJokeList(String category, String jokeType, Integer amount) {
        final MutableLiveData<Joke> data = new MutableLiveData<>();
        jokesApi.getSingleJoke(category, jokeType, amount).enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                if (response.body() != null) {
                    data.setValue(response.body());

                    Log.d(TAG, "joke response: " + response.toString());
                    Log.d(TAG, "joke response: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                data.setValue(null);
                Log.d(TAG, " jokes response: null");
            }
        });
        return data;
    }
}
