package io.eugene;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab3Test {

    @Test
    void findMax() {
        int expected = 5;
        int result = Lab3.findMax(1,2,5);
        assertEquals(expected, result);
    }

    @Test
    void reverseEvenDigits() {
        int a = 12345;
        int expected = 42;
        int result = Lab3.reverseEvenDigits(a);
        assertEquals(expected, result);
    }

    @Test
    void minDigitInNumber() {
        int a = 62543;
        int expected = 2;
        int result = Lab3.minDigitInNumber(a);
        assertEquals(expected, result);
    }

    @Test
    void getSumOfArray() {
        int[][] A = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,13,9}
        };
        int expected = 20;
        int result = Lab3.getSumOfArray(A);
        assertEquals(expected, result);
    }
}