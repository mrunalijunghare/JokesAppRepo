package com.example.jokeapp.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JokesResponse {
    @SerializedName("error")
    public boolean error;
    @SerializedName("amount")
    public int amount;
    @SerializedName("jokes")
    public ArrayList<JokeClass> arrayListJokes;

    @NonNull
    @Override
    public String toString() {
        return "JokesResponse{" +
                "error=" + error +
                ", amount=" + amount +
                ", jokes=" + arrayListJokes +
                '}';
    }
}
