package org.example.player;

import org.example.song.Song;

public class SongPlayer {
    public void print(Song song) {
        System.out.println(song.convertToString());
    }
}
