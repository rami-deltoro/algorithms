package org.example.sorting;

import lombok.extern.slf4j.Slf4j;

/*
    O(nlogn) time
    O(n) space
    https://stackoverflow.com/questions/7801861/why-is-merge-sort-worst-case-run-time-o-n-log-n
 */
@Slf4j
public class MergeSort {

    private int[] tempArray;


    /*
         setup temp array
         call helper recursive method with parameters start to end indexes.
     */
    public void exeucte(int[] array) {
        tempArray = new int[array.length];
        mergeSort(array,0,array.length-1,"original");
    }

    /*
        Algorithm :
        1. Find middle point
        2. Split array down the middle
        3. Sort and Merge each half piece - https://www.youtube.com/watch?v=KF2j-9iSf4Q
     */
    private void mergeSort(int[] array, int leftStart, int rightEnd,String caller) {
        if(leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;


        mergeSort(array,leftStart, middle,"left-middle");
        mergeSort(array,middle+1,rightEnd,"middle-right");
        mergeHalves(array,leftStart,rightEnd,caller);

    }

    /*
        Add each element from each half into a new array and then finally add any remaining elementrs.
     */
    private void mergeHalves(int[] array, int leftStart,int rightEnd,String caller) {
        log.info("Merging halves for leftStart = {} , rightEnd = {} caller = {}",leftStart,rightEnd,caller);
        int leftEnd = (leftStart + rightEnd) / 2; // Same as line 22 - middle
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd) {
            if(array[left] <= array[right]) {
                tempArray[index] = array[left];
                left++;
            } else {
                tempArray[index] = array[right];
                right++;
            }
            index++;

        }

        System.arraycopy(array,left,tempArray,index,leftEnd-left+1);
        System.arraycopy(array,right,tempArray,index,rightEnd-right+1);
        System.arraycopy(tempArray,leftStart,array,leftStart,size);


    }

}
