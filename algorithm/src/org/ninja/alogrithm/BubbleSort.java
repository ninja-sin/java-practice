package org.ninja.alogrithm;

public class BubbleSort {
    public static void sort(int[] sourceArr) {
        for (int i = sourceArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (sourceArr[j] > sourceArr[j + 1]) {
                    sourceArr[j] = sourceArr[j] ^ sourceArr[j + 1];
                    sourceArr[j + 1] = sourceArr[j] ^ sourceArr[j + 1];
                    sourceArr[j] = sourceArr[j] ^ sourceArr[j + 1];
                }
            }
        }
    }
}
