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

        String firstVerse = getFirstVerse(Arrays.asList(fly));
        String secondVerse = getSecondVerse(Arrays.asList(fly, spider));
        String thirdVerse = getThirdVerse(Arrays.asList(fly, spider, bird));
        String fourthVerse = getFourthVerse(Arrays.asList(fly, spider, bird, cat));
        String fifthVerse = getFifthVerse(Arrays.asList(fly, spider, bird, cat, dog));
        String sixthVerse = getSixthVerse(Arrays.asList(fly, spider, bird, cat, dog, cow));
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

    private static String getFirstVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(0) + ".\n" +
                "I don't know why she swallowed a " + animals.get(0) + " - perhaps she'll die!\n" +
                "\n";
    }
    private static String getSecondVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(1) + ";\n" +
                "That wriggled and wiggled and tickled inside her.\n" +
                "She swallowed the " + animals.get(1) + " to catch the " + animals.get(0) + ";\n" +
                "I don't know why she swallowed a " + animals.get(0) + " - perhaps she'll die!\n" +
                "\n";
    }
    private static String getFinalVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(0) + "...\n" +
                "...She's dead, of course!";
    }

    private static String getSixthVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(5) + ";\n" +
                "I don't know how she swallowed a " + animals.get(5) + "!\n" +
                "She swallowed the " + animals.get(5) + " to " + animals.get(3) + "ch the " + animals.get(4) + ",\n" +
                "She swallowed the " + animals.get(4) + " to " + animals.get(3) + "ch the cat,\n" +
                "She swallowed the " + animals.get(3) + " to catch the " + animals.get(2) + ",\n" +
                "She swallowed the " + animals.get(2) + " to catch the " + animals.get(1) + ",\n" +
                "She swallowed the " + animals.get(1) + " to catch the " + animals.get(0) + ";\n" +
                "I don't know why she swallowed a " + animals.get(0) + " - perhaps she'll die!\n" +
                "\n";
    }

    private static String getFifthVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(4) + ";\n" +
                "What a hog, to swallow a " + animals.get(4) + "!\n" +
                "She swallowed the " + animals.get(4) + " to catch the " + animals.get(3) + ",\n" +
                "She swallowed the " + animals.get(3) + " to catch the " + animals.get(2) + ",\n" +
                "She swallowed the " + animals.get(2) + " to catch the " + animals.get(1) + ",\n" +
                "She swallowed the " + animals.get(1) + " to catch the " + animals.get(0) + ";\n" +
                "I don't know why she swallowed a " + animals.get(0) + " - perhaps she'll die!\n" +
                "\n";
    }

    private static String getFourthVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(3) + ";\n" +
                "Fancy that to swallow a " + animals.get(3) + "!\n" +
                "She swallowed the " + animals.get(3) + " to catch the " + animals.get(2) + ",\n" +
                "She swallowed the " + animals.get(2) + " to catch the " + animals.get(1) + ",\n" +
                "She swallowed the " + animals.get(1) + " to " + animals.get(3) + "ch the " + animals.get(0) + ";\n" +
                "I don't know why she swallowed a " + animals.get(0) + " - perhaps she'll die!\n" +
                "\n";
    }

    private static String getThirdVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(2) + ";\n" +
                "How absurd to swallow a " + animals.get(2) + ".\n" +
                "She swallowed the " + animals.get(2) + " to catch the " + animals.get(1) + ",\n" +
                "She swallowed the " + animals.get(1) + " to catch the " + animals.get(0) + ";\n" +
                "I don't know why she swallowed a " + animals.get(0) + " - perhaps she'll die!\n" +
                "\n";
    }



    public static void print(String song) {
        System.out.println(song);
    }
}