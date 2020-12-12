package org.ninja.alogrithm;

import utils.MyPrint;

public class MergeSort {
    public static void sort(int[] sourceArr) {
//        int [] t = new int[] {3, 2, 4, 1, 6};
        int[] arr = process(sourceArr, 0, sourceArr.length - 1);
        MyPrint.print(arr);
    }

    public static int[] process(int[] arr, int rightStart, int leftEnd) {
        if (rightStart >= leftEnd) {
            return new int[]{arr[rightStart]};
        }
        int mid = rightStart + (leftEnd - rightStart) / 2;
        int[] leftArr = process(arr, rightStart, mid);
        int[] rightArr = process(arr, mid + 1, leftEnd);
//        MyPrint.print(leftArr);
//        MyPrint.print(rightArr);
        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        int[] temp = new int[rightArr.length + leftArr.length];
        int tempIndex = 0;
        int rightIndex = 0;
        int leftIndex = 0;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] <= rightArr[rightIndex]) {
                temp[tempIndex++] = leftArr[leftIndex++];
            } else {
                temp[tempIndex++] = rightArr[rightIndex++];
            }
        }
        while (leftIndex < leftArr.length) {
            temp[tempIndex++] = leftArr[leftIndex++];
        }
        while (rightIndex < rightArr.length) {
            temp[tempIndex++] = rightArr[rightIndex++];
        }
        return temp;
    }
}
