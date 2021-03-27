package org.example.search;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public List<Integer> execute(int value,int arraySizeToWorkWith,int[] theArray) {
        final List<Integer> indexesFound = new ArrayList<>();

        for(int i = 0 ; i < arraySizeToWorkWith ; i++) {

            if(theArray[i] == value) {
                indexesFound.add(i);
            }
        }

        return indexesFound;

    }
}
