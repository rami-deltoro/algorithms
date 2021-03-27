package org.example;

import org.example.search.BinarySearch;
import org.example.search.LinearSearch;
import org.example.sorting.InsertionSort;
import org.example.sorting.SelectionSort;
import org.example.structures.ArrayStructure;
import org.example.sorting.BubbleSort;


public class App 
{
    private static final int ARRAY_SIZE_TO_WORK_WITH = 10;
    private static final ArrayGenerator arrayGenerator = new ArrayGenerator(ARRAY_SIZE_TO_WORK_WITH,50,10);


    public static void main( String[] args ) {
        executeInsertionSort();
    }

    private static void executeInsertionSort() {
        final int[] theArray = arrayGenerator.generateRandomArray();
        final InsertionSort insertionSort = new InsertionSort(theArray,ARRAY_SIZE_TO_WORK_WITH);

        insertionSort.execute();
    }

    private static void executeSelectionSort() {
        final int[] theArray = arrayGenerator.generateRandomArray();
        final SelectionSort selectionSort = new SelectionSort(theArray,ARRAY_SIZE_TO_WORK_WITH);

        selectionSort.execute();

    }



    private static void executeBubbleSort() {
        final int[] theArray = arrayGenerator.generateRandomArray();
        final BubbleSort bubbleSort = new BubbleSort(theArray,ARRAY_SIZE_TO_WORK_WITH);

        bubbleSort.execute();
        System.out.println("********* BINARY SEARCH ************");

        final BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearchForValue(11,bubbleSort);
    }

    private static void executeArrayStructures() {
        final int[] theArray = arrayGenerator.generateRandomArray();
        final ArrayStructure arrayStructure = new ArrayStructure(theArray,ARRAY_SIZE_TO_WORK_WITH);

        arrayStructure.printArray();
        System.out.println("Index at 3 is : " + arrayStructure.getValueAtIndex(3));
        System.out.println("Does Array have value 17 : " + arrayStructure.hasValue(17));

        arrayStructure.delete(3);
        arrayStructure.printArray();

        arrayStructure.insertValue(55);
        arrayStructure.printArray();

        LinearSearch linearSearch = new LinearSearch();

        System.out.println("Indexes that have the value 14 in "+linearSearch.execute(14,arrayStructure.getArraySizeToWorkWith(),arrayStructure.getTheArray()));
    }

}
