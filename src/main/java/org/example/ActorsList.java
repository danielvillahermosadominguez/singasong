package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActorsList {
    private final ArrayList<Actor> actors;

    public ActorsList(List<String> actors) {
        this.actors = new ArrayList<Actor>();
        for (String text : actors) {
            this.actors.add(new Actor(text));
        }
    }

    public ActorsList getPrecedents(Actor actor) {
        int index = actors.indexOf(actor);

        List<String> names = new ArrayList<>();
        for (int i = index; i >= 0; i--) {
            Actor actor1 = actors.get(i);
            names.add(actor1.getName());
        }
        Collections.reverse(names);
        return new ActorsList(names);
    }

    public Actor getLast() {
        return actors.get(actors.size() - 1);
    }

    public Actor getFirst() {
        return actors.get(0);
    }

    public Actor getPrecedent(Actor actor) {
        int pos = actors.indexOf(actor);
        return actors.get(pos - 1);
    }

    public int size() {
        return this.actors.size();
    }

    public Actor getNext(Actor actor) {
        int pos = actors.indexOf(actor);
        return actors.get(pos + 1);
    }
}
