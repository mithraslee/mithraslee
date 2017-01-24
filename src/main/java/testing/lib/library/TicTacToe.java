package testing.lib.library;

import static testing.lib.common.CommonUtils.printArray;

/**
 * Created by Yun on 1/17/2017.
 */
public class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int N;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
        N = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        if (row == col) diagonal += val;
        if (row + col == N-1) antiDiagonal += val;

        System.out.println("\tR = " + row + "; C = " + col + "; P = " + player);

        int W = player == 1 ? N : -N;

        if (rows[row] == W || cols[col] == W || diagonal == W || antiDiagonal == W) {
            return player;
        }
        return 0;
    }
}
