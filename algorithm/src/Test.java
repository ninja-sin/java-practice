import org.ninja.alogrithm.SelectionSort;
import utils.MyPrint;

import java.util.Comparator;
import java.util.Random;


public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] sourceArr = randomSourceArr(Math.max(10, random.nextInt(15)));
        MyPrint.print(sourceArr);
        System.out.println();
        SelectionSort.sort(sourceArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }, false);
    }

    public static Integer[] randomSourceArr(int length) {
        Random random = new Random();
        Integer[] sourceArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            sourceArr[i] = random.nextInt(1000);
        }
        return sourceArr;
    }


}
