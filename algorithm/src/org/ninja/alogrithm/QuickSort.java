package org.ninja.alogrithm;

import org.ninja.utils.ArrayUtils;

public class QuickSort {

    public static void sort(int[] sourceArr, int v) {
        if (v == 1) {
            sortV1(sourceArr);
            return;
        } else if (v == 2) {
            sortV2(sourceArr);
            return;
        } else if (v == 3) {
            sortV3(sourceArr);
            return;
        }
    }

    public static void sortV1(int[] sourceArr) {
        process1(sourceArr, 0, sourceArr.length - 1);
    }

    public static void process1(int[] arr, int start, int end) {
        if (start >= end) return;
        int index = partitionV1(arr, start, end);
        process1(arr, start, index - 1);
        process1(arr, index + 1, end);
    }

    public static int partitionV1(int[] arr, int start, int end) {
        int less = start;
        int more = end;
        while (less < more) {
            if (arr[less] <= arr[end]) less++;
            else if (arr[less] > arr[end]) {
                ArrayUtils.swap(arr, less, --more);
            }
        }
        ArrayUtils.swap(arr, more, end);
        return more;
    }

    public static void sortV2(int[] arr) {
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int start, int end) {
        if (start >= end) return;
        int[] indexInfo = partitionV2(arr, start, end);
        process2(arr, start, indexInfo[0]);
        process2(arr, indexInfo[1], end);
    }

    public static int[] partitionV2(int[] arr, int start, int end) {
        int less = start - 1;
        int more = end;
        while (start < more) {
            if (arr[start] == arr[end]) start++;
            else if (arr[start] < arr[end]) {
                ArrayUtils.swap(arr, ++less, start++);
            } else if (arr[start] > arr[end]) {
                ArrayUtils.swap(arr, start, --more);
            }
        }
        ArrayUtils.swap(arr, more, end);
        return new int[]{less, more + 1};
    }

    public static void sortV3(int[] sourceArr) {
        process3(sourceArr, 0, sourceArr.length - 1);
    }

    public static void process3(int[] arr, int start, int end) {
        if (start >= end) return;
        ArrayUtils.swap(arr, end, start + (int) (Math.random() * (end - start)));
        int[] indexInfo = partitionV2(arr, start, end);
        process2(arr, start, indexInfo[0]);
        process2(arr, indexInfo[1], end);
    }

    public static int[] partitionV3(int[] arr, int start, int end) {
        int less = start - 1;
        int more = end;
        while (start < more) {
            if (arr[start] == arr[end]) start++;
            else if (arr[start] < arr[end]) {
                ArrayUtils.swap(arr, ++less, start++);
            } else if (arr[start] > arr[end]) {
                ArrayUtils.swap(arr, start, --more);
            }
        }
        ArrayUtils.swap(arr, more, end);
        return new int[]{less, more + 1};
    }

}
