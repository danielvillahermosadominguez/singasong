package org.example;

class Song {
    private final SongComposer composer;
    private final SongPrinter printer;

    public Song(SongComposer composer, SongPrinter printer) {
        this.composer = composer;
        this.printer = printer;
    }

    public void Play() {
        printer.print(composer.create());
    }
}