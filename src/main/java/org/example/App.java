package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.recursion.Factorial;
import org.example.recursion.TriangularNumber;
import org.example.search.BinarySearch;
import org.example.search.LinearSearch;
import org.example.sorting.*;
import org.example.structures.ArrayStructure;
import org.example.structures.TheQueue;
import org.example.structures.TheStack;
import org.example.structures.binarytrees.BinaryTree;
import org.example.structures.doubleendedlinkedlist.DoubleEndedLinkedList;
import org.example.structures.doubleendedlinkedlist.NeighborIterator;
import org.example.structures.hashtable.HashFunction;
import org.example.structures.hashtable.HashFunction3;
import org.example.structures.linkedlist.LinkList;
import org.example.utils.Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
        Data Structures like Arrays, trees, Lists best used to represent real objects.

        Stacks and queues are used to complete a tasks, it is a programmes tool and then discarded.

 */

@Slf4j
public class App 
{
    public static String[][] elementsToAdd = {
            { "ace", "Very good" },
            { "act", "Take action" },
            { "add", "Join (something) to something else" },
            { "age", "Grow old" },
            { "ago", "Before the present" },
            { "aid", "Help, assist, or support" },
            { "aim", "Point or direct" },
            { "air", "Invisible gaseous substance" },
            { "all", "Used to refer to the whole quantity" },
            { "amp",
                    "Unit of measure for the strength of an electrical current" },
            { "and", "Used to connect words" }, { "ant", "A small insect" },
            { "any", "Used to refer to one or some of a thing" },
            { "ape", "A large primate" },
            { "apt", "Appropriate or suitable in the circumstances" },
            { "arc", "A part of the circumference of a curve" },
            { "are", "Unit of measure, equal to 100 square meters" },
            { "ark", "The ship built by Noah" },
            { "arm", "Two upper limbs of the human body" },
            { "art", "Expression or application of human creative skill" },
            { "ash", "Powdery residue left after the burning" },
            { "ask", "Say something in order to obtain information" },
            { "asp", "Small southern European viper" },
            { "ass", "Hoofed mammal" },
            { "ate", "To put (food) into the mouth and swallow it" },
            { "atm", "Unit of pressure" },
            { "awe", "A feeling of reverential respect" },
            { "axe", "Edge tool with a heavy bladed head" },
            { "aye", "An affirmative answer" } };

    private static final int ARRAY_SIZE_TO_WORK_WITH = 10;
    private static final ArrayGenerator arrayGenerator = new ArrayGenerator(ARRAY_SIZE_TO_WORK_WITH,50,10);


    public static void main( String[] args ) {
        executeBinaryTree();
    }


    public static void executeBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addNode(50, "Boss");
        binaryTree.addNode(25, "Vice President");
        binaryTree.addNode(15, "Office Manager");
        binaryTree.addNode(30, "Secretary");
        binaryTree.addNode(75, "Sales Manager");
        binaryTree.addNode(85, "SalesMan 1");

        binaryTree.postOrderTraverseTree(binaryTree.getRoot());

        log.info("Search for 30 ::{}",binaryTree.findNode(30));

    }
    public static void executeHashFunction3() {
        Scanner input = new Scanner(System.in);

        HashFunction3 wordHashTable = new HashFunction3(11);
        wordHashTable.addArray(elementsToAdd);


        String wordLookUp = "a";

        while (!wordLookUp.equalsIgnoreCase("x")) {

            System.out.println(": ");

            wordLookUp = input.nextLine();
            System.out.println(wordHashTable.find(wordLookUp));
        }
    }

    private static void executeHashFunction() {
        HashFunction hashFunction = new HashFunction(30);

        String[] elementsToAdd = {"1","5","17","21","26"};
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };




        hashFunction.hashFunction2(elementsToAdd3);
        hashFunction.increaseArraySize(60);
        hashFunction.findKey("660");

        log.info("Pre CLuster / double hash function array");
        Utils.displayTheStack(hashFunction.getTheArray());

        Arrays.fill(hashFunction.getTheArray(),"-1");

        log.info("After CLuster / double hash function array");

        hashFunction.doubleHashFunction(elementsToAdd3);

        Utils.displayTheStack(hashFunction.getTheArray());

        hashFunction.findDoubleHashedKey("989");






    }


    private static void executeQuickSort() {
        ArrayGenerator arrayGenerator = new ArrayGenerator(10,10,10);
        final int[] theArray = arrayGenerator.generateRandomArray();


        log.info("Original Array");
        Utils.printHorzArray(-1,-1,theArray.length,theArray);

        QuickSort quickSort = new QuickSort(theArray);
        quickSort.execute();

        log.info("After Sort Array");
        Utils.printHorzArray(-1,-1,theArray.length,theArray);
    }

    private static void executeMergeSort() {
        ArrayGenerator arrayGenerator = new ArrayGenerator(10,10,10);
        final int[] theArray = arrayGenerator.generateRandomArray();
        MergeSort mergeSort = new MergeSort();

        log.info("Original Array");
        Utils.printHorzArray(-1,-1,theArray.length,theArray);
        mergeSort.exeucte(theArray);
        log.info("Array After Sort");
        Utils.printHorzArray(-1,-1,theArray.length,theArray);

    }
    private static void executeNonRecursion() {
        TriangularNumber triangularNumber = new TriangularNumber();
        Factorial factorial = new Factorial();

        log.info("triangularNumber non Recursive 6 = {}",triangularNumber.getTriangularNumberNonRecursive(6));
        log.info("triangularNumber Recursive 6 = {}",triangularNumber.getTriangularNumberRecursive(6));

        log.info("Factorial 6 = {}",factorial.getFactorial(6));

    }

    private static void executeDoubleEndedLinkedList() {
        DoubleEndedLinkedList doubleEndedLinkedList = new DoubleEndedLinkedList();

        doubleEndedLinkedList.insertInOrder("Rami Del Toro",7);
        doubleEndedLinkedList.insertInOrder("Paulina Del Toro",6);
//        doubleEndedLinkedList.insertInOrder("Iris Tuff",8);
//        doubleEndedLinkedList.insertInOrder("John DT",12);
//        doubleEndedLinkedList.insertInOrder("Tabetha Tuff",9);
//        doubleEndedLinkedList.insertInOrder("Amanda Tuff",10);


        doubleEndedLinkedList.display();


        NeighborIterator neighborIterator = new NeighborIterator(doubleEndedLinkedList);

        neighborIterator.getCurrentNeighbor().display();
        log.info("has next ? = {}",neighborIterator.hasNext());
        neighborIterator.remove();

        doubleEndedLinkedList.display();
    }

    private static void executeLinkedList() {
        LinkList linkedList = new LinkList();

        linkedList.insertFirstLink("Data Structures",500);
        linkedList.insertFirstLink("Design Patterns",700);
        linkedList.insertFirstLink("Phoenix Project",150);
        linkedList.insertFirstLink("80/20 principle",740);

        linkedList.display();

        linkedList.removeFirst();

        linkedList.display();

        log.info("{} was found",linkedList.find("Design Patterns").getBookName());
        log.info("Is Lost in the list? {}",!(linkedList.find("Lost") == null));

        linkedList.remove("Design Patterns");

        linkedList.display();

    }

    private static void executeQueue() {
        TheQueue theQueue = new TheQueue(10);
        theQueue.priorityInsert("10");
        theQueue.priorityInsert("22");
        theQueue.priorityInsert("13");
        theQueue.priorityInsert("44");
        theQueue.priorityInsert("55");
        theQueue.priorityInsert("16");
        theQueue.priorityInsert("77");
        theQueue.priorityInsert("28");
        theQueue.priorityInsert("99");
        theQueue.priorityInsert("14");
        theQueue.priorityInsert("17");

        Utils.displayTheQueue(theQueue);

        theQueue.remove();
        Utils.displayTheQueue(theQueue);

        theQueue.peek();

    }
    private static void executeStack() {
        TheStack theStack = new TheStack(10);
        theStack.push("10");
        theStack.push("15");
        theStack.peek();
        theStack.pop();
        Utils.displayTheStack(theStack.getStackArray());
        theStack.pushMany("10 12 13 14 15");
        Utils.displayTheStack(theStack.getStackArray());
        theStack.popAll();
        Utils.displayTheStack(theStack.getStackArray());


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
