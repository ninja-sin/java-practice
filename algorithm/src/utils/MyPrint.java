package utils;

public class MyPrint {
    public static <T> void print(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
