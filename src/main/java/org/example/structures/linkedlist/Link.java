package org.example.structures.linkedlist;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Link {

    private String bookName;
    private int millionsSold;

    private Link next;


    public Link(String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display() {
        log.info("BookName = {} MillionsSold = {} 000,000",bookName,millionsSold);
    }

    public String toString() {
        return bookName;
    }
}
