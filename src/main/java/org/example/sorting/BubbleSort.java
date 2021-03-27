package org.example.sorting;


import static org.example.utils.Utils.printHorzArray;

public class BubbleSort extends SortingAlgorithms {

    public BubbleSort(int[] theArray, int arraySizeToWorkWith) {
        super(theArray, arraySizeToWorkWith);
    }

    public void execute() {
        for(int i = arraySizeToWorkWith - 1;i>1;i--) {
            for(int j=0; j<i;j++) {

                if(theArray[j] > theArray[j+1]) {
                    swapValues(j,j+1);
                    printHorzArray(i,j,arraySizeToWorkWith,theArray);

                }
                printHorzArray(i,j,arraySizeToWorkWith, theArray);
            }
        }
    }
}
