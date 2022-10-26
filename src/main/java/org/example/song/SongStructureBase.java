package org.example.song;

import org.example.song.SongStructure;

import java.util.ArrayList;
import java.util.List;

public abstract class SongStructureBase implements SongStructure {
    private int lastSpecialPhrase;
    private List<String> specialPhrasesForEachVerse;
    private String endOfVerse;
    private String firstPhrase;
    private String finalPhrase;
    private String refrain;

    public SongStructureBase() {
        this.specialPhrasesForEachVerse = new ArrayList<>();
        configureRandomPhrases();
        this.lastSpecialPhrase = 0;
    }

    @Override
    public String getFirstPhrase() {
        return this.firstPhrase;
    }

    @Override
    public String getDifferentPhrase() {
        return getNextRandomPhrase();
    }

    @Override
    public String getFinalPhrase() {
        return this.finalPhrase;
    }

    @Override
    public String getEndOfVerse() {
        return this.endOfVerse;
    }

    @Override
    public String getRefrainOfTheVerse() {
        return this.refrain;
    }

    protected String getNextRandomPhrase() {
        String result = specialPhrasesForEachVerse.get(lastSpecialPhrase);
        lastSpecialPhrase = (lastSpecialPhrase + 1) % this.specialPhrasesForEachVerse.size();
        return result;
    }

    protected abstract void configureRandomPhrases();

    protected void addSpecialPhraseForEachVerse(String phrase) {
        specialPhrasesForEachVerse.add(phrase);
    }

    protected void setTemplateEndOfVerse(String phrase) {
        this.endOfVerse = phrase;
    }

    protected void addTemplateForFirstPhrase(String phrase) {
        this.firstPhrase = phrase;
    }

    protected void addTemplateRefrainOfTheVerse(String phrase) {
        this.refrain = phrase;
    }

    protected void addFinalPhrase(String phrase) {
        this.finalPhrase = phrase;
    }
}
