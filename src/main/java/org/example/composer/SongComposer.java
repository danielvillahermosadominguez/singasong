package org.example.composer;

import org.example.actors.Actor;
import org.example.actors.ActorsList;
import org.example.song.Phrase;
import org.example.song.Song;
import org.example.song.SongStructure;
import org.example.song.Verse;

import java.util.ArrayList;
import java.util.List;

public class SongComposer {

    private final ActorsList actors;
    private final SongStructure structure;

    public SongComposer(ActorsList actors, SongStructure structure) {
        this.actors = actors;
        this.structure = structure;
    }

    public Song create() {
        Song song = new Song();
        Actor actor = actors.getFirst();
        Actor lastActor = actors.getLast();
        ActorsList actorsInTheVerse = actors.getPrecedents(actor);
        while (!actor.is(lastActor)) {
            song.addVerse(createVerse(actorsInTheVerse));
            actor = actors.getNext(actor);
            actorsInTheVerse = actors.getPrecedents(actor);
        }

        song.addVerse(createFinalVerse(actors));
        return song;
    }

    private Verse createVerse(ActorsList actors) {
        List<Phrase> phrases = new ArrayList<Phrase>();
        phrases.add(createFirstPhrase(actors));
        Actor firstActor = actors.getFirst();
        Actor lastActor = actors.getLast();
        if (actors.size() > 1) {
            phrases.add(new Phrase(String.format(structure.getDifferentPhrase(), lastActor.getName())));
        }
        phrases.addAll(createBody(actors));
        phrases.add(new Phrase(String.format(structure.getEndOfVerse(), firstActor.getName())));
        return new Verse(phrases);
    }

    private List<Phrase> createBody(ActorsList actors) {
        List<Phrase> result = new ArrayList<>();
        Actor actor = actors.getLast();
        Actor firstActor = actors.getFirst();
        int actorOrder = actors.size() - 1; //TODO: refactorize it. I don't know how to easily calculate it  without affect to the performance
        while (!actor.is(firstActor)) {
            Actor secondActor = actors.getPrecedent(actor);
            result.add(createRefrain(actor, actorOrder, secondActor));
            actor = secondActor;
            actorOrder--;
        }

        return result;
    }

    private Phrase createRefrain(Actor actor, int actorOrder, Actor secondActor) {
        String endLine = actorOrder == 1 ? ";" : ",";
        return new Phrase(String.format(structure.getRefrainOfTheVerse(), actor.getName(), secondActor.getName(), endLine));
    }

    private Phrase createFirstPhrase(ActorsList actors) {
        Actor actor = actors.getLast();
        String endline = actors.size() == 1 ? "." : ";";
        return new Phrase(String.format(structure.getFirstPhrase(), actor.getName(), endline));
    }

    private Verse createFinalVerse(ActorsList actors) {
        List<Phrase> phrases = new ArrayList<>();
        Actor actor = actors.getLast();
        phrases.add(new Phrase(String.format(structure.getFinalPhrase(), actor.getName())));
        return new Verse(phrases);
    }
}
