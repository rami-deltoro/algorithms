package org.example.structures.hashtable;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *  Prime numbers in hash functions help minimize collisions.
 */
@Getter
@Slf4j
public class HashFunction {

    private String[] theArray;
    private int arraySize;
    private int itemsInArray;

    public HashFunction(int arraySize) {
        this.arraySize=arraySize;
        theArray = new String[arraySize];
        Arrays.fill(theArray,"-1");
    }

    public void hashFunction(String[] stringsForArray) {

        for (int i=0;i < stringsForArray.length;i++) {
            String element = stringsForArray[i];
            theArray[Integer.parseInt(element)] = element;
        }
    }

    public void hashFunction2(String[] stringsForArray) {
        for (int i=0;i < stringsForArray.length;i++) {
            String element = stringsForArray[i];


            int arrayIndex = Integer.parseInt(element) % arraySize;
            log.info("Mod index = {} for value = {}",arrayIndex,element);

            while (!theArray[arrayIndex].equals("-1")) {
                ++arrayIndex;

                log.info("Collision trying {} index instead",arrayIndex);

                arrayIndex%= arraySize;
            }

            theArray[arrayIndex] = element;

        }
    }

    /*
        Avoid clustering.
     */
    public void doubleHashFunction(String[] stringsForArray) {
        for (int i=0;i < stringsForArray.length;i++) {
            String element = stringsForArray[i];


            int arrayIndex = Integer.parseInt(element) % arraySize;
            int stepDistance = 5 - (Integer.parseInt(element) & 5);

            log.info("Mod index = {} for value = {}",arrayIndex,element);

            while (!theArray[arrayIndex].equals("-1")) {
                arrayIndex+=stepDistance;

                log.info("Collision trying {} index instead",arrayIndex);

                arrayIndex%= arraySize;
            }

            theArray[arrayIndex] = element;

        }
    }

    public boolean isPrime(int number) {
        if(number % 2 == 0) {
            return false;
        }

        for(int i = 3; i * i <=number;i+=2) {
            if(number % i == 0 ) {
                return false;
            }

        }

        return true;
    }

    public int getNextPrime(int minNumberToCheck) {

        for(int i = minNumberToCheck;true;i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    public void increaseArraySize(int minArraySize) {
        int newArraySize = getNextPrime(minArraySize);
        moveOldArray(newArraySize);
    }


    private void moveOldArray(int newArraySize) {

        String[] cleanArray = removeEmptySpacesInArray(theArray);
        theArray = new String[newArraySize];
        arraySize = newArraySize;
        log.info("new Array Size = {}",newArraySize);
        Arrays.fill(theArray,"-1");

        hashFunction2(cleanArray);

    }

    private String[] removeEmptySpacesInArray(String[] arrayToClean) {
        List<String> stringList = new ArrayList<>();

        for(String theString : arrayToClean) {
            if(!theString.equals("-1") && !theString.equals("")) {
                stringList.add(theString);
            }
        }

        return stringList.toArray(new String[0]);
    }

    public String findKey(String key) {
        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        int stepDistance = 5 - (Integer.parseInt(key) & 5);


        while (!theArray[arrayIndexHash].equals("-1")) {

            if(theArray[arrayIndexHash].equals(key)) {
                log.info("{} was found in index = {}",key,arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            arrayIndexHash = arrayIndexHash + stepDistance;

            arrayIndexHash = arrayIndexHash % arraySize;
        }

        return null;
    }

    public String findDoubleHashedKey(String key) {
        int arrayIndexHash = Integer.parseInt(key) % arraySize;


        while (!theArray[arrayIndexHash].equals("-1")) {

            if(theArray[arrayIndexHash].equals(key)) {
                log.info("{} was found in index = {}",key,arrayIndexHash);
                return theArray[arrayIndexHash];
            }

            ++arrayIndexHash;

            arrayIndexHash = arrayIndexHash % arraySize;
        }

        return null;
    }

}

