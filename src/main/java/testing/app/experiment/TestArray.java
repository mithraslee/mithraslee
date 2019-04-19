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

        ArrayTest.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
        ArrayTest.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 2);
        ArrayTest.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1);

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

        ArrayTest.subsetsWithNoDup(new Integer [] {3, 2, 1});
        ArrayTest.subsetsWithNoDup2(new Integer [] {3, 2, 1});
        ArrayTest.subsetsWithDupRecursive(new Integer [] {1, 2, 2});
        ArrayTest.subsetsWithDupRecursive2(new Integer [] {1, 2, 2});
        ArrayTest.subsetsWithDupRecursive3(new Integer [] {1, 2, 2});
        ArrayTest.subsetsWithDupIterative(new Integer [] {1, 2, 2});

        ArrayTest.combinationSumWithNoDupInput(new Integer [] {2, 3, 4, 6, 7}, 10);

        //region Combination Sum
        ArrayTest.combinationSum(new Integer [] {2, 3, 4, 6, 7}, 7);
        ArrayTest.combinationSum(new Integer [] {2, 2, 3, 4, 6, 7}, 7);

        ArrayTest.combinationSumI_2(new Integer [] {2, 3, 4, 6, 7}, 7);
        ArrayTest.combinationSumI_2(new Integer [] {2, 2, 3, 4, 6, 7}, 7);

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
        ArrayTest.jumpPath3(jumpArr1);

        ArrayTest.jumpPath(jumpArr2);
        ArrayTest.jumpPath2(jumpArr2);
        ArrayTest.jumpPath3(jumpArr2);

        ArrayTest.jumpPath(jumpArr3);
        ArrayTest.jumpPath2(jumpArr3);
        ArrayTest.jumpPath3(jumpArr3);

        ArrayTest.dragonChallengeDemo(new ArrayList<Integer>(Arrays.asList(new Integer[]{5,6,0,4,2,4,1,0,0,4})));
        ArrayTest.dragonChallengeDemo(new ArrayList<Integer>(Arrays.asList(new Integer[]{5,6,0,4,2,4,1,0,0,0})));
        ArrayTest.dragonChallengeDemo(new ArrayList<Integer>(Arrays.asList(new Integer[]{2,3,1,1,4})));
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

//        Integer KW = 11;
        Integer KW = 10;
        Integer[] value = new Integer[] {1, 6, 18, 22, 28};
        Integer[] weight = new Integer[] {1, 2, 5, 6, 7};
        ArrayTest.knapsack(value, weight, KW);
        ArrayTest.knapsackWithRepetition(value, weight, KW);

        Integer [] numForBalancedPartition = new Integer [10];
        for (int i = 0; i < 10; i++) numForBalancedPartition[i] = (int)(Math.random()*10 + 1);
        ArrayTest.balancedPatition(numForBalancedPartition);

        ArrayTest.maxProfitII(new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4});
        ArrayTest.maxProfitVI(new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4}, 2);
        ArrayTest.maxProfitVI(new Integer[]{2, 3, 1, 7, 5, 4, 6, 3, 1, 4}, 1);

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
//        ArrayTest.getSkyline(buildings);
        Integer[][] buildings2 = new Integer[][] {
                {0,2,3}, {4,6,3}, {2,4,3}
        };
        ArrayTest.getSkyline(buildings2);

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
        ArrayTest.totalHammingDistance3(new Integer[]{4, 14, 2});

        ArrayTest.findMinHeightTrees(4, new Integer[][]{{1,0},{1,2},{1,3}});
        ArrayTest.findMinHeightTrees2(4, new Integer[][]{{1,0},{1,2},{1,3}});
        ArrayTest.findMinHeightTrees(4, new Integer[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        ArrayTest.findMinHeightTrees2(4, new Integer[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        ArrayTest.findMinHeightTrees(7, new Integer[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});
        ArrayTest.findMinHeightTrees2(7, new Integer[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}});

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
            ArrayTest.kthSmallest2(matrix4, i);
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

        ArrayTest.numIslands2(3, 3, new int[][]{
                {0,0}, {0,1}, {1,2}, {2,1}
        });
        ArrayTest.numIslands2(1, 2, new int[][]{
                {0,1}, {0,0}
        });
        ArrayTest.numIslands2(21, 71, new int[][]{
        {19,28},{14,38},{15,44},{17,12},{6,19},{11,69},{2,30},{7,43},{19,6},{7,29},{10,21},{17,55},{20,66},{12,28},{11,64},{12,52},{18,15},{2,52},{10,20},{0,50},{16,5},{17,25},{12,67},{6,45},{13,17},{5,55},{10,42},{20,17},{3,26},{20,61},{14,10},{9,1},{9,69},{6,29},{11,53},{3,66},{4,45},{12,65},{11,35},{5,67},{18,35},{2,57},{12,12},{13,53},{9,65},{13,0},{3,18},{13,39},{5,54},{20,43},{19,29},{17,37},{17,45},{3,38},{2,61},{2,65},{3,21},{5,40},{10,4},{12,36},{2,8},{3,33},{15,4},{13,35},{0,45},{20,29},{10,66},{19,7},{0,46},{19,11},{10,22},{19,0},{0,9},{2,20},{16,64},{10,37},{16,49},{4,20},{20,68},{10,38},{17,59},{15,54},{17,60},{19,18},{0,60},{9,62},{3,69},{10,44},{15,2},{14,44},{17,0},{18,42},{17,28},{11,10},{11,42},{11,67},{0,32},{8,0},{17,6},{7,26},{17,65},{17,66},{7,38},{8,17},{7,60},{0,16},{7,59},{18,8},{16,63},{7,0},{11,46},{0,7},{6,4},{2,63},{8,56},{18,18},{12,70},{2,15},{14,65},{13,52},{11,0},{10,48},{7,8},{11,44},{0,35},{4,64},{6,36},{16,17},{7,34},{1,33},{11,60},{17,11},{4,58},{4,9},{18,7},{15,40},{11,24},{17,3},{7,9},{1,38},{1,14},{15,21},{14,68},{14,69},{16,40},{5,60},{18,46},{15,51},{7,65},{1,34},{15,55},{19,63},{5,35},{20,9},{13,1},{20,69},{19,67},{17,44},{12,44},{10,49},{12,43},{14,21},{18,11},{11,9},{4,56},{6,70},{8,54},{1,55},{17,47},{18,38},{3,31},{16,37},{13,7},{15,6},{18,33},{4,60},{17,40},{7,3},{3,32},{13,41},{5,62},{17,4},{20,5},{15,32},{19,31},{8,69},{19,58},{3,35},{6,64},{0,37},{15,56},{6,46},{4,42},{4,51},{2,7},{7,13},{20,47},{10,29},{12,18},{20,52},{5,5},{12,34},{1,57},{7,32},{3,58},{14,29},{2,32},{2,46},{14,5},{3,9},{19,68},{18,16},{19,2},{6,23},{20,3},{10,69},{9,0},{0,13},{20,38},{6,14},{0,21},{6,50},{2,5},{1,20},{5,20},{1,5},{10,0},{7,6},{15,13},{8,21},{7,14},{9,9},{19,8},{13,25},{5,30},{1,16},{18,19},{16,44},{4,5},{15,37},{20,14},{20,8},{5,23},{13,44},{17,56},{13,62},{2,18},{1,58},{17,2},{20,40},{8,9},{8,52},{6,24},{19,65},{7,48},{20,51},{2,21},{7,39},{11,27},{7,22},{12,6},{19,12},{12,66},{0,55},{20,62},{11,20},{2,35},{2,0},{6,7},{5,41},{9,37},{8,44},{16,15},{9,48},{18,54},{19,52},{19,24},{19,46},{5,0},{19,50},{2,37},{18,31},{6,20},{4,59},{5,39},{9,38},{19,51},{3,67},{11,33},{7,57},{13,47},{20,64},{8,24},{13,69},{4,11},{4,46},{13,32},{18,3},{20,54},{18,17},{7,5},{15,12},{12,7},{6,11},{5,4},{17,26},{7,12},{12,68},{8,45},{8,2},{15,34},{12,20},{1,26},{6,54},{19,16},{0,17},{9,13},{4,65},{12,58},{11,52},{8,32},{18,32},{11,50},{9,50},{17,13},{11,17},{16,53},{18,26},{2,42},{14,58},{0,23},{19,44},{9,39},{15,47},{11,70},{10,35},{8,41},{15,39},{20,50},{2,50},{17,39},{1,28},{7,63},{16,61},{15,58},{19,17},{11,40},{20,46},{12,41},{6,32},{2,67},{4,52},{14,24},{0,43},{17,34},{6,56},{2,53},{1,69},{0,11},{16,48},{1,47},{14,12},{7,23},{8,37},{17,18},{7,27},{7,2},{10,63},{13,6},{3,23},{12,8},{1,52},{11,30},{9,57},{16,57},{9,58},{4,38},{18,36},{10,17},{20,24},{13,64},{18,37},{4,21},{17,33},{2,33},{15,10},{8,40},{14,52},{19,1},{2,45},{11,55},{3,40},{8,31},{20,57},{6,33},{6,22},{6,28},{2,11},{4,15},{4,31},{16,26},{9,27},{10,61},{5,52},{3,68},{0,19},{13,40},{0,52},{18,22},{1,24},{13,29},{12,33},{16,58},{19,66},{6,62},{18,40},{17,58},{2,34},{15,63},{8,23},{14,50},{20,16},{6,9},{8,1},{3,0},{20,10},{15,23},{1,0},{13,4},{8,25},{10,13},{12,9},{18,39},{3,24},{20,63},{16,39},{7,36},{15,65},{13,10},{19,20},{3,54},{12,35},{17,49},{17,31},{14,48},{18,65},{2,44},{9,51},{17,64},{16,36},{7,10},{5,9},{12,13},{6,59},{13,21},{8,14},{10,67},{20,56},{6,53},{18,25},{14,39},{8,70},{10,27},{0,48},{0,36},{12,56},{3,28},{15,14}
    });
        ArrayTest.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        ArrayTest.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});
        ArrayTest.numberOfArithmeticSlicesII(new int[]{2, 4, 6, 8, 10});
        ArrayTest.numberOfArithmeticSlicesII2(new int[]{2, 4, 6, 8, 10});
//        ArrayTest.numberOfArithmeticSlicesII(new int[]{2, 4, 6, 8, 10});
        ArrayTest.numberOfArithmeticSlicesII(new int[]{2, 2, 2, 2, 2});
        ArrayTest.numberOfArithmeticSlicesII2(new int[]{2, 2, 2, 2, 2});
        ArrayTest.numberOfArithmeticSlices(new int[]{1,2,3,4,5,6,7});
        ArrayTest.numberOfArithmeticSlicesII(new int[]{1,2,3,4,5,6,7});
        ArrayTest.numberOfArithmeticSlicesII2(new int[]{1,2,3,4,5,6,7});
        ArrayTest.numberOfArithmeticSlicesII2(new int[]{2,2,3,4});

//        ArrayTest.trapRainWater(new int[][]{
//                {1,4,3,1,3,2},
//                {3,2,1,3,2,4},
//                {2,3,3,2,3,1}
//        });

        ArrayTest.trapRainWater(new int[][]{
                {12, 13, 1, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}
        });

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

        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{new ArrayTest.Interval2(3,4)});
        ArrayTest.findRightInterval2(new ArrayTest.Interval2[]{new ArrayTest.Interval2(3,4)});

        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{new ArrayTest.Interval2(3,4), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,2)});
        ArrayTest.findRightInterval2(new ArrayTest.Interval2[]{new ArrayTest.Interval2(3,4), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,2)});

        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{new ArrayTest.Interval2(1,4), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(3,4)});
        ArrayTest.findRightInterval2(new ArrayTest.Interval2[]{new ArrayTest.Interval2(1,4), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(3,4)});

        ArrayTest.findRightInterval(new ArrayTest.Interval2[]{new ArrayTest.Interval2(4,5), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,2)});
        ArrayTest.findRightInterval2(new ArrayTest.Interval2[]{new ArrayTest.Interval2(4,5), new ArrayTest.Interval2(2,3), new ArrayTest.Interval2(1,2)});

        ArrayTest.minMoves2(new int[]{6, 7, 8, 12, 4});
        ArrayTest.minMoves2(new int[]{6, 7, 8, 12, 5});
        ArrayTest.minMoves2(new int[]{1, 2, 3, 6, 7, 8});
        ArrayTest.minMoves2(new int[]{1, 3, 5, 5, 6, 7});
        ArrayTest.minMoves2(new int[]{1, 0, 0, 8, 6});
        ArrayTest.minMoves2_2(new int[]{1, 0, 0, 8, 6});
        ArrayTest.minMoves2_3(new int[]{1, 0, 0, 8, 6});

        ArrayTest.findMinArrowShots(new int[][]{
                {10,16}, {2,8}, {1,6}, {7,12}
        });

        ArrayTest.findMinArrowShots(new int[][]{
                {1,4}, {2,3}, {3,8}, {4,6}, {5,7}, {6, 8}
        });

        ArrayTest.numberOfBoomerangs(new int[][]{
                {0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}
        });

        ArrayTest.majorityElementII(new int[]{1,2,2,3,2,1,1,3});
        ArrayTest.majorityElementII2(new int[]{1,2,2,3,2,1,1,3});
        ArrayTest.majorityElementII3(new int[]{8,8,7,7,7});
        ArrayTest.majorityElementII3(new int[]{1,2,2,3,2,1,1,3});
        ArrayTest.majorityElementIII(new int[]{8,8,7,7,7}, 3);
        ArrayTest.majorityElementIII(new int[]{1,2,2,3,2,1,1,3}, 3);
        ArrayTest.majorityElementIII(new int[]{1,2,2,3,2,1,1,3}, 4);

        ArrayTest.splitArray(new int[]{7,2,5,10,8}, 2);
        ArrayTest.splitArray(new int[]{1, 4, 4}, 3);
        ArrayTest.splitArray(new int[]{6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4}, 8);
        ArrayTest.splitArray(new int[]{5334,6299,4199,9663,8945,3566,9509,3124,6026,6250,7475,5420,9201,9501,38,5897,4411,6638,9845,161,9563,8854,3731,5564,5331,4294,3275,1972,1521,2377,3701,6462,6778,187,9778,758,550,7510,6225,8691,3666,4622,9722,8011,7247,575,5431,4777,4032,8682,5888,8047,3562,9462,6501,7855,505,4675,6973,493,1374,3227,1244,7364,2298,3244,8627,5102,6375,8653,1820,3857,7195,7830,4461,7821,5037,2918,4279,2791,1500,9858,6915,5156,970,1471,5296,1688,578,7266,4182,1430,4985,5730,7941,3880,607,8776,1348,2974,1094,6733,5177,4975,5421,8190,8255,9112,8651,2797,335,8677,3754,893,1818,8479,5875,1695,8295,7993,7037,8546,7906,4102,7279,1407,2462,4425,2148,2925,3903,5447,5893,3534,3663,8307,8679,8474,1202,3474,2961,1149,7451,4279,7875,5692,6186,8109,7763,7798,2250,2969,7974,9781,7741,4914,5446,1861,8914,2544,5683,8952,6745,4870,1848,7887,6448,7873,128,3281,794,1965,7036,8094,1211,9450,6981,4244,2418,8610,8681,2402,2904,7712,3252,5029,3004,5526,6965,8866,2764,600,631,9075,2631,3411,2737,2328,652,494,6556,9391,4517,8934,8892,4561,9331,1386,4636,9627,5435,9272,110,413,9706,5470,5008,1706,7045,9648,7505,6968,7509,3120,7869,6776,6434,7994,5441,288,492,1617,3274,7019,5575,6664,6056,7069,1996,9581,3103,9266,2554,7471,4251,4320,4749,649,2617,3018,4332,415,2243,1924,69,5902,3602,2925,6542,345,4657,9034,8977,6799,8397,1187,3678,4921,6518,851,6941,6920,259,4503,2637,7438,3893,5042,8552,6661,5043,9555,9095,4123,142,1446,8047,6234,1199,8848,5656,1910,3430,2843,8043,9156,7838,2332,9634,2410,2958,3431,4270,1420,4227,7712,6648,1607,1575,3741,1493,7770,3018,5398,6215,8601,6244,7551,2587,2254,3607,1147,5184,9173,8680,8610,1597,1763,7914,3441,7006,1318,7044,7267,8206,9684,4814,9748,4497,2239}, 9);

        ArrayTest.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1);
        ArrayTest.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 2);
        ArrayTest.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        ArrayTest.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4);
        ArrayTest.maxSlidingWindow(new int[]{1, 3, -1}, 3);
        ArrayTest.maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);

//        ArrayTest.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1);
//        ArrayTest.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 2);
//        ArrayTest.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        ArrayTest.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4);
//        ArrayTest.medianSlidingWindow(new int[]{1, 3, -1}, 3);
//        ArrayTest.medianSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);
        ArrayTest.medianSlidingWindow(new int[]{5,2,2,7,3,7,9,0,2,3}, 9);

        ArrayTest.threeSumSmaller(new int[]{1,1,-2}, 1);

        ArrayTest.findPeakElementDemo(new int[]{1, 2, 3, 1});
        ArrayTest.findPeakElementDemo(new int[]{1, 2, 1});
        ArrayTest.findPeakElementDemo(new int[]{1, 2});
        ArrayTest.findPeakElementDemo(new int[]{2, 1});
        ArrayTest.findPeakElementDemo(new int[]{2});

        ArrayTest.getModifiedArray(5, new int[][]{
                {1,  3,  2},
                {2,  4,  3},
                {0,  2, -2}
        });

//        ArrayTest.minTransfers(new int[][]{
//                {0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}
//        });
//        ArrayTest.minTransfers(new int[][]{
//                {0, 1, 10}, {2, 0, 5}
//        });
        ArrayTest.minTransfers(new int[][]{
                {1,2,3},{1,3,3},{6,4,1},{5,4,4}
        });
        ArrayTest.minTransfers2(new int[][]{
                {1,2,3},{1,3,3},{6,4,1},{5,4,4}
        });


        ArrayTest.minMeetingRooms(new int[][]{
                {15, 20},{0, 30},{5, 10}
        });

        ArrayTest.minMeetingRooms2(new int[][]{
                {15, 20},{0, 30},{5, 10}
        });

//        ArrayTest.minMeetingRooms3(new int[][]{
//                {15, 20},{0, 30},{5, 10}
//        });
        ArrayTest.minMeetingRooms3(new int[][]{
                {2, 7}
        });

        ArrayTest.multiply(new int[][]{{1, 0, 0},{-1, 0, 3}}, new int[][]{{7, 0, 0},{0, 0, 0},{0, 0, 1}});
        ArrayTest.multiply2(new int[][]{{1, 0, 0},{-1, 0, 3}}, new int[][]{{7, 0, 0},{0, 0, 0},{0, 0, 1}});

//        ArrayTest.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99);
//        ArrayTest.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 1, 99);
//        ArrayTest.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 1, 75);
//        ArrayTest.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 1, 70);
//        ArrayTest.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 10, 70);
        ArrayTest.findMissingRanges(new int[]{-1}, -1, 0);
        ArrayTest.findMissingRanges(new int[]{2147483647}, 0, 2147483647);
        ArrayTest.findMissingRanges(new int[]{-2147483648,2147483647}, -2147483648, 2147483647);

//        ArrayTest.minCostII(new int[][]{
//                {4,16},{15,5},{18,17},{10,12},{14,10},{3,10},{2,11},{18,14},{9,1},{14,13}
//        });
        ArrayTest.minCostII(new int[][]{
                {1,2},{1,19},{17,13},{3,20},{20,16},{9,8},{2,7},{19,18},{14,1},{16,20},{5,8},{10,10},{1,15},{15,6},{16,13},{17,2},{11,16},{6,13},{5,7},{17,5},{16,13},{19,1}
        });

        ArrayTest.numWays(3, 3);
        ArrayTest.numWays2(3, 3);

        ArrayTest.wallsAndGates(new int[][]{
                {Integer.MAX_VALUE,                -1,                 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,                -1},
                {Integer.MAX_VALUE,                -1, Integer.MAX_VALUE,                -1},
                {0,                -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
//                {3, -1, 0,  1},
//                {2,  2, 1, -1},
//                {1, -1, 2, -1},
//                {0, -1, 3,  4}
        });

        ArrayTest.shortestDistanceDemo(new int[][]{
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        });

        ArrayTest.numberOfPatterns2(1, 1);
        ArrayTest.numberOfPatterns2(3, 3);

        ArrayTest.findMaxConsecutiveOnes(new int[]{1,0,1,1,0});
        ArrayTest.findMaxConsecutiveOnes2(new int[]{1,0,1,1,0});
        ArrayTest.findMaxConsecutiveOnes3(new int[]{1,0,1,1,0});

        ArrayTest.isReflectedDemo(new int[][]{
                {1,1},{-1,1}
        });
        ArrayTest.isReflectedDemo(new int[][]{
                {1,1},{-1,-1}
        });
        ArrayTest.isReflectedDemo(new int[][]{
                {0,0},{1,0},{3,0}
        });
        ArrayTest.isReflectedDemo(new int[][]{
                {0,0},{2,0},{4,0}
        });
        ArrayTest.isReflectedDemo(new int[][]{
                {0,0}
        });
        ArrayTest.isReflectedDemo(new int[][]{
                {1,2},{2,2},{1,4},{2,4}
        });

//        ArrayTest.countRangeSumDemo(new int[]{-2, 5, -1}, -2, 2);
        ArrayTest.countRangeSumDemo(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864);

        ArrayTest.isRectangleCoverDemo(new int[][]{
                {1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}
        });

        ArrayTest.poorPigs(1000, 15, 60);
        ArrayTest.poorPigs2(1000, 15, 60);
        ArrayTest.poorPigs(125, 15, 60);
        ArrayTest.poorPigs2(125, 15, 60);

        ArrayTest.findTargetSumWays(new int[]{1,1,1,1,1}, 3);

        ArrayTest.findSubsequencesDemo(new int[]{4,6,7,7,7});

        ArrayTest.PredictTheWinnerDemo(new int[]{1,5,2});
        ArrayTest.PredictTheWinnerDemo(new int[]{1,5,233,7});

        ArrayTest.minArea(new Character[][]{
                {'0', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '1', '0', '0'}
        }, 0, 2);

        ArrayTest.hasPathDemo(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        }, new int[]{0, 4}, new int[]{4, 4});

        ArrayTest.hasPathDemo(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        }, new int[]{0, 4}, new int[]{3, 2});

//
//        ArrayTest.shortestDistanceDemo(new int[][]{
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        }, new int[]{0, 4}, new int[]{4, 4});
//
//        ArrayTest.shortestDistanceDemo(new int[][]{
//                {0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0},
//                {1, 1, 0, 1, 1},
//                {0, 0, 0, 0, 0}
//        }, new int[]{0, 4}, new int[]{3, 2});
//
//        ArrayTest.shortestDistanceDemo(new int[][]{
//                {0,0,0,0,1,0,0},
//                {0,0,1,0,0,0,0},
//                {0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,1},
//                {0,1,0,0,0,0,0},
//                {0,0,0,1,0,0,0},
//                {0,0,0,0,0,0,0},
//                {0,0,1,0,0,0,1},
//                {0,0,0,0,1,0,0}
//        }, new int[]{0, 0}, new int[]{8, 6});

//        ArrayTest.findShortestWayDemo(new int[][]{
//                {0, 0, 0, 0, 0},
//                {1, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {0, 1, 0, 0, 0}
//        }, new int[]{4, 3}, new int[]{0, 1});
//
//        ArrayTest.findShortestWayDemo(new int[][]{
//                {0, 0, 0, 0, 0},
//                {1, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {0, 1, 0, 0, 0}
//        }, new int[]{4, 3}, new int[]{3, 0});


//        ArrayTest.findShortestWayDemo(new int[][]{
//                {0,0,0,0,0,0,0},
//                {0,0,1,0,0,1,0},
//                {0,0,0,0,1,0,0},
//                {0,0,0,0,0,0,1}
//        }, new int[]{0, 4}, new int[]{2, 0});

        ArrayTest.findShortestWayDemo(new int[][]{
                {0,0,0,0,0},
                {1,1,0,0,1},
                {0,0,0,0,0},
                {0,1,0,0,1},
                {0,1,0,0,0}
        }, new int[]{4, 3}, new int[]{0, 1});

//        ArrayTest.findShortestWayDemo(new int[][]{
//                {0,1,0,1,0,0,0,0,0,0,1},
//                {0,1,0,1,1,1,0,1,1,0,0},
//                {1,0,0,0,0,0,0,0,0,0,1},
//                {0,0,0,1,1,1,0,1,0,0,1},
//                {1,1,0,0,0,1,0,0,0,1,1},
//                {0,1,0,0,0,0,0,1,0,1,0},
//                {0,0,0,0,1,0,0,1,1,1,0}
//        }, new int[]{0, 4}, new int[]{1, 6});

//        ArrayTest.shortestDistanceDemo(new int[][]{
//                {0,0,1,1,1,0,0,0,1,0,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,0,0,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,1,0,0,1,1,1,1,0,0,1,0,0,0},{0,0,1,0,1,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,0,1,1,1,0,0,0,1,0,0,0,1,1,1,0,1,1,1,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,0,0,0,0,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,0,1,0,1,0,1,1,1,1,1,0,0,0,1},{0,1,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,1,1,0,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,0,1,0,1,1,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,1,1,0,1,1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,1,0,0,1,0,1,0},{1,0,0,0,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,0,1,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,1,0,1,1,0,1,1,0,1,1,0,1,1,1,0,1,0,0,0,1,1,0,1,0,1,0,1,1,0,0,1,0},{1,1,0,1,1,0,0,0,0,1,1,1,1,1,0,1,1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,0,1,0,0,0,1,0,1,1,0,1,1,1,1,0,1,1,0,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0},{0,1,0,0,1,1,0,1,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,1,0,1,1,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,0,0,0,0,1,1,1,0,0,1,1,0,0,1,1,0,1,0,0,1,1,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1},{0,0,1,1,0,0,0,1,1,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,0,0,1,1,0,1,1,0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1,0,0,1,0,1,1,0,0,1,1,1,1,0,1,0,1,1,1,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,0,0,1,1},{1,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,1,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,1,1,0,1,0,0,0,0,0,1,1,1,0,0,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,1,0,1,1,1},{1,0,1,0,1,1,1,1,0,0,0,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,0,1,0,1,0,1,1,1,0,1,1,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,0,0,1,1,0},{0,1,1,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,1,1,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,1,0,1,1,0,0,1,1,0,0,0,0,1,0,1,1,1,1,1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,0},{0,1,1,0,0,1,1,0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1,1,0,1,0,1,1,1,1,1,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,1,1},{1,0,1,1,1,1,1,0,0,0,0,1,0,0,1,1,1,1,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,0,1,0,1,1,0,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,1},{0,1,0,1,0,0,1,1,0,1,1,1,0,1,1,1,1,0,1,0,1,1,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,1,0,1,1,0,1,1,1,1,1,1,0,0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,1,1,0,1,0,1,1},{1,1,1,1,0,0,0,1,1,0,1,1,0,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,1,0,1,0,0,1,0,1,1,0,0,0,1,0,1,0,1,0},{1,1,1,1,0,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1,1,0,1,0,0,1,0,1,0,0,1,1,0,1,0,0,1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,0,1,0,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1,0,1,1,1,1,1,0,1},{0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,1,1,0,1,1,0,1,1,1,1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,0,0,0,0,1,0,1,1,1,0,0,0,0,1,0,1,0,0,0},{0,1,1,0,0,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,0,0,0,0,1,0,1,0,1,0,1,1,0,1,0,1,0,0,1,1,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,0,1,1,1,0,0,1,1,0,0,1,0,1,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1,1,1,0,0,1,1,0},{0,0,1,0,1,0,1,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0,0,0,1,1,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,1},{0,1,0,0,1,1,0,1,0,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,1,0,1,0,1,1,1,1,0,0,0,1,0,0,1,0,1,0,1,0},{1,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,1,0,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,0,0,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,1,1,0,0,1,1,0,1,0,1,1,1,1,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1,0,1,1,0,0,1},{0,1,1,0,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,0,1,0,1,1,0,0,1,1,1,1,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1,1,0,0,0,0,1,1,0,0,1,0,1,1},{1,1,1,0,1,1,1,0,0,0,1,0,1,1,1,0,0,1,0,0,0,1,0,1,1,1,0,1,0,0,0,0,1,1,0,1,0,1,0,1,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,1,1,0,1,0,1,0,0,1,0,1,0,1,1,1,1,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1,1,0,0,1,1,0,1},{1,1,0,1,0,0,1,0,0,1,1,0,0,0,1,0,1,1,0,0,0,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,0,0,0,0,0,1,1,1,1,0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,1,0,0,1,1,1,0,1,0,0,0,1,1,1,1,1,0,1,1,1,0,0,1,0,1,1,1,1,1,0,0,1,1,0,0,1,1,1,0},{1,0,1,1,1,1,1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,0,0,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,0,1,1,0,1,1,1,1,1,0,0,0,1,0,1,0,0,0,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,1,0,0,1,1,1,1,0,0},{0,0,1,1,0,1,0,0,1,1,0,1,0,1,1,0,0,1,0,1,0,0,0,1,1,0,1,0,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,1,0,1,0,0,1,1,1,1,1,1,0,1,1,1,0,0,1,0,1,0,1,0,1,1,1,0,1,0,0,0,1,1,1,0,1,1,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0},{0,1,1,0,1,1,0,1,1,0,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,0,1,0,1,1,0,1,1,0,0,1,0,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,1,1,1,0,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1},{1,1,0,0,1,1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,0,1,0,0,1,0,0,0,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,0,0,1,1,1,0,1,1,0,0,1,0,1,0,0,1,1,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,0,0,1,1,1},{0,1,1,1,1,1,0,1,1,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,1,0,0,1,0,0,0,0,1,1,1,1,0,1,1,1,0,1,1,0,0,0,1,1,0,1,0,1,1,1,1,1,1,0,1,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,1,0},{0,1,0,0,1,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,1,0,0,1,0,1,1,0,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,1,0,0,0,1,0},{1,0,0,1,0,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,0,0,1,1,0,0,1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,0,1,0,1,1,1,1,1,1,0,0,1,1,1,0,0,0,0,1,0,0,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,1,0,0,1,1,0,0,1,0,1,1,1,0,1},{1,0,0,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,1,0,0,1,1,0,1,0,0,0,1,0,1,1,0,0,0,1,0,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,0,1,1,1},{1,1,0,1,0,1,0,0,0,0,0,0,1,0,0,1,0,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,1,1,0,0,1,1,0,0,0,0,0,1,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,1,1,0,1,0,1,1,1,0,0,1,0},{1,0,1,1,0,1,0,0,1,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,0,0,0,1,1,1,1,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,1,0,1,1,0,0,1,0,1,0,0,1,1,1,1,0},{0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,0,0,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,1,0,0,1,1,0,0,1,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,0,1},{0,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1,1,0,0,0,1,0,0,1,0,0,1,1,1,1,0,1,1,1,1,0,0,0,1,0,1,1,0,1,1,1,0,1,0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1,0,1,0,1,0},{0,0,1,0,0,0,1,1,0,1,0,1,0,0,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,1,1,0,0,1,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,1,1,0,0,1,1,1,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,1,1,1,1,0,0,1,1,0,1,0,0},{1,1,1,1,0,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,1,1,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,0,0,1,0,1,1,1,1,0,1,0,0,1,1,1,0,0,0,1,1,0,0,1,1,0,0,1,0,0,0,0,1,1,0,1,0,0,0,0,1,0,1,0,1,0,0,1,1,0,1,1,0,1,1,1,1,0,1},{1,0,1,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,1,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,0,1,0,0,1,1,1,1,0,1,0,1,1,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,1},{1,0,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,1,0,1,0,1,0,1,1,1,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,1,1,1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,1,0,0,0},{0,1,0,1,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0,1,1,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,0,1,0,0,0,0,1,0,1,1,0,0,0,1,0,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0,1,1,0,0,1,0,1,1,1},{0,0,1,1,1,1,1,1,0,1,1,1,1,0,0,0,1,0,1,0,1,0,1,1,0,0,0,1,1,0,0,1,1,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,1,1,0,0,1,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0,0,1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,1},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,1,1,0,0,1,0,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,1,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,0,1,0,0,1,1,0,1,0,0,0,1,0,1,0,0,1,0,0,1,0,0,1,0,1,1,0,1,0,1,1,1},{0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,1,0,1,1,1,1,1,0,0,1,0,0,0,1,0,1,1,0,1,0,0,0,0,1,1,0,1,0,0,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,0,0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,0},{1,1,0,1,0,1,0,0,1,1,1,0,0,1,1,0,0,1,1,0,1,0,0,1,1,0,0,1,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,0,1,0,1,0,0,0,0,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,1,1,1,1},{1,1,0,0,1,1,0,1,1,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,0,1,1,0,1,1,1,1,0,0,0,0,1,0,0,1,1,0,1,0,1,1,1,0,1,1,0,1,1,0,1,1,1,0,1,1,0,0,0,1,1,1,0,1,0,0,1,0,1,1,0,1,1,0,1,0,1,0,1,0,0,1,0,1},{0,1,0,1,0,1,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,1,0,0,1,0,1,0,1,1,1,1,0,1,1,0,1,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,1,0,1,1,0,1,0,0,0,0,1,1,0,0,1,1,0,0,0,0},{1,0,1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,0,1,0,1,0,0,1,1,1,0,1,0,1,1,0,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,1,1,0,0,1,0,1,1,0,1,0,1,1},{0,1,0,0,1,0,0,1,0,1,1,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,1,0,0,1,1,0,1,1,0,1,0,0,0,1,0,1,0,0,0,1,1,0,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,1,0},{0,1,0,0,1,0,0,1,1,1,1,1,0,0,1,1,0,1,1,0,0,0,0,0,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,1,1,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,1,0,0,1,1,1,1,1,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,0,0,1,1,0,1,0,1},{1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,1,0,1,1,1,0,1,1,1,0,0,1,0,0,1,1,1,0,0,1,1,0,0,1,1,1,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,0,0,1,1,1,0,0,0,0,1,0,0,0,1,1,0,1,1,1,0,0,0,0,1,0,1},{1,0,0,1,1,0,0,0,1,0,0,1,1,1,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,0,1,1,1,1,1,0,0,0,0,1,1,0,1,1,1,0,1,1,0,1,0,1,0,1,1,0,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,1,1,0,1,1,1,0,1,0,1,0,0,1,1,1,1,1,1,1,0,0,0,1},{0,1,0,0,0,0,1,0,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,0,0},{0,1,1,0,0,1,1,0,0,1,1,0,0,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,0,1,1,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,1,0,0,1,0,1,0,1,1,1,1},{1,0,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,1,1,0,1,0,0,0,0,1,0,0,1,1,1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,1,1,1,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,1,1,0,0,1,0,1,1,0,1,0,0,1,1,1,0,0,0,1,0,0,1,0,1,1,0,0,1,0,0,0,1},{0,0,1,1,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,0,1,1,1,0,0,1,0,0,0,0,1,0,1,1,0,0,0,1,1,1,0,1,1,0,1},{1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,0,1,1,1,0,1,0,1,0,1,0,0,1,0,1,1,1,1,0,1,1,0,0,0,0,1,0,1,1,0,1,1,0,1,0,0,0,1,0,0,1,0,1,1,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,0,1,0,1,1,0,0,0,1},{0,1,1,0,0,1,0,0,1,1,0,1,0,1,0,1,0,1,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,1,1,1,0,1,1,0,1,0,0,0,0,1,1,1,0,0,1,1,0,1,0,0,1,0,1,0,1,0,0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,0,0,0,0,1,0,1,1,1,1,0,1,0,1,0,1,0,0,0,0},{1,1,1,1,1,0,0,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,0,0,0,0,0,1,0,1,0,1,0,0,0,1,1,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,1,1,1,1,1,0,0,1,1,0,0,1,0,1,1,0,0},{0,1,1,0,0,1,0,1,0,1,1,1,0,1,1,1,0,0,1,0,1,1,1,0,0,0,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,0,1,1,1,0,0,1,1,1,0},{0,0,0,0,1,0,1,0,1,0,1,1,0,1,1,1,0,0,0,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,0,1,1,1,0,1,1,0,0,1,0,1,0,1,1,1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,0,1,1,0,1,1,1,0,1,0,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,0,1},{0,1,1,0,0,0,0,1,1,0,1,0,0,1,1,0,1,1,1,1,1,1,1,0,1,1,0,1,0,0,1,0,0,1,0,0,0,1,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,0,1,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1},{0,0,0,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,1,1,1,0,1,0,1,1,1,0,0,1,0,0,1,1,0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,1,0,0,0,1,0,1,0,0,1,0,0,0},{1,0,1,1,0,1,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0,1,1,1,0,1,1,1,0,0,0,0,0,0,1,1,0,1,0,1,0,1,0,0,1,0,1,1,1,0,1,1,1,1,0,0,1,0,0,0,1,0,1,1,1,1,0,1,1,1,0,0,1,1,1,1,0,0,1,1,0,1,1,1,0,1,0,0},{0,0,0,1,0,0,0,1,0,1,1,0,1,0,0,0,0,0,1,1,1,1,1,0,1,0,1,1,0,0,1,0,1,0,0,1,1,1,1,0,1,0,0,1,0,1,0,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,1,1,1,0,0,1,1,0,1,1,0,0,1,0,0,0,0,1,1,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,1,0},{0,1,0,0,0,1,1,1,0,1,1,0,1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,0,0,1,0,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,1,1,0,1,0,1,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,1,0,0,1,1,1,0,0,1,0},{1,0,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1,1,0,0,1,0,1,0,0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,0,1,1,0,1,0,0,0,0,1,0,0,1,1,0,1,1,1,0,0,1,0,0,0,0,1,0,0},{0,0,1,0,0,1,0,1,0,1,1,1,0,1,1,0,1,0,0,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,1,0,1,0,0,1,0,1,1,1,0,0,0,0,0,1,1,1,1,0,1,1,0,1,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,1,1,0,0,1,1,1,1,1,0,1,1,1,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,1,1,1,0,0,1,0,1,0,0,0,1,1,1,1,1,0,1,1,0,1,0,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,1,0,0,1,0,1,0,0,0,1},{0,0,0,0,0,0,1,1,1,1,0,1,1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,0,0,1,1,0,0,1,1,0,1,0,1,0,1,1,0,1,1,1,1,1,0,0,0,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1,1,0,1,0},{0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,0,1,1,0,0,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,0,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,1,0},{1,0,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,1,0,0,1,0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,1,1},{0,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,1,1,0,0,0,0,0,1,1,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,1,0,0,1,0,1,0,1,1},{0,0,1,1,0,1,0,1,0,1,0,0,1,1,1,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,0,1,1,0,1,0,1,0,0,1,1,0,0,1,0,1,0,0,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,0,1,1,0,0,1,1,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1,0,1,1},{0,1,1,0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,1,0,0,1,1,0,0,0,0,0,0,1,0,0,1,1,1,1,0,0,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,0,1,0,1,0,1,0,0,1,0,1,1,1},{1,0,1,1,1,1,0,1,1,1,1,0,0,1,0,1,1,0,1,0,1,1,1,1,1,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,1,1,1,0,1,1,0,1,0,1,1,1,0,0,0,0,1,1,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,1,0,0,1,0},{1,1,1,1,0,1,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,1,1,0,0,0,0,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,1,0,1,1,0,1,1,1,0,1,1,0,0,0,1,1,0,1,1,1,1,1,0,0,0,1,1,1,0,1,0,0,0,1,0,1,1,0,1},{1,0,1,1,1,0,1,1,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1,1,0,1,0,0,0,1,1,0,1,1,0,0,0,0,1,0,0,1,1,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,1,1,1,0,1,0,0,0,1,0,1,1,1,0,0,0,0,1},{1,1,0,1,1,1,0,0,0,1,0,1,1,1,0,1,0,1,0,0,1,0,1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0,1,1,0,1,0,1,0,0,0,1,1,1,1,0,1,0,0,0,1,1,0,0,0,0,1,0,0,1,0,1,1,0,0,0,1,1,0,0,1,0,0,0},{1,0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,0,0,0,1,1,0,0,0,0,0,1,1,0,1,0,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,1,1,1,1,0,1,1,0,1,0,0,0,1,1,0,1,1,1,0,1,0,0,1,1,1,0,1,1,1,0,0,0,1,0,0,0,0,0},{1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,0,1,0,0,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,0,1,1,0,1,0,0,1,1,1,0,0,0,0,1,0,1,0,0,1,1,1,0,0,1,1,0},{1,1,1,1,0,1,1,0,1,0,0,0,1,0,0,1,0,0,1,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,1,0,1,1,0,0,1,0,0,0,1,0,0,1,1,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1,1,1,0,0,0,0,0,1,1,1,0,1,0,0,1,1,1,0,0,1,0,1,0,0},{0,0,0,1,1,0,0,0,1,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,0,0,1,1,0,1,1,0,1,0,0,0,0,1,0,1,0,1,1,1,0,0,0,1,0,0,1,0,1,0,1,0,1,1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,0,1,1,0,1,1,0,0,0,1,1,1,0,0,0,1,0,1,1,1,1,0,1,1},{0,1,0,0,1,0,0,0,1,1,0,1,1,1,1,1,1,1,1,0,0,1,0,0,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0,0,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,1,0,0,1,0,1,1,0,1,0,0,1,1,1,0,0,1,0,0,1,1,0,0,0,1,0,1,1,1,1,0},{0,1,0,1,1,0,1,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,1,1,1,0,0,1,1,0,1,0,1,0,1,1,0,1,1,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,1,1,0,1,0,1,1},{0,1,1,1,1,1,0,0,1,1,0,1,0,1,0,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,0,1,1,0,0,0,1,0,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,0,1,1,0,0,0,1,0,0,1,0,0,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,0,1,0,0,0,0,0,1,1,1},{1,1,1,1,0,0,0,0,1,1,1,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,0,1,1,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,0,1,0,0,0,1,1,0,0,0,0},{1,0,0,1,1,0,1,0,0,1,1,0,1,1,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,1,0,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,0,0,1,1,0,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,1,1,0,0},{0,1,0,0,0,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,0,1,1,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,0,1,1,0,1,1,1,0,0,1,0,1,0,1,0,1,0,0,1,0,0,1,0,0,0,0,1,0},{1,1,0,1,0,1,1,1,1,1,1,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1,0,0,0,1,1,0,0,0,1,1,1,0,1,1,0,1,1,0,1,1,0,0,0,1,1,0,1,1,0,0,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,1,1,1,0,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,1,0,0,0},{1,0,0,0,0,1,0,0,1,1,1,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0,0,1,0,0,1,0,0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,0,0,1,0,1,1,0,1,1,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,1,0,1},{1,0,0,1,1,1,1,0,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,0,1,1,1,1,1,0,1,0,0,1,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,1,0,0,0,1,1,0,1,0,1,1,1,1},{1,0,0,1,0,0,0,0,1,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,0,1,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,0,1,1,0,1,0,0,1,0,0,1,0,1,0,0,1,0,0,0,1,0,1,1,0,1,1,1,1,1,0,0,0,1,1,0,1,1},{1,1,1,1,0,0,1,0,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,1,1,0,1,0,0,1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1,0,0,1,0,1,0,1,1,1,0,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,0,1,0,0},{0,0,1,0,1,0,1,1,1,1,1,0,1,1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,0,0,1,1,0,0,0,1,1,0,1,1,1,0,0,1,1,1,0,1,0,1,1,1,1,1,0,0,1,0,1,1,1,0,0,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,1,1,1,1,0,0,0,1,1,0,1,0,0,0,0,1},{0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,1,1,0,0,0,1,1,0,1,1,1,0,0,0,1,0,1,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,1,1,0,0,0,1,1,0,0,0,0,1,0,0,1,0,0,1,1,1,0,0,0,1,0,1,1,0,0,0,1,0,0,1,0},{1,1,0,1,1,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,0,0,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,0,1,1,1,0,1,0,0,0,1,1,0,1,0,1,0,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,1,0,0,0,0,1,1,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,1,0,1,0},{1,0,0,1,1,1,1,0,1,1,0,0,1,1,0,1,0,0,1,1,0,0,0,0,1,1,1,0,1,1,0,1,1,1,0,0,1,0,0,1,1,0,0,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,1,1,1,1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,1,0,1,0,0,1,0},{1,0,1,1,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,1,0,1},{0,0,1,1,0,1,0,0,0,0,1,0,0,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0,1,1,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,1,1,0,1,0,1,1,1,0,0,1,1,0,0,0,0,0,0,1,1,0,1,0,1,0,0,1,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,0,1,0,0,0},{0,1,1,1,0,0,1,0,0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1,0,1,1,0,0,1,1,0,0,1,0,1,0,0,1,1,0,1,0,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,0,1,0,1,1,0,0,0,0,0,1,1,0,1,0,1,1}}, new int[]{22, 94}, new int[]{63, 4});

        ArrayTest.findDiagonalOrder(new int[][]{
                { 1, 2, 3, 4},
                { 5, 6, 7, 8},
                { 9,10,11,12}
        });
        ArrayTest.findDiagonalOrder(new int[][]{
                { 1, 2, 3, 4}
        });
        ArrayTest.findDiagonalOrder(new int[][]{
                {1}, {2}, {3}, {4}
        });

        ArrayTest.leastIntervalOrdered(new Character[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        ArrayTest.leastIntervalOrdered2(new Character[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2);
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
