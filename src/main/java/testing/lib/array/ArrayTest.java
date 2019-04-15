/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.array;

import java.util.*;

import testing.lib.fenwick_tree.FenwickTree;
import testing.lib.sort_search.*;

import javax.swing.*;

/**
 *
 * @author yunl
 */
public class ArrayTest <T extends Number> {

    //region Utilities
    private static <T extends Number> void printTwoDimentinalArray(T[][] arr) {
        if (arr == null) return;
        int M = arr.length;
        if (M <= 0) return;

        for (int i = 0; i < M; i++)
            System.out.println("\t" + Arrays.asList(arr[i]));
    }

    private static Integer[] convertIntArrToIntegerArr(int[] arr) {
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    private static Double[] convertDoubleArrToDoubleArr(double[] arr) {
        Double[] a = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    private static Integer[][] convertIntArrToIntegerArr(int[][] arr) {
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

    private static Double[][] convertDoubleArrToDoubleArr(double[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        Double[][] a = new Double[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = arr[i][j];
            }
        }
        return a;
    }

    private static void printArray(int[] arr) {
        printArray(convertIntArrToIntegerArr(arr), null, false);
    }
    private static void printArray(int[] arr, String note) {
        printArray(convertIntArrToIntegerArr(arr), note, false);
    }
    private static void printArray(int[] arr, String note, boolean printDimension) {
        printArray(convertIntArrToIntegerArr(arr), note, false);
    }

    private static void printArray(double[] arr) {
        printArray(convertDoubleArrToDoubleArr(arr), null, false);
    }
    private static void printArray(double[] arr, String note) {
        printArray(convertDoubleArrToDoubleArr(arr), note, false);
    }
    private static void printArray(double[] arr, String note, boolean printDimension) {
        printArray(convertDoubleArrToDoubleArr(arr), note, false);
    }

    private static <T> void printArray(T[] arr) {
        printArray(arr, null, false);
    }
    private static <T> void printArray(T[] arr, String note) {
        printArray(arr, note, false);
    }
    private static <T> void printArray(T[] arr, boolean printDimension) {
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


    private static void printTwoDimentinalArray(int[][] arr) {
        printTwoDimentinalArray(convertIntArrToIntegerArr(arr), null, false);
    }
    private static void printTwoDimentinalArray(int[][] arr, String note) {
        printTwoDimentinalArray(convertIntArrToIntegerArr(arr), note, false);
    }
    private static void printTwoDimentinalArray(int[][] arr, boolean printDimension) {
        printTwoDimentinalArray(convertIntArrToIntegerArr(arr), null, printDimension);
    }

    private static void printTwoDimentinalArray(double[][] arr) {
        printTwoDimentinalArray(convertDoubleArrToDoubleArr(arr), null, false);
    }
    private static void printTwoDimentinalArray(double[][] arr, String note) {
        printTwoDimentinalArray(convertDoubleArrToDoubleArr(arr), note, false);
    }
    private static void printTwoDimentinalArray(double[][] arr, boolean printDimension) {
        printTwoDimentinalArray(convertDoubleArrToDoubleArr(arr), null, printDimension);
    }

    private static <T> void printTwoDimentinalArray(T[][] arr) {
        printTwoDimentinalArray(arr, null, false);
    }

    private static <T> void printTwoDimentinalArray(T[][] arr, String note) {
        printTwoDimentinalArray(arr, note, false);
    }

    private static <T> void printTwoDimentinalArray(T[][] arr, boolean printDimension) {
        printTwoDimentinalArray(arr, null, printDimension);
    }

    private static <T> void printTwoDimentinalArray(T[][] arr, String note, boolean printDimension) {
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
    //endregion

    public static void find2NumWithGivenSum(Integer[] a, int size, int sum) {
        Sort.quickSort(a, size);
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int temp = a[left] + a[right];
            if (temp == sum)
                break;
            else if (temp > sum)
                right--;
            else
                left++;
        }
        System.out.println("\na: " + Arrays.asList(a));
        if (left < right) {
            System.out.println("a[" + left + "] + a[" + right + "] = " + sum);
        }
    }

    /**
     * convert array:	{ a1, a2, a3, ..., an, b1, b2, b3, ..., bn }
     * to:				{ a1, b1, a2, b2, a3, b3, ........, an, bn }
     *    {(a1, a2, a3, a4, b1, b2, b3, b4)}
     * => {(a1, a2, b1, b2), (a3, a4, b3, b4)}
     * => {(a1, b1), (a2, b2), (a3, b3), (a4, b4)}
     * <p>
     *    {(a1, a2, a3, a4, a5, b1, b2, b3, b4, b5)}
     * => {(a1, a2, b1, b2), b3, a3, (a4, a5, b4, b5)}
     * => {(a1, a2, b1, b2), a3, b3, (a4, a5, b4, b5)}
     * => {(a1, b1), (a2, b2), (a3, b3), (a4, b4), (a5, b5)}
     * <p>
     * TODO
     */
    public static void convertMerge(Character[] a, int size) {
        System.out.println("Before conversion: " + Arrays.asList(a));
        convertMergeHelper(a, 0, size - 1);
        System.out.println("After conversion:  " + Arrays.asList(a));
    }

    public static void convertMergeHelper(Character[] a, int begin, int end) {
        int size = end - begin + 1;
        if (a == null || size % 2 == 1 || size <= 2)
            return;
        int half = size / 2;
        int lHalfHalf = half / 2;
        int hHalfHalf = half - lHalfHalf;

        for (int i = begin + lHalfHalf; i < begin + half; i++) {
            ArrayTest.<Character>swap(a, i, i + hHalfHalf);
        }
        if (lHalfHalf == hHalfHalf) {
            convertMergeHelper(a, begin, begin + half - 1);
            convertMergeHelper(a, begin + half, end);
        } else {
            ArrayTest.<Character>swap(a, begin + half - 1, begin + half);
            convertMergeHelper(a, begin, begin + half - 2);
            convertMergeHelper(a, begin + half + 1, end);
        }
    }

    private static <T> void swap(T[] a, int index1, int index2) {
        T temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    // 子数组的最大乘机：给定长度为N的整数数组，只允许乘法，不能用除法，计算任意(N-1)个数的组合中乘积最大的一组
    public static void maxSubProduct(Integer[] a, int size) {
        Integer[] temp = new Integer[size];
        Arrays.fill(temp, 1);
        int P = 1;
        for (int i = 1; i < size; i++) {
            P *= a[i - 1];
            temp[i] *= P;
        }
        P = 1;
        for (int i = size - 2; i >= 0; i--) {
            P *= a[i + 1];
            temp[i] *= P;
        }
        System.out.println("Array:      " + Arrays.asList(a));
        System.out.println("Temp array: " + Arrays.asList(temp));
    }

    // 子数组的最大和：给定长度为N的整数数组，只允许加法，不能用减法，计算任意(N-1)个数的组合中和最大的一组
    public static void maxSubSum(Integer[] a, int size) {
        Integer[] temp = new Integer[size];
        Arrays.fill(temp, 0);
        int S = 0;
        for (int i = 1; i < size; i++) {
            S += a[i - 1];
            temp[i] += S;
        }
        S = 0;
        for (int i = size - 2; i >= 0; i--) {
            S += a[i + 1];
            temp[i] += S;
        }
        System.out.println("Array:      " + Arrays.asList(a));
        System.out.println("Temp array: " + Arrays.asList(temp));
    }

    /**
     * Find Minimum in Rotated Sorted Array
     *
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     *         (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * There could be duplicated elements
     * You may assume no duplicate exists in the array.
     */
    public static int findMin(int[] num) {
        if (num == null) return -1;
        int len = num.length;
        if (len < 1) return -1;

        int begin = 0;
        int end = len - 1;
        int mid;
        while (begin <= end) {
            mid = begin + (end- begin)/2;
            if (mid == begin) {
                return Math.min(num[begin], num[end]);
            } else if (num[mid] > num[end]) {
                begin = mid + 1;
            } else if (num[mid] < num[mid - 1]) {
                return num[mid];
            } else {
                end = mid + 1;
            }
        }
        return -1;
    }
    public int findMin2(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;

        int lb = 0, ub = num.length - 1;
        // case1: num[0] < num[num.length - 1]
        if (num[lb] < num[ub]) return num[lb];

        // case2: num[0] > num[num.length - 1] or num[0] < num[num.length - 1]
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (num[mid] < num[ub]) {
                ub = mid;
            } else if (num[mid] > num[ub]){
                lb = mid;
            } else {
                ub--;
            }
        }

        return Math.min(num[lb], num[ub]);
    }

    /**
     * Given a 2D matrix. Some of the matrix's elements are 0
     * If matrix[i][j] == 0, set Row[i] and Column[j] all to zeros.
     * <p>
     * https://leetcode.com/problems/set-matrix-zeroes/
     *
     * @param matrix
     */
    public static void setZeroes(Integer[][] matrix) {
        System.out.println("\nStart function setZeroes()");
        if (matrix == null) return;
        int R = matrix.length;
        if (R <= 0) return;
        int C = matrix[0].length;
        if (C <= 0) return;

        System.out.println("Before zeroing:");
        for (int i = 0; i < R; i++) {
            System.out.println("\t" + Arrays.asList(matrix[i]));
        }

        long r = 0;
        long c = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    r |= 0x1 << i;
                    c |= 0x1 << j;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            if ((r & (0x1 << i)) != 0) {
                for (int j = 0; j < C; j++)
                    matrix[i][j] = 0;
            }
        }
        for (int j = 0; j < C; j++) {
            if ((c & (0x1 << j)) != 0) {
                for (int i = 0; i < R; i++)
                    matrix[i][j] = 0;
            }
        }

        System.out.println("After zeroing:");
        for (int i = 0; i < R; i++) {
            System.out.println("\t" + Arrays.asList(matrix[i]));
        }

        System.out.println("End function setZeroes()");
    }

    // last version will cause stack overflow in leetcode test. This version will pass
    public static void setZeroes2(Integer[][] matrix) {
        System.out.println("\nStart function setZeroes()");
        if (matrix == null) return;
        int R = matrix.length;
        if (R <= 0) return;
        int C = matrix[0].length;
        if (C <= 0) return;

        System.out.println("Before zeroing:");
        for (int i = 0; i < R; i++) {
            System.out.println("\t" + Arrays.asList(matrix[i]));
        }

        LinkedList<Integer> rList = new LinkedList<>();
        LinkedList<Integer> cList = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rList.addLast(i);
                    cList.addLast(j);
                }
            }
        }
        for (int i : rList)
            for (int j = 0; j < C; j++)
                matrix[i][j] = 0;
        for (int j : cList)
            for (int i = 0; i < R; i++)
                matrix[i][j] = 0;

        System.out.println("After zeroing:");
        for (int i = 0; i < R; i++) {
            System.out.println("\t" + Arrays.asList(matrix[i]));
        }

        System.out.println("End function setZeroes()");
    }

    public static int largestRectangleArea(Integer[] height) {
        System.out.println("\nStart function largestRectangleArea()");
        printArray(height);
        System.out.println("\t************************************");
        Stack<Integer> s = new Stack<>();
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            if (!s.isEmpty()) {
                while (!s.isEmpty() && height[s.peek()] > height[i]) {
                    int temp = s.pop();
                    if (!s.isEmpty()) {
                        maxArea = Math.max(maxArea, (i - s.peek() - 1) * height[temp]);
                    } else {
                        maxArea = Math.max(maxArea, i * height[temp]);
                    }
                }
            }
            s.push(i);
            printStack(s, height, maxArea);
        }
        System.out.println("\t------------------------------------");
        while (!s.isEmpty()) {
            int temp = s.pop();
            if (!s.empty()) {
                maxArea = Math.max(maxArea, (len - s.peek() - 1) * height[temp]);
            } else {
                maxArea = Math.max(maxArea, len * height[temp]);
            }
            printStack(s, height, maxArea);
        }
        System.out.println("\t************************************");
        return maxArea;
    }

    private static void printStack(Stack s, Integer[] height, int maxArea) {
        Stack sHelper = new Stack();
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (!s.isEmpty()) {
            sHelper.push((Integer) s.pop());
        }
        while (!sHelper.isEmpty()) {
            Integer i = (Integer) sHelper.pop();
            s.push(i);
            sb.append(i).append("(").append(height[i]).append(") ");
        }
        sb.append("]");
        System.out.println("\tStack: " + sb.toString() + " MaxArea = " + maxArea);
    }

    /**
     * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
     * For example, given the following matrix:
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * Return 6.
     * <p>
     * https://leetcode.com/problems/maximal-rectangle/
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(Character[][] matrix) {
        System.out.println("\nStart function maximalRectangle()");
        int rows = matrix.length;
        if (rows <= 0)
            return 0;
        int columns = matrix[0].length;
        if (columns <= 0)
            return 0;

        printTwoDimentinalArray(matrix, "Original array:", true);

        Integer[][] heights = new Integer[rows][columns];

        for (int j = 0; j < columns; ++j) {
            heights[0][j] = (matrix[0][j] == '1') ? 1 : 0;
            for (int i = 1; i < rows; ++i) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i - 1][j] + 1;
                } else
                    heights[i][j] = 0;
            }
        }

        printTwoDimentinalArray(heights, "Height array:");

        int maxArea = 0;
        for (int i = 0; i < rows; ++i)
            maxArea = Math.max(maxArea, largestRectangleArea(heights[i]));

        System.out.println("Maximal rectangle area: " + maxArea);
        return maxArea;
    }

    /**
     * Maximal Square
     * <p>
     * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
     * <p>
     * For example, given the following matrix:
     * <p>
     * 1 0 1 0 0
     * 1 0 1 1 1
     * 1 1 1 1 1
     * 1 0 0 1 0
     * Return 4.
     * <p>
     * https://leetcode.com/problems/maximal-square/
     */
    public static int maximalSquare(Character[][] matrix) {
        System.out.println("\nStart function maximalSquare()");
        int rows = matrix.length;
        if (rows <= 0)
            return 0;
        int columns = matrix[0].length;
        if (columns <= 0)
            return 0;

        printTwoDimentinalArray(matrix, "Original array:", true);

        Integer[][] heights = new Integer[rows][columns];

        for (int j = 0; j < columns; j++) {
            heights[0][j] = matrix[0][j] == '1' ? 1 : 0;
            for (int i = 1; i < rows; i++) {
                if (matrix[i][j] == '1') {
                    heights[i][j] = heights[i - 1][j] + 1;
                } else {
                    heights[i][j] = 0;
                }
            }
        }

        printTwoDimentinalArray(heights, "Height array:");

        int maxSquare = 0;
        for (int i = rows - 1; i >= 0; --i) {
            maxSquare = Math.max(maxSquare, largestSquareArea(heights[i]));
            int minLen = Math.min(i + 1, columns);
            if (maxSquare == minLen * minLen) {
                break;
            }
        }

        System.out.println("Maximal square area: " + maxSquare);
        return maxSquare;
    }

    public static int largestSquareArea(Integer[] height) {
        int maxSquare = -1;
        int len = height.length;
        Stack S = new Stack();
        for (int i = 0; i < len; i++) {
            if (!S.isEmpty()) {
                while (!S.isEmpty() && height[i] < height[(Integer) S.peek()]) {
                    int temp = (Integer) S.pop();
                    if (S.isEmpty()) {
                        maxSquare = Math.max(maxSquare, (int) Math.pow((double) Math.min(i, height[temp]), 2.0));
                    } else {
                        maxSquare = Math.max(maxSquare, (int) Math.pow((double) Math.min((i - (int) S.peek() - 1), height[temp]), 2.0));
                    }
                }
            }
            S.push(i);
        }
        while (!S.isEmpty()) {
            int temp = (Integer) S.pop();
            if (S.isEmpty()) {
                maxSquare = Math.max(maxSquare, (int) Math.pow((double) Math.min(len, height[temp]), 2.0));
            } else {
                maxSquare = Math.max(maxSquare, (int) Math.pow((double) Math.min((len - 1 - (int) S.peek()), height[temp]), 2.0));
            }
        }
        return maxSquare;
    }
    public static int largestSquareArea2(Integer[] height) {
        int maxSquareLen = -1;
        int len = height.length;
        Stack S = new Stack();
        for (int i = 0; i < len; i++) {
            if (!S.isEmpty()) {
                while (!S.isEmpty() && height[i] < height[(Integer) S.peek()]) {
                    int temp = (Integer) S.pop();
                    if (S.isEmpty()) {
                        maxSquareLen = Math.max(maxSquareLen, Math.min(i, height[temp]));
                    } else {
                        maxSquareLen = Math.max(maxSquareLen, Math.min(i - (int) S.peek() - 1, height[temp]));
                    }
                }
            }
            S.push(i);
        }
        while (!S.isEmpty()) {
            int temp = (Integer) S.pop();
            if (S.isEmpty()) {
                maxSquareLen = Math.max(maxSquareLen, Math.min(len, height[temp]));
            } else {
                maxSquareLen = Math.max(maxSquareLen, Math.min(len - 1 - (int) S.peek(), height[temp]));
            }
        }
        return maxSquareLen * maxSquareLen;
    }

    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
     * A gray code sequence must begin with 0.
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * Note:
     * For a given n, a gray code sequence is not uniquely defined.
     * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
     * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     * Subscribe to see which companies asked this question
     * <p>
     * https://leetcode.com/problems/gray-code/
     *
     * @param n
     * @return
     */
    public static ArrayList<Integer> grayCode(int n) {
        System.out.println("\nStart function grayCode(); n = " + n);
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        if (n <= 0) {
            newArr.add(0);
        } else if (n == 1) {
            newArr.add(0);
            newArr.add(1);
        } else {
            ArrayList<Integer> arr = grayCode(n - 1);
            boolean tag = false;

            for (int code : arr) {
                newArr.add((code << 1) + (tag ? 1 : 0));
                tag = !tag;
                newArr.add((code << 1) + (tag ? 1 : 0));
            }
        }
        return newArr;
    }

    /**
     * Given a triangle, find the minimum path sum from top to
     * bottom. Each step you may move to adjacent numbers on the
     * row below.
     * For example, given the following triangle
     * [
     *    [2],
     *   [3,4],
     *  [6,5,7],
     * [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 
     * (i.e., 2 + 3 + 5 + 1 = 11).
     * Note:
     * <p>
     * Bonus point if you are able to do this using only O(n)
     * extra space, where n is the total number of rows in the
     * triangle.
     */
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        System.out.println("\nStart function minimumTotal()");
        int height = triangle.size();
        ArrayList<Integer> presums = new ArrayList<Integer>();
        ArrayList<Integer> minsums = new ArrayList<Integer>();
        presums.add(triangle.get(0).get(0));

        for (int i = 1; i < height; i++) {
            minsums.add(presums.get(0) + triangle.get(i).get(0));

            for (int j = 1; j < i; j++) {
                minsums.add(Math.min(presums.get(j - 1), presums.get(j)) + triangle.get(i).get(j));
            }

            minsums.add(presums.get(i - 1) + triangle.get(i).get(i));

            presums = (ArrayList<Integer>) minsums.clone();
            minsums.clear();
        }

        int minsum = presums.get(0);
        for (int i = 1; i < presums.size(); i++) {
            if (presums.get(i) < minsum)
                minsum = presums.get(i);
        }

        System.out.println("\tInput triangle");
        for (List<Integer> list : triangle)
            System.out.println("\t" + list);
        System.out.println("\tminsum: " + minsum);

        return minsum;
    }

    /**
     * Pascals Triangle II
     * <p>
     * Given an index k, return the kth row of the Pascal's triangle.
     * For example, given k = 3,
     * Return [1,3,3,1].
     * Note:
     * Could you optimize your algorithm to use only O(k) extra space?
     */
    public static ArrayList<Integer> getPascalsTriangleRow(int row) {
        System.out.println("\nStart function getPascalsTriangleRow(). row = " + row);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= row; i++) {
            res.add(1);
            for (int j = i - 1; j >= 1; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        System.out.println("\tResult = " + res);
        return res;
    }

    /**
     * Given an array of words and a length L, format the text
     * such that each line has exactly L characters and is fully
     * (left and right) justified.
     * You should pack your words in a greedy approach; that is,
     * pack as many words as you can in each line. Pad extra
     * spaces ' ' when necessary so that each line has exactly L
     * characters.
     * Extra spaces between words should be distributed as
     * evenly as possible. If the number of spaces on a line do
     * not divide evenly between words, the empty slots on the
     * left will be assigned more spaces than the slots on the
     * right.
     * For the last line of text, it should be left justified
     * and no extra space is inserted between words.
     * For example,
     * words: ["This", "is", "an", "example", "of", "text", "justification."]
     * L: 16.
     * Return the formatted lines as:
     * [
     * "This    is    an",
     * "example  of text",
     * "justification.  "
     * ]
     * Note: Each word is guaranteed not to exceed L in length.
     * click to show corner cases.
     * Corner Cases:
     * • A line other than the last line might contain only
     * one word. What should you do in this case?
     * In this case, that line should be left-justified.
     */
    static public ArrayList<String> fullJustify(String[] words, int L) {
        System.out.println("\nStart function fullJustify()");
        ArrayList<String> result = new ArrayList<>();
        int len = words.length;
        if (len <= 0) return result;

        ArrayList<String> temp = new ArrayList<>();
        for (String word : words) {
            if (temp.size() > 0) {
                int count = temp.size();
                int length = 0;
                for (String str : temp) {
                    length += str.length();
                }
                if ((length + count + word.length()) > L) {
                    StringBuilder sb = new StringBuilder();
                    // Insert a new line
                    if (count == 1) {
                        sb.append(temp.get(0));
                        appendSpace(sb, (L - length));
                        result.add(sb.toString());
                    } else {
                        int totalSpace = L - length;
                        int spacePerWord = (int) Math.floor(totalSpace / (count - 1));
                        for (int i = 0; i < (count - 1); ++i) {
                            sb.append(temp.get(i));
                            appendSpace(sb, spacePerWord);
                        }
                        // Append space before the last word in this line
                        appendSpace(sb, (L - sb.length() - temp.get(count - 1).length()));
                        sb.append(temp.get(count - 1));
                        result.add(sb.toString());
                    }
                    temp.clear();
                }
            }
            temp.add(word);
        }
        // Handle the last line
        if (temp.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (String w : temp) {
                sb.append(w);
                if (sb.length() < (L - 1))
                    sb.append(" ");
                else
                    break;
            }
            appendSpace(sb, (L - sb.length()));
            temp.clear();
            result.add(sb.toString());
        }

        System.out.println("\tInputs: " + Arrays.asList(words));
        for (String str : result)
            System.out.println("\t" + str);

        return result;
    }

    static private void appendSpace(StringBuilder sb, int num) {
        for (int i = 1; i <= num; i++)
            sb.append(" ");
    }
    // Another version, cleaner
    public static List<String> fullJustify2(String[] words, int maxWidth) {
        ArrayList<String> res = new ArrayList<>();
        if (words == null) return res;
        int len = words.length;
        if (len <= 0) return res;
        if (maxWidth <= 0) return res;

        Integer[] wlens = new Integer[len];
        for (int i = 0; i < len; i++) {
            wlens[i] = words[i].length();
        }
        int start = 0;
        int tmpLen = 0;
        for (int cur = 0; cur < len; cur++) {
            int wordNum = cur - start + 1;
            if (tmpLen + wordNum - 1 + wlens[cur] > maxWidth) {
                res.add(genString(words, start, cur - 1, tmpLen, maxWidth));
                tmpLen = 0;
                start = cur;
            }
            tmpLen += wlens[cur];
        }
        res.add(genString(words, start, len - 1, tmpLen, maxWidth));
        return res;
    }
    private static String genString(String[] words, int start, int end, int tmpLen, int maxWidth) {
        int wordCount = end - start + 1;
        if (wordCount == 1) return words[start];

        int intervalCount = wordCount - 1;
        int totalSpaces = maxWidth - tmpLen;
        int [] spaceWidths = new int [intervalCount];
        for (int i = 0; i < intervalCount; i++) {
            spaceWidths[i] = totalSpaces/intervalCount + (i < totalSpaces%intervalCount ? 1 : 0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);
        for (int i = 0; i < intervalCount; i++) {
            for (int j = 0; j < spaceWidths[i]; j++)
                sb.append(" ");
            sb.append(words[start + i + 1]);
        }
        return sb.toString();
    }

    /**
     * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
     * For example,
     * Given n = 3,
     * You should return the following matrix:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     */
    public enum Dir {
        Right, Down, Left, Top
    }

    static public Integer[][] generateMatrix(int n) {
        System.out.println("\nStart function generateMatrix()");
        if (n <= 0) return null;
        //if (n == 1) return int [1][1] {1};
        Integer[][] results = new Integer[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(results[i], 0);

        generateMatrixHelper(results, 0, 0, 1, n, Dir.Right);

        printTwoDimentinalArray(results);
        return results;
    }

    static private void generateMatrixHelper(Integer[][] results, int i, int j, int cur, int N, Dir dir) {
        System.out.println("\ti = " + i + "; j = " + j + "; cur = " + cur + "; N = " + N + "; dir = " + dir);
        if (i < 0 || i >= N ||
                j < 0 || j >= N ||
                results[i][j] != 0)
            return;
        else
            results[i][j] = cur;

        if (cur == N * N)
            return;

        int newI = i;
        int newJ = j;
        switch (dir) {
            case Right:
                newJ++;
                break;
            case Down:
                newI++;
                break;
            case Left:
                newJ--;
                break;
            case Top:
                newI--;
                break;
        }

        if (changeDir(newI, newJ, results, N)) {
            switch (dir) {
                case Right:
                    generateMatrixHelper(results, i + 1, j, cur + 1, N, Dir.Down);
                    break;
                case Down:
                    generateMatrixHelper(results, i, j - 1, cur + 1, N, Dir.Left);
                    break;
                case Left:
                    generateMatrixHelper(results, i - 1, j, cur + 1, N, Dir.Top);
                    break;
                case Top:
                    generateMatrixHelper(results, i, j + 1, cur + 1, N, Dir.Right);
                    break;
            }
        } else {
            generateMatrixHelper(results, newI, newJ, cur + 1, N, dir);
        }
    }

    static private boolean changeDir(int newI, int newJ, Integer[][] results, int N) {
        // System.out.println("newI = " + newI + "; newJ = " + newJ + "; results[newI][newJ] = " + results[newI][newJ] + "; N = " + N);
        if (newI < 0 || newI >= N ||
                newJ < 0 || newJ >= N) {
            return true;
        } else if (results[newI][newJ] != 0) {
            return true;
        } else {
            return false;
        }
    }

    // Optimal solution IMO
    static public Integer[][] generateMatrixIterative(int n) {
        System.out.println("\nStart function generateMatrixIterative()");
        if (n <= 0) return null;
        //if (n == 1) return int [1][1] {1};
        Integer[][] results = new Integer[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(results[i], 0);

        int top = 0, down = n - 1, left = 0, right = n - 1;
        int cur = 1;
        Dir dir = Dir.Right;
        while (top <= down && left <= right) {
            switch (dir) {
                case Right:
                    for (int j = left; j <= right; j++) {
                        results[top][j] = cur++;
                    }
                    top++;
                    dir = Dir.Down;
                    break;
                case Down:
                    for (int i = top; i <= down; i++) {
                        results[i][right] = cur++;
                    }
                    right--;
                    dir = Dir.Left;
                    break;
                case Left:
                    for (int j = right; j >= left; j--) {
                        results[down][j] = cur++;
                    }
                    down--;
                    dir = Dir.Top;
                    break;
                case Top:
                    for (int i = down; i >= top; i--) {
                        results[i][left] = cur++;
                    }
                    left++;
                    dir = Dir.Right;
                    break;
            }
        }

        printTwoDimentinalArray(results);
        return results;
    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * <p>
     * return [1,6],[8,10],[15,18].
     */
    static public class Interval implements Comparable<Interval> {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public int compareTo(Interval i2) {
            return ((Integer) start).compareTo((Integer) i2.start);
        }

        @Override
        public String toString() {
            return "[" + start + " - " + end + "]";
        }
    }

    static public void testIntervalMerge() {
        System.out.println("\nStart function testIntervalMerge()");
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(12, 20));
        intervals.add(new Interval(8, 10));
        System.out.println("Original: " + intervals);

        ArrayList<Interval> results = merge(intervals);

        System.out.println("Sorted  : " + intervals);
        System.out.println("Merged  : " + results);
    }

    static public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
//         Collections.sort(intervals,
//                         new Comparator<Interval> () {
//                             public int compare(Interval i1, Interval i2) {
//                                 return ((Integer)(i1.start)).compareTo((Integer)(i2.start));
//                             }
//                         });
        Collections.sort(intervals, (i1, i2) -> ((Integer) (i1.start)).compareTo((Integer) (i2.start)));

        ArrayList<Interval> results = new ArrayList<>();
        Interval pre = null;
        for (Interval cur : intervals) {
            if (pre != null) {
                if (pre.end < cur.start) {
                    results.add((Interval) pre);
                    pre = cur;
                } else {
                    pre = new Interval(pre.start, Math.max(cur.end, pre.end));
                }
            } else {
                pre = cur;
            }
        }
        if (pre != null)
            results.add(pre);
        return results;
    }

    /**
     * There are N children standing in a line. Each child is assigned a rating value.
     * You are giving candies to these children subjected to the
     * following requirements:
     * • Each child must have at least one candy.
     * • Children with a higher rating get more candies than their neighbors.
     * <p>
     * https://leetcode.com/problems/candy/
     * <p>
     * What is the minimum candies you must give?
     */
    public static int candy(Integer[] ratings) {
        System.out.println("\nStart function candy()");
        if (ratings == null || ratings.length == 0)
            return 0;
        printArray(ratings, "Ratings: ");
        int len = ratings.length;
        Integer[] candies = new Integer[len];
        Arrays.fill(candies, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
        }
        printArray(candies, "Candies: ");

        int sum = 0;
        for (int i : candies)
            sum += i;
        return sum;
    }

    /**
     * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
     * with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * Note:
     * You are not suppose to use the library's sort function for this problem.
     * <p>
     * Follow up:
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with an one-pass algorithm using only constant space?
     */
    public static void sortColors(Integer[] A) {
        System.out.println("\nStart function sortColors()");
        printArray(A, "\tUnsorted: ");
        int len = A.length;
        int endZero = 0;
        int startTwo = len - 1;
        int cur = 0;
        while (cur <= startTwo) {
            if (A[cur] == 0) {
                if (cur > endZero) {
                    Utility.swap(A, cur, endZero);
                }
                endZero++;
                cur++;
            } else if (A[cur] == 2) {
                Utility.swap(A, cur, startTwo);
                startTwo--;
            } else {
                cur++;
            }
        }
        printArray(A, "\tSorted: ");
    }

    /**
     * Minimum Size SubArray Sum
     * Given an array of n positive integers and a positive integer s,
     * find the minimal length of a subarray of which the sum ≥ s.
     * If there isn't one, return 0 instead.
     * <p>
     * For example, given the array [2,3,1,2,4,3] and s = 7,
     * the subarray [4,3] has the minimal length under the problem constraint.
     * <p>
     * https://leetcode.com/problems/minimum-size-subarray-sum
     */
    static public int minSubArrayLen(int s, int[] nums) {
        System.out.println("\nStart function minSubArrayLen()");
        int len = nums.length;
        if (len <= 0) return 0;

        int start = 0;
        int end = 0;
        int minLen = len + 1;
        int curSum = 0;
        while (end < len) {
            while (curSum < s && end < len) {
                curSum += nums[end++];
            }
            while (curSum >= s && start <= end) {
                minLen = Math.min(minLen, end - start);
                curSum -= nums[start++];
            }
        }

        minLen = minLen == len + 1 ? 0 : minLen;
        System.out.println("The minlen is " + minLen);
        return minLen;
    }
    static public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        int start = 0, end = 0;
        int minLen = len + 1;
        int sum = 0;
        while (end < len) {
            sum += nums[end];

            while (start <= end && sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        minLen = minLen == len + 1 ? 0 : minLen;
        return minLen;
    }

    /**
     * Maximum Size Subarray Sum Equals k
     *
     * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
     * Note:
     * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
     * Example 1:
     * Given nums = [1, -1, 5, -2, 3], k = 3,
     *         return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
     * Example 2:
     * Given nums = [-2, -1, 2, 1], k = 1,
     *         return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
     * Follow Up:
     * Can you do it in O(n) time?
     */
    public static int maxSubArrayLen(int[] nums, int k) {
        System.out.println("\nStart function maxSubArrayLen(). K = " + k);
        printArray(nums, "\tNums:");

        int len = nums.length;
        if (len < 1) return 0;

        int res = 0;
        HashMap<Long, HashSet<Integer>> map = new HashMap<>();
        long[] sum = new long[len];
        for (int i = 0; i < len; i++) {
            sum[i] = nums[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
            if (nums[i] == k) {
                res = Math.max(res, 1);
            }
            if (sum[i] == k) {
                res = Math.max(res, i + 1);
            }
            Long diff = sum[i] - (long)k;
            if (map.containsKey(diff)) {
                for (int idx : map.get(diff)) {
                    res = Math.max(res, i - idx);
                }
            }

            if (map.containsKey(sum[i])) {
                map.get(sum[i]).add(i);
            } else {
                map.put(sum[i], new HashSet<>(Arrays.asList(new Integer[]{i})));
            }
        }
        System.out.println("\tRes = " + res);
        return res;
    }
    public static int maxSubArrayLen2(int[] nums, int k) {
        System.out.println("\nStart function maxSubArrayLen2(). K = " + k);
        printArray(nums, "\tNums:");

        int len = nums.length;
        if (len < 1) return 0;

        int res = 0;
        HashMap<Long, HashSet<Integer>> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (nums[i] == k) {
                res = Math.max(res, 1);
            }
            if (sum == k) {
                res = Math.max(res, i + 1);
            }
            Long diff = sum - k;
            if (map.containsKey(diff)) {
                for (int idx : map.get(diff)) {
                    res = Math.max(res, i - idx);
                }
            }

            if (map.containsKey(sum)) {
                map.get(sum).add(i);
            } else {
                map.put(sum, new HashSet<>(Arrays.asList(new Integer[]{i})));
            }
        }
        System.out.println("\tRes = " + res);
        return res;
    }
    // Optimal Solution
    public static int maxSubArrayLen3(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) return 0;
        int res = 0;
        long sum = 0;
        HashMap<Long, Integer> M = new HashMap<>();
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (nums[i] == k) res = Math.max(res, 1);
            if (sum == k) res = Math.max(res, i + 1);

            long diff = sum - k;
            if (M.containsKey(diff)) {
                res = Math.max(res, i - M.get(diff));
            }

            if (!M.containsKey(sum)) {
                M.put(sum, i);
            }
        }
        return res;
    }

    /**
     * Attention! Important!
     */
    public static int getKthFromTwoSortedArray(Integer A[], Integer B[], int kth) {
        assert A != null : "Array A is null";
        assert B != null : "Array B is null";

        int lenA = A.length;
        int lenB = B.length;

        if (lenA <= 0) return B[kth - 1];
        if (lenB <= 0) return A[kth - 1];
        if (kth <= 1) return Math.min(A[0], B[0]);

        if (A[lenA / 2] >= B[lenB / 2]) {
            if ((lenA / 2 + lenB / 2 + 1) >= kth) {
                return getKthFromTwoSortedArray(Arrays.copyOfRange(A, 0, lenA / 2), B, kth);
            } else {
                return getKthFromTwoSortedArray(A, Arrays.copyOfRange(B, lenB / 2 + 1, lenB), kth - (lenB / 2 + 1));
            }
        } else {
            if ((lenA / 2 + lenB / 2 + 1) >= kth) {
                return getKthFromTwoSortedArray(A, Arrays.copyOfRange(B, 0, lenB / 2), kth);
            } else {
                return getKthFromTwoSortedArray(Arrays.copyOfRange(A, lenA / 2 + 1, lenA), B, kth - (lenA / 2 + 1));
            }
        }
    }

    public static double findMedianSortedArrays(Integer[] A, Integer[] B) {
        System.out.println("\nStart function findMedianSortedArrays()");
        assert A != null : "Array A is null";
        assert B != null : "Array B is null";
        System.out.println("\tA = " + Arrays.asList(A));
        System.out.println("\tB = " + Arrays.asList(B));
        int lenA = A.length;
        int lenB = B.length;

        if ((lenA + lenB) % 2 == 1) {
            return getKthFromTwoSortedArray2(A, B, (lenA + lenB) / 2 + 1);
        } else {
            return (getKthFromTwoSortedArray2(A, B, (lenA + lenB) / 2) +
                    getKthFromTwoSortedArray2(A, B, (lenA + lenB) / 2 + 1)) / 2.0;
        }
    }

    // Optimal solution!!!
    public static int getKthFromTwoSortedArray2(Integer[] A, Integer[] B, int kth) {
        assert A != null : "Array A is null";
        assert B != null : "Array B is null";
        assert kth > 0 : "kth < 1";

        int lenA = A.length;
        int lenB = B.length;

        assert lenA + lenB >= kth : "lenA + lenB < kth";

        if (lenA > lenB) return getKthFromTwoSortedArray2(B, A, kth);
        if (lenA == 0 && lenB > 0) return B[kth - 1];
        if (kth == 1) return Math.min(A[0], B[0]);

        int i = Math.min(lenA, kth / 2);
        int j = Math.min(lenB, kth / 2);

        if (A[i - 1] > B[j - 1]) {
            // The commented out part is wrong!!! Leave here for comparision
            return getKthFromTwoSortedArray2(A, Arrays.copyOfRange(B, j, lenB), kth - j);
            // return getKthFromTwoSortedArray2(Arrays.copyOfRange(A, 0, i), Arrays.copyOfRange(B, j, lenB), kth - j);
        } else {
            return getKthFromTwoSortedArray2(Arrays.copyOfRange(A, i, lenA), B, kth - i);
            // return getKthFromTwoSortedArray2(Arrays.copyOfRange(A, i, lenA), Arrays.copyOfRange(B, 0, j), kth - i);
        }
    }

    // region Count Smaller

    /**
     * Count of Smaller Numbers After Self My Submissions Question
     * You are given an integer array nums and you have to return a new counts array.
     * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
     * Example:
     * Given nums = [5, 2, 6, 1]
     * To the right of 5 there are 2 smaller elements (2 and 1).
     * To the right of 2 there is only 1 smaller element (1).
     * To the right of 6 there is 1 smaller element (1).
     * To the right of 1 there is 0 smaller element.
     * Return the array [2, 1, 1, 0].
     * <p>
     * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
     */
    // This version Time Limit Exceeded
    public static List<Integer> countSmaller(Integer[] nums) {
        if (nums == null) return null;
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        if (len == 0) return res;

        ArrayList<Integer> cur = new ArrayList<>();
        Integer[] resArr = new Integer[len];
        resArr[len - 1] = 0;
        cur.add(nums[len - 1]);
        int max = nums[len - 1];
        int min = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                cur.add(nums[i]);
                resArr[i] = len - i - 1;
            } else if (nums[i] < min) {
                min = nums[i];
                cur.add(0, nums[i]);
                resArr[i] = 0;
            } else {
                int j = 0;
                for (; j < cur.size(); j++) {
                    if (cur.get(j) >= nums[i]) break;
                }
                cur.add(j, nums[i]);
                resArr[i] = j;
            }
        }
        return Arrays.asList(resArr);
    }

    private static class TempNode implements Comparable<TempNode> {
        int val;
        int index;
        int cnt;

        TempNode(int v, int i) {
            val = v;
            index = i;
            cnt = 0;
        }

        @Override
        public int compareTo(TempNode n) {
            return Integer.compare(val, n.val);
        }
    }

    public static List<Integer> countSmaller2(Integer[] nums) {
        if (nums == null) return null;
        int len = nums.length;
        if (len == 0) return new ArrayList<>();

        ArrayList<TempNode> tempList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            tempList.add(new TempNode(nums[i], i));
        }
        List<TempNode> list = mergeSort(tempList);
        Integer[] resArr = new Integer[len];
        for (TempNode n : list) {
            resArr[n.index] = n.cnt;
        }
        return Arrays.asList(resArr);
    }

    private static List<TempNode> mergeSort(List<TempNode> list) {
        int len = list.size();
        if (len <= 1) return list;
        int m = len / 2;

        List<TempNode> leftList = mergeSort(list.subList(0, m));
        List<TempNode> rightList = mergeSort(list.subList(m, len));
        return merge(leftList, rightList);
    }

    private static List<TempNode> merge(List<TempNode> leftList, List<TempNode> rightList) {
        if (leftList == null || rightList == null) {
            if (leftList == null && rightList == null) {
                return null;
            } else if (leftList == null) {
                return rightList;
            } else {
                return leftList;
            }
        }
        ArrayList<TempNode> tempList = new ArrayList<>();
        int leftLen = leftList.size();
        int rightLen = rightList.size();
        int leftCur = 0;
        int rightCur = 0;
        int tempCur = 0;
        while (leftCur < leftLen && rightCur < rightLen) {
            if (leftList.get(leftCur).compareTo(rightList.get(rightCur)) <= 0) {
                tempList.add(leftList.get(leftCur));
                tempList.get(tempCur).cnt += rightCur;
                tempCur++;
                leftCur++;
            } else {
                tempList.add(rightList.get(rightCur));
                tempCur++;
                rightCur++;
            }
        }
        while (leftCur < leftLen) {
            tempList.add(leftList.get(leftCur++));
            tempList.get(tempCur++).cnt += rightLen;
        }
        while (rightCur < rightLen) {
            tempList.add(rightList.get(rightCur++));
        }
        return tempList;
    }

    // TODO
    public static List<Integer> countSmaller3(Integer[] nums) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        for (int i : nums) sortedSet.add(i);
        HashMap<Integer, Integer> M = new HashMap<>();
        Iterator iter = sortedSet.iterator();
        int index = 1;
        while (iter.hasNext()) {
            M.put((Integer) iter.next(), index++);
        }
        System.out.println("\tM = " + M);

        FenwickTree bit = new FenwickTree(sortedSet.size() + 1);
        ArrayList<Integer> res = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++)
            res.add(0);

        for (int i = nums.length - 1; i >= 0; i--) {
            res.set(i, bit.sum(M.get(nums[i]) - 1));
            bit.add(M.get(nums[i]), 1);
        }
        return res;
    }

    public static List<Integer> countSmaller4(Integer[] nums) {
        if (nums == null) return null;
        int len = nums.length;
        ArrayList<Integer> res = new ArrayList<>();

        TempNode[] input = new TempNode[len];
        for (int i = 0; i < len; i++) {
            input[i] = new TempNode(nums[i], i);
        }

        mergeSort(input, 0, len - 1);

        Integer[] resArr = new Integer[len];
        for (TempNode n : input) {
            resArr[n.index] = n.cnt;
        }
        return Arrays.asList(resArr);
    }

    private static void mergeSort(TempNode[] input, int b, int e) {
        if (input == null || b < 0 || e < 0 || b >= e) return;
        int m = (b + e) / 2;

        mergeSort(input, b, m);
        mergeSort(input, m + 1, e);
        merge(input, b, m, m + 1, e);
    }

    private static void merge(TempNode[] input, int b1, int e1, int b2, int e2) {
        LinkedList<TempNode> temp = new LinkedList<>();
        int curLeft = b1, curRight = b2;

        while (curLeft <= e1 && curRight <= e2) {
            if (input[curLeft].val <= input[curRight].val) {
                input[curLeft].cnt += curRight - b2;
                temp.add(input[curLeft]);
                curLeft++;
            } else {
                temp.add(input[curRight]);
                curRight++;
            }
        }
        while (curLeft <= e1) {
            input[curLeft].cnt += e2 - b2 + 1;
            temp.add(input[curLeft]);
            curLeft++;
        }
        while (curRight <= e2) {
            temp.add(input[curRight]);
            curRight++;
        }
        int index = b1;
        for (TempNode n : temp) {
            input[index++] = n;
        }
    }
    // endregion

    //region BFS/DFS

    /**
     * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
     * A region is captured by flipping all 'O's into 'X's in that surrounded region .
     * For example,
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * <p>
     * BFS
     */
    public static void surroundedRegions(Character[][] arr, int M, int N) {
        System.out.println("\nStart function surroundedRegions()");

        printTwoDimentinalArray(arr, "Original array:");

        HashSet<Point> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                addToSet(arr, M, N, set, new Point(i, j));
                if (!set.isEmpty()) {
                    int minX = Integer.MAX_VALUE;
                    int maxX = Integer.MIN_VALUE;
                    int minY = Integer.MAX_VALUE;
                    int maxY = Integer.MIN_VALUE;

                    for (Point p : set) {
                        if (p.i < minX) minX = p.i;
                        if (p.i > maxX) maxX = p.i;
                        if (p.j < minY) minY = p.j;
                        if (p.j > maxY) maxY = p.j;
                    }
                    if (!(minX == 0 || maxX == (M - 1) || minY == 0 || maxY == (N - 1))) {
                        for (Point p : set) {
                            arr[p.i][p.j] = '|';
                        }
                    } else {
                        for (Point p : set) {
                            arr[p.i][p.j] = '-';
                        }
                    }
                    set.clear();
                }
            }
        }

        printTwoDimentinalArray(arr, "Converted array");
    }

    private static void addToSet(Character[][] arr, int M, int N, HashSet<Point> set, Point p) {
        if (p.i >= M || p.i < 0 || p.j >= N || p.j < 0 || set.contains(p))
            return;
        if (arr[p.i][p.j] == 'O') {
            set.add(p);
            // System.out.println("Size: " + set.size() + "; x = " + p.i + "; y = " + p.j);
            addToSet(arr, M, N, set, new Point(p.i + 1, p.j));
            addToSet(arr, M, N, set, new Point(p.i - 1, p.j));
            addToSet(arr, M, N, set, new Point(p.i, p.j + 1));
            addToSet(arr, M, N, set, new Point(p.i, p.j + 1));
        }
    }

    static class Point implements Comparable<Point> {
        public int i;
        public int j;

        public Point(int x, int y) {
            i = x;
            j = y;
        };

        @Override
        public int compareTo(Point p) {
            int pi = p.i;
            int pj = p.j;

            if (pi == i && pj == j)
                return 0;
            else if ((i > pi) && ((i == pi) && (j > pj)))
                return 1;
            else // ((i < pi) && ((i == pi) && (j < pj)))
                return -1;
        }

        @Override
        public boolean equals(Object p) {
            if (this == p) return true;

            if (!(p instanceof Point)) return false;

            Point tempP = (Point) p;

            return (this.compareTo(tempP) == 0);
        }

        @Override
        public int hashCode() {
            return ((Integer) (i)).hashCode() + ((Integer) (j)).hashCode();
        }
    }

    public static void surroundedRegions2(Character[][] arr, int M, int N) {
        System.out.println("\nStart function surroundedRegions2()");

        printTwoDimentinalArray(arr, "Original array in surroundedRegions2");

        HashMap<Integer, HashSet<Integer>> dict = new HashMap<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'O') {
                    addToQueue(arr, M, N, i, j, dict);
                    if (!dict.isEmpty()) {
                        boolean clear = true;
                        if (dict.keySet().contains(0) || dict.keySet().contains(M - 1))
                            clear = false;
                        for (HashSet<Integer> set : dict.values()) {
                            if (set.contains(0) || set.contains(N - 1))
                                clear = false;
                        }

                        if (clear) {
                            for (Integer r : dict.keySet())
                                for (Integer c : dict.get(r))
                                    arr[r][c] = 'X';
                        }

                        dict.clear();
                    }
                }
            }
        }

        printTwoDimentinalArray(arr, "Converted array");
    }

    private static void addToQueue(Character[][] arr, int M, int N, int i, int j, HashMap<Integer, HashSet<Integer>> dict) {
        if (i >= M || i < 0 || j >= N || j < 0)
            return;
        if (arr[i][j] != 'O')
            return;
        else {
            if (dict.keySet().contains(i)) {
                if (dict.get(i).contains(j)) {
                    return;
                } else {
                    dict.get(i).add(j);
                }
            } else {
                dict.put(i, new HashSet<Integer>());
                dict.get(i).add(j);
            }
            addToQueue(arr, M, N, i + 1, j, dict);
            addToQueue(arr, M, N, i - 1, j, dict);
            addToQueue(arr, M, N, i, j + 1, dict);
            addToQueue(arr, M, N, i, j - 1, dict);
        }
    }

    public static void surroundedRegions3(Character[][] board) {
        System.out.println("\nStart function surroundedRegions3()");
        if (board == null)
            return;
        int M = board.length;
        if (M == 0)
            return;
        int N = board[0].length;
        if (N == 0)
            return;

        printTwoDimentinalArray(board, "Original array in surroundedRegions3");

        HashMap<Integer, HashSet<Integer>> dict = new HashMap<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    boolean clear = addToMap2(board, M, N, i, j, dict);
                    if (clear) {
                        for (Integer r : dict.keySet())
                            for (Integer c : dict.get(r))
                                board[r][c] = 'X';
                    }

                    dict.clear();
                }
            }
        }

        printTwoDimentinalArray(board, "Converted array");
    }

    private static boolean addToMap2(Character[][] arr, int M, int N, int i, int j, HashMap<Integer, HashSet<Integer>> dict) {
        if (i > M - 1 || i < 0 || j > N - 1 || j < 0)
            return false;
        if (arr[i][j] != 'O')
            return true;
        else {
            if (i == M - 1 || i == 0 || j == N - 1 || j == 0)
                return false;
            else {
                if (!dict.keySet().isEmpty() && dict.keySet().contains(i)) {
                    if (dict.get(i).contains(j)) {
                        return true;
                    } else {
                        dict.get(i).add(j);
                    }
                } else {
                    dict.put(i, new HashSet<Integer>());
                    dict.get(i).add(j);
                }
                return addToMap2(arr, M, N, i + 1, j, dict) &&
                        addToMap2(arr, M, N, i - 1, j, dict) &&
                        addToMap2(arr, M, N, i, j + 1, dict) &&
                        addToMap2(arr, M, N, i, j - 1, dict);
            }
        }
    }

    public static void surroundedRegions4(Character[][] board) {
        System.out.println("\nStart function surroundedRegions4()");
        if (board == null)
            return;
        int M = board.length;
        if (M == 0)
            return;
        int N = board[0].length;
        if (N == 0)
            return;

        printTwoDimentinalArray(board, "Original array in surroundedRegions4");
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O')
                MARK(board, M, N, 0, j);
        }
        for (int j = 0; j < N; j++) {
            if (board[M - 1][j] == 'O')
                MARK(board, M, N, M - 1, j);
        }
        for (int i = 1; i < M - 1; i++) {
            if (board[i][0] == 'O')
                MARK(board, M, N, i, 0);
        }
        for (int i = 1; i < M - 1; i++) {
            if (board[i][N - 1] == 'O')
                MARK(board, M, N, i, N - 1);
        }

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }

        printTwoDimentinalArray(board, "Converted array");
    }

    private static void MARK(Character[][] arr, int M, int N, int i, int j) {
        if (i > M - 1 || i < 0 || j > N - 1 || j < 0)
            return;
        if (arr[i][j] != 'O')
            return;
        else {
            arr[i][j] = 'A';
            if (i + 1 < M && i + 1 >= 0 && j < N && j >= 0 && arr[i + 1][j] == 'O')
                MARK(arr, M, N, i + 1, j);
            if (i - 1 < M && i - 1 >= 0 && j < N && j >= 0 && arr[i - 1][j] == 'O')
                MARK(arr, M, N, i - 1, j);
            if (i < M && i >= 0 && j + 1 < N && j + 1 >= 0 && arr[i][j + 1] == 'O')
                MARK(arr, M, N, i, j + 1);
            if (i < M && i >= 0 && j - 1 < N && j - 1 >= 0 && arr[i][j - 1] == 'O')
                MARK(arr, M, N, i, j - 1);
        }
    }

    // The most efficient manner: BFS
    public static void surroundedRegions5(Character[][] board) {
        System.out.println("\nStart function surroundedRegions5()");
        if (board == null)
            return;
        int M = board.length;
        if (M == 0)
            return;
        int N = board[0].length;
        if (N == 0)
            return;

        printTwoDimentinalArray(board, "Original array in surroundedRegions5");

        Queue<Point> q = new LinkedList<>();

        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O')
                q.add(new Point(0, j));
        }
        if (M > 1) {
            for (int j = 0; j < N; j++) {
                if (board[M - 1][j] == 'O')
                    q.add(new Point(M - 1, j));
            }
        }
        if (M > 2) {
            for (int i = 1; i < M - 1; i++) {
                if (board[i][0] == 'O')
                    q.add(new Point(i, 0));
            }
            if (N > 1) {
                for (int i = 1; i < M - 1; i++) {
                    if (board[i][N - 1] == 'O')
                        q.add(new Point(i, N - 1));
                }
            }
        }
        while (!q.isEmpty()) {
            Point temp = q.poll();
            int i = temp.i;
            int j = temp.j;
            board[i][j] = 'A';
            if (i + 1 < M && i + 1 >= 0 && j < N && j >= 0 && board[i + 1][j] == 'O')
                q.add(new Point(i + 1, j));
            if (i - 1 < M && i - 1 >= 0 && j < N && j >= 0 && board[i - 1][j] == 'O')
                q.add(new Point(i - 1, j));
            if (i < M && i >= 0 && j + 1 < N && j + 1 >= 0 && board[i][j + 1] == 'O')
                q.add(new Point(i, j + 1));
            if (i < M && i >= 0 && j - 1 < N && j - 1 >= 0 && board[i][j - 1] == 'O')
                q.add(new Point(i, j - 1));
        }
//        while (!q.isEmpty()) {
//            int size = q.size();
//            while (size-- > 0) {
//                Point temp = q.poll();
//                int i = temp.i;
//                int j = temp.j;
//                board[i][j] = 'A';
//                if (i+1 < M && i+1 >= 0 && j < N && j >= 0 && board[i+1][j] == 'O')
//                    q.add(new Point(i+1, j));
//                if (i-1 < M && i-1 >= 0 && j < N && j >= 0 && board[i-1][j] == 'O')
//                    q.add(new Point(i-1, j));
//                if (i < M && i >= 0 && j+1 < N && j+1 >= 0 && board[i][j+1] == 'O')
//                    q.add(new Point(i, j+1));
//                if (i < M && i >= 0 && j-1 < N && j-1 >= 0 && board[i][j-1] == 'O')
//                    q.add(new Point(i, j-1));
//            }
//        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        printTwoDimentinalArray(board, "Converted array: ");
    }

    /**
     * Given a grid, the value of each spot means:
     * 0                  => Empty spot
     * -1                  => Guard
     * -2                  => Blocked spot
     * Find # of steps from each empty spot to its
     * closest guard.
     * <p>
     * BFS
     */
    public static void findShortestPathToGuard(Integer[][] grid) {
        assert grid != null;
        int R = grid.length;
        if (R <= 0) return;
        int C = grid[0].length;
        if (C <= 0) return;

        Queue<Point> Q = new LinkedList<>();
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (grid[i][j] == -1)
                    Q.add(new Point(i, j));

        int level = 0;
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                Point cur = Q.poll();
                addNewPoint(grid, Q, cur.i, cur.j, level);
            }
            level++;
        }
    }

    private static void addNewPoint(Integer[][] grid, Queue<Point> Q, int x, int y, int level) {
        int R = grid.length;
        int C = grid[0].length;
        int newLevel = level + 1;
        if (x + 1 >= 0 && x + 1 < R && grid[x + 1][y] == 0) {
            grid[x + 1][y] = newLevel;
            Q.add(new Point(x + 1, y));
        }
        if (x - 1 >= 0 && x - 1 < R && grid[x - 1][y] == 0) {
            grid[x - 1][y] = newLevel;
            Q.add(new Point(x - 1, y));
        }
        if (y + 1 >= 0 && y + 1 < C && grid[x][y + 1] == 0) {
            grid[x][y + 1] = newLevel;
            Q.add(new Point(x, y + 1));
        }
        if (y - 1 >= 0 && y - 1 < C && grid[x][y - 1] == 0) {
            grid[x][y - 1] = newLevel;
            Q.add(new Point(x, y - 1));
        }
    }

    /**
     * find the number of solutions (non-negative integral) for the equation x1+x2+x3+x4+x5=20.
     * ie, #((0,0,0,0,20),(0,0,0,20,0),....)
     * <p>
     * For instance: var = 2, sum = 3, the possible solution would be:
     * [1, 2], [2, 1], [0, 3], [3, 0]
     */
    public static int findNumSolution(int var, int sum) {
        if (sum < 0 || var < 1)
            return 0;
        if (var == 1)
            return 1;

        int total = 0;
        for (int i = 0; i <= sum; i++) {
            int tmp = findNumSolution(var - 1, sum - i);
            if (tmp == 0)
                break;
            total += tmp;
        }
        return total;
    }

    /**
     * Similar to question above: findNumSolution
     * Return all possible solutions.
     * <p>
     * DFS
     */
    public static List<List<Integer>> findNumSolutionWithResult(int var, int sum) {
        System.out.println("\nStart function findNumSolutionWithResult()");
        ArrayList<List<Integer>> res = new ArrayList<>();
        findNumSolutionWithResultDFS(var, sum, res, new LinkedList<Integer>());

        System.out.println("Possible solutions for (var: " + var + ", sum: " + sum + "):");
        for (List<Integer> list : res)
            System.out.println("\t" + list);
        return res;
    }
    public static void findNumSolutionWithResultDFS(int var, int sum, ArrayList<List<Integer>> res, LinkedList<Integer> tmpList) {
        if (sum < 0 || var < 1)
            return;
        if (var == 1) {
            tmpList.add(sum);
            res.add(new LinkedList<Integer>(tmpList));
            tmpList.removeLast();
            return;
        }

        for (int i = 0; i <= sum; i++) {
            tmpList.add(i);
            findNumSolutionWithResultDFS(var - 1, sum - i, res, tmpList);
            tmpList.removeLast();
        }
    }

    /**
     * Print all possible distinct permutation for a given array, which does not have duplicated items
     * <p>
     * DFS
     */
    public static ArrayList<LinkedList<Integer>> permuteNoDup(Integer[] num) {
        System.out.println("\nStart function permuteNoDup()");
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        if (num == null || num.length <= 0) return results;

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (Integer i : num) map.put(i, true);

        permuteNoDupHelper(map, new LinkedList<>(), results);
        printArray(num, "Input array:");
        for (LinkedList<Integer> res : results) {
            System.out.println("\tpermutation: " + res);
        }

        return results;
    }

    private static void permuteNoDupHelper(HashMap<Integer, Boolean> map, LinkedList<Integer> temp, ArrayList<LinkedList<Integer>> results) {
        if (temp.size() == map.size()) {
            results.add((LinkedList<Integer>) temp.clone());
        } else {
            for (Integer i : map.keySet()) {
                if (map.get(i)) {
                    map.put(i, false);
                    temp.addLast(i);
                    permuteNoDupHelper(map, temp, results);
                    temp.removeLast();
                    map.put(i, true);
                }
            }
        }
    }

    /**
     * Print all possible distinct permutation for a given array, which may have duplicated items
     * <p>
     * DFS
     * <p>
     * Important! Attention!
     */
    public static ArrayList<LinkedList<Integer>> permuteUnique(Integer[] num) {
        System.out.println("\nStart function permuteUnique()");
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : num)
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);

        permuteUniqueHelper(num, map, new LinkedList<Integer>(), results);

        printArray(num, "Input array:");
        for (LinkedList<Integer> res : results) {
            System.out.println("\tpermutation: " + res);
        }

        return results;
    }

    private static void permuteUniqueHelper(Integer[] num, HashMap<Integer, Integer> map, LinkedList<Integer> temp, ArrayList<LinkedList<Integer>> results) {
        if (temp.size() == num.length) {
            results.add((LinkedList<Integer>) (temp.clone()));
        } else {
            for (Integer key : map.keySet()) {
                int val = map.get(key);
                if (val > 0) {
                    map.put(key, val - 1);
                    temp.addLast(key);
                    permuteUniqueHelper(num, map, temp, results);
                    temp.removeLast();
                    map.put(key, val);
                }
            }
        }
    }

    /**
     * Return all possible subsets of a given array which has no duplicated items
     * <p>
     * DFS
     */
    public static List<List<Integer>> subsetsWithNoDup(Integer[] num) {
        System.out.println("\nStart function subsetsWithNoDup()");
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length <= 0) return res;

        subsetsWithNoDupHelper(num, new LinkedList<>(), res, 0);

        printArray(num, "Input array:");
        for (List<Integer> set : res) {
            System.out.println("\tsubset: " + set);
        }
        return res;
    }
    private static void subsetsWithNoDupHelper(Integer[] num, LinkedList<Integer> temp, ArrayList<List<Integer>> res, int index) {
        if (index == num.length) {
            res.add(new LinkedList<Integer>(temp));
        } else {
            subsetsWithNoDupHelper(num, temp, res, index + 1);
            temp.add(num[index]);
            subsetsWithNoDupHelper(num, temp, res, index + 1);
            temp.remove(num[index]);
        }
    }

    public static List<List<Integer>> subsetsWithNoDup2(Integer[] num) {
        System.out.println("\nStart function subsetsWithNoDup2()");
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length <= 0) return res;

        Arrays.sort(num);
        subsetsWithNoDupHelper2(num, new LinkedList<>(), res, 0);

        printArray(num, "Input array:");
        for (List<Integer> set : res) {
            System.out.println("\tsubset: " + set);
        }
        return res;
    }
    private static void subsetsWithNoDupHelper2(Integer[] num, LinkedList<Integer> temp, ArrayList<List<Integer>> res, int index) {
        if (index == num.length) {
            res.add(new LinkedList<Integer>(temp));
        } else {
            subsetsWithNoDupHelper2(num, temp, res, index + 1);
            temp.add(num[index]);
            subsetsWithNoDupHelper2(num, temp, res, index + 1);
            temp.remove(num[index]);
        }
    }

    /**
     * Recursive manner
     * <p>
     * DFS
     */
    public static List<List<Integer>> subsetsWithDupRecursive(Integer[] num) {
        System.out.println("\nStart function subsetsWithDupRecursive()");
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length <= 0) return results;

        Arrays.sort(num);

        subsetsWithDupHelper(num, new ArrayList<>(), results, 0);

        printArray(num, "Input array:");
        for (List<Integer> list : results) {
            System.out.println("\tsubset: " + list);
        }
        return results;
    }

    private static void subsetsWithDupHelper(Integer[] num,
                                             ArrayList<Integer> temp,
                                             ArrayList<List<Integer>> results,
                                             int index) {
        if (index == num.length) {
            results.add((ArrayList<Integer>) temp.clone());
            return;
        }

        int i;
        for (i = index + 1; i < num.length; i++) {
            if (num[index] != num[i])
                break;
        }
        int dupLen = i - index;

        for (int time = 0; time <= dupLen; time++) {
            for (int j = 0; j < time; j++)
                temp.add(num[index]);
            subsetsWithDupHelper(num, temp, results, index + dupLen);
            for (int j = 0; j < time; j++)
                temp.remove(temp.size() - 1);
        }
    }

    // Similar to solution above. But no SORTING is needed.
    // Trade time-complexity with space-complexity.
    public static List<List<Integer>> subsetsWithDupRecursive2(Integer[] num) {
        System.out.println("\nStart function subsetsWithDupRecursive2()");
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length <= 0) return results;

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : num) {
            if (countMap.containsKey(i)) countMap.put(i, countMap.get(i) + 1);
            else countMap.put(i, 1);
        }
        ArrayList<Integer> items = new ArrayList<>(countMap.keySet());

        subsetsWithDupHelper2(items, countMap, new LinkedList<>(), results, 0);
        printArray(num, "Input array:");
        for (List<Integer> list : results) {
            System.out.println("\tsubset: " + list);
        }
        return results;
    }
    private static void subsetsWithDupHelper2(ArrayList<Integer> items,
                                              HashMap<Integer, Integer> countMap,
                                              LinkedList<Integer> temp,
                                              ArrayList<List<Integer>> results,
                                              int index) {
        if (index == items.size()) {
            results.add((LinkedList<Integer>) temp.clone());
        } else {
            int val = items.get(index);
            int count = countMap.get(val);
            if (count > 0) {
                for (int time = 0; time <= count; time++) {
                    for (int j = 0; j < time; j++) temp.add(val);
                    subsetsWithDupHelper2(items, countMap, temp, results, index + 1);
                    for (int j = 0; j < time; j++) temp.removeLast();
                }
            }
        }
    }

    public static List<List<Integer>> subsetsWithDupRecursive3(Integer[] num) {
        System.out.println("\nStart function subsetsWithDupRecursive3()");
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length <= 0) return results;

        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int i : num) {
            if (countMap.containsKey(i)) countMap.put(i, countMap.get(i) + 1);
            else countMap.put(i, 1);
        }

        subsetsWithDupHelper3(countMap, new LinkedList<>(), results);
        printArray(num, "Input array:");
        for (List<Integer> list : results) {
            System.out.println("\tsubset: " + list);
        }
        return results;
    }
    private static void subsetsWithDupHelper3(TreeMap<Integer, Integer> countMap,
                                              LinkedList<Integer> temp,
                                              ArrayList<List<Integer>> results) {
        if (countMap.isEmpty()) {
            results.add(new LinkedList<>(temp));
        } else {
            int k = countMap.firstKey();
            if (countMap.get(k) > 0) {
                int count = countMap.get(k);
                countMap.remove(k);
                for (int time = 0; time <= count; time++) {
                    for (int j = 0; j < time; j++) temp.add(k);
                    subsetsWithDupHelper3(countMap, temp, results);
                    for (int j = 0; j < time; j++) temp.removeLast();
                }
                countMap.put(k, count);
            }
        }
    }

    // Iterative manner
    public static List<List<Integer>> subsetsWithDupIterative(Integer[] num) {
        System.out.println("\nStart function subsetsWithDupIterative()");
        if (num == null)
            return null;

        Arrays.sort(num);

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> prev = new ArrayList<List<Integer>>();

        for (int i = num.length - 1; i >= 0; i--) {
            //get existing sets
            if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
                prev.clear();
                for (int j = 0; j < result.size(); j++) {
                    prev.add(new ArrayList<Integer>(result.get(j)));
                }
            }

            //add current number to each element of the set
            for (List<Integer> temp : prev) {
                ((ArrayList<Integer>) temp).add(0, num[i]);
            }

            //add each single number as a set, only if current element is different with previous
            if (i == num.length - 1 || num[i] != num[i + 1]) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                prev.add(temp);
            }

            //add all set created in this iteration
            for (List<Integer> temp : prev) {
                result.add(new ArrayList<Integer>(temp));
            }
        }

        //add empty set
        result.add(new ArrayList<Integer>());

        printArray(num, "Input array:");
        for (List<Integer> list : result) {
            System.out.println("\tsubset: " + list);
        }

        return result;
    }

    //region Combination Sum
    /**
     * Given an array of integers & a target sum, find all possible combinations of integers that sum up equal to target.
     * Each integer can be used multiple times, and the integers are distinct from each other.
     * <p>
     * For intance: input array = [2, 3, 4, 6, 7] && target = 10:
     * combinationSum: [4, 6]
     * combinationSum: [3, 7]
     * combinationSum: [3, 3, 4]
     * combinationSum: [2, 4, 4]
     * combinationSum: [2, 2, 6]
     * combinationSum: [2, 2, 3, 3]
     * combinationSum: [2, 2, 2, 4]
     * combinationSum: [2, 2, 2, 2, 2]
     * <p>
     * DFS
     */
    public static List<List<Integer>> combinationSumWithNoDupInput(Integer[] candidates, int target) {
        System.out.println("\nStart function combinationSumWithNoDupInput()");
        List<List<Integer>> results = new ArrayList<>();

        combinationSumWithNoDupInputDFS(candidates, target, new LinkedList<>(), results, 0);

        printArray(candidates, "Input array:");
        for (List<Integer> res : results) {
            System.out.println("\tcombinationSum: " + res);
        }

        return results;
    }

    private static void combinationSumWithNoDupInputDFS(Integer[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> res, int index) {
        if (target == 0) {
            res.add(new LinkedList<>(temp));
        } else if (index < candidates.length && target > 0) {
            combinationSumWithNoDupInputDFS(candidates, target, temp, res, index + 1);
            int count = target / candidates[index];
            for (int i = 1; i <= count; i++) {
                temp.add(candidates[index]);
                combinationSumWithNoDupInputDFS(candidates, target - i * candidates[index], temp, res, index + 1);
            }
            for (int i = 1; i <= count; i++) {
                temp.removeLast();
            }
        }
    }

    /**
     * Combination Sum
     *
     * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     *
     * The same repeated number may be chosen from C unlimited number of times.
     *
     *         Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [2, 3, 6, 7] and target 7,
     * A solution set is:
     *         [
     *         [7],
     *         [2, 2, 3]
     *         ]
     */
    public static List<List<Integer>> combinationSum(Integer[] candidates, int target) {
        System.out.println("\nStart function combinationSum()");
        System.out.println("\tTarget = " + target);
        printArray(candidates, "\tCandidate: ");
        ArrayList<List<Integer>> results = new ArrayList<> ();
        Arrays.sort(candidates);

//        combinationSumDFS (candidates, target, new LinkedList<Integer> (), results, 0);

        combinationSumDFS2 (candidates, target, new LinkedList<Integer> (), results, 0);

        for (List<Integer> r : results) {
            System.out.println("\t\t" + r);
        }
        return results;
    }
    // This version cannot handle cases like (new Integer [] {2, 2, 3, 4, 6, 7}, 7)
    private static void combinationSumDFS(Integer[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> results, int index) {
        if (target == 0) {
            results.add(new LinkedList<> (temp));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }
        combinationSumDFS(candidates, target, temp, results, index+1);
        int count = target/candidates[index];
        for (int i = 1; i <= count; i++) {
            temp.add(candidates[index]);
            combinationSumDFS(candidates, target-i*candidates[index], temp, results, index+1);
        }
        for (int i = 1; i <= count; i++) {
            temp.removeLast();
        }
    }
    // This version can handle array with duplicated elements
    private static void combinationSumDFS2(Integer[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> results, int start) {
        if (target == 0) {
            results.add(new LinkedList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] <= target) {
                temp.add(candidates[i]);
                combinationSumDFS2(candidates, target-candidates[i], temp, results, i);
                temp.removeLast();
            }
        }
    }

    public static List<List<Integer>> combinationSumI_2(Integer[] candidates, int target) {
        System.out.println("\nStart function combinationSumI_2()");
        System.out.println("\tTarget = " + target);
        printArray(candidates, "\tCandidate: ");
        ArrayList<List<Integer>> results = new ArrayList<> ();
        TreeSet<Integer> keys = new TreeSet<>();
        for (int i : candidates) {
            keys.add(i);
        }
        System.out.println("\tkeys = " + keys);

        combinationSumDFSI_2 (new ArrayList<Integer>(keys), target, new LinkedList<Integer> (), results, 0);

        for (List<Integer> r : results) {
            System.out.println("\t\t" + r);
        }
        return results;
    }
    private static void combinationSumDFSI_2(ArrayList<Integer> keys, int target, LinkedList<Integer> temp, ArrayList<List<Integer>> results, int idx) {
        System.out.println("\ttemp = " + temp);
        System.out.println("\ttarget = " + target);
        if (target == 0) {
            results.add(new LinkedList<>(temp));
            return;
        }
        for (int i = idx; i < keys.size(); i++) {
            if (target >= keys.get(i)) {
                temp.add(keys.get(i));
                combinationSumDFSI_2(keys, target - keys.get(i), temp, results, i);
                temp.removeLast();
            }
        }
    }

    /**
     * Combination Sum II
     *
     * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
     *
     * Each number in C may only be used once in the combination.
     *
     * Note:
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
     * A solution set is:
     *         [
     *         [1, 7],
     *         [1, 2, 5],
     *         [2, 6],
     *         [1, 1, 6]
     *         ]
     */
    public static List<List<Integer>> combinationSum2(Integer[] candidates, int target) {
        System.out.println("\nStart function combinationSum2()");
        System.out.println("\tTarget = " + target);
        printArray(candidates, "\tCandidate: ");
        ArrayList<List<Integer>> results = new ArrayList<> ();

        Arrays.sort(candidates);
//        combinationSumDFS2 (candidates, target, new LinkedList<> (), results, 0);
        combinationSumDFS2_2 (candidates, target, new LinkedList<> (), results, 0);
//        combinationSumDFS2_3 (candidates, target, new LinkedList<> (), results, 0);

        for (List<Integer> r : results) {
            System.out.println("\t\t" + r);
        }
        return results;
    }
    private static void combinationSumDFS2 (Integer[] candidates, int target, LinkedList<Integer> temp, ArrayList<List<Integer>> results, int index) {
        int len = candidates.length;
        Integer sum = 0;
        for (Integer i : temp)
            sum += i;
        if (sum == target) {
            results.add(new LinkedList<>(temp));
            return;
        }
        if (sum > target || index >= len)
            return;

        int count = 1;
        while (index + count < len) {
            if (candidates[index] == candidates[index + count]) {
                count++;
            } else {
                break;
            }
        }
        combinationSumDFS2 (candidates, target, temp, results, index + count);
        for (int i  = 0; i < count; i++) {
            temp.add(candidates[index]);
            combinationSumDFS2 (candidates, target, temp, results, index + count);
        }
        for (int i  = 0; i < count; i++) {
            temp.removeLast();
        }
    }
    private static void combinationSumDFS2_3 (Integer[] candidates, int target, LinkedList<Integer> temp, ArrayList<List<Integer>> results, int index) {
        if (target == 0) {
            results.add(new LinkedList<>(temp));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }

        int count = 1;
        while (index + count < candidates.length) {
            if (candidates[index] == candidates[index + count]) {
                count++;
            } else {
                break;
            }
        }
        combinationSumDFS2_3 (candidates, target, temp, results, index + count);
        for (int i  = 1; i <= count; i++) {
            temp.add(candidates[index]);
            combinationSumDFS2_3 (candidates, target - i * candidates[index], temp, results, index + count);
        }
        for (int i  = 1; i <= count; i++) {
            temp.removeLast();
        }
    }
    private static void combinationSumDFS2_2 (Integer[] candidates, int target, LinkedList<Integer> temp, ArrayList<List<Integer>> results, int start) {
        if (target == 0) {
            results.add(new LinkedList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] <= target) {
                temp.add(candidates[i]);
                combinationSumDFS2_2(candidates, target-candidates[i], temp, results, i+1);
                temp.removeLast();
            }
        }
    }
    /**
     * Combination Sum III
     * Find all possible combinations of k numbers that add up to a number n,
     * given that only numbers from 1 to 9 can be used and
     * each combination should be a unique set of numbers.
     * Example 1:
     *    Input: k = 3, n = 7
     * Output:
     *    [[1,2,4]]
     * Example 2:
     *    Input: k = 3, n = 9
     * Output:
     *    [[1,2,6], [1,3,5], [2,3,4]]
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        System.out.println("\nStart function combinationSum3()");
        System.out.println("\tk = " + k + "; n = " + n);
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (n > 45 || n < 1 || k > 9 || k < 1) return res;

//        combinationSum3Helper(k, n, 1, new LinkedList<Integer>(), res);
        combinationSum3DFS(k, n, 1, new LinkedList<Integer>(), res);
        System.out.println("\t" + res);
        return res;
    }
    private static void combinationSum3Helper(int k, int n, int start, LinkedList<Integer> tempList, ArrayList<List<Integer>> res) {
        if (k == 0 && n == 0) {
            res.add(new LinkedList<>(tempList));
            return;
        }
        if (k < 0 || n < 0 || start > 9) return;

        combinationSum3Helper(k, n, start+1, tempList, res);
        tempList.add(start);
        combinationSum3Helper(k-1, n-start, start+1, tempList, res);
        tempList.removeLast();
    }
    private static void combinationSum3DFS(int k, int sum, int start, LinkedList<Integer> tempList, ArrayList<List<Integer>> res) {
        if (k == 0 && sum == 0) {
            res.add(new LinkedList<>(tempList));
            return;
        }
        if (k < 0 || sum < 0 || start > 9) return;

        for (int i = start; i <= 9; i++) {
            if (i <= sum) {
                tempList.add(i);
                combinationSum3DFS(k - 1, sum - i, i+1, tempList, res);
                tempList.removeLast();
            }
        }
    }
    /**
     * Combination Sum IV
     * Given an integer array with all positive numbers and no duplicates,
     * find the number of possible combinations that add up to a positive integer target.
     * Example:
     *    nums = [1, 2, 3]
     *    target = 4
     * The possible combination ways are:
     *         (1, 1, 1, 1)
     *         (1, 1, 2)
     *         (1, 2, 1)
     *         (1, 3)
     *         (2, 1, 1)
     *         (2, 2)
     *         (3, 1)
     * Note that different sequences are counted as different combinations.
     * Therefore the output is 7.
     * Follow up:
     * What if negative numbers are allowed in the given array?
     * How does it change the problem?
     * What limitation we need to add to the question to allow negative numbers?
     *
     * https://leetcode.com/problems/combination-sum-iv/
     */
    // This version timeouts
    public static int combinationSum4(Integer[] nums, int target) {
        System.out.println("\nStart function combinationSum4()");
        System.out.println("\tnum = " + Arrays.asList(nums) + "; target = " + target);
        HashSet<List<Integer>> res = new HashSet<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, target/n);
        }
        combinationSum4Helper(map, target, new LinkedList<Integer>(), res);
        System.out.println("\t" + res);
        return res.size();
    }
    private static void combinationSum4Helper(HashMap<Integer, Integer> map, int target, LinkedList<Integer> tempList, HashSet<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<>(tempList));
            return;
        } else if (target < 0) {
            return;
        }

        for (int n : map.keySet()) {
            if (map.get(n) > 0) {
                int val = map.get(n);
                tempList.add(n);
                map.put(n, val - 1);
                combinationSum4Helper(map, target - n, tempList, res);
                tempList.removeLast();
                map.put(n, val);
            }
        }
    }
    // This version passes Leetcode test
    // DP Problem
    public static int combinationSum4_2(Integer[] nums, int target) {
        System.out.println("\nStart function combinationSum4_2()");
        System.out.println("\tnum = " + Arrays.asList(nums) + "; target = " + target);

        int[] D = new int[target+1];
        D[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    D[i] += D[i - nums[j]];
                }
            }
        }

        System.out.println("\tcount = " + D[target]);
        return D[target];
    }
    //endregion

    //region N Queen Games

    /**
     * http://oj.leetcode.com/problems/n-queens/
     */
    static public ArrayList<String[]> solveNQueens(int n) {
        System.out.println("\nStart function solveNQueens(); n = " + n);
        ArrayList<String[]> results = new ArrayList<>();
        // ArrayList<ArrayList<Integer>> permutation = new ArrayList<> ();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[n];
        Arrays.fill(used, false);

        int count = 1;
        for (int i = 1; i <= n; i++)
            count *= i;

        solveNQueensDfs(used, temp, count / 2, n, results);

        for (String[] strs : results) {
            for (String str : strs) {
                System.out.println(str);
            }
            System.out.println();
        }
        return results;
    }

    static private void solveNQueensDfs(
            boolean[] used, ArrayList<Integer> temp,
            int count, int n, ArrayList<String[]> results) {
        if (used.length == temp.size()) {
            testLayout(temp, results, n);
            // cur++;
            // permutation.add((ArrayList<Integer>)temp.clone());
            return;
        }
        // if (cur == count)
        //     return;

        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(i);
                solveNQueensDfs(used, temp, count, n, results);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    static private void testLayout(ArrayList<Integer> a, ArrayList<String[]> results, int n) {
        int len = a.size();

        HashSet<Integer> sum = new HashSet<>();
        HashSet<Integer> difference = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (!sum.contains(a.get(i) + i))
                sum.add(a.get(i) + i);
            if (!difference.contains(a.get(i) - i))
                difference.add(a.get(i) - i);
        }

        if (sum.size() == len && difference.size() == len) {
            char[][] result1 = new char[n][n];
            char[][] result2 = new char[n][n];
            for (int m = 0; m < n; m++) {
                Arrays.fill(result1[m], '.');
                Arrays.fill(result2[m], '.');
            }
            for (int m = 0; m < n; m++) {
                result1[a.get(m)][m] = 'Q';
                result2[n - 1 - a.get(m)][m] = 'Q';
            }
            String[] resultStr1 = new String[n];
            String[] resultStr2 = new String[n];
            for (int m = 0; m < n; m++) {
                resultStr1[m] = new String(result1[m]);
                resultStr2[m] = new String(result2[m]);
            }
            results.add(resultStr1);
            results.add(resultStr2);
        }
    }

    static public ArrayList<Character[][]> solveNQueens2(int n) {
        System.out.println("\nStart function solveNQueens2(); n = " + n);
        ArrayList<Character[][]> results = new ArrayList<>();
        boolean[] col = new boolean[n];
        Integer[] row = new Integer[n];

        Arrays.fill(col, false);
        Arrays.fill(row, 0);

        solveNQueensDfs2(0, n, results, col, row);
        for (Character[][] res : results) {
            printTwoDimentinalArray(res);
            System.out.println();
        }
        return results;
    }

    static private void solveNQueensDfs2(int r, int n, ArrayList<Character[][]> results, boolean[] col, Integer[] row) {
        if (r == n) {
            Character[][] res = new Character[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(res[i], '.');
                res[i][row[i]] = 'Q';
            }
            results.add(res);
        } else {
            int i, j;
            for (j = 0; j < n; j++) {
                if (!col[j]) {
                    for (i = 0; i < r; i++) {
                        if (Math.abs(j - row[i]) == Math.abs(i - r)) {
                            break;
                        }
                    }
                    if (i == r) {
                        row[r] = j;
                        col[j] = true;
                        solveNQueensDfs2(r + 1, n, results, col, row);
                        row[r] = Integer.MIN_VALUE;
                        col[j] = false;
                    }
                }
            }
        }
    }

    // Optimal solution!
    static public ArrayList<Character[][]> solveNQueens3(int n) {
        System.out.println("\nStart function solveNQueens3(); n = " + n);
        ArrayList<Character[][]> results = new ArrayList<>();

        if (n >= 1) {
            solveNQueensDfs3(0, n, new HashMap<Integer, Integer>(), results);
        }
        for (Character[][] res : results) {
            printTwoDimentinalArray(res);
            System.out.println();
        }

        return results;
    }

    static private void solveNQueensDfs3(int r, int n, HashMap<Integer, Integer> map, ArrayList<Character[][]> results) {
        if (r == n) {
            Character[][] res = new Character[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(res[i], '.');
            }
            for (Integer col : map.keySet()) {
                res[map.get(col)][col] = 'Q';
            }
            results.add(res);
        } else {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(j)) {
                    boolean violated = false;
                    for (Integer col : map.keySet()) {
                        if (Math.abs(col - j) == Math.abs(r - map.get(col))) {
                            violated = true;
                            break;
                        }
                    }
                    if (!violated) {
                        map.put(j, r);
                        solveNQueensDfs3(r + 1, n, map, results);
                        map.remove(j);
                    }
                }
            }
        }
    }
    //endregion

    // region Jump Games

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Determine if you are able to reach the last index.
     * <p>
     * For example:
     * A = [2,3,1,1,4], return true.
     * A = [3,2,1,0,4], return false.
     * <p>
     * https://leetcode.com/problems/jump-game/
     *
     * @param A
     * @return
     */
    public static boolean canJump(Integer... A) {
        System.out.println("\nStart function canJump()");
        assert A != null : "Input array is NULL";

        int len = A.length;
        if (len <= 1) return true;

        boolean[] reachable = new boolean[len];
        Arrays.fill(reachable, false);

        reachable[0] = true;
        for (int i = 0; i < len; i++) {
            if (reachable[i]) {
                if (i + A[i] >= len - 1)
                    return true;
                for (int j = 1; j <= A[i]; j++) {
                    reachable[i + j] = true;
                }
            }
        }

        return reachable[len - 1];
    }

    public static boolean canJump2(Integer[] A) {
        System.out.println("\nStart function canJump2()");
        assert A != null : "Input array is NULL";

        int len = A.length;
        if (len <= 1) return true;

        int start = 0;
        int end = 0;

        while (end < len) {
            int max = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i >= len - 1) {
                    return true;
                }
                if (A[i] + i > max)
                    max = A[i] + i;
            }
            if (max == end)
                break;
            start = end + 1;
            end = max;
        }

        return false;
    }

    // Optimal solution
    public static boolean canJump3(Integer[] A) {
        System.out.println("\nStart function canJump3()");
        assert A != null : "Input array is NULL";

        int len = A.length;
        for (int i = 0, maxCover = 0; i <= maxCover && i < len; i++) { // Important is the condition "i <= maxCover"
            if (A[i] + i > maxCover)
                maxCover = A[i] + i;
            if (maxCover >= len - 1)
                return true;
        }
        return false;
    }

    /**
     * Return the minimum steps needed to jump to the end
     * <p>
     * https://leetcode.com/problems/jump-game-ii/
     */
    public static int jump(Integer[] A) {
        System.out.println("\nStart function jump()");
        assert A != null : "Input array is NULL";

        int len = A.length;
        int step = 0;
        if (len <= 1) return step;

        boolean[] handled = new boolean[len];
        handled[0] = true;

        HashSet<Integer> nextStep = new HashSet<>();
        HashSet<Integer> curStep = new HashSet<>();

        curStep.add(0);
        while (!curStep.isEmpty()) {
            step++;
            nextStep.clear();
            for (Integer i : curStep) {
                if (i + A[i] >= len - 1) {
                    return step;
                }
                for (int j = 1; j <= A[i]; j++) {
                    if (!handled[i + j]) {
                        nextStep.add(i + j);
                        handled[i + j] = true;
                    }
                }
            }
            curStep.clear();
            curStep.addAll(nextStep);
        }

        return -1;
    }

    public static int jump2(Integer[] A) {
        System.out.println("\nStart function jump2()");
        assert A != null : "Input array is NULL";
        int len = A.length;
        if (len <= 1) return 0;

        int start = 0;
        int end = 0;
        int count = 0;

        while (end < len) {
            int max = end;
            count++;
            for (int i = start; i <= end; i++) {
                if (A[i] + i >= len - 1) {
                    return count;
                }
                if (A[i] + i > max)
                    max = A[i] + i;
            }
            if (max == end)
                break;
            start = end + 1;
            end = max;
        }

        return -1;
    }

    public static int jump3(Integer[] A) {
        System.out.println("\nStart function jump3()");
        assert A != null : "Input array is NULL";
        int len = A.length;
        if (len <= 1) return 0;

        int step = 0;
        int stepStart = 0;
        int stepEnd = 0;
        while (stepStart < len) {
            int max = stepEnd;
            if (max >= len - 1) return step;

            for (int i = stepStart; i <= stepEnd; i++) {
                max = Math.max(max, i + A[i]);
            }
            step++;
            if (stepEnd == max) break;  // Important
            stepStart = stepEnd + 1;
            stepEnd = max;
        }
        return -1;
    }

    public static int jump4(Integer[] A) {
        System.out.println("\nStart function jump4()");
        assert A != null : "Input array is NULL";
        int len = A.length;
        if (len <= 1) return 0;

        int count = 0;
        for (int s = 0, e = 0, max = 0; s <= e && s < len; s++) {
            if (A[s] + s >= len - 1) return count + 1;
            max = Math.max(max, A[s] + s);
            if (s == e) {
                count++;
                e = max;
            }
        }
        return -1;
    }

    /**
     * Return all possible ways to jump to the end
     * <p>
     * Similar to BFS idea.
     */
    public static List<List<Integer>> jumpPath(Integer[] A) {
        System.out.println("\nStart function jumpPath()");
        assert A != null : "Input array is NULL";

        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = A.length;
        if (len <= 1) return res;

        HashSet<LinkedList<Integer>> nextStep = new HashSet<>();
        HashSet<LinkedList<Integer>> curStep = new HashSet<>();

        LinkedList<Integer> tmpList = new LinkedList<>();
        tmpList.add(0);
        curStep.add(tmpList);
        while (!curStep.isEmpty()) {
            nextStep.clear();

            for (LinkedList<Integer> list : curStep) {
                if (list.isEmpty()) continue;

                Integer i = list.getLast();
                for (int j = 1; (j <= A[i]) && (i + j <= len - 1); j++) {
                    LinkedList<Integer> newList = new LinkedList<>(list);
                    newList.add(i + j);
                    if (i + j == len - 1) {
                        res.add(newList);
                    } else {
                        nextStep.add(newList);
                    }
                }
            }
            curStep.clear();
            curStep.addAll(nextStep);
        }

        System.out.println(Arrays.asList(A) + "'s all jump possibilities: ");
        for (List<Integer> list : res) {
            System.out.println("\t" + list);
        }

        return res;
    }
    public static List<List<Integer>> jumpPath2(Integer[] A) {
        System.out.println("\nStart function jumpPath2()");
        assert A != null : "Input array is NULL";

        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = A.length;
        if (len <= 1) return res;

        LinkedList<Integer> tmpList = new LinkedList<>();
        tmpList.add(0);
        Queue<LinkedList<Integer>> Q = new LinkedList<>();
        Q.add(tmpList);
        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                LinkedList<Integer> curList = Q.poll();
                int lastIdx = curList.getLast();
                for (int i = 1; i <= A[lastIdx] && lastIdx + i <= len - 1; i++) {
                    LinkedList<Integer> newList = new LinkedList<>(curList);
                    newList.add(lastIdx + i);
                    if (lastIdx + i == len - 1) {
                        res.add(newList);
                    } else {
                        Q.add(newList);
                    }
                }
            }
        }

        System.out.println(Arrays.asList(A) + "'s all jump possibilities: ");
        for (List<Integer> list : res) {
            System.out.println("\t" + list);
        }

        return res;
    }
    // This version might be easier to follow
    public static List<List<Integer>> jumpPath3(Integer[] A) {
        System.out.println("\nStart function jumpPath3()");
        assert A != null : "Input array is NULL";

        int len = A.length;
        ArrayList<List<Integer>> res = new ArrayList<>();

        Queue<LinkedList<Integer>> Q = new LinkedList<>();
        LinkedList<Integer> init = new LinkedList<>();
        init.addLast(0);
        Q.add(init);

        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                LinkedList<Integer> curList = Q.poll();
                int lastIndex = curList.getLast();
                int steps = A[lastIndex];
                for (int i = 1; i <= steps && lastIndex + i < len; i++) {
                    LinkedList<Integer> newList = new LinkedList<>(curList);
                    newList.addLast(lastIndex + i);
                    if (lastIndex + i == len - 1) {
                        res.add(newList);
                    } else {
                        Q.add(newList);
                    }
                }
            }
        }

        System.out.println(Arrays.asList(A) + "'s all jump possibilities: ");
        for (List<Integer> list : res) {
            System.out.println("\t" + list);
        }

        return res;
    }

    public static void dragonChallengeDemo(ArrayList<Integer> arr) {
        System.out.println("\nStart function dragonChallengeDemo()");
        System.out.println("\tArr = " + arr);
        System.out.println("\tPath = " + dragonChallenge(arr));
    }
    public static List<Integer> dragonChallenge(ArrayList<Integer> arr) {
        assert arr != null : "Input array is null!";

        LinkedList<Integer> emptyRes = new LinkedList<Integer>();
        int len = arr.size();
        if (len < 1) return emptyRes;
        if (len == 1) {
            if (arr.get(0) <= 0) return emptyRes;
            else return new ArrayList<Integer>(arr);
        }

        HashSet<LinkedList<Integer>> nextStep = new HashSet<>();
        HashSet<LinkedList<Integer>> curStep = new HashSet<>();
        curStep.add(new LinkedList<>(Arrays.asList(new Integer[]{0})));

        while (!curStep.isEmpty()) {
            nextStep.clear();

            for (LinkedList<Integer> cur : curStep) {
                if (cur.isEmpty()) continue;

                Integer curIndex = cur.getLast();
                if (curIndex + arr.get(curIndex) > len - 1) {
                    return cur;
                } else {
                    for (int j = 1; j <= arr.get(curIndex); j++) {
                        if (arr.get(curIndex+j) != 0) {
                            LinkedList<Integer> newList = new LinkedList<>(cur);
                            newList.add(curIndex+j);
                            if (curIndex + j == len - 1) {
                                return newList;
                            } else {
                                nextStep.add(newList);
                            }
                        }
                    }
                }
            }
            curStep.clear();
            curStep.addAll(nextStep);
        }
        return emptyRes;
    }
    //endregion

    // region Search Paths

    /**
     * It is allowed to move right/down for each step.
     * Find all possible paths from top-left corner to bottom-right corner
     * <p>
     * DFS
     */
    public static void searchPath(int M, int N) {
        System.out.println("\nStart function searchPath()");
        Integer[][] arr = new Integer[M][N];
        Character[][] path = new Character[M][N];

        for (int i = 0; i < M; i++) {
            Arrays.fill(path[i], ' ');
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = (int) (Math.random() * 5) > 0 ? 1 : 0;
            }
        }
        arr[0][0] = 1;
        arr[M - 1][N - 1] = 1;
        for (int i = 0; i < M; i++) {
            System.out.println("\t" + Arrays.asList(arr[i]));
        }
        System.out.println();

        searchPathHelper(arr, path, M, N, 0, 0);
        System.out.println("End function searchPath()");
    }

    private static void searchPathHelper(Integer[][] a, Character[][] path, int M, int N, int x, int y) {
        if (x >= M || y >= N || x < 0 || y < 0 || (a[x][y] == 0)) {
            return;
        }

        path[x][y] = '+';
        if ((x == M - 1) && (y == N - 1)) {
            for (int i = 0; i < M; i++) {
                System.out.println("\t" + Arrays.asList(path[i]));
            }
            System.out.println();
        } else {
            searchPathHelper(a, path, M, N, x + 1, y);
            searchPathHelper(a, path, M, N, x, y + 1);
        }
        path[x][y] = ' ';
    }

    /**
     * It is allowed to move left/right/up/down for each step.
     * Find all possible paths from top-left corner to bottom-right corner
     * <p>
     * DFS
     */
    public static void searchAllPath(int M, int N) {
        System.out.println("\nStart function searchAllPath()");
        Integer[][] arr = new Integer[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = (int) (Math.random() * 5) > 0 ? 1 : 0;
        arr[0][0] = 1;
        arr[M - 1][N - 1] = 1;

        System.out.println("The path array:");
        for (int i = 0; i < M; i++) {
            System.out.println("\t" + Arrays.asList(arr[i]));
        }
        System.out.println();

        ArrayList<Integer[][]> results = new ArrayList<>();

        searchAllPathHelper(arr, 0, 0, results, 1);

        System.out.println("The results:");
        for (Integer[][] r : results) {
            for (int i = 0; i < M; i++) {
                System.out.println("\t" + Arrays.asList(r[i]));
            }
            System.out.println();
        }
        System.out.println("\nEnd function searchAllPath()");
    }

    private static void searchAllPathHelper(Integer[][] arr, int x, int y, ArrayList<Integer[][]> results, int index) {
        if (arr == null)
            return;
        int M = arr.length;
        if (M == 0)
            return;
        int N = arr[0].length;
        if (N == 0)
            return;

        if (x >= M || y >= N || x < 0 || y < 0 || arr[x][y] != 1)
            return;

        arr[x][y] = -index;
        if (x == M - 1 && y == N - 1) {
            Integer[][] newResult = new Integer[M][N];
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++)
                    newResult[i][j] = arr[i][j] < 0 ? -arr[i][j] : 0;

            results.add(newResult);
        } else {
            searchAllPathHelper(arr, x + 1, y, results, index + 1);
            searchAllPathHelper(arr, x - 1, y, results, index + 1);
            searchAllPathHelper(arr, x, y + 1, results, index + 1);
            searchAllPathHelper(arr, x, y - 1, results, index + 1);
        }
        arr[x][y] = 1;
    }

    /**
     * Matchsticks to Square
     *
     * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
     * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
     *         Example 1:
     * Input: [1,1,2,2,2]
     * Output: true
     * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
     * Example 2:
     * Input: [3,3,3,3,4]
     * Output: false
     * Explanation: You cannot find a way to form a square with all the matchsticks.
     */
    public static void makesquareDemo(int[] nums) {
        System.out.println("\nStart function makesquareDemo()");
        printArray(nums, "\tNums:");
        System.out.println("\tSquarable: " + makesquare(nums));
    }
    public static boolean makesquare(int[] nums) {
        int len = nums.length;
        if (len < 4) return false;
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum % 4 != 0) return false;
        //Arrays.sort(nums);
        int L = sum/4;

        return makesquareDFS(nums, new int[4], 0, L);
    }
    private static boolean makesquareDFS(int[] nums, int[] sums, int index, int L) {
        if (index == nums.length) {
            if (sums[0] == L &&
                    sums[1] == L &&
                    sums[2] == L) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= L) {
                sums[i] += nums[index];
                if (makesquareDFS(nums, sums, index+1, L)) {
                    return true;
                }
                sums[i] -= nums[index];
            }
        }
        return false;
    }
//    // Not working
//    public static boolean makesquare(int[] nums) {
//        int len = nums.length;
//        if (len < 4) return false;
//        int sum = 0;
//        for (int n : nums) sum += n;
//
//        if (sum % 4 != 0) return false;
//        Arrays.sort(nums);
//        int L = sum/4;
//        int start = 0;
//        int end = len-1;
//
//        sum = 0;
//        while (start < end) {
//            while (nums[end] == L) {
//                end--;
//            }
//            while (nums[start] == L) {
//                start++;
//            }
//            if (start < end) {
//                if (nums[start] + nums[end] + sum == L) {
//                    start++;
//                    end--;
//                    sum = 0;
//                } else if (nums[start] + nums[end] > L) {
//                    return false;
//                } else {
//                    sum += nums[start] + nums[end];
//                    start++;
//                }
//            }
//        }
//        if (start == end) {
//            return nums[start] == L;
//        }
//        return true;
//    }

    //endregion

    //endregion

    // region DP Problem

    /**
     * Wiggle Subsequence
     *
     * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
     *
     * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
     *
     * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
     *
     * Examples:
     * Input: [1,7,4,9,2,5]
     * Output: 6
     * The entire sequence is a wiggle sequence.
     *
     *         Input: [1,17,5,10,13,15,10,5,16,8]
     * Output: 7
     * There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
     *
     * Input: [1,2,3,4,5,6,7,8,9]
     * Output: 2
     */
    public static int wiggleMaxLength(Integer[] nums) {
        System.out.println("\nStart function wiggleMaxLength()");
        printArray(nums, "\tNums: ");
        int len = nums.length;
        if (len <= 1) return len;
        Integer[] D = new Integer[len];
        Integer[] last = new Integer[len];
        D[0] = 1;
        last[0] = 0;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int maxLenIndex = 0;
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (last[j] == 0) {
                    if (D[j] > maxLen && nums[i] != nums[j]) {
                        maxLen = D[j];
                        maxLenIndex = j;
                    }
                } else if (last[j] > 0) {
                    if (D[j] > maxLen && nums[i] < nums[j]) {
                        maxLen = D[j];
                        maxLenIndex = j;
                    }
                } else {
                    if (D[j] > maxLen && nums[i] > nums[j]) {
                        maxLen = D[j];
                        maxLenIndex = j;
                    }
                }
            }
            D[i] = maxLen + 1;
            last[i] = nums[i] - nums[maxLenIndex];
            max = Math.max(max, D[i]);
        }
        printArray(D, "\tD: ");
        printArray(last, "\tLast: ");
        return max;
    }
    public static int wiggleMaxLength2(Integer[] nums) {
        System.out.println("\nStart function wiggleMaxLength2()");
        printArray(nums, "\tNums: ");
        int len = nums.length;
        if (len <= 1) return len;
        Integer[] P = new Integer[len];
        Integer[] Q = new Integer[len];
        Arrays.fill(P, 1);
        Arrays.fill(Q, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    P[i] = Math.max(P[i], Q[j] + 1);
                } else if (nums[i] < nums[j]) {
                    Q[i] = Math.max(Q[i], P[j] + 1);
                }
            }
        }
        printArray(P, "\tP: ");
        printArray(Q, "\tQ: ");
        return Math.max(P[len-1], Q[len-1]);
    }
    public static int wiggleMaxLength3(Integer[] nums) {
        System.out.println("\nStart function wiggleMaxLength3()");
        printArray(nums, "\tNums: ");
        int len = nums.length;
        if (len <= 1) return len;
        int P = 1;
        int Q = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]) {
                P = Q + 1;
            } else if (nums[i] < nums[i-1]) {
                Q = P + 1;
            }
        }
        System.out.println("\tP = " + P);
        System.out.println("\tQ = " + Q);
        return Math.max(P, Q);
    }

    public static void LIS(Integer[] a, int size) {
        if (a == null || size <= 0) {
            return;
        }
        Integer[] b = new Integer[size];
        b[0] = 1;

        for (int i = 1; i < size; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && max < b[j]) {
                    max = b[j];
                }
            }
            b[i] = max + 1;
        }
        int max = 0;
        for (int i : b) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("\na: " + Arrays.asList(a));
        System.out.println("b: " + Arrays.asList(b));
        System.out.println("Longest Increasing Subarray of a is: " + max);
    }

    // Maximum Continuous Sum SubArray
    public static void MCS(Integer[] a, int size) {
        System.out.println("\nStart function MCS()");
        if (a == null || size <= 0) {
            return;
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = 0;
        int i, j;

        for (i = 0, j = 0; i < size; i++) {
            sum += a[i];
            if (sum < 0) {
                sum = 0;
                j = i + 1;
            } else if (sum > max) {
                max = sum;
                start = j;
                end = i;
            }
        }
        System.out.println("\ta: " + Arrays.asList(a));
        System.out.println("\tMaximum Continuous Sum of a is: " + max + "; Start: " + start + "; End: " + end);
    }

    private static int BC(Integer[][] a, int N, int M, int top, int down, int column) {
        if (a == null || N <= 0 || M <= 0 || top < 0 || down < 0 || column < 0 ||
                top > down || top >= N || down >= N || column >= M) {
            return -1;
        }
        int sum = 0;
        for (int r = top; r <= down; r++) {
            sum += a[r][column];
        }
        return sum;
    }

    public static void MSC2Dimentional(Integer[][] a, int N, int M) {
        System.out.println("\nStart function MSC2Dimentional()");
        if (a == null || N <= 0 || M <= 0) {
            return;
        }
        int sum = 0;
        int max = 0;
        int top = 0, down = 0, left = 0, right = 0;
        int T = 0, D = 0, L = 0, R = 0;

        for (T = 0; T < N; T++) {
            for (D = T; D < N; D++) {
                sum = 0;
                for (R = 0; R < M; R++) {
                    sum += BC(a, N, M, T, D, R);
                    if (sum < 0) {
                        sum = 0;
                        L = R + 1;
                    } else if (sum > max) {
                        max = sum;
                        top = T;
                        down = D;
                        left = L;
                        right = R;
                    }
                }
            }
        }
        System.out.println("\tArray:");
        for (int i = 0; i < N; i++) {
            System.out.println("\t" + Arrays.asList(a[i]));
        }
        System.out.println("\tMaximum Continuous Sum of a is: " + max);
        System.out.println("\tTop: " + top + "; Down: " + down + "; Left: " + left + "; Right " + right);
    }

    // Maximum Continuous Product SubArray
    public static int maxProduct(Integer[] A) {
        System.out.println("\nStart function maxProduct()");
        int len = A.length;
        int maxP = A[0];
        int max = 1, min = 1;

        for (int i = 1; i < len; i++) {
            if (A[i] == 0) {
                max = 1;
                min = 1;
                maxP = Math.max(maxP, 0);
            } else if (A[i] > 0) {
                max *= A[i];
                min = Math.min(1, min * A[i]);
                maxP = Math.max(max, maxP);
            } else {
                // max * A[i] < 0
                int tmp = max;
                if (A[i] * min > 0) {
                    max = A[i] * min;
                    maxP = Math.max(max, maxP);
                } else {
                    // min * A[i] < 0
                    max = 1;
                }
                min = tmp * A[i];
            }
        }
        System.out.println("\ta: " + Arrays.asList(A));
        System.out.println("\tMaximum Continuous Product of a is: " + maxP);
        return maxP;
    }

    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     * Note:
     * The solution is guaranteed to be unique.
     * <p>
     * http://oj.leetcode.com/problems/gas-station/
     */
    public static int canCompleteCircuit(Integer[] gas, Integer[] cost) {
        System.out.println("\nStart function canCompleteCircuit()");
        int len1 = gas.length;
        int len2 = cost.length;
        if (len1 != len2 || len1 == 0)
            return -1;

        System.out.println("\tGAS:   " + Arrays.asList(gas));
        System.out.println("\tCOST:  " + Arrays.asList(cost));
        Integer[] route = new Integer[len1];
        Integer total = 0;
        Integer sum = 0;
        Integer start = 0;
        for (int i = 0, index = 0; i < len1; i++) {
            route[index++] = gas[i] - cost[i];
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        System.out.println("\tROUTE:  " + Arrays.asList(route));
        if (total < 0) {
            System.out.println("\tCannot complete!");
            return -1;
        } else {
            System.out.println("\tStart point = " + start);
            return start;
        }
    }

    // This solution works if the solution is NOT guaranteed to be unique
    public HashSet<Integer> canCompleteCircuitNonUnique(int[] gas, int[] cost) {
        HashSet<Integer> res = new HashSet<>();
        int lenG = gas.length;
        int lenC = cost.length;
        if (lenG != lenC) {
            return res;
        } else if (lenG == 0) {
            return res;
        }

        for (int start = 0; start < lenG; start++) {
            int sum = 0;
            int i = 0;
            for (; i < lenG; i++) {
                sum += gas[(int) ((i + start) % lenG)];
                sum -= cost[(int) ((i + start) % lenG)];
                if (sum < 0)
                    break;
            }
            if (i == lenG && sum >= 0) {
                res.add(start);
            }
        }
        return res;
    }

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid
     * How many possible unique paths are there?
     * <p>
     * https://leetcode.com/problems/unique-paths/
     * <p>
     * DP Problem
     */
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[][] paths = new int[2][n];
        paths[0][0] = 1;
        for (int i = 1; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            paths[i % 2][0] = 1;
            for (int j = 1; j < n; j++) {
                paths[i % 2][j] = paths[i % 2][j - 1] + paths[(i - 1) % 2][j];
            }
        }
        return paths[m - 1][n - 1];
    }

    /**
     * Follow up for "Unique Paths":
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     * The total number of unique paths is 2.
     * <p>
     * https://leetcode.com/problems/unique-paths-ii/
     * <p>
     * DP Problem
     *
     * @param obstacleGrid
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) return 0;
        int m = obstacleGrid.length;
        if (m <= 0) return 0;
        int n = obstacleGrid[0].length;
        if (n <= 0) return 0;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] paths = new int[2][n];
        paths[0][0] = 1;
        for (int j = 1; j < n; j++) {
            paths[0][j] = obstacleGrid[0][j] == 1 ? 0 : paths[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            paths[i][0] = obstacleGrid[i][0] == 1 ? 0 : paths[(i - 1) % 2][0];
            for (int j = 1; j < n; j++) {
                paths[i % 2][j] = obstacleGrid[i][j] == 1 ? 0 : (paths[i % 2][j - 1] + paths[(i - 1) % 2][j]);
            }
        }
        return paths[m - 1][n - 1];
    }

    public static void maxSubsquare(int M, int N) {
        System.out.println("Start function maxSubsquare()");
        int maxSize = 0;
        int top = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        Integer[][] arr = new Integer[M][N];
        Integer[][] row = new Integer[M][N];
        Integer[][] col = new Integer[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = (int) (Math.random() * 4) > 0 ? 1 : 0;
            }
        }
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    temp = 0;
                    row[i][j] = 0;
                } else {
                    row[i][j] = ++temp;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            int temp = 0;
            for (int i = 0; i < M; i++) {
                if (arr[i][j] == 0) {
                    temp = 0;
                    col[i][j] = 0;
                } else {
                    col[i][j] = ++temp;
                }
            }
        }
        System.out.println("Array:");
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.asList(arr[i]));
        System.out.println("Row:");
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.asList(row[i]));
        System.out.println("Col:");
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.asList(col[i]));

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    for (int k = Math.min(i, j); k + 1 > maxSize; k--) {
                        if ((arr[i - k][j] == 1) &&
                                (arr[i][j - k] == 1) &&
                                (arr[i - k][j - k] == 1) &&
                                ((row[i][j] - row[i][j - k]) == k) &&
                                ((row[i - k][j] - row[i - k][j - k]) == k) &&
                                ((col[i][j] - col[i - k][j]) == k) &&
                                ((col[i][j - k] - col[i - k][j - k]) == k)) {
                            maxSize = (k + 1) * (k + 1);
                            down = i;
                            right = j;
                            top = i - k;
                            left = j - k;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("maxSize   = " + maxSize);
        System.out.println("top   = " + top);
        System.out.println("down  = " + down);
        System.out.println("left  = " + left);
        System.out.println("right = " + right);
        for (int i = top; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void maxSubRectangle(int M, int N) {
        System.out.println("Start function maxSubRectangle()");
        int maxSize = 0;
        int top = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        Integer[][] arr = new Integer[M][N];
        Integer[][] row = new Integer[M][N];
        Integer[][] col = new Integer[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = (int) (Math.random() * 3) < 1 ? 0 : 1;
            }
        }
        for (int i = 0; i < M; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    temp = 0;
                    row[i][j] = 0;
                } else {
                    row[i][j] = ++temp;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            int temp = 0;
            for (int i = 0; i < M; i++) {
                if (arr[i][j] == 0) {
                    temp = 0;
                    col[i][j] = 0;
                } else {
                    col[i][j] = ++temp;
                }
            }
        }
        System.out.println("Array:");
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.asList(arr[i]));
        System.out.println("Row:");
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.asList(row[i]));
        System.out.println("Col:");
        for (int i = 0; i < M; i++)
            System.out.println(Arrays.asList(col[i]));

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (arr[i][j] == 1) {
                    int rLen;
                    int cLen;
                    for (rLen = i; rLen >= 0; rLen--) {
                        for (cLen = j; cLen >= 0; cLen--) {
                            if ((rLen + 1) * (cLen + 1) <= maxSize)
                                continue;

                            if (arr[i - rLen][j] == 1 &&
                                    arr[i][j - cLen] == 1 &&
                                    arr[i - rLen][j - cLen] == 1 &&
                                    (row[i][j] - row[i][j - cLen] == cLen) &&
                                    (row[i - rLen][j] - row[i - rLen][j - cLen] == cLen) &&
                                    (col[i][j] - col[i - rLen][j] == rLen) &&
                                    (col[i][j - cLen] - col[i - rLen][j - cLen] == rLen)) {
                                maxSize = (rLen + 1) * (cLen + 1);
                                down = i;
                                right = j;
                                top = i - rLen;
                                left = j - cLen;
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("maxSize   = " + maxSize);
        System.out.println("top   = " + top);
        System.out.println("down  = " + down);
        System.out.println("left  = " + left);
        System.out.println("right = " + right);
        for (int i = top; i <= down; i++) {
            for (int j = left; j <= right; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Given an array of currency units and a target amount,
     * find one way to make the changes with minimal number of coins
     * <p>
     * DP Problem
     *
     * https://leetcode.com/problems/coin-change/
     */
    public static Integer minNumberOfChanges(Integer[] units, Integer target) {
        System.out.println("\nStart function minNumberOfChanges()");
        assert units != null : "Input array is null";

        int len = units.length;
        Integer[][] TN = new Integer[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(TN[i], target + 1);
        }
        //Arrays.sort(units);
        for (int j = 0; j <= target; j++) {
            TN[0][j] = j % units[0] == 0 ? (j / units[0]) : (target + 1);
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (units[i] > j) {
                    TN[i][j] = TN[i - 1][j];
                } else {
                    Integer min = target + 1;
                    for (int a = 0; a <= j / units[i]; a++) {
                        min = Math.min(min, TN[i - 1][j - a * units[i]] + a);
                    }
                    TN[i][j] = min;
                }
            }
        }
        for (int i = 0; i < len; i++)
            System.out.println(Arrays.asList(TN[i]));

        printArray(units, "Target = " + target + "; Units: ");
        System.out.println("Minimal number of coins: " + TN[len - 1][target]);
        return TN[len - 1][target];
    }
    // A much better version
    public static Integer minNumberOfChanges2(Integer[] coins, Integer amount) {
        System.out.println("\nStart function minNumberOfChanges2()");
        int len = coins.length;
        if (len < 1) return 0;
        Integer[] DP = new Integer[amount + 1];
        Arrays.fill(DP, amount + 1);
        DP[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < len; j++) {
                if (coins[j] <= i) {
                    DP[i] = Math.min(DP[i], DP[i - coins[j]] + 1);
                }
            }
        }
        printArray(coins, "Target = " + amount + "; Units: ");
        System.out.println("Minimal number of coins: " + (DP[amount] > amount ? -1 : DP[amount]));
        return DP[amount] > amount ? -1 : DP[amount];
    }

    /**
     * Given an array of currency units and a target amount,
     * find the number of possible ways to make the changes
     * <p>
     * DP Problem
     */
    public static Integer totalNumberOfChanges(Integer[] units, Integer target) {
        System.out.println("\nStart function totalNumberOfChanges()");
        printArray(units, "\tUnits: ");
        System.out.println("\tTarget = " + target);
        assert units != null : "Input array is null";

        int len = units.length;
        Integer[][] TN = new Integer[len][target + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(TN[i], 0);
        }
        //Arrays.sort(units);
        for (int j = 0; j <= target; j++) {
            TN[0][j] = j % units[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (units[i] > j) {
                    TN[i][j] = TN[i - 1][j];
                } else {
                    for (int a = 0; a <= j / units[i]; a++) {
                        TN[i][j] += TN[i - 1][j - a * units[i]];
                    }
                }
            }
        }
//        for (int i = 0; i < len; i++)
//            System.out.println(Arrays.asList(TN[i]));
        System.out.println("\tNOC = " + TN[len - 1][target]);
        return TN[len - 1][target];
    }
    public static Integer totalNumberOfChanges2(Integer[] units, Integer target) {
        System.out.println("\nStart function totalNumberOfChanges2()");
        printArray(units, "\tUnits: ");
        System.out.println("\tTarget = " + target);
        assert units != null : "Input array is null";

        int len = units.length;
        Integer[][] TN = new Integer[2][target + 1];
        for (int j = 0; j <= target; j++) {
            TN[0][j] = j % units[0] == 0 ? 1 : 0;
        }
        Arrays.fill(TN[1], 0);

        for (int i = 1; i < len; i++) {
            Arrays.fill(TN[i % 2], 0);
            for (int j = 0; j <= target; j++) {
                if (units[i] > j) {
                    TN[i % 2][j] = TN[(i - 1) % 2][j];
                } else {
                    for (int a = 0; a <= j / units[i]; a++) {
                        TN[i % 2][j] += TN[(i - 1) % 2][j - a * units[i]];
                    }
                }
            }
//            System.out.println(Arrays.asList(TN[i%2]));
        }
        System.out.println("\tNOC = " + TN[(len - 1) % 2][target]);
        return TN[(len - 1) % 2][target];
    }
    // Using DFS, similar to "Combination Sum". The performance of this version is not as good as the previous two
    public static Integer totalNumberOfChanges3(Integer[] units, Integer target) {
        System.out.println("\nStart function totalNumberOfChanges3()");
        printArray(units, "\tUnits: ");
        System.out.println("\tTarget = " + target);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        DFS_totalNumberOfChanges3(units, target, new ArrayList<Integer>(), results, 0);
        System.out.println("\tNOC = " + results.size());
        return results.size();
    }
    private static void DFS_totalNumberOfChanges3(Integer[] units, Integer target, ArrayList<Integer> tmpList, ArrayList<ArrayList<Integer>> results, int index) {
        Integer sum = 0;
        for (Integer i : tmpList)
            sum += i;
        if (sum == target) {
            results.add((ArrayList<Integer>) tmpList.clone());
            return;
        }
        if (sum > target || index >= units.length)
            return;
        DFS_totalNumberOfChanges3(units, target, tmpList, results, index + 1);
        int count = (target - sum) / units[index];
        for (int i = 0; i < count; i++) {
            tmpList.add(units[index]);
            DFS_totalNumberOfChanges3(units, target, tmpList, results, index + 1);
        }
        for (int i = 0; i < count; i++) {
            tmpList.remove(tmpList.size() - 1);
        }
    }
    public static Integer totalNumberOfChanges4(Integer[] units, Integer target) {
        System.out.println("\nStart function totalNumberOfChanges4()");
        Arrays.sort(units);
        printArray(units, "\tUnits: ");
        System.out.println("\tTarget = " + target);
        int len = units.length;
        if (len < 1) return 0;
        Integer[] DP = new Integer[target + 1];
        Arrays.fill(DP, 0);
        DP[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < len; j++) {
//                if (units[j] <= i && units[j] % i == 0) {
//                    DP[i] += 1;
//                } else if (units[j] < i) {
//                    DP[i] += DP[i - units[j]];
//                }
                if (units[j] <= i) {
                    DP[i] += DP[i - units[j]];
                }
            }
        }
        printArray(DP, "\tDP:");
        return DP[target];
    }

    /**
     * There is a pyramid with 1 cup at level , 2 at level 2 , 3 at level 3 and so on..
     * It looks something like this
     * 1
     * 2   3
     * 4   5   6
     * 7   8   9   10
     * every cup has capacity C. you pour L liters of water from top . when cup 1 gets
     * filled , it overflows to cup 2,3 equally, and when they get filled , Cup 4 and 6 get
     * water only from 2 and 3 resp but 5 gets water from both the cups and so on.
     * Now given C and M .Find the amount of water in ith cup.
     * <p>
     * Solved it with O(k).
     * The idea is simple. Pour L into coup 1. Divide into its children if overflows.
     * Do this for subsequent elements, until find k.
     * <p>
     * The biggest problem is to find the children.
     * The first child of a coup is the same of last if height does not change.
     * The second one is first + 1.
     * <p>
     * For the given example, children would found in the the following order
     * (see how children repeats when height repeats (kth is one based!):
     * <p>
     * <p>
     * Height:  1     2     2     3     3     3
     * Coup  :  1     2     3     4     5     6
     * Child : 2 3 | 4 5 | 5 6 | 7 8 | 8 9 | 9 10
     * <p>
     * <p>
     * DP Problem
     */
    public static double calculateWaterVol(Double C, Double L, int kth) {
        System.out.println("\nStart function calculateWaterVol()");
        int[] height = new int[kth];
        Double[] water = new Double[kth];
        Arrays.fill(height, 0);
        Arrays.fill(water, 0.0);

        water[0] = L;
        int childIndex = 0;

        for (int i = 0; i < kth; i++) {
            Double over = 0.0;
            if (water[i] > C) {
                over = (water[i] - C) / 2.0;
                water[i] = C;
            }
            if ((i == 0) || (height[i - 1] < height[i])) { // This is an important step!
                ++childIndex;
            }
            if (childIndex >= kth)
                break;
            height[childIndex] = height[i] + 1;
            water[childIndex] += over;
            ++childIndex;
            if (childIndex >= kth)
                break;
            height[childIndex] = height[i] + 1;
            water[childIndex] += over;
        }
        return water[kth - 1] > C ? C : water[kth - 1];
    }

    public static void testMaxContinuousSubArray() {
        int N = 20;
        int M = 10;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = (int) (M * Math.random());
        }

        maxContinuousSubArray(a);
    }

    /**
     * Given an array of integers. Find the adjacent sub-array which:
     * 1. has the largest sum
     * 2. all the integers in the sub-array can form a continuous sequence
     * <p>
     * For instance, array: [3, 2, 6, 5, 7, 0, 1, 4]
     * There are 3 continuous sub-arrays: [3, 2], [6, 5, 7], [0, 1].
     * The largest sum would be 6+5+7 = 18
     * <p>
     * DP Problem
     *
     * @param a
     */
    public static void maxContinuousSubArray(Integer[] a) {
        System.out.println("\nStart function maxContinuousSubArray()");
        printArray(a, "Input array: ");

        Integer len = a.length;
        Integer[][] maxVal = new Integer[len][len];
        Integer[][] minVal = new Integer[len][len];
        Boolean[][] duplicated = new Boolean[len][len];
        HashSet<Integer> set = new HashSet<>();
        Integer maxLen = Integer.MIN_VALUE;
        Integer begin = 0;
        Integer end = 0;

        for (int i = 0; i < len; i++) {
            maxVal[i][i] = a[i];
            minVal[i][i] = a[i];
            Arrays.fill(duplicated[i], false);
        }
        for (int i = 0; i < len; i++) {
            set.clear();
            set.add(a[i]);
            for (int j = i + 1; j < len; j++) {
                maxVal[i][j] = Math.max(maxVal[i][j - 1], a[j]);
                minVal[i][j] = Math.min(minVal[i][j - 1], a[j]);

                if (set.contains(a[j])) {
                    duplicated[i][j] = true;
                } else {
                    duplicated[i][j] = duplicated[i][j - 1];
                    set.add(a[j]);
                }
            }
        }
        printTwoDimentinalArray(minVal, "MinVal array: ");
        printTwoDimentinalArray(maxVal, "MaxVal array: ");
        printTwoDimentinalArray(duplicated, "duplicated array: ");
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (maxVal[i][j] - minVal[i][j] == j - i &&
                        !duplicated[i][j] &&
                        j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                    end = j;
                }
            }
        }
        Integer[] res = Arrays.copyOfRange(a, begin, end + 1);
        printArray(a, "Input array: ");
        System.out.println("\tbegin = " + begin + "; a[begin] = " + a[begin]);
        System.out.println("\tend = " + end + "; a[end] = " + a[end]);
        System.out.println("\t" + Arrays.asList(res));
    }

    /**
     * Given n books of:
     * widths:  w1, w2, w3, …, wn
     * heights: h1, h2, h3, …, hn
     * The book shelf's width is W.
     * Each shelf layer's height is determined by the highest book on this layer.
     * Find the minimal height of the book shelf after putting all the books on the shelf.
     * <p>
     * DP Problem
     */
    public static Integer minBookShelfCost(Integer[] width, Integer[] height, Integer W) {
        System.out.println("\nStart function minBookShelfCost()");

        printArray(width, "Input Width:");
        printArray(height, "Input Height:");
        System.out.println("Input W = " + W);

        assert width != null && height != null && W > 0;
        int len = width.length;
        assert len == height.length;

        Integer[][] widths = new Integer[len][len];
        Integer[][] heights = new Integer[len][len];
        Integer[] cost = new Integer[len + 1];

        for (int i = 0; i < len; i++) {
            Arrays.fill(widths[i], Integer.MAX_VALUE);
            Arrays.fill(heights[i], Integer.MAX_VALUE);
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            Integer sum = 0;
            for (int j = i; j < len; j++) {
                if (width[j] > W)
                    return Integer.MAX_VALUE;
                sum += width[j];
                if (sum <= W)
                    widths[i][j] = sum;
                else
                    break;
            }
        }
        for (int i = 0; i < len; i++) {
            Integer maxHeight = Integer.MIN_VALUE;
            for (int j = i; j < len; j++) {
                if (widths[i][j] <= W) {
                    maxHeight = Math.max(maxHeight, height[j]);
                    heights[i][j] = maxHeight;
                } else
                    break;
            }
        }
        printTwoDimentinalArray(widths, "WIDTHS:");
        printTwoDimentinalArray(heights, "HEIGHTS:");

        cost[0] = 0;
        for (int j = 1; j <= len; j++) {
            Integer min = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++) {
                if (heights[i - 1][j - 1] != Integer.MAX_VALUE) {
                    min = Math.min(min, cost[i - 1] + heights[i - 1][j - 1]);
                }
            }
            cost[j] = min;
        }
        printArray(cost, "COST:");
        System.out.println("The minimal cost is: " + cost[len]);
        return cost[len];
    }

    /**
     * Given n words of lengths:  l1, l2, l3, l4, ..., ln
     * The line's length is M
     * If a line contains words i to j (i <= j), the number of extra spaces
     * left at the end of this line is:
     * M - (j - i) + sum(lk) [i <= k <= j]
     * Cost of each line is the cubes of the extra spaces.
     * The last line has no cost.
     * How to minimize the total cost of all the lines when all the words are printed
     * <p>
     * DP Problem
     */
    public static Integer textJustification(Integer[] length, Integer M, Integer[] start) {
        System.out.println("\nStart function textJustification()");
        printArray(length, "Input Length:");
        System.out.println("Input M = " + M);

        assert length != null && M > 0;
        int len = length.length;
        assert len > 0 || start.length == len;

        Integer[][] extras = new Integer[len][len];
        Integer[][] lc = new Integer[len][len];
        Integer[] cost = new Integer[len + 1];

        for (int i = 0; i < len; i++) {
            Arrays.fill(extras[i], Integer.MIN_VALUE);
            Arrays.fill(lc[i], Integer.MAX_VALUE);
        }
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            Integer remaining = M;
            for (int j = i; j < len; j++) {
                if (length[j] > M)
                    return Integer.MAX_VALUE;
                remaining -= length[j];
                if ((remaining - (j - i)) >= 0)
                    extras[i][j] = (remaining - (j - i));
                else
                    break;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (j == len - 1 && extras[i][j] >= 0)
                    lc[i][j] = 0;
                else if (extras[i][j] >= 0)
                    lc[i][j] = (int) Math.pow(extras[i][j], 3);
                else
                    break;
            }
        }
        System.out.println("EXTRAS:");
        for (int i = 0; i < len; i++) {
            System.out.print(String.format("\t%3d: ", i));
            for (int j = 0; j < len; j++) {
                System.out.print(extras[i][j] < 0 ? "----, " : String.format("%4d, ", extras[i][j]));
            }
            System.out.println();
        }
        System.out.println("LINECOSTS:");
        for (int i = 0; i < len; i++) {
            System.out.print(String.format("\t%3d: ", i));
            for (int j = 0; j < len; j++) {
                System.out.print(lc[i][j] == Integer.MAX_VALUE ? "++++, " : String.format("%4d, ", lc[i][j]));
            }
            System.out.println();
        }

        cost[0] = 0;
        for (int j = 1; j <= len; j++) {
            Integer min = Integer.MAX_VALUE;
            Integer startIndex = -1;
            for (int i = 1; i <= j; i++) {
                if (lc[i - 1][j - 1] != Integer.MAX_VALUE) {
                    if (min > cost[i - 1] + lc[i - 1][j - 1]) {
                        min = cost[i - 1] + lc[i - 1][j - 1];
                        startIndex = i - 1;
                    }
                }
            }
            cost[j] = min;
            start[j - 1] = startIndex;
        }
        printArray(start, "START");
        printArray(cost, "COST:");
        System.out.println("The minimal cost is: " + cost[len]);
        return cost[len];
    }

    /**
     * Knapsack Problem
     * <p>
     * Given n objects, each with a value & a weight.
     * Given a knapsack of capacity W weight units.
     * Goal: fill the knapsack to maximize it total value.
     * <p>
     * DP Problem
     */
    public static List<Integer> knapsack(Integer[] value, Integer[] weight, Integer W) {
        System.out.println("\nStart function knapsack()");
        assert value != null && weight != null && W > 0;

        printArray(value, "Input Value:");
        printArray(weight, "Input Weight:");
        System.out.println("Input W = " + W);

        int len = value.length;
        assert len == weight.length;

        Integer[][] DP = new Integer[len + 1][W + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(DP[i], 0);
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i - 1] > j) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], value[i - 1] + DP[i - 1][j - weight[i - 1]]);
                }
            }
        }

        printTwoDimentinalArray(DP, "DP array in knapsack:");

        LinkedList<Integer> result = new LinkedList<>();
        for (int i = len, j = W; i >= 1; i--) {
            if (DP[i][j] > DP[i - 1][j]) {
                result.addFirst(i - 1);
                j -= weight[i - 1];
            }
        }

        int totalVal = 0;
        System.out.print("\tValues: ");
        for (int i : result) {
            System.out.print(value[i] + " ");
            totalVal += value[i];
        }
        System.out.println("\tTotal value = " + totalVal);
        int totalWei = 0;
        System.out.print("\tWeights: ");
        for (int i : result) {
            System.out.print(weight[i] + " ");
            totalWei += weight[i];
        }
        System.out.println("\tTotal weight = " + totalWei);

        return result;
    }

    public static List<Integer> knapsackWithRepetition(Integer[] value, Integer[] weight, Integer W) {
        System.out.println("\nStart function knapsackWithRepetition()");
        assert value != null && weight != null && W > 0;

        printArray(value, "Input Value:");
        printArray(weight, "Input Weight:");
        System.out.println("Input W = " + W);

        int len = value.length;
        assert len == weight.length;

        Integer[][] DP = new Integer[len + 1][W + 1];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(DP[i], 0);
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i - 1] > j) {
                    DP[i][j] = DP[i - 1][j];
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], value[i - 1] + DP[i][j - weight[i - 1]]);
                }
            }
        }

        printTwoDimentinalArray(DP, "DP array in knapsackWithRepetition:");

        LinkedList<Integer> result = new LinkedList<>();
        for (int i = len, j = W; i >= 1; i--) {
            if (DP[i][j] > DP[i - 1][j]) {
                result.addFirst(i - 1);
                j -= weight[i - 1];
                i++;
            }
        }

        int totalVal = 0;
        System.out.print("\tValues: ");
        for (int i : result) {
            System.out.print(value[i] + " ");
            totalVal += value[i];
        }
        System.out.println("\tTotal value = " + totalVal);
        int totalWei = 0;
        System.out.print("\tWeights: ");
        for (int i : result) {
            System.out.print(weight[i] + " ");
            totalWei += weight[i];
        }
        System.out.println("\tTotal weight = " + totalWei);

        return result;
    }

    /**
     * Given an array, partition it into two sub-arrays, while the difference between sums of these two sub-arrays is minimal.
     * <p>
     * DP Problem
     */
    public static List<Integer> balancedPatition(Integer[] num) {
        System.out.println("\nStart function balancedPatition()");
        Integer sum = 0;
        for (Integer i : num)
            sum += i;
        Integer half = sum / 2;
        int len = num.length;

        Integer[][] DP = new Integer[len + 1][half + 1];
        for (int i = 0; i <= len; i++)
            Arrays.fill(DP[i], 0);

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= half; j++) {
                if (num[i - 1] > j)
                    DP[i][j] = DP[i - 1][j];
                else
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - num[i - 1]] + num[i - 1]);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i = len, col = half; i > 0; i--) {
            if (DP[i][col] != DP[i - 1][col]) {
                res.addFirst(num[i - 1]);
                col -= num[i - 1];
            }
        }

        printTwoDimentinalArray(DP, "DP array:");
        System.out.println("num: " + Arrays.asList(num));
        System.out.println("\tSUM: " + sum);
        System.out.println("\tThe balanced partition is of sum: " + DP[len][half]);
        System.out.println("\tThe balanced partition list: " + res);
        return res;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     * (ie, buy one and sell one share of the stock multiple times).
     * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     *
     * @param prices
     * @return
     */
    public static int maxProfitII(Integer[] prices) {
        System.out.println("\nStart function maxProfitII()");
        printArray(prices, "\tPrices:");
        int maxP = 0;
        int len = prices.length;
        if (len < 2) return 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxP += prices[i] - prices[i - 1];
            }
        }
        System.out.println("\tRes: " + maxP);
        return maxP;
    }

    /**
     * Best Time To Buy And Sell Stock with Fee
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * For each of the transaction, there is a fee.
     * Figure out the maximum profit.
     */
    public static int maxProfitVI(Integer[] prices, int fee) {
        System.out.println("\nStart function maxProfitII2()");
        printArray(prices, "\tPrices:");
        System.out.println("\tFee: " + fee);
        int len = prices.length;
        if (len < 2) return 0;
        int[] DP = new int[len];

        for (int i = 1; i < len; i++) {
            DP[i] = DP[i-1];
            for (int j = 0; j < i; j++) {
                if (prices[i] > prices[j]) {
                    DP[i] = Math.max(DP[i], DP[j] + prices[i] - prices[j] - fee);
                }
            }
        }
        printArray(DP, "\tDP:");
        return DP[len-1];
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public static int maxProfitIII(Integer[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int maxP = 0;
        Integer[] leftP = new Integer[len];
        leftP[0] = 0;
        int minIndex = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[minIndex])
                minIndex = i;
            leftP[i] = Math.max(maxP, prices[i] - prices[minIndex]);
        }
        Integer[] rightP = new Integer[len];
        rightP[len - 1] = 0;
        int maxIndex = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (prices[i] > prices[maxIndex])
                maxIndex++;
            rightP[i] = Math.max(maxP, prices[maxIndex] - prices[i]);
        }
        for (int i = 0; i < len; i++) {
            maxP = Math.max(leftP[i] + rightP[i], maxP);
        }
        return maxP;
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete at most k transactions.
     * Note:
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     */
    public static int maxProfitIV(int k, Integer[] prices) {
        System.out.println("\nStart function maxProfitIV()");
        printArray(prices, "Prices: ");
        System.out.println("\tk = " + k);
        int len = prices.length;
        if (len <= 1) return 0;
        if (k >= len - 1) return maxProfitII(prices);

        Integer[][] DP = new Integer[k + 1][len];
        for (int i = 0; i <= k; i++)
            Arrays.fill(DP[i], 0);

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < len; j++) {
                int maxWithJ = 0;
                for (int t = 0; t < j; t++) {
                    if (prices[j] > prices[t]) {
                        maxWithJ = Math.max(maxWithJ, DP[i - 1][t] + prices[j] - prices[t]);
                    }
                }
                DP[i][j] = Math.max(maxWithJ, DP[i][j - 1]);
            }
        }

        printTwoDimentinalArray(DP, "DP array: ");
        System.out.println("\tmax profit = " + DP[k][len - 1]);
        return DP[k][len - 1];
    }

    public static int maxProfitIV2(int k, Integer[] prices) {
        System.out.println("\nStart function maxProfitIV2()");
        printArray(prices, "\tPrices: ");
        System.out.println("\tk = " + k);
        int len = prices.length;
        if (len <= 1) return 0;
        if (k >= len - 1) return maxProfitII(prices);

        Integer[][] DP = new Integer[2][len];
        for (int i = 0; i < 2; i++)
            Arrays.fill(DP[i], 0);

        System.out.println("\tDP array: ");
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < len; j++) {
                int maxWithJ = 0;
                for (int t = 0; t < j; t++) {
                    if (prices[j] > prices[t]) {
                        maxWithJ = Math.max(maxWithJ, DP[(i - 1) % 2][t] + prices[j] - prices[t]);
                    }
                }
                DP[i % 2][j] = Math.max(maxWithJ, DP[i % 2][j - 1]);
            }
            printArray(DP[i % 2]);
        }

        System.out.println("\tmax profit = " + DP[k % 2][len - 1]);
        return DP[k % 2][len - 1];
    }

    public static int maxProfitIV3(int k, Integer[] prices) {
        System.out.println("\nStart function maxProfitIV3()");
        printArray(prices, "\tPrices: ");
        System.out.println("\tk = " + k);
        int len = prices.length;
        if (len <= 1) return 0;
        if (k >= len - 1) return maxProfitII(prices);

        Integer[][] local = new Integer[k + 1][len];
        Integer[][] global = new Integer[k + 1][len];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(local[i], 0);
            Arrays.fill(global[i], 0);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < len; j++) {
                int diff = prices[j] - prices[j - 1];
                local[i][j] = Math.max(global[i - 1][j - 1] + diff, local[i][j - 1] + diff);
                global[i][j] = Math.max(global[i][j - 1], local[i][j]);
            }
        }

        System.out.println("\tmax profit = " + global[k][len - 1]);
        return global[k][len - 1];
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     * <p>
     * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * Example:
     * <p>
     * prices = [1, 2, 3, 0, 2]
     * maxProfit = 3
     * transactions = [buy, sell, cooldown, buy, sell]
     *
     * DP Problem
     */
    // 引入辅助数组sells和buys
    //      sells[i]表示在第i天不持有股票所能获得的最大累计收益
    //      buys[i]表示在第i天持有股票所能获得的最大累计收益//
    // 初始化数组：
    //      sells[0] = 0
    //      sells[1] = max(0, prices[1] - prices[0])
    //      buys[0] = -prices[0]
    //      buys[1] = max(-prices[0], -prices[1])
    // 状态转移方程
    //      sells[i] = max(sells[i - 1], buys[i - 1] + prices[i])
    //      buys[i] = max(buys[i - 1], sells[i - 2] - prices[i])
    // 所求最大收益为sells[-1]
    public static int maxProfitV(Integer[] prices) {
        System.out.println("\nStart function maxProfitV()");
        printArray(prices, "\tPrices: ");
        int len = prices.length;
        if (len <= 1) return 0;

        int[] buys = new int[len];
        int[] sells = new int[len];

        buys[0] = -prices[0];
        sells[0] = 0;
        buys[1] = Math.max(-prices[1], -prices[0]);
        sells[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < len; i++) {
            buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i]);
            sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i]);
        }
        System.out.println("\tmaxProfit = " + sells[len - 1]);
        return sells[len - 1];
    }

    public static int maxProfitV2(Integer[] prices) {
        System.out.println("\nStart function maxProfitV2()");
        printArray(prices, "\tPrices: ");
        Integer buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
        for (int price : prices) {
            pre_buy = buy;
            buy = Math.max(pre_sell - price, pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy + price, pre_sell);
        }
        System.out.println("\tmaxProfit = " + sell);
        return sell;
    }

    /**
     * Dungeon Game
     *
     * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon.
     * The dungeon consists of M x N rooms laid out in a 2D grid.
     * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
     * <p>
     * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately
     * <p>
     * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
     * <p>
     * * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
     * <p>
     * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
     * <p>
     * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
     * <p>
     * -2 (K)	-3	    3
     * -5	    -10	    1
     * 10	    30	    -5 (P)
     * <p>
     * Notes:
     * <p>
     * The knight's health has no upper bound.
     * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
     *
     * DP Problem
     */
    public static int calculateMinimumHP(Integer[][] dungeon) {
        System.out.println("\nStart function calculateMinimumHP()");
        printTwoDimentinalArray(dungeon, "\tMatrix: ");
        if (dungeon == null) return -1;
        int R = dungeon.length;
        if (R <= 0) return -1;
        int C = dungeon[0].length;
        if (C <= 0) return -1;

        Integer[][] DP = new Integer[R][C];
        DP[R - 1][C - 1] = dungeon[R - 1][C - 1] <= 0 ? (1 - dungeon[R - 1][C - 1]) : 1;
        for (int j = C - 2; j >= 0; j--) {
            DP[R - 1][j] = Math.max(1, DP[R - 1][j + 1] - dungeon[R - 1][j]);
        }
        for (int i = R - 2; i >= 0; i--) {
            DP[i][C - 1] = Math.max(1, DP[i + 1][C - 1] - dungeon[i][C - 1]);
            for (int j = C - 2; j >= 0; j--) {
                DP[i][j] = Math.max(1, Math.min(DP[i][j + 1], DP[i + 1][j]) - dungeon[i][j]);
            }
        }
        printTwoDimentinalArray(DP, "\tDP array:");
        return DP[0][0];
    }

    private static class Status {
        public Status(int r, int n) {
            remaining = r;
            needed = n;
        }

        int remaining;
        int needed;

        @Override
        public String toString() {
            return "(R:" + remaining + ";N:" + needed + ")";
        }
    }

    private static class Cell {
        public Cell(Status t, Status l) {
            fromTop = t;
            fromLeft = l;
        }

        Status fromTop;
        Status fromLeft;

        @Override
        public String toString() {
            return "(F.T:" + fromTop + "; F.L:" + fromLeft + ")";
        }
    }

    // Not working
    public static int calculateMinimumHP2(Integer[][] dungeon) {
        System.out.println("\nStart function calculateMinimumHP()");
        printTwoDimentinalArray(dungeon, "\tMatrix: ");
        if (dungeon == null) return -1;
        int R = dungeon.length;
        if (R <= 0) return -1;
        int C = dungeon[0].length;
        if (C <= 0) return -1;

        Cell[][] roll = new Cell[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                roll[i][j] = new Cell(new Status(0, 0), new Status(0, 0));
            }
        }
        if (dungeon[0][0] >= 0) {
            roll[0][0] = new Cell(new Status(dungeon[0][0], 0), new Status(dungeon[0][0], 0));
        } else {
            roll[0][0] = new Cell(new Status(0, -dungeon[0][0]), new Status(0, -dungeon[0][0]));
        }

        for (int j = 1; j < C; j++) {
            int newBalance = dungeon[0][j] + roll[0][j - 1].fromLeft.remaining;
            if (newBalance >= 0) {
                roll[0][j] = new Cell(new Status(newBalance, roll[0][j - 1].fromLeft.needed), new Status(newBalance, roll[0][j - 1].fromLeft.needed));
            } else {
                roll[0][j] = new Cell(new Status(0, -newBalance + roll[0][j - 1].fromLeft.needed), new Status(0, -newBalance + roll[0][j - 1].fromLeft.needed));
            }
        }
        for (int i = 1; i < R; i++) {
            int newBalance = dungeon[i][0] + roll[i - 1][0].fromTop.remaining;
            if (newBalance >= 0) {
                roll[i][0] = new Cell(new Status(newBalance, roll[i - 1][0].fromTop.needed), new Status(newBalance, roll[i - 1][0].fromTop.needed));
            } else {
                roll[i][0] = new Cell(new Status(0, -newBalance + roll[i - 1][0].fromTop.needed), new Status(0, -newBalance + roll[i - 1][0].fromTop.needed));
            }

            for (int j = 1; j < C; j++) {
                // From Top
                int newBalanceTopTop = dungeon[i][j] + roll[i - 1][j].fromTop.remaining;
                int newNeededFromTopTop = roll[i - 1][j].fromTop.needed + (newBalanceTopTop >= 0 ? 0 : -newBalanceTopTop);
                int newBalanceFromTopTop = newBalanceTopTop >= 0 ? newBalanceTopTop : 0;

                int newBalanceTopLeft = dungeon[i][j] + roll[i - 1][j].fromLeft.remaining;
                int newNeededFromTopLeft = roll[i - 1][j].fromLeft.needed + (newBalanceTopLeft >= 0 ? 0 : -newBalanceTopLeft);
                int newBalanceFromTopLeft = newBalanceTopLeft >= 0 ? newBalanceTopLeft : 0;

                if (newNeededFromTopTop > newNeededFromTopLeft) {
                    roll[i][j].fromTop = new Status(newBalanceFromTopLeft, newNeededFromTopLeft);
                } else if (newNeededFromTopTop < newNeededFromTopLeft) {
                    roll[i][j].fromTop = new Status(newBalanceFromTopTop, newNeededFromTopTop);
                } else {
                    roll[i][j].fromTop = new Status(Math.max(newBalanceFromTopTop, newBalanceFromTopLeft), newNeededFromTopTop);
                }
                // From Left
                int newBalanceLeftTop = dungeon[i][j] + roll[i][j - 1].fromTop.remaining;
                int newNeededFromLeftTop = roll[i][j - 1].fromTop.needed + (newBalanceLeftTop >= 0 ? 0 : -newBalanceLeftTop);
                int newBalanceFromLeftTop = newBalanceLeftTop >= 0 ? newBalanceLeftTop : 0;

                int newBalanceLeftLeft = dungeon[i][j] + roll[i][j - 1].fromLeft.remaining;
                int newNeededFromLeftLeft = roll[i][j - 1].fromLeft.needed + (newBalanceLeftLeft >= 0 ? 0 : -newBalanceLeftLeft);
                int newBalanceFromLeftLeft = newBalanceLeftLeft >= 0 ? newBalanceLeftLeft : 0;

                if (newNeededFromLeftTop > newNeededFromLeftLeft) {
                    roll[i][j].fromLeft = new Status(newBalanceFromLeftLeft, newNeededFromLeftLeft);
                } else if (newNeededFromLeftTop < newNeededFromLeftLeft) {
                    roll[i][j].fromLeft = new Status(newBalanceFromLeftTop, newNeededFromLeftTop);
                } else {
                    roll[i][j].fromLeft = new Status(Math.max(newBalanceFromLeftTop, newBalanceFromLeftLeft), newNeededFromLeftTop);
                }
            }
        }
        printTwoDimentinalArray(roll, "\tDP Array:");
        return Math.min(roll[R - 1][C - 1].fromLeft.needed, roll[R - 1][C - 1].fromTop.needed) + 1;
    }

    // Not working
    public static int calculateMinimumHP3(Integer[][] dungeon) {
        System.out.println("\nStart function maxProfitIV3()");
        printTwoDimentinalArray(dungeon, "\tMatrix: ");
        if (dungeon == null) return -1;
        int R = dungeon.length;
        if (R <= 0) return -1;
        int C = dungeon[0].length;
        if (C <= 0) return -1;

        Status[][] roll = new Status[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(roll[i], new Status(0, 0));
        }
        if (dungeon[0][0] >= 0) {
            roll[0][0] = new Status(dungeon[0][0], 0);
        } else {
            roll[0][0] = new Status(0, -dungeon[0][0]);
        }
        for (int j = 1; j < C; j++) {
            int newBalance = dungeon[0][j] + roll[0][j - 1].remaining;
            if (newBalance >= 0) {
                roll[0][j] = new Status(newBalance, roll[0][j - 1].needed);
            } else {
                roll[0][j] = new Status(0, -newBalance + roll[0][j - 1].needed);
            }
        }
        for (int i = 1; i < R; i++) {
            int newBalance = dungeon[i][0] + roll[i - 1][0].remaining;
            if (newBalance >= 0) {
                roll[i][0] = new Status(newBalance, roll[i - 1][0].needed);
            } else {
                roll[i][0] = new Status(0, -newBalance + roll[i - 1][0].needed);
            }

            for (int j = 1; j < C; j++) {
                int newBalanceFromTop = dungeon[i][j] + roll[i - 1][j].remaining;
                int newBalanceFromLeft = dungeon[i][j] + roll[i][j - 1].remaining;

                int newNeededFromTop = roll[i - 1][j].needed + (newBalanceFromTop >= 0 ? 0 : (-newBalanceFromTop));
                int newNeededFromLeft = roll[i][j - 1].needed + (newBalanceFromLeft >= 0 ? 0 : (-newBalanceFromLeft));

                if (newNeededFromTop > newNeededFromLeft) {
                    roll[i][j] = new Status(newBalanceFromLeft >= 0 ? newBalanceFromLeft : 0, newNeededFromLeft);
                } else {
                    roll[i][j] = new Status(newBalanceFromTop >= 0 ? newBalanceFromTop : 0, newNeededFromTop);
                }
            }
        }
        printTwoDimentinalArray(roll, "\tDP Array:");
        return roll[R - 1][C - 1].needed + 1;
    }

    // Not working
    public static int calculateMinimumHP4(Integer[][] dungeon) {
        System.out.println("\nStart function maxProfitIV3()");
        printTwoDimentinalArray(dungeon, "\tMatrix: ");
        if (dungeon == null) return -1;
        int R = dungeon.length;
        if (R <= 0) return -1;
        int C = dungeon[0].length;
        if (C <= 0) return -1;

        Status[][] roll = new Status[2][C];
        Arrays.fill(roll[0], new Status(0, 0));
        Arrays.fill(roll[1], new Status(0, 0));
        if (dungeon[0][0] >= 0) {
            roll[0][0] = new Status(dungeon[0][0], 0);
        } else {
            roll[0][0] = new Status(0, -dungeon[0][0]);
        }
        for (int j = 1; j < C; j++) {
            int newBalance = dungeon[0][j] + roll[0][j - 1].remaining;
            if (newBalance >= 0) {
                roll[0][j] = new Status(newBalance, roll[0][j - 1].needed);
            } else {
                roll[0][j] = new Status(0, -newBalance + roll[0][j - 1].needed);
            }
        }
        for (int i = 1; i < R; i++) {
            int newBalance = dungeon[i][0] + roll[(i - 1) % 2][0].remaining;
            if (newBalance >= 0) {
                roll[i % 2][0] = new Status(newBalance, roll[(i - 1) % 2][0].needed);
            } else {
                roll[i % 2][0] = new Status(0, -newBalance + roll[(i - 1) % 2][0].needed);
            }

            for (int j = 1; j < C; j++) {
                int newBalanceFromTop = dungeon[i][j] + roll[(i - 1) % 2][j].remaining;
                int newBalanceFromLeft = dungeon[i][j] + roll[i % 2][j - 1].remaining;

                int newNeededFromTop = roll[(i - 1) % 2][j].needed + newBalanceFromTop >= 0 ? 0 : (-newBalanceFromTop);
                int newNeededFromLeft = roll[i % 2][j - 1].needed + newBalanceFromLeft >= 0 ? 0 : (-newBalanceFromLeft);

                if (newNeededFromTop > newNeededFromLeft) {
                    roll[i % 2][j] = new Status(newBalanceFromLeft >= 0 ? newBalanceFromLeft : 0, newNeededFromLeft);
                } else {
                    roll[i % 2][j] = new Status(newBalanceFromTop >= 0 ? newBalanceFromTop : 0, newNeededFromTop);
                }
            }
        }
        System.out.println("\tResult = " + (roll[(R - 1) % 2][C - 1].needed + 1));
        return roll[(R - 1) % 2][C - 1].needed + 1;
    }

    /**
     * Guess Number Higher or Lower II Question
     *
     * We are playing the Guess Game. The game is as follows:
     *
     * I pick a number from 1 to n. You have to guess which number I picked.
     *
     * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
     *
     * However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
     *
     *         Example:
     *
     * n = 10, I pick 8.
     *
     * First round:  You guess 5, I tell you that it's higher. You pay $5.
     * Second round: You guess 7, I tell you that it's higher. You pay $7.
     * Third round:  You guess 9, I tell you that it's lower. You pay $9.
     *
     * Game over. 8 is the number I picked.
     *
     * You end up paying $5 + $7 + $9 = $21.
     * Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
     *
     * Hint:
     *
     * The best strategy to play the game is to minimize the maximum loss you could possibly face.
     * Another strategy is to minimize the expected loss.
     * Here, we are interested in the first scenario.
     *
     * Take a small example (n = 3). What do you end up paying in the worst case?
     * Check out this article if you're still stuck.
     * The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
     * As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
     *
     * DP Problem
     *
     * 此题是之前那道Guess Number Higher or Lower的拓展，难度增加了不少。
     * 根据题目中的提示，这道题需要用到Minimax极小化极大算法，关于这个算法可以参见这篇讲解。
     * 并且题目中还说明了要用DP来做，那么我们需要建立一个二维的dp数组，其中dp[i][j]表示从数字i到j之间猜中任意一个数字最少需要花费的钱数。
     * 那么我们需要遍历每一段区间[j, i]，维护一个全局最小值global_min变量，然后遍历该区间中的每一个数字，计算局部最大值local_max = k + max(dp[j][k - 1], dp[k + 1][i])，这个正好是将该区间在每一个位置都分为两段，然后取当前位置的花费加上左右两段中较大的花费之和为局部最大值，然后更新全局最小值，最后在更新dp[j][i]的时候看j和i是否是相邻的，相邻的话赋为i，否则赋为global_min，参见代码如下：
     */
    public static int getMoneyAmount(int n) {
        System.out.println("\nStart function getMoneyAmount()");
        Integer[][] DP = new Integer[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(DP[i], 0);
        }
        for (int j = 2; j <= n; j++) {
            for (int i = j-1; i > 0; i--) {
                Integer gMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int lMax = k + Math.max(DP[i][k-1], DP[k+1][j]);
                    gMin = Math.min(gMin, lMax);
                }
                DP[i][j] = i + 1 == j ? i : gMin;
            }
        }
        printTwoDimentinalArray(DP, "\tDP array: ");
        return DP[1][n];
    }

    /**
     * Largest Divisible Subset
     *
     * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
     *
     * If there are multiple solutions, return any subset is fine.
     *
     * Example 1:
     *
     * nums: [1,2,3]
     *
     * Result: [1,2] (of course, [1,3] will also be ok)
     * Example 2:
     *
     * nums: [1,2,4,8]
     *
     * Result: [1,2,4,8]
     * Credits:
     *
     * DP Problem
     */
    public static List<Integer> largestDivisibleSubset(Integer[] nums) {
        System.out.println("\nStart function largestDivisibleSubset()");
        printArray(nums, "\tNums:");
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        Integer[] DP = new Integer[len];
        Integer[] parent = new Integer[len];
        Arrays.fill(DP, 0);
        Arrays.fill(parent, -1);
        int max = 0, maxStartIndex = -1;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (nums[j] % nums[i] == 0 && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                    parent[i] = j;
                    if (max < DP[i]) {
                        max = DP[i];
                        maxStartIndex = i;
                    }
                }
            }
        }
        for (int i = 0; i < max; i++) {
            res.add(nums[maxStartIndex]);
            maxStartIndex = parent[maxStartIndex];
        }
        System.out.println("\tResult: " + res);
        return res;
    }
    public static List<Integer> largestDivisibleSubset2(Integer[] nums) {
        System.out.println("\nStart function largestDivisibleSubset2()");
        printArray(nums, "\tNums:");
        LinkedList<Integer> res = new LinkedList<>();
        int len = nums.length;
        Arrays.sort(nums);

        Integer[] DP = new Integer[len];
        Integer[] child = new Integer[len];
        Arrays.fill(DP, 0);
        Arrays.fill(child, -1);
        int max = 0, maxEndIndex = -1;

        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (nums[j] % nums[i] == 0 && DP[j] < DP[i] + 1) {
                    DP[j] = DP[i] + 1;
                    child[j] = i;
                    if (max < DP[j]) {
                        max = DP[j];
                        maxEndIndex = j;
                    }
                }
            }
        }
        for (int i = 0; i < max; i++) {
            res.addFirst(nums[maxEndIndex]);
            maxEndIndex = child[maxEndIndex];
        }
        System.out.println("\tResult: " + res);
        return res;
    }

    /**
     * The Skyline Problem
     * <p>
     * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
     * <p>
     * Buildings Skyline Contour
     * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
     * <p>
     * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
     * <p>
     * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
     * <p>
     * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
     * <p>
     * Notes:
     * <p>
     * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
     * The input list is already sorted in ascending order by the left x position Li.
     * The output list must be sorted by the x position.
     * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
     * <p>
     * https://leetcode.com/problems/the-skyline-problem/
     *
     * DP Problem
     */
    private static class Block {
        int start;
        int end;
        int height;

        public Block(int s, int e, int h) {
            start = s;
            end = e;
            height = h;
        }
    }
    public static List<int[]> getSkyline(Integer[][] buildings) {
        System.out.println("\nStart function getSkyline()");
        printTwoDimentinalArray(buildings, "\tBuildings: ");

        List<int[]> res = new ArrayList<>();
        if (buildings.length < 1) return res;

        PriorityQueue<Integer> points = new PriorityQueue<>();
        PriorityQueue<Block> Q = new PriorityQueue<>(buildings.length, (Block b1, Block b2) -> -Integer.compare(b1.height, b2.height));
//        PriorityQueue<Block> Q = new PriorityQueue<>(buildings.length, (Block b1, Block b2) -> -Integer.compare(b1.height, b2.height));

        PriorityQueue<Block> blocks = new PriorityQueue<>(buildings.length, (a, b) -> a.start - b.start);
        for (int i = 0; i < buildings.length; i++) {
            blocks.add(new Block(buildings[i][0], buildings[i][1], buildings[i][2]));
            points.add(buildings[i][0]);
            points.add(buildings[i][1]);
        }
//        LinkedList<Block> blocks = new LinkedList<>();
//        for (int i = 0; i < buildings.length; i++) {
//            blocks.add(new Block(buildings[i][0], buildings[i][1], buildings[i][2]));
//            points.add(buildings[i][0]);
//            points.add(buildings[i][1]);
//        }
//        Collections.sort(blocks, (a,b) -> a.start - b.start);

        int curHeight = 0;

        while (!points.isEmpty()) {
            int index = points.remove();
            while (!Q.isEmpty() && index >= Q.peek().end) {
                Q.remove();
            }
            // At first, 'if' instead of 'while' is used, which would be wrong for
            // inputs: (1, 2, 1), (1, 2, 2), (1, 2, 3)
            //if (!blocks.isEmpty() && index == blocks.getFirst().start) {

            while (!blocks.isEmpty() && index >= blocks.peek().start) {
                Q.add(blocks.poll());
            }

//            while (!blocks.isEmpty() && index >= blocks.getFirst().start) {
//                Q.add(blocks.removeFirst());
//            }

            if (!Q.isEmpty() && curHeight != Q.peek().height) {
                res.add(new int[]{index, Q.peek().height});
                curHeight = Q.peek().height;
            } else if (Q.isEmpty() && curHeight != 0) {
                res.add(new int[]{index, 0});
                curHeight = 0;
            }
        }
        System.out.println("\tPoints");
        for (int[] point : res) {
            System.out.println("\t\t(" + point[0] + ", " + point[1] + ")");
        }
        return res;
    }

    /**
     * Burst Balloons
     * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
     * Find the maximum coins you can collect by bursting the balloons wisely.
     * Note: 
     *         (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
     *         (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     * Example:
     * Given [3, 1, 5, 8]
     * Return 167
     * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     *
     * DP Problem
     */
    // dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])      ( i ≤ k ≤ j )
    public static int maxCoins(Integer[] nums) {
        System.out.println("\nStart function maxCoins()");
        printArray(nums, "\tNums: ");

        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        Integer[] newNums = new Integer[len+2];
        newNums[0] = 1;
        newNums[len+1] = 1;
        for (int i = 0; i < len; i++) {
            newNums[i+1] = nums[i];
        }
        printArray(newNums, "\tNew nums: ");
        Integer[][] DP = new Integer[len+2][len+2];
        for (int i = 0; i < len+2; i++) {
            Arrays.fill(DP[i], 0);
        }
        Integer[][] DP2 = new Integer[len+2][len+2];
        for (int i = 0; i < len+2; i++) {
            Arrays.fill(DP2[i], 0);
            if (i > 0 && i < len-1) {
                DP2[i][i] = newNums[i - 1] * newNums[i] * newNums[i + 1];
            }
        }
        printTwoDimentinalArray(DP2, "\tDP2 Array:");
        for (int length = 1; length <= len; length++) {
            for (int left = 1; left <= len - length + 1; left++) {
                int right = left + length - 1;
                for (int k = left; k <= right; k++) {
                    DP[left][right] = Math.max(DP[left][right], newNums[left-1]*newNums[k]*newNums[right+1] + DP[left][k-1] + DP[k+1][right]);
                }
            }
        }
        for (int j = 1; j <= len; j++) {
            for (int i = j - 1; i >= 1; i--) {
                for (int k = i; k <= j; k++) {
                    DP2[i][j] = Math.max(DP2[i][j], newNums[i-1]*newNums[k]*newNums[j+1] + DP2[i][k-1] + DP2[k+1][j]);
                }
            }
        }

//        for (int i = len; i >= 1; i--) {
//            for (int j = i + 1; j <= len; j++) {
//                for (int k = i; k <= j; k++) {
//                    DP2[i][j] = Math.max(DP2[i][j], newNums[i-1]*newNums[k]*newNums[j+1] + DP2[i][k-1] + DP2[k+1][j]);
//                }
//            }
//        }

        printTwoDimentinalArray(DP, "\tDP Array:");
        printTwoDimentinalArray(DP2, "\tDP2 Array:");
        System.out.println("\tMax coints = " + DP[1][len]);
        return DP[1][len];
    }


    /**
     * Ones and Zeroes
     *
     * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
     *
     * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
     *
     * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
     *
     * Note:
     * The given numbers of 0s and 1s will both not exceed 100
     * The size of given string array won't exceed 600.
     * Example 1:
     * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
     * Output: 4
     *
     * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
     * Example 2:
     * Input: Array = {"10", "0", "1"}, m = 1, n = 1
     * Output: 2
     *
     * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
     */
    private static class ZeroOneCount {
        Integer zeros;
        Integer ones;
        ZeroOneCount(int z, int o) {
            zeros = z;
            ones = o;
        }
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        System.out.println("\nStart function findMaxForm()");
        printArray(strs, "\tStrings:");
        System.out.println("\tm = " + m + "; n = " + n);
        Integer[][] DP = new Integer[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(DP[i], 0);
        }
        ArrayList<ZeroOneCount> list = new ArrayList<>();
        for (String s : strs) {
            int zeros = 0;
            int ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            list.add(new ZeroOneCount(zeros, ones));
        }

        for (ZeroOneCount zoc : list) {
            int zeros = zoc.zeros;
            int ones = zoc.ones;
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    DP[i][j] = Math.max(DP[i][j], DP[i - zeros][j - ones] + 1);
                }
            }
        }
//        // This loop is wrong, since it should cause one string to be used mutiple times
//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                for (ZeroOneCount zoc : list) {
//                    if (zoc.zeros <= i && zoc.ones <= j) {
//                        DP[i][j] = Math.max(DP[i][j], DP[i-zoc.zeros][j-zoc.ones] + 1);
//                    }
//                }
//            }
//        }
        printTwoDimentinalArray(DP, "\tDP: ");
        return DP[m][n];
    }
    // endregion

    /**
     * Contains Duplicate III
     * <p>
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
     * <p>
     * https://leetcode.com/problems/contains-duplicate-iii/
     */
    // Passed test
    public static void containsNearbyAlmostDuplicateDemo(Integer[] nums, int k, int t) {
        System.out.println("\nStart function containsNearbyAlmostDuplicate()");
        printArray(nums, "\tNums: ");
        System.out.println("\tk = " + k);
        System.out.println("\tt = " + t);
        boolean res = containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println("\tres = " + res);
    }

    public static boolean containsNearbyAlmostDuplicate(Integer[] nums, int k, int t) {
        int len = nums.length;
        if (len < 2) return false;
        if (t < 0 || k < 0) return false;

        HashMap<Long, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            long val = (long) nums[i];
            if (!map.containsKey(val)) {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(i);
                map.put(val, newSet);
            } else {
                HashSet<Integer> set = map.get(val);
                for (int j : set) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                set.add(i);
                map.put(val, set);
            }
        }

        ArrayList<Long> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);

        for (int i = 0; i < sortedKeys.size(); i++) {
            long val = sortedKeys.get(i);
            HashSet<Integer> valLocs = map.get(val);

            for (int j = i + 1; j < sortedKeys.size() && sortedKeys.get(j) - val <= t; j++) {
                long tVal = sortedKeys.get(j);
                if (Math.abs(tVal - val) <= t) {
                    HashSet<Integer> tValLocs = map.get(tVal);
                    for (int l1 : valLocs) {
                        for (int l2 : tValLocs) {
                            if (Math.abs(l1 - l2) <= k) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    // Time out
    public static boolean containsNearbyAlmostDuplicate2(Integer[] nums, int k, int t) {
        int len = nums.length;
        if (len < 2) return false;
        if (t < 0 || k < 0) return false;
        //HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Long, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int val = nums[i];
            for (long tVal : map.keySet()) {
                if (Math.abs(tVal - val) <= t && map.containsKey(tVal)) {
                    HashSet<Integer> set = map.get(tVal);
                    for (int j : set) {
                        if (Math.abs(i - j) <= k) {
                            return true;
                        }
                    }
                }
            }
            if (!map.containsKey(val)) {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(i);
                map.put((long) val, newSet);
            } else {
                HashSet<Integer> set = map.get(val);
                for (int j : set) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                set.add(i);
                map.put((long) val, set);
            }
        }
        return false;
    }

    /**
     * Summary Ranges
     * <p>
     * Given a sorted integer array without duplicates, return the summary of its ranges.
     * <p>
     * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
     * <p>
     * https://leetcode.com/problems/summary-ranges/
     */
    public static List<String> summaryRanges(Integer[] nums) {
        System.out.println("\nStart function summaryRanges()");
        printArray(nums, "\tArray: ");
        ArrayList<String> res = new ArrayList<>();
        int len = nums.length;
        if (len < 1) return res;

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] != end + 1) {
                if (start == end)
                    res.add("" + start + "");
                else
                    res.add(start + "->" + end);
                start = nums[i];
            }
            end = nums[i];
        }
        if (start == end)
            res.add("" + start + "");
        else
            res.add(start + "->" + end);
        System.out.println("\t" + res);
        return res;
    }

    /**
     * H-Index
     * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
     * <p>
     * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
     * <p>
     * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
     * <p>
     * Note: If there are several possible values for h, the maximum one is taken as the h-index.
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        if (len == 0) return 0;

        for (int i = len - 1; i >= 1; i--) {
            if (citations[i] >= len - i && citations[i - 1] <= len - i) {
                return len - i;
            }
        }
        if (citations[0] >= len) return len;
        return 0;
    }

    public static int hIndex3(Integer[] citations) {
        Arrays.sort(citations, (a, b) -> b - a);
        Arrays.sort(citations);
        int len = citations.length;
        if (len == 0) return 0;
        int b = 0, e = len - 1;
        while (b < e) {
            int tmp = citations[b];
            citations[b] = citations[e];
            citations[e] = tmp;
            b++;
            e--;
        }

        for (int i = 0; i < len; i++) {
            if (i >= citations[i]) return i;
        }
        return len;
    }

    public static int hIndex4(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        if (len == 0) return 0;
        int b = 0, e = len - 1;
        while (b < e) {
            int tmp = citations[b];
            citations[b] = citations[e];
            citations[e] = tmp;
            b++;
            e--;
        }

        int begin = 0, end = len - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (mid < citations[mid]) {
                begin = mid + 1;
            } else {
                int temp = mid;
                while (temp >= 0 && temp >= citations[temp]) {
                    temp--;
                }
                return temp + 1;
            }
        }
        return len;
    }

    // Better solution using BFS
    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        if (len == 0) return 0;

        int begin = 1;
        int end = len - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            int loc = len - mid;
            if (citations[mid] < loc) {
                begin = mid + 1;
            } else if (citations[mid - 1] > loc) {
                end = mid - 1;
            } else {
                int temp = mid;
                while (temp < len &&
                        citations[temp] >= len - temp &&
                        citations[temp - 1] <= len - temp) {
                    temp++;
                }
                return len - (temp - 1);
            }
        }

        if (citations[0] >= len) return len;
        return 0;
    }

    /**
     * Total Hamming Distance
     * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
     * Now your job is to find the total Hamming distance between all pairs of the given numbers.
     *         Example:
     * Input: 4, 14, 2
     * Output: 6
     * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
     * showing the four bits relevant in this case). So the answer will be:
     * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
     */
    public static int totalHammingDistance(Integer[] nums) {
        System.out.println("\nStart function totalHammingDistance()");
        System.out.println("\tnums: " + Arrays.asList(nums));
        int sum = 0;
        int len = nums.length;
        if (len <= 1) return 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                sum += hammingDistance(nums[i], nums[j]);
            }
        }
        System.out.println("\tsum = " + sum);
        return sum;
    }
    public static int hammingDistance(int a, int b) {
        int count = 0;
        while (a > 0 && b > 0) {
            if ((a & 0x1) != (b & 0x1)) {
                count++;
            }
            a >>= 1;
            b >>= 1;
        }
        while (a > 0) {
            if ((a & 0x1) == 1) {
                count++;
            }
            a >>= 1;
        }
        while (b > 0) {
            if ((b & 0x1) == 1) {
                count++;
            }
            b >>= 1;
        }
        return count;
    }
    // Optimal solution
    public static int totalHammingDistance2(Integer[] nums) {
        System.out.println("\nStart function totalHammingDistance2()");
        System.out.println("\tnums: " + Arrays.asList(nums));
        int sum = 0;
        int len = nums.length;
        if (len <= 1) return 0;
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i : nums) {
            countDigits(i, temp);
        }

        for (int count : temp) {
            sum += count * (len - count);
        }
        System.out.println("\tsum = " + sum);
        return sum;
    }
    private static void countDigits(int i, ArrayList<Integer> temp) {
        int index = 0;
        while (i > 0) {
            if ((i & 0x1) == 1) {
                if (temp.size() > index)
                    temp.set(index, temp.get(index) + 1);
                else
                    temp.add(1);
            } else {
                if (temp.size() <= index)
                    temp.add(0);
            }
            index++;
            i >>= 1;
        }
    }
    public static int totalHammingDistance3(Integer[] nums) {
        System.out.println("\nStart function totalHammingDistance3()");
        System.out.println("\tnums: " + Arrays.asList(nums));
        int len = nums.length;
        int[] cnts = new int[32];

        for (int n : nums) {
            countDigits(n, cnts);
        }
        int sum = 0;
        for (int cnt : cnts) {
            sum += cnt * (len - cnt);
        }
        System.out.println("\tsum = " + sum);
        return sum;
    }
    private static void countDigits(int n, int[] cnts) {
        int idx = 0;
        while (n > 0) {
            if ((n & 0x1) == 1) {
                cnts[idx]++;
            }
            idx++;
            n >>= 1;
        }
    }

    /**
     * Game of Life
     *
     * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
     * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
     *         1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
     * 2. Any live cell with two or three live neighbors lives on to the next generation.
     * 3. Any live cell with more than three live neighbors dies, as if by over-population..
     *         4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     * Write a function to compute the next state (after one update) of the board given its current state.
     * Follow up: 
     *         1. Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
     * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
     */
    public static void gameOfLife(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        if (R < 1 || C < 1) return;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] %10 == 1) {
                    updateNeightbors(board, i, j, R, C);
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int val = board[i][j];
                int nei = val / 10;
                boolean live = val % 10 == 1;
                if (live) {
                    if (nei < 2 || nei > 3) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (nei == 3) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    private static void updateNeightbors(int[][] board, int i, int j, int R, int C) {
        if (i-1 >= 0) {
            board[i-1][j] += 10;
        }
        if (i-1 >= 0 && j-1 >= 0) {
            board[i-1][j-1] += 10;
        }
        if (i-1 >= 0 && j+1 < C) {
            board[i-1][j+1] += 10;
        }
        if (j-1 >= 0) {
            board[i][j-1] += 10;
        }
        if (j+1 < C) {
            board[i][j+1] += 10;
        }
        if (i+1 < R) {
            board[i+1][j] += 10;
        }
        if (i+1 < R && j-1 >= 0) {
            board[i+1][j-1] += 10;
        }
        if (i+1 < R && j+1 < C) {
            board[i+1][j+1] += 10;
        }
    }

    public static List<Integer> findMinHeightTrees(int n, Integer[][] edges) {
        System.out.println("\nStart function findMinHeightTrees()");
        printTwoDimentinalArray(edges);
        List<Integer> res = new ArrayList<>();
        int connLen = edges.length;
        if (connLen < 1) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        HashMap<Integer, HashSet<Integer>> conn = new HashMap<>();
        for (int i = 0; i < connLen; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (conn.containsKey(n1)) {
                conn.get(n1).add(n2);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(n2);
                conn.put(n1, newSet);
            }
            if (conn.containsKey(n2)) {
                conn.get(n2).add(n1);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(n1);
                conn.put(n2, newSet);
            }
        }

        HashSet<Integer> curLevel = new HashSet<>();
        HashSet<Integer> preLevel = new HashSet<>();
        while (conn.size() > 0) {
            for (Integer i : conn.keySet()) {
                if (conn.get(i).size() <= 1) {
                    curLevel.add(i);
                }
            }

            for (int cur : curLevel) {
                for (int neighbor : conn.get(cur)) {
                    conn.get(neighbor).remove(cur);
                }
                conn.remove(cur);
            }
            preLevel.clear();
            preLevel.addAll(curLevel);
            curLevel.clear();
        }

        res.addAll(preLevel);
        System.out.println("\tRes = " + res);
        return res;
    }

    public static List<Integer> findMinHeightTrees2(int n, Integer[][] edges) {
        System.out.println("\nStart function findMinHeightTrees2()");
        printTwoDimentinalArray(edges);
        List<Integer> res = new ArrayList<>();
        int connLen = edges.length;
        if (connLen < 1) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        HashMap<Integer, HashSet<Integer>> conn = new HashMap<>();
        for (int i = 0; i < connLen; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (conn.containsKey(n1)) {
                conn.get(n1).add(n2);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(n2);
                conn.put(n1, newSet);
            }
            if (conn.containsKey(n2)) {
                conn.get(n2).add(n1);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(n1);
                conn.put(n2, newSet);
            }
        }

        Queue<Integer> Q = new LinkedList<>();
        for (Integer i : conn.keySet()) {
            if (conn.get(i).size() <= 1) {
                Q.add(i);
            }
        }
        while (conn.size() > 2) {
            int size = Q.size();
            while (size-- > 0) {
                int cur = Q.poll();
                for (int neighbor : conn.get(cur)) {
                    conn.get(neighbor).remove(cur);
                    if (conn.get(neighbor).size() <= 1) {
                        Q.add(neighbor);
                    }
                }
                conn.remove(cur);
            }
        }

        res.addAll(conn.keySet());
        System.out.println("\tRes = " + res);
        return res;
    }

//    public static List<Integer> findMinHeightTrees(int n, Integer[][] edges) {
//        System.out.println("\nStart function findMinHeightTrees()");
//        printTwoDimentinalArray(edges);
//        List<Integer> res = new ArrayList<>();
//        int connLen = edges.length;
//        if (connLen < 1) {
//            for (int i = 0; i < n; i++) {
//                res.add(i);
//            }
//            return res;
//        }
//
//        HashMap<Integer, HashSet<Integer>> conn = new HashMap<>();
//        for (int i = 0; i < connLen; i++) {
//            int n1 = edges[i][0];
//            int n2 = edges[i][1];
//            if (conn.containsKey(n1)) {
//                conn.get(n1).add(n2);
//            } else {
//                HashSet<Integer> newSet = new HashSet<>();
//                newSet.add(n2);
//                conn.put(n1, newSet);
//            }
//            if (conn.containsKey(n2)) {
//                conn.get(n2).add(n1);
//            } else {
//                HashSet<Integer> newSet = new HashSet<>();
//                newSet.add(n1);
//                conn.put(n2, newSet);
//            }
//        }
//
//        Queue<Integer> Q = new LinkedList<>();
//        for (Integer i : conn.keySet()) {
//            if (conn.get(i).size() == 1) {
//                Q.add(i);
//            }
//        }
//
//        HashMap<Integer, Integer> handledLevel = new HashMap<>();
//        HashSet<Integer> lastLevel = new HashSet<>();
//        HashSet<Integer> curLevel = new HashSet<>();
//        HashSet<Integer> nextLevel = new HashSet<>();
//        int level = 0;
//        while (!Q.isEmpty()) {
//            level++;
//            int size = Q.size();
//            while (size-- > 0) {
//                int i = Q.poll();
//                curLevel.add(i);
//                handledLevel.put(i, level);
//            }
//
//            for (int cur : curLevel) {
//                for (int neighbor : conn.get(cur)) {
//                    if ((!handledLevel.containsKey(neighbor) ||
//                            handledLevel.get(neighbor) == level) &&
//                            !nextLevel.contains(neighbor)) {
//                        nextLevel.add(neighbor);
//                    }
//                }
//            }
//            if (!nextLevel.equals(curLevel) && !nextLevel.isEmpty()) {
//                Q.addAll(nextLevel);
//            }
//            lastLevel.clear();
//            lastLevel.addAll(curLevel);
//            curLevel.clear();
//            nextLevel.clear();
//        }
//        res.addAll(lastLevel);
//        System.out.println("\tRes = " + res);
//        return res;
//    }

    /**
     * Find K Pairs with Smallest Sums
     *
     * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
     *
     * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
     *
     * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
     *
     * Example 1:
     * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
     *
     * Return: [1,2],[1,4],[1,6]
     *
     * The first 3 pairs are returned from the sequence:
     *         [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * Example 2:
     * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
     *
     * Return: [1,1],[1,1]
     *
     * The first 2 pairs are returned from the sequence:
     *         [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     * Example 3:
     * Given nums1 = [1,2], nums2 = [3],  k = 3
     *
     * Return: [1,3],[2,3]
     *
     * All possible pairs are returned from the sequence:
     *         [1,3],[2,3]
     * Credits:
     */
    private static class TwoPair {
        Integer n1;
        Integer n2;
        public TwoPair(Integer x, Integer y) {
            n1 = x;
            n2 = y;
        }
    }
    public static List<Integer[]> kSmallestPairs(Integer[] nums1, Integer[] nums2, int k) {
        System.out.println("\nStart function kSmallestPairs()");
        printArray(nums1, "\tNums1: ");
        printArray(nums2, "\tNums2: ");

        List<Integer[]> res = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 == 0 || len2 == 0) return res;

        PriorityQueue<TwoPair> Q = new PriorityQueue<>(len1 * len2, (p1, p2) -> (p1.n1 + p1.n2) - (p2.n1 + p2.n2));
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                Q.add(new TwoPair(nums1[i], nums2[j]));
            }
        }

        for (int i = 0; i < k; i++) {
            if (Q.isEmpty()) break;
            TwoPair p = Q.poll();
            res.add(new Integer[]{p.n1, p.n2});
        }
        for (Integer[] a : res) {
            System.out.println("\t\t" + Arrays.asList(a));
        }
        return res;
    }

    /**
     * Wiggle Sort
     *
     * Given an unsorted array nums, reorder it such that nums[0] <= nums[1] => nums[2] <= nums[3]....
     * Note:
     * You may assume all input has valid answer.
     * Follow Up:
     * Can you do it in O(n) time and/or in-place with O(1) extra space?
     */
    public static void wiggleSort(Integer[] nums) {
        System.out.println("\nStart function wiggleSort()");
        printArray(nums, "\tNums:");
        int len = nums.length;
        if (len <= 1) return;
        for (int i = 1; i < len; i++) {
            if ((i%2 == 1 && nums[i] < nums[i-1]) ||
                (i%2 == 0 && nums[i] > nums[i-1])) {
                swap(nums, i, i - 1);
            }
        }
        printArray(nums, "\tNums Sorted:");
    }

    /**
     * Wiggle Sort II
     *
     * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
     * Example:
     *         (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
     *         (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
     * Note:
     * You may assume all input has valid answer.
     * Follow Up:
     * Can you do it in O(n) time and/or in-place with O(1) extra space?
     */
    public static void wiggleSortII(Integer[] nums) {
        System.out.println("\nStart function wiggleSort()");
        printArray(nums, "\tNums:");
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) temp[i] = nums[i];
        Arrays.sort(temp);

        int pre = (len + 1)/2;
        int post = len;
        for (int i = 0; i < len; i++) {
            nums[i] = i % 2 == 1 ? temp[--post] : temp[--pre];
        }
        printArray(nums, "\tNums Sorted:");
    }

    /**
     * Longest Increasing Path in a Matrix
     *
     * Given an integer matrix, find the length of the longest increasing path.
     *
     * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
     *
     * Example 1:
     *
     * nums = [
     *         [9,9,4],
     *         [6,6,8],
     *         [2,1,1]
     *         ]
     * Return 4
     * The longest increasing path is [1, 2, 6, 9].
     *
     * Example 2:
     *
     * nums = [
     *         [3,4,5],
     *         [3,2,6],
     *         [2,2,1]
     *         ]
     * Return 4
     * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
     */
    public static int longestIncreasingPath(Integer[][] matrix) {
        System.out.println("\nStart function longestIncreasingPath()");
        printTwoDimentinalArray(matrix, "\tMatrix:");
        int R = matrix.length;
        if (R < 1) return 0;
        int C = matrix[0].length;
        if (C < 1) return 0;
        Integer[][] LDP = new Integer[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(LDP[i], 0);
        }

        int maxLen = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                maxLen = Math.max(maxLen, longestIncreasingPathHelper(matrix, LDP, i, j, R, C));
            }
        }
        printTwoDimentinalArray(LDP, "\tLDP:");
        System.out.println("\tMax length = " + maxLen);
        return maxLen;
    }
    private static int longestIncreasingPathHelper(Integer[][] matrix, Integer[][] LDP, int i, int j, int R, int C) {
        if (LDP[i][j] > 0) return LDP[i][j];

        int above = (i > 0 && matrix[i][j] > matrix[i-1][j]) ? longestIncreasingPathHelper(matrix, LDP, i-1, j, R, C) : 0;
        int below = (i < R-1 && matrix[i][j] > matrix[i+1][j]) ? longestIncreasingPathHelper(matrix, LDP, i+1, j, R, C) : 0;
        int left = (j > 0 && matrix[i][j] > matrix[i][j-1]) ? longestIncreasingPathHelper(matrix, LDP, i, j-1, R, C) : 0;
        int right = (j < C-1 && matrix[i][j] > matrix[i][j+1]) ? longestIncreasingPathHelper(matrix, LDP, i, j+1, R, C) : 0;

        int maxSteps = 1 + Math.max(Math.max(above, below), Math.max(left, right));
        LDP[i][j] = maxSteps;
        return maxSteps;
    }

    /**
     * Heaters
     * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
     *         Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
     *         So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
     * Note:
     *         1. Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
     *         2. Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
     *         3. As long as a house is in the heaters' warm radius range, it can be warmed.
     *         4. All the heaters follow your radius standard and the warm radius will the same.
     * Example 1:
     * Input: [1,2,3],[2]
     * Output: 1
     * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
     *         Example 2:
     * Input: [1,2,3,4],[1,4]
     * Output: 1
     * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
     */
    private static class Range {
        Integer position;
        Integer higherBound;
        public Range(int p, int h) {
            position = p;
            higherBound = h;
        }
    }
    public static int findRadius(int[] houses, int[] heaters) {
        System.out.println("\nStart function findRadius()");
        Arrays.sort(houses);
        Arrays.sort(heaters);
        printArray(houses, "\thouses:");
        printArray(heaters, "\theaters:");
        int hLen = heaters.length;
        ArrayList<Range> ranges = new ArrayList<>();
        for (int i = 0; i < hLen - 1; i++) {
            Range newRange = new Range(heaters[i], heaters[i] + (heaters[i+1] - heaters[i])/2);
            ranges.add(newRange);
        }
        // This line is important. Make sure the last heater is included
        ranges.add(new Range(heaters[hLen-1], Integer.MAX_VALUE));

        int curRangeIndex = 0;
        Integer maxR = Integer.MIN_VALUE;
        for (int h : houses) {
            Range curRange = ranges.get(curRangeIndex);
            while (h > curRange.higherBound) {
                curRange = ranges.get(++curRangeIndex);
            }
            maxR = Math.max(maxR, Math.abs(h - curRange.position));
        }
        System.out.println("\tMaxR = " + maxR);
        return maxR;
    }

    /**
     * Self Crossing
     * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.
     * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
     *         Example 1:
     * Given x = [2, 1, 1, 2],
     *         ┌───┐
     *         │   │
     *         └───┼──>
     *             │
     * Return true (self crossing)
     * Example 2:
     * Given x = [1, 2, 3, 4],
     *         ┌──────┐
     *         │      │
     *         │
     *         │
     *         └────────────>
     * Return false (not self crossing)
     * Example 3:
     * Given x = [1, 1, 1, 1],
     *         ┌───┐
     *         │   │
     *         └───┼>
     * Return true (self crossing)
     */
    private static class Line {
        int x1;
        int y1;
        int x2;
        int y2;
        public Line(int x, int y, int m, int n) {
            x1 = 1;
            y1 = y;
            x2 = m;
            y2 = n;
        }
        public boolean isCross (Line l2) {
            return ((this.y1 <= l2.y1 && this.y2 >= l2.y1) &&
                    (l2.x1 <= this.x1 && l2.x2 >= this.x1)) ||
                   ((this.x1 <= l2.x1 && this.x2 >= l2.x1) &&
                    (l2.y1 <= this.y1 && l2.y2 >= this.y1));
        }
    }
    public static void isSelfCrossingDemo(int[] x) {
        System.out.println("\nStart function isSelfCrossing()");
        printArray(x, "\tInput:");
        System.out.println("\tisSelfCrossing = " + isSelfCrossing(x));
    }
    // Wrong version
    public static boolean isSelfCrossing2(int[] x) {
        int len = x.length;
        if (len <= 3) return false;
        LinkedList<Line> Q = new LinkedList<>();
        Q.add(new Line(0, 0, 0, x[0]));
        Q.add(new Line(-x[1], x[0], 0, x[0]));
        Q.add(new Line(-x[1], x[0] - x[2], -x[1], x[0]));

        for (int i = 3; i < len; i++) {
            Line last = Q.getLast();
            Line newLine;
            if (i%4 == 0) {
                newLine = new Line(last.x1, last.y1, last.x1, last.y1 + x[i]);
            } else if (i%4 == 1) {
                newLine = new Line(last.x2 - x[i], last.y2, last.x2, last.y2);
            } else if (i%4 == 2) {
                newLine = new Line(last.x1, last.y1 - x[i], last.x1, last.y1);
            } else {
                newLine = new Line(last.x1, last.y1, last.x1 + x[i], last.y1);
            }
            if (Q.removeFirst().isCross(newLine)) {
                return true;
            }
            Q.addLast(newLine);
        }
        return false;
    }
    // http://www.cnblogs.com/grandyang/p/5216856.html
    public static boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; ++i) {
            if (x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) {
                return true;
            }
            if (i >= 4 && x[i-1] == x[i-3] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
            if (i >= 5 && x[i-2] >= x[i-4] && x[i-3] >= x[i-1] && x[i-1] >= x[i-3] - x[i-5] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Increasing Triplet Subsequence
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
     * Formally the function should:
     * Return true if there exists i, j, k 
     * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     * Your algorithm should run in O(n) time complexity and O(1) space complexity.
     * Examples:
     * Given [1, 2, 3, 4, 5],
     *         return true.
     * Given [5, 4, 3, 2, 1],
     *         return false.
     */
    public static void increasingTripletDemo(int[] nums) {
        System.out.println("\nStart function increasingTriplet()");
        printArray(nums, "\tNums:");
        System.out.println("\tRes = " + increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        Integer m1 = Integer.MAX_VALUE;
        Integer m2 = Integer.MAX_VALUE;
        for (int a : nums) {
            if (m1 >= a) m1 = a;
            else if (m2 >= a) m2 = a;
            else return true;
        }
        return false;
    }

    /**
     * Island Perimeter
     * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
     *
     * Example:
     *
     *         [[0,1,0,0],
     *          [1,1,1,0],
     *          [0,1,0,0],
     *          [1,1,0,0]]
     *
     * Answer: 16
     * Explanation: The perimeter is the 16 yellow stripes in the image below:
     */
    public static int islandPerimeter(int[][] grid) {
        int R = grid.length;
        if (R < 1) return 0;
        int C = grid[0].length;
        if (C < 1) return 0;

        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    total++;
                }
            }
        }
        int overlapHorizontal = 0;
        for (int i = 0; i < R-1; i++) {
            int sum = 0;
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1 && grid[i][j] == grid[i+1][j]) {
                    sum++;
                }
            }
            overlapHorizontal += sum;
        }
        int overlapVeritcal = 0;
        for (int j = 0; j < C-1; j++) {
            int sum = 0;
            for (int i = 0; i < R; i++) {
                if (grid[i][j] == 1 && grid[i][j] == grid[i][j+1]) {
                    sum++;
                }
            }
            overlapVeritcal += sum;
        }

        return total * 4 - 2 * overlapVeritcal - 2 * overlapHorizontal;
    }
    private static class PairVal {
        int total;
        int neighbors;
        PairVal(int t, int n) {
            total = t;
            neighbors = n;
        }
    }
    public static void islandPerimeter2Demo(int[][] grid) {
        System.out.println("\nStart function islandPerimeter2Demo()");
        printTwoDimentinalArray(grid, "\tGrid:");
        System.out.println("\tRes = " + islandPerimeter2(grid));
    }
    // This version is wrong for input [[1,1],[1,1]]
    public static int islandPerimeter2(int[][] grid) {
        int R = grid.length;
        if (R < 1) return 0;
        int C = grid[0].length;
        if (C < 1) return 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    PairVal res = islandPerimeterDFS(grid, i, j, R, C);
                    return res.total * 4 - 2 * res.neighbors;
                }
            }
        }
        return 0;
    }
    private static PairVal islandPerimeterDFS(int[][] grid, int i, int j, int R, int C) {
        grid[i][j] = -1;
        PairVal above = (i > 0 && grid[i-1][j] == 1) ? islandPerimeterDFS(grid, i-1, j, R, C) : null;
        PairVal below = (i < R-1 && grid[i+1][j] == 1) ? islandPerimeterDFS(grid, i+1, j, R, C) : null;
        PairVal left = (j > 0 && grid[i][j-1] == 1) ? islandPerimeterDFS(grid, i, j-1, R, C) : null;
        PairVal right = (j < C-1 && grid[i][j+1] == 1) ? islandPerimeterDFS(grid, i, j+1, R, C) : null;
//        grid[i][j] = 1;

        int total = 1 + (above != null ? above.total : 0) + (below != null ? below.total : 0) + (left != null ? left.total : 0) + (right != null ? right.total : 0);
        int neighbors = (above != null ? above.neighbors + 1 : 0) + (below != null ? below.neighbors + 1 : 0) + (left != null ? left.neighbors + 1 : 0) + (right != null ? right.neighbors + 1 : 0);
        return new PairVal(total, neighbors);
    }

    /**
     * Evaluate Division
     * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
     * Example:
     * Given a / b = 2.0, b / c = 3.0. 
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
     *         return [6.0, 0.5, -1.0, 1.0, -1.0 ].
     * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
     * According to the example above:
     * equations = [ ["a", "b"], ["b", "c"] ],
     * values = [2.0, 3.0],
     * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
     * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
     */
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        System.out.println("\nStart function calcEquation()");
        for (int i = 0; i < values.length; i++) {
            System.out.println("\t" + equations[i][0] + " / " + equations[i][1] + " = " + values[i]);
        }
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, HashSet<String>> Dd2Dv = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String dd = equations[i][0];
            String dv = equations[i][1];
            map.put(dd+"/"+dv, values[i]);
            map.put(dv+"/"+dd, 1.0/values[i]);
            if (!Dd2Dv.containsKey(dd)) {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(dv);
                Dd2Dv.put(dd, newSet);
            } else {
                Dd2Dv.get(dd).add(dv);
            }
            if (!Dd2Dv.containsKey(dv)) {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(dd);
                Dd2Dv.put(dv, newSet);
            } else {
                Dd2Dv.get(dv).add(dd);
            }
        }

        double[] res = new double[queries.length];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.length; i++) {
            String dd = queries[i][0];
            String dv = queries[i][1];
            String exp = dd+"/"+dv;
            if (map.containsKey(exp)) {
                res[i] = map.get(exp);
            } else {
                if (!Dd2Dv.containsKey(dd)) {
                    continue;
                } else if (dd.equals(dv)) {
                    res[i] = 1.0;
                } else {
                    res[i] = getPath(map, Dd2Dv, dd, dv);
                }
            }
        }
        System.out.println("\tResults:");
        for (int i = 0; i < queries.length; i++) {
            System.out.println("\t" + queries[i][0] + " / " + queries[i][1] + " = " + res[i]);
        }
        return res;
    }
    private static double getPath(HashMap<String, Double> map, HashMap<String, HashSet<String>> Dd2Dv, String start, String end) {
        Queue<LinkedList<String>> Q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        list.add(start);
        Q.add(list);
        visited.add(start);
        while(!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                LinkedList<String> tmpList = Q.poll();
                if (tmpList.getLast().equals(end)) {
                    return getValFromPath(map, tmpList);
                } else {
                    for (String divisor : Dd2Dv.get(tmpList.getLast())) {
                        if (!visited.contains(divisor)) {
                            LinkedList<String> tmpList2 = new LinkedList<>(tmpList);
                            tmpList2.add(divisor);
                            visited.add(divisor);
                            Q.add(tmpList2);
                        }
                    }
                }
            }
        }
        return -1.0;
    }
//    private static double getPath(HashMap<String, Double> map, HashMap<String, HashSet<String>> Dd2Dv, String start, String end) {
//        Queue<LinkedList<String>> Q = new LinkedList<>();
//        HashSet<String> visited = new HashSet<>();
//        LinkedList<String> list = new LinkedList<>();
//        list.add(start);
//        Q.add(list);
//        while(!Q.isEmpty()) {
//            int size = Q.size();
//            while (size-- > 0) {
//                LinkedList<String> tmpList = Q.poll();
//                if (tmpList.getLast().equals(end)) {
//                    return getValFromPath(map, tmpList);
//                } else {
//                    visited.add(tmpList.getLast());
//                    for (String divisor : Dd2Dv.get(tmpList.getLast())) {
//                        if (!visited.contains(divisor)) {
//                            LinkedList<String> tmpList2 = new LinkedList<>(tmpList);
//                            tmpList2.add(divisor);
//                            Q.add(tmpList2);
//                        }
//                    }
//                }
//            }
//        }
//        return -1.0;
//    }
    private static double getValFromPath(HashMap<String, Double> map, LinkedList<String> tmpList) {
        double res = 1.0;
        String dd = null;
        for (String str : tmpList) {
            if (dd == null) {
                dd = str;
            } else {
                String exp = dd + "/" + str;
                res *= map.get(exp);
                dd = str;
            }
        }
        return res;
    }
    public static double[] calcEquation2(String[][] equations, double[] values, String[][] queries) {
        System.out.println("\nStart function calcEquation()");
        for (int i = 0; i < values.length; i++) {
            System.out.println("\t" + equations[i][0] + " / " + equations[i][1] + " = " + values[i]);
        }
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, HashSet<String>> Dd2Dv = new HashMap<>();
        HashMap<String, HashSet<String>> Dv2Dd = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String dd = equations[i][0];
            String dv = equations[i][1];
            //Expression exp = new Expression(dd, dv);
            map.put(dd+"/"+dv, values[i]);
            map.put(dv+"/"+dd, 1.0/values[i]);
            if (!Dd2Dv.containsKey(dd)) {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(dv);
                Dd2Dv.put(dd, newSet);
            } else {
                Dd2Dv.get(dd).add(dv);
            }
            if (!Dd2Dv.containsKey(dv)) {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(dd);
                Dd2Dv.put(dv, newSet);
            } else {
                Dd2Dv.get(dv).add(dd);
            }
            if (!Dv2Dd.containsKey(dv)) {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(dd);
                Dv2Dd.put(dv, newSet);
            } else {
                Dv2Dd.get(dv).add(dd);
            }
            if (!Dv2Dd.containsKey(dd)) {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(dv);
                Dv2Dd.put(dd, newSet);
            } else {
                Dv2Dd.get(dd).add(dv);
            }
        }

        double[] res = new double[queries.length];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.length; i++) {
            String dd = queries[i][0];
            String dv = queries[i][1];
            String exp = dd+"/"+dv;
            if (map.containsKey(exp)) {
                res[i] = map.get(exp);
            } else {
                if (!Dd2Dv.containsKey(dd) || !Dv2Dd.containsKey(dv)) {
                    continue;
                } else if (dd.equals(dv)) {
                    res[i] = 1.0;
                } else {
                    for (String divisor : Dd2Dv.get(dd)) {
                        String exp1 = dd + "/" + divisor;
                        String exp2 = divisor + "/" + dv;

                        if (map.containsKey(exp2)) {
                            res[i] = map.get(exp1) * map.get(exp2);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("\tResults:");
        for (int i = 0; i < queries.length; i++) {
            System.out.println("\t" + queries[i][0] + " / " + queries[i][1] + " = " + res[i]);
        }
        return res;
    }

    /**
     * Create Maximum Number
     * Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
     *         Example 1:
     * nums1 = [3, 4, 6, 5]
     * nums2 = [9, 1, 2, 5, 8, 3]
     * k = 5
     *         return [9, 8, 6, 5, 3]
     * Example 2:
     * nums1 = [6, 7]
     * nums2 = [6, 0, 4]
     * k = 5
     *         return [6, 7, 6, 0, 4]
     * Example 3:
     * nums1 = [3, 9]
     * nums2 = [8, 9]
     * k = 3
     *         return [9, 8, 9]
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        System.out.println("\nStart function maxNumber()");
        printArray(nums1, "\tNum1: ");
        printArray(nums2, "\tNum2: ");
        System.out.println("\tK = " + k);
        int m = nums1.length;
        int n = nums2.length;
        LinkedList<Integer> res = new LinkedList<>();
        Integer max = Integer.MIN_VALUE;
        for (int i = Math.max(0, k-n); i <= Math.min(m, k); i++) {
            LinkedList<Integer> a1 = maxArr(nums1, i);
            LinkedList<Integer> a2 = maxArr(nums2, k - i);
            LinkedList<Integer> merged = mergeArr(a1, a2);

            if (isGreater(merged, res)) {
                res = merged;
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        for (int i : res) {
            resArr[index++] = i;
        }
        printArray(resArr, "\tResult: ");
        return resArr;
    }
    private static LinkedList<Integer> maxArr(int[] nums, int k) {
        int len = nums.length;
        LinkedList<Integer> res = new LinkedList<>();
        int drop = len - k;
        for (int i : nums) {
            while (drop > 0 && !res.isEmpty() && res.getLast() < i) {
                res.removeLast();
                drop--;
            }
            res.addLast(i);
        }
        LinkedList<Integer> finalRes = new LinkedList<Integer>(res.subList(0, k));
        return finalRes;
    }
    private static boolean isGreater(LinkedList<Integer> nums1, LinkedList<Integer> nums2) {
        int i = 0, j = 0;
        for(; i < nums1.size() && j < nums2.size(); ++i, ++j) {
            if (nums1.get(i) > nums2.get(j))
                return true;
            if (nums1.get(i) < nums2.get(j))
                return false;
        }
        return i != nums1.size();
    }
    private static LinkedList<Integer> mergeArr(LinkedList<Integer> a1, LinkedList<Integer> a2) {
        LinkedList<Integer> res = new LinkedList<>();
        while (!a1.isEmpty() && !a2.isEmpty()) {
            res.add(isGreater(a1, a2) ? a1.removeFirst() : a2.removeFirst());
        }
        while (!a1.isEmpty()) {
            res.add(a1.removeFirst());
        }
        while (!a2.isEmpty()) {
            res.add(a2.removeFirst());
        }
        return res;
    }

    /**
     * Frog Jump
     * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
     *
     * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
     *
     * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
     *
     * Note:
     *
     * The number of stones is ≥ 2 and is < 1,100.
     * Each stone's position will be a non-negative integer < 231.
     * The first stone's position is always 0.
     * Example 1:
     *
     *         [0,1,3,5,6,8,12,17]
     *
     * There are a total of 8 stones.
     * The first stone at the 0th unit, second stone at the 1st unit,
     * third stone at the 3rd unit, and so on...
     * The last stone at the 17th unit.
     *
     * Return true. The frog can jump to the last stone by jumping
     * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
     * 2 units to the 4th stone, then 3 units to the 6th stone,
     * 4 units to the 7th stone, and 5 units to the 8th stone.
     * Example 2:
     *
     *         [0,1,2,3,4,8,9,11]
     *
     * Return false. There is no way to jump to the last stone as
     * the gap between the 5th and 6th stone is too large.
     */
    public static void canCrossDemo(int[] stones) {
        System.out.println("\nStart function canCrossDemo()");
        printArray(stones, "\tStones:");

        System.out.println("\tCan cross: " + canCross3(stones));
    }
    // Time out
    public static boolean canCross(int[] stones) {
        int len = stones.length;
        int last = stones[len-1];
        if (stones[0] != 0 || stones[1] != 1) {
            return false;
        }
        if (last <= 1) {
            return true;
        }
        HashSet<Integer> stoneSet = new HashSet<>();
        for (int i : stones) {
            stoneSet.add(i);
        }
        HashMap<Integer, HashSet<Integer>> processed = new HashMap<>();
        processed.put(1, new HashSet<>());
        processed.get(1).add(1);
        HashMap<Integer, HashSet<Integer>> curLevel = new HashMap<>(processed);
        HashMap<Integer, HashSet<Integer>> nextLevel = new HashMap<>();
        while (!curLevel.isEmpty()) {
            for (int curStone : curLevel.keySet()) {
                for (int lastStep : curLevel.get(curStone)) {
                    for (int i = -1; i <= 1; i++) {
                        int curStep = lastStep + i;
                        if (curStep == 0) continue;
                        int nextStone = curStone + curStep;
                        if (nextStone == last) {
                            return true;
                        }
                        if (stoneSet.contains(nextStone)) {
                            if (!nextLevel.containsKey(nextStone)) {
                                nextLevel.put(nextStone, new HashSet<>());
                            }
                            if (!processed.containsKey(nextStone) ||
                                    !processed.get(nextStone).contains(curStep)) {
                                nextLevel.get(nextStone).add(curStep);
                            }
                        }
                    }

                    if (!processed.containsKey(curStone)) {
                        processed.put(curStone, new HashSet<>());
                    }
                    processed.get(curStone).add(lastStep);
                }
            }

            curLevel.clear();
            curLevel = (HashMap<Integer, HashSet<Integer>>)nextLevel.clone();
            nextLevel.clear();
            System.out.println("\t" + curLevel);
        }

        return false;
    }
    // Time out
    public static boolean canCross2(int[] stones) {
        int k = 0;
        return canCrossDFS2(stones, 0, k);
    }
    private static boolean canCrossDFS2(int[] stones, int index, int k) {
        if (index == stones.length - 1) return true;
        for (int i = k - 1; i <= k + 1; i++) {
            int nextJump = stones[index] + i;

            int nextPosition = Arrays.binarySearch(stones, index + 1, stones.length, nextJump);
            if (nextPosition > 0) {
                if (canCrossDFS2(stones, nextPosition, i)) {
                    return true;
                }
            }
        }

        return false;
    }
    // Time out
    public static boolean canCross3(int[] stones) {
        HashSet<Integer> stoneSet = new HashSet<>();
        for (int i : stones) {
            stoneSet.add(i);
        }
        int last = stones[stones.length-1];
        int k = 0;
        return canCrossDFS3(stoneSet, 0, last, k);
    }
    private static boolean canCrossDFS3(HashSet<Integer> stoneSet, int curStone, int destStone, int k) {
        if (destStone == curStone) {
            return true;
        }
        for (int i = k - 1; i <= k + 1; i++) {
            int nextStone = curStone + i;

            if (nextStone != curStone && stoneSet.contains(nextStone)) {
                if (canCrossDFS3(stoneSet, nextStone, destStone, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 4Sum II
     *
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
     *
     * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
     *
     * Example:
     *
     * Input:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     *
     * Output:
     *         2
     *
     * Explanation:
     * The two tuples are:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        System.out.println("\nStart function fourSumCount()");
        printArray(A, "\tA:");
        printArray(B, "\tB:");
        printArray(C, "\tC:");
        printArray(D, "\tD:");

        ArrayList<int[]> res = new ArrayList<>();
        ArrayList<int[]> candidates = new ArrayList<>();
        candidates.add(A);
        candidates.add(B);
        candidates.add(C);
        candidates.add(D);
        ArrayList<Integer> indexs = new ArrayList<>();
        indexs.add(0);
        indexs.add(0);
        indexs.add(0);
        indexs.add(0);
        fourSumCountDFS(candidates, indexs, new int[4], 0, res);

        for (int[] r : res) {
            printArray(r, "\t\tRes:");
        }
        System.out.println("\tCount = " + res.size());
        return res.size();
    }
    private static void fourSumCountDFS(ArrayList<int[]> candidates, ArrayList<Integer> indexs, int[] temp, int index, ArrayList<int[]> res) {
        if (index == 4) {
            int sum = 0;
            for (int i : temp) {
                sum += i;
            }
            if (sum == 0) {
                res.add((int[]) temp.clone());
            }
        } else {
            int len = candidates.get(index).length;
            for (int i = 0; i < len; i++) {
                temp[index] = candidates.get(index)[i];
                fourSumCountDFS(candidates, indexs, temp, index+1, res);
            }
        }
    }
    // Passed test
    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        System.out.println("\nStart function fourSumCount2()");
        printArray(A, "\tA:");
        printArray(B, "\tB:");
        printArray(C, "\tC:");
        printArray(D, "\tD:");

        HashMap<Integer, Integer> AB = new HashMap<>();
        HashMap<Integer, Integer> CD = new HashMap<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum1 = A[i] + B[j];
                if (AB.containsKey(sum1)) {
                    AB.put(sum1, AB.get(sum1) + 1);
                } else {
                    AB.put(sum1, 1);
                }
                int sum2 = C[i] + D[j];
                if (CD.containsKey(sum2)) {
                    CD.put(sum2, CD.get(sum2) + 1);
                } else {
                    CD.put(sum2, 1);
                }
            }
        }

        int res = 0;
        for (int s1 : AB.keySet()) {
            if (CD.containsKey(-s1)) {
                res += AB.get(s1) * CD.get(-s1);
            }
        }
        System.out.println("\tCount = " + res);
        return res;
    }
    // Wrong version
    public static int fourSumCount3(int[] A, int[] B, int[] C, int[] D) {
        System.out.println("\nStart function fourSumCount2()");
        printArray(A, "\tA:");
        printArray(B, "\tB:");
        printArray(C, "\tC:");
        printArray(D, "\tD:");

        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<List<Integer>> candidates = new ArrayList<>();
        candidates.add(new ArrayList<>());
        candidates.add(new ArrayList<>());
        candidates.add(new ArrayList<>());
        candidates.add(new ArrayList<>());
        int aZeros = 0;
        for (int a : A) {
            if (a == 0) aZeros++;
            else candidates.get(0).add(a);
        }
        int bZeros = 0;
        for (int b : B) {
            if (b == 0) bZeros++;
            else candidates.get(1).add(b);
        }
        int cZeros = 0;
        for (int c : C) {
            if (c == 0) cZeros++;
            else candidates.get(2).add(c);
        }
        int dZeros = 0;
        for (int d : D) {
            if (d == 0) dZeros++;
            else candidates.get(3).add(d);
        }
        if (aZeros > 0) {
            candidates.get(0).add(0);
            aZeros--;
        }
        if (bZeros > 0) {
            candidates.get(1).add(0);
            bZeros--;
        }
        if (cZeros > 0) {
            candidates.get(2).add(0);
            cZeros--;
        }
        if (dZeros > 0) {
            candidates.get(3).add(0);
            dZeros--;
        }

        ArrayList<Integer> indexs = new ArrayList<>();
        indexs.add(0);
        indexs.add(0);
        indexs.add(0);
        indexs.add(0);
        fourSumCountDFS2(candidates, indexs, new int[4], 0, res);

        for (List<Integer> r : res) {
            System.out.println("\t\t" + r);
        }
        int count = res.size() + (aZeros * bZeros * cZeros * dZeros);
        System.out.println("\tCount = " + count);
        return count;
    }
    private static void fourSumCountDFS2(ArrayList<List<Integer>> candidates, ArrayList<Integer> indexs, int[] temp, int index, ArrayList<List<Integer>> res) {
        if (index == 4) {
            LinkedList<Integer> newRes = new LinkedList<>();
            int sum = 0;
            for (int i : temp) {
                sum += i;
                newRes.add(i);
            }
            if (sum == 0) {
                res.add(newRes);
            }
        } else {
            int len = candidates.get(index).size();
            for (int i = 0; i < len; i++) {
                temp[index] = candidates.get(index).get(i);
                fourSumCountDFS2(candidates, indexs, temp, index+1, res);
            }
        }
    }


    /**
     * 132 Pattern
     * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak< aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
     * Note: n will be less than 15,000.
     * Example 1:
     * Input: [1, 2, 3, 4]
     * Output: False
     * Explanation: There is no 132 pattern in the sequence.
     * Example 2:
     * Input: [3, 1, 4, 2]
     * Output: True
     * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
     * Example 3:
     * Input: [-1, 3, 2, 0]
     * Output: True
     * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
     */
    public static void find132patternDemo(int[] nums) {
        System.out.println("\nStart function find132patternDemo()");
        printArray(nums, "\tNums:");
        System.out.println("\tRes = " + find132pattern(nums));
    }
    private static class ArrayValIndex {
        int val;
        int index;
        ArrayValIndex(int v, int i) {
            val = v;
            index = i;
        }
    }
    public static boolean find132pattern(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int[] preMin = new int[len];
        Integer min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            preMin[i] = min;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j] && nums[i] > preMin[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    // This version is wrong for test case: [4, 5, 1, 3, 2]
    public static boolean find132pattern2(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int[] preMin = new int[len];
        Integer min = Integer.MAX_VALUE;
        Integer maxIndex = 0;

        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            preMin[i] = min;
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }

            if (nums[i] < nums[maxIndex] && nums[i] > preMin[maxIndex]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Assign Cookies
     * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
     * Note:
     * You may assume the greed factor is always positive. 
     * You cannot assign more than one cookie to one child.
     * Example 1:
     * Input: [1,2,3], [1,1]
     * Output: 1
     * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
     * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
     * You need to output 1.
     * Example 2:
     * Input: [1,2], [1,2,3]
     * Output: 2
     * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
     * You have 3 cookies and their sizes are big enough to gratify all of the children,
     * You need to output 2.
     */
    public static int findContentChildren(int[] g, int[] s) {
        System.out.println("\nStart function findContentChildren()");
        printArray(g, "\tG:");
        printArray(s, "\tS:");
        PriorityQueue<Integer> PG = new PriorityQueue<>(g.length, (a,b) -> b-a);
        PriorityQueue<Integer> PS = new PriorityQueue<>(g.length, (a,b) -> b-a);
        for (int i : g) PG.add(i);
        for (int j : s) PS.add(j);

        int count = 0;
        while (!PG.isEmpty() && !PS.isEmpty()) {
            if (PS.peek() < PG.peek()) {
                PG.poll();
            } else {
                count++;
                PG.poll();
                PS.poll();
            }
        }
        System.out.println("\tCount = " + count);
        return count;
    }

    /**
     * UTF-8 Validation
     * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
     *
     * For 1-byte character, the first bit is a 0, followed by its unicode code.
     * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
     * This is how the UTF-8 encoding would work:
     *
     *         Char. number range  |        UTF-8 octet sequence
     *            (hexadecimal)    |              (binary)
     *         --------------------+---------------------------------------------
     *         0000 0000-0000 007F | 0xxxxxxx
     *         0000 0080-0000 07FF | 110xxxxx 10xxxxxx
     *         0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
     *         0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
     *
     *         Note:
     * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
     *
     *         Example 1:
     *
     * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
     *
     * Return true.
     * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
     * Example 2:
     *
     * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
     *
     * Return false.
     * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
     * The next byte is a continuation byte which starts with 10 and that's correct.
     * But the second continuation byte does not start with 10, so it is invalid.
     */
    public static void validUtf8Demo(int[] data) {
        System.out.println("\nStart function validUtf8()");
        printArray(data, "\tData:");
        System.out.println("\tValid: " + validUtf8(data));
    }
    public static boolean validUtf8(int[] data) {
        int len = data.length;

        int i = 0;
        while (i < len) {
            int cur = data[i];
//            if ((cur & 0b10000000) == 0) {
            if ((cur & 0x80) == 0) {
                i++;
            } else {
                int n = countStartingOnes(cur);
                if (n >= 8 || n == 1) {
                    return false;
                } else if (n + i > len) {
                    return false;
                } else {
                    for (int j = 1; j <= n-1; j++) {
//                      if (((data[i+j] & 0b11000000) ^ 0b01000000) != 0b10000000) {
                        if (((data[i+j] & 0xC0) ^ 0x40) != 192) {
                            return false;
                        }
                    }
                    i += n;
                }
            }
        }
        return true;
    }
    private static int countStartingOnes(int num) {
        int n = 0;
        int t = num;
//        while ((t & 0b10000000) == 0b10000000) {
        while ((t & 0x80) == 128) {
            n++;
            t <<= 1;
        }
        return n;
    }

    /**
     * Kth Smallest Element in a Sorted Matrix
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     * Example:
     * matrix = [
     *         [ 1,  5,  9],
     *         [10, 11, 13],
     *         [12, 13, 15]
     *         ],
     * k = 8,
     *         return 13.
     */
    private static class PointWithVal {
        Integer i;
        Integer j;
        Integer val;
        PointWithVal(int x, int y, int v) {
            i = x;
            j = y;
            val = v;
        }
    }
    public static int kthSmallest(int[][] matrix, int k) {
        System.out.println("\nStart function kthSmallest(); k = " + k);
        printTwoDimentinalArray(matrix, "\tMatrix:");
        int R = matrix.length;
        int C = matrix[0].length;
        Boolean[][] visited = new Boolean[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], false);
        }
        HashSet<PointWithVal> S = new HashSet<>();
        S.add(new PointWithVal(0, 0, matrix[0][0]));
        visited[0][0] = true;
        int count = 1;
        int curVal = matrix[0][0];
        while (!S.isEmpty() && count <= k) {
            PointWithVal min = new PointWithVal(-1, -1, Integer.MAX_VALUE);
            for (PointWithVal pv : S) {
                if (pv.val < min.val) {
                    min = pv;
                    curVal = min.val;
                }
            }
            S.remove(min);
            if (count == k) {
                break;
            }
            count++;
            if (min.i + 1 < R && !visited[min.i + 1][min.j]) {
                S.add(new PointWithVal(min.i + 1, min.j, matrix[min.i + 1][min.j]));
                visited[min.i + 1][min.j] = true;
            }
            if (min.j + 1 < C && !visited[min.i][min.j + 1]) {
                S.add(new PointWithVal(min.i, min.j + 1, matrix[min.i][min.j + 1]));
                visited[min.i][min.j + 1] = true;
            }
        }
        System.out.println("\tkth element = " + curVal);
        return curVal;
    }
    // Better solution with PriorityQueue
    public static int kthSmallest2(int[][] matrix, int k) {
        System.out.println("\nStart function kthSmallest2(); k = " + k);
        printTwoDimentinalArray(matrix, "\tMatrix:");
        int R = matrix.length;
        int C = matrix[0].length;
        Boolean[][] visited = new Boolean[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], false);
        }
        PriorityQueue<PointWithVal> Q = new PriorityQueue<>((a, b) -> a.val - b.val);
        PointWithVal cur = new PointWithVal(0, 0, matrix[0][0]);
        Q.add(cur);
        visited[0][0] = true;
        int count = 1;
        while (!Q.isEmpty() && count <= k) {
            cur = Q.poll();
            if (count == k) {
                break;
            }
            count++;
            if (cur.i + 1 < R && !visited[cur.i + 1][cur.j]) {
                Q.add(new PointWithVal(cur.i + 1, cur.j, matrix[cur.i + 1][cur.j]));
                visited[cur.i + 1][cur.j] = true;
            }
            if (cur.j + 1 < C && !visited[cur.i][cur.j + 1]) {
                Q.add(new PointWithVal(cur.i, cur.j + 1, matrix[cur.i][cur.j + 1]));
                visited[cur.i][cur.j + 1] = true;
            }
        }
        System.out.println("\tkth element = " + cur.val);
        return cur.val;
    }

    /**
     * Intersection of Two Arrays
     * Given two arrays, write a function to compute their intersection.
     *         Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
     * Note:
     *         • Each element in the result must be unique.
     * The result can be in any order.
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }
        return res;
    }

    /**
     * Intersection of Two Arrays II
     * Given two arrays, write a function to compute their intersection.
     *         Example:
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
     * Note:
     *         • Each element in the result should appear as many times as it shows in both arrays.
     *         • The result can be in any order.
     * Follow up:
     *         • What if the given array is already sorted? How would you optimize your algorithm?
     *         • What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        LinkedList<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }
        return res;
    }

    /**
     * Top K Frequent Elements
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     *         For example,
     * Given [1,1,1,2,2,3] and k = 2, return [1,2].
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */
    private static class CountSet {
        Integer count;
        HashSet<Integer> set;
        CountSet(int c, HashSet<Integer> s) {
            count = c;
            set = s;
        }
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        System.out.println("\nStart function topKFrequent(); k = " + k);
        printArray(nums, "\tNums:");

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        HashMap<Integer, HashSet<Integer>> count2Set = new HashMap<>();
        for (Integer i : map.keySet()) {
            if (!count2Set.containsKey(map.get(i))) {
                HashSet<Integer> newSet = new HashSet<>();
                count2Set.put(map.get(i), newSet);
            }
            count2Set.get(map.get(i)).add(i);
        }
        PriorityQueue<CountSet> Q = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (Integer c : count2Set.keySet()) {
            Q.add(new CountSet(c, count2Set.get(c)));
        }

        List<Integer> res = new ArrayList<>();
        while (!Q.isEmpty() && res.size() < k) {
            CountSet cur = Q.poll();
            res.addAll(cur.set);
        }

        System.out.println("\tRes: " + res);
        System.out.println("\tTop K elements: " + res.subList(0, k));
        return res.subList(0, k);
    }

    /**
     * Find All Duplicates in an Array
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     * Find all the elements that appear twice in this array.
     * Could you do it without extra space and in O(n) runtime?
     * Example:
     * Input:
     *         [4,3,2,7,8,2,3,1]
     * Output:
     *         [2,3]
     */
    public static List<Integer> findDuplicates(int[] nums) {
        System.out.println("\nStart function topKFrequent()");
        printArray(nums, "\tNums:");

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i+1 && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
            System.out.println("\t\ti = " + i);
            printArray(nums);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                res.add(nums[i]);
            }
        }

        System.out.println("\tRes = " + res);
        return res;
    }

    /**
     * Find All Numbers Disappeared in an Array
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     *
     * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     *
     * Example:
     *
     * Input:
     *         [4,3,2,7,8,2,3,1]
     *
     * Output:
     *         [5,6]
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        System.out.println("\nStart function topKFrequent()");
        printArray(nums, "\tNums:");

        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i+1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                res.add(i+1);
            }
        }
        return res;
    }

    /**
     * Queue Reconstruction by Height
     * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
     *         Note:
     * The number of people is less than 1,100.
     * Example
     * Input:
     *         [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     * Output:
     *         [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    private static class PeopleOrder {
        int height;
        int preCount;
        PeopleOrder (int h, int p) {
            height = h;
            preCount = p;
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        System.out.println("\nStart function reconstructQueue()");
        printTwoDimentinalArray(people, "\tPeople");

        int len = people.length;
        ArrayList<PeopleOrder> ps = new ArrayList<>();
        for (int[] p : people) {
            ps.add(new PeopleOrder(p[0], p[1]));
        }
        ps.sort((a, b)-> a.height - b.height);
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = new int[]{-1, -1};
        }
//        // This version of init is wrong!!! Every row will point to the same memory
//        Arrays.fill(res, new int[]{-1, -1});

        for (PeopleOrder p : ps) {
            int h = p.height;
            int pre = p.preCount;
            int index;
            int preCount = pre;
            for (index = 0; index < len && preCount > 0; index++) {
                if (res[index][0] == -1) {
                    preCount--;
                } else if (res[index][0] >= h){
                    preCount--;
                }
            }
            while (res[index][0] != -1) {
                index++;
            }

            res[index][0] = h;
            res[index][1] = pre;
        }

        printTwoDimentinalArray(res, "\tRes");
        return res;
    }
    public static int[][] reconstructQueue2(int[][] people) {
        System.out.println("\nStart function reconstructQueue2()");
        printTwoDimentinalArray(people, "\tPeople");

        int len = people.length;
        Arrays.sort(people, (a, b) -> a[0] - b[0]);
        printTwoDimentinalArray(people, "\tPeople");
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = new int[]{-1, -1};
        }
        for (int[] p : people) {
            int h = p[0];
            int pre = p[1];
            int index;
            int preCount = pre;
            for (index = 0; index < len && preCount > 0; index++) {
                if (res[index][0] == -1) {
                    preCount--;
                } else if (res[index][0] >= h){
                    preCount--;
                }
            }
            while (res[index][0] != -1) {
                index++;
            }

            res[index][0] = h;
            res[index][1] = pre;
        }

        printTwoDimentinalArray(res, "\tRes");
        return res;
    }

    /**
     * Third Maximum Number
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
     * Example 1:
     * Input: [3, 2, 1]
     * Output: 1
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     * Output: 2
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     * Output: 1
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     */
    public static int thirdMax(int[] nums) {
        System.out.println("\nStart function thirdMax()");
        printArray(nums, "\tNums:");
        Integer n1 = null;
        Integer n2 = null;
        Integer n3 = null;
        for (int i : nums) {
            if (n1 == null || n1 < i) {
                n3 = n2;
                n2 = n1;
                n1 = i;
            } else if (n1 != i && (n2 == null || n2 < i)) {
                n3 = n2;
                n2 = i;
            } else if (n1 != i && n2 != i && (n3 == null || n3 < i)) {
                n3 = i;
            }
        }
        System.out.println("\tN1 = " + n1);
        System.out.println("\tN2 = " + n2);
        System.out.println("\tN3 = " + n3);
        return (n3 == null) ? n1 : n3;
    }

    /**
     * Arithmetic Slices
     * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
     * For example, these are arithmetic sequence:
     *         1, 3, 5, 7, 9
     *         7, 7, 7, 7
     *         3, -1, -5, -9
     * The following sequence is not arithmetic.
     *         1, 1, 2, 5, 7
     * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
     *         A slice (P, Q) of array A is called arithmetic if the sequence:
     * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
     * The function should return the number of arithmetic slices in the array A.
     *         Example:
     * A = [1, 2, 3, 4]
     *         return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     */
    public static int numberOfArithmeticSlices(int[] A) {
        System.out.println("\nStart function numberOfArithmeticSlices()");
        printArray(A, "\tA:");
        int len = A.length;
        if (len < 3) return 0;
        List<Integer> continuousCount = new ArrayList<>();
        int curDiff = A[1] - A[0];
        int curCount = 2;
        for (int i = 2; i < len; i++) {
            int diff = A[i] - A[i-1];
            if (diff == curDiff) {
                curCount++;
            } else {
                continuousCount.add(curCount);
                curCount = 2;
                curDiff = diff;
            }
        }
        if (curCount > 2) {
            continuousCount.add(curCount);
        }
        int total = 0;
        for (int i : continuousCount) {
            total += countOfArithmeticSlices(i);
        }
        System.out.println("\tRes = " + total);
        return total;
    }
    private static int countOfArithmeticSlices(int n) {
        int count = 0;
        for (int i = 1; i <= n-2; i++) {
            count += i;
        }
        return count;
    }

    public static int numberOfArithmeticSlicesII(int[] A) {
        System.out.println("\nStart function numberOfArithmeticSlicesII()");
        printArray(A, "\tA:");
        int len = A.length;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        HashMap<Integer, HashSet<Integer>> valToIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (valToIndex.containsKey(A[i])) {
                valToIndex.get(A[i]).add(i);
            } else {
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(i);
                valToIndex.put(A[i], newSet);
            }
            maxVal = Math.max(maxVal, A[i]);
            minVal = Math.min(minVal, A[i]);
        }
        int sum = 0;
        for (int i = 0; i < len-3; i++) {
            for (int j = i + 2; j < len; j++) {
                int diff = A[j] - A[i];
                int count = 2;
                int tempVal = A[i] + count * diff;
                HashMap<Integer, HashSet<Integer>> tempMap = (HashMap<Integer, HashSet<Integer>>)valToIndex.clone();
                while (tempVal <= maxVal && tempVal >= minVal && tempMap.containsKey(tempVal)) {
                    boolean updated = false;
                    for (int k : tempMap.get(tempVal)) {
                        if (k > j) {
                            tempMap.remove(tempVal);
                            count++;
                            tempVal = A[i] + count *diff;
                            updated = true;
                        }
                    }
//                    if (tempVal == A[i] + 2 * diff) {
                    if (!updated) {
                        break;
                    }
                }
                if (count >= 3) {
                    sum += countOfArithmeticSlices(count);
                }
            }
        }
        System.out.println("\tSum = " + sum);
        return sum;
    }

    public static int numberOfArithmeticSlicesII2(int[] A) {
        System.out.println("\nStart function numberOfArithmeticSlicesII2()");
        printArray(A, "\tA:");
        int len = A.length;
        ArrayList<HashMap<Integer, Integer>> idxToMap = new ArrayList<>();
        idxToMap.add(new HashMap<>());

        int res = 0;
        for (int i = 1; i < len; i++) {
            idxToMap.add(new HashMap<>());
            for (int j = 0; j < i; j++) {
                long diff = (long)A[i] - (long)A[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) continue;
                int d = (int)diff;

                if (!idxToMap.get(i).containsKey(d)) {
                    idxToMap.get(i).put(d, 0);
                }
                idxToMap.get(i).put(d, idxToMap.get(i).get(d) + 1);
                if (idxToMap.get(j).containsKey(d)) {
                    idxToMap.get(i).put(d, idxToMap.get(i).get(d) + idxToMap.get(j).get(d));
                    res += idxToMap.get(j).get(d);
                }
//                if (idxToMap.get(i).get(d) > 1) {
//                    res += idxToMap.get(i).get(d) - 1;
//                }
            }
        }

        System.out.println("\tRes = " + res);
        return res;
    }

    /**
     * Partition Equal Subset Sum
     * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
     *         Note:
     *         1. Each of the array element will not exceed 100.
     *         2. The array size will not exceed 200.
     * Example 1:
     * Input: [1, 5, 11, 5]
     * Output: true
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     * Example 2:
     * Input: [1, 2, 3, 5]
     * Output: false
     * Explanation: The array cannot be partitioned into equal sum subsets.
     */
    public static boolean canPartition(int[] num) {
        System.out.println("\nStart function canPartition()");
        printArray(num, "\tNum");
        Integer sum = 0;
        for (Integer i : num)
            sum += i;
        if (sum % 2 != 0) return false;
        Integer half = sum/2;
        int len = num.length;

        Integer [][] DP = new Integer [len+1][half+1];
        for (int i = 0; i <= len; i++)
            Arrays.fill(DP[i], 0);

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= half; j++) {
                if (num[i-1] > j)
                    DP[i][j] = DP[i-1][j];
                else
                    DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j-num[i-1]] + num[i-1]);
            }
        }

        // Used '==' instead of 'equals', which led to wrong answer
        //return DP[len][half] == half;
        return DP[len][half].equals(half);
    }

    /**
     * Number of Islands
     *
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * Example 1:
     *         11110
     *         11010
     *         11000
     *         00000
     * Answer: 1
     * Example 2:
     *         11000
     *         11000
     *         00100
     *         00011
     * Answer: 3
     */
    public int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int M = grid.length;
        if (M == 0) return 0;
        int N = grid[0].length;
        if (N == 0) return 0;

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != '0') {
                    count++;
                    pollute(grid, i, j, M, N);
                }
            }
        }
        return count;
    }
    private void pollute(char[][] grid, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        pollute(grid, i+1, j, M, N);
        pollute(grid, i-1, j, M, N);
        pollute(grid, i, j+1, M, N);
        pollute(grid, i, j-1, M, N);
    }
    // Better version
    public int numIslands2(char[][] grid) {
        if (grid == null) return 0;
        int M = grid.length;
        if (M == 0) return 0;
        int N = grid[0].length;
        if (N == 0) return 0;

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != '0') {
                    count++;
                    pollute2(grid, i, j, M, N, dirs);
                }
            }
        }
        return count;
    }
    private void pollute2(char[][] grid, int i, int j, int M, int N, int[][] dirs) {
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < M && y >= 0 && y < N && grid[x][y] != '0') {
                pollute2(grid, x, y, M, N, dirs);
            }
        }
    }

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        System.out.println("\nStart function numIslands2()");
        System.out.println("\tm = " + m + "; n = " + n);
        printTwoDimentinalArray(positions, "\tPositions");

        HashMap<Integer, HashSet<Point>> id2ps = new HashMap<>();
        HashMap<Point, Integer> p2id = new HashMap<>();
        HashSet<Point> used = new HashSet<>();

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        int id = 0;
        List<Integer> res = new ArrayList<>();
        for (int[] p : positions) {
            if (p[0] >= 0 && p[0] < m && p[1] >= 0 && p[1] < n) {
                Point newP = new Point(p[0], p[1]);
                if (!used.contains(newP)) {
                    HashSet<Integer> neighborIds = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = newP.i + dir[0];
                        int y = newP.j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            Point np = new Point(x, y);
                            if (p2id.containsKey(np)) {
                                neighborIds.add(p2id.get(np));
                            }
                        }
                    }
                    if (neighborIds.size() == 0) {
                        p2id.put(newP, id);
                        HashSet<Point> newS = new HashSet<>();
                        newS.add(newP);
                        id2ps.put(id, newS);
                        id++;
                    } else if (neighborIds.size() == 1) {
                        int nid = neighborIds.iterator().next();
                        p2id.put(newP, nid);
                        id2ps.get(nid).add(newP);
                    } else {
                        p2id.put(newP, id);
                        HashSet<Point> newSet = new HashSet<>();
                        newSet.add(newP);
                        for (int nid : neighborIds) {
                            for (Point np : id2ps.get(nid)) {
                                p2id.put(np, id);
                                newSet.add(np);
                            }
                            id2ps.remove(nid);
                        }
                        id2ps.put(id, newSet);
                        id++;
                    }
                    used.add(newP);
                }
//                HashSet<Integer> tmp = new HashSet<>();
//                for (int v : p2id.values()) {
//                    tmp.add(v);
//                }
//                res.add(tmp.size());
                res.add(id2ps.size());
            }
        }
        System.out.println("\tRes = " + res);
        return res;
    }
    public static List<Integer> numIslands2_2(int m, int n, int[][] positions) {
        System.out.println("\nStart function numIslands2_2()");
        System.out.println("\tm = " + m + "; n = " + n);
        printTwoDimentinalArray(positions, "\tPositions");

        Integer R = Math.max(m, n);

        HashMap<Integer, HashSet<Integer>> id2ps = new HashMap<>();
        HashMap<Integer, Integer> p2id = new HashMap<>();
        HashSet<Integer> used = new HashSet<>();

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        int id = 0;
        List<Integer> res = new ArrayList<>();
        for (int[] p : positions) {
            if (p[0] >= 0 && p[0] < m && p[1] >= 0 && p[1] < n) {
                Integer newP = p[0] * R + p[1];
                if (!used.contains(newP)) {
                    HashSet<Integer> neighborIds = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = newP/R + dir[0];
                        int y = newP%R + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            Integer np = x * R + y;
                            if (p2id.containsKey(np)) {
                                neighborIds.add(p2id.get(np));
                            }
                        }
                    }
                    if (neighborIds.size() == 0) {
                        p2id.put(newP, id);
                        HashSet<Integer> newS = new HashSet<>();
                        newS.add(newP);
                        id2ps.put(id, newS);
                        id++;
                    } else if (neighborIds.size() == 1) {
                        int nid = neighborIds.iterator().next();
                        p2id.put(newP, nid);
                        id2ps.get(nid).add(newP);
                    } else {
                        p2id.put(newP, id);
                        HashSet<Integer> newSet = new HashSet<>();
                        newSet.add(newP);
                        for (int nid : neighborIds) {
                            for (Integer np : id2ps.get(nid)) {
                                p2id.put(np, id);
                                newSet.add(np);
                            }
                            id2ps.remove(nid);
                        }
                        id2ps.put(id, newSet);
                        id++;
                    }
                    used.add(newP);
                }
                res.add(id2ps.size());
            }
        }
        System.out.println("\tRes = " + res);
        return res;
    }

    /**
     * Trapping Rain Water II
     * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
     *         Note:
     * Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
     * Example:
     * Given the following 3x6 height map:
     *     [
     *         [1,4,3,1,3,2],
     *         [3,2,1,3,2,4],
     *         [2,3,3,2,3,1]
     *     ]
     * Return 4.
     *
     * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
     *
     * After the rain, water are trapped between the blocks. The total volume of water trapped is 4.
     * https://leetcode.com/problems/trapping-rain-water-ii/
     */
    private static class PointWithHeight {
        int i;
        int j;
        int height;
        PointWithHeight (int x, int y, int h) {
            i = x;
            j = y;
            height = h;
        }
    }
    public static int trapRainWater(int[][] heightMap) {
        System.out.println("\nStart function trapRainWater()");
        printTwoDimentinalArray(heightMap, "\tHeightMap");
        int R = heightMap.length;
        if (R < 1) return 0;
        int C = heightMap[0].length;
        if (C < 1) return 0;
        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        PriorityQueue<PointWithHeight> Q = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R-1 || j == 0 || j == C-1) {
                    Q.add(new PointWithHeight(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        int volume = 0;
        Integer maxHeight = Integer.MIN_VALUE;
        while (!Q.isEmpty()) {
            PointWithHeight p = Q.poll();
            maxHeight = Math.max(maxHeight, p.height);
            for (int d = 0; d < 4; d++) {
                int i = p.i + dirs[d][0];
                int j = p.j + dirs[d][1];
                if (i < 0 || i >= R || j < 0 || j >= C || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                if (heightMap[i][j] < maxHeight) {
                    volume += (maxHeight - heightMap[i][j]);
                }
                Q.add(new PointWithHeight(i, j, heightMap[i][j]));
            }
        }
        System.out.println("\tVolume = " + volume);
        return volume;
    }
    // This version is wrong
    public static int trapRainWater2(int[][] heightMap) {
        System.out.println("\nStart function trapRainWater()");
        printTwoDimentinalArray(heightMap, "\tHeightMap");
        int R = heightMap.length;
        if (R < 1) return 0;
        int C = heightMap[0].length;
        if (C < 1) return 0;

        int[][] left = new int[R][C];
        int[][] right = new int[R][C];
        int[][] top = new int[R][C];
        int[][] down = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 1; j < C; j++) {
                left[i][j] = Math.max(left[i][j-1], heightMap[i][j-1]);
            }
            for (int j = C-2; j >= 0; j--) {
                right[i][j] = Math.max(right[i][j+1], heightMap[i][j+1]);
            }
        }
        for (int j = 0; j < C; j++) {
            for (int i = 1; i < R; i++) {
                top[i][j] = Math.max(top[i-1][j], heightMap[i-1][j]);
            }
            for (int i = R-2; i >= 0; i--) {
                down[i][j] = Math.max(down[i+1][j], heightMap[i+1][j]);
            }
        }
        int[][] minHs = new int[R][C];

        int volume = 0;
        for (int i = 1; i < R-1; i++) {
            for (int j = 1; j < C-1; j++) {
                int minH = Math.min(Math.min(left[i][j], right[i][j]), Math.min(top[i][j], down[i][j]));
                minHs[i][j] = minH;
                if (heightMap[i][j] < minH) {
                    volume += minH - heightMap[i][j];
                }
            }
        }
        printTwoDimentinalArray(left, "\tLeft");
        printTwoDimentinalArray(right, "\tRight");
        printTwoDimentinalArray(top, "\tTop");
        printTwoDimentinalArray(down, "\tDown");
        printTwoDimentinalArray(minHs, "\tMinH");
        System.out.println("\tVolume = " + volume);
        return volume;
    }

    /**
     * Pacific Atlantic Water Flow
     * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
     *         Note:
     *         1. The order of returned grid coordinates does not matter.
     * 2. Both m and n are less than 150.
     * Example:
     * Given the following 5x5 matrix:
     * Pacific ~   ~   ~   ~   ~
     *         ~  1   2   2   3  (5) *
     *         ~  3   2   3  (4) (4) *
     *         ~  2   4  (5)  3   1  *
     *         ~ (6) (7)  1   4   5  *
     *         ~ (5)  1   1   2   4  *
     *         *   *   *   *   * Atlantic
     * Return:
     *         [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     */
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        System.out.println("\nStart function pacificAtlantic()");
        printTwoDimentinalArray(matrix, "\tMatrix");

        List<int[]> res = new LinkedList<>();
        int R = matrix.length;
        if (R < 1) return res;
        int C = matrix[0].length;
        if (C < 1) return res;

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };
        Queue<Point> Q = new LinkedList<>();
        boolean[][] P = new boolean[R][C];
        boolean[][] A = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            Point p = new Point(i, 0);
            Q.add(p);
            P[i][0] = true;
        }
        for (int j = 1; j < C; j++) {
            Point p = new Point(0, j);
            Q.add(p);
            P[0][j] = true;
        }
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int[] dir : dirs) {
                int x = p.i + dir[0];
                int y = p.j + dir[1];
                if (x >= 0 && y >= 0 && x < R && y < C && !P[x][y] && matrix[x][y] >= matrix[p.i][p.j]) {
                    Point newP = new Point(x, y);
                    Q.add(newP);
                    P[x][y] = true;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            Point p = new Point(i, C-1);
            Q.add(p);
            A[i][C-1] = true;
            if (P[i][C-1]) {
                res.add(new int[]{i, C-1});
            }
        }
        for (int j = 0; j < C-1; j++) {
            Point p = new Point(R-1, j);
            Q.add(p);
            A[R-1][j] = true;
            if (P[R-1][j]) {
                res.add(new int[]{R-1, j});
            }
        }
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int[] dir : dirs) {
                int x = p.i + dir[0];
                int y = p.j + dir[1];
                if (x >= 0 && y >= 0 && x < R && y < C && !A[x][y] && matrix[x][y] >= matrix[p.i][p.j]) {
                    Point newP = new Point(x, y);
                    Q.add(newP);
                    A[x][y] = true;
                    if (P[x][y]) {
                        res.add(new int[]{x, y});
                    }
                }
            }
        }

        System.out.println("\tRes:");
        for (int[] r : res) {
            printArray(r);
        }
        return res;
    }
    // Wrong. Not quite sure why ...
    public static List<int[]> pacificAtlantic2(int[][] matrix) {
        System.out.println("\nStart function pacificAtlantic2()");
        printTwoDimentinalArray(matrix, "\tMatrix");

        List<int[]> res = new LinkedList<>();
        int R = matrix.length;
        if (R < 1) return res;
        int C = matrix[0].length;
        if (C < 1) return res;

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };
        Queue<Point> Q = new LinkedList<>();
        HashSet<Point> P = new HashSet<>();
        HashSet<Point> A = new HashSet<>();

        for (int i = 0; i < R; i++) {
            Point p = new Point(i, 0);
            P.add(p);
            Q.add(p);
        }
        for (int j = 1; j < C; j++) {
            Point p = new Point(0, j);
            P.add(p);
            Q.add(p);
        }
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int[] dir : dirs) {
                int x = p.i + dir[0];
                int y = p.j + dir[1];
                Point newP = new Point(x, y);
                if (x >= 0 && y >= 0 && x < R && y < C && !P.contains(newP) && matrix[x][y] >= matrix[p.i][p.j]) {
                    Q.add(newP);
                    P.add(newP);
                }
            }
        }
        for (int i = 0; i < R; i++) {
            Point p = new Point(i, C-1);
            Q.add(p);
            A.add(p);
            if (P.contains(p)) {
                res.add(new int[]{i, C-1});
            }
        }
        for (int j = 0; j < C-1; j++) {
            Point p = new Point(R-1, j);
            Q.add(p);
            A.add(p);
            if (P.contains(p)) {
                res.add(new int[]{R-1, j});
            }
        }
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int[] dir : dirs) {
                int x = p.i + dir[0];
                int y = p.j + dir[1];
                Point newP = new Point(x, y);
                if (x >= 0 && y >= 0 && x < R && y < C && !A.contains(newP) && matrix[x][y] >= matrix[p.i][p.j]) {
                    Q.add(newP);
                    A.add(newP);
                    if (P.contains(newP)) {
                        res.add(new int[]{x, y});
                    }
                }
            }
        }

        System.out.println("\tRes:");
        for (int[] r : res) {
            printArray(r);
        }
        return res;
    }

    /**
     * Non-overlapping Intervals
     * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     *         Note:
     *         1. You may assume the interval's end point is always bigger than its start point.
     *         2. Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
     * Example 1:
     * Input: [ [1,2], [2,3], [3,4], [1,3] ]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
     *         Example 2:
     * Input: [ [1,2], [1,2], [1,2] ]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     *         Example 3:
     * Input: [ [1,2], [2,3] ]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     */
    public static class Interval2 {
        int start;
        int end;
        public Interval2() { start = 0; end = 0; }
        public Interval2(int s, int e) { start = s; end = e; }
        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
    public static int eraseOverlapIntervals(Interval2[] intervals) {
        System.out.println("\nStart function eraseOverlapIntervals()");
        HashSet<Interval2> nonUsed = new HashSet<>();
        for (Interval2 inter : intervals) {
            nonUsed.add(inter);
        }
        Arrays.sort(intervals, (a,b) -> {
            if (a.start != b.start) return a.start - b.start;
            else return a.end - b.end;
        });
        printArray(intervals, "\tIntervals:");
        int maxL = 0;

        while (!nonUsed.isEmpty()) {
            List<Interval2> curList = new LinkedList<Interval2>();
            int index = 0;
            while (!nonUsed.contains(intervals[index])) {
                index++;
            }
            Interval2 cur = intervals[index];
            curList.add(cur);
            nonUsed.remove(cur);
            for (int i = index+1; i < intervals.length; i++) {
                if (!intervalCross(cur, intervals[i])) {
                    curList.add(intervals[i]);
                    nonUsed.remove(intervals[i]);
                    cur = intervals[i];
                }
            }
            cur = intervals[index];
            for (int i = index-1; i >= 0; i--) {
                if (!intervalCross(cur, intervals[i])) {
                    curList.add(intervals[i]);
                    nonUsed.remove(intervals[i]);
                    cur = intervals[i];
                }
            }
            if (curList.size() > maxL) {
                maxL = curList.size();
                System.out.println("\tcurList = " + curList);
            }
        }
        int minToBeRemoved = intervals.length - maxL;
        System.out.println("\tminToBeRemoved = " + minToBeRemoved);
        return minToBeRemoved;
    }
    private static boolean intervalCross(Interval2 i1, Interval2 i2) {
        if (i1.start > i2.start) return intervalCross(i2, i1);
        if (i1.end > i2.start) return true;
        else return false;
    }
    // Better solution
    public static int eraseOverlapIntervals2(Interval2[] intervals) {
        System.out.println("\nStart function eraseOverlapIntervals2()");
        Arrays.sort(intervals, (a,b) -> {
            if (a.start != b.start) return a.start - b.start;
            else return a.end - b.end;
        });
        printArray(intervals, "\tIntervals:");
        int res = 0;
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervalCross(intervals[last], intervals[i])) {
                res++;
                if (intervals[last].end > intervals[i].end) {
                    last = i;
                }
            } else {
                last = i;
            }
        }
        System.out.println("\tres = " + res);
        return res;
    }
    public static int eraseOverlapIntervals3(Interval2[] intervals) {
        System.out.println("\nStart function eraseOverlapIntervals3()");
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        printArray(intervals, "\tIntervals:");
        int res = 0;
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[last].end > intervals[i].start) {
                res++;
                if (intervals[last].end > intervals[i].end) {
                    last = i;
                }
            } else {
                last = i;
            }
        }
        System.out.println("\tres = " + res);
        return res;
    }

    /**
     * Find Right Interval
     * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
     * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
     * Note:
     *         1. You may assume the interval's end point is always bigger than its start point.
     *         2. You may assume none of these intervals have the same start point.
     * Example 1:
     * Input: [ [1,2] ]
     * Output: [-1]
     * Explanation: There is only one interval in the collection, so it outputs -1.
     * Example 2:
     * Input: [ [3,4], [2,3], [1,2] ]
     * Output: [-1, 0, 1]
     * Explanation: There is no satisfied "right" interval for [3,4].
     * For [2,3], the interval [3,4] has minimum-"right" start point;
     * For [1,2], the interval [2,3] has minimum-"right" start point.
     * Example 3:
     * Input: [ [1,4], [2,3], [3,4] ]
     * Output: [-1, 2, -1]
     * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
     * For [2,3], the interval [3,4] has minimum-"right" start point.
     */
    public static int[] findRightInterval(Interval2[] intervals) {
        System.out.println("\nStart function findRightInterval()");
        printArray(intervals, "\tIntervals:");
        int len = intervals.length;
        Interval2[] order = new Interval2[len];
        for (int i = 0; i < len; i++) {
            order[i] = new Interval2(intervals[i].start, i);
        }
        Arrays.sort(order, (a,b)-> a.start - b.start);
        printArray(order, "\torder:");

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = binarySearch(order, intervals[i].end);
        }

        printArray(res, "\tRes:");
        return res;
    }
    private static int binarySearch(Interval2[] order, int n) {
        int b = 0;
        int e = order.length - 1;
        while (b <= e) {
            int m = (b+e)/2;
            if (order[m].start == n) {
                return order[m].end;
            } else if (order[m].start > n) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }
        // Attention !!!
        while (e < order.length && order[e].start < n) {
            e++;
        }
        if (e < order.length) {
            return order[e].end;
        } else {
            return -1;
        }
    }
    public static int[] findRightInterval2(Interval2[] intervals) {
        System.out.println("\nStart function findRightInterval2()");
        printArray(intervals, "\tIntervals:");
        int len = intervals.length;
        int[][] start2Idx = new int[len][2];
        for (int i = 0; i < len; i++) {
            start2Idx[i][0] = intervals[i].start;
            start2Idx[i][1] = i;
        }
        Arrays.sort(start2Idx, (a, b) -> a[0] - b[0]);
        printTwoDimentinalArray(start2Idx, "\torder:");

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = binarySearch3(start2Idx, intervals[i].end);
        }
        printArray(res, "\tRes:");
        return res;
    }
    private static int binarySearch2(int[][] start2Idx, int val) {
        int len = start2Idx.length;
        int b = 0, e = len - 1;
        while (b <= e) {
            int m = (b + e) / 2;
            if (start2Idx[m][0] == val) {
                return start2Idx[m][1];
            } else if (start2Idx[m][0] > val) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }
        while (e < len && start2Idx[e][0] < val) {
            e++;
        }
        if (e < len) {
            return start2Idx[e][1];
        } else {
            return -1;
        }
    }
    public static int binarySearch3(int[][] start2Idx, int val) {
        int len = start2Idx.length;
        int lb = -1, ub = len;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (start2Idx[mid][0] < val) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1 == len ? -1 : start2Idx[lb+1][1];
    }
    /**
     * Minimum Moves to Equal Array Elements
     * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
     * Example:
     * Input:
     *         [1,2,3]
     * Output:
     *         3
     * Explanation:
     * Only three moves are needed (remember each move increments two elements):
     *         [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
     */
    public static int minMoves(int[] nums) {
        Integer min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        int sum = 0;
        for (int i : nums) {
            sum += (i - min);
        }
        return sum;
    }

    /**
     * Minimum Moves to Equal Array Elements II
     * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
     * You may assume the array's length is at most 10,000.
     * Example:
     * Input:
     *         [1,2,3]
     * Output:
     *         2
     * Explanation:
     * Only two moves are needed (remember each move increments or decrements one element):
     *         [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
     */
    // This version is wrong
    public static int minMoves2(int[] nums) {
        System.out.println("\nStart function minMoves2()");
        printArray(nums, "\tNums:");
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int average = sum/len;
        if (sum % len != 0) {
            int smaller = 0;
            int larger = 0;
            for (int i : nums) {
                if (i <= average) smaller++;
                if (i > average) larger++;
            }
            if (larger > smaller) {
                average++;
            }
        }

        int res = 0;
        for (int i : nums) {
            res += Math.abs(i - average);
        }
        System.out.println("\tAverage = " + average);
        System.out.println("\tminMoves = " + res);
        return res;
    }
    public static int minMoves2_2(int[] nums) {
        System.out.println("\nStart function minMoves2_2()");
        Arrays.sort(nums);
        printArray(nums, "\tNums:");

        Integer min = nums[0];
        int sum = 0;
        for (int i : nums) {
            sum += (i - min);
        }

        int average = min;
        int len = nums.length;
        int index = 0;
        while (index < len) {
            int nextStart = index + 1;
            while (nextStart < len && nums[nextStart] == nums[index]) {
                nextStart++;
            }
            if (nextStart < len) {
                int diff = nums[nextStart] - nums[index];
                int minus = (len - nextStart) * diff;
                int add = nextStart * diff;
                if (minus > add) {
                    sum = sum - minus + add;
                    average = nums[nextStart];
                } else {
                    break;
                }
            }
            index = nextStart;
        }
        System.out.println("\tAverage = " + average);
        System.out.println("\tminMoves = " + sum);
        return sum;
    }
    public static int minMoves2_3(int[] nums) {
        System.out.println("\nStart function minMoves2_3()");
        Arrays.sort(nums);
        printArray(nums, "\tNums:");

        int len = nums.length;
        int index = 0;

        while (index < len) {
            int nextStart = index + 1;
            while (nextStart < len && nums[nextStart] == nums[index]) {
                nextStart++;
            }
            if (nextStart < len) {
                int diff = nums[nextStart] - nums[index];
                int minus = diff * (len - nextStart);
                int add = diff * nextStart;
                if (minus <= add) {
                    break;
                }
            }
            index = nextStart;
        }
        index = index == len ? len - 1 : index;
        int sum = 0;
        for (int i : nums) {
            sum += Math.abs(nums[index] - i);
        }

        System.out.println("\tAverage = " + nums[index]);
        System.out.println("\tminMoves = " + sum);
        return sum;
    }

    /**
     * Minimum Number of Arrows to Burst Balloons
     * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
     * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xendbursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
     * Example:
     * Input:
     *         [[10,16], [2,8], [1,6], [7,12]]
     * Output:
     *         2
     * Explanation:
     * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
     */
    public static int findMinArrowShots(int[][] points) {
        System.out.println("\nStart function findMinArrowShots()");
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        printTwoDimentinalArray(points, "Points:");
        int len = points.length;
        if (len < 1) return 0;

        int res = 0;
        int[] curPoint = points[0];
        for (int i = 1; i < len; i++) {
            int[] point = points[i];
            if (point[0] > curPoint[1]) {
                res++;
                curPoint = point;
            } else {
                curPoint[1] = Math.min(point[1], curPoint[1]);
            }
        }
        res++;

        System.out.println("\tRes = " + res);
        return res;
    }

    /**
     * Number of Boomerangs
     * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
     * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
     * Example:
     * Input:
     *         [[0,0],[1,0],[2,0]]
     * Output:
     *         2
     * Explanation:
     * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
     */
    public static int numberOfBoomerangs(int[][] points) {
        System.out.println("\nStart function numberOfBoomerangs()");
        printTwoDimentinalArray(points, "Points:");
        int R = points.length;
        if (R < 1) return 0;

        int sum = 0;
        for (int i = 0; i < R; i++) {
            HashMap<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < R; j++) {
                if (j == i) continue;
                double dist = getDistance(points[i], points[j]);
                if (map.containsKey(dist)) {
                    map.put(dist, map.get(dist) + 1);
                } else {
                    map.put(dist, 1);
                }
            }
            for (double d : map.keySet()) {
                int count = map.get(d);
                if (map.get(d) >= 2) {
                    sum += count * (count-1);
                }
            }
        }
        System.out.println("\tSum = " + sum);
        return sum;
    }
    private static double getDistance(int[] p1, int[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    /**
     * Majority Element
     *
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     * You may assume that the array is non-empty and the majority element always exist in the array.
     */
    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int maj = nums[0];
        int count = 1;
        for (int i : nums) {
            if (maj == i) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                maj = i;
                count = 1;
            }
        }
        return maj;
    }

    /**
     * Majority Element II
     *
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
     * Hint:
     *         1. How many majority elements could it possibly have?
     * Do you have a better hint? Suggest it!
     */
    public static List<Integer> majorityElementII(int[] nums) {
        System.out.println("\nStart function majorityElementII()");
        printArray(nums, "\tNums:");
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        Integer m1 = null;
        Integer m2 = null;
        int c1 = 0, c2 = 0;
        for (int i : nums) {
            if ((m1 == null || c1 == 0) && (m2 == null || (m2 != null && i != m2))) {
                m1 = i;
                c1 = 1;
            } else if (m1 == i) {
                c1++;
            } else if (m2 == null || c2 == 0) {
                m2 = i;
                c2 = 1;
            } else if (m2 == i) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (i == m1) {
                c1++;
            } else if (i == m2) {
                c2++;
            }
        }

        if (c1 > len/3) res.add(m1);
        if (c2 > len/3) res.add(m2);

        System.out.println("\tRes: " + res);
        return res;
    }
    public static List<Integer> majorityElementII2(int[] nums) {
        System.out.println("\nStart function majorityElementII2()");
        printArray(nums, "\tNums:");
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, c1 = 0, c2 = 0;
        for (int i : nums) {
            if (i == m1) {
                c1++;
            } else if (i == m2) {
                c2++;
            } else if (c1 == 0) {
                m1 = i;
                c1++;
            } else if (c2 == 0) {
                m2 = i;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (i == m1) {
                c1++;
            } else if (i == m2) {
                c2++;
            }
        }

        if (c1 > len/3) res.add(m1);
        if (c2 > len/3) res.add(m2);
        System.out.println("\tRes: " + res);
        return res;
    }
    public static List<Integer> majorityElementII3(int[] nums) {
        System.out.println("\nStart function majorityElementII3()");
        printArray(nums, "\tNums:");
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        int m1 = -1;
        int m2 = -1;
        int c1 = 0;
        int c2 = 0;

        for (int i : nums) {
            if (c1 == 0 && m2 != i) {
                m1 = i;
                c1 = 1;
                continue;
            } else if (c2 == 0 && m1 != i) {
                m2 = i;
                c2 = 1;
                continue;
            }

            if (i == m1) {
                c1++;
            } else if (i == m2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (i == m1) {
                c1++;
            } else if (i == m2) {
                c2++;
            }
        }
        if (c1 > len/3) res.add(m1);
        if (c2 > len/3) res.add(m2);
        System.out.println("\tRes: " + res);
        return res;
    }

    /**
     * Majority Number III
     *
     * Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
     *
     * Find it.
     *
     * majorityNumber
     */
    public static List<Integer> majorityElementIII(int[] nums, int k) {
        System.out.println("\nStart function majorityElementIII(). K = " + k);
        printArray(nums, "\tNums:");

        List<Integer> res = new ArrayList<>();
        if (nums == null) return res;
        int len = nums.length;
        if (len < 1) return res;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
                if (map.size() >= k) {
                    removeZeroCount(map);
                }
            }
        }

        for (int n : map.keySet()) {
            map.put(n, 0);
        }
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
        }
        for (int n : map.keySet()) {
            if (map.get(n) > len/k) {
                res.add(n);
            }
        }
        System.out.println("\tRes: " + res);
        return res;
    }
    private static void removeZeroCount(HashMap<Integer, Integer> map) {
        for (int n : map.keySet()) {
            map.put(n, map.get(n) - 1);
        }
        //        while(iter.hasNext()) {
//           Map.Entry<Integer, Integer> entry = iter.next();
//            if (entry.getValue() == 0) {
//                iter.remove();
//            }
//        }
        map.entrySet().removeIf(entry -> entry.getValue() == 0);
    }

    /**
     * Split Array Largest Sum
     * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
     *
     * Note:
     * Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
     *
     * Examples:
     *
     * Input:
     * nums = [7,2,5,10,8]
     * m = 2
     *
     * Output:
     *         18
     *
     * Explanation:
     * There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8],
     * where the largest sum among the two subarrays is only 18.
     */
    // Works, but timed out
    // Optimal solution: http://www.cnblogs.com/grandyang/p/5933787.html
    public static int splitArray2(int[] nums, int m) {
        System.out.println("\nStart function splitArray()");
        printArray(nums, "Nums:");
        System.out.println("\tm = " + m);
        int len = nums.length;

        Integer[][] S = new Integer[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(S[i], 0);
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                S[i][j] = sum;
            }
        }
        printTwoDimentinalArray(S, "\tSums:");

        int maxSum = splitArrayHelper(S, 0, len-1, m);
        System.out.println("\tMaxSum = " + maxSum);
        return maxSum;
    }
    private static int splitArrayHelper(Integer[][] S, int start, int end, int m) {
        if (start > end || (end-start+1) < m) {
            return 0;
        }
        if (m == 1) {
            return S[start][end];
        }
        int globalMin = Integer.MAX_VALUE;
        int localMax = Integer.MIN_VALUE;
        for (int i = start + 1; i <= end; i++) {
            localMax = Math.max(S[start][i-1], splitArrayHelper(S, i, end, m-1));
            globalMin = Math.min(globalMin, localMax);
        }

        return globalMin;
    }
    // Optimal solution
    public static int splitArray(int[] nums, int m) {
        System.out.println("\nStart function splitArray()");
        printArray(nums, "Nums:");
        System.out.println("\tm = " + m);

        long left = 0, right = 0;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
//        while (left < right) {
        while (left <= right) {
            long mid = left + (right - left)/2;
            if (canSplit(nums, mid, m)) {
//                right = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("\tMaxSum = " + (int)left);
        return (int)left;
    }
    private static boolean canSplit(int[] nums, long mid, int m) {
        int cnt = 1;
        long curSum = 0;
        for (int n : nums) {
            curSum += n;
            if (curSum > mid) {
                curSum = n;
                cnt++;
                if (cnt > m) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 3Sum Smaller
     *
     * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
     *
     * For example, given nums = [-2, 0, 1, 3], and target = 2.
     *
     * Return 2. Because there are two triplets which sums are less than 2:
     *
     *         [-2, 0, 1]
     *         [-2, 0, 3]
     * Follow up:
     * Could you solve it in O(n2) runtime?
     */
    public static int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            int sum = target - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] < sum) {
                    res += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * Find Peak Element - Accepted
     *
     * A peak element is an element that is greater than its neighbors.
     * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * You may imagine that num[-1] = num[n] = -∞.
     * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
     */
    public static void findPeakElementDemo(int[] nums) {
        System.out.println("\nStart function findPeakElementDemo()");
        printArray(nums, "Nums:");
        int index = findPeakElement(nums);
        System.out.println("\tPeak index = " + index);
        System.out.println("\tPeak value = " + nums[index]);
    }
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int begin = 0;
        int end = nums.length - 1;

        while (begin < end) {
            int mid = begin + (end - begin)/2;
            if (nums[mid] < nums[mid + 1]) {
                begin = mid + 1;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[begin] > nums[end] ? begin : end;
    }
    public static int findPeakElement2(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int begin = 0;
        int end = nums.length - 1;

        while (begin + 1 < end) {
            int mid = begin + (end - begin)/2;
            if (nums[mid] < nums[mid + 1]) {
                begin = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return nums[begin] > nums[end] ? begin : end;
    }

    /**
     * Find the Duplicate Number
     *
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
     *
     * Note:
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     */
    public static int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high-low)/2;
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int t = 0;
        while (true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) {
                break;
            }
        }
        return slow;
    }

    /**
     * Sliding Window Maximum
     *
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     *
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     *
     *         Window position                Max
     *         ------------------------       -----
     *        [1  3  -1] -3  5  3  6  7       3
     *         1 [3  -1  -3] 5  3  6  7       3
     *         1  3 [-1  -3  5] 3  6  7       5
     *         1  3  -1 [-3  5  3] 6  7       5
     *         1  3  -1  -3 [5  3  6] 7       6
     *         1  3  -1  -3  5 [3  6  7]      7
     * Therefore, return the max sliding window as [3,3,5,5,6,7].
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        System.out.println("\nStart function maxSlidingWindow(). K = " + k);
        printArray(nums, "Nums:");
        int len = nums.length;
        if (k > len || len < 1) return new int[]{};

        int[] res = new int[len - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        int end = 0, start = 0;
        while (end < k) {
            if (map.containsKey(nums[end])) {
                map.put(nums[end], map.get(nums[end]) + 1);
            } else {
                map.put(nums[end], 1);
            }
            end++;
        }
        for (; end < len; end++) {
            res[start] = map.firstKey();
            map.put(nums[start], map.get(nums[start]) - 1);
            if (map.get(nums[start]) == 0) {
                map.remove(nums[start]);
            }
            start++;
            if (map.containsKey(nums[end])) {
                map.put(nums[end], map.get(nums[end]) + 1);
            } else {
                map.put(nums[end], 1);
            }
        }
        res[start] = map.firstKey();
        printArray(res, "Res:");
        return res;
    }

    /**
     * Sliding Window Median
     *
     * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
     *
     *         Examples:
     *         [2,3,4] , the median is 3
     *
     *         [2,3], the median is (2 + 3) / 2 = 2.5
     *
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
     *
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     *
     * Window position                Median
     * ---------------               -----
     *         [1  3  -1] -3  5  3  6  7       1
     *         1 [3  -1  -3] 5  3  6  7       -1
     *         1  3 [-1  -3  5] 3  6  7       -1
     *         1  3  -1 [-3  5  3] 6  7       3
     *         1  3  -1  -3 [5  3  6] 7       5
     *         1  3  -1  -3  5 [3  6  7]      6
     * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
     */
    public static double[] medianSlidingWindow(int[] nums, int k) {
        System.out.println("\nStart function medianSlidingWindow(). K = " + k);
        printArray(nums, "Nums:");
        int len = nums.length;
        if (k > len || len < 1) return new double[]{};

        double[] res = new double[len - k + 1];
        PriorityQueue<Long> upperhalf = new PriorityQueue<>((a, b) -> Long.compare(a, b));
        PriorityQueue<Long> lowerhalf = new PriorityQueue<>((a, b) -> -Long.compare(a, b));
        int end = 0, start = 0;
        while (end < k) {
            int val = nums[end];
            lowerhalf.add((long)val);
            end++;
        }
        rebalanceHeap(upperhalf, lowerhalf);
        for (; end < len; end++) {
            res[start] = getMedian(upperhalf, lowerhalf);
            if (lowerhalf.contains((long)nums[start])) {
                lowerhalf.remove((long)nums[start]);
            } else {
                upperhalf.remove((long)nums[start]);
            }
            start++;
            if (!upperhalf.isEmpty() && nums[end] >= upperhalf.peek()) {
                upperhalf.add((long)nums[end]);
            } else {
                lowerhalf.add((long)nums[end]);
            }
            rebalanceHeap(upperhalf, lowerhalf);
        }
        res[start] = getMedian(upperhalf, lowerhalf);
        printArray(res, "Res:");
        return res;
    }
    private static void rebalanceHeap(PriorityQueue<Long> upper, PriorityQueue<Long> lower) {
        while (upper.size() > lower.size()) {
            lower.add(upper.poll());
        }
        while (lower.size() > upper.size() + 1) {
            upper.add(lower.poll());
        }
    }
    private static double getMedian(PriorityQueue<Long> upper, PriorityQueue<Long> lower) {
        if (lower.isEmpty()) {
            return 0.0;
        }
        if (lower.size() == upper.size() + 1) {
            return (double)lower.peek();
        } else {
            return (double)(lower.peek() + upper.peek()) / 2.0;
        }
    }

    public static double[] medianSlidingWindow2(int[] nums, int k) {
        System.out.println("\nStart function medianSlidingWindow(). K = " + k);
        printArray(nums, "Nums:");
        int len = nums.length;
        if (k > len || len < 1) return new double[]{};

        double[] res = new double[len - k + 1];
        TreeMap<Long, Integer> upperhalf = new TreeMap<>((a, b) -> Long.compare(a, b));
        TreeMap<Long, Integer> lowerhalf = new TreeMap<>((a, b) -> -Long.compare(a, b));
        int end = 0, start = 0;
        while (end < k) {
            int val = nums[end];
            addToMap2(lowerhalf, val);
            end++;
        }
        rebalanceMaps2(upperhalf, lowerhalf);
        for (; end < len; end++) {
            res[start] = getMedian2(upperhalf, lowerhalf);
            if (lowerhalf.containsKey((long)nums[start])) {
                removeFromMap2(lowerhalf, nums[start]);
            } else {
                removeFromMap2(upperhalf, nums[start]);
            }
            start++;
            if (!upperhalf.isEmpty() && nums[end] >= upperhalf.firstKey()) {
                addToMap2(upperhalf, nums[end]);
            } else {
                addToMap2(lowerhalf, nums[end]);
            }
            rebalanceMaps2(upperhalf, lowerhalf);
        }
        res[start] = getMedian2(upperhalf, lowerhalf);
        printArray(res, "Res:");
        return res;
    }
    private static void addToMap2(TreeMap<Long, Integer> map, long val) {
        if (map.containsKey(val)) {
            map.put((long)val, map.get(val) + 1);
        } else {
            map.put((long)val, 1);
        }
    }
    private static void removeFromMap2(TreeMap<Long, Integer> map, long val) {
        if (map.containsKey(val)) {
            map.put(val, map.get(val) - 1);
        }
        if (map.containsKey(val) && map.get(val) == 0) {
            map.remove(val);
        }
    }
    private static void rebalanceMaps2(TreeMap<Long, Integer> upper, TreeMap<Long, Integer> lower) {
        int upperCount = 0;
        int lowerCount = 0;
        for (long k : upper.keySet()) upperCount += upper.get(k);
        for (long k : lower.keySet()) lowerCount += lower.get(k);

        while (upperCount > lowerCount) {
            addToMap2(lower, upper.firstKey());
            removeFromMap2(upper, upper.firstKey());
            upperCount--;
            lowerCount++;
        }
        while (lowerCount > upperCount + 1) {
            addToMap2(upper, lower.firstKey());
            removeFromMap2(lower, lower.firstKey());
            upperCount++;
            lowerCount--;
        }
    }
    private static double getMedian2(TreeMap<Long, Integer> upper, TreeMap<Long, Integer> lower) {
        if (lower.isEmpty()) {
            return 0.0;
        }
        int upperCount = 0;
        int lowerCount = 0;
        for (long k : upper.keySet()) upperCount += upper.get(k);
        for (long k : lower.keySet()) lowerCount += lower.get(k);

        if (lowerCount == upperCount + 1) {
            return (double)lower.firstKey();
        } else {
            return (double)(lower.firstKey() + upper.firstKey()) / 2.0;
        }
    }

    /**
     * Range Addition
     * Assume you have an array of length n initialized with all 0's and are given k update operations.
     * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
     * Return the modified array after all k operations were executed.
     *         Example:
     * Given:
     * length = 5,
     * updates = [
     *         [1,  3,  2],
     *         [2,  4,  3],
     *         [0,  2, -2]
     *         ]
     * Output:
     *         [-2, 0, 3, 5, 3]
     * Explanation:
     * Initial state:
     *         [ 0, 0, 0, 0, 0 ]
     * After applying operation [1, 3, 2]:
     *         [ 0, 2, 2, 2, 0 ]
     * After applying operation [2, 4, 3]:
     *         [ 0, 2, 5, 5, 3 ]
     * After applying operation [0, 2, -2]:
     *         [-2, 0, 3, 5, 3 ]
     * Hint:
     *         1. Thinking of using advanced data structures? You are thinking it too complicated.
     *         2. For each update operation, do you really need to update all elements between i and j?
     *         3. Update only the first and end element is sufficient.
     * The optimal time complexity is O(k + n) and uses O(1) extra space.
     */
    public static int[] getModifiedArray(int length, int[][] updates) {
        System.out.println("\nStart function getModifiedArray().");
        printTwoDimentinalArray(updates, "\tUpdates:");
        int[] res = new int[length + 1];
        for (int[] update : updates) {
            res[update[0]] = update[2];
            res[update[1] + 1] = -update[2];
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i-1];
        }
        int[] finalRes = Arrays.copyOfRange(res, 0, length);
        printArray(finalRes, "\tRes:");
        return finalRes;
    }

    /**
     * Optimal Account Balancing
     * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for 10.ThenlaterChrisgaveAlice10.ThenlaterChrisgaveAlice5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
     * Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
     * Note:
     *         1. A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
     *         2. Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
     *          
     * Example 1:
     * Input:
     *         [[0,1,10], [2,0,5]]
     * Output:
     *         2
     * Explanation:
     * Person #0 gave person #1 $10.
     *         Person #2 gave person #0 $5.
     * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
     *          
     * Example 2:
     * Input:
     *         [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
     * Output:
     *         1
     * Explanation:
     * Person #0 gave person #1 $10.
     *         Person #1 gave person #0 $1.
     *         Person #1 gave person #2 $5.
     *         Person #2 gave person #0 $5.
     *         Therefore, person #1 only need to give person #0 $4, and all debt is settled.
     */
    // This version is WRONG!!!
    public static int minTransfers(int[][] transactions) {
        System.out.println("\nStart function minTransfers().");
        printTwoDimentinalArray(transactions, "\tTransactions:");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            int a = trans[0];
            int b = trans[1];
            int m = trans[2];
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + m);
            } else {
                map.put(a, m);
            }
            if (map.containsKey(b)) {
                map.put(b, map.get(b) - m);
            } else {
                map.put(b, -m);
            }
        }

        TreeMap<Integer, Integer> negtives = new TreeMap<>((a, b) -> a - b);
        TreeMap<Integer, Integer> postives = new TreeMap<>((a, b) -> b - a);

        for (int v : map.values()) {
            if (v > 0) {
                incTreeMap(postives, v);
            } else if (v < 0) {
                incTreeMap(negtives, v);
            }
        }

        int steps = 0;
        while (!postives.isEmpty() && !negtives.isEmpty()) {
            steps++;
            int largest = postives.firstKey();
            int smallest = negtives.firstKey();
            if (negtives.containsKey(-largest)) {
                decTreeMap(postives, largest);
                decTreeMap(negtives, -largest);
            } else if (postives.containsKey(-smallest)) {
                decTreeMap(postives, -smallest);
                decTreeMap(negtives, smallest);
            } else {
                int sum = largest + smallest;
                decTreeMap(postives, largest);
                decTreeMap(negtives, smallest);

                if (sum > 0) {
                    incTreeMap(postives, sum);
                } else if (sum < 0) {
                    incTreeMap(negtives, sum);
                }
            }
        }

        System.out.println("\tRes: " + steps);
        return steps;
    }
    private static void incTreeMap(TreeMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
    private static void decTreeMap(TreeMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                map.remove(key);
            }
        }
    }
    public static int minTransfers2(int[][] transactions) {
        System.out.println("\nStart function minTransfers2().");
        printTwoDimentinalArray(transactions, "\tTransactions:");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            int a = trans[0];
            int b = trans[1];
            int m = trans[2];
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + m);
            } else {
                map.put(a, m);
            }
            if (map.containsKey(b)) {
                map.put(b, map.get(b) - m);
            } else {
                map.put(b, -m);
            }
        }

        ArrayList<Integer> nums = new ArrayList<>(map.values());

        int res = minTransfersDFS(nums, 0, 0);
        System.out.println("\tRes: " + res);
        return res;
    }
    private static int minTransfersDFS(ArrayList<Integer> nums, int cur, int steps) {
        int minSteps = Integer.MAX_VALUE;
        while (cur < nums.size() && nums.get(cur) == 0) ++cur;
        for (int i = cur + 1; i < nums.size(); i++) {
            if (nums.get(cur) * nums.get(i) < 0) {
                nums.set(i, nums.get(i) + nums.get(cur));
                minSteps = Math.min(minSteps, minTransfersDFS(nums, cur + 1, steps + 1));
                nums.set(i, nums.get(i) - nums.get(cur));
            }
        }
        return minSteps == Integer.MAX_VALUE ? steps : minSteps;
    }
//    private static int minTransfersDFS(ArrayList<Integer> nums, int cur, int steps) {
//        boolean valid = true;
//
//        int minSteps = Integer.MAX_VALUE;
//        while (cur < nums.size() && nums.get(cur) == 0) ++cur;
//        for (int i = cur; i < nums.size() - 1; i++) {
//            if (nums.get(i) != 0) {
//                valid = false;
//                for (int j = i + 1; j < nums.size(); j++) {
//                    int tmp = nums.get(j);
//                    nums.set(i, nums.get(i) + tmp);
//                    nums.set(j, 0);
//                    int tmpSteps;
////                    if (nums.get(i) == 0) {
//                    tmpSteps = minTransfersDFS(nums, i + 1, steps + 1);
////                    } else {
////                        tmpSteps = minTransfersDFS(nums, i, steps + 1);
////                    }
//                    minSteps = Math.min(minSteps, tmpSteps);
//                    nums.set(j, tmp);
//                    nums.set(i, nums.get(i) - tmp);
//                    if (minSteps == steps + 1) {
//                        return minSteps;
//                    }
//                }
//            }
//        }
//        if (valid) {
//            return steps;
//        } else {
//            return minSteps;
//        }
//    }

    /**
     * Russian Doll Envelopes
     *
     * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
     *
     * What is the maximum number of envelopes can you Russian doll? (put one inside other)
     *
     * Example:
     * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        int[] DP = new int[len];

        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        Arrays.fill(DP, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            max = Math.max(max, DP[i]);
        }
        return max;
    }

    /**
     * Max Sum of Rectangle No Larger Than K
     * Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.
     *         Example:
     * Given matrix = [
     *         [1,  0, 1],
     *         [0, -2, 3]
     *         ]
     * k = 2
     * The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
     * Note:
     *         1. The rectangle inside the matrix must have an area > 0.
     * What if the number of rows is much larger than the number of columns?
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null) return 0;
        int R = matrix.length;
        if (R < 1) return 0;
        int C = matrix[0].length;
        if (C < 1) return 0;

        int res = Integer.MIN_VALUE;
        int[][] sum = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum[i][j] = matrix[i][j];
                if (i > 0) {
                    sum[i][j] += sum[i-1][j];
                }
                if (j > 0) {
                    sum[i][j] += sum[i][j-1];
                }
                if (i > 0  && j > 0) {
                    sum[i][j] -= sum[i-1][j-1];
                }

                for (int r = 0; r <= i; r++) {
                    for (int c = 0; c <= j; c++) {
                        int d = sum[i][j];
                        if (r > 0) d -= sum[r-1][j];
                        if (c > 0) d -= sum[i][c-1];
                        if (r > 0 && c > 0) d += sum[r-1][c-1];
                        if (d <= k) {
                            res = Math.max(res, d);
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * Maximum Gap
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
     *
     * Try to solve it in linear time/space.
     *
     *         Return 0 if the array contains less than 2 elements.
     *
     * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
     *
     * Bucket Sort
     */
    public static int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int size = (max - min)/len + 1;
        int bucketSize = (max - min) / size + 1;
        int[] bucketMin = new int[bucketSize];
        int[] bucketMax = new int[bucketSize];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        HashSet<Integer> nonEmptyBucket = new HashSet<>();

        for (int n : nums) {
            int index = (n-min)/size;
            bucketMax[index] = Math.max(bucketMax[index], n);
            bucketMin[index] = Math.min(bucketMin[index], n);
            nonEmptyBucket.add(index);
        }
        int pre = 0;
        int res = 0;
        for (int i = 1; i < bucketSize; i++) {
            if (nonEmptyBucket.contains(i)) {
                res = Math.max(res, bucketMin[i] - bucketMax[pre]);
                pre = i;
            }
        }
        return res;
    }

    /**
     * Shortest Word Distance 最短单词距离
     *
     * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
     *
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     *
     * Given word1 = “coding”, word2 = “practice”, return 3.
     * Given word1 = "makes", word2 = "coding", return 1.
     *
     * Note:
     * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
     */
    public static int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                idx1 = i;
            }
            if (words[i].equals(word2)) {
                idx2 = i;
            }
            if (idx1 != -1 && idx2 != -1) {
                res = Math.min(res, Math.abs(idx1 - idx2));
            }
        }
        return res;
    }

    public static int shortestDistance2(String[] words, String word1, String word2) {
        int idx = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (idx != -1 && !words[idx].equals(words[i])) {
                    res = Math.min(res, Math.abs(i - idx));
                }
                idx = i;
            }
        }
        return res;
    }

    /** Shortest Word Distance III 最短单词距离之三
     *
     * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
     *
     * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
     *
     * word1 and word2 may be the same and they represent two individual words in the list.
     *
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     *
     * Given word1 = “makes”, word2 = “coding”, return 1.
     * Given word1 = "makes", word2 = "makes", return 3.
     *
     * Note:
     * You may assume word1 and word2 are both in the list.
     */
    public static int shortestWordDistanceIII(String[] words, String word1, String word2) {
        int idx = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (idx != -1 && (word1.equals(word2) || !words[idx].equals(words[i]))) {
                    res = Math.min(res, Math.abs(i - idx));
                }
                idx = i;
            }
        }
        return res;
    }

    /**
     * Meeting Rooms
     *
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     *
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     *         return false.
     */
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a,b)-> a.start - b.start);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }

    /**
     * Meeting Rooms II 会议室之二
     *
     *
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     *
     * For example,
     * Given [[0, 30],[5, 10],[15, 20]],
     *         return 2.
     */
    public static int minMeetingRooms(int[][] intervals) {
        System.out.println("\nStart function minMeetingRooms().");
        printTwoDimentinalArray(intervals, "\tIntervals:");

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> Q = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int start = interval[0];
            while (!Q.isEmpty() && Q.peek() <= start) {
                Q.poll();
            }
            Q.add(interval[1]);

            max = Math.max(max, Q.size());
        }

        System.out.println("\tMax = " + max);
        return max;
    }

    public static int minMeetingRooms2(int[][] intervals) {
        System.out.println("\nStart function minMeetingRooms2().");
        printTwoDimentinalArray(intervals, "\tIntervals:");

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (map.containsKey(start)) {
                map.put(start, map.get(start) + 1);
            } else {
                map.put(start, 1);
            }
            if (map.containsKey(end)) {
                map.put(end, map.get(end) - 1);
            } else {
                map.put(end, -1);
            }
        }

        int tmp = 0;
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            tmp += map.get(key);
            max = Math.max(max, tmp);
        }

        System.out.println("\tMax = " + max);
        return max;
    }
    public static int minMeetingRooms3(int[][] intervals) {
        System.out.println("\nStart function minMeetingRooms3().");
        printTwoDimentinalArray(intervals, "\tIntervals:");

        PriorityQueue<Integer> starts = new PriorityQueue<>();
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (int[] inter : intervals) {
            starts.add(inter[0]);
            ends.add(inter[1]);
        }
        int res = 0;
        int cnt = 0;
        while (!starts.isEmpty()) {
            if (starts.peek() < ends.peek()) {
                cnt++;
                starts.poll();
            } else {
                cnt--;
                ends.poll();
            }
            res = Math.max(res, cnt);
        }
        System.out.println("\tMax = " + res);
        return res;
    }

    /**
     * Sparse Matrix Multiplication
     * Given two sparse matrices A and B, return the result of AB.
     *
     * You may assume that A's column number is equal to B's row number.
     *         Example:
     *
     * A = [
     *         [ 1, 0, 0],
     *         [-1, 0, 3]
     *     ]
     *
     * B = [
     *         [ 7, 0, 0 ],
     *         [ 0, 0, 0 ],
     *         [ 0, 0, 1 ]
     *     ]
     *
     *         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
     * AB =    | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
     *         |  0 0 1 |
     */
    public static int[][] multiply(int[][] A, int[][] B) {
        System.out.println("\nStart function multiply().");
        printTwoDimentinalArray(A, "\tA:");
        printTwoDimentinalArray(B, "\tB:");

        int R1 = A.length;
        int C1 = A[0].length;
        int R2 = B.length;
        int C2 = B[0].length;

        assert C1 == R2;

        int[][] res = new int[R1][C2];

        for (int i = 0; i < R1; i++) {
            for (int j = 0; j < C2; j++) {
                int sum = 0;
                for (int h = 0; h < C1; h++) {
                    sum += A[i][h] * B[h][j];
                }
                res[i][j] = sum;
            }
        }
        printTwoDimentinalArray(res, "\tRes:");
        return res;
    }
    public static int[][] multiply2(int[][] A, int[][] B) {
        System.out.println("\nStart function multiply().");
        printTwoDimentinalArray(A, "\tA:");
        printTwoDimentinalArray(B, "\tB:");

        int R1 = A.length;
        int C1 = A[0].length;
        int R2 = B.length;
        int C2 = B[0].length;

        assert C1 == R2;

        int[][] res = new int[R1][C2];

        for (int i = 0; i < R1; i++) {
            for (int h = 0; h < C1; h++) {
                if (A[i][h] != 0) {
                    for (int j = 0; j < C2; j++) {
                        if (B[h][j] != 0) {
                            res[i][j] += A[i][h] * B[h][j];
                        }
                    }
                }
            }
        }
        printTwoDimentinalArray(res, "\tRes:");
        return res;
    }

    /**
     * Missing Ranges
     * Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
     * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
     */
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        System.out.println("\nStart function findMissingRanges().");
        printArray(nums, "\tNum:");
        System.out.println("\tLower = " + lower);
        System.out.println("\tUpper = " + upper);

        List<String> res = new ArrayList<>();
        // LONG !!!
        Long pre = (long)lower;
        for (int n : nums) {
            if (n >= lower && n <= upper) {
                // LONG !!!
                Long curEnd = (long)n - 1;

                if (curEnd == pre) {
                    res.add(curEnd + "");
                } else if (curEnd > pre) {
                    res.add(pre + "->" + curEnd);
                }
                pre = (long)n + 1;
            }
        }
        if (pre < upper) {
            res.add(pre + "->" + upper);
        } else if (pre == upper) {
            res.add(upper + "");
        }

        System.out.println("\tRes = " + res);
        return res;
    }

    public static int minTotalDistance(int[][] grid) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        Collections.sort(rows);
        Collections.sort(cols);
        int i = 0, j = rows.size() - 1;
        int sum = 0;
        while (i < j) {
            sum += rows.get(j) - rows.get(i) + cols.get(j--) - cols.get(i++);
        }
        return sum;
    }

    /**
     * Paint House
     * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
     * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
     * Note:
     * All costs are positive integers.
     */
    public static int minCost(int[][] costs) {
        if (costs == null) return 0;
        int R = costs.length;
        if (R < 1) return 0;
        int C = costs[0].length;
        assert C == 3;
        int[][] DP = new int[R][3];
        DP[0][0] = costs[0][0];
        DP[0][1] = costs[0][1];
        DP[0][2] = costs[0][2];

        for (int i = 1; i < R; i++) {
            DP[i][0] = Math.min(DP[i-1][1], DP[i-1][2]) + costs[i][0];
            DP[i][1] = Math.min(DP[i-1][0], DP[i-1][2]) + costs[i][1];
            DP[i][2] = Math.min(DP[i-1][0], DP[i-1][1]) + costs[i][2];
        }

        return Math.min(DP[R-1][0], Math.min(DP[R-1][1], DP[R-1][2]));
    }

    /**
     * Paint House II
     * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
     * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
     * Note:
     * All costs are positive integers.
     */
    public static int minCostII(int[][] costs) {
        System.out.println("\nStart function minCostII().");
        printTwoDimentinalArray(costs, "\tCosts:");

        if (costs == null) return 0;
        int R = costs.length;
        if (R < 1) return 0;
        int C = costs[0].length;
        if (C < 1) return 0;

        long min1 = 0;
        long min2 = 0;
        int idx1 = -1;

        for (int i = 0; i < R; i++) {
            long last1 = min1;
            long last2 = min2;
            int lastIdx1 = idx1;
            min1 = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;

            for (int j = 0; j < C; j++) {
                long cost = costs[i][j] + ((lastIdx1 == j) ? last2 : last1);
                if (cost < min1) {
                    min2 = min1; // Attention!!!
                    min1 = cost;
                    idx1 = j;
                } else if (cost < min2) {
                    min2 = cost;
                }
            }
        }

        System.out.println("\tMinCost = " + min1);
        return (int)min1;
    }

    /**
     * Paint Fence
     * There is a fence with n posts, each post can be painted with one of the k colors.
     * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
     * Return the total number of ways you can paint the fence.
     *         Note:
     * n and k are non-negative integers.
     */
    public static int numWays(int n, int k) {
        System.out.println("\nStart function numWays().");
        System.out.println("\tN = " + n + "; k = " + k);
        if (n == 0) return 0;
        int same = 0, diff = k, res = same + diff;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = res * (k - 1);
            res = same + diff;
        }
        System.out.println("\tRes = " + res);
        return res;
    }
    public static int numWays2(int n, int k) {
        System.out.println("\nStart function numWays2().");
        System.out.println("\tN = " + n + "; k = " + k);
        if (n == 0) return 0;
        int[] DP = new int[n];
        DP[0] = k;
        for (int i = 1; i < n; i++) {
            DP[i] = DP[i-1] + DP[i-1] * (k-1);
        }
        System.out.println("\tRes = " + DP[n-1]);
        return DP[n-1];
    }

    /**
     * Walls and Gates
     * You are given a m x n 2D grid initialized with these three possible values.
     *  1. -1  - A wall or an obstacle.
     *  2. 0   - A gate.
     *  3. INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
     * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
     * For example, given the 2D grid:
     * INF  -1  0  INF
     * INF INF INF  -1
     * INF  -1 INF  -1
     *         0  -1 INF INF
     * After running your function, the 2D grid should be:
     *         3  -1   0   1
     *         2   2   1  -1
     *         1  -1   2  -1
     *         0  -1   3   4
     */
    public static void wallsAndGates(int[][] rooms) {
        System.out.println("\nStart function wallsAndGates()");
        printTwoDimentinalArray(rooms, "\tRooms:");
        int R = rooms.length;
        if (R < 1) return;
        int C = rooms[0].length;
        if (C < 1) return;

        int[][] dirs = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        Queue<Integer[]> Q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rooms[i][j] == 0) {
                    Q.add(new Integer[]{i, j});
                }
            }
        }

        while (!Q.isEmpty()) {
            Integer[] cur = Q.poll();
            int val = rooms[cur[0]][cur[1]];
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < R && y >= 0 && y < C && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = val + 1;
                    Q.add(new Integer[]{x, y});
                }
            }
        }
        printTwoDimentinalArray(rooms, "\tRooms:");
    }

    /**
     * Shortest Distance from All Buildings
     * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
     *         • Each 0 marks an empty land which you can pass by freely.
     *         • Each 1 marks a building which you cannot pass through.
     *         • Each 2 marks an obstacle which you cannot pass through.
     * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
     *         1 - 0 - 2 - 0 - 1
     *         |   |   |   |   |
     *         0 - 0 - 0 - 0 - 0
     *         |   |   |   |   |
     *         0 - 0 - 1 - 0 - 0
     * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
     * Note:
     * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
     */
    public static void shortestDistanceDemo(int[][] grid) {
        System.out.println("\nStart function shortestDistanceDemo()");
        printTwoDimentinalArray(grid, "\tGrid:");
        System.out.println("\tRes = " + shortestDistance(grid));
    }
    public static int shortestDistance(int[][] grid) {
        int R = grid.length;
        if (R < 1) return -1;
        int C = grid[0].length;
        if (C < 1) return -1;

//        int[][] sum = copyOfArray(grid);
        int[][] sum = new int[R][C];
        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        int val = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
//                    int[][] dist = copyOfArray(grid);
                    int[][] dist = new int[R][C];

                    Queue<int[]> Q = new LinkedList<>();
                    Q.add(new int[]{i, j});
                    while (!Q.isEmpty()) {
                        int[] cur = Q.poll();
                        for (int[] dir : dirs) {
                            int x = cur[0] + dir[0];
                            int y = cur[1] + dir[1];
                            if (x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == val) {
                                grid[x][y]--;
                                dist[x][y] = dist[cur[0]][cur[1]] + 1;
//                                sum[x][y] += dist[x][y] - 1;
                                sum[x][y] += dist[x][y];
                                Q.add(new int[]{x, y});
                            }
                        }
                    }
                    val--;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == val) {
                    res = Math.min(res, sum[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static int[][] copyOfArray(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;

        int[][] copy = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }


    /**
     * Bomb Enemy
     * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
     * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
     * Note that you can only put the bomb at an empty cell.
     * Example:
     * For the given grid
0 E  * 0 0
     * E 0 W E
0 E  * 0 0
     *         return 3. (Placing a bomb at (1,1) kills 3 enemies)
     */
    public int maxKilledEnemies(char[][] grid) {
        int R = grid.length;
        if (R < 1) return 0;
        int C = grid[0].length;
        if (C < 1) return 0;

        int res = 0;
        int rowCnt = 0;
        int[] colCnt = new int[C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rowCnt = 0;
                    for (int k = j; k < C && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            rowCnt++;
                        }
                    }
                }

                if (i == 0 || grid[i-1][j] == 'W') {
                    colCnt[j] = 0;
                    for (int k = i; k < R && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            colCnt[j]++;
                        }
                    }
                }

                if (grid[i][j] == '0') {
                    res = Math.max(res, rowCnt + colCnt[j]);
                }
            }
        }
        return res;
    }
    public int maxKilledEnemies2(char[][] grid) {
        int R = grid.length;
        if (R < 1) return 0;
        int C = grid[0].length;
        if (C < 1) return 0;

        int[][] l2r = new int[R][C];
        int[][] r2l = new int[R][C];
        int[][] t2d = new int[R][C];
        int[][] d2t = new int[R][C];

        for (int i = 0; i < R; i++) {
            l2r[i][0] = grid[i][0] == 'E' ? 1 : 0;
            for (int j = 1; j < C; j++) {
                if (grid[i][j] == 'W') {
                    l2r[i][j] = 0;
                    continue;
                }
                l2r[i][j] = l2r[i][j-1];
                if (grid[i][j] == 'E') {
                    l2r[i][j]++;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            r2l[i][C-1] = grid[i][C-1] == 'E' ? 1 : 0;
            for (int j = C-2; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    r2l[i][j] = 0;
                    continue;
                }
                r2l[i][j] = r2l[i][j+1];
                if (grid[i][j] == 'E') {
                    r2l[i][j]++;
                }
            }
        }
        for (int j = 0; j < C; j++) {
            t2d[0][j] = grid[0][j] == 'E' ? 1 : 0;
            for (int i = 1; i < R; i++) {
                if (grid[i][j] == 'W') {
                    t2d[i][j] = 0;
                    continue;
                }
                t2d[i][j] = t2d[i-1][j];
                if (grid[i][j] == 'E') {
                    t2d[i][j]++;
                }
            }
        }
        for (int j = 0; j < C; j++) {
            d2t[R-1][j] = grid[R-1][j] == 'E' ? 1 : 0;
            for (int i = R-2; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    d2t[i][j] = 0;
                    continue;
                }
                d2t[i][j] = d2t[i+1][j];
                if (grid[i][j] == 'E') {
                    d2t[i][j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, l2r[i][j] + r2l[i][j] + t2d[i][j] + d2t[i][j]);
                }
            }
        }
        return res;
    }

    /**
     * Max Consecutive Ones II
     * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
     * Example 1:
     * Input: [1,0,1,1,0]
     * Output: 4
     * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
     * After flipping, the maximum number of consecutive 1s is 4.
     * Note:
     *         • The input array will only contain 0 and 1.
     *         • The length of input array is a positive integer and will not exceed 10,000
     * Follow up:
     * What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
         if (len < 1) return 0;

        int res = 0;
        for (int i = 0, start = 0, pre = -1; i < len; i++) {
            if (nums[i] == 0) {
                if (pre == -1) {
                    pre = i;
                } else {
                    start = pre + 1;
                    pre = i;
                }
            }
            res = Math.max(res, (i - start + 1));
        }
        return res;
    }
    public int findMaxConsecutiveOnes2(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;

        int res = 0;
        for (int i = 0, start = 0, pre = -1; i < len; i++) {
            if (nums[i] == 0) {
                if (pre != -1) {
                    start = pre + 1;
                }
                pre = i;
            }
            res = Math.max(res, (i - start + 1));
        }
        return res;
    }

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        int[] res = new int[len];

        int idx = a >= 0 ? len - 1 : 0;
        int i = 0, j = len - 1;
        while (i <= j) {
            if (a >= 0) {
                res[idx--] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ? cal(nums[i++], a, b, c) : cal(nums[j--], a, b, c);
            } else {
                res[idx++] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ? cal(nums[j--], a, b, c) : cal(nums[i++], a, b, c);
            }
        }
        return res;
    }
    private static int cal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    /**
     * Android Unlock Patterns
     * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
     *         Rules for a valid pattern:
     *         1. Each pattern must connect at least m keys and at most n keys.
     *         2. All the keys must be distinct.
     *         3. If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
     *         4. The order of keys used matters.
     *
     * Explanation:
     *         | 1 | 2 | 3 |
     *         | 4 | 5 | 6 |
     *         | 7 | 8 | 9 |
     * Invalid move: 4 - 1 - 3 - 6 
     * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
     * Invalid move: 4 - 1 - 9 - 2
     * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
     * Valid move: 2 - 4 - 1 - 3 - 6
     * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
     * Valid move: 6 - 5 - 4 - 1 - 9 - 2
     * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
     *         Example:
     * Given m = 1, n = 1, return 9.
     */
    public static int numberOfPatterns(int m, int n) {
        System.out.println("\nStart function numberOfPatterns()");
        System.out.println("\tM = " + m + "; N = " + n);

        if (m < 1 || n < 1 || m > 9 || n > 9 || m > n) {
            return 0;
        }

        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            LinkedList<Integer> tmp = new LinkedList<>();
            HashSet<Integer> used = new HashSet<>();
            used.add(i);
            tmp.add(i);
            numberOfPatternsDFS(tmp, used, m , n, res);
            tmp.removeLast();
            used.remove(i);
        }

        for (List<Integer> r : res) {
            System.out.println("\t" + r);
        }
        System.out.println("\tRes = " + res.size());
        return res.size();
    }
    private static void numberOfPatternsDFS(LinkedList<Integer> tmp, HashSet<Integer> used, int m, int n, ArrayList<LinkedList<Integer>> res) {
        int len = tmp.size();
        if (len >= m && len <= n) {
            res.add(new LinkedList<>(tmp));
        }
        if (len >= n) {
            return;
        }
        int last = tmp.getLast();
        for (int i = 1; i <= 9; i++) {
            if (used.contains(i)) {
                continue;
            }
            int pi = (last-1) / 3;
            int pj = (last-1) % 3;
            int ci = (i-1) / 3;
            int cj = (i-1) % 3;
            int mid = (i + last)/2;
            if (Math.abs(pi - ci)%2 == 0 && Math.abs(pj - cj)%2 == 0 && !used.contains(mid)) {
                continue;
            }
            tmp.add(i);
            used.add(i);
            numberOfPatternsDFS(tmp, used, m , n, res);
            used.remove(i);
            tmp.removeLast();
        }
    }
    public static int numberOfPatterns2(int m, int n) {
        System.out.println("\nStart function numberOfPatterns()");
        System.out.println("\tM = " + m + "; N = " + n);

        if (m < 1 || n < 1 || m > 9 || n > 9 || m > n) {
            return 0;
        }

        int[] nums = new int[]{1,2};
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        for (int i : nums) {
            LinkedList<Integer> tmp = new LinkedList<>();
            HashSet<Integer> used = new HashSet<>();
            used.add(i);
            tmp.add(i);
            numberOfPatternsDFS(tmp, used, m , n, res);
            tmp.removeLast();
            used.remove(i);
        }
        int cnt = res.size() * 4;
        res.clear();
        LinkedList<Integer> tmp = new LinkedList<>();
        HashSet<Integer> used = new HashSet<>();
        used.add(5);
        tmp.add(5);
        numberOfPatternsDFS(tmp, used, m , n, res);
        tmp.removeLast();
        used.remove(5);

        cnt += res.size();
//        for (List<Integer> r : res) {
//            System.out.println("\t" + r);
//        }
        System.out.println("\tRes = " + cnt);
        return cnt;
    }


    public static void isReflectedDemo(int[][] points) {
        System.out.println("\nStart function numberOfPatterns()");
        printTwoDimentinalArray(points, "\tPoints:");
        System.out.println("\tRes: " + isReflected(points));
    }
    public static boolean isReflected(int[][] points) {
        int len = points.length;
        if (len < 2) return true;

        double min = Double.MAX_EXPONENT;
        double max = Double.MIN_EXPONENT;
        HashMap<Double, Double> map = new HashMap<>();
        for (int[] p : points) {
            map.put((double)p[0], (double)p[1]);
            min = Math.min(min, (double)p[0]);
            max = Math.max(max, (double)p[0]);
        }
        double mid = (min + max) / 2.0;

        for (Map.Entry<Double, Double> entry : map.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            double nx = 2*mid - x;
            if (!map.containsKey(nx) || map.get(nx) != y) {
                return false;
            }
        }
        return true;
    }
    // This version is wrong for [[1,2],[2,2],[1,4],[2,4]]
    public static boolean isReflected2(int[][] points) {
        int len = points.length;
        if (len < 2) return true;

        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                arr.add(points[i]);
            } else if (points[i][0] != points[i-1][0] || points[i][1] != points[i-1][1]) {
                arr.add(points[i]);
            }
        }

        double mid = ((double)points[0][0] + (double)points[arr.size() - 1][0])/2;
        int i = 0, j = arr.size() - 1;
        while (i <= j) {
            double tmp = ((double)arr.get(i)[0] + (double)arr.get(j)[0])/2;
            if (arr.get(i)[1] != arr.get(j)[1] ||
                    tmp != mid) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


//    def isConvex(self, points):
//            """
//            :type points: List[List[int]]
//            :rtype: bool
//    """
//    def crossProduct(p0, p1, p2):
//    x0, y0 = p0
//    x1, y1 = p1
//    x2, y2 = p2
//    return (x2 - x0) * (y1 - y0) - (x1 - x0) * (y2 - y0)
//
//    size = len(points)
//    last = 0
//            for x in range(size):
//    p0, p1, p2 = points[x], points[(x + 1) % size], points[(x + 2) % size]
//    p = crossProduct(p0, p1, p2)
//    if p * last < 0:
//            return False
//            last = p
//    return True

    public static boolean isConvex(List<List<Integer>> points) {
        int len = points.size();
        int last = 0;

        for (int i = 0; i < len; i++) {
            int p = crossProduct(points.get(i), points.get((i+1)%len), points.get((i+2)%len));
            if (p * last < 0) {
                return false;
            }
            last = p;
        }
        return true;
    }
    private static int crossProduct(List<Integer> p0, List<Integer> p1, List<Integer> p2) {
       return (p2.get(0) - p0.get(0) * (p1.get(1) - p0.get(1)) - (p1.get(0) - p0.get(0)) * (p2.get(1) - p0.get(1)));
    }

    /**
     * Count of Range Sum
     * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
     * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
     *         Note:
     * A naive algorithm of O(n2) is trivial. You MUST do better than that.
     *         Example:
     * Given nums = [-2, 5, -1], lower = -2, upper = 2,
     * Return 3.
     * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
     * Credits:
     * Special thanks to @dietpepsi for adding this problem and creating all test cases.
     */
    public static void countRangeSumDemo(int[] nums, int lower, int upper) {
        System.out.println("\nStart function countRangeSumDemo()");
        printArray(nums, "\tNums:");
        System.out.println("\tLower = " + lower);
        System.out.println("\tUpper = " + upper);
        System.out.println("\tRes = " + countRangeSum(nums, lower, upper));
    }
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        if(len <= 0) {
            return 0;
        }
        long[] sum = new long[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] += nums[i] + sum[i-1];
        }

        return countRangeSumHelper(nums, sum, lower, upper, 0, len - 1);
    }
    private static int countRangeSumHelper(int[] nums, long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            if (nums[left] >= lower && nums[left] <= upper) {
                return 1;
            }
            return 0;
        }
        int mid = (left + right)/2;
        int total = 0;
        for (int i = left; i <= mid; i++) {
            for (int j = mid + 1; j <= right; j++) {
                long tmp = sum[j] - sum[i] + nums[i];
                if (tmp >= lower && tmp <= upper) {
                    total++;
                }
            }
        }
        return total + countRangeSumHelper(nums, sum, lower, upper, left, mid) + countRangeSumHelper(nums, sum, lower, upper, mid + 1, right);
    }

    /**
     * Perfect Rectangle
     * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
     * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
     *
     * Example 1:
     * rectangles = [
     *         [1,1,3,3],
     *         [3,1,4,2],
     *         [3,2,4,4],
     *         [1,3,2,4],
     *         [2,3,3,4]
     *         ]
     * Return true. All 5 rectangles together form an exact cover of a rectangular region.
     *
     * Example 2:
     * rectangles = [
     *         [1,1,2,3],
     *         [1,3,2,4],
     *         [3,1,4,2],
     *         [3,2,4,4]
     *         ]
     * Return false. Because there is a gap between the two rectangular regions.
     *
     * Example 3:
     * rectangles = [
     *         [1,1,3,3],
     *         [3,1,4,2],
     *         [1,3,2,4],
     *         [3,2,4,4]
     *         ]
     * Return false. Because there is a gap in the top center.
     *
     *         Example 4:
     * rectangles = [
     *         [1,1,3,3],
     *         [3,1,4,2],
     *         [1,3,2,4],
     *         [2,2,4,4]
     *         ]
     * Return false. Because two of the rectangles overlap with each other.
     */
    public static void isRectangleCoverDemo(int[][] rectangles) {
        System.out.println("\nStart function isRectangleCoverDemo()");
        printTwoDimentinalArray(rectangles, "\tRectangles:");
        System.out.println("\tRes = " + isRectangleCover(rectangles));
    }
    public static boolean isRectangleCover(int[][] rectangles) {
        HashSet<String> S = new HashSet<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rec : rectangles) {
            minX = Math.min(minX, rec[0]);
            minY = Math.min(minY, rec[1]);
            maxX = Math.max(maxX, rec[2]);
            maxY = Math.max(maxY, rec[3]);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            String s1 = rec[0] + ":" + rec[1];
            String s2 = rec[0] + ":" + rec[3];
            String s3 = rec[2] + ":" + rec[3];
            String s4 = rec[2] + ":" + rec[1];

            if (S.contains(s1)) {
                S.remove(s1);
            } else {
                S.add(s1);
            }
            if (S.contains(s2)) {
                S.remove(s2);
            } else {
                S.add(s2);
            }
            if (S.contains(s3)) {
                S.remove(s3);
            } else {
                S.add(s3);
            }
            if (S.contains(s4)) {
                S.remove(s4);
            } else {
                S.add(s4);
            }
        }
        String s1 = minX + ":" + minY;
        String s2 = minX + ":" + maxY;
        String s3 = maxX + ":" + maxY;
        String s4 = maxX + ":" + minY;
        if (!S.contains(s1) || !S.contains(s2) || !S.contains(s3) || !S.contains(s4) || S.size() != 4) {
            return false;
        }

        return area == (maxX - minX) * (maxY - minY);
    }

    /**
     * Poor Pigs
     *
     * There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
     * Answer this question, and write an algorithm for the follow-up general case.
     * Follow-up:
     * If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.
     */
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        System.out.println("\nStart function poorPigs()");
        System.out.println("\nbucekts = " + buckets + ", minutesToDie = " + minutesToDie + ", minutesToTest = " + minutesToTest);
        int pigs = 0;
        int tests = minutesToTest / minutesToDie + 1;
        while (Math.pow(tests, pigs) < buckets) {
            pigs++;
        }
        System.out.println("\tPigs = " + pigs);
        return pigs;
    }
    public static int poorPigs2(int buckets, int minutesToDie, int minutesToTest) {
        System.out.println("\nStart function poorPigs()");
        System.out.println("\nbucekts = " + buckets + ", minutesToDie = " + minutesToDie + ", minutesToTest = " + minutesToTest);
        if (buckets-- == 1) return 0;
        int base = minutesToTest/minutesToDie + 1;
        int count = 0;
        while (buckets > 0) {
            buckets /= base;
            count++;
        }
        System.out.println("\tPigs = " + count);
        return count;
    }

    /**
     * Target Sum
     *
     * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
     *
     * Find out how many ways to assign symbols to make sum of integers equal to target S.
     *
     *         Example 1:
     * Input: nums is [1, 1, 1, 1, 1], S is 3.
     * Output: 5
     * Explanation:
     *
     *         -1+1+1+1+1 = 3
     *         +1-1+1+1+1 = 3
     *         +1+1-1+1+1 = 3
     *         +1+1+1-1+1 = 3
     *         +1+1+1+1-1 = 3
     *
     * There are 5 ways to assign symbols to make the sum of nums be target 3.
     * Note:
     * The length of the given array is positive and will not exceed 20.
     * The sum of elements in the given array will not exceed 1000.
     * Your output answer is guaranteed to be fitted in a 32-bit integer.
     */
    public static int findTargetSumWays(int[] nums, int S) {
        System.out.println("\nStart function findTargetSumWays(). S = " + S);
        printArray(nums, "\tNums: ");
        int[] res = new int[1];
        findTargetSumWaysDFS(nums, 0, S, 0, res);
        System.out.println("\tRes = " + res[0]);
        return res[0];
    }
    private static void findTargetSumWaysDFS(int[] nums, int idx, int S, int tmp, int[] res) {
        if (idx == nums.length) {
            if (tmp == S) res[0]++;
            return;
        }
        findTargetSumWaysDFS(nums, idx+1, S, tmp + nums[idx], res);
        findTargetSumWaysDFS(nums, idx+1, S, tmp - nums[idx], res);
    }

    public static void findSubsequencesDemo(int[] nums) {
        System.out.println("\nStart function findSubsequencesDemo()");
        printArray(nums, "\tNums: ");
        List<List<Integer>> res = findSubsequences(nums);
        System.out.println("\tRes:");
        for (List<Integer> r : res) {
            System.out.println("\t" + r);
        }
    }
    public static List<List<Integer>> findSubsequences3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        if (len < 2) return res;

        HashSet<String> used = new HashSet<>();
        HashMap<Integer, List<LinkedList<Integer>>> past = new HashMap<>();
        for (int i = 0; i < len; i++) {
            past.put(i, new ArrayList<>());
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    LinkedList<Integer> new1 = new LinkedList<>(Arrays.asList(new Integer[]{nums[j], nums[i]}));
                    past.get(i).add(new1);
                    if (!used.contains(new1.toString())) {
                        res.add(new1);
                        used.add(new1.toString());
                    }
                    for (LinkedList<Integer> list : past.get(j)) {
                        LinkedList<Integer> newList = new LinkedList<>(list);
                        newList.add(nums[i]);
                        past.get(i).add(newList);
                        if (!used.contains(newList.toString())) {
                            res.add(newList);
                            used.add(newList.toString());
                        }
                    }
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        if (len < 2) return res;

        LinkedList<Integer> tmp = new LinkedList<>();
        tmp.add(nums[0]);
        HashMap<Integer, List<LinkedList<Integer>>> past = new HashMap<>();
        for (int i = 0; i < len; i++) {
            past.put(i, new ArrayList<>());
        }

        for (int i = 1; i < len; i++) {
            int j = 0;
            if (nums[i] == nums[i-1]) {
                j = i-1;
            }
            for (; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    LinkedList<Integer> new1 = new LinkedList<>(Arrays.asList(new Integer[]{nums[j], nums[i]}));
                    past.get(i).add(new1);
                    res.add(new1);
                    for (LinkedList<Integer> list : past.get(j)) {
                        LinkedList<Integer> newList = new LinkedList<>(list);
                        newList.add(nums[i]);
                        past.get(i).add(newList);
                        res.add(newList);
                    }
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        if (len < 2) return res;

        findSubsequencesDFS(nums, 0, new LinkedList<>(), res);
        return res;
    }
    public static void findSubsequencesDFS(int[] nums, int start, LinkedList<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() >= 2) {
            res.add(new LinkedList<>(tmp));
        }
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            if (tmp.isEmpty() || nums[i] >= tmp.getLast()) {
                tmp.add(nums[i]);
                findSubsequencesDFS(nums, i + 1, tmp, res);
                tmp.removeLast();
            }
        }
    }

    /**
     * Predict the Winner
     * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
     * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
     * Example 1:
     * Input: [1, 5, 2]
     * Output: False
     * Explanation: Initially, player 1 can choose between 1 and 2.
     * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
     * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
     * Hence, player 1 will never be the winner and you need to return False.
     *         Example 2:
     * Input: [1, 5, 233, 7]
     * Output: True
     * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
     * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
     *         Note:
     *         1. 1 <= length of the array <= 20.
     *         2. Any scores in the given array are non-negative integers and will not exceed 10,000,000.
     *         3. If the scores of both players are equal, then player 1 is still the winner.
     */
    public static void PredictTheWinnerDemo(int[] nums) {
        System.out.println("\nStart function PredictTheWinnerDemo()");
        printArray(nums, "\tNums: ");
        System.out.println("\tRes:" + PredictTheWinner(nums));
    }
    public static boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if (len == 1) return true;
        return PredictTheWinnerHelper(nums, 0, len - 1, 0, 0, true);
    }
    private static boolean PredictTheWinnerHelper(int[] nums, int left, int right, long p1, long p2, boolean first) {
        if (left > right) {
            if (p1 >= p2) {
                return first;
            } else {
                return !first;
            }
        }
        boolean leftRes = PredictTheWinnerHelper(nums, left + 1, right, first ? p1 + nums[left] : p1, first ? p2 : p2 + nums[left], !first);
        boolean rightRes = PredictTheWinnerHelper(nums, left, right - 1, first ? p1 + nums[right] : p1, first ? p2 : p2 + nums[right], !first);

        if (leftRes && rightRes) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Smallest Rectangle Enclosing Black Pixels
     * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
     * For example, given the following image:
     *         [
     *         "0010",
     *         "0110",
     *         "0100"
     *         ]
     * and x = 0, y = 2,
     * Return 6.
     */
    public static int minArea(Character[][] image, int x, int y) {
        System.out.println("\nStart function minArea()");

        int R = image.length;
        if (R < 1) return 0;
        int C = image[0].length;
        if (C < 1) return 0;

        assert x >= 0 && x < R && y >= 0 && y < C && image[x][y] == '1';

        System.out.println("\tImage:");
        for (int i = 0; i < R; i++) {
            System.out.println("\t" + Arrays.asList(image[i]));
        }
        System.out.println("\tX = " + x + "; Y = " + y);

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };

        int minX = R - 1;
        int maxX = 0;
        int minY = C - 1;
        int maxY = 0;
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{x, y});
        image[x][y] = '2';
        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            minX = Math.min(minX, cur[0]);
            maxX = Math.max(maxX, cur[0]);
            minY = Math.min(minY, cur[1]);
            maxY = Math.max(maxY, cur[1]);

            for (int[] dir : dirs) {
                int newX = cur[0] + dir[0];
                int newY = cur[1] + dir[1];
                if (newX >= 0 && newX < R && newY >= 0 && newY < C && image[newX][newY] == '1') {
                    image[newX][newY] = '2';
                    Q.add(new int[]{newX, newY});
                }
            }
        }
        System.out.println("\tMinArea = " + (maxX - minX + 1) * (maxY - minY + 1));
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    /**
     * The Maze
     * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
     * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
     * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
     * Example 1
     * Input 1: a maze represented by a 2D array
0 0  * 1 0 0
     *     0 0 0 0 0
     *     0 0 0 1 0
     *     1 1 0 1 1
     *     0 0 0 0 0
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
     * Output: true
     * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
     *
     *         Example 2
     * Input 1: a maze represented by a 2D array
     *     0 0 1 0 0
     *     0 0 0 0 0
     *     0 0 0 1 0
     *     1 1 0 1 1
     *     0 0 0 0 0
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
     * Output: false
     * Explanation: There is no way for the ball to stop at the destination.
     *
     *         Note:
     *         1. There is only one ball and one destination in the maze.
     *         2. Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
     *         3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
     *         4. The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
     */
    public static void hasPathDemo(int[][] maze, int[] start, int[] destination) {
        System.out.println("\nStart function hasPath()");
        printTwoDimentinalArray(maze, "\tMaze:");
        printArray(start, "\tStart:");
        printArray(destination, "\tDestionation:");
        System.out.println("\tRes: " + hasPath(maze, start, destination));
    }
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int R = maze.length;
        if (R < 1) return false;
        int C = maze[0].length;
        if (C < 1) return false;

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };
        boolean[][] visited = new boolean[R][C];

        visited[start[0]][start[1]] = true;
        for (int[] dir : dirs) {
            if (hasPathDFS(maze, R, C, start[0], start[1], destination, dirs, dir, visited)) {
                return true;
            }
        }
        return false;
    }
    private static boolean hasPathDFS(int[][] maze, int R, int C, int i, int j, int[] destination,int[][] dirs, int[] d, boolean[][] visited) {
        if (i < 0 || i >= R || j < 0 || j >= C) {
            return false;
        }
        if (!reachWall(maze, i, j, R, C, d)) {
            return hasPathDFS(maze, R, C, i + d[0], j + d[1], destination, dirs, d, visited);
        }
        if (destination[0] == i && destination[1] == j) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if ((dir[0] != d[0] && dir[1] != d[1]) &&
                (d[0] + dir[0] != 0 && d[1] + dir[1] != 0)) {
                if (hasPathDFS(maze, R, C, i, j, destination, dirs, dir, visited)) {
                    return true;
                }
            }
        }
        // visited[i][j] = false;
        return false;
    }
    private static boolean reachWall(int[][] maze, int i, int j, int R, int C, int[] dir) {
        int x = i + dir[0];
        int y = j + dir[1];

        return (x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1);
    }

    /**
     * The Maze II
     * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
     * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
     * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
     * Example 1
     * Input 1: a maze represented by a 2D array
0 0  * 1 0 0
     *     0 0 0 0 0
     *     0 0 0 1 0
     *     1 1 0 1 1
     *     0 0 0 0 0
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
     * Output: 12
     * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
     * The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
     *
     * Example 2
     * Input 1: a maze represented by a 2D array
     *     0 0 1 0 0
     *     0 0 0 0 0
     *     0 0 0 1 0
     *     1 1 0 1 1
     *     0 0 0 0 0
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
     * Output: -1
     * Explanation: There is no way for the ball to stop at the destination.
     *
     *         Note:
     *         1. There is only one ball and one destination in the maze.
     *         2. Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
     *         3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
     * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
     */
    public static void shortestDistanceDemo(int[][] maze, int[] start, int[] destination) {
        System.out.println("\nStart function shortestDistanceDemo()");
        printTwoDimentinalArray(maze, "\tMaze:");
        printArray(start, "\tStart:");
        printArray(destination, "\tDestionation:");
        System.out.println("\tRes: " + shortestDistance(maze, start, destination));
    }
    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int R = maze.length;
        if (R < 1) return -1;
        int C = maze[0].length;
        if (C < 1) return -1;
        int M = Math.max(R, C) + 1;

        int s = start[0] * M + start[1];
        int e = destination[0] * M + destination[1];

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };
        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(s, 0);
        int[] res = new int[]{Integer.MAX_VALUE};
        for (int[] dir : dirs) {
            shortestDistanceDFS(maze, R, C, M, s, e, dirs, dir, visited, 0, res);
        }
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }
    private static void shortestDistanceDFS(int[][] maze, int R, int C, int M, int cur, int end, int[][] dirs, int[] d, HashMap<Integer, Integer> visited, int cnt, int[] res) {
        int i = cur/M;
        int j = cur%M;
        // if (i < 0 || i >= R || j < 0 || j >= C || res[0] <= cnt) {
        //     return;
        // }
        if (!reachWall(maze, i, j, R, C, d)) {
            while (!reachWall(maze, i, j, R, C, d)) {
                i += d[0];
                j += d[1];
                cnt++;
            }
            cur = i * M + j;
        }

        if (cur == end) {
            res[0] = Math.min(res[0], cnt);
            return;
        }

        if (res[0] <= cnt + 1) {
            return;
        }
        if (visited.containsKey(cur) && visited.get(cur) <= cnt) {
            return;
        }
        visited.put(cur, cnt);
        for (int[] dir : dirs) {
            if ((dir[0] != d[0] && dir[1] != d[1]) &&
                    (d[0] + dir[0] != 0 && d[1] + dir[1] != 0)) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1) {
                    continue;
                }
                shortestDistanceDFS(maze, R, C, M, x * M + y, end, dirs, dir, visited, cnt + 1, res);
            }
        }
    }
    public static int shortestDistance2(int[][] maze, int[] start, int[] destination) {
        int R = maze.length;
        if (R < 1) return -1;
        int C = maze[0].length;
        if (C < 1) return -1;
        int M = Math.max(R, C) + 1;

        int s = start[0] * M + start[1];
        int e = destination[0] * M + destination[1];

        int[][] dirs = new int[][]{
                {-1, 0},{1, 0},{0, -1},{0, 1}
        };
        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(s, 0);
        int[] res = new int[]{Integer.MAX_VALUE};
        for (int[] dir : dirs) {
            shortestDistanceDFS2(maze, R, C, M, s, e, dirs, dir, visited, 0, res);
        }
        return res[0] == Integer.MAX_VALUE ? -1 : res[0];
    }
    private static void shortestDistanceDFS2(int[][] maze, int R, int C, int M, int cur, int end, int[][] dirs, int[] d, HashMap<Integer, Integer> visited, int cnt, int[] res) {
        int i = cur/M;
        int j = cur%M;
        if (i < 0 || i >= R || j < 0 || j >= C) {
            return;
        }
        if (!reachWall(maze, i, j, R, C, d)) {
            shortestDistanceDFS2(maze, R, C, M, (i + d[0]) * M + j + d[1], end, dirs, d, visited, cnt + 1, res);
            return;
        }
        if (cur == end) {
            res[0] = Math.min(res[0], cnt);
            return;
        }
        if (visited.containsKey(cur) && visited.get(cur) <= cnt) {
            return;
        }
        visited.put(cur, cnt);
        for (int[] dir : dirs) {
            if ((dir[0] != d[0] && dir[1] != d[1]) &&
                    (d[0] + dir[0] != 0 && d[1] + dir[1] != 0)) {
                shortestDistanceDFS2(maze, R, C, M, (i + dir[0]) * M + j + dir[1], end, dirs, dir, visited, cnt + 1, res);
            }
        }
    }

    /**
     * The Maze III
     * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.
     * Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".
     * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.
     *         Example 1
     * Input 1: a maze represented by a 2D array
     *         0 0 0 0 0
     *         1 1 0 0 1
     *         0 0 0 0 0
     *         0 1 0 0 1
     *         0 1 0 0 0
     * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
     * Input 3: hole coordinate (rowHole, colHole) = (0, 1)
     * Output: "lul"
     * Explanation: There are two shortest ways for the ball to drop into the hole.
     * The first way is left -> up -> left, represented by "lul".
     * The second way is up -> left, represented by 'ul'.
     * Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".
     *
     * Example 2
     * Input 1: a maze represented by a 2D array
     * 0 0 0 0 0
     *         1 1 0 0 1
     *         0 0 0 0 0
     *         0 1 0 0 1
     *         0 1 0 0 0
     * Input 2: ball coordinate (rowBall, colBall) = (4, 3)
     * Input 3: hole coordinate (rowHole, colHole) = (3, 0)
     * Output: "impossible"
     * Explanation: The ball cannot reach the hole.
     *
     * Note:
     *         1. There is only one ball and one hole in the maze.
     *         2. Both the ball and hole exist on an empty space, and they will not be at the same position initially.
     *         3. The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
     * The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.
     */
    public static void findShortestWayDemo(int[][] maze, int[] ball, int[] hole) {
        System.out.println("\nStart function findShortestWayDemo()");
        printTwoDimentinalArray(maze, "\tMaze:");
        printArray(ball, "\tBall:");
        printArray(hole, "\tHole:");
        System.out.println("\tRes: " + findShortestWay(maze, ball, hole));
    }
    private static class VisitedNode {
        int i;
        int j;
        String path;
        public VisitedNode(int x, int y, String p) {
            i = x;
            j = y;
            path = p;
        }
    }
    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int R = maze.length;
        if (R < 1) return "impossible";
        int C = maze[0].length;
        if (C < 1) return "impossible";

        HashMap<Character, int[]> dirs = new HashMap<>();
        dirs.put('u', new int[]{-1, 0});
        dirs.put('d', new int[]{1, 0});
        dirs.put('l', new int[]{0, -1});
        dirs.put('r', new int[]{0, 1});
        HashMap<Character, Integer> dirsInt = new HashMap<>();
        dirsInt.put('u', 1);
        dirsInt.put('d', 2);
        dirsInt.put('l', 4);
        dirsInt.put('r', 8);

        Queue<VisitedNode> Q = new LinkedList<>();
        Q.add(new VisitedNode(ball[0], ball[1], "u"));
        Q.add(new VisitedNode(ball[0], ball[1], "d"));
        Q.add(new VisitedNode(ball[0], ball[1], "l"));
        Q.add(new VisitedNode(ball[0], ball[1], "r"));
        int[][] visited = new int[R][C];
        visited[ball[0]][ball[1]] = 15;
        boolean found = false;
        PriorityQueue<String> res = new PriorityQueue<>();

        while (!Q.isEmpty()) {
            int size = Q.size();
            LinkedList<VisitedNode> nextLevel = new LinkedList<>();
            while (size-- > 0) {
                VisitedNode vn = Q.poll();
                if (vn.i == hole[0] && vn.j == hole[1]) {
                    res.add(vn.path);
                    found = true;
                    continue;
                }

                Character dc = vn.path.charAt(vn.path.length() - 1);
                int[] dir = dirs.get(dc);
                int x = vn.i + dir[0], y = vn.j + dir[1];

                if (!(x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1)) {
                    if ((visited[x][y] & dirsInt.get(dc)) == 0) {
                        nextLevel.add(new VisitedNode(x, y, vn.path));
                    }
                } else {
                    if (vn.i == ball[0] && vn.j == ball[1]) {
                        continue;
                    }
                    for (Character d : dirs.keySet()) {
                        if (d != dc && (dirs.get(d)[0] + dir[0] != 0 && dirs.get(d)[1] + dir[1] != 0)) {
                            x = vn.i + dirs.get(d)[0];
                            y = vn.j + dirs.get(d)[1];
                            if (!(x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1 || (visited[x][y] & dirsInt.get(d)) != 0)) {
                                nextLevel.add(new VisitedNode(x, y, vn.path + d));
                            }
                        }
                    }
                }
            }
            if (!found) {
                for (VisitedNode vn : nextLevel) {
                    visited[vn.i][vn.j] |= dirsInt.get(vn.path.charAt(vn.path.length() - 1));
                    Q.add(vn);
                }
            }
        }

        if (res.isEmpty()) return "impossible";
        return res.peek();
    }
    public static String findShortestWay3(int[][] maze, int[] ball, int[] hole) {
        int R = maze.length;
        if (R < 1) return "impossible";
        int C = maze[0].length;
        if (C < 1) return "impossible";
        int M = Math.max(R, C) + 1;

        int s = ball[0] * M + ball[1];
        int e = hole[0] * M + hole[1];

        HashMap<Character, int[]> dirs = new HashMap<>();
        dirs.put('u', new int[]{-1, 0});
        dirs.put('d', new int[]{1, 0});
        dirs.put('l', new int[]{0, -1});
        dirs.put('r', new int[]{0, 1});

        Queue<VisitedNode> Q = new LinkedList<>();
        Q.add(new VisitedNode(ball[0], ball[1], "u"));
        Q.add(new VisitedNode(ball[0], ball[1], "d"));
        Q.add(new VisitedNode(ball[0], ball[1], "l"));
        Q.add(new VisitedNode(ball[0], ball[1], "r"));
        HashSet<Character>[][] visited = new HashSet[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited[i][j] = new HashSet<>();
            }
        }
        visited[ball[0]][ball[1]].add('u');
        visited[ball[0]][ball[1]].add('d');
        visited[ball[0]][ball[1]].add('l');
        visited[ball[0]][ball[1]].add('r');
        boolean found = false;
        PriorityQueue<String> res = new PriorityQueue<>();

        while (!Q.isEmpty()) {
            int size = Q.size();
            LinkedList<VisitedNode> nextLevel = new LinkedList<>();
            while (size-- > 0) {
                VisitedNode vn = Q.poll();
                if (vn.i == hole[0] && vn.j == hole[1]) {
                    res.add(vn.path);
                    found = true;
                    continue;
                }

                Character dc = vn.path.charAt(vn.path.length() - 1);
                int[] dir = dirs.get(dc);
                int x = vn.i + dir[0], y = vn.j + dir[1];

                if (!(x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1)) {
                    if (!visited[x][y].contains(dc)) {
                        nextLevel.add(new VisitedNode(x, y, vn.path));
                    }
                } else {
                    if (vn.i == ball[0] && vn.j == ball[1]) {
                        continue;
                    }
                    for (Character d : dirs.keySet()) {
                        if (d != dc && (dirs.get(d)[0] + dir[0] != 0 && dirs.get(d)[1] + dir[1] != 0)) {
                            x = vn.i + dirs.get(d)[0];
                            y = vn.j + dirs.get(d)[1];
                            if (!(x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1 || visited[x][y].contains(d))) {
                                nextLevel.add(new VisitedNode(x, y, vn.path + d));
                            }
                        }
                    }
                }
            }
            if (!found) {
                for (VisitedNode vn : nextLevel) {
                    visited[vn.i][vn.j].add(vn.path.charAt(vn.path.length() - 1));
                    Q.add(vn);
                }
            }
        }

        if (res.isEmpty()) return "impossible";
        return res.peek();
    }
    public static String findShortestWay2(int[][] maze, int[] ball, int[] hole) {
        int R = maze.length;
        if (R < 1) return "impossible";
        int C = maze[0].length;
        if (C < 1) return "impossible";
        int M = Math.max(R, C) + 1;

        int s = ball[0] * M + ball[1];
        int e = hole[0] * M + hole[1];

        HashMap<Character, int[]> dirs = new HashMap<>();
        dirs.put('u', new int[]{-1, 0});
        dirs.put('d', new int[]{1, 0});
        dirs.put('l', new int[]{0, -1});
        dirs.put('r', new int[]{0, 1});

        HashMap<Integer, Integer> visited = new HashMap<>();
        visited.put(s, 0);
        HashMap<Integer, HashSet<String>> res = new HashMap<>();
        int[] tCnt = new int[]{Integer.MAX_VALUE};
        for (Character dir : dirs.keySet()) {
            findShortestWayDFS2(maze, R, C, M, s, e, dirs, dir, visited, 0, new StringBuilder(dir.toString()), tCnt, res);
        }
        if (tCnt[0] == Integer.MAX_VALUE) {
            return "impossible";
        }
        HashSet<String> shortest = res.get(tCnt[0]);
        String finalRes = shortest.iterator().next();
        for (String r : shortest) {
            System.out.println("\t" + r);
            if (r.length() < finalRes.length()) {
                finalRes = r;
            } else if (r.length() == finalRes.length()) {
                finalRes = finalRes.compareTo(r) < 0 ? finalRes : r;
            }
        }
        return finalRes;
    }
    private static void findShortestWayDFS2(int[][] maze, int R, int C, int M, int cur, int end, HashMap<Character, int[]> dirs, Character d, HashMap<Integer, Integer> visited, int cnt, StringBuilder tmp, int[] tCnt, HashMap<Integer, HashSet<String>> res) {
        int i = cur / M;
        int j = cur % M;

        if (cur == end) {
            if (cnt <= tCnt[0]) {
                if (res.containsKey(cnt)) {
                    res.get(cnt).add(tmp.toString());
                } else {
                    HashSet<String> newSet = new HashSet<>();
                    newSet.add(tmp.toString());
                    res.put(cnt, newSet);
                }
                tCnt[0] = cnt;
            }
            return;
        }

        if (!reachWall(maze, i, j, R, C, dirs.get(d))) {
            findShortestWayDFS2(maze, R, C, M, (i + dirs.get(d)[0]) * M + j + dirs.get(d)[1], end, dirs, d, visited, cnt + 1, tmp, tCnt, res);
            return;
        }

        if (cnt + 1 > tCnt[0]) {
            return;
        }

        if (visited.containsKey(cur) && visited.get(cur) <= cnt) {
            return;
        }
        visited.put(cur, cnt);
        for (Character dir : dirs.keySet()) {
            if ((dirs.get(dir)[0] != dirs.get(d)[0] && dirs.get(dir)[1] != dirs.get(d)[1]) &&
                (dirs.get(d)[0] + dirs.get(dir)[0] != 0 && dirs.get(d)[1] + dirs.get(dir)[1] != 0)) {
                int x = i + dirs.get(dir)[0], y = j + dirs.get(dir)[1];
                if (x < 0 || x >= R || y < 0 || y >= C || maze[x][y] == 1) {
                    continue;
                }
                tmp.append(dir);
                findShortestWayDFS2(maze, R, C, M, (i + dirs.get(dir)[0]) * M + j + dirs.get(dir)[1], end, dirs, dir, visited, cnt + 1, tmp, tCnt, res);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
//    public int depthSumReverse(List<NestedInteger> nestedList) {
//        ArrayList<Integer> depthSum = new ArrayList<>();
//        depthSumReverseDFS(nestedList, depthSum);
//        int res = 0;
//        for (int i = 0; i < depthSum.size(); i++) {
//            res += (depthSum.size() - i) * depthSum.get(i);
//        }
//        return res;
//    }
//    private void depthSumReverseDFS(List<NestedInteger> nestedList, ArrayList<Integer> depthSum) {
//        int sum = 0;
//        List<NestedInteger> nextLevel = new ArrayList<>();
//        for (NestedInteger nl : nestedList) {
//            if (nl.isInteger()) sum += nl.getInteger();
//            else nextLevel.addAll(nl.getList());
//        }
//        depthSum.add(sum);
//        depthSumReverseDFS(nextLevel, depthSum);
//    }
//    // Another version
//    public int depthSumReverse2(List<NestedInteger> nestedList) {
//        HashMap<Integer, Integer> depthSum = new HashMap<>();
//        for (NestedInteger nl : nestedList) {
//            depthSumReverseDFS2(nl, depthSum, 0);
//        }
//        int res = 0;
//        for (int i = 0; i < depthSum.size(); i++) {
//            res += (depthSum.size() - i) * depthSum.get(i);
//        }
//        return res;
//    }
//    private void depthSumReverseDFS2(NestedInteger nl, HashMap<Integer, Integer> depthSum, int depth) {
//        if (depth >= depthSum.size()) {
//            depthSum.put(depth, 0);
//        }
//        if (nl.isInteger()) {
//            depthSum.put(depth, depthSum.get(depth) + nl.getInteger());
//        } else {
//            for (NestedInteger n : nl.getList()) {
//                depthSumReverseDFS2(n, depthSum, depth + 1);
//            }
//        }
//    }

//    public static int findMaximumXOR(int[] nums) {
//        int len = nums.length;
//        if (len <= 1) return 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                int t = (nums[i] ^ nums[j]);
//                max = Math.max(max, t);
//            }
//        }
//        return max;
//    }


    /**
     * Diagonal traverse
     * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order.
     * Example 1:
     * Input:
     *         [
     *         [ 1, 2, 3 ],
     *         [ 4, 5, 6 ],
     *         [ 7, 8, 9 ]
     *         ]
     * Output:  [1,2,4,7,5,3,6,8,9]
     * Explanation:
     *
     * Note:
     *         1. The total number of elements of the given matrix will not exceed 10,000.
     *
     * https://leetcode.com/contest/leetcode-weekly-contest-18b/problems/diagonal-traverse/
     */
    public static int[] findDiagonalOrder(int[][] matrix) {
        System.out.println("\nStart function findDiagonalOrder()");
        printTwoDimentinalArray(matrix, "\tMatrix:");

        int R = matrix.length;
        if (R < 1) return new int[]{};
        int C = matrix[0].length;
        if (C < 1) return new int[]{};

        int[] res = new int[R * C];
        int idx = 0;
        boolean i2j = true;

        for (int sum = 0; sum < R * C; sum++) {
            if (i2j) {
                int i = Math.min(sum, R-1);
                int j = sum - i;
                for (; i >= 0 && j <= Math.min(sum, C - 1); i--, j++) {
                    res[idx++] = matrix[i][j];
                }
            } else {
                int j = Math.min(sum, C-1);
                int i = sum - j;
                for (; j >= 0 && i <= Math.min(sum, R - 1); i++, j--) {
                    res[idx++] = matrix[i][j];
                }
            }
            i2j = !i2j;
        }

        printArray(res, "\tRes");
        return res;
    }

    /**
     * Contiguous Array
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> v2i = new HashMap<>();
        int len = nums.length;
        if (len < 2) return 0;

        int res = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (sum == 0) {
                res = i + 1;
            } else {
                if (v2i.containsKey(sum)) {
                    res = Math.max(res, i - v2i.get(sum));
                } else {
                    v2i.put(sum, i);
                }
            }
        }

        return res;
    }

    public void moveZeros(Integer[] nums) {
        if (nums == null) return;
        int len = nums.length;
        if (len <= 1) return;

        int startZero = 0, idx = 0;
        while (idx < len) {
            while (startZero < len && nums[startZero] != 0) {
                startZero++;
            }
            idx = Math.max(idx, startZero);
            while (idx < len && nums[idx] == 0) {
                idx++;
            }
            if (idx < len) swap(nums, idx++, startZero++);
        }
    }
}

//    /**
//     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//     * For example,
//     * Given [100, 4, 200, 1, 3, 2],
//     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//     * Your algorithm should run in O(n) complexity.
//     */
//    TODO
//    public static Integer longestConsecutiveSequence (Integer [] arr) {
//         class Marker {
//            public Integer curLen;
//            public Integer max;
//            public Integer min;
//            public Marker() {
//                curLen = 0;
//                max = -1;
//                min = -1;
//            }
//            public Marker(Integer len, Integer ma, Integer mi) {
//                curLen = len;
//                max = ma;
//                min = mi;
//            }
//            @Override
//            public String toString () {
//                return (curLen + " -> [" + max + ", " + min + "]").toString();
//            }
//        }
//
//        System.out.println("Array: " + Arrays.asList(arr));
//
//        int size = arr.length;
//        Marker[] helperArr = new Marker[size];
////        Arrays.fill(helperArr, new Marker (1, Integer.MIN_VALUE, Integer.MAX_VALUE));
//
//        for (int i = 0; i < size; i++) {
//            helperArr[i] = new Marker (1, arr[i], arr[i]);
//        }
//        System.out.println("Initial HelperArray: " + Arrays.asList(helperArr));
//
//        for (int i = 1; i < size; i++) {
//            int maxLen = Integer.MIN_VALUE;
//            int maxIndex = Integer.MIN_VALUE;
//            for (int j = 0; j < i; j++) {
//                if (((arr[i] == (helperArr[j].max + 1)) || (arr[i] == (helperArr[j].min - 1))) &&
//                    (helperArr[j].curLen > maxLen)) {
//                    maxLen = helperArr[j].curLen;
//                    maxIndex = j;
//                }
//            }
//            if (maxLen == Integer.MIN_VALUE) {
//                helperArr[i].curLen = 1;
//                helperArr[i].max = arr[i];
//                helperArr[i].min = arr[i];
//            } else {
//                helperArr[i].curLen = maxLen + 1;
//                helperArr[i].max = (arr[i] == (helperArr[maxIndex].max + 1)) ? arr[i] : helperArr[maxIndex].max;
//                helperArr[i].min = (arr[i] == (helperArr[maxIndex].min - 1)) ? arr[i] : helperArr[maxIndex].min;
//            }
//            System.out.println("HelperArray: " + Arrays.asList(helperArr));
//        }
//
//        System.out.println("Done HelperArray: " + Arrays.asList(helperArr));
//
//        Integer maxLen = Integer.MIN_VALUE;
//        for (int i = 0; i < size - 1; i++) {
//            maxLen = helperArr[i].curLen;
//            System.out.print(helperArr[i] + " || ");
//        }
//        System.out.println(helperArr[size - 1]);
//
//        for (Marker m : helperArr) {
//            if (m.curLen > maxLen)
//                maxLen = m.curLen;
//        }
//
//        return maxLen;
//    }
