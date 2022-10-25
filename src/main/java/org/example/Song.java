package org.example;

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

        String firstVerse = getFirstVerse(Arrays.asList(fly), ".");
        String secondVerse = getSecondVerse(Arrays.asList(fly, spider), "That wriggled and wiggled and tickled inside her.\n", ";");
        String thirdVerse = getThirdVerse(Arrays.asList(fly, spider, bird), "How absurd to swallow a " + Arrays.asList(fly, spider, bird).get(2) + ".\n", ";");
        String fourthVerse = getFourthVerse(Arrays.asList(fly, spider, bird, cat), "Fancy that to swallow a " + Arrays.asList(fly, spider, bird, cat).get(3) + "!\n", ";");
        String fifthVerse = getFifthVerse(Arrays.asList(fly, spider, bird, cat, dog), "What a hog, to swallow a " + Arrays.asList(fly, spider, bird, cat, dog).get(4) + "!\n");
        String sixthVerse = getSixthVerse(Arrays.asList(fly, spider, bird, cat, dog, cow), "I don't know how she swallowed a " + Arrays.asList(fly, spider, bird, cat, dog, cow).get(5) + "!\n");
        String finalVerse = getFinalVerse(Arrays.asList(horse));
        String song = firstVerse +
                secondVerse +
                thirdVerse +
                fourthVerse +
                fifthVerse +
                sixthVerse +
                finalVerse;

        print(song);
    }

    private static String getFirstVerse(List<String> animals, String endFirstLine) {
        String result =  getFirstphrase(animals.get(0), endFirstLine);
        result += getEndOfVerse(animals.get(0));
        return result;
    }

    private static String getEndOfVerse(String animal) {
        return "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n\n";
    }

    private static String getSecondVerse(List<String> animals, String differentPhrase, String endFirstLine) {

        String result = getFirstphrase(animals.get(animals.size()-1), endFirstLine);
        result += differentPhrase;
        result += getBody(animals);
        result += getEndOfVerse(animals.get(0));
        return result;
    }

    private static String getThirdVerse(List<String> animals, String differentPhrase, String endFirstLine) {
        String result = getFirstphrase(animals.get(2), endFirstLine);
        result += differentPhrase;
        result += getBody(animals);
        result += getEndOfVerse(animals.get(0)) ;
        return result;
    }

    private static String getFourthVerse(List<String> animals, String differentPhrase, String endFirstLine) {
        String result = getFirstphrase(animals.get(3), endFirstLine);
        result += differentPhrase;
        result += getBody(animals);
        result += getEndOfVerse(animals.get(0)) ;
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

    private static String getFifthVerse(List<String> animals, String differentPhrase) {
        String result = getFirstphrase(animals.get(4), ";");
        result += differentPhrase;
        result += getBody(animals);
        result += getEndOfVerse(animals.get(0)) ;
        return result;
    }

    private static String getSixthVerse(List<String> animals, String differentPhrase) {
        String result = getFirstphrase(animals.get(5), ";");
        result += differentPhrase;
        result +=getBody(animals);
        result += getEndOfVerse(animals.get(0));
        return result;
    }

    private static String getFinalVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(0) + "...\n" +
                "...She's dead, of course!";
    }

    public static void print(String song) {
        System.out.println(song);
    }
}