package org.ninja.alogrithm;

public class ShellSort {
    public static void sort(int[] sourceArr) {
        int h = 1;
        while (h < sourceArr.length / 3) {
            h = 3 * h + 1;
        }
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < sourceArr.length; i++) {
                for (int j = i; j > gap - 1 && sourceArr[j] < sourceArr[j - gap]; j -= gap) {
                    sourceArr[j] = sourceArr[j] ^ sourceArr[j - gap];
                    sourceArr[j - gap] = sourceArr[j] ^ sourceArr[j - gap];
                    sourceArr[j] = sourceArr[j] ^ sourceArr[j - gap];
                }
            }
        }
    }
}
