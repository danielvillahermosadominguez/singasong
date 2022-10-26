package org.example.song;

public class Song extends Lyric {

    public Song() {
        super();
    }

    public void addVerse(Verse verse) {
        this.lyrics.add(verse);
    }
}
