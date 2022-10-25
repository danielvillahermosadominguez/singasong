package org.example;

import java.util.ArrayList;
import java.util.List;

public class SongStructure {

    public SongStructure() {
        this.randomPhrases = new ArrayList<>();
        configureRandomPhrases();
    }

    protected List<String> randomPhrases;

    private void configureRandomPhrases() {
        addRandomPhrase("");
        addRandomPhrase("That wriggled and wiggled and tickled inside her.\n");
        addRandomPhrase("How absurd to swallow a %s.\n");
        addRandomPhrase("Fancy that to swallow a %s!\n");
        addRandomPhrase("What a hog, to swallow a %s!\n");
        addRandomPhrase("I don't know how she swallowed a %s!\n");
    }

    private void addRandomPhrase(String phrase) {
        randomPhrases.add(phrase);
    }

    protected String getEndOfVerse() {
        return "I don't know why she swallowed a %s - perhaps she'll die!\n\n";
    }

    protected String getRefrainTemplate() {
        return "She swallowed the %s to catch the %s%s\n";
    }

    protected String getDifferentPhrase(int lastAnimal) {
        return randomPhrases.get(lastAnimal);
    }

    protected String getFirstPhrase(String animal, String endline) {
        return "There was an old lady who swallowed a " + animal + endline + "\n";
    }

    protected String getFinalPhrase() {
        return "There was an old lady who swallowed a %s...\n" +
                "...She's dead, of course!";
    }
}
