package com.example.jokeapp.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class JokesRequest implements Serializable {
    private String category;
    private String jokeType;
    private String amount;

    public JokesRequest() {
        category = Util.ANY;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJokeType() {
        return jokeType;
    }

    public void setJokeType(String jokeType) {
        this.jokeType = jokeType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @NonNull
    @Override
    public String toString() {
        return "JokesRequest{" +
                "category=" + category +
                ", jokeType='" + jokeType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
