package com.example.jokeapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.jokeapp.model.Event;
import com.example.jokeapp.model.JokeClass;
import com.example.jokeapp.model.JokesRequest;
import com.example.jokeapp.model.JokesResponse;
import com.example.jokeapp.repository.JokesRepository;

public class JokesViewModel extends AndroidViewModel {
    private final JokesRepository jokesRepository;
    private LiveData<JokesResponse> jokesResponseLiveData = new MutableLiveData<>();
    private LiveData<JokeClass> jokeResponseLiveData = new MutableLiveData<>();
    private JokesRequest jokesRequest = new JokesRequest();

    public JokesViewModel(@NonNull Application application) {
        super(application);
        jokesRepository = new JokesRepository();
    }

    public void setJokesRequest(JokesRequest jokesRequest) {
        this.jokesRequest = jokesRequest;
    }

    public LiveData<JokesResponse> getJokesResponseLiveData() {
        return jokesResponseLiveData;
    }

    public LiveData<JokeClass> getSingleJokeResponseLiveData() {
        return jokeResponseLiveData;
    }

    public void handleEvents(Event event) {
        switch (event) {
            case SEARCH:
                requestSearchJokesList();
                break;
            case SUBMIT:
                break;
        }
    }

    private void requestSearchJokesList() {
        int amount = 0;
        if (jokesRequest.getAmount() != null && !jokesRequest.getAmount().isEmpty())
            amount = Integer.parseInt(jokesRequest.getAmount());

        if (amount > 1)
            this.jokesResponseLiveData = jokesRepository.getJokesList(
                    jokesRequest.getCategory(),
                    jokesRequest.getJokeType(),
                    jokesRequest.getAmount());
        else
            this.jokeResponseLiveData = jokesRepository.getSingleJokeList(
                    jokesRequest.getCategory(),
                    jokesRequest.getJokeType(),
                    jokesRequest.getAmount());
    }
}
