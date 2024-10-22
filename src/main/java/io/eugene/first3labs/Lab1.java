package io.eugene.first3labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;

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
        
        Integer n = 10;
        Integer[] treug = new Integer[n];

        for (int i = 1; i <= n; i++) {
            treug[i-1] = i * (i + 1) / 2;
        }
        print(treug);


        Integer[] kvd = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        print(kvd);


        Integer[] merge = new Integer[n * 2];
        for (int i = 0; i < n; i++) {
            merge[i] = treug[i];
        }
        for (int i = n; i < n * 2; i++) {
            merge[i] = kvd[i - n];
        }
        print(merge);


        Arrays.sort(merge);
        print(merge);


        List<Integer> z = new ArrayList<>(Arrays.asList(merge));
        z.remove(0);
        merge = z.toArray(new Integer[z.size()]);
        print(merge);

        merge = arrayUnique(merge);
        print(merge);

    }

    public static Integer[] arrayUnique(Integer [] res) {
        var s = new HashSet<Integer>();
        Arrays.stream(res).forEach(x -> s.add(x));
        var z = new Integer[s.size()];
        int i = 0;
        for (var el : s) z[i++] = el;
        return z;
    }

    public static void print(Integer[] arr){
        Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

}
