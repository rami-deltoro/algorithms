package org.example.recursion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TriangularNumber {

    public int getTriangularNumberNonRecursive(int number) {
        int triangularNumber = 0;

        while(number > 0) {
            triangularNumber = triangularNumber + number;
            number--;
        }

        return triangularNumber;
    }

    public int getTriangularNumberRecursive(int number) {
        log.info("Method called with number = {}",number);

        if(number == 1) {
            log.info("Returning 1");
            return 1;
        } else {
            int result = number + getTriangularNumberRecursive(number - 1);
            log.info("returning {} :: {} + getTriangularNumberRecursive({}-1)",result,number,number);
            return result;
        }
    }
}
