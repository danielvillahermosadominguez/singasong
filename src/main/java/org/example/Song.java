package org.example;

import java.util.ArrayList;
import java.util.List;

class Song {
    public static final String THAT_WRIGGLED_AND_WIGGLED_AND_TICKLED_INSIDE_HER = "That wriggled and wiggled and tickled inside her.\n";
    public static final String HOW_ABSURD_TO_SWALLOW_A_S = "How absurd to swallow a %s.\n";
    public static final String FANCY_THAT_TO_SWALLOW_A_S = "Fancy that to swallow a %s!\n";
    public static final String WHAT_A_HOG_TO_SWALLOW_A_S = "What a hog, to swallow a %s!\n";
    public static final String I_DON_T_KNOW_HOW_SHE_SWALLOWED_A_S = "I don't know how she swallowed a %s!\n";
    public static final String DOT_COMMA = ";";
    public static final String COMMA = ",";
    private final SongPrinter printer
            ;
    private List<String> animals;
    private List<String> randomPhrases;

    public Song(List<String> animals, SongPrinter printer) {
        this.animals = animals;
        createRandomPhrases();
        this.printer = printer;
    }

    private void createRandomPhrases() {
        this.randomPhrases = new ArrayList<>();
        randomPhrases.add("");
        randomPhrases.add(THAT_WRIGGLED_AND_WIGGLED_AND_TICKLED_INSIDE_HER);
        randomPhrases.add(HOW_ABSURD_TO_SWALLOW_A_S);
        randomPhrases.add(FANCY_THAT_TO_SWALLOW_A_S);
        randomPhrases.add(WHAT_A_HOG_TO_SWALLOW_A_S);
        randomPhrases.add(I_DON_T_KNOW_HOW_SHE_SWALLOWED_A_S);
    }

    public void create() {
        List<String> animalsInTheVerse = new ArrayList<>();
        String song = "";
        for (int animalOrder = 0; animalOrder < animals.size() - 1; animalOrder++) {
            animalsInTheVerse.add(animals.get(animalOrder));
            song += createVerse(animalsInTheVerse, animalOrder);
        }
        song += getFinalVerse(animals);

        printer.print(song);
    }

    private String getEndOfVerse(String animal) {
        return "I don't know why she swallowed a " + animal + " - perhaps she'll die!\n\n";
    }

    private String createVerse(List<String> animals, int lastAnimal) {
        String endFirstLine = animals.size() == 1 ? "." : DOT_COMMA;
        String differentPhrase = randomPhrases.get(lastAnimal);
        String result = getFirstphrase(animals.get(animals.size() - 1), endFirstLine);
        result += String.format(differentPhrase, animals.get(animals.size() - 1));
        result += getBody(animals);
        result += getEndOfVerse(animals.get(0));
        return result;
    }

    private String getBody(List<String> animals) {
        String result = "";
        for (int i = animals.size() - 1; i > 0; i--) {
            result += "She swallowed the " + animals.get(i) + " to catch the " + animals.get(i - 1) + (i == 1 ? DOT_COMMA : COMMA) + "\n";
        }
        return result;
    }

    private String getFirstphrase(String animal, String endLine) {
        return "There was an old lady who swallowed a " + animal + endLine + "\n";
    }

    private String getFinalVerse(List<String> animals) {
        return "There was an old lady who swallowed a " + animals.get(animals.size() - 1) + "...\n" +
                "...She's dead, of course!";
    }

}