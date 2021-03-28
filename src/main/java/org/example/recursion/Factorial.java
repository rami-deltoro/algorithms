package org.example.recursion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Factorial {


    public int getFactorial(int number) {
        if(number == 1) {
            return 1;
        } else {
            int result = number * getFactorial(number - 1);
            log.info("result = {} :: {} * getFactorial({} - 1)",result,number,number);
            return result;
        }
    }
}
