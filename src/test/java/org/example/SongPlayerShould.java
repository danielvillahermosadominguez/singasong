package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongPlayerShould {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

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
        SongPlayer player = new SongPlayer();
        Song song = new Song();
        player.print(song);
        assertEquals("\r\n", outContent.toString());
    }

    @Test
    void return_a_character_RN_when_a_character_is_written() {
        SongPlayer player = new SongPlayer();
        Song song = new Song();
        song.addVerse(new Verse(Arrays.asList(new Phrase("a"))));
        player.print(song);
        assertEquals("a\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_a_newline_is_written() {
        SongPlayer player = new SongPlayer();
        Song song = new Song();
        song.addVerse(new Verse(Arrays.asList(new Phrase("\n"))));
        player.print(song);
        assertEquals("\n\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_a_phrase_with_a_new_line() {
        SongPlayer player = new SongPlayer();
        Song song = new Song();
        song.addVerse(new Verse(Arrays.asList(new Phrase("There was an old lady who swallowed a fly.\n"))));
        player.print(song);
        assertEquals("There was an old lady who swallowed a fly.\n\r\n", outContent.toString());
    }

    @Test
    void return_RN_when_a_phrase_with_two_new_lines() {
        SongPlayer player = new SongPlayer();
        Song song = new Song();
        song.addVerse(new Verse(Arrays.asList(new Phrase("I don't know why she swallowed a fly - perhaps she'll die!\n" + "\n"))));
        player.print(song);
        assertEquals("I don't know why she swallowed a fly - perhaps she'll die!\n" +
                "\n\r\n", outContent.toString());
    }
}
