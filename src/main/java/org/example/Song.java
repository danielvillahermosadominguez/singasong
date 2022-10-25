package org.example;

import java.util.ArrayList;

class Song {
    private final SongPrinter printer;
    private final SongStructure structure;
    private ActorsList actors;

    public Song(ActorsList actors, SongPrinter printer, SongStructure structure) {
        this.actors = actors;
        this.printer = printer;
        this.structure = structure;
    }

    public void Play() {
        String song = create();
        printer.print(song);
    }

    private String create() {
        ActorsList itemsInTheVerse = new ActorsList(new ArrayList<>());
        String song = "";
        Actor actor = actors.getFirst();
        Actor lastActor = actors.getLast();
        ActorsList actorsInTheVerse = actors.getPrecedents(actor);
        while (!actor.is(lastActor)) {
            song += createVerse(actorsInTheVerse);
            actor = actors.getNext(actor);
            actorsInTheVerse = actors.getPrecedents(actor);
        }

        song += createFinalVerse(actors);
        return song;
    }


    private String createVerse(ActorsList actors) {
        String result = createFirstPhrase(actors);
        Actor firstActor = actors.getFirst();
        Actor lastActor = actors.getLast();
        result += String.format(structure.getDifferentPhrase(), lastActor.getName());
        result += createBody(actors);
        result += String.format(structure.getEndOfVerse(), firstActor.getName());
        return result;
    }

    private String createBody(ActorsList actors) {
        String result = "";
        Actor actor = actors.getLast();
        Actor firstActor = actors.getFirst();
        int actorOrder = actors.size() - 1; //TODO: refactorizar
        while (!actor.is(firstActor)) {
            Actor secondActor = actors.getPrecedent(actor);
            result += String.format(structure.getRefrainOfTheVerse(), actor.getName(), secondActor.getName(), (actorOrder == 1 ? ";" : ","));
            actor = secondActor;
            actorOrder--;
        }

        return result;
    }

    private String createFirstPhrase(ActorsList actors) {
        Actor actor = actors.getLast();
        String endline = actors.size() == 1 ? "." : ";";
        return String.format(structure.getFirstPhrase(), actor.getName(), endline);
    }

    private String createFinalVerse(ActorsList actors) {
        Actor actor = actors.getLast();
        return String.format(structure.getFinalPhrase(), actor.getName());
    }
}