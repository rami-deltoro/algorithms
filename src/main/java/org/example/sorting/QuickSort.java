package org.example.sorting;

/*
    O(nlogn) average time = if we pick median pivot
    O(n^2) worst, if we have pivot the smallest element
 */
public class QuickSort {

    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void execute() {
        quicksort(0,array.length-1);
    }

    private void quicksort(int left, int right) {
        if(left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int index = partition(left,right,pivot);
        quicksort(left,index-1);
        quicksort(index,right);

    }

    private int partition(int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swapValues(left,right);
                left++;
                right--;
            }
        }

        return left;

    }

    public void swapValues(int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
