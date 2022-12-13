package com.example.jokeapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jokeapp.R;
import com.example.jokeapp.viewmodel.JokesViewModel;

public class ListActivity extends AppCompatActivity {

    JokesViewModel jokesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        jokesViewModel = ViewModelProviders.of(this).get(JokesViewModel.class);

        getJokesList();
    }

    private void getJokesList() {
        jokesViewModel.getJokesResponseLiveData().observe(this, jokesResponse -> {
            if (jokesResponse != null) {
                Toast.makeText(this, "Jokes = "+jokesResponse.amount, Toast.LENGTH_SHORT).show();
            }
        });

        jokesViewModel.getJokeResponseLiveData().observe(this, joke -> {
            if (joke != null) {
                Toast.makeText(this, "Jokes = "+joke, Toast.LENGTH_SHORT).show();
            }
        });
    }
}