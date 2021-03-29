package org.example.structures.hashtable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashFunction3 {
    private WordList[] theArray;
    private int arraySize;


    public HashFunction3(int size) {
        this.theArray = new WordList[size];
        arraySize = size;

        for(int i=0;i<arraySize;i++) {
            theArray[i] = new WordList();
        }
    }

    public void displayTheArray() {

        for (int i = 0; i < arraySize; i++) {

            System.out.println("theArray Index " + i);

            theArray[i].displayWordList();

        }

    }


    public Word find(String wordToFind) {
        int hashKey = stringHashFunction(wordToFind);

        return theArray[hashKey].find(hashKey,wordToFind);
    }

    public void addArray(String[][] elementsToAdd) {
        for(int i=0;i<elementsToAdd.length;i++) {
            String word = elementsToAdd[i][0];
            String definition = elementsToAdd[i][1];

            Word newWord = new Word(word,definition);
            insert(newWord);
        }
    }

    public void insert(Word newWord) {
        String wordToHash = newWord.getTheWord();
        int hashKey = stringHashFunction(wordToHash);

        theArray[hashKey].insert(newWord,hashKey);
    }

    public int stringHashFunction(String wordToHash) {
        int hashKeyValue = 0;

        for(int i=0;i<wordToHash.length();i++) {
            int charCode = wordToHash.charAt(i) - 96;
            int hashKeyValueTemp = hashKeyValue;
            hashKeyValue = (hashKeyValue * 27 + charCode) % arraySize;
            log.info("Hash key value temp = {} , hash key value = {}",hashKeyValueTemp,hashKeyValue);
        }


        return hashKeyValue;
    }

}
