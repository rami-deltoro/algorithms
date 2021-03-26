package org.example;

public class ArrayGenerator {

    private final int arraySizeToWorkWith;
    private final int maxArraySize;
    private final int upperBoundValueInArray;

    public ArrayGenerator(final int arraySizeToWorkWith, final int maxArraySize, final int upperBoundValueInArray) {
        this.arraySizeToWorkWith=arraySizeToWorkWith;
        this.maxArraySize=maxArraySize;
        this.upperBoundValueInArray=upperBoundValueInArray;
    }

    public int[] generateRandomArray() {
        final int[] theArray = new int[maxArraySize];
        for(int i = 0; i < arraySizeToWorkWith ; i ++) {
            theArray[i] = (int)(Math.random()*upperBoundValueInArray)+upperBoundValueInArray;
        }

        return theArray;
    }
}
