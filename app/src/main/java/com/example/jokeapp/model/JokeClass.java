package com.example.jokeapp.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class JokeClass {
    @SerializedName("error")
    public String error;
    @SerializedName("category")
    public String category;
    @SerializedName("type")
    public String type;
    @SerializedName("setup")
    public String setup;
    @SerializedName("delivery")
    public String delivery;
    @SerializedName("flags")
    public Flags flags;
    @SerializedName("safe")
    public boolean safe;
    @SerializedName("id")
    public int id;
    @SerializedName("lang")
    public String lang;
    @SerializedName("joke")
    public String joke;

    @NonNull
    @Override
    public String toString() {
        return "Joke{" +
                "error='" + error + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", delivery='" + delivery + '\'' +
                ", flags=" + flags +
                ", safe=" + safe +
                ", id=" + id +
                ", lang='" + lang + '\'' +
                ", joke='" + joke + '\'' +
                '}';
    }
}
