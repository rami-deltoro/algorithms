package org.example.structures.binarytrees;

import lombok.Data;
import lombok.Getter;

@Data
public class Node {

    private int key;
    private String name;
    private Node leftChild;
    private Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has a key " + key;
    }

}
