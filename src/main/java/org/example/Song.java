package org.example;

import java.util.ArrayList;
import java.util.List;

class Song {
    private final SongPrinter printer;
    private final SongStructure structure;
    private List<String> animals;

    public Song(List<String> animals, SongPrinter printer, SongStructure structure) {
        this.animals = animals;
        this.printer = printer;
        this.structure = structure;
    }

    public void Play() {
        String song = create();

        printer.print(song);
    }

    private String create() {
        List<String> animalsInTheVerse = new ArrayList<>();
        String song = "";
        for (int animalOrder = 0; animalOrder < animals.size() - 1; animalOrder++) {
            animalsInTheVerse.add(animals.get(animalOrder));
            song += createVerse(animalsInTheVerse, animalOrder);
        }
        song += createFinalVerse(animals);
        return song;
    }


    private String createVerse(List<String> animals, int lastAnimal) {
        String result = createFirstPhrase(animals);
        result += String.format(structure.getDifferentPhrase(lastAnimal), animals.get(animals.size() - 1));
        result += createBody(animals);
        result += String.format(structure.getEndOfVerse(), animals.get(0));
        return result;
    }

    private String createBody(List<String> animals) {
        String result = "";
        for (int animalOrder = animals.size() - 1; animalOrder > 0; animalOrder--) {
            String animal = animals.get(animalOrder);
            String secondAnimal = animals.get(animalOrder - 1);
            result += String.format(structure.getRefrainTemplate(), animal, secondAnimal, (animalOrder == 1 ? ";" : ","));
        }
        return result;
    }

    private String createFirstPhrase(List<String> animals) {
        String animal = animals.get(animals.size() - 1);
        String endline = animals.size() == 1 ? "." : ";";
        return structure.getFirstPhrase(animal, endline);
    }

    protected String createFinalVerse(List<String> animals) {
        String animal = animals.get(animals.size() - 1);
        return String.format(structure.getFinalPhrase(), animal);
    }
}