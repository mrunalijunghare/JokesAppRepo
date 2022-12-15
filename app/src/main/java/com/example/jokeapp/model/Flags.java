package com.example.jokeapp.model;

import androidx.annotation.NonNull;

public class Flags {
    public boolean nsfw;
    public boolean religious;
    public boolean political;
    public boolean racist;
    public boolean sexist;
    public boolean explicit;

    @NonNull
    @Override
    public String toString() {
        return "Flags{" +
                "nsfw=" + nsfw +
                ", religious=" + religious +
                ", political=" + political +
                ", racist=" + racist +
                ", sexist=" + sexist +
                ", explicit=" + explicit +
                '}';
    }
}
