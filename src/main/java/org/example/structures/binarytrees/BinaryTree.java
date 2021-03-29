package org.example.structures.binarytrees;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class BinaryTree {

    private Node root;

    public Node findNode(int key) {
        Node focusNode = root;

        while(focusNode.getKey() != key) {
            if(key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else {
                focusNode = focusNode.getRightChild();
            }

            if(focusNode == null) {
                return null;
            }
        }

        return focusNode;
    }

    public void inOrderTraverseTree(Node focusNode) {
        if(focusNode!= null) {
            inOrderTraverseTree(focusNode.getLeftChild());
            log.info("InOrder Traversal :: focusNode = {}",focusNode);
            inOrderTraverseTree(focusNode.getRightChild());
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if(focusNode!= null) {
            log.info("InOrder Traversal :: focusNode = {}",focusNode);
            preOrderTraverseTree(focusNode.getLeftChild());
            preOrderTraverseTree(focusNode.getRightChild());
        }
    }

    public void postOrderTraverseTree(Node focusNode) {
        if(focusNode!= null) {
            postOrderTraverseTree(focusNode.getLeftChild());
            postOrderTraverseTree(focusNode.getRightChild());
            log.info("InOrder Traversal :: focusNode = {}",focusNode);

        }
    }

    public void addNode(final int key, final String name) {
        final Node newNode = new Node(key,name);

        if(root==null) {
            root = newNode;
        } else {
            Node focusNode = root;

            Node parent;

            while(true) {
                parent = focusNode;
                if(key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();

                    if(focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();

                    if(focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }

    }
}
