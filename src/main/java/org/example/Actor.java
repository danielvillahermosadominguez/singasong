package org.example;

public class Actor {
    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean is(Actor lastActor) {
        return this.getName().equals(lastActor.getName());
    }
}
