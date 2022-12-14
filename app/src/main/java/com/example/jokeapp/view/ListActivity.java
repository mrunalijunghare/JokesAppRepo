package com.example.jokeapp.view;

import static com.example.jokeapp.model.Event.SEARCH;
import static com.example.jokeapp.model.Util.KEY_JOKE_REQUEST;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.jokeapp.R;
import com.example.jokeapp.adapter.JokesAdapter;
import com.example.jokeapp.model.Event;
import com.example.jokeapp.model.JokeClass;
import com.example.jokeapp.model.JokesRequest;
import com.example.jokeapp.model.Util;
import com.example.jokeapp.viewmodel.JokesViewModel;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    JokesViewModel jokesViewModel;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private JokesAdapter jokesAdapter;
    private ArrayList<JokeClass> jokesArraylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();

        getJokesList();
    }

    private void init() {
        jokesViewModel = ViewModelProviders.of(this).get(JokesViewModel.class);
        setDataFromIntent();

        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        jokesAdapter = new JokesAdapter(this,jokesArraylist);
        recyclerView.setAdapter(jokesAdapter);
        makeRequestForJokesList();
    }

    private void makeRequestForJokesList() {
        jokesViewModel.handleEvents(SEARCH);
    }

    private void setDataFromIntent() {
        JokesRequest jokesRequest = (JokesRequest) getIntent().getSerializableExtra(KEY_JOKE_REQUEST);
        if (jokesRequest != null)
            jokesViewModel.setJokesRequest(jokesRequest);
    }

    private void getJokesList() {
        jokesViewModel.getJokesResponseLiveData().observe(this, jokesResponse -> {
            if (jokesResponse != null && jokesResponse.arrayListJokes != null) {
                jokesArraylist.addAll(jokesResponse.arrayListJokes);
                jokesAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Jokes = "+jokesResponse.amount, Toast.LENGTH_SHORT).show();
            }
        });

        jokesViewModel.getJokeResponseLiveData().observe(this, joke -> {
            if (joke != null) {
                jokesArraylist.add(joke);
                jokesAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Jokes = "+joke, Toast.LENGTH_SHORT).show();
            }
        });
    }
}