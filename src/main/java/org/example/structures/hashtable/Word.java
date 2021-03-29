package org.example.structures.hashtable;

import lombok.Data;

@Data
public class Word {


    private String theWord;
    private String definition;
    private int key;
    private Word next;

    public Word(String theWord, String definition) {
        this.theWord = theWord;
        this.definition = definition;
    }

    public String toString() {
        return theWord + " : " + definition;
    }
}
