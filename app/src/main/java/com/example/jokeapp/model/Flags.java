package com.example.jokeapp.model;

public class Flags {
    public boolean nsfw;
    public boolean religious;
    public boolean political;
    public boolean racist;
    public boolean sexist;
    public boolean explicit;

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
