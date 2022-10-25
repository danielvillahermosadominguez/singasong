package org.example;

import java.util.Arrays;

import static java.lang.System.exit;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please you need to include a list of animals in the arguments:");
            System.out.println("For example:");
            System.out.println("singsangsong fly spider cat");
            exit(0);
        }

        SongPrinter printer = new SongPrinter();
        SongStructureChildrenSong structure = new SongStructureChildrenSong();
        ActorsList animals = new ActorsList(Arrays.asList(args));
        SongComposer composer = new SongComposer(animals, structure);
        Song song = new Song(composer, printer);
        song.Play();
    }
}
