package org.example.sorting;


import org.example.utils.Utils;

/*
    Fastest of elementary sorts
 */
public class InsertionSort extends SortingAlgorithms{

    public InsertionSort(int[] theArray, int arraySizeToWorkWith) {
        super(theArray, arraySizeToWorkWith);
    }

    public void execute() {
        for(int i =1; i < arraySizeToWorkWith;i++) {
            int j =i;

            int toInsert = theArray[i];

            while((j>0) && (theArray[j-1]) > toInsert) {

                theArray[j] = theArray[j-1];
                j--;
                Utils.printHorzArray(i,j,arraySizeToWorkWith,theArray);
            }

            theArray[j] = toInsert;

            Utils.printHorzArray(i,j,arraySizeToWorkWith,theArray);

            System.out.println("\n Array[i] = " + theArray[i] + " Array[i] = " + theArray[j] + " toInsert = "+toInsert);

        }
    }
}
