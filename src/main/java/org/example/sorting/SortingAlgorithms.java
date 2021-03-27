package org.example.sorting;


public class SortingAlgorithms {

    protected final int[] theArray;

    protected int arraySizeToWorkWith;

    public SortingAlgorithms(int[] theArray, int arraySizeToWorkWith) {
        this.theArray = theArray;
        this.arraySizeToWorkWith = arraySizeToWorkWith;
    }


    public void swapValues(int indexOne, int indexTwo) {
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }


    public int[] getTheArray() {
        return theArray;
    }

    public int getArraySizeToWorkWith() {
        return arraySizeToWorkWith;
    }
}
