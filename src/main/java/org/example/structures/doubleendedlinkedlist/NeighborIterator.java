package org.example.structures.doubleendedlinkedlist;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Getter
@Slf4j
public class NeighborIterator {

    private Neighbor currentNeighbor;
    private Neighbor previousNeighbor;
    private final DoubleEndedLinkedList theNeighbors;

    public NeighborIterator(DoubleEndedLinkedList theNeighbors) {
        this.theNeighbors = theNeighbors;
        currentNeighbor = theNeighbors.getFirstLink();
        previousNeighbor = theNeighbors.getLastLink();
    }

    public boolean hasNext() {

        if(currentNeighbor.getNext() != null) {
            return true;
        } else {
            return false;
        }
    }

    public Neighbor next() {
        if(hasNext()) {
            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.getNext();

            return currentNeighbor;
        }

        return null;
    }

    public void remove() {
        if(previousNeighbor == null) {
            theNeighbors.setFirstLink(currentNeighbor.getNext());
        } else {

            previousNeighbor.setNext(currentNeighbor.getNext());

            if(currentNeighbor.getNext() == null) { //At the end of the list

                currentNeighbor = theNeighbors.getFirstLink();
                previousNeighbor = null;
            }
        }
    }
}
