package org.example.search;

import org.example.sorting.SortingAlgorithms;

import static org.example.utils.Utils.printHorzArray;




/*
    Has to be sorted
    Does not work well when there is duplicate numbers

 */
public class BinarySearch {

    public void binarySearchForValue(int targetValue, SortingAlgorithms sortingAlgorithms) {
        final int arraySizeToWorkWith = sortingAlgorithms.getArraySizeToWorkWith();
        final int[] theArray = sortingAlgorithms.getTheArray();

        int lowIndex = 0;
        int highIndex = arraySizeToWorkWith - 1;

        while(lowIndex <= highIndex) {
            int middleIndex = (highIndex + lowIndex) / 2;

            if(theArray[middleIndex] < targetValue) {
                lowIndex = middleIndex + 1;
            } else if(theArray[middleIndex] > targetValue) {
                highIndex = middleIndex - 1 ;
            } else {
                System.out.println("\n Found a match for target value = "+ targetValue+ " at index "+middleIndex);
                break;
            }


            printHorzArray(middleIndex,-1,arraySizeToWorkWith,theArray);
        }
    }
}
