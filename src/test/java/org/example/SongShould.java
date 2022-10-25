package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongShould {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

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

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void return_a_empty_string_when_the_screen_is_clean() {
        assertEquals("", outContent.toString());
    }

    @Test
    void return_a_RN_when_an_empty_value_is_written() {
        Song song = new Song();
        song.print("");
        assertEquals("\r\n", outContent.toString());
    }

    @Test
    void return_a_character_RN_when_a_character_is_written() {
        Song song = new Song();
        song.print("a");
        assertEquals("a\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_a_newline_is_written() {
        Song song = new Song();
        song.print("\n");
        assertEquals("\n\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_a_phrase_with_a_new_line() {
        Song song = new Song();
        song.print("There was an old lady who swallowed a fly.\n");
        assertEquals("There was an old lady who swallowed a fly.\n\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_a_phrase_with_two_new_lines() {
        Song song = new Song();
        song.print("I don't know why she swallowed a fly - perhaps she'll die!\n" + "\n");
        assertEquals("I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_original_song_is_printed() {
        List<String> animals = Arrays.asList("fly", "spider", "bird", "cat", "dog", "cow");
        Song song = new Song();
        song.create(animals);
        assertEquals(expected_full_song + "\r\n", outContent.toString());
    }
}
