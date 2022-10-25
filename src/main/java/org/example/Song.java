package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Song {

    public static void main(String[] args) {

        String fly = "fly";
        String spider = "spider";
        String bird = "bird";
        String cat = "cat";
        String dog = "dog";
        String cow = "cow";
        String horse = "horse";
        List<String> animals = Arrays.asList(fly, spider, bird, cat, dog, cow);
        List<String> randomPhrases = new ArrayList<>();
        randomPhrases.add("");
        randomPhrases.add("That wriggled and wiggled and tickled inside her.\n");
        randomPhrases.add("How absurd to swallow a " + animals.get(2) + ".\n");
        randomPhrases.add("Fancy that to swallow a " + animals.get(3) + "!\n");
        randomPhrases.add("What a hog, to swallow a " + animals.get(4) + "!\n");
        randomPhrases.add("I don't know how she swallowed a " + animals.get(5) + "!\n");

        List<String> animalsInTheVerse = new ArrayList<>();
        String song = "";
        for(int i = 0;i< animals.size();i++) {
            animalsInTheVerse.add(animals.get(i));
            song += createVerse(animalsInTheVerse, randomPhrases.get(i), animalsInTheVerse.size() == 1 ? ".":";");
        }
        song+= getFinalVerse(Arrays.asList(horse));

        print(song);
    }

    private static String getEndOfVerse(String animal) {
        return "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n\n";
    }

    private static String createVerse(List<String> animals, String differentPhrase, String endFirstLine) {
        String result = getFirstphrase(animals.get(animals.size() - 1), endFirstLine);
        result += differentPhrase;
        result += getBody(animals);
        result += getEndOfVerse(animals.get(0));
        return result;
    }

    private static String getBody(List<String> animals) {
        String result = "";
        for (int i = animals.size() - 1; i > 0; i--) {
            result += "She swallowed the " + animals.get(i) + " to catch the " + animals.get(i - 1) + (i == 1 ? ";" : ",") + "\n";
        }
        return result;
    }

    private static String getFirstphrase(String animal, String endLine) {
        return "There was an old lady who swallowed a " + animal + endLine + "\n";
    }

    private static String getFinalVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(0) + "...\n" +
                "...She's dead, of course!";
    }

    public static void print(String song) {
        System.out.println(song);
    }
}