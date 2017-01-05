package testing.lib.common;

import java.util.Arrays;

/**
 * Created by Yun on 10/26/2016.
 */
public class CommonUtils {
    public static void sysPrint(String x) {
        System.out.println(x);
    }

    //region Utilities
    public static <T extends Number> void printTwoDimentinalArray(T[][] arr) {
        if (arr == null) return;
        int M = arr.length;
        if (M <= 0) return;

        for (int i = 0; i < M; i++)
            System.out.println("\t" + Arrays.asList(arr[i]));
    }

    public static Integer[] convertIntArrToIntegerArr(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    public static Integer[][] convertIntArrToIntegerArr(int[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        Integer[][] a = new Integer[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = arr[i][j];
            }
        }
        return a;
    }

    public static void printArray(int[] arr) {
        printArray(convertIntArrToIntegerArr(arr), null, false);
    }

    public static void printArray(int[] arr, String note) {
        printArray(convertIntArrToIntegerArr(arr), note, false);
    }

    public static void printArray(int[] arr, String note, boolean printDimension) {
        printArray(convertIntArrToIntegerArr(arr), note, false);
    }

    public static <T> void printArray(T[] arr) {
        printArray(arr, null, false);
    }

    public static <T> void printArray(T[] arr, String note) {
        printArray(arr, note, false);
    }

    public static <T> void printArray(T[] arr, boolean printDimension) {
        printArray(arr, null, printDimension);
    }

    private static <T> void printArray(T[] arr, String note, boolean printDimension) {
        if (arr == null) return;
        int N = arr.length;
        if (N <= 0) return;

        if (note != null) System.out.println(note);
        if (printDimension) System.out.println("Column = " + N);
        System.out.println("\t" + Arrays.asList(arr));
    }


    public static void printTwoDimentinalArray(int[][] arr) {
        printTwoDimentinalArray(convertIntArrToIntegerArr(arr), null, false);
    }
    public static void printTwoDimentinalArray(int[][] arr, String note) {
        printTwoDimentinalArray(convertIntArrToIntegerArr(arr), note, false);
    }
    public static void printTwoDimentinalArray(int[][] arr, boolean printDimension) {
        printTwoDimentinalArray(convertIntArrToIntegerArr(arr), null, printDimension);
    }

    public static <T> void printTwoDimentinalArray(T[][] arr) {
        printTwoDimentinalArray(arr, null, false);
    }

    public static <T> void printTwoDimentinalArray(T[][] arr, String note) {
        printTwoDimentinalArray(arr, note, false);
    }

    public static <T> void printTwoDimentinalArray(T[][] arr, boolean printDimension) {
        printTwoDimentinalArray(arr, null, printDimension);
    }

    public static <T> void printTwoDimentinalArray(T[][] arr, String note, boolean printDimension) {
        if (arr == null) return;
        int M = arr.length;
        if (M <= 0) return;
        int N = arr.length;
        if (N <= 0) return;

        if (note != null) System.out.println(note);
        if (printDimension) System.out.println("Row = " + M + "; Column = " + N);
        for (int i = 0; i < M; i++)
            printArray(arr[i]);
    }
}
