package org.example.structures.doubleendedlinkedlist;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Neighbor {

    private String homeOwnerName;
    private int houseNumber;

    public Neighbor next;
    private Neighbor previous;

    public Neighbor(String homeOwnerName, int houseNumber) {
        this.homeOwnerName = homeOwnerName;
        this.houseNumber = houseNumber;
    }

    public void display() {
        log.info("homeOwnerName = {} , houseNumber = {} Private Drive",homeOwnerName,houseNumber);
    }

    public String toString() {
        return homeOwnerName;
    }
}
