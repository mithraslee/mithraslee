package testing.lib.fenwick_tree;

/**
 * Created by yun.li on 12/23/16.
 */
public class BIT2D {
    private int[][] arr;
    private int[][] BIT;
    private int R;
    private int C;

    private int lowBit(int x) {
        return x & -x;
    }

    public BIT2D(int[][] matrix) {
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

        int rIndex = row + 1;
        int cIndex = col + 1;

        for (; rIndex <= R; rIndex += lowBit(rIndex)) {
            for (; cIndex <= C; cIndex += lowBit(cIndex)) {
                BIT[rIndex][cIndex] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (R == 0 || C == 0) return 0;
        return sum(row2+1, col2+1) - sum(row2+1, col1) - sum(row1, col2+1) + sum(row1, col1);
    }

    public int sum(int row, int col) {
        int rIndex = row + 1;
        int cIndex = col + 1;
        int sum = 0;
        for (; rIndex > 0; rIndex -= lowBit(rIndex)) {
            for (; cIndex > 0; cIndex -= lowBit(cIndex)) {
                sum += BIT[rIndex][cIndex];
            }
        }
        return sum;
    }
}
