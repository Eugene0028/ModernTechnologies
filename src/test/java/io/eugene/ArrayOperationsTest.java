package io.eugene;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTest {

    // Тест для метода sumArrays
    @Test
    public void testSumArrays() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        int[] expected = {5, 7, 9};
        assertArrayEquals(expected, App1.sumArrays(a, b));
    }

    @Test
    public void testSumArraysWithZeros() {
        int[] a = {0, 0, 0};
        int[] b = {1, 2, 3};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, App1.sumArrays(a, b));
    }

    @Test
    public void testSumArraysDifferentLength() {
        int[] a = {1, 2};
        int[] b = {3, 4, 5};
        assertThrows(IllegalArgumentException.class, () -> App1.sumArrays(a, b));
    }

    // Тест для метода shiftArrayLeft
    @Test
    public void testShiftArrayLeft() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        App1.shiftArrayLeft(arr, 2);
        double[] expected = {3.0, 4.0, 5.0, 1.0, 2.0}; // Ожидаем результат после сдвига
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testShiftArrayLeftWithNegativeShift() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertThrows(IndexOutOfBoundsException.class, () -> App1.shiftArrayLeft(arr, -1));
    }

    @Test
    public void testShiftArrayLeftWithMoreThanLength() {
        double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0};
        App1.shiftArrayLeft(arr, 7); // Сдвиг больше длины массива
        double[] expected = {3.0, 4.0, 5.0, 1.0, 2.0}; // Ожидаем результат после сдвига
        assertArrayEquals(expected, arr);
    }

    // Тест для метода findSubsequence
    @Test
    public void testFindSubsequence() {
        int[] vec = {1, 2, 3, 4, 5};
        int[] seq = {3, 4};
        int expectedIndex = 2; // Ожидаем, что подпоследовательность начнется с индекса 2
        assertEquals(expectedIndex, App1.findSubsequence(vec, seq));
    }

    @Test
    public void testFindSubsequenceNotFound() {
        int[] vec = {1, 2, 3, 4, 5};
        int[] seq = {6, 7};
        int expectedIndex = -1; // Ожидаем, что подпоследовательность не найдена
        assertEquals(expectedIndex, App1.findSubsequence(vec, seq));
    }

    @Test
    public void testFindSubsequenceAtStart() {
        int[] vec = {1, 2, 3, 4, 5};
        int[] seq = {1, 2};
        int expectedIndex = 0; // Ожидаем, что подпоследовательность начнется с индекса 0
        assertEquals(expectedIndex, App1.findSubsequence(vec, seq));
    }

}
