package org.example.structures;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *          Queue : First item put in is the First item out. FIFO
 */
@Getter
@Slf4j
public class TheQueue {

    private final String[] queueArray;
    private final int queueSize;
    private int front;
    private int rear;
    private int numberOfItems;

    public TheQueue(int queueSize) {
        this.queueSize = queueSize;
        queueArray = new String[queueSize];

        Arrays.fill(queueArray,"-1");
    }

    public void priorityInsert(String input) {
        int i;

        log.info("numberOfItems = {}",numberOfItems);
        if(numberOfItems == queueSize) {
            log.warn("Queue is full. {} not added",input);
        }
        else if(numberOfItems == 0) {
            insert(input);
        } else {
            for(i = numberOfItems-1;i>=0;i--) {
                log.info("i = {}",i);

                if(Integer.parseInt(input) < Integer.parseInt(queueArray[i])) {
                    queueArray[i+1] = queueArray[i];
                } else {
                    break;
                }
            }

            queueArray[i+1] = input;
            rear++;
            numberOfItems++;
        }
    }

    public void insert(String input) {
        if(numberOfItems + 1 <=queueSize) {
            queueArray[rear] = input;
            rear++;
            numberOfItems++;

            log.info("INSERT {} was added to Queue",input);
        } else {
            log.warn("Queue is full");
        }
    }

    public void remove() {
         if(numberOfItems > 0) {
             log.info("Remove {} was removed" ,queueArray[front]);
             queueArray[front] = "-1";

             front++;

             numberOfItems--;
         } else {
             log.warn("Queue is empty");
         }
    }

    public void peek() {
        log.info("The first elementr is {}",queueArray[front]);
    }
}
