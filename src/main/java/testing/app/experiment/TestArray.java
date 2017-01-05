package testing.app.experiment;

import sun.plugin.javascript.navig.Array;
import testing.lib.array.ArrayTest;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestArray {
    public static void run () {
        int size = 10;
        Integer [] ai0 = new Integer [size];
        for (int i = 0; i < size; i++) {
            ai0[i] = (int)(Math.random() * (size + 1));
        }
        ArrayTest.find2NumWithGivenSum(ai0, size, 10);

        Character [] cArr1 = {'1', '2', '3', '4', '5', 'a', 'b', 'c', 'd', 'e'};
        Character [] cArr2 = {'1', '2', '3', '4', 'a', 'b', 'c', 'd'};
        ArrayTest.convertMerge(cArr1, 10);
        ArrayTest.convertMerge(cArr2, 8);

        int size2 = 5;
        Integer [] ai4 = new Integer [size2];
        for (int i = 0; i < size2; i++)
            ai4[i] = (int)(Math.random() * size2) + 1;
        ArrayTest.maxSubProduct(ai4, size2);

        Integer [] ai5 = new Integer [size2];
        for (int i = 0; i < size2; i++)
            ai5[i] = (int)(Math.random() * size2 * 2);
        ArrayTest.maxSubSum(ai5, size2);

        int RowForSetZeros = 10;
        Integer [][] intMatrix = new Integer [RowForSetZeros][RowForSetZeros];
        for (int i = 0; i < RowForSetZeros; i++)
            for (int j = 0; j < RowForSetZeros; j++) {
                intMatrix[i][j] = (int)(Math.random() * 20) > 0 ? 1 : 0;
            }
        ArrayTest.setZeroes(intMatrix);
        ArrayTest.setZeroes2(intMatrix);

        int Row = 10;
        int Column = 10;
        Character [][] matrix = new Character [Row][Column];
        for (int i = 0; i < Row; i++)
            for (int j = 0; j < Column; j++)
                matrix[i][j] = (int)(Math.random() * 3) == 0 ? '0' : '1';
        ArrayTest.maximalRectangle(matrix);

        int Row2 = 5;
        int Column2 = 5;
        Character [][] matrix2 = new Character [Row2][Column2];
        for (int i = 0; i < Row2; i++)
            for (int j = 0; j < Column2; j++)
                matrix2[i][j] = (int)(Math.random() * 3) == 0 ? '0' : '1';
        ArrayTest.maximalSquare(matrix2);

        Character [][] matrix3 = new Character [][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        ArrayTest.maximalSquare(matrix3);

        int num = 4;
        System.out.println("Gray code of " + num + " is " + ArrayTest.grayCode(num));

        ArrayList<ArrayList<Integer>> arrArr = new ArrayList<> ();
        arrArr.add(new ArrayList<> (Arrays.asList(-1)));
        arrArr.add(new ArrayList<> (Arrays.asList(2, 3)));
        arrArr.add(new ArrayList<> (Arrays.asList(1, -1, -3)));
        ArrayTest.minimumTotal(arrArr);
        ArrayTest.getPascalsTriangleRow(4);

        ArrayTest.fullJustify(new String [] {"Here", "is", "an", "example", "of", "text", "justification."}, 16);

        ArrayTest.generateMatrix(3);
        ArrayTest.generateMatrixIterative(4);

        ArrayTest.testIntervalMerge();

        ArrayTest.candy(new Integer[]{3, 4, 1, 5, 6, 2});

        for (int t = 0; t < 20; t++) {
            int ss = (int) (Math.random() * 10) + 5;
            Integer[] colors = new Integer[ss];
            for (int i = 0; i < ss; i++) {
                colors[i] = (int) (Math.random() * 3);
            }
            ArrayTest.sortColors(colors);
            for (int i = 1; i < ss; i++) {
                if (colors[i] < colors[i-1])
                    System.out.println("WRONG!!!");
            }
        }

        ArrayTest.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});

        //region Test Get Kth from two sorted arrays
        int K = 29;
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        for (int i = 1; i < K; i++) {
            if ((int)(Math.random()*2) == 0)
                al1.add(i);
            else
                al2.add(i);
        }
        Integer []testArr1 = al1.toArray(new Integer[al1.size()]);
        Integer []testArr2 = al2.toArray(new Integer[al2.size()]);
        System.out.println("\nInput array1 for getKthFromTwoSortedArray(): " + Arrays.asList(testArr1));
        System.out.println("Input array2 for getKthFromTwoSortedArray(): " + Arrays.asList(testArr2));

        for (int i = 1; i < K; i++) {
            assert ArrayTest.getKthFromTwoSortedArray(testArr1, testArr2, i) == i : "WRONG!!! " + i;
        }
        System.out.println("\tgetKthFromTwoSortedArray() Passed :)");
        for (int i = 1; i < K; i++) {
            assert ArrayTest.getKthFromTwoSortedArray2(testArr1, testArr2, i) == i : "WRONG!!! " + i;
        }
        System.out.println("\tgetKthFromTwoSortedArray2() Passed :)");

        Double median = ArrayTest.findMedianSortedArrays(new Integer[]{1}, new Integer[]{2,3,4,5,6,7,8});
        System.out.println("\tmedian = " + median);
        //endregion

        System.out.println();

        // region Test Count Smaller
        Integer[] arr1 = new Integer[]{3, 5, 2, 4, 1, 2};
        System.out.println("Count smaller arr for " + Arrays.asList(arr1) + " is: " + ArrayTest.countSmaller(arr1));
        System.out.println("Count smaller arr for " + Arrays.asList(arr1) + " is: " + ArrayTest.countSmaller2(arr1));
        System.out.println("Count smaller arr for " + Arrays.asList(arr1) + " is: " + ArrayTest.countSmaller3(arr1));
        System.out.println("Count smaller arr for " + Arrays.asList(arr1) + " is: " + ArrayTest.countSmaller4(arr1));
        // endregion

        System.out.println();

        //region BFS/DFS
        int M = 10;
        int N = 10;
        Character [][] arr = new Character [M][N]; // = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},{'X', 'O', 'X', 'X'}};
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                int temp = (int)(Math.random() * 2);
                if (temp == 0)
                    arr[i][j] = 'O';
                else
                    arr[i][j] = 'X';

            }
        ArrayTest.surroundedRegions(arr, M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                int temp = (int)(Math.random() * 2);
                if (temp == 0)
                    arr[i][j] = 'O';
                else
                    arr[i][j] = 'X';

            }
        ArrayTest.surroundedRegions2(arr, M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                int temp = (int)(Math.random() * 2);
                if (temp == 0)
                    arr[i][j] = 'O';
                else
                    arr[i][j] = 'X';

            }
        ArrayTest.surroundedRegions3(arr);
        Character [][] arrtt = new Character [M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                int temp = (int)(Math.random() * 2);
                if (temp == 0)
                    arrtt[i][j] = 'O';
                else
                    arrtt[i][j] = 'X';

            }
        ArrayTest.surroundedRegions4(arrtt);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                int temp = (int)(Math.random() * 3);
                if (temp == 0)
                    arrtt[i][j] = 'O';
                else
                    arrtt[i][j] = 'X';

            }
        ArrayTest.surroundedRegions5(arrtt);



        Integer[][] grid = new Integer [][] {
                { 0,  0,  0, -2, -1, -2,  0,  0, -2,  0},
                { 0, -1,  0,  0, -2,  0,  0,  0,  0,  0},
                { 0, -2,  0,  0,  0,  0,  0,  0, -1,  0},
                { 0,  0, -1, -2,  0,  0,  0,  0,  0, -2},
                {-2,  0,  0,  0,  0,  0, -2,  0,  0,  0},
                { 0,  0,  0,  0,  0,  0,  0, -1,  0,  0},
                {-1,  0,  0, -2,  0, -1,  0,  0,  0, -2}
        };
        int RR = grid.length;
        int CC = grid[0].length;
        System.out.println("BEFORE");
        for (int i = 0; i < RR; i++) {
            for (int j = 0; j < CC; j++) {
                System.out.print(String.format("%2d " , grid[i][j]));
            }
            System.out.println();
        }
        ArrayTest.findShortestPathToGuard(grid);
        System.out.println("AFTER");
        for (int i = 0; i < RR; i++) {
            for (int j = 0; j < CC; j++) {
                System.out.print(String.format("%2d " , grid[i][j]));
            }
            System.out.println();
        }

        int var = 3, sum = 3;
        int numOfSolutions = ArrayTest.findNumSolution(var, sum);
        System.out.println("\nNum of possible solutions for (var: " + var + ", sum: " + sum + ") is " + numOfSolutions);
        ArrayTest.findNumSolutionWithResult(var, sum);

        ArrayTest.permuteNoDup(new Integer [] {1, 2, 3});
        ArrayTest.permuteUnique(new Integer [] {1, 2, 3});
        ArrayTest.permuteUnique(new Integer [] {1, 1, 2});

        ArrayTest.subsetsWithNoDup(new Integer [] {1, 2, 3});
        ArrayTest.subsetsWithDupRecursive(new Integer [] {1, 2, 2});
        ArrayTest.subsetsWithDupRecursive2(new Integer [] {1, 2, 2});
        ArrayTest.subsetsWithDupIterative(new Integer [] {1, 2, 2});

        ArrayTest.combinationSumWithNoDupInput(new Integer [] {2, 3, 4, 6, 7}, 10);

        //region Combination Sum
        ArrayTest.combinationSum(new Integer [] {2, 3, 4, 6, 7}, 7);
        ArrayTest.combinationSum(new Integer [] {2, 2, 3, 4, 6, 7}, 7);

        ArrayTest.combinationSum2(new Integer [] {10, 1, 2, 7, 6, 1, 5}, 8);

        ArrayTest.combinationSum3(3, 9);

        ArrayTest.combinationSum4(new Integer[]{1, 2, 3}, 4);
        ArrayTest.combinationSum4_2(new Integer[]{1, 2, 3}, 4);
//        ArrayTest.combinationSum4(new Integer[]{4, 2, 1}, 32);
        ArrayTest.combinationSum4_2(new Integer[]{4, 2, 1}, 32);
        //endregion

        //region Test N Queens game
        ArrayTest.solveNQueens(1);
        ArrayTest.solveNQueens(4);

        ArrayTest.solveNQueens2(1);
        ArrayTest.solveNQueens2(4);

        ArrayTest.solveNQueens3(1);
        ArrayTest.solveNQueens3(5);
        //endregion



        System.out.println();

        //region Test Jump games
        Integer []jumpArr1 = new Integer[] {2,3,1,1,4};
        Integer []jumpArr2 = new Integer[] {3,2,1,0,4};
        Integer []jumpArr3 = new Integer[10]; //{4, 0, 0, 1, 4, 2, 3, 2, 0, 2};
        jumpArr3[0] = (int)(Math.random() * 4) + 1;
        for (int i = 1; i < 10; i++) {
            jumpArr3[i] = (int)(Math.random() * 5);
        }

        System.out.println(Arrays.asList(jumpArr1) + " jumpable? " + ArrayTest.canJump(jumpArr1));
        System.out.println(Arrays.asList(jumpArr1) + " jumpable? " + ArrayTest.canJump2(jumpArr1));
        System.out.println(Arrays.asList(jumpArr1) + " jumpable? " + ArrayTest.canJump3(jumpArr1));

        System.out.println(Arrays.asList(jumpArr2) + " jumpable? " + ArrayTest.canJump(jumpArr2));
        System.out.println(Arrays.asList(jumpArr2) + " jumpable? " + ArrayTest.canJump2(jumpArr2));
        System.out.println(Arrays.asList(jumpArr2) + " jumpable? " + ArrayTest.canJump3(jumpArr2));

        System.out.println(Arrays.asList(jumpArr3) + " jumpable? " + ArrayTest.canJump(jumpArr3));
        System.out.println(Arrays.asList(jumpArr3) + " jumpable? " + ArrayTest.canJump2(jumpArr3));
        System.out.println(Arrays.asList(jumpArr3) + " jumpable? " + ArrayTest.canJump3(jumpArr3));

        System.out.println(Arrays.asList(jumpArr1) + "'s min jump steps: " + ArrayTest.jump(jumpArr1));
        System.out.println(Arrays.asList(jumpArr1) + "'s min jump steps: " + ArrayTest.jump2(jumpArr1));
        System.out.println(Arrays.asList(jumpArr1) + "'s min jump steps: " + ArrayTest.jump3(jumpArr1));
        System.out.println(Arrays.asList(jumpArr1) + "'s min jump steps: " + ArrayTest.jump4(jumpArr1));

        System.out.println(Arrays.asList(jumpArr2) + "'s min jump steps: " + ArrayTest.jump(jumpArr2));
        System.out.println(Arrays.asList(jumpArr2) + "'s min jump steps: " + ArrayTest.jump2(jumpArr2));
        System.out.println(Arrays.asList(jumpArr2) + "'s min jump steps: " + ArrayTest.jump3(jumpArr2));
        System.out.println(Arrays.asList(jumpArr2) + "'s min jump steps: " + ArrayTest.jump4(jumpArr2));

        System.out.println(Arrays.asList(jumpArr3) + "'s min jump steps: " + ArrayTest.jump(jumpArr3));
        System.out.println(Arrays.asList(jumpArr3) + "'s min jump steps: " + ArrayTest.jump2(jumpArr3));
        System.out.println(Arrays.asList(jumpArr3) + "'s min jump steps: " + ArrayTest.jump3(jumpArr3));
        System.out.println(Arrays.asList(jumpArr3) + "'s min jump steps: " + ArrayTest.jump4(jumpArr3));

        ArrayTest.jumpPath(jumpArr1);
        ArrayTest.jumpPath2(jumpArr1);

        ArrayTest.jumpPath(jumpArr2);
        ArrayTest.jumpPath2(jumpArr2);

        ArrayTest.jumpPath(jumpArr3);
        ArrayTest.jumpPath2(jumpArr3);
        //endregion

        ArrayTest.searchPath(5, 5);
        ArrayTest.searchAllPath(5, 5);

        ArrayTest.makesquareDemo(new int[]{1,1,2,2,2});
        ArrayTest.makesquareDemo(new int[]{3,3,3,3,4});
        ArrayTest.makesquareDemo(new int[]{5,5,5,5,4,4,4,4,3,3,3,3});
        //endregion

        System.out.println();

        // region DP Problems

        ArrayTest.wiggleMaxLength(new Integer[]{1,7,4,9,2,5});
        ArrayTest.wiggleMaxLength2(new Integer[]{1,7,4,9,2,5});
        ArrayTest.wiggleMaxLength3(new Integer[]{1,7,4,9,2,5});
        ArrayTest.wiggleMaxLength(new Integer[]{1,17,5,10,13,15,10,5,16,8});
        ArrayTest.wiggleMaxLength2(new Integer[]{1,17,5,10,13,15,10,5,16,8});
        ArrayTest.wiggleMaxLength3(new Integer[]{1,17,5,10,13,15,10,5,16,8});
        ArrayTest.wiggleMaxLength(new Integer[]{1,2,3,4,5,6,7,8,9});
        ArrayTest.wiggleMaxLength2(new Integer[]{1,2,3,4,5,6,7,8,9});
        ArrayTest.wiggleMaxLength3(new Integer[]{1,2,3,4,5,6,7,8,9});
        ArrayTest.wiggleMaxLength(new Integer[]{1,1,1,1,2});
        ArrayTest.wiggleMaxLength2(new Integer[]{1,1,1,1,2});
        ArrayTest.wiggleMaxLength3(new Integer[]{1,1,1,1,2});

        int size3 = 10;
        Integer [] ai1 = new Integer [size3];
        for (int i = 0; i < size3; i++) {
            ai1[i] = (int)(Math.random() * (size3 + 1));
        }
        ArrayTest.LIS(ai1, size3);

        Integer [] ai2 = new Integer [size3];
        for (int i = 0; i < size3; i++) {
            ai2[i] = (int)(Math.random() * (size3 + 1)) - size3/2;
        }
        ArrayTest.MCS(ai2, size3);
        ArrayTest.maxProduct(new Integer[]{2,3,-2,4});
        ArrayTest.maxProduct(new Integer[]{2,-1,3,-2,-3,4});

        Integer [][] ai3 = new Integer [5][size3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < size3; j++)
                ai3[i][j] = (int)(Math.random() * (size3 + 1)) - size3/2;
        }
        ArrayTest.MSC2Dimentional(ai3, 5, size3);

        Integer [] gas = new Integer [5];
        for (int i = 0; i < 5; i++) gas[i] = (int)(Math.random() * 11);
        Integer [] cost = new Integer [5];
        for (int i = 0; i < 5; i++) cost[i] = (int)(Math.random() * 11);
        ArrayTest.canCompleteCircuit(gas, cost);
        ArrayTest.canCompleteCircuit(new Integer[]{1,2,3,4,5}, new Integer[]{1,3,2,4,5});

        ArrayTest.maxSubsquare(10, 10);
        ArrayTest.maxSubRectangle(5, 10);

        // Test totalNumberOfChanges & minNumberOfChanges
        System.out.println();

        //Integer[] units = new Integer [] {3,7,6,2,5,11,4,1,10,13};
        Integer[] units = new Integer [] {3,7,6,2,5,11,4,10,13};
        Integer target = 56;
        ArrayTest.minNumberOfChanges(units, target);
        ArrayTest.minNumberOfChanges2(units, target);

        ArrayTest.totalNumberOfChanges(units, target);
        ArrayTest.totalNumberOfChanges2(units, target);
        ArrayTest.totalNumberOfChanges3(units, target);
        ArrayTest.totalNumberOfChanges4(units, target);

        ArrayTest.totalNumberOfChanges4(new Integer[]{4, 2, 1}, 32);
        ArrayTest.combinationSum4_2(new Integer[]{4, 2, 1}, 32);

//        try {
//            Integer times = 1;
//            long []TN1_RunnTime = new long[times];
//            long []TN2_RunnTime = new long[times];
//            long []TN3_RunnTime = new long[times];
//            Arrays.fill(TN1_RunnTime, 0);
//            Arrays.fill(TN2_RunnTime, 0);
//            Arrays.fill(TN3_RunnTime, 0);
//            Integer TN1 = (Integer)TestUtility.callMethodWithTimeReturn(ArrayTest.class.getDeclaredMethod("totalNumberOfChanges", Integer[].class, Integer.class), new Object[]{null, units, target, TN1_RunnTime});
//            Integer TN2 = (Integer)TestUtility.callMethodWithTimeReturn(ArrayTest.class.getDeclaredMethod("totalNumberOfChanges2", Integer[].class, Integer.class), new Object[]{null, units, target, TN2_RunnTime});
//            Integer TN3 = (Integer)TestUtility.callMethodWithTimeReturn(ArrayTest.class.getDeclaredMethod("totalNumberOfChanges3", Integer[].class, Integer.class), new Object[]{null, units, target, TN3_RunnTime});
//            System.out.println("TN1 of " + target + " from units:" + Arrays.asList(units) + " is " + TN1);
//            System.out.println("TN2 of " + target + " from units:" + Arrays.asList(units) + " is " + TN2);
//            System.out.println("TN3 of " + target + " from units:" + Arrays.asList(units) + " is " + TN3);
//            long TN1_Average = TN1_RunnTime[0];
//            long TN2_Average = TN2_RunnTime[0];
//            long TN3_Average = TN3_RunnTime[0];
//            for (int i = 1; i < times; i++) {
//                TN1_Average = (long)((double)i/(i+1) * (double)TN1_RunnTime[i] + 1.0/(double)(i+1) * (double)TN1_RunnTime[i]);
//                TN2_Average = (long)((double)i/(i+1) * (double)TN2_RunnTime[i] + 1.0/(double)(i+1) * (double)TN2_RunnTime[i]);
//                TN3_Average = (long)((double)i/(i+1) * (double)TN3_RunnTime[i] + 1.0/(double)(i+1) * (double)TN3_RunnTime[i]);
//            }
//            System.out.println("Average time for TN1: " + TN1_Average);
//            System.out.println("Average time for TN2: " + TN2_Average);
//            System.out.println("Average time for TN3: " + TN3_Average);
//        } catch (NoSuchMethodException | SecurityException ex) {
//            Logger.getLogger(Experiment.class.getName()).log(Level.SEVERE, null, ex);
//        }


        Double C = 1.0;
        Double L = 3.4;
        int kth = 5;
        System.out.println("C: " + C + "; L: " + C + "; kth: " + kth + " => " + ArrayTest.calculateWaterVol(C, L, kth));

        ArrayTest.testMaxContinuousSubArray();

        Integer W = 4;
        Integer[] width = new Integer[] {1, 2, 1, 1, 2, 1};
        Integer[] height = new Integer[] {1, 2, 5, 4, 3, 1};
        ArrayTest.minBookShelfCost(width, height, W);

        Integer ML = 10;
        Integer[] length = new Integer[] {5, 4, 1, 2, 7, 1, 5, 10, 6, 1, 3, 7, 2, 4, 3};
        Integer[] start = new Integer[length.length]; // Start means: for the ith word, start[ith] == index of the first word of the line for the ith word, so that the total cost from 1st word to ith word is minimized
        ArrayTest.textJustification(length, ML, start);

        Integer KW = 11;
        Integer[] value = new Integer[] {1, 6, 18, 22, 28};
        Integer[] weight = new Integer[] {1, 2, 5, 6, 7};
        ArrayTest.knapsack(value, weight, KW);

        Integer [] numForBalancedPartition = new Integer [10];
        for (int i = 0; i < 10; i++) numForBalancedPartition[i] = (int)(Math.random()*10 + 1);
        ArrayTest.balancedPatition(numForBalancedPartition);

        ArrayTest.maxProfitIV2(3, new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4});
        ArrayTest.maxProfitIV3(3, new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4});

        ArrayTest.maxProfitV(new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4});
        ArrayTest.maxProfitV(new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4});

        for (int t = 0; t < 20; t++) {
            int ss = (int) (Math.random() * 10) + 5;
            Integer[] prices = new Integer[ss];
            for (int i = 0; i < ss; i++) {
                prices[i] = (int) (Math.random() * 10) + 1;
            }
            ArrayTest.maxProfitV(prices);
            ArrayTest.maxProfitV2(prices);
        }

        Integer[][] matrix10 = new Integer[][] {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };
//        ArrayTest.calculateMinimumHP(matrix10);
        Integer[][] matrix11 = new Integer[][] {
                {100},
        };
//        ArrayTest.calculateMinimumHP(matrix11);
        Integer[][] matrix12 = new Integer[][] {
                {1, -3},
                {0, -2},
        };
//        Integer[][] matrix12 = new Integer[][] {
//                {1, -3, 3},
//                {0, -2, 0},
//                {-3, -3, -3}
//        };
//        ArrayTest.calculateMinimumHP(matrix12);
//        Integer[][] matrix13 = new Integer[][] {
//                {1, 2},
//                {-2, -3},
//        };
        Integer[][] matrix13 = new Integer[][] {
                {1, 2, 1},
                {-2, -3, -3},
                {3, 2, -2}
        };
        ArrayTest.calculateMinimumHP(matrix13);
        Integer[][] matrix14 = new Integer[][] {
                {  0,-74,-47,-20,-23,-39,-48},
                { 37,-30, 37,-65,-82, 28,-27},
                {-76,-33,  7, 42,  3, 49,-93},
                { 37,-41, 35,-16,-96,-56, 38},
                {-52, 19,-37, 14,-65,-42,  9},
                {  5,-26,-30,-65, 11,  5, 16},
                {-60,  9, 36,-36, 41,-47,-86},
                {-22, 19, -5,-41, -8,-96,-95}
        };
        ArrayTest.calculateMinimumHP(matrix14);

        ArrayTest.getMoneyAmount(5);

        ArrayTest.largestDivisibleSubset(new Integer[]{1,2,4,8,10,12});
        ArrayTest.largestDivisibleSubset2(new Integer[]{1,2,4,8,10,12});

        Integer[][] buildings = new Integer[][] {
            {2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}
        };
        ArrayTest.getSkyline(buildings);

        ArrayTest.maxCoins(new Integer[]{3, 1, 5, 8});
        ArrayTest.maxCoins(new Integer[]{1, 5});

        ArrayTest.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3);
        // DP Problem
        // endregion

//        ArrayTest.containsNearbyAlmostDuplicateDemo(new Integer[]{-1,2147483647}, 1, 2147483647);
//        ArrayTest.containsNearbyAlmostDuplicateDemo(new Integer[]{7, 1, 3}, 2, 3);
        ArrayTest.containsNearbyAlmostDuplicateDemo(new Integer[]{10, 100, 11, 9, 100, 10}, 1, 2);

        ArrayTest.summaryRanges(new Integer[] {0,1,2,4,5,7});
        ArrayTest.summaryRanges(new Integer[] {0,1,2,4,5,7,8,9});

        ArrayTest.totalHammingDistance2(new Integer[]{4, 14, 2});

        ArrayTest.findMinHeightTrees(4, new Integer[][]{{1,0},{1,2},{1,3}});
        ArrayTest.findMinHeightTrees(4, new Integer[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        ArrayTest.findMinHeightTrees(7, new Integer[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});

        ArrayTest.kSmallestPairs(new Integer[]{1,7,11}, new Integer[]{2, 4, 6}, 9);

        ArrayTest.wiggleSort(new Integer[]{3, 5, 2, 1, 6, 4});
        ArrayTest.wiggleSortII(new Integer[]{1, 5, 1, 1, 7, 6, 4});
        ArrayTest.wiggleSortII(new Integer[]{1, 5, 1, 1, 6, 4});


        ArrayTest.longestIncreasingPath(new Integer[][]{
                {9,9,4},
                {6,6,8},
                {2,1,1}
        });
        ArrayTest.longestIncreasingPath(new Integer[][]{
                {3, 4, 5, 2},
                {3, 2, 6, 8},
                {2, 2, 1, 4},
                {1, 7, 3, 7}
        });

        ArrayTest.findRadius(new int[]{1,2,3,4}, new int[]{1,4});

        ArrayTest.isSelfCrossingDemo(new int[]{2, 1, 1, 2});
        ArrayTest.isSelfCrossingDemo(new int[]{1, 2, 3, 4});
        ArrayTest.isSelfCrossingDemo(new int[]{1, 1, 1, 1});

        ArrayTest.increasingTripletDemo(new int[]{1,2,3,4,5});
        ArrayTest.increasingTripletDemo(new int[]{5, 4, 3, 2, 1});
        ArrayTest.increasingTripletDemo(new int[]{2, 4, 4, 3, 5});
//findNumSolution
        ArrayTest.islandPerimeter2Demo(new int[][]{
                {1,1},
                {1,1}
        });

//        ArrayTest.calcEquation(new String[][]{
//                    {"a", "b"}, {"b", "c"}
//                },
//                new double[]{2.0, 3.0},
//                new String[][]{
//                    {"a", "c"}
//                });
        ArrayTest.calcEquation(new String[][]{
                        {"a", "b"}, {"b", "c"}
                },
                new double[]{2.0, 3.0},
                new String[][]{
                        {"a", "b"}, {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}
                });
        ArrayTest.calcEquation(new String[][]{
                        {"x1","x2"}, {"x2","x3"}, {"x3","x4"}, {"x4","x5"}
                },
                new double[]{3.0,4.0,5.0,6.0},
                new String[][]{
                        {"x1","x5"}, {"x5","x2"}, {"x2","x4"}, {"x2","x2"}, {"x2","x9"}, {"x9","x9"}
                });

        ArrayTest.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        ArrayTest.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        ArrayTest.maxNumber(new int[]{8,0,4,4,1,7,3,6,5,9,3,6,6,0,2,5,1,7,7,7,8,7,1,4,4,5,4,8,7,6,2,2,9,4,7,5,6,2,2,8,4,6,0,4,7,8,9,1,7,0}, new int[]{6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4}, 50);

        ArrayTest.canCrossDemo(new int[]{0,1,3,5,6,8,12,17});
        ArrayTest.canCrossDemo(new int[]{0,1,2,3,4,8,9,11});

        ArrayTest.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});
        ArrayTest.fourSumCount2(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});
        ArrayTest.fourSumCount2(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});

        ArrayTest.find132patternDemo(new int[]{1,2,3,4,5});
        ArrayTest.find132patternDemo(new int[]{3, 1, 4, 2});
        ArrayTest.find132patternDemo(new int[]{-1, 3, 2, 0});
        ArrayTest.find132patternDemo(new int[]{4, 5, 1, 3, 2});

        ArrayTest.findContentChildren(new int[]{1,2,3}, new int[]{1,1});
        ArrayTest.findContentChildren(new int[]{1,2}, new int[]{1,2,3});
        ArrayTest.findContentChildren(new int[]{1,3,4}, new int[]{1,2});
        ArrayTest.findContentChildren(new int[]{2,2,2}, new int[]{1,3,4});

        ArrayTest.validUtf8Demo(new int[]{197, 130, 1});
        ArrayTest.validUtf8Demo(new int[]{235, 140, 4});
        ArrayTest.validUtf8Demo(new int[]{145});
        ArrayTest.validUtf8Demo(new int[]{3});

        int[][] matrix4 = new int[][]{
                { 1,  5,  10},
                {10, 11, 13},
                {12, 13, 15}
        };
        for (int i = 1; i <= 9; i++) {
            ArrayTest.kthSmallest(matrix4, i);
        }
//        int[][] matrix5 = new int[][]{
//                { 1,  5,  9},
//                {10, 11, 13},
//                {12, 13, 15}
//        };

        ArrayTest.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        ArrayTest.topKFrequent(new int[]{1,1,1,2,1,3,4,5,2,2,3,3,3,4,1,5,5,3,3,2,2,3}, 2);

        ArrayTest.findDuplicates(new int[]{4,3,2,7,8,2,3,1});

        ArrayTest.reconstructQueue(new int[][]{
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        });
        ArrayTest.reconstructQueue2(new int[][]{
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        });

        ArrayTest.thirdMax(new int[]{2,2,3,1});
        ArrayTest.thirdMax(new int[]{1,2,-2147483648});

        ArrayTest.canPartition(new int[]{100,100,100,100,100,100,100,100});

        ArrayTest.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
//        ArrayTest.trapRainWater(new int[][]{
//                {1,4,3,1,3,2},
//                {3,2,1,3,2,4},
//                {2,3,3,2,3,1}
//        });

//        ArrayTest.trapRainWater(new int[][]{
//                {12, 13, 1, 12},
//                {13, 4, 13, 12},
//                {13, 8, 10, 12},
//                {12, 13, 12, 12},
//                {13, 13, 13, 13}
//        });

        ArrayTest.pacificAtlantic(new int[][]{
                {1,2},
                {2,3}
        });

        ArrayTest.pacificAtlantic(new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        });

        ArrayTest.pacificAtlantic2(new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        });

        ArrayTest.eraseOverlapIntervals(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(1,2), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,3), new ArrayTest.Interval2(3,4), new ArrayTest.Interval2(3,5), new ArrayTest.Interval2(4,6)
        });
        ArrayTest.eraseOverlapIntervals2(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(1,2), new ArrayTest.Interval2(1,2), new ArrayTest.Interval2(1,2)
        });
        ArrayTest.eraseOverlapIntervals3(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(1,2), new ArrayTest.Interval2(1,2), new ArrayTest.Interval2(1,2)
        });
        ArrayTest.eraseOverlapIntervals(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(1,2), new ArrayTest.Interval2(2,3)
        });
        ArrayTest.eraseOverlapIntervals(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(0,1), new ArrayTest.Interval2(1,3), new ArrayTest.Interval2(3,5), new ArrayTest.Interval2(6,9), new ArrayTest.Interval2(2,4), new ArrayTest.Interval2(4,7), new ArrayTest.Interval2(7,8), new ArrayTest.Interval2(8,9)
        });

        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(3,4)
        });
        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(3,4), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,2)
        });
        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(1,4), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(3,4)
        });
        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{
                new ArrayTest.Interval2(4,5), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,2)
        });
    }
//        try {
//            /*
//            Class[] cArgForJump = new Class[1];
//            cArgForJump[0] = Integer[].class;
//            Object[] paraForJump = new Object[1];
//
//            Class[] cArgForJump = new Class[2];
//            cArgForJump[0] = Integer.class;
//            cArgForJump[1] = Integer.class;
//            Method funcCanJump = arrayTestClassHandler.getDeclaredMethod("testPrint", cArgForJump);
//            */
//            ArrayList<Method> functions = new ArrayList<> ();
//            functions.add(ArrayTest.class.getDeclaredMethod("canJump", Integer[].class));
//            functions.add(ArrayTest.class.getDeclaredMethod("canJump2", Integer[].class));
//            functions.add(ArrayTest.class.getDeclaredMethod("canJump3", Integer[].class));
//            functions.add(ArrayTest.class.getDeclaredMethod("jump", Integer[].class));
//            functions.add(ArrayTest.class.getDeclaredMethod("jump2", Integer[].class));
//            functions.add(ArrayTest.class.getDeclaredMethod("jumpPath", Integer[].class));
//
////            HashMap<Method, ArrayList<ArrayList<Object>>> functionsToRun = new HashMap<> ();
////            ArrayList<ArrayList<Object>> inputs = new ArrayList<> ();
////            inputs.add(new ArrayList<> (Arrays.asList(null, jump1)));
////            inputs.add(new ArrayList<> (Arrays.asList(null, jump2)));
////            inputs.add(new ArrayList<> (Arrays.asList(null, jump3)));
////            functionsToRun.put(ArrayTest.class.getDeclaredMethod("canJump", Integer[].class), (ArrayList<ArrayList<Object>>)inputs.clone());
////            functionsToRun.put(ArrayTest.class.getDeclaredMethod("canJump2", Integer[].class), (ArrayList<ArrayList<Object>>)inputs.clone());
////            functionsToRun.put(ArrayTest.class.getDeclaredMethod("canJump3", Integer[].class), (ArrayList<ArrayList<Object>>)inputs.clone());
////            functionsToRun.put(ArrayTest.class.getDeclaredMethod("jump", Integer[].class), (ArrayList<ArrayList<Object>>)inputs.clone());
////            functionsToRun.put(ArrayTest.class.getDeclaredMethod("jump2", Integer[].class), (ArrayList<ArrayList<Object>>)inputs.clone());
////            functionsToRun.put(ArrayTest.class.getDeclaredMethod("jumpPath", Integer[].class), (ArrayList<ArrayList<Object>>)inputs.clone());
////
////            for (Method func : functionsToRun.keySet()) {
////                for (ArrayList<Object> para : functionsToRun.get(func)) {
////                    TestUtility.callMethod(func, para.toArray());
////                }
////            }
//
//            HashMap<Method, ArrayList<Object[]>> functionsToRun = new HashMap<> ();
//            ArrayList<Object[]> inputs = new ArrayList<> ();
//            inputs.add(new Object [] {null, jumpArr1});
//            inputs.add(new Object [] {null, jumpArr2});
//            inputs.add(new Object [] {null, jumpArr3});
//            functionsToRun.put(ArrayTest.class.getDeclaredMethod("canJump", Integer[].class), (ArrayList<Object[]>)inputs.clone());
//            functionsToRun.put(ArrayTest.class.getDeclaredMethod("canJump2", Integer[].class), (ArrayList<Object[]>)inputs.clone());
//            functionsToRun.put(ArrayTest.class.getDeclaredMethod("canJump3", Integer[].class), (ArrayList<Object[]>)inputs.clone());
//            functionsToRun.put(ArrayTest.class.getDeclaredMethod("jump", Integer[].class), (ArrayList<Object[]>)inputs.clone());
//            functionsToRun.put(ArrayTest.class.getDeclaredMethod("jump2", Integer[].class), (ArrayList<Object[]>)inputs.clone());
//            functionsToRun.put(ArrayTest.class.getDeclaredMethod("jumpPath", Integer[].class), (ArrayList<Object[]>)inputs.clone());
//
//            for (Method func : functionsToRun.keySet()) {
//                for (Object[] para : functionsToRun.get(func)) {
//                    TestUtility.callMethod(func, para);
//                }
//            }
//
//
//            for (Method func : functions) {
////                TestUtility.callMethod(func, new Object[]{null, jump1});
////                TestUtility.callMethod(func, new Object[]{null, jump2});
////                TestUtility.callMethod(func, new Object[]{null, jump3});
//            }
////            Method funcCanJump = ArrayTest.class.getDeclaredMethod("canJump", Integer[].class);
////            TestUtility.callMethod(funcCanJump, new Object[]{null, jump1});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump2", Integer[].class), new Object[]{null, jump1});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump3", Integer[].class), new Object[]{null, jump1});
////
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump", Integer[].class), new Object[]{null, jump2});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump2", Integer[].class), new Object[]{null, jump2});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump3", Integer[].class), new Object[]{null, jump2});
////
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump", Integer[].class), new Object[]{null, jump3});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump2", Integer[].class), new Object[]{null, jump3});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("canJump3", Integer[].class), new Object[]{null, jump3});
////
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("jump", Integer[].class), new Object[]{null, jump1});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("jump2", Integer[].class), new Object[]{null, jump1});
////
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("jump", Integer[].class), new Object[]{null, jump2});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("jump2", Integer[].class), new Object[]{null, jump2});
////
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("jump", Integer[].class), new Object[]{null, jump3});
////            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("jump2", Integer[].class), new Object[]{null, jump3});
//
//            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("testPrint", Integer.class, Integer.class), new Object[]{null, 1, 2});
//
//            TestUtility tu = new TestUtility();
//            ArrayTest at = new ArrayTest();
//            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("testPrint", Integer.class, Integer.class), new Object[]{at, 3, 4});
//            TestUtility.callMethod(ArrayTest.class.getDeclaredMethod("testPrintNonStatic", Integer.class, Integer.class), new Object[]{at, 5, 6});
//            tu.callMethodNoStatic(ArrayTest.class.getDeclaredMethod("testPrintNonStatic", Integer.class, Integer.class), new Object[]{at, 7, 8});
//
//        } catch (NoSuchMethodException | SecurityException ex) {
//            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
//        }



//        TODO
//        int size3 = 10;
//        Integer [] ai6 = new Integer [size3];
//        for (int i = 0; i < size3; i++) {
//            ai6[i] = (int)(Math.random() * size3 * 2) + 1;
//        }
//        Integer maxLen = ArrayTest.longestConsecutiveSequence (ai6);
//        System.out.println("MaxLen = " + maxLen);
}
