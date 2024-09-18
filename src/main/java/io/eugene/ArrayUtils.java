package io.eugene;

public class ArrayUtils {

    // Поиск максимума из трех чисел
    public static double maxOfThree(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    // Произведение элементов с четной суммой индексов
    public static double productOfEvenSumIndices(double[][] array) {
        double product = 1.0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    product *= array[i][j];
                }
            }
        }
        return product;
    }

    // Минимум на и ниже главной диагонали
    public static double minBelowMainDiagonal(double[][] array) {
        double min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }
}
