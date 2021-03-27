package org.example.structures;


public class ArrayStructure {

    private final int[] theArray;
    private int arraySizeToWorkWith;


    public ArrayStructure(final int[] theArray, final int arraySizeToWorkWith) {
        this.theArray=theArray;
        this.arraySizeToWorkWith=arraySizeToWorkWith;
    }

    public void insertValue(int value) {
        if(arraySizeToWorkWith < theArray.length) {
            theArray[arraySizeToWorkWith] = value;
            arraySizeToWorkWith++;
        }
    }

    public void delete(final int index) {
        if (index < arraySizeToWorkWith) {
            for (int i = index; i < (arraySizeToWorkWith - 1); i++) {
                theArray[i] = theArray[i + 1];
            }
        }


        arraySizeToWorkWith--;
    }

    public boolean hasValue(final int targetValue) {
        boolean hasValue = false;

        for(int i=0; i < arraySizeToWorkWith;i++) {
            if(theArray[i] == targetValue) {
                hasValue = true;
                break;
            }
        }

        return hasValue;
    }


    public int getValueAtIndex(final int index) {
        if(index < arraySizeToWorkWith) {
            return theArray[index];
        }

        return 0;
    }

    public void printArray() {
        System.out.println("----------");
        for(int i=0; i < arraySizeToWorkWith;i++) {
            System.out.print("| " + i +" | ");
            System.out.println(theArray[i] + " |");
        }
    }

    public int[] getTheArray() {
        return theArray;
    }

    public int getArraySizeToWorkWith() {
        return arraySizeToWorkWith;
    }
}
