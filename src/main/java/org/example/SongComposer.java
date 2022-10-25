package org.example;

import java.util.ArrayList;

public class SongComposer {

    private final ActorsList actors;
    private final SongStructure structure;

    public SongComposer(ActorsList actors, SongStructure structure) {
        this.actors = actors;
        this.structure = structure;
    }

    protected String create() {
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
        if(actors.size() > 1) {
            result += String.format(structure.getDifferentPhrase(), lastActor.getName());
        }
        result += createBody(actors);
        result += String.format(structure.getEndOfVerse(), firstActor.getName());
        return result;
    }

    private String createBody(ActorsList actors) {
        String result = "";
        Actor actor = actors.getLast();
        Actor firstActor = actors.getFirst();
        int actorOrder = actors.size() - 1; //TODO: refactorize it. I don't know how to easily calculate it  without affect to the performance
        while (!actor.is(firstActor)) {
            Actor secondActor = actors.getPrecedent(actor);
            result += createRefrain(actor, actorOrder, secondActor);
            actor = secondActor;
            actorOrder--;
        }

        return result;
    }

    private String createRefrain(Actor actor, int actorOrder, Actor secondActor) {
        String endLine = actorOrder == 1 ? ";" : ",";
        return String.format(structure.getRefrainOfTheVerse(), actor.getName(), secondActor.getName(), endLine);
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
