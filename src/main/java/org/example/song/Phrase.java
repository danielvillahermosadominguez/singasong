package org.example.song;

public class Phrase extends Lyric {
    private final String text;

    public Phrase(String text) {
        this.text = text;
    }

    @Override
    public String convertToString() {
        return this.text;
    }
}
