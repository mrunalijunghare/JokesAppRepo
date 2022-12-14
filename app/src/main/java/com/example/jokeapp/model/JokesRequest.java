package com.example.jokeapp.model;

import java.io.Serializable;
import java.util.List;

public class JokesRequest implements Serializable {
    private String category;
    private String jokeType;
    private String amount;

    public JokesRequest() {
        category = Util.ANY;
    }

    public JokesRequest(String category, String jokeType, String amount) {
        this.category = category;
        this.jokeType = jokeType;
        this.amount = amount;
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

    @Override
    public String toString() {
        return "JokesRequest{" +
                "category=" + category +
                ", jokeType='" + jokeType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
