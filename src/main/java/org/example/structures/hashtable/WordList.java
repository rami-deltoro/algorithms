package org.example.structures.hashtable;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WordList {

    private Word firstWord = null;


    public Word find(int hashKey,String wordToFind) {
        Word current = firstWord;

        while(current!=null && current.getKey() <= hashKey) {
            if(current.getTheWord().equals(wordToFind)) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }
    public void displayWordList() {
        Word current = firstWord;


        while(current!=null) {
            log.info("{}",current);
            current = current.getNext();
        }
    }

    public void insert(Word newWord, int hashKey) {
        Word previous = null;
        Word current = firstWord;

        newWord.setKey(hashKey);

        while(current !=null && newWord.getKey() > current.getKey()) {
            previous = current;
            current = current.getNext();
        }

        if(previous == null) {
            firstWord = newWord;
        } else {
            previous.setNext(newWord);
        }

        newWord.setNext(current);

    }

}
