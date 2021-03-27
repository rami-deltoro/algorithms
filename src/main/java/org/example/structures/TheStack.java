package org.example.structures;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.example.utils.Utils;

import java.util.Arrays;

/**
 *          Stacks : First item pulled out is the last item in. LIFO
 */
@Getter
@Slf4j
public class TheStack {

    private String[] stackArray;
    private int stacksize;
    private int topOfStack = -1;

    public TheStack(int stacksize) {
        this.stacksize = stacksize;
        stackArray = new String[stacksize];

        Arrays.fill(stackArray,"-1");
    }

    public void push(String input) {

        if(topOfStack + 1 < stacksize) {
            topOfStack ++;
            stackArray[topOfStack] = input;
            Utils.displayTheStack(stackArray);
            log.info("PUSH {}  Was added to the Stack",input);

        } else {
            log.warn("Error :: Stack is Full.");
        }

    }

    public String pop() {
        Utils.displayTheStack(stackArray);

        if(topOfStack >= 0) {

            stackArray[topOfStack] = "-1";

            return  stackArray[topOfStack--];
        } else {
            log.info("INFO :: Stack is empty");
        }


        return "-1";
    }

    /*
        Not using string.split for practice reasons.
     */
    public void pushMany(String multipleValues) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<multipleValues.length();i++) {
            if(' ' != multipleValues.charAt(i)) {
                stringBuilder.append(multipleValues.charAt(i));
            }
            else {
                push(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }

        if(stringBuilder.length() > 0) {
            push(stringBuilder.toString());
        }
    }

    public void popAll() {
        for(int i = topOfStack; i>=0;i--) {
            pop();
        }
    }

    public String peek() {

        Utils.displayTheStack(stackArray);

        log.info("PEEK {} Is at top of the stack",stackArray[topOfStack]);

        return stackArray[topOfStack];

    }


}
