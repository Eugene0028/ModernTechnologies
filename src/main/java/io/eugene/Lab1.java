package io.eugene;

/**
 * Hello world!
 *
 */
public class Lab1
{
    public static int[] sumArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException("Массивы должны быть одной длины");
        }
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

    public static void shiftArrayLeft(double[] arr, int shift) {
        int length = arr.length;
        double[] temp = new double[length];
        for (int i = 0; i < length; i++) {
            temp[i] = arr[(i + shift) % length];
        }
        System.arraycopy(temp, 0, arr, 0, length);
    }

    public static int findSubsequence(int[] vec, int[] seq) {
        for (int i = 0; i <= vec.length - seq.length; i++) {
            boolean match = true;
            for (int j = 0; j < seq.length; j++) {
                if (vec[i + j] != seq[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
    }
}
