package com.example.jokeapp.model;

import com.google.gson.annotations.SerializedName;

public class Joke {
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

    public Joke(String category, String type, String setup, String delivery, Flags flags, boolean safe, int id, String lang, String joke, String error) {
        this.category = category;
        this.type = type;
        this.setup = setup;
        this.delivery = delivery;
        this.flags = flags;
        this.safe = safe;
        this.id = id;
        this.lang = lang;
        this.joke = joke;
        this.error = error;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

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
