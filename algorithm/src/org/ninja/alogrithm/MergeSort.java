package org.ninja.alogrithm;

public class MergeSort {
    public static void sort(int[] sourceArr) {
        process(sourceArr, 0, sourceArr.length - 1);
    }

    public static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int start = left;
        int tempIndex = 0;
        int rightStart = mid + 1;
        while (left <= mid && rightStart <= right) {
            temp[tempIndex++] = arr[left] <= arr[rightStart] ? arr[left++] : arr[rightStart++];
        }
        while (left <= mid) {
            temp[tempIndex++] = arr[left++];
        }
        while (rightStart <= right) {
            temp[tempIndex++] = arr[rightStart++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[start++] = temp[i];
        }
    }
}
