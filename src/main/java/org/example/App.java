package org.example;

import org.example.structures.ArrayStructure;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final int ARRAY_SIZE_TO_WORK_WITH = 10;
    private static final ArrayGenerator arrayGenerator = new ArrayGenerator(ARRAY_SIZE_TO_WORK_WITH,50,10);


    public static void main( String[] args )
    {
        final int[] theArray = arrayGenerator.generateRandomArray();
        final ArrayStructure arrayStructure = new ArrayStructure(theArray,ARRAY_SIZE_TO_WORK_WITH);

        arrayStructure.printArray();
        System.out.println("Index at 3 is : " + arrayStructure.getValueAtIndex(3));
        System.out.println("Does Array have value 17 : " + arrayStructure.hasValue(17));

        arrayStructure.delete(3);
        arrayStructure.printArray();

        arrayStructure.insertValue(55);
        arrayStructure.printArray();

        System.out.println("Indexes that have the value 14 in "+arrayStructure.linearSearch(14));

    }

}
