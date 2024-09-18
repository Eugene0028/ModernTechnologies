package io.eugene;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTest {

    @Test
    public void testMaxOfThree() {
        assertEquals(3.0, ArrayUtils.maxOfThree(1.0, 2.0, 3.0));
        assertEquals(2.0, ArrayUtils.maxOfThree(2.0, 1.0, -5.0));
        assertEquals(0.0, ArrayUtils.maxOfThree(-1.0, 0.0, -2.0));
    }

    @Test
    public void testProductOfEvenSumIndices() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        assertEquals(1.0 * 3.0 * 5.0 * 7.0 * 9.0, ArrayUtils.productOfEvenSumIndices(array));
    }

    @Test
    public void testMinBelowMainDiagonal() {
        double[][] array = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        assertEquals(1.0, ArrayUtils.minBelowMainDiagonal(array));

        double[][] array2 = {
                {10.0, 20.0, 30.0},
                {5.0, 50.0, 60.0},
                {7.0, 3.0, 90.0}
        };
        assertEquals(3.0, ArrayUtils.minBelowMainDiagonal(array2));
    }
}

