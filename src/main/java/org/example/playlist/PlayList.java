package org.example.playlist;

import org.example.composer.SongComposer;
import org.example.player.SongPlayer;
import org.example.song.Song;

public class PlayList {
    private final SongComposer composer;
    private final SongPlayer player;

    public PlayList(SongComposer composer, SongPlayer player) {
        this.composer = composer;
        this.player = player;
    }

    public void Play() {
        Song song = composer.create();
        player.print(song);
    }
}