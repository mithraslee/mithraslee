/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.number;

import java.awt.*;
import java.util.*;
import java.lang.*;
import java.util.List;

import static testing.lib.common.CommonUtils.printArray;
import static testing.lib.common.CommonUtils.printTwoDimentinalArray;

/**
 *
 * @author yunl
 */
public class NumberTest {
    private static int [] flipDigit = {0, 1, -2, -3, -4, -5, 9, -7, 8, 6};
    
    public static boolean isPrime (int n) {
        if (n<2)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    
    public static void generatePrimeNumber (int n, List<Integer> lip) {
        for (int i = 2; i <= n; i++) {
            if (isPrime (i)) {
                lip.add(i);
            }
        }
    }
    
    public static int getKthPrimeNumber (int kth) {
        int count = 0;
        int i = 2;
        while (true) {
            if (isPrime(i)) {
                count++;
            }
            if (count == kth) {
                return i;
            } else {
                i++;
            }
        }
    }

    /**
     * Count Primes - Accepted
     * Total Accepted: 41610 Total Submissions: 190169 Difficulty: Easy
     * Description:
     * Count the number of prime numbers less than a non-negative number, n.
     *
     * https://leetcode.com/problems/count-primes/
     */
    public static int countPrimes(int n) {
        Boolean[] isPrime = new Boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static int fibRecursive (int n) {
        if (n <= 0)
            return 0;
        else if (n <= 2)
            return 1;
        else
            return fibRecursive(n-1) + fibRecursive(n-2);
    }
    
    public static int fibItrative (int n) {
        if (n <= 0)
            return 0;
        else if (n <= 2)
            return 1;
        else {
            int f = 0;
            int f1 = 1;
            int f2 = 1;
            
            for (int i = 3; i <= n; i++) {
                f = f1 + f2;
                f2 = f1;
                f1 = f;
            }
            return f;
        }
    }
    
    public static int GCDv1 (int x, int y) {
        if (x < y)
            return GCDv1(y,x);
        if (y == 0)
            return x;
        else 
            return GCDv1(y, x%y);
    }
    
    public static int GCDv2 (int x, int y) {
        if (x < y)
            return GCDv2(y, x);
        if (y == 0)
            return x;
        else
            return GCDv2(x-y, y);
    }
    
    public static int GCDv3 (int x, int y) {
        if (x < y)
            return GCDv2(y, x);
        if (y == 0)
            return x;
        else {
            if ((x & 0x1) == 0) {
                if ((y & 0x1) == 0) {
                    return GCDv3(x>>1, y>>1)<<1;
                } else {
                    return GCDv3(x>>1, y);
                }
            } else {
                if ((y & 0x1) == 0) {
                    return GCDv3(x, y>>1);
                } else {
                    return GCDv1(x, y);
                }
            }
        }
    }
    
    public static int reverseDigit (int n) {
        System.out.println("\nStart function reverseDigit(): n = " + n);
        int temp = 0;
        while (n > 0) {
            temp *= 10;
            temp += n%10;
            n /= 10;
        }
        System.out.println("\tResult = " + temp);
        return temp;
    }
    
    public static int toDecimal (int n, int scale) {
        System.out.println("\nStart function toDecimal(): n = " + n + "; scale = " + scale);
        if (n == 0)
            return 0;
        else
            return n%10 + scale * toDecimal(n/10, scale);
    }
    
    // Design an algorithm to fnd the kth number such that the only prime factors are 3, 5, and 7
    public static List<Integer> kthNum (int kth) {
        System.out.println("\nStart function textJustification(): kth = " + kth);
        List<Integer> res = new ArrayList<>();
        if (kth <= 0)
            return res;
        
        res.add(1);
        
        Queue<Integer> q3 = new LinkedList<>();
        q3.add(3);
        Queue<Integer> q5 = new LinkedList<>();
        q5.add(5);
        Queue<Integer> q7 = new LinkedList<>();
        q7.add(7);
        
        int x;
        while (res.size() < kth) {
            x = Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));
            
            if (x == q3.peek()) {
                int h3 = q3.poll();
                q3.add(h3 * 3);
                q5.add(h3 * 5);
                q7.add(h3 * 7);
            } else if (x == q5.peek()) {
                int h5 = q5.poll();
                q5.add(h5 * 5);
                q7.add(h5 * 7);
            } else {
                int h7 = q7.poll();
                q7.add(h7 * 7);
            }
            res.add(x);
        }
        System.out.println("\tResult: " + res);
        return res;
    }
    
    public static int LIS (Integer [] a, int size) {
        System.out.println("\nStart function LIS()");
        Integer [] b = new Integer[size];
        Arrays.fill(b, 0);
        
        b[0] = 1;
        
        for(int i = 1; i < size; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && b[j] > max) {
                    max = b[j];
                }
            }
            b[i] = max + 1;
        }
        
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (b[i] > max)
                max = b[i];
        }
        System.out.println("\ta: " + Arrays.asList(a));
        System.out.println("\tb: " + Arrays.asList(b));
        System.out.println("\tLongest Increasing Subarray of a is: " + max);
        
        return max;
    }
    
    public static int add_no_arithm (int a, int b) {
        if (b > a)
            return add_no_arithm (b, a);
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b)<<1;
        
        return add_no_arithm(sum, carry);
    }
    public static int flip (int a) {
        int b = 0;
        int sign = a > 0?-1:1;
        while (a != 0) {
            b += sign;
            a += sign;
        }
        return b;
    }
    public static int substract (int a, int b) {
        return a + flip(b);
    }
    public static int abs (int a) {
        if (a > 0) return a;
        else return flip(a);
    }
    public static int times (int a, int b) {
        if (a < b)
            return times(b, a);
        int sum = 0;
        for (int i = 0; i < abs(b); i++)
            sum += a;
        if (b < 0)
            return flip(sum);
        else
            return sum;
    }
    public static int divide (int a, int b) {
        if (b == 0) {
            System.out.println("Devided by zero");
            return -1;
        }
        int q = 0;
        int dividend = abs(a);
        int divisor = flip(abs(b));
        
        while (dividend + divisor > 0) {
            q++;
            dividend += divisor;
        }
        if (times(a, b) < 0)
            return flip(q);
        else
            return q;
    }

    /* Write a function to identify if an integer has the same value when reversed (i.e flipped over. 6 when reversed will be 9).
     * For example: the method should return true for the following integers
     * 818
     * 1691
     * 88
     * but should return false for
     * 8018
     * 212
     */
    public static int flipInteger (int n) {
        int temp = n;
        int flip = 0;
        
        while (temp > 0) {
            if (flipDigit[temp%10] < 0)
                return -1;
            else {
                flip *= 10;
                flip += flipDigit[temp%10];
                temp /= 10;
            }
        }
        return flip;
    }

    /**
     * Implement int sqrt(int x).
     * Compute and return the square root of x.
     *
     * http://oj.leetcode.com/problems/powx-n
     */
    public static void powDemo(double x, int n) {
        System.out.println("\nStart function pow()");
        System.out.println("\tpow(" + x + ", " + n + ") = " + pow(x, n));
    }
    public static double pow(double x, int n) {
        if (n < 0) return 1.0/powHelper(x, -n);
        else return powHelper(x, n);
    }
    public static double powHelper(double x, int n) {
//        if (x == 0) return 0;
        if (n == 0) return 1.0;

        double half = powHelper(x, n/2);
        if (n%2 == 1)
            return half*half*x;
        else
            return half*half;
    }

    /**
     * Implement int sqrt(int x).
     * Compute and return the square root of x.
     *
     * http://oj.leetcode.com/problems/sqrtx
     */
    public static Double sqrt (Double n) {
        System.out.println("\nStart function sqrt()");
        System.out.println("\tn = " + n);
        Double precision_unit = 0.000001;
//        System.out.println("n = " + n);
        if (n < 0.0) {
            System.out.println("\tres = " + -1.0);
            return -1.0;
        } else if (n <= precision_unit) {
            System.out.println("\tres = " + precision_unit);
            return 0.001;
        } else if (n == 1.0) {
            System.out.println("\tres = " + 1.0);
            return 1.0;
        }

        boolean lowerThanOne = false;
        if (n <= 1.0) {
            lowerThanOne = true;
            n *= (1.0/precision_unit);
        }

        Double low = 1.0;
        Double high = n;
        Double mid = 0.0;

        while (low < high) {
            mid = (low + high)/2.0;
//            System.out.println("mid = " + mid + "; low = " + low + "; high = " + high);
            if (Math.abs((mid * mid) - n) <= precision_unit) {
                break;
            } else if ((mid * mid) > n) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (lowerThanOne) {
            mid /= 1000;
        }
        System.out.println("\tres = " + mid);
        return mid;
    }
    
    /*
     * Given an array of integers, every element appears three times except for one. Find that single one.
     */
    public static int singleNumber(Integer [] A) {
        System.out.println("\nStart function singleNumber()");
        System.out.println("\tA = " + Arrays.asList(A));
        Integer [] temp = new Integer [32];
        Arrays.fill(temp, 0);
        
        for (int a : A) {
            int cur = 0;
            while (a > 0) {
                if ((a & 0x1) == 1)
                    temp[cur]++;
                cur++;
                a >>= 1;
            }
        }
        
        int result = 0;
        
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            result |= temp[i]%3;
        }
        System.out.println("\tResult = " + result);
        return result;
    }

    public static String removeEndSpace(String s) {
        if (s == null || s.equals("")) return s;
        int end = s.length()-1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        return s.substring(0, end+1);
    }
    public static String removeHeadSpace(String s) {
        if (s == null || s.equals("")) return s;
        int len = s.length();
        int start = 0;
        while (start < len && s.charAt(start) == ' ') {
            start++;
        }
        return s.substring(start, len);
    }
    
//    private enum InputType {
//        INVALID(0),    // 0: Including Alphas, '(', '&' and so on
//        SPACE(1),      // 1: 
//        SIGN(2),       // 2: '+' & '-'
//        DIGIT(3),      // 3: Numbers
//        DOT(4),        // 4: '.'
//        EXPONENT(5)    // 5: 'e' or 'E'
//    };
    private enum InputType {
        INVALID(0),
        SPACE(1),
        SIGN(2),
        DIGIT(3), 
        DOT(4), 
        EXPONENT(5);
        
        InputType (int num) {
            this.order = num;
        }
        public int order;
    }
    
    public static boolean isNumber (String s) {
        if (s == null) return false;
        int len = s.length();
        if (len < 1) return false;
        
        Integer [][]finiteMachine = new Integer [][] {
        //   0:INV  1:SPA  2:SIG  3:DIG  4:DOT  5:EXP
            {   -1,     0,     3,     1,     2,    -1}, // 0: Initial state or starts with space(s)
            {   -1,     8,    -1,     1,     4,     5}, // 1: After number input
            {   -1,    -1,    -1,     4,    -1,    -1}, // 2: Not number ahead, only '.' inputted
            {   -1,    -1,    -1,     1,     2,    -1}, // 3: '+' or '-' inputted
            {   -1,     8,    -1,     4,    -1,     5}, // 4: Both number and '.' inputted ahead 
            {   -1,    -1,     6,     7,    -1,    -1}, // 5: After 'e' or 'E' inputted
            {   -1,    -1,    -1,     7,    -1,    -1}, // 6: Inputted '+'/'-' after 'e'/'E'
            {   -1,     8,    -1,     7,    -1,    -1}, // 7: Inputted number after 'e'/'E'
            {   -1,     8,    -1,    -1,    -1,    -1}, // 8: Valid inputs after space
        };
        int last = 0;
        for (int i = 0; i < len; i++) {
            InputType input = InputType.INVALID;
            char c = s.charAt(i);
            switch (c) {
                case ' ':
                    input = InputType.SPACE;
                    break;
                case '+':
                case '-':
                    input = InputType.SIGN;
                    break;
                case '.':
                    input = InputType.DOT;
                    break;
                case 'e':
                case 'E':
                    input = InputType.EXPONENT;
                    break;
                default:
                    if (c >= '0' && c <= '9')
                        input = InputType.DIGIT;
                    break;
            }
            last = finiteMachine[last][input.order];
            if (last == -1) return false;
        }
        return last == 1 ||
               last == 4 ||
               last == 7 ||
               last == 8;
    }
    
//    public static boolean isNumber(String s) {
//        assert s != null;
//        String str = removeHeadSpace(removeEndSpace(s)).toLowerCase();
//        
//        if (str.length() == 0) return false;
//        String str1 = (str.charAt(0) == '-' || str.charAt(0) == '+') ? str.substring(1) : str;
//        int len = str1.length();
//
//        if (len == 0) return false;
//        if (str1.contains(" ")) return false;
//     	int index = str1.indexOf('e');
//     	if (index != -1) {
//     		if (index == 0 || index == len - 1)
//     			return false;
//     		if (index != str1.lastIndexOf('e'))
//     			return false;
//     	}
//     	
//     	index = str1.indexOf('.');
//     	if (index != -1) { 
//     	    if (index != str1.lastIndexOf('.') || len == 1)
//     	        return false;
//     	  //  if (index == len - 1)
//     	  //      return false;
//     	    if (index != len - 1 && !(str1.charAt(index+1) >= '0' && str1.charAt(index+1) <= '9'))
//     	        return false;
//     	    if (index != 0 && !(str1.charAt(index-1) >= '0' && str1.charAt(index-1) <= '9'))
//     	        return false;
//        }
//        for (int i = 0; i < len; i++) {
//        	Character c = str1.charAt(i);
//        	if ((c >= '0' && c <= '9') || c == 'e' || c == '.') {
//                } else
//                    return false;
//        }
//        return true;
//    }
    
    public static int atoi(String str) {
        if (str.length() == 0)
            return 0;
        int i = 0;
        while (str.charAt(i) == ' ') i++;
        
        if (str.indexOf('+') != -1 && str.indexOf('-') != -1) return 0; 
        boolean neg = false;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
        	if (str.charAt(i) == '-')
        	    neg = true;
        	i++;
        }

        String s = str.substring(i);

        char [] digits = s.toCharArray();

        int sum = 0;
        for (char j : digits) {
        	if (!(j >= '0' && j <= '9')) {
        		return neg ? -sum : sum;
        	}
        	int d = j - '0';

        	if (sum > Integer.MAX_VALUE/10)
        		return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	else if (sum == Integer.MAX_VALUE/10) {
        		if (d >= 7 && !neg)
        			return Integer.MAX_VALUE;
        		else if (d >= 8 && neg)
        			return Integer.MIN_VALUE;
        	}
        	sum = sum*10 + d;
        }
        return neg ? -sum : sum;
    }

    /* Roman To Integer 
     * Given a roman numeral, convert it to an integer.
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    private static int c2n (Character c) {
        switch (Character.toUpperCase(c)) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    private static Character n2c (Integer n) {
        switch (n) {
            case 1: return 'I';
            case 5: return 'V';
            case 10: return 'X';
            case 50: return 'L';
            case 100: return 'C';
            case 500: return 'D';
            case 1000: return 'M';
            default: return '_';
        }
    }
    public static int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        if (len < 1) return 0;
        for (int i = 0; i < len; i++) {
            Integer nc = c2n(s.charAt(i));
            Integer np = (i > 0) ? c2n(s.charAt(i-1)) : Integer.MAX_VALUE;
            if (i > 0 && nc > np) {
                result += (nc - 2*np);
            } else {
                result += nc;
            }
        }
        return result;
    }
    public static int romanToInt2(String s) {
        int result = 0;
        int len = s.length();
        if (len < 1) return 0;

        char[] chars = ("M"+s).toCharArray();
        for (int i = 1; i <= len; i++) {
            Integer nc = c2n(chars[i]);
            Integer np = c2n(chars[i-1]);
            if (nc > np) {
                result += (nc - 2*np);
            } else {
                result += nc;
            }
        }
        return result;
    }
    public static String intToRoman(int num) {
        Character []symbol = new Character[]{ 'I','V','X', 'L','C', 'D','M'};  
        StringBuilder sb = new StringBuilder();
        int scale = 1000;
        
        for (int i = 6; i >= 0; i-=2) {
            int digit = num/scale;
            if (digit != 0) {
                if (digit <= 3) {
                    for (int j = 0; j < digit; j++)
                        sb.append(symbol[i]);
                } else if (digit == 4) {
                    sb.append(symbol[i]);
                    sb.append(symbol[i+1]);
                } else if (digit == 5) {
                    sb.append(symbol[i+1]);
                } else if (digit <= 8) {
                    sb.append(symbol[i+1]);
                    for (int j = 6; j <= digit; j++)
                        sb.append(symbol[i]);
                } else if (digit == 9) {
                    sb.append(symbol[i]);
                    sb.append(symbol[i+2]);
                }
            }
            num %= scale;
            scale /= 10;
        }
        return sb.toString();
    }
    private static class RomanScale {
        public Integer scale;
        public Character oneTimeSymbol;
        public Character fiveTimeSymbol;
        public RomanScale(Integer s, Character os, Character fs) {
            scale = s;
            oneTimeSymbol = os;
            fiveTimeSymbol = fs;
        }
    }
    public static String intToRoman3(int num) {
        //LinkedList<RomanScale> rs = new LinkedList<>(Arrays.asList(new RomanScale(1000, 'M', 'Z'), new RomanScale(100, 'C', 'D'), new RomanScale(10, 'X', 'L'), new RomanScale(1, 'I', 'V')));
        LinkedList<RomanScale> rs = new LinkedList<>();
        rs.add(new RomanScale(1000, 'M', 'Z'));
        rs.add(new RomanScale(100, 'C', 'D'));
        rs.add(new RomanScale(10, 'X', 'L'));
        rs.add(new RomanScale(1, 'I', 'V'));
        StringBuilder sb = new StringBuilder();

        ListIterator<RomanScale> iter = rs.listIterator();
        while (iter.hasNext()) {
            RomanScale scale = iter.next();
            int digit = num /scale.scale;
            num %= scale.scale;
            switch(digit) {
                case 1:
                case 2:
                case 3:
                    while (digit-- > 0) sb.append(scale.oneTimeSymbol);
                    break;
                case 4:
                    sb.append(scale.oneTimeSymbol);
                case 5:
                    sb.append(scale.fiveTimeSymbol);
                    break;
                case 6:
                case 7:
                case 8:
                    sb.append(scale.fiveTimeSymbol);
                    while (digit-- > 5) sb.append(scale.oneTimeSymbol);
                    break;
                case 9:
                    sb.append(scale.oneTimeSymbol);
                    iter.previous();
                    sb.append(iter.previous().oneTimeSymbol);
                    iter.next();
                    iter.next();
                    break;
                default:
                    break;
            }
        }
        return sb.toString();
    }
    private static class RomanCharacter {
        public Character oneTimeSymbol;
        public Character fiveTimeSymbol;
        public RomanCharacter(Character os, Character fs) {
            oneTimeSymbol = os;
            fiveTimeSymbol = fs;
        }
    }
    public static String intToRoman4(int num) {
        HashMap<Integer, RomanCharacter> map = new HashMap<>();
        map.put(1000, new RomanCharacter('M', 'Z'));
        map.put(100, new RomanCharacter('C', 'D'));
        map.put(10, new RomanCharacter('X', 'L'));
        map.put(1, new RomanCharacter('I', 'V'));
        StringBuilder sb = new StringBuilder();

        Integer scale = 1000;
        while (scale > 0) {
            int digit = num /scale;
            num %= scale;
            switch(digit) {
                case 1:
                case 2:
                case 3:
                    while (digit-- > 0) sb.append(map.get(scale).oneTimeSymbol);
                    break;
                case 4:
                    sb.append(map.get(scale).oneTimeSymbol);
                case 5:
                    sb.append(map.get(scale).fiveTimeSymbol);
                    break;
                case 6:
                case 7:
                case 8:
                    sb.append(map.get(scale).fiveTimeSymbol);
                    while (digit-- > 5) sb.append(map.get(scale).oneTimeSymbol);
                    break;
                case 9:
                    sb.append(map.get(scale).oneTimeSymbol);
                    sb.append(map.get(scale*10).oneTimeSymbol);
                    break;
                default:
                    break;
            }
            scale /= 10;
        }
        return sb.toString();
    }
    public static String intToRoman2(int num) {
        Integer[] romanCharacter = new Integer[] {1000, 500, 100, 50, 10, 5, 1};

        StringBuilder sb = new StringBuilder();
        int scale = 0;
        Integer diff = null;
        while (num > 0) {
            if (num >= romanCharacter[scale]) {
                sb.append(n2c(romanCharacter[scale]));
                num -= romanCharacter[scale];
            } else {
                if (num >= romanCharacter[scale]-romanCharacter[scale]/10) {
                    sb.append(n2c(romanCharacter[scale+1]));
                    sb.append(n2c(romanCharacter[scale]));
                    num -= (romanCharacter[scale] - romanCharacter[scale+1]);
                }
                scale++;
            }
        }
        return sb.toString();
    }

    /**
     * Number Refactor Combinations
     * Refactor an Integer to all possible combinations, for instance:
     *         24=2*2*2*3
     *           =2*2*6
     *         =2*3*4
     *           =2*12
     *           =3*8
     *           =4*6
     */
    public static List<List<Integer>> factorCombination(int n) {
        System.out.println("\nStart function factorCombination()");
        System.out.println("\tn = " + n);
        List<List<Integer>> res = new ArrayList<> ();
        factorCombinationDFS(n, 2, new LinkedList<Integer> (), res);
        for (List<Integer> list : res)
            System.out.println("\t" + list);
        return res;
    }
    private static void factorCombinationDFS (int n, int start, LinkedList<Integer> tmp, List<List<Integer>> res) {
        if (n == 1) {
            res.add(new LinkedList<> (tmp));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n%i != 0) 
                continue;
            if (i == n && tmp.isEmpty())
                continue;
            tmp.addLast(i);
            factorCombinationDFS(n/i, i, tmp, res);
            tmp.removeLast();
        }
    }

    /**
     * Factor Combinations
     * Numbers can be regarded as product of its factors. For example,
     * 8 =  * 2 x 2 x 2;
     *   =  * 2 x 4.
     * Write a function that takes an integer n and return all possible combinations of its factors.
     * Note: 
     *         1. You may assume that n is always positive.
     *         2. Factors should be greater than 1 and less than n.
     *         Examples: 
     * input: 1
     * output: 
     *         []
     * input: 37
     * output: 
     *         []
     * input: 12
     * output:
     *         [
     *         [2, 6],
     *         [2, 2, 3],
     *         [3, 4]
     *         ]
     */
    public static void getFactorsDemo(int n) {
        System.out.println("\nStart function getFactorsDemo(). n = " + n);
        List<List<Integer>> res = getFactors(n);
        for (List<Integer> list : res) {
            System.out.println("\t" + list);
        }
    }
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 2) return res;

        getFactorsDFS(n, 2, new LinkedList<Integer>(), res);

        return res;
    }
    // This version accepted
    private static void getFactorsDFS(int n, int cur, LinkedList<Integer> tmp, List<List<Integer>> res) {
        if (n == 1 && tmp.size() > 1) {
            res.add(new LinkedList<>(tmp));
        } else {
            for (int i = cur; i <= n; i++) {
                if (n % i != 0) continue;
                if (n == i && tmp.isEmpty()) continue;
                tmp.add(i);
                getFactorsDFS(n/i, i, tmp, res);
                tmp.removeLast();
            }
        }
    }
    // This version timed out
    private static void getFactorsDFS2(int n, int cur, LinkedList<Integer> tmp, List<List<Integer>> res) {
        if (n == 1 && tmp.size() > 1) {
            res.add(new LinkedList<>(tmp));
            //} else if (cur <= (int)Math.ceil((double)n/2)) {
        } else if (cur <= n) {
            getFactorsDFS(n, cur + 1, tmp, res);
            if (n % cur == 0) {
                tmp.add(cur);
                getFactorsDFS(n/cur, cur, tmp, res);
                tmp.removeLast();
            }
        }
    }

    /**
     * Divide two integers without using multiplication, division and mod operator.
     *
     * https://oj.leetcode.com/problems/divide-two-integers
     */
    public static void divideIntegersDemo(int dividend, int divisor) {
        System.out.println("\nStart function divideIntegers()");
        System.out.println("\t" + dividend + " / " + divisor + " = " + divideIntegers(dividend, divisor));
    }
    public static int divideIntegers(int dividend, int divisor) {
        assert divisor != 0;
        if (dividend == 0) return 0;
        boolean neg = dividend * divisor < 0;

        long dd = Math.abs(dividend);
        long dv = Math.abs(divisor);

        if (dv == 1) return (neg ? -1 : 1) * Math.abs(dividend);
        if (dd < dv) return 0;

        int result = 0;
        while (dd >= dv) {
            long times = dv;
            for (int i = 0; dd >= times; i++, times <<= 1) {
                dd -= times;
                result += (1 << i);
            }
        }
        return neg ? -result : result;
    }

    // Similar to StringTest.fractionToDecimal
    public static String divideWithStop (int num, int dev) {
        System.out.println("\nStart function divideWithStop()");
        System.out.println("\tnum = " + num);
        System.out.println("\tdev = " + dev);
        if (num == 0) return "0";
        if (dev == 0) return "INFINITE";
        boolean neg = num*dev<0;
        num = Math.abs(num);
        dev = Math.abs(dev);
        
        StringBuilder res = new StringBuilder();
        res.append(num/dev);
        num %= dev;
        if (num != 0) {
            res.append(".");
            List<Integer> afterDot = new ArrayList<> ();
            HashMap<Integer, Integer> map = new HashMap<> ();
            int index = 0;
            int loopStart = -1;
            while (num != 0 && index < 10) {
                num *= 10;
                int newDigit = num/dev;
                if (!map.containsKey(newDigit)) {
                    afterDot.add(newDigit);
                    map.put(newDigit, index++);
                } else {
                    loopStart = newDigit;
                    break;
                }
                num -= newDigit * dev;
            }
            for (Integer d : afterDot) {
                if (d == loopStart)
                    res.append("(");
                res.append(d);
            }
            if (loopStart == -1) {
                res.append("(0)");
            } else {
                res.append(")");
            }
        }
        String finalRes = neg?"-"+res.toString():res.toString();
        System.out.println("\tResult = " + finalRes);
        return finalRes;
    }
    public static String divideWithStop2 (Integer num, Integer dev) {
        System.out.println("\nStart function divideWithStop2()");
        System.out.println("\tnum = " + num);
        System.out.println("\tdev = " + dev);
        assert dev != 0;
        if (num == 0) return "0";
        if (dev == 1) return num.toString();
        boolean neg = num > 0 ? dev < 0 : dev > 0;
        int n = Math.abs(num);
        int d = Math.abs(dev);

        StringBuilder sb = new StringBuilder();
        int res = n/d;
        int rem = n%d;
        sb.append(res);

        if (rem != 0) {
            sb.append('.');
            HashMap<Integer, Integer> remMap = new HashMap<>();
            int index = 0;
            while (rem != 0) {
                if (remMap.containsKey(rem)) {
                    int start = remMap.get(rem);
                    sb.insert(start, '(');
                    sb.append(')');
                    break;
                } else {
                    remMap.put(rem, sb.length());
                    rem *= 10;
                    res = rem/d;
                    sb.append(res);
                    rem %= d;
                }
                index++;
                if (index == 10) {
                    break;
                }
            }
        }
        String finalRes = neg?"-"+sb.toString():sb.toString();
        System.out.println("\tResult = " + finalRes);
        return finalRes;

    }

    //    Largest Number
    //    Given a list of non negative integers, arrange them such that they form the largest number.
    //
    //    For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
    //
    //    Note: The result may be very large, so you need to return a string instead of an integer.
    public static String largestNumber(Integer[] nums) {
        System.out.println("\nStart function largestNumber()");
        System.out.println("\tnums = " + Arrays.asList(nums));
        Integer[] newArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++)
            newArray[i] = nums[i];

        Arrays.sort(newArray, (n1, n2) -> {
            char[] c1 = Integer.toString(n1).toCharArray();
            char[] c2 = Integer.toString(n2).toCharArray();
            int len1 = c1.length;
            int len2 = c2.length;
            int i1 = 0, i2 = 0;
            while (i1 < len1 && i2 < len2) {
                if (c1[i1] > c2[i2]) return 1;
                if (c1[i1] < c2[i2]) return -1;
                i1++;
                i2++;
            }
            if (len1 == len2) return 0;
            if (i1 == len1) {
                if (c1[0] > c2[i2]) return 1;
                if (c1[0] < c2[i2]) return -1;

                while (i2 < len2) {
                    if (c1[len1 - 1] > c2[i2]) return 1;
                    else if (c1[len1 - 1] < c2[i2]) return -1;
                    i2++;
                }
                return 0;
            } else {
                if (c2[0] > c1[i1]) return -1;
                if (c2[0] < c1[i1]) return 1;

                while (i1 < len1) {
                    if (c2[len2 - 1] > c1[i1]) return -1;
                    else if (c2[len2 - 1] < c1[i1]) return 1;
                    i1++;
                }
                return 0;
            }
        });
        System.out.println("\t" + Arrays.asList(newArray));
        if (newArray[0] == 0 && newArray[newArray.length-1] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = newArray.length-1; i >= 0; i--) {
            sb.append(newArray[i]);
        }
        System.out.println("\t" + sb.toString());
        return sb.toString();
    }

    public static int reverseBits(int n) {
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8);
        n = ((n & 0xFFFF0000) >>> 16) | ((n & 0x0000FFFF) << 16);
        return n;
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        Double ln = Math.log10(n)/Math.log10(2);
        Double lm = Math.log10(m)/Math.log10(2);
        int res;
        if (Math.floor(ln) >= Math.ceil(lm)) {
            res = (int)Math.pow(2, Math.floor(ln));
        } else {
            res = m;
        }
        int diff = n - res;
        for (int i = 0 ; i <= diff; i++)
            res &= i;
        return res;
    }

    /**
     * Find the total area covered by two rectilinear rectangles in a 2D plane.
     * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
     * Assume that the total area is never beyond the maximum possible value of int.
     *
     * https://leetcode.com/problems/rectangle-area/
     */
    static public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Range verR1 = new Range(A, C);
        Range verR2 = new Range(E, G);
        Range horR1 = new Range(B, D);
        Range horR2 = new Range(F, H);

        Range verInter = new Range(verR1, verR2);
        Range horInter = new Range(horR1, horR2);

        int commonArea = verInter.getLen() * horInter.getLen();
        return verR1.getLen() * horR1.getLen() + verR2.getLen() * horR2.getLen() - commonArea;
    }
    private static class Range {
        public Range(int i1, int i2) {
            min = Math.min(i1, i2);
            max = Math.max(i1, i2);
        }
        public Range(Range r1, Range r2) {
            if (r1.min > r2.min) {
                Range tmp = r1;
                r1 = r2;
                r2 = tmp;
            }
            min = r2.min;
            if (r2.min >= r1.max) {
                //this(r2.min, r2.min);
                max = r2.min;
            } else {
                max = Math.min(r2.max, r1.max);
            }

        }
        public int getLen() {
            return max - min;
        }

        public int min;
        public int max;
    }

    /**
     * Permutation Sequence - Accepted 
     * Total Accepted: 2964 Total Submissions: 14422My Submissions
     * The set [1,2,3,…,n] contains a total of n! unique permutations.
     * By listing and labeling all of the permutations in order,
     * We get the following sequence (ie, for n = 3):
     *         1. "123"
     *         2. "132"
     *         3. "213"
     *         4. "231"
     *         5. "312"
     *         6. "321"
     * Given n and k, return the kth permutation sequence.
     * Note: Given n will be between 1 and 9 inclusive.
     *
     * http://oj.leetcode.com/problems/permutation-sequence/
     */
    // Recursive way
    public static void getPermutationDemo(int n) {
        System.out.println("\nStart function getPermutationsDemo(): n = " + n);
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        for (int i = 1; i <= num; i++) {
            System.out.println("\t" + getPermutation(n, i));
        }
    }
    public static String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            if (k == 1)
                return "12";
            else
                return "21";
        }

        Integer mod = 1;
        for (int i = 2; i <= (n-1); ++i)
            mod *= i;
        Integer stage = (Integer)(k/mod);
        Integer remainer = (Integer)(k%mod);
        if (remainer == 0) stage--;

        Integer newK = k - mod * stage;
        String nextStr = getPermutation(n-1, newK);

        stage++;
        StringBuilder sb = new StringBuilder ();
        sb.append(stage.toString());
        for (int i = 0; i < nextStr.length(); i++) {
            Integer curDigit = Character.getNumericValue(nextStr.charAt(i));
            if (stage <= curDigit) {
                sb.append(curDigit + 1);
            } else {
                sb.append(curDigit);
            }
        }

        return sb.toString();
    }
    public static void getPermutationDemo2(int n) {
        System.out.println("\nStart function getPermutationDemo2(): n = " + n);
        int num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        for (int i = 1; i <= num; i++) {
            System.out.println("\t" + getPermutation2(n, i));
        }
    }
    // Iterative way
    public static String getPermutation2(int n, int k) {
        int mod = 1;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            mod *= (i + 1);
            num[i] = i + 1;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            mod /= (n - i);
            int stage = k / mod;
            k %= mod;

            sb.append(num[stage]);
            for (int j = stage; j < n - i - 1; j++) {
                num[j] = num[j + 1];
            }
        }
        return sb.toString();
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

        combinationSum3Helper(k, n, 1, new LinkedList<Integer>(), res);
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

    /**
     * Add Digits - Accepted
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * For example:
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     * Follow up:
     * Could you do it without any loop/recursion in O(1) runtime?
     * Hint:
     *    1. A naive implementation of the above process is trivial. Could you come up with other methods?
     *    2. What are all the possible results?
     *    3. How do they occur, periodically or randomly?
     * You may find this Wikipedia article useful.
     */
    public static void addDigitsDemo(int num) {
        System.out.println("\nStart function addDigitsDemo()");
        System.out.println("\tResult = " + addDigits(num));
    }
    public static int addDigits(int num) {
        if (num < 10) return num;
        return num - 9 * (int)Math.floor((double)(num - 1) / 9.0);
    }

    /**
     * Nim Game
     *
     * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
     *
     * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
     *
     * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
     */
    // Optimal solution
    public boolean canWinNim(int n) {
        if (n <= 3) return true;
        return n % 4 != 0;
    }
    // Another solution
    public boolean canWinNim2(int n) {
        if (n <= 3) return true;

        boolean[] D = new boolean[n+1];
        D[0] = true;
        D[1] = true;
        D[2] = true;
        D[3] = true;
        for (int i = 4; i <= n; i++) {
            if (D[i-1] && D[i-2] && D[i-3]) {
                D[i] = false;
            } else {
                D[i] = true;
            }
        }
        return D[n];
    }
    // Another solution
    public boolean canWinNim3(int n) {
        if (n <= 3) return true;

        boolean[] D = new boolean[4];
        D[1] = true;
        D[2] = true;
        D[3] = true;
        for (int i = 4; i <= n; i++) {
            if (D[(i-1)%4] && D[(i-2)%4] && D[(i-3)%4]) {
                D[i%4] = false;
            } else {
                D[i%4] = true;
            }
        }
        return D[n%4];
    }

    /**
     * Ugly Number II
     * <p>
     * Write a program to find the n-th ugly number.
     * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
     * Note that 1 is typically treated as an ugly number.
     */
    public static void nthUglyNumberDemo(int n) {
        System.out.println("\nStart function nthUglyNumberDemo()");
        System.out.println("\t" + n + "th item: " + nthUglyNumber(n));
    }
    public static int nthUglyNumber(int n) {
        if (n == 1) return 1;
        Queue<Long> q2 = new LinkedList<>();
        Queue<Long> q3 = new LinkedList<>();
        Queue<Long> q5 = new LinkedList<>();
        q2.add(2L);
        q3.add(3L);
        q5.add(5L);

        int kth = 1;
        while (true) {
            long min = Math.min(Math.min(q2.peek(), q3.peek()), q5.peek());
            kth++;
            if (kth == n) {
                return (int) min;
            }
            if (min == q2.peek()) {
                long cur = q2.poll();
                q2.add(2 * cur);
                q3.add(3 * cur);
                q5.add(5 * cur);
            } else if (min == q3.peek()) {
                long cur = q3.poll();
                q3.add(3 * cur);
                q5.add(5 * cur);
            } else {
                long cur = q5.poll();
                q5.add(5 * cur);
            }
        }
    }
    public static void nthUglyNumberDemo2(int n) {
        System.out.println("\nStart function nthUglyNumberDemo()");
        System.out.println("\t" + n + "th item: " + nthUglyNumber2(n));
    }
    public static int nthUglyNumber2(int n) {
        LinkedList<Integer> res = new LinkedList<>();
        res.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        while (res.size() < n) {
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
            res.add(min);
        }
        return res.getLast();
    }

    /**
     * Super Ugly Number
     *
     * Write a program to find the nth super ugly number.
     *
     * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
     *
     * Note:
     *         (1) 1 is a super ugly number for any given primes.
     *         (2) The given numbers in primes are in ascending order.
     *         (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
     */
    public static int nthSuperUglyNumber(int n, Integer[] primes) {
        System.out.println("\nStart function nthSuperUglyNumber()");
        int len = primes.length;
        LinkedList<Integer> res = new LinkedList<>();
        res.add(1);
        Integer[] index = new Integer[len];
        Arrays.fill(index, 0);

        while (res.size() < n) {
            Integer min = res.get(index[0]) * primes[0];
            for (int i = 0; i < len; i++) {
                min = Math.min(min, res.get(index[i]) * primes[i]);
            }
            for (int i = 0; i < len; i++) {
                if (res.get(index[i]) * primes[i] == min) {
                    index[i]++;
                }
            }
            res.add(min);
        }
        System.out.println("\t" + res);
        System.out.println("\t" + n + "th item: " + res.getLast());
        return res.getLast();
    }

    // A more efficient version. Still times out in LeetCode
    private static class TempNode {
        Integer val;
        Integer index;
        Integer prime;
        public TempNode(Integer v, Integer i, Integer p) {
            val = v;
            index = i;
            prime = p;
        }
        @Override
        public String toString() {
            return "V:" + val + "; I:" + index + "; P:" + prime;
        }
    }
    public static int nthSuperUglyNumber2(int n, Integer[] primes) {
        System.out.println("\nStart function nthSuperUglyNumber2()");
        printArray(primes, "\tPrimes:");

        int len = primes.length;
        LinkedList<Integer> res = new LinkedList<>();
        res.add(1);
        Integer[] index = new Integer[len];
        Arrays.fill(index, 0);

        PriorityQueue<TempNode> Q = new PriorityQueue<>(len, (t1, t2) -> t1.val - t2.val);
        for (int i = 0; i < len; i++) {
            Q.add(new TempNode(primes[i], 0, primes[i]));
        }

        while (res.size() < n) {
            int min = Q.peek().val;
            res.add(min);
            while (!Q.isEmpty() && Q.peek().val == min) {
                TempNode cur = Q.poll();
                cur.val = cur.prime * res.get(++cur.index);
                Q.add(cur);
            }
            Iterator iter = Q.iterator();
            while (iter.hasNext()) {
                System.out.print(iter.next() + " => ");
            }
            System.out.println();
        }
        System.out.println("\t" + res);
        System.out.println("\t" + n + "th item: " + res.getLast());
        return res.getLast();
    }

    public static int nthSuperUglyNumber3(int n, Integer[] primes) {
        System.out.println("\nStart function nthSuperUglyNumber2()");
        int len = primes.length;
        LinkedList<Integer> res = new LinkedList<>();
        res.add(1);
        Integer[] index = new Integer[len];
        Arrays.fill(index, 0);

        PriorityQueue<TempNode3> Q = new PriorityQueue<TempNode3>(len, (t1, t2) -> Long.compare(t1.val, t2.val));
        for (int i = 0; i < len; i++) {
            Q.add(new TempNode3((long)(int)primes[i], 0, primes[i]));
        }

        while (res.size() < n) {
            long min = Q.peek().val;
            res.add((int)min);
            while (!Q.isEmpty() && Q.peek().val == min) {
                TempNode3 cur = Q.poll();
                cur.val = (long)cur.prime * res.get(++cur.index);
                Q.add(cur);
            }
        }
        System.out.println("\t" + res);
        System.out.println("\t" + n + "th item: " + res.getLast());
        return res.getLast();
    }
    private static class TempNode3 {
        Long val;
        Integer index;
        Integer prime;
        public TempNode3(Long v, Integer i, Integer p) {
            val = v;
            index = i;
            prime = p;
        }
    }

//    public static int nthSuperUglyNumber(int n, Integer[] primes) {
//        if (n == 1) return 1;
//        ArrayList<Queue<Long>> queues = new ArrayList<>();
//        for (int p : primes) {
//            Queue<Long> Q = new LinkedList<>();
//            Q.add((long)p);
//            queues.add(Q);
//        }
//
//        int kth = 1;
//        while (true) {
//            kth++;
//            Long min = queues.get(0).peek();
//            int minIndex = 0;
//            for (int i = 1; i < queues.size(); i++) {
//                Queue<Long> Q = queues.get(i);
//                if (min > Q.peek()) {
//                    min = Q.peek();
//                    minIndex = i;
//                }
//            }
//            if (kth == n) {
//                return (int) (long) min;
//            }
//            long cur = queues.get(minIndex).poll();
//            Queue<Long> Q = queues.get(minIndex);
//            Q.add(primes[minIndex] * cur);
//        }
//    }

    /**
     * Bulb Switcher   Add to List QuestionEditorial Solution  My Submissions
     * Total Accepted: 32879
     * Total Submissions: 78629
     * Difficulty: Medium
     * Contributors: Admin
     * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
     *
     *         Example:
     *
     * Given n = 3.
     *
     * At first, the three bulbs are [off, off, off].
     * After first round, the three bulbs are [on, on, on].
     * After second round, the three bulbs are [on, off, on].
     * After third round, the three bulbs are [on, off, off].
     *
     * So you should return 1, because there is only one bulb is on.
     *
     * http://www.cnblogs.com/grandyang/p/5100098.html
     */
    public static int bulbSwitch(int n) {
        System.out.println("\nStart function bulbSwitch(). n = " + n);
        if (n <= 1) return 1;
        Boolean[] on = new Boolean[n+1];
        Arrays.fill(on, true);
        for (int i = 2; i <= n; i++) {
            int temp = i;
            while (temp <= n) {
                on[temp] = !on[temp];
                temp += i;
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (on[i]) {
                count++;
            }
        }
        System.out.println("\t" + Arrays.asList(on));
        System.out.println("\tCount = " + count);
        return count;
    }
    public static int bulbSwitch2(int n) {
        int res = 1;
        while (res * res <= n) res++;
        return res - 1;
    }

    /**
     * Perfect Squares
     * <p>
     * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
     * <p>
     * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
     */
    public static void numSquaresDemo(int n) {
        System.out.println("\nStart function numSquaresDemo()");
        System.out.println("\tSmallest squares for " + n + " is: " + numSquares(n));
    }

    public static int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;

        if (n < 4) return n;
        int largest = (int) Math.floor(Math.sqrt((double) n));
        if (largest * largest == n) return 1;

        int smallest = n;
        while (largest > 1) {
            int remaining = n - largest * largest;
            int count = numSquares(remaining) + 1;
            if (count < smallest) smallest = count;
            largest--;
            if (n / (largest * largest) >= smallest) return smallest;
        }
        return smallest;
    }

    /**
     * Sum of Two Integers
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     * Example:
     * Given a = 1 and b = 2, return 3.
     */
    public static boolean isPerfectSquare(int num) {
        System.out.println("\nStart function isPerfectSquare(). n = " + num);
        if (num == 1) return true;
        for (int i = 2; i <= num/2; i++) {
            if (i * i == num) {
                System.out.println("\tRes = " + i);
                return true;
            }
        }
        System.out.println("\tRes = false");
        return false;
    }
    public static boolean isPerfectSquare3(int num) {
        System.out.println("\nStart function isPerfectSquare3(). n = " + num);
        if (num == 1) return true;
        long top = num/2;
        while (top * top > num) {
            top /= 2;
        }
        for (long i = top; i <= 2 * top; i++) {
            if (i * i == num) {
                System.out.println("\tRes = " + i);
                return true;
            }
        }
        System.out.println("\tRes = false");
        return false;
    }
    public static boolean isPerfectSquare2(int num) {
        System.out.println("\nStart function isPerfectSquare2(). n = " + num);
        if (num == 1) return true;
        int b = 2, e = num/2;
        while (b <= e) {
            long m = (long)(b + (e - b)/2);
            long t = m * m;
            if (t == num) {
                System.out.println("\tRes = " + m);
                return true;
            } else if (t > num) {
                e = (int)m - 1;
            } else {
                b = (int)m + 1;
            }
        }
        System.out.println("\tRes = false");
        return false;
    }

    /**
     * Counting Bits
     *
     * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
     *
     * Example:
     * For num = 5 you should return [0,1,1,2,1,2].
     *
     * Follow up:
     *
     * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
     * Space complexity should be O(n).
     * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
     */
    public static int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            int t = i;
            while (t > 0) {
                res[i] += t % 2;
                t >>= 1;
            }
        }
        return res;
    }
    public static int[] countBits2(int num) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);

        while (res.size() < num + 1) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                res.add(res.get(i) + 1);
                if (res.size() == num + 1) {
                    break;
                }
            }
        }

        int[] finalRes = new int[num+1];
        for (int i = 0; i <= num; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    /**
     * Binary Watch
     * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
     * Each LED represents a zero or one, with the least significant bit on the right.
     *
     * For example, the above binary watch reads "3:25".
     * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
     *         Example:
     * Input: n = 1
     * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
     * Note:
     *    • The order of output does not matter.
     *    • The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
     *    • The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
     */
    public static List<String> readBinaryWatch(int num) {
        System.out.println("\nStart function readBinaryWatch(). n = " + num);
        List<String> res = new ArrayList<>();

        for (int i = 0; i <= num; i++) {
            List<Integer> hours = getNumsWithDigits(i, 11);
            List<Integer> minutes = getNumsWithDigits(num-i, 59);
            for (int h : hours) {
                for (int m : minutes) {
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        for(String r : res) {
            System.out.println("\t\t" + r);
        }
        return res;
    }
    private static List<Integer> getNumsWithDigits(int digits, int upperLimit) {
        List<Integer> nums = new ArrayList<>();
        for (int i = upperLimit; i >= 0; i--) {
            int t = i;
            int count = 0;
            while (t > 0) {
                if ((t & 0x1) == 1) {
                    count++;
                }
                t >>= 1;
            }
            if (count == digits) {
                nums.add(i);
            }
        }
        return nums;
    }

    /**
     * Nth Digit
     * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
     * Note:
     * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
     * Example 1:
     * Input:
     *         3
     * Output:
     *         3
     * Example 2:
     * Input:
     *         11
     * Output:
     *         0
     * Explanation:
     * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
     */
    public static int findNthDigit(int n) {
        System.out.println("\nStart function findNthDigit(). n = " + n);
        int cur = 0;
        int next = 1;
        Queue<Integer> Q = new LinkedList<>();
        Stack S = new Stack();
        for (int i = 1; i <= n; i++) {
            if (Q.isEmpty()) {
                S.clear();
                int t = next;
                while (t > 0) {
                    S.push(t % 10);
                    t /= 10;
                }
                while (!S.isEmpty()) {
                    Q.add((Integer)S.pop());
                }
                next++;
            }
            cur = Q.poll();
        }
        System.out.println("\t\tnth = " + cur);
        return cur;
    }
    public static int findNthDigit2(int n) {
        int start = 1;
        int len = 1;
        int cnt = 9;
        while (n > len * cnt) {
            n -= len * cnt;
            cnt *= 10;
            len++;
            start *= 10;
        }
        String cad = start + (n-1)/len + "";
        return cad.charAt((n-1)%len) - '0';
    }

    /**
     * Integer Replacement
     * Given a positive integer n and you can do operations as follow:
     *
     * If n is even, replace n with n/2.
     * If n is odd, you can replace n with either n + 1 or n - 1.
     * What is the minimum number of replacements needed for n to become 1?
     *
     * Example 1:
     *
     * Input:
     *         8
     *
     * Output:
     *         3
     *
     * Explanation:
     *         8 -> 4 -> 2 -> 1
     * Example 2:
     *
     * Input:
     *         7
     *
     * Output:
     *         4
     *
     * Explanation:
     *         7 -> 8 -> 4 -> 2 -> 1
     * or
     *         7 -  *> 6 -> 3 -> 2 -> 1
     */
    public static int integerReplacement(int n) {
        System.out.println("\nStart function integerReplacement(). n = " + n);
        if (n == 0) return 1;
        if (n == 1) return 0;

        int[] DP = new int[n+1];
        DP[0] = 1;
        DP[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i%2 == 0) {
                DP[i] = DP[i/2] + 1;
            } else {
                DP[i] = Math.min(DP[i-1], DP[(i+1)/2] + 1) + 1;
            }
        }
        printArray(DP, "\tDP:");
        System.out.println("\tSteps = " + DP[n]);
        return DP[n];
    }
    public static int integerReplacement2(int n) {
        System.out.println("\nStart function integerReplacement2(). n = " + n);
        if (n == 0) return 1;
        if (n == 1) return 0;

        int step = 0;
        long t = n;
        while (t != 1) {
            if (t%2 == 0) {
                t /= 2;
            } else {
                if (t > 4 && (t+1)%4 == 0) {
                    t += 1;
                } else {
                    t -= 1;
                }
            }
            step++;
        }
        System.out.println("\tSteps = " + step);
        return step;
    }

    /**
     * Elimination Game
     * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
     * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
     * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
     * Find the last number that remains starting with a list of length n.
     *         Example:
     * Input:
     * n = 9,
     *         1 2 3 4 5 6 7 8 9
     *         2 4 6 8
     *         2 6
     *         6
     * Output:
     *         6
     */
    public static int lastRemaining(int n) {
        System.out.println("\nStart function lastRemaining(). n = " + n);
        if (n <= 1) return n;
        HashSet<Integer> S = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            S.add(i);
        }
        int min = 1;
        int max = n;
        int step = 2;
        boolean l2h = true;
        while (S.size() > 1) {
            System.out.println("\t" + S);
            if (l2h) {
                while (!S.contains(min)) {min++;}
                for (int i = min; i <= max; i += step) {
                    if (S.contains(i)) {
                        S.remove(i);
                    }
                }
            } else {
                while (!S.contains(max)) {max--;}
                for (int i = max; i >= min; i -= step) {
                    if (S.contains(i)) {
                        S.remove(i);
                    }
                }
            }
            step <<= 1;
            l2h = !l2h;
        }
        Iterator<Integer> iter = S.iterator();
        int last = iter.next();
        System.out.println("\tLast = " + last);
        return last;
    }
    public static int lastRemaining2(int n) {
        System.out.println("\nStart function lastRemaining(). n = " + n);
        if (n <= 1) return n;
        HashSet<Integer> S = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            S.add(i);
        }
        int min = 1;
        int max = n;
        int step = 2;
        boolean l2h = true;
        while (S.size() > 1) {
            System.out.println("\t" + S);
            if (l2h) {
                for (int i = min; i <= max; i += step) {
                    S.remove(i);
                    if (i == min) {
                        while (!S.contains(min)) {
                            min++;
                        }
                    }
                    if (i == max) {
                        while (!S.contains(max)) {
                            max--;
                        }
                    }
                }
            } else {
                for (int i = max; i >= min; i -= step) {
                    S.remove(i);
                    if (i == min) {
                        while (!S.contains(min)) {
                            min++;
                        }
                    }
                    if (i == max) {
                        while (!S.contains(max)) {
                            max--;
                        }
                    }
                }
            }
            step <<= 1;
            l2h = !l2h;
        }
        Iterator<Integer> iter = S.iterator();
        int last = iter.next();
        System.out.println("\tLast = " + last);
        return last;
    }

    /**
     * Lexicographical Numbers
     * Given an integer n, return 1 - n in lexicographical order.
     * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
     * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
     */
    public static List<Integer> lexicalOrder(int n) {
        System.out.println("\nStart function lexicalOrder(). n = " + n);
        PriorityQueue<String> temp = new PriorityQueue<>();
        for (Integer i = 1; i <= n; i++) {
            temp.add(i.toString());
        }
        List<Integer> res = new ArrayList<>();
        while (!temp.isEmpty()) {
            res.add(Integer.parseInt(temp.poll()));
        }
        System.out.println("\t" + res);
        return res;
    }
    // Optimal solution - DFS
    public static List<Integer> lexicalOrder2(int n) {
        System.out.println("\nStart function lexicalOrder(). n = " + n);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            lexicalOrderDFS(i, n, res);
        }
        System.out.println("\t" + res);
        return res;
    }
    private static void lexicalOrderDFS(int cur, int n, ArrayList<Integer> res) {
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i <= n) {
                lexicalOrderDFS(cur * 10 + i, n, res);
            } else {
                break;
            }
        }
    }

    /**
     * K-th Smallest in Lexicographical Order
     *
     * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
     *
     * Note: 1 ≤ k ≤ n ≤ 109.
     *
     * Example:
     *
     * Input:
     * n: 13   k: 2
     *
     * Output:
     *         10
     *
     * Explanation:
     * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
     */
    // Memory out
    public static int findKthNumber(int n, int k) {
        System.out.println("\nStart function findKthNumber(). n = " + n + "; k = " + k);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            findKthNumberDFS(i, n, k, res);
        }
        //System.out.println("\t" + res);
        System.out.println("\tKth element = " + res.get(res.size()-1));
        return res.get(res.size()-1);
    }
    private static boolean findKthNumberDFS(int cur, int n, int k, ArrayList<Integer> res) {
        if (cur > n) {
            return false;
        }
        if (res.size() >= k) {
            return true;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i <= n) {
                if (findKthNumberDFS(cur * 10 + i, n, k, res)) {
                    return true;
                };
            } else {
                break;
            }
        }
        return false;
    }
    // Times out
    private static int resCount = 0;
    private static int kth = 0;
    public static int findKthNumber2(int n, int k) {
        System.out.println("\nStart function findKthNumber2(). n = " + n + "; k = " + k);
        resCount = 0;
        kth = 0;
        for (int i = 1; i <= 9; i++) {
            findKthNumberDFS2(i, n, k);
        }
        System.out.println("\tKth element = " + kth);
        return kth;
    }
    private static boolean findKthNumberDFS2(int cur, int n, int k) {
        if (cur > n) {
            return false;
        }
        if (resCount >= k) {
            return true;
        }
        kth = cur;
        resCount++;
        for (int i = 0; i <= 9; i++) {
            if (cur * 10 + i <= n) {
                if (findKthNumberDFS2(cur * 10 + i, n, k)) {
                    return true;
                };
            } else {
                break;
            }
        }
        return false;
    }

    /**
     * Water and Jug Problem
     * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
     *         If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
     * Operations allowed:
     *         • Fill any of the jugs completely with water.
     *         • Empty any of the jugs.
     * • Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
     *         Example 1: (From the famous "Die Hard" example)
     * Input: x = 3, y = 5, z = 4
     * Output: True
     * Example 2:
     * Input: x = 2, y = 6, z = 5
     * Output: False
     */
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
    }
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    /**
     * Convert a Number to Hexadecimal
     * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
     * Note:
     *  1. All letters in hexadecimal (a-f) must be in lowercase.
     *  2. The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
     *  3. The given number is guaranteed to fit within the range of a 32-bit signed integer.
     *  4. You must not use any method provided by the library which converts/formats the number to hex directly.
     * Example 1:
     * Input:
     *         26
     * Output:
     *         "1a"
     * Example 2:
     * Input:
     *         -1
     * Output:
     *         "ffffffff"
     */
    public static String toHex(int num) {
        System.out.println("\nStart function toHex(). n = " + num);
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int cur = (num & 0xF);
            if (cur >= 10) {
                sb.insert(0, (char)('a' + (cur - 10)));
            } else {
                sb.insert(0, cur);
            }
            num >>>= 4;
        }
        System.out.println("\tRes = " + sb.toString());
        return sb.toString();
    }

    /**
     * Arranging Coins
     * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
     *
     * Given n, find the total number of full staircase rows that can be formed.
     *
     * n is a non-negative integer and fits within the range of a 32-bit signed integer.
     *
     *         Example 1:
     *
     * n = 5
     *
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤
     *
     * Because the 3rd row is incomplete, we return 2.
     * Example 2:
     *
     * n = 8
     *
     * The coins can form the following rows:
     * ¤
     * ¤ ¤
     * ¤ ¤ ¤
     * ¤ ¤
     *
     * Because the 4th row is incomplete, we return 3.
     */
    public static int arrangeCoins(int n) {
        int i = 1;
        for (; i <= n; i++) {
            if (n >= i) {
                n -= i;
            } else {
                break;
            }
        }
        return i-1;
    }

    public static int findMaximumXOR(int[] nums) {
        System.out.println("\nStart function findMaximumXOR()");
        printArray(nums, "\tNums: ");

        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                set.add(num & mask);
            }
            System.out.println("\tSet: " + set);
            int tmp = max | (1 << i);
            System.out.println("\t\tTmp: " + tmp);
            for(int prefix : set){
                System.out.println("\t\tPrefix: " + prefix);
                if(set.contains(tmp ^ prefix)) {
                    System.out.println("\t\tMax = " + tmp);
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    /**
     * Can I Win
     *
     * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.
     *
     * What if we change the game so that players cannot re-use integers?
     *
     * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
     *
     * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
     *
     * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
     *
     * Example
     *
     * Input:
     * maxChoosableInteger = 10
     * desiredTotal = 11
     *
     * Output:
     *         false
     *
     * Explanation:
     * No matter which integer the first player choose, the first player will lose.
     * The first player can choose an integer from 1 up to 10.
     * If the first player choose 1, the second player can only choose integers from 2 up to 10.
     * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
     * Same with other integers chosen by the first player, the second player will always win.
     */
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;

        HashMap<Integer, Boolean> map = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, 0, map);
    }
    private static boolean canIWin(int maxChoosableInteger, int desiredTotal, int used, HashMap<Integer, Boolean> map) {
        if (map.containsKey(used)) {
            return map.get(used);
        }
        for (int i = 0; i < maxChoosableInteger; i++) {
            int cur = (1 << i);
            if ((cur & used) == 0) {
                if (desiredTotal <= i+1 || !canIWin(maxChoosableInteger, desiredTotal - (i+1), (cur | used), map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used, false);
        return false;
    }

    /**
     * Print Numbers by Recursion
     *
     * Print numbers from 1 to the largest number with N digits by recursion.
     *         Example
     * Given N = 1, return [1,2,3,4,5,6,7,8,9].
     * Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].
     * Note
     * It's pretty easy to do recursion like:
     * recursion(i) {
     *     if i > largest number:
     *     return
     *             results.add(i)
     *     recursion(i + 1)
     * }
     * however this cost a lot of recursion memory as the recursion depth maybe very large.
     * Can you do it in another way to recursive with at most N depth?
     * Challenge
     * Do it in recursion, not for-loop.
     */
    public static List<Integer> numbersByRecursion(int n) {
        System.out.println("\nStart function numbersByRecursion(). n = " + n);
        if (n <= 0) return new LinkedList<>();
        List<Integer> last = numbersByRecursion(n-1);
        ArrayList<Integer> list = new ArrayList(last);
        int begin = (int)Math.pow(10, n-1);
        int end = (int)Math.pow(10, n);
        for (int i = begin; i < end; i++) {
            list.add(i);
        }
        System.out.println("\tRes = " + list);
        return list;
    }
    public static List<Integer> numbersByRecursion2(int n) {
        System.out.println("\nStart function numbersByRecursion2(). n = " + n);
        if (n <= 1) return new ArrayList<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
        ArrayList<Integer> last = (ArrayList<Integer>)numbersByRecursion2(n-1);
//        ArrayList<Integer> list = new ArrayList(last);

        for (int i = (int)Math.pow(10, n - 2) - 1; i < (int)Math.pow(10, n - 1) - 1; i++) {
            for (int j = 0; j < 10; j++) {
                last.add(last.get(i) * 10 + j);
            }
        }

        System.out.println("\tRes = " + last);
        return last;
    }

    /**
     * Number Complement
     *
     * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
     *
     * Note:
     * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
     * You could assume no leading zero bit in the integer’s binary representation.
     *         Example 1:
     * Input: 5
     * Output: 2
     * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
     * Example 2:
     * Input: 1
     * Output: 0
     * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
     */
    public static int findComplement(int num) {
        System.out.println("\nStart function findComplement(). n = " + num);
        int cnt = 0;
        int tmp = num;
        while (tmp > 0) {
            cnt++;
            tmp >>= 1;
        }
        int mask = (0x1 << cnt) - 1;
        System.out.println("\t" + (~num & mask));
        return ~num & mask;
    }

    /**
     * Strobogrammatic Number 
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
     * For example, the numbers "69", "88", and "818" are all strobogrammatic.
     */
    public static void isStrobogrammaticDemo(String num) {
        System.out.println("\nStart function isStrobogrammaticDemo(). n = " + num);
        System.out.println("\tRes = " + isStrobogrammatic(num));
    }
    public static boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        map.put('0', '0');

        int low = 0, high = num.length() - 1;
        while (low <= high) {
            char l = num.charAt(low);
            char h = num.charAt(high);

            if (!map.containsKey(l) ||
                map.get(l) != h) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    /**
     * Strobogrammatic Number II
     *
     *
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     *
     * Find all strobogrammatic numbers that are of length = n.
     *
     *         For example,
     * Given n = 2, return ["11","69","88","96"].
     *
     * Hint:
     *
     * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
     */
    public static List<String> findStrobogrammatic(int n) {
        System.out.println("\nStart function findStrobogrammatic(). n = " + n);
        List<String> res = findStrobogrammaticHelper(n, n);
        System.out.println("\tRes = " + res);
        return res;
    }
    public static List<String> findStrobogrammaticHelper(int n, int m) {
        List<String> res = new ArrayList<String>();
        if (m == 0) {
            res.add("");
            return res;
        }
        if (m == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> tmp = findStrobogrammaticHelper(n, m - 2);
        for (String t : tmp) {
            if (m != n) {
                res.add("0" + t + "0");
            }
            res.add("1" + t + "1");
            res.add("6" + t + "9");
            res.add("8" + t + "8");
            res.add("9" + t + "6");
        }
        return res;
    }
    public static List<String> findStrobogrammatic2(int n) {
        System.out.println("\nStart function findStrobogrammatic2(). n = " + n);
        List<String> res = findStrobogrammaticHelper2(n);
        ListIterator<String> iter = res.listIterator();
        while (iter.hasNext()) {
            String cur = iter.next();
            if (cur.startsWith("0") && cur.length() > 1) {
                iter.remove();
            }
        }
        System.out.println("\tRes = " + res);
        return res;
    }
    public static List<String> findStrobogrammaticHelper2(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        List<String> tmp = findStrobogrammaticHelper2(n - 2);
        for (String t : tmp) {
            res.add("0" + t + "0");
            res.add("1" + t + "1");
            res.add("6" + t + "9");
            res.add("8" + t + "8");
            res.add("9" + t + "6");
        }
        return res;
    }

    /**
     * Strobogrammatic Number III 
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     * Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
     *         For example,
     * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
     * Note:
     * Because the range might be a large number, the low and high numbers are represented as string.
     */
    public static int strobogrammaticInRange(String low, String high) {
        HashSet<String> res = new HashSet<>();

        strobogrammaticInRangeHelper(low, high, "", res);
        strobogrammaticInRangeHelper(low, high, "0", res);
        strobogrammaticInRangeHelper(low, high, "1", res);
        strobogrammaticInRangeHelper(low, high, "8", res);

        return res.size();
    }
    private static void strobogrammaticInRangeHelper(String low, String high, String tmp, HashSet<String> res) {
        if (tmp.length() >= low.length() && tmp.length() <= high.length()) {
            if ((tmp.length() == low.length() && tmp.compareTo(low) < 0) || (tmp.length() == high.length() && tmp.compareTo(high) > 0)) {
                return;
            }
            if (!(tmp.length() > 1 && tmp.startsWith("0"))) {
                res.add(tmp);
            }
//            if (tmp.length() > 1 && tmp.startsWith("0")) {
//                return;
//            }
//            res.add(tmp);
        }
        if (tmp.length() + 2 > high.length()) {
            return;
        }
        strobogrammaticInRangeHelper(low, high, "0" + tmp + "0", res);
        strobogrammaticInRangeHelper(low, high, "1" + tmp + "1", res);
        strobogrammaticInRangeHelper(low, high, "6" + tmp + "9", res);
        strobogrammaticInRangeHelper(low, high, "8" + tmp + "8", res);
        strobogrammaticInRangeHelper(low, high, "9" + tmp + "6", res);
    }

    /**
     * Find the Celebrity
     * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
     * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
     * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
     *         Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
     */
    private static boolean knows(int a, int b) {
        boolean[][] tmp = new boolean[][] {
            {true, false, true, true},
            {true, true,  true, false},
            {false, false, false, false},
            {true, false, true, true}
        };
        return tmp[a][b];
    }
    public static int findCelebrityDemo(int n) {
        System.out.println("\nStart function findCelebrityDemo(). n = " + n);
        int celebrity = findCelebrity(n);
        System.out.println("\tCelebrity = " + celebrity);
        return celebrity;
    }
    public static int findCelebrity(int n) {
        if (n < 1) return -1;
        if (n == 1) return 0;

        HashSet<Integer> not = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (not.contains(i)) continue;
            int j = 0;
            for (; j < n; j++) {
                if (j == i) continue;
                if (knows(i, j)) {
                    not.add(i);
                    break;
                } else {
                    not.add(j);
                }
            }
            if (j == n) {
                int k = 0;
                for (; k < n; k++) {
                    if (k != i && !knows(k, i)) {
                        not.add(i);
                        break;
                    }
                }
                if (k == n) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Construct the Rectangle
     * For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:
     *         1. The area of the rectangular web page you designed must equal to the given target area.
     *         2. The width W should not be larger than the length L, which means L >= W.
     * 3. The difference between length L and width W should be as small as possible.
     * You need to output the length L and the width W of the web page you designed in sequence.
     *         Example:
     * Input: 4
     * Output: [2, 2]
     * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
     * But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
     * Note:
     *         1. The given area won't exceed 10,000,000 and is a positive integer
     * The web page's width and length you designed must be positive integers.
     */
    public static void constructRectangleDemo(int area) {
        System.out.println("\nStart function constructRectangleDemo(). Area = " + area);
        printArray(constructRectangle(area), "\tRes");
    }
    public static int[] constructRectangle(int area) {
        int L = (int)Math.ceil(Math.sqrt((double)area));
        while (L <= area) {
            if (area % L == 0) {
                return new int[]{L, area/L};
            }
            L++;
        }
        return new int[]{area, 1};
    }

    /**
     * Smallest Good Base
     * For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
     *
     * Now given a string representing n, you should return the smallest good base of n in string format.
     *
     *         Example 1:
     * Input: "13"
     * Output: "3"
     * Explanation: 13 base 3 is 111.
     * Example 2:
     * Input: "4681"
     * Output: "8"
     * Explanation: 4681 base 8 is 11111.
     * Example 3:
     * Input: "1000000000000000000"
     * Output: "999999999999999999"
     * Explanation: 1000000000000000000 base 999999999999999999 is 11.
     * Note:
     * The range of n is [3, 10^18].
     * The string representing n is always valid and will not have leading zeros.
     */
    public static void smallestGoodBaseDemo(String n) {
        System.out.println("\nStart function smallestGoodBaseDemo(). N = " + n);
        System.out.println("\tRes = " + smallestGoodBase(n));
    }
    public static String smallestGoodBase(String n) {
        Long N = Long.parseLong(n);
        for (Long K = 2L; K * K <= N; K++) {
            if (N % K == 1) {
                long t = N;
                while (t > 0) {
                    long d = t % K;
                    if (d != 1) break;
                    t /= K;
                }
                if (t == 0) {
                    return K.toString();
                }
            }
        }
        return ""+(N-1);
    }
    public static String smallestGoodBase2(String n) {
        Long N = Long.parseLong(n);
        Long M = N - 1;
        for (Long K = 2L; K <= M; K++) {
            if (N % K == 1) {
                long t = N;
                while (t > 0) {
                    long d = t % K;
                    if (d != 1) break;
                    t /= K;
                }
                if (t == 0) {
                    return K.toString();
                }
            }
        }
        return "-1";
    }
}
