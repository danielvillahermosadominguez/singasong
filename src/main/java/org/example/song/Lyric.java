package org.example.song;

import java.util.ArrayList;
import java.util.List;

public class Lyric {
    protected final List<Lyric> lyrics;

    public Lyric() {
        this.lyrics = new ArrayList<>();
    }

    public String convertToString() {
        String result = "";
        for (Lyric verse : lyrics) {
            result += verse.convertToString();
        }
        return result;
    }
}
