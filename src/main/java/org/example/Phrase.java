package org.example;

public class Phrase {
    private final String text;

    public Phrase(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
