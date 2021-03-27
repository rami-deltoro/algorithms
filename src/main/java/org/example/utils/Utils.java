package org.example.utils;

import org.example.structures.TheQueue;

public class Utils {


    public static void printHorzArray(int i, int j,int arraySizeToWorkWith,int[] theArray){

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < arraySizeToWorkWith; n++){

            System.out.print("| " + n + "  ");

        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < arraySizeToWorkWith; n++){

            System.out.print("| " + theArray[n] + " ");

        }

        System.out.println("|");

        for(int n = 0; n < 51; n++)System.out.print("-");

        System.out.println();

        // END OF FIRST PART


        // ADDED FOR BUBBLE SORT

        if(j != -1){

            // ADD THE +2 TO FIX SPACING

            for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");

            System.out.print(j);

        }


        // THEN ADD THIS CODE

        if(i != -1){

            // ADD THE -1 TO FIX SPACING

            for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");

            System.out.print(i);

        }

        System.out.println();

    }


    public static void displayTheQueue(TheQueue theQueue){
        String[] queueArray = theQueue.getQueueArray();
        int front = theQueue.getFront();
        int rear = theQueue.getRear();

        int queueSize = queueArray.length;

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < queueSize; n++){


            if(queueArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", queueArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        // Number of spaces to put before the F

        int spacesBeforeFront = 3*(2*(front+1)-1);

        for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");

        System.out.print("F");

        // Number of spaces to put before the R

        int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);

        for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");

        System.out.print("R");

        System.out.println("\n");

    }

    public static void displayTheStack(String[] stackArray){
        int stackSize = stackArray.length;

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){



            if(stackArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }

}
