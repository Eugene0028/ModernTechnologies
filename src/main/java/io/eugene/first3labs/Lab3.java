package io.eugene.first3labs;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab3 {
    public static int findMax(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static int reverseEvenDigits(int a){
//        StringBuilder result = new StringBuilder();
//        String s = String.valueOf(a);
//        for (int i = s.length() - 1; i >= 0; i--) {
//            if (Character.getNumericValue(s.charAt(i)) % 2 == 0){
//                result.append(s.charAt(i));
//            }
//        }
//
//        return Integer.parseInt(result.toString());

        return String
                .valueOf(a)
                .chars()
                .map(Character::getNumericValue)
                .filter(x -> x % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return Integer.parseInt(String.join("", list));
                        }));
    }

    public static int minDigitInNumber(int a){
        return String
                .valueOf(a)
                .chars()
                .map(Character::getNumericValue)
                .min()
                .getAsInt();
    }

    public static int getSumOfArray(int[][] A){
        int summa = 0;

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] % 2 != 0){
                    summa += A[i][j];
                }
            }
        }
        return summa;
    }

}
