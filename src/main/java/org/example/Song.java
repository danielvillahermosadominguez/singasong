package org.example;

import java.util.ArrayList;
import java.util.List;

class Song {
    private final SongPrinter printer;
    private final SongStructure structure;
    private List<String> items;

    public Song(List<String> items, SongPrinter printer, SongStructure structure) {
        this.items = items;
        this.printer = printer;
        this.structure = structure;
    }

    public void Play() {
        String song = create();
        printer.print(song);
    }

    private String create() {
        List<String> itemsInTheVerse = new ArrayList<>();
        String song = "";
        for (int itemOrder = 0; itemOrder < items.size() - 1; itemOrder++) {
            String item = items.get(itemOrder);
            itemsInTheVerse.add(item);
            song += createVerse(itemsInTheVerse);
        }
        song += createFinalVerse(items);
        return song;
    }


    private String createVerse(List<String> items) {
        String result = createFirstPhrase(items);
        result += String.format(structure.getDifferentPhrase(), items.get(items.size() - 1));
        result += createBody(items);
        result += String.format(structure.getEndOfVerse(), items.get(0));
        return result;
    }

    private String createBody(List<String> animals) {
        String result = "";
        for (int animalOrder = animals.size() - 1; animalOrder > 0; animalOrder--) {
            String animal = animals.get(animalOrder);
            String secondAnimal = animals.get(animalOrder - 1);
            result += String.format(structure.getRefrainOfTheVerse(), animal, secondAnimal, (animalOrder == 1 ? ";" : ","));
        }
        return result;
    }

    private String createFirstPhrase(List<String> animals) {
        String animal = animals.get(animals.size() - 1);
        String endline = animals.size() == 1 ? "." : ";";
        return String.format(structure.getFirstPhrase(),animal, endline);
    }

    private String createFinalVerse(List<String> animals) {
        String animal = animals.get(animals.size() - 1);
        return String.format(structure.getFinalPhrase(), animal);
    }
}