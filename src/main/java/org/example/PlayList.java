package org.example;

class PlayList {
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