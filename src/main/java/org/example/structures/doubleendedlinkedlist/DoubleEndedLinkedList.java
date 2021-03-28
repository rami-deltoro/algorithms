package org.example.structures.doubleendedlinkedlist;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DoubleEndedLinkedList {

    private Neighbor firstLink;
    private Neighbor lastLink;

    public void insertInFirstPosition(String homeOwnerName,int houseNumber) {
        final Neighbor newNeighbor = new Neighbor(homeOwnerName,houseNumber);

        if(isEmpty()) {
            lastLink = newNeighbor;
        } else {
            firstLink.setPrevious(newNeighbor);
        }

        newNeighbor.setNext(firstLink);
        firstLink = newNeighbor;
    }

    public void insertInLastPosition(String homeOwnerName,int houseNumber) {
        final Neighbor newNeighbor = new Neighbor(homeOwnerName,houseNumber);

        if(isEmpty()) {
            firstLink = newNeighbor;
        } else {
            lastLink.setNext(newNeighbor);
            newNeighbor.setPrevious(lastLink);
        }

        newNeighbor.setPrevious(lastLink);
        lastLink = newNeighbor;


    }

    public void insertInOrder(String homeOwnerName,int houseNumber) {
        final Neighbor newNeighbor = new Neighbor(homeOwnerName,houseNumber);

        Neighbor previousNeighbor = null;
        Neighbor currentNeighbor = firstLink;

        while (currentNeighbor != null && houseNumber > currentNeighbor.getHouseNumber()) {
            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.getNext();
        }

        if(previousNeighbor == null) {
            firstLink = newNeighbor;
        } else {
            previousNeighbor.setNext(newNeighbor);
        }

        newNeighbor.setNext(currentNeighbor);

    }

    public boolean insertAfterHouseNumber(String homeOwnerName,int houseNumber, int targetHouseNumber) {
        final Neighbor newNeighbor = new Neighbor(homeOwnerName,houseNumber);

        Neighbor target = null;
        Neighbor iteratedNeighbor = firstLink;

        while(iteratedNeighbor!=null && target==null) {
            if(iteratedNeighbor.getHouseNumber() == targetHouseNumber) {
                target = iteratedNeighbor;
            } else {
                iteratedNeighbor = iteratedNeighbor.getNext();
            }
        }

        if(target!=null) {
            newNeighbor.setNext(target.getNext());
            newNeighbor.setPrevious(target);
            target.setNext(newNeighbor);
        }

        return target !=null;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void display() {
        Neighbor theLink = firstLink;
        log.info("******* START *********");
        while (theLink !=null) {
            theLink.display();
            log.info("Next Link = {} \n",theLink.getNext());
            theLink = theLink.getNext();
        }

        log.info("******* END *********");

    }
}
