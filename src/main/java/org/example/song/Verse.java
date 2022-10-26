package org.example.song;

import org.example.song.Lyric;
import org.example.song.Phrase;

import java.util.List;

public class Verse extends Lyric {
    public Verse(List<Phrase> phrases) {
       this.lyrics.addAll(phrases);
    }
}
