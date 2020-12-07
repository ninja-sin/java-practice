package org.ninja.alogrithm;

public class InsertionSort {
    public static void sort(int[] sourceArr) {
        for (int i = 0; i < sourceArr.length; i++) {
            for (int j = i; j > 0 && sourceArr[j] < sourceArr[j - 1]; j--) {
                sourceArr[j] = sourceArr[j] ^ sourceArr[j - 1];
                sourceArr[j - 1] = sourceArr[j] ^ sourceArr[j - 1];
                sourceArr[j] = sourceArr[j] ^ sourceArr[j - 1];
            }
        }
    }
}
