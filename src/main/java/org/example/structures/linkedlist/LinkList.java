package org.example.structures.linkedlist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkList {

    private Link firstLink;


    public boolean isEmpty() {
        return firstLink == null;
    }

    public void insertFirstLink(String bookName,int millionsSold) {
        Link newLink = new Link(bookName,millionsSold);
        newLink.setNext(firstLink);
        firstLink=newLink;
    }

    public Link removeFirst() {
        Link linkReference = firstLink;

        if(isEmpty()) {
            log.info("Nothing to Remove. Link List is empty");
        } else {
            firstLink = firstLink.getNext();
        }

        return linkReference;
    }

    public void display() {
        Link theLink = firstLink;
        log.info("\n********** Start **********\n");
        while(theLink !=null) {
            theLink.display();
            log.info("Next Link : {}", theLink.getNext());

            theLink = theLink.getNext();
        }

        log.info("\n********** End **********\n");

    }

    public Link find(String bookName) {
        Link theLink = firstLink;

        if(!isEmpty()) {
            while(!bookName.equals(theLink.getBookName())) {

                if(theLink.getNext() == null) {
                    return null;
                } else {
                    theLink = theLink.getNext();
                }
            }
        } else {
            log.info("Nothing to find. Link List is empty");
        }

        return theLink;
    }

    public Link remove(String bookName) {
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while(!bookName.equals(currentLink.getBookName())) {
            if(currentLink.getNext() == null) {
                return null;
            } else {
                previousLink = currentLink;
                currentLink = currentLink.getNext();
            }
        }

        if(currentLink == firstLink.getNext()) {
            firstLink = currentLink.getNext();
        } else {
            previousLink.setNext(currentLink.getNext());
        }

        return currentLink;
    }
}
