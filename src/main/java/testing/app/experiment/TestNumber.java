package testing.app.experiment;

import testing.lib.number.NumberTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestNumber {
    public static void run () {
        List<Integer> lip = new ArrayList<>();

        NumberTest.generatePrimeNumber(100, lip);
        System.out.println(lip);

        int n1 = 366;
        int n2 = 132;
        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + NumberTest.GCDv3(n1, n2));

        int n3 = 53412879;
        NumberTest.reverseDigit(n3);

        int k = 20;
        NumberTest.kthNum(k);

        int size = 20;
        Integer [] ai = new Integer [size];
        for (int i = 0; i < size; i++) {
            ai[i] = (int)(Math.random() * (size + 1));
        }
//        Sort.<Integer>quickSort(ai, size);
        NumberTest.LIS(ai, size);

        int a = (int)(Math.random() * (100 + 1));
        int b = (int)(Math.random() * (100 + 1));
        System.out.println(a + " + " + b + " = " + NumberTest.add_no_arithm(a, b));

        int a1 = (int)(Math.random() * (1000 + 1));
        int flip = NumberTest.flipInteger(a1);
        if (flip >= 0)
            System.out.println(a1 + " <->" + flip);
        else
            System.out.println(a1 + " <-> -1");

        NumberTest.powDemo(2, 2);
        NumberTest.powDemo(2, -2);
        NumberTest.powDemo(2, 0);
        NumberTest.powDemo(1, 10);
        NumberTest.powDemo(10, 2);
        NumberTest.powDemo(10, -2);

        Double ad = Math.random() * 2;
        Double sqrtad = NumberTest.sqrt(ad);
        System.out.println("\t" + sqrtad + " * " + sqrtad + " = " + sqrtad*sqrtad + "(" + ad + ")");
        NumberTest.sqrt(0.000001);
        NumberTest.sqrt(0.0000001);

        Integer [] testArr = new Integer [] {3, 3, 2, 1, 3, 2, 4, 4, 2, 4};
        NumberTest.singleNumber(testArr);

        String number = "+.8";
        System.out.println(number + " is number? " + NumberTest.isNumber(number));

        String RomanNumber = "MMMCMXCIX"; //MCMXLIII MCMXC MMXIV MMMCMXCIX
        int ConvertedNumber = NumberTest.romanToInt(RomanNumber);
        String ConvertedRonman  = NumberTest.intToRoman (ConvertedNumber);
        String ConvertedRonman2 = NumberTest.intToRoman2(ConvertedNumber);
        System.out.println(RomanNumber + " = " + ConvertedNumber);
        System.out.println(ConvertedNumber + " = " + ConvertedRonman);
        System.out.println(ConvertedNumber + " = " + ConvertedRonman2);

        NumberTest.factorCombination(24);

        NumberTest.divideIntegersDemo(9, 2);
        NumberTest.divideIntegersDemo(9, -2);
        NumberTest.divideIntegersDemo(-9, 2);
        NumberTest.divideIntegersDemo(-9, -2);
        NumberTest.divideIntegersDemo(9, 3);
        NumberTest.divideIntegersDemo(9, 9);
        NumberTest.divideIntegersDemo(9, 10);

//        NumberTest.divideWithStop(-25, 5);
//        NumberTest.divideWithStop2(-25, 5);
//        NumberTest.divideWithStop(4, 2);
        NumberTest.divideWithStop2(4, 2);
//        NumberTest.divideWithStop(2, 3);
//        NumberTest.divideWithStop2(2, 3);

//        int[] nums = {3, 30, 34, 5, 9};
        Integer[] nums = {2, 2281};
        System.out.println(NumberTest.largestNumber(nums));

        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(NumberTest.reverseBits(1)));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println((Math.log10(1)/Math.log10(2)));
        System.out.println((Math.log10(0)/Math.log10(2)));
        System.out.println(Integer.toBinaryString(NumberTest.rangeBitwiseAnd(20000, 2147483647)));

        System.out.println("NumberTest.computeArea(-3, 0, 3, 4, 0, -1, 9, 2) = " + NumberTest.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));

        NumberTest.getPermutationDemo(3);
        NumberTest.getPermutationDemo2(3);
//        NumberTest.getPermutation2(3, 3);

        NumberTest.combinationSum3(3, 9);

        NumberTest.combinationSum4(new Integer[]{1, 2, 3}, 4);
        NumberTest.combinationSum4_2(new Integer[]{1, 2, 3}, 4);
//        NumberTest.combinationSum4(new Integer[]{4, 2, 1}, 32);
        NumberTest.combinationSum4_2(new Integer[]{4, 2, 1}, 32);

        NumberTest.addDigitsDemo(38);


        NumberTest.nthUglyNumberDemo(1600);
        NumberTest.nthUglyNumberDemo2(1600);
        NumberTest.nthSuperUglyNumber(1600, new Integer[]{2, 3, 5});
//        NumberTest.nthSuperUglyNumber2(1600, new Integer[]{2, 3, 5});
        NumberTest.nthSuperUglyNumber(12, new Integer[]{2, 7, 13, 19});
        NumberTest.nthSuperUglyNumber2(12, new Integer[]{2, 7, 13, 19});
        NumberTest.nthSuperUglyNumber2(20, new Integer[]{2, 7, 13, 19});

        NumberTest.bulbSwitch(2);
        NumberTest.bulbSwitch(3);
        NumberTest.bulbSwitch(4);
        NumberTest.bulbSwitch(5);

        NumberTest.numSquaresDemo(11);
        NumberTest.numSquaresDemo(12);
        NumberTest.numSquaresDemo(13);
        NumberTest.numSquaresDemo(14);
        NumberTest.numSquaresDemo(15);
        NumberTest.numSquaresDemo(16);
        NumberTest.numSquaresDemo(17);
        NumberTest.numSquaresDemo(18);

        NumberTest.isPerfectSquare(808201);
        NumberTest.isPerfectSquare2(808201);
        NumberTest.isPerfectSquare3(808201);

        NumberTest.countBits2(0);
        NumberTest.countBits2(1);
        NumberTest.countBits2(2);
        NumberTest.countBits2(5);

        NumberTest.readBinaryWatch(1);
        NumberTest.readBinaryWatch(3);

        NumberTest.findNthDigit(11);

//        NumberTest.integerReplacement(11);
//        NumberTest.integerReplacement2(11);
//        NumberTest.integerReplacement(111);
        NumberTest.integerReplacement2(111);
//        NumberTest.integerReplacement(211);
//        NumberTest.integerReplacement2(211);
//        NumberTest.integerReplacement(57);
//        NumberTest.integerReplacement2(57);

        for (int n = 1; n <= 12; n++) {
            NumberTest.lastRemaining(n);
        }
//        NumberTest.lastRemaining(1000000);

        NumberTest.lexicalOrder(13);
        NumberTest.findKthNumber2(13, 1);
        NumberTest.findKthNumber2(13, 2);
        NumberTest.findKthNumber2(13, 3);
        NumberTest.findKthNumber2(13, 4);
        NumberTest.findKthNumber2(13, 5);
        NumberTest.findKthNumber2(13, 6);
        NumberTest.findKthNumber2(13, 7);
        NumberTest.findKthNumber2(13, 8);
        NumberTest.findKthNumber2(13, 9);
        NumberTest.findKthNumber2(13, 10);
        NumberTest.findKthNumber2(13, 11);
        NumberTest.findKthNumber2(13, 12);
        NumberTest.findKthNumber2(13, 13);
        NumberTest.findKthNumber(99, 8);
        NumberTest.findKthNumber2(99, 8);

//        NumberTest.toHex(26);
        NumberTest.toHex(-1);

        NumberTest.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});

        NumberTest.numbersByRecursion(2);

        NumberTest.findComplement(5);

        NumberTest.isStrobogrammaticDemo("69");
        NumberTest.isStrobogrammaticDemo("818");
        NumberTest.isStrobogrammaticDemo("868");

        NumberTest.findStrobogrammatic(0);
        NumberTest.findStrobogrammatic(1);
        NumberTest.findStrobogrammatic(2);
        NumberTest.findStrobogrammatic(3);

        NumberTest.strobogrammaticInRange("100", "200");

        NumberTest.findCelebrityDemo(4);
    }
}
