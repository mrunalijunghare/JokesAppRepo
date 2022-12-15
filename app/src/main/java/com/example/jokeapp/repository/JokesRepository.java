package com.example.jokeapp.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.jokeapp.model.JokeClass;
import com.example.jokeapp.model.JokesResponse;
import com.example.jokeapp.network.JokesApi;
import com.example.jokeapp.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JokesRepository {
    private static final String TAG = JokesRepository.class.getSimpleName();
    private final JokesApi jokesApi;
    public JokesRepository() {
        jokesApi = RetrofitClient.getRetrofitInstance().create(JokesApi.class);
    }
    public LiveData<JokesResponse> getJokesList(String category, String jokeType, String amount) {
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
    public LiveData<JokeClass> getSingleJokeList(String category, String jokeType, String amount) {
        final MutableLiveData<JokeClass> data = new MutableLiveData<>();
        jokesApi.getSingleJoke(category, jokeType, amount).enqueue(new Callback<JokeClass>() {
            @Override
            public void onResponse(Call<JokeClass> call, Response<JokeClass> response) {
                if (response.body() != null) {
                    data.setValue(response.body());

                    Log.d(TAG, "joke response: " + response.toString());
                    Log.d(TAG, "joke response: " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<JokeClass> call, Throwable t) {
                data.setValue(null);
                Log.d(TAG, " jokes response: null");
            }
        });
        return data;
    }
}
