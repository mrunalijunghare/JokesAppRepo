package com.example.jokeapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jokeapp.model.Joke;
import com.example.jokeapp.model.JokesResponse;
import com.example.jokeapp.repository.JokesRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JokesViewModel extends AndroidViewModel {
    private JokesRepository jokesRepository;
    private LiveData<JokesResponse> jokesResponseLiveData = new MutableLiveData<>();;
    private LiveData<Joke> jokeResponseLiveData = new MutableLiveData<>();

    public JokesViewModel(@NonNull Application application) {
        super(application);

        jokesRepository = new JokesRepository();
        List<String> categoryList = new ArrayList<String>(Arrays.asList("Any"));
        String category = String.join(",", categoryList);
        int amount = 1;
        if (amount > 1)
            this.jokesResponseLiveData = jokesRepository.getJokesList(category, "single", amount);
        else
            this.jokeResponseLiveData = jokesRepository.getSingleJokeList(category, "single", amount);
    }

    public LiveData<JokesResponse> getJokesResponseLiveData() {
        return jokesResponseLiveData;
    }

    public LiveData<Joke> getJokeResponseLiveData() {
        return jokeResponseLiveData;
    }
}
