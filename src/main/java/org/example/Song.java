package org.example;

import java.util.ArrayList;
import java.util.List;

public class Song {

    private final List<Verse> verses;

    public Song() {
        this.verses = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        for (Verse verse:verses) {
            result+= verse.toString();
        }
        return result;
    }

    public void addVerse(Verse verse) {
        this.verses.add(verse);
    }
}
