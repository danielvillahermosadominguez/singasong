package org.example;

public class SongStructureChildrenSong extends SongStructureBase {

    private String endOfVerse;

    @Override
    protected void configureRandomPhrases() {
        addSpecialPhraseForEachVerse("");
        addSpecialPhraseForEachVerse("That wriggled and wiggled and tickled inside her.\n");
        addSpecialPhraseForEachVerse("How absurd to swallow a %s.\n");
        addSpecialPhraseForEachVerse("Fancy that to swallow a %s!\n");
        addSpecialPhraseForEachVerse("What a hog, to swallow a %s!\n");
        addSpecialPhraseForEachVerse("I don't know how she swallowed a %s!\n");
        addTemplateForFirstPhrase("There was an old lady who swallowed a %s%s\n");
        addTemplateRefrainOfTheVerse("She swallowed the %s to catch the %s%s\n");
        addFinalPhrase("There was an old lady who swallowed a %s...\n" +
                "...She's dead, of course!");
        setTemplateEndOfVerse("I don't know why she swallowed a %s - perhaps she'll die!\n\n");
    }
}
