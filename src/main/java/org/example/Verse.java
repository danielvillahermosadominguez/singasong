package org.example;

import java.util.List;

public class Verse {
    private final List<Phrase> phrases;

    public Verse(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    @Override
    public String toString() {
        String result = "";
        for (Phrase phrase:phrases) {
            result+= phrase.toString();
        }
        return result;
    }
}
