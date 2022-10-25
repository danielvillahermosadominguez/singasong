package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongComposerShould {
    private final String expected_full_song = "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a spider;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a bird;\n" +
            "How absurd to swallow a bird.\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cat;\n" +
            "Fancy that to swallow a cat!\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a dog;\n" +
            "What a hog, to swallow a dog!\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cow;\n" +
            "I don't know how she swallowed a cow!\n" +
            "She swallowed the cow to catch the dog,\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a horse...\n" +
            "...She's dead, of course!";

    private final String expectedSongWith8Animals = "There was an old lady who swallowed a fly.\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a spider;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a bird;\n" +
            "How absurd to swallow a bird.\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cat;\n" +
            "Fancy that to swallow a cat!\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a dog;\n" +
            "What a hog, to swallow a dog!\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a cow;\n" +
            "I don't know how she swallowed a cow!\n" +
            "She swallowed the cow to catch the dog,\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a horse;\n" +
            "That wriggled and wiggled and tickled inside her.\n" +
            "She swallowed the horse to catch the cow,\n" +
            "She swallowed the cow to catch the dog,\n" +
            "She swallowed the dog to catch the cat,\n" +
            "She swallowed the cat to catch the bird,\n" +
            "She swallowed the bird to catch the spider,\n" +
            "She swallowed the spider to catch the fly;\n" +
            "I don't know why she swallowed a fly - perhaps she'll die!\n" +
            "\n" +
            "There was an old lady who swallowed a worm...\n" +
            "...She's dead, of course!";

    @Test
    void return_a_song_with_animals() {
        SongStructureChildrenSong structure = new SongStructureChildrenSong();
        ActorsList animals = new ActorsList(Arrays.asList("fly", "spider", "bird", "cat", "dog", "cow", "horse"));
        SongComposer composer = new SongComposer(animals, structure);

        String song = composer.create();

        assertEquals(expected_full_song, song);
    }

    @Test
    void return_a_song_with_one_animal() {
        String expectedSong = "There was an old lady who swallowed a fly...\n" +
                              "...She's dead, of course!";
        SongStructureChildrenSong structure = new SongStructureChildrenSong();
        ActorsList animals = new ActorsList(Arrays.asList("fly"));
        SongComposer composer = new SongComposer(animals, structure);

        String song = composer.create();

        assertEquals(expectedSong, song);
    }

    @Test
    void return_a_song_with_two_animals() {
        String expectedSong = "There was an old lady who swallowed a fly.\n" +
                "I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a cow...\n" +
                "...She's dead, of course!";
        SongStructureChildrenSong structure = new SongStructureChildrenSong();
        ActorsList animals = new ActorsList(Arrays.asList("fly", "cow"));
        SongComposer composer = new SongComposer(animals, structure);

        String song = composer.create();

        assertEquals(expectedSong, song);
    }

    @Test
    void return_a_song_with_eigth_animals() {
        SongStructureChildrenSong structure = new SongStructureChildrenSong();
        ActorsList animals = new ActorsList(Arrays.asList("fly", "spider", "bird", "cat", "dog", "cow", "horse","worm"));
        SongComposer composer = new SongComposer(animals, structure);

        String song = composer.create();

        assertEquals(expectedSongWith8Animals, song);
    }

    @Test
    void return_a_song_with_different_animals() {
        String expectedSong = "There was an old lady who swallowed a tiger.\n" +
                "I don't know why she swallowed a tiger - perhaps she'll die!\n" +
                "\n" +
                "There was an old lady who swallowed a zebra...\n" +
                "...She's dead, of course!";
        SongStructureChildrenSong structure = new SongStructureChildrenSong();
        ActorsList animals = new ActorsList(Arrays.asList("tiger","zebra"));
        SongComposer composer = new SongComposer(animals, structure);

        String song = composer.create();

        assertEquals(expectedSong, song);
    }
}
