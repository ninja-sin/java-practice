import org.ninja.alogrithm.HeapSort;
import utils.MyPrint;

import java.util.Random;


public class Test {
    public static void main(String[] args) {
        Random random = new Random();
//        Integer[] sourceArr = randomSourceArr(Math.max(10, random.nextInt(15)));
        int[] sourceArr = randomSourceArr(Math.max(30, random.nextInt(35)));
        MyPrint.print(sourceArr);
//        SelectionSort.sort(sourceArr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        }, false);
//        BubbleSort.sort(sourceArr);
//        InsertionSort.sort(sourceArr);
//        ShellSort.sort(sourceArr);
//        MergeSort.sort(sourceArr);
//        QuickSort.sort(sourceArr, 3);
        HeapSort.sort(sourceArr, 4);
        MyPrint.print(sourceArr);
    }

//    public static Integer[] randomSourceArr(int length) {
//        Random random = new Random();
//        Integer[] sourceArr = new Integer[length];
//        for (int i = 0; i < length; i++) {
//            sourceArr[i] = random.nextInt(1000);
//        }
//        return sourceArr;
//    }

    public static int[] randomSourceArr(int length) {
        Random random = new Random();
        int[] sourceArr = new int[length];
        for (int i = 0; i < length; i++) {
            sourceArr[i] = random.nextInt(1000);
        }
        return sourceArr;
    }


}
