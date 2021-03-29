package org.example.structures.hashtable;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

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


            int arrayIndex = Integer.parseInt(element) % 29;
            log.info("Mod index = {} for value = {}",arrayIndex,element);

            while (!theArray[arrayIndex].equals("-1")) {
                ++arrayIndex;

                log.info("Collision trying {} index instead",arrayIndex);

                arrayIndex%= arraySize;
            }

            theArray[arrayIndex] = element;

        }
    }

    public String findKey(String key) {
        int arrayIndexHash = Integer.parseInt(key) % 29;


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
