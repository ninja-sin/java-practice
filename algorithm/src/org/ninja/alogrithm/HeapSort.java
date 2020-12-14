package org.ninja.alogrithm;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {

    public static void sort(int[] sourceArr, int v) {
        if (v == 1) {
            processV1(sourceArr);
        } else if (v == 2) {
            processV2(sourceArr);
        } else if (v == 3) {
            processV3(sourceArr);
        } else if (v == 4) {
            processV4(sourceArr);
        }
    }

    static void processV1(int[] sourceArr) {
        MaxHeap heap = new MaxHeap(sourceArr.length);
        for (int i = 0; i < sourceArr.length; i++) {
            heap.push(sourceArr[i]);
        }
        for (int i = sourceArr.length - 1; i >= 0; i--) {
            sourceArr[i] = heap.pop();
        }
    }

    static void processV2(int[] sourceArr) {
        int heapSize = sourceArr.length;
        for (int i = heapSize - 1; i >= 0; i--) {
            insert(sourceArr, i);
            heapify(sourceArr, i, heapSize);
        }
        ArrayUtils.swap(sourceArr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(sourceArr, 0, heapSize);
            ArrayUtils.swap(sourceArr, 0, --heapSize);
        }
    }

    static void processV3(int[] sourceArr) {
        int heapSize = sourceArr.length;
        for (int i = heapSize - 1; i >= 0; i--) {
            heapify(sourceArr, i, heapSize);
        }
        ArrayUtils.swap(sourceArr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(sourceArr, 0, heapSize);
            ArrayUtils.swap(sourceArr, 0, --heapSize);
        }
    }

    static void processV4(int[] sourceArr) {
        int heapSize = sourceArr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(sourceArr.length, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < heapSize; i++) {
            pq.add(sourceArr[i]);
        }

        while (!pq.isEmpty()) {
            sourceArr[--heapSize] = pq.poll();
        }
    }

    static void insert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            ArrayUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize ? arr[left] < arr[left + 1] ? left + 1 : left : left;
            largest = arr[index] < arr[largest] ? largest : index;
            if (largest == index) break;
            ArrayUtils.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static class MaxHeap {
        int[] heap;
        int heapSize;
        int limit;

        public MaxHeap(int limit) {
            this.limit = limit;
            heapSize = 0;
            heap = new int[limit];
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (isFull()) {
                throw new RuntimeException("heap is full!!!!");
            }
            heap[heapSize] = value;
            insert(heapSize++);
        }

        void insert(int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                ArrayUtils.swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("heap is empty!!!!");
            }
            int value = heap[0];
            ArrayUtils.swap(heap, 0, --heapSize);
            heapify(0);
            return value;
        }

        void heapify(int index) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize ? heap[left] >= heap[left + 1] ? left : left + 1 : left;
                largest = heap[largest] <= heap[index] ? index : largest;
                if (index == largest) break;
                ArrayUtils.swap(heap, index, largest);
                index = largest;
                left = index * 2 + 1;
            }

        }
    }
}
