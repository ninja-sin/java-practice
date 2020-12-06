package org.ninja.alogrithm;

import utils.MyPrint;

import java.util.Comparator;

public class SelectionSort {

    public static <T> void sort(T[] sourceArr, Comparator<T> comparator, boolean reverse) {
        doSort(sourceArr, comparator, reverse);
    }

    private static <T> void doSort(T[] sourceArr, Comparator<T> comparator, boolean reverse) {
        int minPos = 0;
        for (int i = 0; i < sourceArr.length - 1; i++) {
            T a = sourceArr[i];
            for (int j = i + 1; j < sourceArr.length; j++) {
                T b = sourceArr[j];
                int compare = comparator.compare(a, b);
                if (reverse) {
                    compare = -compare;
                }
                if (compare > 0) {
                    minPos = j;
                }
            }
            swap(sourceArr, i, minPos);
            MyPrint.print(sourceArr);
            System.out.println();
        }
    }

    private static <T> void swap(T[] sourceArr, int pos1, int pos2) {
        T a = sourceArr[pos1];
        T b = sourceArr[pos2];
        sourceArr[pos1] = b;
        sourceArr[pos2] = a;
    }
}
