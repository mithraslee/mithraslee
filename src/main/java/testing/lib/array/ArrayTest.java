/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.array;

import java.util.*;
import java.util.function.BooleanSupplier;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import testing.lib.fenwick_tree.FenwickTree;
import testing.lib.sort_search.*;

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

    private static void printArray(int[] arr) {
        printArray(convertIntArrToIntegerArr(arr), null, false);
    }

    private static void printArray(int[] arr, String note) {
        printArray(convertIntArrToIntegerArr(arr), note, false);
    }

    private static void printArray(int[] arr, String note, boolean printDimension) {
        printArray(convertIntArrToIntegerArr(arr), note, false);
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
     * {(a1, a2, a3, a4, b1, b2, b3, b4)}
     * => {(a1, a2, b1, b2), (a3, a4, b3, b4)}
     * => {(a1, b1), (a2, b2), (a3, b3), (a4, b4)}
     * <p>
     * {(a1, a2, a3, a4, a5, b1, b2, b3, b4, b5)}
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
        Stack s = new Stack();
        int len = height.length;
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            if (!s.isEmpty()) {
                while (!s.isEmpty() && height[(Integer) s.peek()] > height[i]) {
                    int temp = (Integer) s.pop();
                    if (!s.isEmpty()) {
                        maxArea = Math.max(maxArea, (i - (Integer) s.peek() - 1) * height[temp]);
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
            int temp = (Integer) s.pop();
            if (!s.empty()) {
                maxArea = Math.max(maxArea, (len - (Integer) s.peek() - 1) * height[temp]);
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
     * [2],
     * [3,4],
     * [6,5,7],
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

    // Optimal solution!
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
                    addToMap(arr, M, N, i, j, dict);
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

    private static void addToMap(Character[][] arr, int M, int N, int i, int j, HashMap<Integer, HashSet<Integer>> dict) {
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
            addToMap(arr, M, N, i + 1, j, dict);
            addToMap(arr, M, N, i - 1, j, dict);
            addToMap(arr, M, N, i, j + 1, dict);
            addToMap(arr, M, N, i, j - 1, dict);
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
    public static List<Set<Integer>> subsetsWithNoDup(Integer[] num) {
        System.out.println("\nStart function subsetsWithNoDup()");
        ArrayList<Set<Integer>> res = new ArrayList<>();
        if (num == null || num.length <= 0) return res;

        subsetsWithNoDupHelper(num, new HashSet<>(), res, 0);

        printArray(num, "Input array:");
        for (Set<Integer> set : res) {
            System.out.println("\tsubset: " + set);
        }
        return res;
    }

    private static void subsetsWithNoDupHelper(Integer[] num, HashSet<Integer> temp, ArrayList<Set<Integer>> res, int index) {
        if (index == num.length) {
            res.add((HashSet<Integer>) temp.clone());
        } else {
            subsetsWithNoDupHelper(num, temp, res, index + 1);
            temp.add(num[index]);
            subsetsWithNoDupHelper(num, temp, res, index + 1);
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
//        combinationSumDFS2_2 (candidates, target, new LinkedList<> (), results, 0);
        combinationSumDFS2_3 (candidates, target, new LinkedList<> (), results, 0);

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

    // This version might be easier to follow
    public static List<List<Integer>> jumpPath2(Integer[] A) {
        System.out.println("\nStart function jumpPath2()");
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
        System.out.println("\nStart function findRadius()");
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
        int maxP = 0;
        int len = prices.length;
        if (len < 2) return 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                maxP += prices[i] - prices[i - 1];
            }
        }
        return maxP;
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
     * Guess Number Higher or Lower II QuestionEditorial Solution  My Submissions
     * Total Accepted: 13653
     * Total Submissions: 39327
     * Difficulty: Medium
     * Contributors: Admin
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
     *         Hint:
     *
     * The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
     * Take a small example (n = 3). What do you end up paying in the worst case?
     * Check out this article if you're still stuck.
     * The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
     * As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?
     *
     * DP Problem
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

        LinkedList<Block> blocks = new LinkedList<>();
        for (int i = 0; i < buildings.length; i++) {
            blocks.add(new Block(buildings[i][0], buildings[i][1], buildings[i][2]));
            points.add(buildings[i][0]);
            points.add(buildings[i][1]);
        }

        int curHeight = 0;

        while (!points.isEmpty()) {
            int index = points.remove();
            while (!Q.isEmpty() && index >= Q.peek().end) {
                Q.remove();
            }
            // At first, 'if' instead of 'while' is used, which would be wrong for
            // inputs: (1, 2, 1), (1, 2, 2), (1, 2, 3)
            //if (!blocks.isEmpty() && index == blocks.getFirst().start) {
            while (!blocks.isEmpty() && index == blocks.getFirst().start) {
                Q.add(blocks.removeFirst());
            }

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
    // dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])                 ( i ≤ k ≤ j )
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
                swap(nums, i, i -1);
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
    public static boolean isSelfCrossing(int[] x) {
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
        while(!Q.isEmpty()) {
            int size = Q.size();
            while (size-- > 0) {
                LinkedList<String> tmpList = Q.poll();
                if (tmpList.getLast().equals(end)) {
                    return getValFromPath(map, tmpList);
                } else {
                    visited.add(tmpList.getLast());
                    for (String divisor : Dd2Dv.get(tmpList.getLast())) {
                        if (!visited.contains(divisor)) {
                            LinkedList<String> tmpList2 = new LinkedList<>(tmpList);
                            tmpList2.add(divisor);
                            Q.add(tmpList2);
                        }
                    }
                }
            }
        }
        return -1.0;
    }
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
                if (canCrossDFS2(stones, nextPosition, i)) return true;
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
        if (destStone == curStone) return true;
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
        System.out.println("\nStart function trapRainWater()");
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
