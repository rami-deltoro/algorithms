package org.example.sorting;

import org.example.utils.Utils;

public class SelectionSort extends SortingAlgorithms {

    public SelectionSort(int[] theArray, int arraySizeToWorkWith) {
        super(theArray, arraySizeToWorkWith);
    }

    public void execute() {

        for(int i = 0 ;i < arraySizeToWorkWith ; i++) {
            int min = i;

            for(int j = i; j < arraySizeToWorkWith ; j++) {


                if(theArray[min] > theArray[j]) {
                    min = j;
                }
            }

            swapValues(i,min);
            Utils.printHorzArray(i, -1,arraySizeToWorkWith,theArray);
        }
    }
}
