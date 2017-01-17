package testing.lib.library;

import static testing.lib.common.CommonUtils.printArray;
import static testing.lib.common.CommonUtils.printTwoDimentinalArray;

/**
 * Created by Yun on 1/14/2017.
 */
public class NumMatrix {
    private int[][] arr;
    private int[][] BIT;
    private int R;
    private int C;

    private int lowBit(int x) {
        return (x & -x);
    }

    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        if (r < 1) return;
        int c = matrix[0].length;
        if (c < 1) return;
        R = r;
        C = c;

        arr = new int[R][C];
        BIT = new int[R+1][C+1];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - arr[row][col];
        arr[row][col] = val;

        for (int i = row + 1; i <= R; i += lowBit(i)) {
            for (int j = col + 1; j <= C; j += lowBit(j)) {
                BIT[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (R == 0 || C == 0) return 0;
        return sum(row2, col2) - sum(row2, col1-1) - sum(row1-1, col2) + sum(row1-1, col1-1);
    }

    public int sum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= lowBit(i)) {
            for (int j = col + 1; j > 0; j -= lowBit(j)) {
                sum += BIT[i][j];
            }
        }
        return sum;
    }

    public void print() {
        printTwoDimentinalArray(arr, "\tArr:");
        printTwoDimentinalArray(BIT, "\tBIT:");
    }
}
