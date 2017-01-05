/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.string;

import testing.lib.common.CommonUtils;
import testing.lib.trie.*;
import testing.lib.common.CommonUtils.*;

import java.util.*;
import java.util.stream.Collector;

import static testing.lib.common.CommonUtils.printArray;
import static testing.lib.common.CommonUtils.printTwoDimentinalArray;

/**
 *
 * @author yunl
 */
public class StringTest {

    private static char[][] chars = {
        "_".toCharArray(),
        "_".toCharArray(),
        "abc".toCharArray(),
        "def".toCharArray(),
        "ghi".toCharArray(),
        "jkl".toCharArray(),
        "mno".toCharArray(),
        "pqrs".toCharArray(),
        "tuv".toCharArray(),
        "wxyz".toCharArray()
    };
    private static String[] strings = {
        "_",
        "_",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };


    public static int strStrDemo (String s1, String s2) {
        System.out.println("\nStart function strStr()");
        System.out.println("\ts1 = " + s1);
        System.out.println("\ts2 = " + s2);
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 > len1) return -1;

        int index = 0;
        int i;
        int nextStart;

        while (index <= (len1 - len2)) {
            for(i = 0, nextStart = -1; i < len2; i++) {
                if ((s2.charAt(0) == s1.charAt(index + i)) && (nextStart == -1) && i > 0)
                    nextStart = i;
                if (s2.charAt(i) != s1.charAt(index + i))
                    break;
            }
            if (i == len2) {
                System.out.println("\tIndex = " + index);
                return index;
            } else {
                if (nextStart == -1)
                    index += i+1;
                else
                    index += nextStart;
            }
        }
        System.out.println("\tIndex = -1");
        return -1;
    }

    public static int strStr (String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 > len1) return -1;

        int index = 0;
        int i;
        int nextStart;

        while (index <= (len1 - len2)) {
            for(i = 0, nextStart = -1; i < len2; i++) {
                if ((s2.charAt(0) == s1.charAt(index + i)) && (nextStart == -1) && i > 0)
                    nextStart = i;
                if (s2.charAt(i) != s1.charAt(index + i))
                    break;
            }
            if (i == len2) {
                return index;
            } else {
                if (nextStart == -1)
                    index += i+1;
                else
                    index += nextStart;
            }
        }
        return -1;
    }

    public static Integer strChr (String s, char c) {
        System.out.println("\nStart function strChr()");
        System.out.println("\tstr = " + s);
        System.out.println("\tc = " + c);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                System.out.println("\tIndex = " + i);
                return i;
            }
        }
        System.out.println("\tIndex = -1");
        return -1;
    }

    public static String reverseDemo (String s) {
        System.out.println("\nStart function reverse()");
        System.out.println("\tstr = " + s);
        String reversed = reverse (s, 0, s.length() - 1);
        System.out.println("\treversed str = " + reversed);
        return reversed;
    }
    public static String reverse (String s) {
        return reverse (s, 0, s.length() - 1);
    }
    public static String reverse (String s, int b, int e) {
        StringBuilder sb = new StringBuilder(s.substring(b, e + 1));

        int size = sb.length();
        for (int i = 0; i < size/2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(size - 1 - i));
            sb.setCharAt(size - 1 - i, temp);
        }
        return sb.toString();
    }
    public static String mergeReverse(String s) {
        if (s == null) 
            return null;
        int len = s.length();
        if (len == 0) 
            return "";
        if (len == 1) 
            return s;
        
        int mid = len/2;
        return mergeReverse(s.substring(mid)) + mergeReverse(s.substring(0, mid));
    }
    
    public static String rightShift (String s, int K) {
        System.out.println("\nStart function rightShift()");
        System.out.println("\tstr = " + s + "; K = " + K);
        int size = s.length();
        String s1 = reverse (s, 0, size - K - 1);
        String s2 = reverse (s, size - K, size - 1);
        String shifted = reverse (s1 + s2, 0, size - 1);
        System.out.println("\tShifted = " + shifted);
        return shifted;
    }

    public static String reverseByWord (String s) {
        System.out.println("\nStart function reverseByWord()");
        System.out.println("\tstr = " + s);
        int index1, index2, size = s.length();

        StringBuilder sb = new StringBuilder();

        for (index1 = 0, index2 = 0; index1 < size; index1++) {
            if (s.charAt(index1) == ' ') {
                sb.append(reverse(s, index2, index1-1)).append(' ');
                index2 = index1 + 1;
            }
        }
        sb.append(reverse(s, index2, index1-1));

        String reversedByWord = sb.toString();
        System.out.println("\tReversed by word: " + reversedByWord);
        return reversedByWord;
    }
    public static String reverseByWord2 (String s) {
        System.out.println("\nStart function reverseByWord2()");
        System.out.println("\tstr = " + s);
        String []words = s.split(" ");
        int len = words.length;
        String []reversed = new String [len];

        for (int i = 0; i < len; i++) {
            reversed[i] = reverse(words[i], 0, words[i].length() - 1);
        }
        String reversedByWord = String.join(" ", reversed);
        System.out.println("\tReversed by word: " + reversedByWord);
        return reversedByWord;
    }

    public static String reverseByDoubleWord (String s) {
        System.out.println("\nStart function reverseByDoubleWord()");
        System.out.println("\tstr = " + s);
        int index1, index2, index3, size = s.length();

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (index1 = 0, index2 = 0, index3 = 0; index1 < size; index1++) {
            if (s.charAt(index1) == ' ') {
                if (index2 == index3) {
                    temp.append(reverse(s, index2, index1 - 1)).append(' ');
                    index2 = index1 + 1;
                } else {
                    temp.append(reverse(s, index2, index1 - 1));
                    sb.append(reverse(temp.toString())).append(' ');
                    temp.delete(0, temp.length());
                    index2 = index1 + 1;
                    index3 = index1 + 1;
                }
            }
        }
        if (index2 != index3) {
            temp.append(reverse(s, index2, index1 - 1));
            sb.append(reverse(temp.toString()));
        } else {
            sb.append(s.substring(index2, index1));
        }
        String reversedByDoubleWord = sb.toString();
        System.out.println("\tReversed by double word: " + reversedByDoubleWord);
        return reversedByDoubleWord;
    }

    public static String strCom (String s1, String s2) {
        System.out.println("\nStart function strCom()");
        System.out.println("\tstr1 = " + s1);
        System.out.println("\tstr2 = " + s2);
        Set<Character> sc1 = new HashSet<> (); // (new Character[](s1.toCharArray()));
        Set<Character> sc2 = new HashSet<> (); // (Arrays.asList(s2.toCharArray()));

        for (char c : s1.toCharArray()) {
            sc1.add(c);
        }
        for (char c : s2.toCharArray()) {
            sc2.add(c);
        }
        sc1.retainAll(sc2);

        System.out.println("\tCommon characters: " + sc1.toString());
        return sc1.toString();
    }

    public static String strDisCom (String s1, String s2) {
        Set<Character> sc1 = new HashSet<> ();
        Set<Character> sc2 = new HashSet<> ();

        for (char c : s1.toCharArray()) {
            sc1.add(c);
        }
        for (char c : s2.toCharArray()) {
            sc2.add(c);
        }

        Set<Character> stemp1 = new HashSet<> (sc1);
        stemp1.addAll(sc2);
        sc1.retainAll(sc2);
        stemp1.removeAll(sc1);

        return stemp1.toString();
    }
    public static String strDisComInOrder (String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        for (char c : s1.toCharArray()) {
            if (strChr (s2, c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //region DFS
    // DFS
    public static void printWithAllUpperLowerCases (String s) {
        System.out.println("\nStart function printWithAllUpperLowerCases()");
        System.out.println("\tstr = " + s);
        printWithAllUpperLowerCases (s, 0);
    }
    private static void printWithAllUpperLowerCases (String s, int index) {
        if (index == s.length()) {
            System.out.println("\t" + s);
            return;
        }
        printWithAllUpperLowerCases(s.substring(0, index) + Character.toLowerCase(s.charAt(index)) + s.substring(index + 1), index + 1);
        printWithAllUpperLowerCases(s.substring(0, index) + Character.toUpperCase(s.charAt(index)) + s.substring(index + 1), index + 1);
    }

    // DFS
    public static void telephoneOutput (Integer[] num) {
        System.out.println("\nStart function telephoneOutput()");
        System.out.println("\tInput num array: " + Arrays.asList(num));
        int[] shift = new int[num.length];

        System.out.println("\t1ST version: ");
        Arrays.fill(shift, 0);
        telephoneOutput  (num, shift, 0);
        
        System.out.println("\t2ND version: ");
        Arrays.fill(shift, 0);
        telephoneOutput2 (num, shift, 0);
    }
    private static void telephoneOutput (Integer[] num, int[] shift, int index) {
        int size = num.length;
        if (index == size) {
            System.out.print("\t");
            for (int i = 0; i < size; i++) {
                System.out.print(chars[num[i]][shift[i]]);
            }
            System.out.println();
            return;
        }
        for (shift[index] = 0; shift[index] < chars[num[index]].length; shift[index]++) {
            telephoneOutput (num, shift, index + 1);
        }
    }
    private static void telephoneOutput2 (Integer[] num, int[] shift, int index) {
        int size = num.length;
        if (index == size) {
            System.out.print ("\t");
            for (int i = 0; i < size; i++) {
                System.out.print (strings[num[i]].charAt(shift[i]));
            }
            System.out.print ("\n");
            return;
        }
        for (shift[index] = 0; shift[index] < strings[num[index]].length(); shift[index]++) {
            telephoneOutput2 (num, shift, index + 1);
        }
    }

    // DFS - Similar to telephoneOutput, with different input type
    public static List<String> letterCombinations(String digits) {
        System.out.println("\nStart function letterCombinations()");
        System.out.println("\tdigits = " + digits);
        List<String> res = new LinkedList<> ();
        
        letterCombinationsDFS (digits, "", res, 0);
        
        System.out.println("\tres = " + res);
        return res;
    }
    private static void letterCombinationsDFS (String digits, String temp, List<String> res, int index) {
        int len = digits.length();
        if (len == index) {
            res.add(temp);
            return;
        }
        int val = digits.charAt(index) - '0';
        for (int i = 0; i < strings[val].length(); i++) {
            letterCombinationsDFS (digits, temp + strings[val].charAt(i), res, index + 1);
        }
    }

    // DFS
    public static void printSubSet (String s) {
        System.out.println("\nStart function printSubSet()");
        System.out.println("\tstr = " + s);
        printSubSet(s, 0);
    }
    private static void printSubSet (String s, int index) {
        if (index == s.length()) {
            System.out.println("\t" + s);
            return;
        }
        //printSubSet(s.substring(0, index) + s.charAt(index) + s.substring(index + 1), index + 1);
        printSubSet(s, index + 1);
        // Attention: do not index + 1 in this case
        printSubSet(s.substring(0, index) + s.substring(index + 1), index);
    }

    // DFS
    public static void printSubSetByBitmap (String s) {
        System.out.println("\nStart function printSubSetByBitmap()");
        System.out.println("\tstr = " + s);
        long c = 1 << s.length();

        for (long i = 0; i < c; i++) {
            long temp = i;
            System.out.print("\t");
            for (int j = 0; j < s.length(); j++) {
                if ((temp & 0x1) == 1) {
                    System.out.print(s.charAt(j));
                }
                temp >>= 1;
            }
            System.out.println();
        }
    }

    // DFS
    public static void printSubSetOfSizeK (String s, int K) {
        System.out.println("\nStart function printSubSetOfSizeK()");
        System.out.println("\tstr = " + s + "; K = " + K);
        printSubSetOfSizeK(s, K, 0);
    }
    private static void printSubSetOfSizeK (String s, int K, int index) {
        if (s.length() == K) {
            System.out.println("\t" + s);
            return;
        }
        if (index == s.length())
            return;

        printSubSetOfSizeK(s, K, index + 1);
        // Attention: do not index + 1 in this case
        printSubSetOfSizeK(s.substring(0, index) + s.substring(index + 1), K, index);
    }

    // DFS
    /**
     * Return all permutations for a given string.
     * There is no duplicated chars
     */
    public static void getPermutationsDemo(String s) {
        System.out.println("\nStart function getPermutationsDemo()");
        System.out.println("\tstr = " + s);
        List<String> res = getPermutations(s);
        System.out.println("\tPermutations:");
        for (String str : res) {
            System.out.println("\t\t" + str);
        }
    }
    public static List<String> getPermutations(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        boolean[] used = new boolean [s.length()];
        Arrays.fill (used, false);
        String p = "";
        getPermutations(s, p, used, index, res);
        return res;
    }
    private static void getPermutations(String s, String p, boolean [] used, int index, List<String> res) {
        if (index == s.length()) {
            res.add(p);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                getPermutations(s, p + s.charAt(i), used, index + 1, res);
                used[i] = false;
            }
        }
    }
    /**
     * Similar as above question
     * But this time, there might be duplicated characters in the string
     */
    public static void getPermutationsWithDupCharacterDemo(String s) {
        System.out.println("\nStart function getPermutationsWithDupCharacterDemo()");
        System.out.println("\tstr = " + s);
        List<String> res = getPermutationsWithDupCharacter(s);
        System.out.println("\tPermutations:");
        for (String str : res) {
            System.out.println("\t\t" + str);
        }
    }
    public static List<String> getPermutationsWithDupCharacter(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        getPermutationsWithDupCharacter(s.length(), "", map, res);
        return res;
    }
    public static void getPermutationsWithDupCharacter(int len, String temp, HashMap<Character, Integer> counts, List<String> res) {
        if (temp.length() == len) {
            res.add(temp);
        } else {
            for (char c : counts.keySet()) {
                int count = counts.get(c);
                if (count > 0) {
                    counts.put(c, count - 1);
                    getPermutationsWithDupCharacter(len, temp + c, counts, res);
                    counts.put(c, count);
                }
            }
        }
    }

    // DFS
    public static void printSubSetPermution (String s) {
        System.out.println("\nStart function printSubSetPermution()");
        System.out.println("\tstr = " + s);
        printSubSetPermution(s, 0);
    }
    private static void printSubSetPermution (String s, int index) {
        if (index == s.length()) {
            List<String> res = getPermutations(s);
            for (String str : res) {
                System.out.println("\t\t" + str);
            }
            return;
        }
        printSubSetPermution(s, index + 1);
        // Attention: do not index + 1 in this case
        printSubSetPermution(s.substring(0, index) + s.substring(index + 1), index);
    }
//    public static void printSubSetPermution (String s) {
//        int index = 0;
//        boolean[] used = new boolean [s.length()];
//        Arrays.fill (used, false);
//        String p = "";
//        printSubSetPermution (s, p, used, index);
//    }
//    public static void printSubSetPermution (String s, String p, boolean [] used, int index) {
//        if (index == s.length()) {
//            System.out.println("\t" + p);
//            return;
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (used[i] == false) {
//                used[i] = true;
//                printSubSetPermution (s, p + s.charAt(i), used, index + 1);
//                printSubSetPermution (s, p, used, index + 1);
//                used[i] = false;
//            }
//        }
//    }

    // DFS
    // Implement an algorithm to print all valid (eg, properly opened and closed) combinations of n-pairs of parentheses
    public static void printPar (int K) {
        System.out.println("\nStart function printPar()");
        System.out.println("\tK = " + K);
        printPar (K, K);
    }
    private static void printPar (int L, int R) {
        printPar ("", L, R);
    }
    private static void printPar (String s, int L, int R) {
        if (L < 0 || R < L)
            return;
        if (L == 0 && R == 0)
            System.out.println("\t" + s);
        else {
            if (L > 0) {
                printPar (s + '{', L - 1, R);
            }
            if (R > L) {
                printPar (s + '}', L, R - 1);
            }
        }
    }

    // DFS
    public static void findSigns (Integer [] a) {
        System.out.println("\nStart function findSigns()");
        System.out.println("\ta = " + Arrays.asList(a));
        findSigns (a, 0);
        //System.out.println("\ta = " + Arrays.asList(a));
    }
    private static void findSigns (Integer [] a, int index) {
        if (index == a.length) {
            int sum = 0;
            for (int i : a)
                sum += i;
            if (sum == 0)
                System.out.println("\t" + Arrays.toString(a));
            return;
        }
        findSigns (a, index + 1);
        a[index] *= -1;
        findSigns (a, index + 1);
        a[index] *= -1;     // This line makes sure that array "a" is not changed after findSigns() is finished. Can be removed if not needed.
    }
    //endregion

    public static int strToInt (String s) {
        System.out.println("\nStart function strToInt()");
        System.out.println("\tstr = " + s);
        int temp = 0;

        for (char c : s.toCharArray()) {
            if (c > '0' && c < '9') {
                temp *= 10;
                temp += c - '0';
            }
        }
        System.out.println("\tconverted = " + temp);
        return temp;
    }

    public static String intToStr (int n) {
        System.out.println("\nStart function intToStr()");
        System.out.println("\tn = " + n);
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append((char)('0' + n%10));
            n /= 10;
        }
        System.out.println("\tconverted = " + sb.toString());
        return reverse (sb.toString());
    }

    public static String replaceSubstring (String s, String sub, String replace) {
        System.out.println("\nStart function replaceSubstring()");
        System.out.println("\tsub = " + sub + "; replace = " + replace);

        int index = strStr (s, sub);
        if (index != -1) {
            StringBuilder sb = new StringBuilder ();
            sb.append(s.substring(0, index));
            sb.append(replace);
            sb.append(s.substring(index + sub.length()));

            System.out.println("\tReplaced string: " + sb.toString());
            return sb.toString();
        }
        System.out.println("\tCannot be replaced");
        return null;
    }

    public static String removeDuplicates (String s) {
        System.out.println("\nStart function removeDuplicates()");
        System.out.println("\ts  = " + s);
        StringBuilder sb = new StringBuilder ();
        sb.append(s.charAt(0));

        int len = s.length();
        for (int i = 1; i < len; i++) {
            int j;
            int sbLen = sb.length();
            for (j = 0; j < sbLen; j++) {
                if (sb.charAt(j) == s.charAt(i))
                    break;
            }
            if (j == sbLen) {
                sb.append(s.charAt(i));
            }
        }

        System.out.println("\tDuplicates removed: " + sb.toString());
        return sb.toString();
    }

    public static String longestDupDemo (String s1, String s2) {
        if (s1.length() > s2.length())
            return longestDup (s2, s1);

        System.out.println("\nStart function longestDup()");
        System.out.println("\ts1 = " + s1 + "; s2 = " + s2);

        int length1 = s1.length();
        for (int len = length1; len > 0; len--) {
            for (int index1 = 0; index1 <= (s1.length() - len); index1++) {
                String sub = s1.substring(index1, index1 + len);
                if (strStr (s2, sub) != -1) {
                    System.out.println("\tlongest dup: " + sub);
                    return sub;
                }
            }
        }
        System.out.println("\tNo dup fount!");
        return null;
    }
    public static String longestDup (String s1, String s2) {
        if (s1.length() > s2.length())
            return longestDup (s2, s1);

        int length1 = s1.length();
        for (int len = length1; len > 0; len--) {
            for (int index1 = 0; index1 <= (s1.length() - len); index1++) {
                String sub = s1.substring(index1, index1 + len);
                if (strStr (s2, sub) != -1) {
                    return sub;
                }
            }
        }
        return null;
    }

    /**
     * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
     * and there exists one unique longest palindromic substring.
     *
     * DP Problem
     * https://oj.leetcode.com/problems/longest-palindromic-substring/
     */
    public static String longestPalindrome (String s) {
        System.out.println("\nStart function longestPalindrome()");
        System.out.println("\ts  = " + s);

        String rs = reverse (s);
        System.out.println("\trs = " + rs);

        String longestPalindrome = longestDup (s, rs);
        System.out.println("longestPalindrome = " + longestPalindrome);
        return longestPalindrome;
    }
    // DP Problem Solution - Optimal solution
    // DP[i][j] = s.charAt[i] == s.charAt[j] && (j - i < 2 || DP[i+1][j-1])
    // 所以，i必须是大到小，j则是小到大
    public static String longestPalindromeDP (String s) {
        System.out.println("\nStart function longestPalindromeDP()");
        System.out.println("\ts  = " + s);

        if (s == null) return null;
        int len = s.length();
        if (len <= 1) return s;

        boolean[][] P = new boolean[len][len];
        for (int i = 0; i < len; i++)
            Arrays.fill(P[i], false);
        int maxL = 1;
        int start = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j)) && ((j - i < 2) || P[i+1][j-1])) {
                    P[i][j] = true;
                    if (maxL < j-i+1) {
                        maxL = j-i+1;
                        start = i;
                    }
                }
            }
        }
        System.out.println("longestPalindrome = " + s.substring(start, start + maxL));
        return s.substring(start, start + maxL);
    }
    public static String longestPalindromeDP2 (String s) {
        System.out.println("\nStart function longestPalindromeDP2()");
        System.out.println("\ts  = " + s);

        if (s == null) return null;
        int len = s.length();
        if (len < 2) return s;

        boolean[][] DP = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(DP[i], false);
        }
        int maxL = 0;
        int start = 0;
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j-i < 2 || DP[i+1][j-1])) {
                    DP[i][j] = true;
                    if (maxL < j-i+1) {
                        maxL = j-i+1;
                        start = i;
                    }
                }
            }
        }
        System.out.println("longestPalindrome = " + s.substring(start, start + maxL));
        return s.substring(start, start + maxL);
    }

    /**
     * Shortest Palindrome   Add to List QuestionEditorial Solution  My Submissions
     * Total Accepted: 31802
     * Total Submissions: 140056
     * Difficulty: Hard
     * Contributors: Admin
     * Given a string S, you are allowed to convert it to a palindrome by adding
     * characters in front of it.
     * Find and return the shortest palindrome you can find by performing this transformation.
     *
     * For example:
     * Given "aacecaaa", return "aaacecaaa".
     * Given "abcd", return "dcbabcd".
     *
     * https://leetcode.com/problems/shortest-palindrome/
     */
    // Timeouts
    public static String shortestPalindrome(String s) {
        if (s == null) return null;

        int len = s.length();
        if (len <= 1) return s;

        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            if (!set.contains(c)) {
                set.add(c);
            }
        }
        if (set.size() == 1) {
            return s;
        }

        if (reverse(s) == s) return s;

        boolean[][] DP = new boolean[len][len];
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            Arrays.fill(DP[i], false);
        }
        for (int j = 0; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                DP[i][j] = (j-i < 2 && chars[i] == chars[j]) || (j-i >= 2 && DP[i+1][j-1] && chars[i] == chars[j]);
                if (DP[i][j] && i == 0 && j + 1 > maxLen) {
                    maxLen = j + 1;
                }
            }
        }

        if (maxLen < len) {
            String reversedSub2 = reverse(s.substring(maxLen));
            return reversedSub2 + s;
        } else {
            return s;
        }
    }
    // Still timeouts
    public static String shortestPalindrome2(String s) {
        System.out.println("\nStart function shortestPalindrome()");
        System.out.println("\ts  = " + s);
        if (s == null) return null;

        int len = s.length();
        if (len <= 1) return s;

        String t = reverse(s);
        if (t == s) return s;

        int i = len;
        for (; i >= 0; i--) {
            if (s.substring(0, i).equals(t.substring(len - i))) {
                break;
            }
        }
        String res = t.substring(0, len - i) + s;
        System.out.println("shortestPalindrome = " + res);
        return res;

    }
    // Optimal solution
    public String shortestPalindrome3(String s) {
        if (s == null) return null;

        int len = s.length();
        if (len <= 1) return s;

        char[] chars = s.toCharArray();

        int i = 0, end = len - 1, j = end;

        while (i < j) {
            if (chars[i] == chars[j]) {
                i++; j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return reverse(s.substring(end + 1)) + s;
    }

    /**
     * Longest Palindrome
     *
     * Given a string which consists of lowercase or uppercase letters,
     * find the length of the longest palindromes that can be built with those letters.
     *
     * This is case sensitive, for example "Aa" is not considered a palindrome here.
     *
     * Note:
     * Assume the length of given string will not exceed 1,010.
     *
     * Example:
     * Input:
     *         "abccccdd"
     * Output:
     *         7
     * Explanation:
     * One longest palindrome that can be built is "dccaccd", whose length is 7.
     *
     * https://leetcode.com/problems/longest-palindrome/
     */
    public static int longestPalindromePossible(String s) {
        System.out.println("\nStart function longestPalindromePossible()");
        System.out.println("\ts  = " + s);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int evenSum = 0;
        int oddSum = 0;
        int oddCount = 0;

        for (Character c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                evenSum += map.get(c);
            } else {
                oddSum += map.get(c);
                oddCount++;
            }
        }
        if (oddCount == 0) {
            System.out.println("\tMax possible length = " + evenSum);
            return evenSum;
        } else {
            System.out.println("\tMax possible length = " + (evenSum + oddSum - (oddCount - 1)));
            return evenSum + oddSum - (oddCount - 1);
        }
    }

    /**
     * Palindrome Permutation
     *
     * Given a string, determine if a permutation of the string could form a palindrome.
     *
     * For example,
     *      "code" -> False, "aab" -> True, "carerac" -> True.
     */
    public static boolean canPermutePalindrome(String s) {
        if (s == null) return true;

        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }

        boolean firstOdd = false;
        for (char c : count.keySet()) {
            if (count.get(c) % 2 == 1) {
                if (!firstOdd) {
                    firstOdd = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Palindrome Permutation II
     *
     * Given a string s, return all the palindromic permutations (without duplicates) of it.
     * Return an empty list if no palindromic permutation could be form.
     *
     * For example:
     * Given s = "aabb", return ["abba", "baab"].
     * Given s = "abc", return [].
     */
    public static void generatePalindromesDemo(String s) {
        System.out.println("\nStart function generatePalindromesDemo()");
        System.out.println("\ts  = " + s);
        List<String> res = generatePalindromes(s);
        System.out.println("\tPossible Palindrome: ");
        for (String str : res) {
            System.out.println("\t\t" + str);
        }
    }
    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.put(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }

        int halfCount = 0;

        Character firstOdd = null;
        for (char c : counts.keySet()) {
            int count = counts.get(c);
            if (count % 2 == 1) {
                if (firstOdd == null) {
                    firstOdd = c;
                } else {
                    return res;
                }
            }
            halfCount += count/2;
            counts.put(c, count/2);
        }

        getPermutationsWithDupCharacter(halfCount, "", counts, res);

        List<String> res2 = new ArrayList<>();
        for (String str : res) {
            if (firstOdd != null) {
                res2.add(str + firstOdd + reverse(str));
            } else {
                res2.add(str + reverse(str));
            }
        }
        return res2;
    }

    /**
     * DP Problem
     */
    public static boolean isShuffled (String x, String y, String z) {
        System.out.println("\nStart function isShuffled()");
        System.out.println("\tx  = " + x);
        System.out.println("\ty  = " + y);
        System.out.println("\tz  = " + z);
        int lenX = x.length();
        int lenY = y.length();
        int lenZ = z.length();
        
        if (lenZ != (lenX + lenY))
            return false;
        
        boolean [][] match = new boolean [lenX + 1][lenY + 1];
        
        match[0][0] = true;
        for (int i = 1; i <= lenX; i++) {
            match[i][0] = match[i-1][0] && (z.charAt(i - 1) == x.charAt(i - 1));
        }
        for (int j = 1; j <= lenY; j++) {
            match[0][j] = match[0][j-1] && (z.charAt(j - 1) == y.charAt(j - 1));
        }
        
        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                match[i][j] = (match[i-1][j] && (z.charAt(i+j-1) == x.charAt(i-1))) ||
                              (match[i][j-1] && (z.charAt(i+j-1) == y.charAt(j-1)));
            }
        }
        
        for (int i = 0; i <= lenX; i++) {
            System.out.print("\t");
            for (int j = 0; j <= lenY; j++) {
                System.out.print((match[i][j]?1:0) + " ");
            }
            System.out.println();
        }

        System.out.println("\tisShuffled = " + match[lenX][lenY]);
        return match[lenX][lenY];
    }
    /**
     * DP Problem
     * Same as isShuffled(), in better format
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        System.out.println("\nStart function isInterleave()");
        System.out.println("\ts1  = " + s1);
        System.out.println("\ts2  = " + s2);
        System.out.println("\ts3  = " + s3);
        if (s1 == null && s2 == null)
            return s3 == null;
        else {
            if (s1 == null)
                return s3.equals(s2);
            if (s2 == null)
                return s3.equals(s1);
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != (len1 + len2))
            return false;
        if (len1 == 0)
            return s3.equals(s2);
        else if (len2 == 0)
            return s3.equals(s1);
            
        boolean [][] flags = new boolean [len1 + 1][len2 + 1];
        flags[0][0] = true;
        for (int i = 1; i <= len1; ++i)
            flags[i][0] = flags[i-1][0] && (s3.charAt(i-1) == s1.charAt(i-1));
        for (int j = 1; j <= len2; ++j)
            flags[0][j] = flags[0][j-1] && (s3.charAt(j-1) == s2.charAt(j-1));

        for (int i = 1; i <= len1; ++i)
            for (int j = 1; j <= len2; ++j) {
                flags[i][j] = (flags[i-1][j] && (s3.charAt(i+j-1) == s1.charAt(i-1))) ||
                              (flags[i][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1)));
            }
        for (int i = 0; i <= len1; ++i) {
            System.out.print("\t");
            for (int j = 0; j <= len2; ++j ) {
                System.out.print((flags[i][j]?1:0) + " ");
            }
            System.out.println();
        }
        System.out.println("\tisInterleaved = " + flags[len1][len2]);
        return flags[len1][len2];
    }
    // Same as the above one, just using rolling array this time
    public static boolean isInterleave2 (String s1, String s2, String s3) {
        System.out.println("\nStart function isInterleave2()");
        System.out.println("\ts1  = " + s1);
        System.out.println("\ts2  = " + s2);
        System.out.println("\ts3  = " + s3);
        if (s1 == null && s2 == null)
            return s3 == null;
        else {
            if (s1 == null)
                return s2.equals(s3);
            if (s2 == null)
                return s1.equals(s3);
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != (len1 + len2))
            return false;
        if (len1 == 0)
            return s3.equals(s2);
        if (len2 == 0)
            return s3.equals(s1);
        
        boolean [][] flags = new boolean [2][len2 + 1];
        flags[0][0] = true;
        for (int j = 1; j <= len2; j++)
            flags[0][j] = flags[0][j-1] && (s3.charAt(j-1) == s2.charAt(j-1));
        
        for (int i = 1; i <= len1; i++) {
            flags[i%2][0] = flags[(i-1)%2][0] && (s3.charAt(i-1) == s1.charAt(i-1));
            for (int j = 1; j < len2; j++) {
                flags[i%2][j] = (flags[(i-1)%2][j] && (s3.charAt(i+j-1) == s1.charAt(i-1))) ||
                                (flags[i%2][j-1] && (s3.charAt(i+j-1) == s2.charAt(j-1)));
            }
        }
        System.out.println("\tisInterleaved = " + flags[len1%2][len2]);
        return flags[len1%2][len2];
    }
            
    /**
     * DP Problem
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences. 
     * For example, given
     *      s = "catsanddog",
     *      dict = ["cat", "cats", "and", "sand", "dog"].
     * 
     * A solution is ["cats and dog", "cat sand dog"]. 
     */
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        System.out.println("\nStart function wordBreak()");
        System.out.println("\ts  = " + s);
        System.out.println("\tdict  = " + dict);

        if (s == null || s.length() <= 0)
            return null;
        int len = s.length();
        
        ArrayList<ArrayList<String>> arr = new ArrayList<> ();
        
        for (int j = 0; j < len; j++) {
            arr.add(new ArrayList<> ());
            for (int i = 0; i <= j; i++ ) {
                String sub = s.substring(i, j + 1); // Attention: j+1 but not j
                if (dict.contains(sub)) {
                    if (i == 0) {
                        arr.get(j).add(sub);
                    } else if (!arr.get(i - 1).isEmpty()) {
                        for (String tempStr : arr.get(i - 1))
                            arr.get(j).add(tempStr + " " + sub);
                    }
                }
            }
        }
        for(ArrayList<String> list : arr)
            System.out.println("\t" + list);
        return arr.get(len - 1);
    }
    /**
     * Very similar to wordBreak. Just use dictlenSet to improve the performance
     *
     * DP Problem
     */
    public static List<String> wordBreak2(String s, Set<String> dict) {
        System.out.println("\nStart function wordBreak2()");
        System.out.println("\ts  = " + s);
        System.out.println("\tdict  = " + dict);

        if (s == null || s.length() <= 0)
            return null;
        int len = s.length();

        ArrayList<ArrayList<String>> arr = new ArrayList<> ();

        // int size = dict.size();
        HashSet<Integer> dictlenSet = new HashSet<> ();
        for (String str : dict) {
            Integer ts = str.length();
            if (!dictlenSet.contains(ts))
                dictlenSet.add(ts);
        }

        for (int j = 0; j < len; j++) {
            arr.add(new ArrayList<> ());
            
            for (Integer wl : dictlenSet) {
                int lowEnd = j - wl + 1;
                if (lowEnd > 0 && !arr.get(lowEnd-1).isEmpty()) {
                    String sub = s.substring(lowEnd, j + 1);
                    if (dict.contains(sub)) {
                        for (String str : arr.get(lowEnd-1))
                            arr.get(j).add(str + " " + sub);
                    }
                } else if (lowEnd == 0) {
                    String sub = s.substring(lowEnd, j + 1);
                    if (dict.contains(sub)) {
                        arr.get(j).add(sub);
                    }
                }
            }
        }
        for(ArrayList<String> list : arr)
            System.out.println("\t" + list);
        return arr.get(len-1);
    }

    /**
     * DFS
     */
    public static List<String> wordBreak3(String s, Set<String> dict) {
        System.out.println("\nStart function wordBreak3()");
        System.out.println("\ts  = " + s);
        System.out.println("\tdict  = " + dict);
        ArrayList<String> ret = new ArrayList<> ();
        if (s == null || s.length() == 0) return ret;
        int n = s.length();
        boolean [] dp = new boolean [n+1];
        for (int i = 1; i <= n; i++) {
            if (dict.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        if (!dp[n]) return ret;
        StringBuilder cur = new StringBuilder();
        wordBreak3Dfs(s, 0, cur, ret, dict);
        System.out.println("\tresult = " + ret);
        return ret;
    }
    private static void wordBreak3Dfs(String s, int start, StringBuilder cur, ArrayList<String> ret, Set<String> dict) {
        int n = s.length();
        if (start >= n) {
            ret.add(new String(cur));
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            String sub = s.substring(start, i);
            if (dict.contains(sub)) {
                int oldLen = cur.length();
                if (oldLen != 0)
                    cur.append(" ");
                cur.append(sub);
                wordBreak3Dfs(s, i, cur, ret, dict);
                cur.delete(oldLen, cur.length());
            }
        }
    }
    /**
     * DFS
     * Very similar to wordBreak3, use LinkedList<String>, instead of StringBuilder, to store temp results
     */
    public static List<String> wordBreak4(String s, Set<String> dict) {
        System.out.println("\nStart function wordBreak4()");
        System.out.println("\ts  = " + s);
        System.out.println("\tdict  = " + dict);
        List<String> ret = new ArrayList<> ();
        if (s == null || s.length() == 0) return ret;
        int len = s.length();
        boolean [] dp = new boolean [len+1];
        for (int i = 1; i <= len; i++) {
            if (dict.contains(s.substring(0, i)))
                dp[i] = true;
            else {
                for (int j = 1; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        if (!dp[len]) return ret;
        wordBreakDfs4(s, 0, new LinkedList<String> (), ret, dict);
        System.out.println("\tresult = " + ret);
        return ret;
    }
    private static void wordBreakDfs4(String s, int start, LinkedList<String> tmp, List<String> ret, Set<String> dict) {
        int len = s.length();
        if (len == start ) {
            LinkedList<String> tt = new LinkedList<> (tmp);
            StringBuilder sb = new StringBuilder();
            int size = tt.size();
            while (size > 1) {
                sb.append(tt.removeFirst()).append(" ");
                size--;
            }
            if (size == 1)
                sb.append(tt.removeFirst());
            ret.add(sb.toString());
        } else {
            for (int i = start+1; i <= len; i++) {
                String sub = s.substring(start, i);
                if (dict.contains(sub)) {
                    tmp.addLast(sub);
                    wordBreakDfs4(s, i, tmp, ret, dict);
                    tmp.removeLast();
                }
            }
        }
    }

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome. 
     * Return all possible palindrome partitioning of s. 
     * For example, given s = "aab",
     * Return 
     * [
     *     ["aa","b"],
     *     ["a","a","b"]
     * ]
     */
    public static ArrayList<String> PalindromePartitioning (String s) {
        System.out.println("\nStart function PalindromePartitioning()");
        System.out.println("\ts  = " + s);
        if (s == null || s.length() <= 0)
            return new ArrayList<>();
        int len = s.length();
        
        ArrayList<ArrayList<String>> arr = new ArrayList<> ();
        
        for (int j = 0; j < len; j++) {
            arr.add(new ArrayList<String> ());
            for (int i = 0; i <= j; i++) {
                String str = s.substring(i, j+1);
                if (isPalindrome(str)) {
                    if (i == 0) {
                        arr.get(j).add(str);
                    } else if (!arr.get(i - 1).isEmpty()) {
                        for (String temp : arr.get(i - 1))
                            arr.get(j).add(temp + "+" + str);
                    }
                }
            }
        }

        for (ArrayList<String> list : arr)
            System.out.println("\t" + list);
        return arr.get(len - 1);
    }
    private static boolean isPalindrome (String str) {
        String reStr = reverse (str);

        return reStr.equals(str);
    }

    /**
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
     * Below is one possible representation of s1 = "great":
     *      great
     *     /    \
     *    gr    eat
     *   / \    /  \
     *  g   r  e   at
     *             / \
     *            a   t
     * To scramble the string, we may choose any non-leaf node and swap its two children.
     * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
     *      rgeat
     *     /    \
     *    rg    eat
     *   / \    /  \
     *  r   g  e   at
     *             / \
     *            a   t
     * We say that "rgeat" is a scrambled string of "great".
     * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
     *      rgtae
     *     /    \
     *    rg    tae
     *   / \    /  \
     *  r   g  ta  e
     *        / \
     *       t   a
     * We say that "rgtae" is a scrambled string of "great".
     * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
     */
    public static boolean isScrambleDemo(String s1, String s2) {
        System.out.println("\nStart function isScrambleDemo()");
        System.out.println("\ts1  = " + s1);
        System.out.println("\ts2  = " + s2);

        boolean res = isScramble(s1, s2);
        System.out.println("\tisScramble = " + res);
        return res;
    }
    public static boolean isScramble (String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        
        char [] ca1 = s1.toCharArray();
        char [] ca2 = s2.toCharArray();

        Arrays.sort(ca1);
        Arrays.sort(ca2);
        String ts1 = new String (ca1);
        String ts2 = new String (ca2);
        if (!ts1.equals(ts2)) {
            return false;
        }
        
        int len = s1.length();
        for (int isep = 1; isep < len; ++isep) {
            // seperate s1 as [0, isep - 1) & [isep, len)
            String seg11 = s1.substring(0, isep);
            String seg12 = s1.substring(isep);
            {
                String seg21 = s2.substring(0, isep);
                String seg22 = s2.substring(isep);
                if (isScramble (seg11, seg21) && isScramble (seg12, seg22))
                    return true;
            }
            {
                String seg21 = s2.substring(len - isep);
                String seg22 = s2.substring(0, len - isep);
                if (isScramble (seg11, seg21) && isScramble (seg12, seg22))
                    return true;
            }
        }
        return false;
    }
    
    /** Distinct Subsequences - Accepted
     * 
     * DP Problem
     *
     * Given a string S and a string T, count the number of distinct subsequences of T in S.
     * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters 
     * without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
     *
     * Here is an example:
     * S = "rabbbit", T = "rabbit"
     * Return 3.
     * 
     * Use DP to solve
     * S, T are two strings.
     * Make DP[S.length() + 1][T.length() + 1], where DP[i+1][j+1] means the number of D.S for
     * S.substring(0, i+1) and T.substring(0, j+1)
     * So, the relation would be
     *      DP[i][j] = DP[i-1][j] + (S.charAt(i-1) == T.charAt(j-1))?DP[i-1][j-1];
     * 
     * So we can see that each row only depends on its previous row, 
     * instead of using two-dimentional array, we can use rolling array to solve this problem
     * 
     */
     public static int numDistinct (String S, String T) {
        int lenS = S.length();
        int lenT = T.length();

        if (lenS < lenT) return 0;
        int [] match = new int [lenT + 1];
        Arrays.fill(match, 0);
        match[0] = 1;
     
        for (int si = 1; si <= lenS; ++si) {
            for (int tj = lenT; tj >= 1; --tj) {
                if (S.charAt(si - 1) == T.charAt(tj - 1)) {
                    match[tj] += match[tj - 1];
                }
            }
        }
        return match[lenT];
    }
    // Normal version
    public static int numDistinct2 (String S, String T) {
        int lenS = S.length();
        int lenT = T.length();

        if (lenS < lenT) return 0;
        int [][] DP = new int [lenS + 1][lenT + 1];
        for (int i = 0; i < lenS; i++) {
            Arrays.fill(DP[i], 0);
        }
        DP[0][0] = 1;
        for (int si = 1; si <= lenS; ++si) {
            DP[si][0] = 1;
            for (int tj = 1; tj <= lenT; ++tj) {
                DP[si][tj] = DP[si - 1][tj];
                if (S.charAt(si - 1) == T.charAt(tj - 1)) {
                    DP[si][tj] += DP[si - 1][tj - 1];
                }
            }
        }
        return DP[lenS][lenT];
    }
    // DFS version
    public static int numDistinct3 (String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if (lenS < lenT) return 0;
        ArrayList<Integer> res = new ArrayList<>();
        numDistinctDFS (s, t, res);
        return res.size();
    }
    private static void numDistinctDFS (String s, String t, ArrayList<Integer> res) {
         if (s == null || t == null) return;

         int lenS = s.length();
         int lenT = t.length();
         if (lenT == 0) {
             res.add(1);
         } else if (s.equals(t)){
             res.add(1);
         } else if (lenS >= lenT) {
             if (s.charAt(0) == t.charAt(0)) {
                 numDistinctDFS(s.substring(1), t.substring(1), res);
             }
             numDistinctDFS(s.substring(1), t, res);
         }
    }

    /* Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100".
     */
    public String addBinaryV1(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        
        StringBuilder sb = new StringBuilder ();
        
        int carry = 0;
        int iterA = lenA - 1;
        int iterB = lenB - 1;
        
        int na = (iterA < 0)?0:Character.getNumericValue(a.charAt(iterA--));
        int nb = (iterB < 0)?0:Character.getNumericValue(b.charAt(iterB--));
        
        do {
            int sum = na + nb + carry;
            carry = (sum>=2)?1:0;
            sum %= 2;
            
            sb.insert(0, sum);
            
            na = (iterA < 0)?0:Character.getNumericValue(a.charAt(iterA--));
            nb = (iterB < 0)?0:Character.getNumericValue(b.charAt(iterB--));
        } while (carry > 0 || na > 0 || nb > 0);
        
        return sb.toString();
    }
    public String addBinaryV2(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        StringBuilder sb = new StringBuilder ();

        for (int itera = lenA - 1, iterb = lenB - 1, carry = 0;
             carry > 0 || itera >= 0 || iterb >= 0;
             itera--, iterb--) {
            int na = (itera < 0)?0:Character.getNumericValue(a.charAt(itera));
            int nb = (iterb < 0)?0:Character.getNumericValue(b.charAt(iterb));

            int sum = na + nb + carry;
            carry = (sum>=2)?1:0;
            sum %= 2;
            sb.insert(0, sum);
        }
        return sb.toString();
    }

    /** Given a 2D board and a word, find if the word exists in the grid.
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are 
     * those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * For example,
     * Given board =
     * [
     *     ["ABCE"],
     *     ["SFCS"],
     *     ["ADEE"]
     * ]
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     */ 
    static public boolean exist(Character[][] board, String word) {
        System.out.println("\nStart function exist()");
        System.out.println("\tboard:");
        for (int i = 0; i < board.length; i++)
            System.out.println("\t" + Arrays.asList(board[i]));
        System.out.println("\tword  = " + word);

        if (board == null)
            return (word == null || word.isEmpty());
        int Row = board.length;
        if (Row <= 0) 
            return (word == null || word.isEmpty());
        int Column = board[0].length;

        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                if (existHelper (board, word, i, j, Row, Column, "")) {
                    System.out.println("\texist = true");
                    return true;
                }
            }
        }
        System.out.println("\texist = false");
        return false;
    }
    static private boolean existHelper (Character[][] board, String word, int i, int j, int Row, int Column, String str) {
        if (i < 0 || j < 0 || i >= Row || j >= Column || 
            board[i][j] == '*' || 
            str.length() >= word.length() ||
            !word.startsWith(str.toString())) {
            return false;
        }
        
        String newStr = str + board[i][j];
        char tempChar = board[i][j];
        board[i][j] = '*';
        boolean flag = false;
        
        if (newStr.equals(word))
            flag = true;
        if (!flag && existHelper (board, word, i + 1, j, Row, Column, newStr))
            flag = true;
        if (!flag && existHelper (board, word, i - 1, j, Row, Column, newStr))
            flag = true;
        if (!flag && existHelper (board, word, i, j + 1, Row, Column, newStr))
            flag = true;
        if (!flag && existHelper (board, word, i, j - 1, Row, Column, newStr))
            flag = true;
        
        board[i][j] = tempChar;
        return flag;
    }
    // This version is better than last version
    static public boolean exist2(Character[][] board, String word) {
        System.out.println("\nStart function exist2()");
        System.out.println("\tboard:");
        for (int i = 0; i < board.length; i++)
            System.out.println("\t" + Arrays.asList(board[i]));
        System.out.println("\tword  = " + word);

        int R = board.length;
        if (R <= 0) return false;
        int C = board[0].length;
        if (C <= 0) return false;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (existHelper2(board, word, i, j, R, C, board[i][j].toString())) {
                    System.out.println("\texist = true");
                    return true;
                }
            }
        }
        System.out.println("\texist = false");
        return false;
    }
    static private boolean existHelper2 (Character[][] board, String word, int i, int j, int R, int C, String str) {
        if (str.equals(word)) return true;
        if (!word.startsWith(str) || str.length() >= word.length()) return false;

        boolean found = false;
        Character tmp = board[i][j];
        board[i][j] = '*';
        if ((i + 1 < R && board[i + 1][j] != '*' && existHelper2(board, word, i + 1, j, R, C, str + board[i + 1][j])) ||
            (j + 1 < C && board[i][j + 1] != '*' && existHelper2(board, word, i, j + 1, R, C, str + board[i][j + 1])) ||
            (i - 1 >= 0 && board[i - 1][j] != '*' && existHelper2(board, word, i - 1, j, R, C, str + board[i - 1][j])) ||
            (j - 1 >= 0 && board[i][j - 1] != '*' && existHelper2(board, word, i, j - 1, R, C, str + board[i][j - 1]))) {
            found = true;
        }
        board[i][j] = tmp;
        return found;
    }

    // A use case of Trie tree!!!
    // This version timeouts in LeetCode test
    public static List<String> findWords(Character[][] board, String[] words) {
        System.out.println("\nStart function findWords()");
        System.out.println("\tboard:");
        for (int i = 0; i < board.length; i++)
            System.out.println("\t" + Arrays.asList(board[i]));
        System.out.println("\twords  = " + Arrays.asList(words));

        List<String> res = new ArrayList<>();
        if (board == null) return res;
        int Row = board.length;
        if (Row <= 0) return res;
        int Column = board[0].length;
        if (Column <= 0) return res;

        if (words.length <= 0) return res;

        Trie dict = new Trie();
        for (String s : words) dict.insert(s);
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                findWordsHelper(board, dict, i, j, Row, Column, "", res);
            }
        }
        System.out.println("\tResults = " + res);
        return res;
    }
    private static void findWordsHelper(Character[][] board, Trie dict, int i, int j, int Row, int Column, String str, List<String> res) {
        if (i < 0 || j < 0 || i >= Row || j >= Column || board[i][j] == '*') return;

        String newStr = str + board[i][j];
        if (dict.startsWith(newStr)) {
            char tempChar = board[i][j];
            board[i][j] = '*';

            if (dict.search(newStr)) {
                res.add(newStr);
            }
            findWordsHelper(board, dict, i + 1, j, Row, Column, newStr, res);
            findWordsHelper(board, dict, i - 1, j, Row, Column, newStr, res);
            findWordsHelper(board, dict, i, j + 1, Row, Column, newStr, res);
            findWordsHelper(board, dict, i, j - 1, Row, Column, newStr, res);

            board[i][j] = tempChar;
        }
    }
    public static List<String> findWords2(Character[][] board, String[] words) {
        System.out.println("\nStart function findWords2()");
        System.out.println("\tboard:");
        for (int i = 0; i < board.length; i++)
            System.out.println("\t" + Arrays.asList(board[i]));
        System.out.println("\twords  = " + Arrays.asList(words));

        List<String> res = new ArrayList<>();
        if (board == null) return res;
        int Row = board.length;
        if (Row <= 0) return res;
        int Column = board[0].length;
        if (Column <= 0) return res;

        if (words.length <= 0) return res;

        Trie dict = new Trie();
        HashSet<String> set = new HashSet<>();
        for (String s : words) dict.insert(s);
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                findWordsHelper2(board, dict, i, j, Row, Column, board[i][j].toString(), set);
            }
        }

        res.addAll(set);
        System.out.println("\tResults = " + res);
        return res;
    }
    // This version passes LeetCode test
    private static void findWordsHelper2(Character[][] board, Trie dict, int i, int j, int Row, int Column, String str, HashSet<String> set) {
        if (!dict.startsWith(str)) return;

        if (dict.search(str) && !set.contains(str))
            set.add(str);

        char tempChar = board[i][j];
        board[i][j] = '*';

        if (i+1 < Row && board[i+1][j] != '*')
            findWordsHelper2(board, dict, i + 1, j, Row, Column, str + board[i+1][j], set);
        if (i-1 >= 0 && board[i-1][j] != '*')
            findWordsHelper2(board, dict, i - 1, j, Row, Column, str + board[i-1][j], set);
        if (j+1 < Column && board[i][j+1] != '*')
            findWordsHelper2(board, dict, i, j + 1, Row, Column, str + board[i][j+1], set);
        if (j-1 >= 0 && board[i][j-1] != '*')
            findWordsHelper2(board, dict, i, j - 1, Row, Column, str + board[i][j-1], set);

        board[i][j] = tempChar;
    }

//    public String minWindow(String S, String T) {
//        if (S == null) return null;
//        else if (T == null) return "";
//        
////        HashSet sSet = new HashSet();
//        HashSet tSet = new HashSet();
//        for (char c : T.toCharArray())
//            if (!tSet.contains(c))
//                tSet.add (c);
//        if (S.length() < tSet.size()) return "";
//        
//        int start = 0; 
//        int end = 0;
//        int minLen = Integer.MAX_VALUE;
//        HashSet tempSet = new HashSet();
//        
//        
//        while (b <= e && e < S.length()) {
//            HashSet sub = new HashSet(Arrays.asList(S.substring(b, e + 1).toCharArray()));
//            if (sub.contains(tSet))
//                break;
//            
//            while (!tSet.contains(S.charAt(b))) {
//                b++;
//            }
//            if (b > e)
//                e = b + tSet.size() - 1;
//            while (S.charAt(e) == S.charAt(b))
//                b++;
//            while ((e - b + 1) < tSet.size())
//                e++;
//        }
//        
//        return null;
//    }

    static public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 < len2) return multiply(num2, num1);

        System.out.println("\nStart function multiply()");
        System.out.println("\tnum1 = " + num1 + "; num2 = " + num2);

        if (num2.equals("0")) {
            System.out.println("\tResult = 0");
            return "0";
        }

        LinkedList [] digits = new LinkedList [len2];
        for (int i = 0; i < len2; i++)
            digits[i] = new LinkedList ();
        Integer [] carries = new Integer [len2];
        Arrays.fill(carries, 0);

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = 0; j < len2; j++) {
                Integer d2 = Character.getNumericValue(num2.charAt(j));
                Integer d1 = Character.getNumericValue(num1.charAt(i));

                Integer multi = d1 * d2;
                multi += carries[j];
                digits[j].addFirst(multi%10);
                carries[j] = multi/10;
            }
        }
        Integer maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < len2; i++) {
            if (carries[i] != 0)
                digits[i].addFirst(carries[i]);
            for (int j = 0; j < (len2 - i - 1); j++)
                digits[i].addLast(0);
            if (digits[i].size() > maxLen)
                maxLen = digits[i].size();
        }

        StringBuilder sb = new StringBuilder ();
        Integer digit = 0;
        Integer carry = 0;

        while (maxLen-- > 0) {
            digit = 0;
            for (int i = 0; i < len2; i++) {
                digit += ((digits[i].size() == 0)?0:(Integer)(digits[i].removeLast()));
            }
            digit += carry;
//            if (digit%10 != 0)
            sb.insert (0, digit%10);
            carry = digit/10;
        }
        while (carry > 0) {
//            if (digit%10 != 0)
            sb.insert (0, carry%10);
            carry /= 10;
        }

        String res = sb.toString();
        assert Integer.parseInt(num1) * Integer.parseInt(num2) == Integer.parseInt(res);
        System.out.println("\tResult = " + res);
        return res;
    }

    // TODO
    static public String multiplyStrings(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 <= 0 || len2 <= 0)
            return null;
        if (len1 < len2)
            return multiplyStrings (num2, num1);

        System.out.println("\nStart function multiplyStrings()");
        System.out.println("\tnum1 = " + num1 + "; num2 = " + num2);

        if (num2.equals("0"))
            return "0";
        if (num2.equals("1"))
            return num1;

        String result = multiplyStringsHelper(num1, num2.charAt(0));
        for (int index = 1; index < len2; index++) {
            result = addStrings(result+"0", multiplyStringsHelper(num1, num2.charAt(index)));
        }
        assert Integer.parseInt(num1) * Integer.parseInt(num2) == Integer.parseInt(result);
        System.out.println("\tResult = " + result);
        return result;
    }
    static public String multiplyStringsHelper(String s, Character c) {
        if (s == null || c == null) return null;
        if (c == '0') return "0";
        if (c == '1') return s;

        Integer d = Character.getNumericValue(c);
        StringBuilder sb = new StringBuilder();
        Integer multi = 0;
        Integer carry = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            Integer sd = Character.getNumericValue(s.charAt(i));
            multi = d * sd;
            multi += carry;
            carry = multi/10;
            sb.insert(0, multi%10);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
    static public String addStrings(String s1, String s2) {
        if (s1 == null || s2 == null) return null;

        StringBuilder sb = new StringBuilder();
        // Attention!!! This format is good! Pay attention to carry!
        for (int index1 = s1.length() - 1, index2 = s2.length() - 1, carry = 0;
             index1 >= 0 || index2 >= 0 || carry > 0;
             index1--, index2--) {
            int d1 = (index1 < 0)?0:Character.getNumericValue(s1.charAt(index1));
            int d2 = (index2 < 0)?0:Character.getNumericValue(s2.charAt(index2));
            int sum = d1+d2+carry;
            carry = sum/10;
            sb.insert(0, sum%10);
        }
        return sb.toString();
    }

    /**
     * Given an array of strings, return all groups of strings that are anagrams.
     * Note: All inputs will be in lower-case.
     *
     * http://oj.leetcode.com/problems/anagrams/
     */
    static public ArrayList<String> anagrams(String[] strs) {
        System.out.println("\nStart function anagrams()");
        System.out.println("\tstrs = " + Arrays.asList(strs));
        HashMap<String, Integer> map = new HashMap<> ();
        ArrayList<String> results = new ArrayList<> ();

        for (int i = 0; i < strs.length; i++) {
            char[] tempArr = strs[i].toCharArray();
            Arrays.sort(tempArr);

            if (!map.containsKey(String.valueOf(tempArr))) {
                map.put(String.valueOf(tempArr), i);
            } else {
                if (map.get(String.valueOf(tempArr)) >= 0) {
                    results.add(strs[map.get(String.valueOf(tempArr))]);
                    map.remove(String.valueOf(tempArr));
                    map.put(String.valueOf(tempArr), -1);
                }
                results.add(strs[i]);
            }
        }
        System.out.println("\tresults = " + Arrays.asList(results));
        return results;
    }
    static public ArrayList<String> anagrams2(String[] strs) {
        System.out.println("\nStart function anagrams2()");
        System.out.println("\tstrs = " + Arrays.asList(strs));
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> results = new ArrayList<>();
        
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            
            String tmpStr = String.valueOf(charArr);
            if (!map.containsKey(tmpStr)) {
                ArrayList<String> list = new ArrayList<> ();
                list.add(s);
                map.put(tmpStr, list);
            } else {
                map.get(tmpStr).add(s);
            }
        }

        for (ArrayList<String> list : map.values()) {
            if (list.size() > 1) {
                results.addAll(list);
            }
        }
        System.out.println("\tresults = " + Arrays.asList(results));
        return results;
    }

    /**
     * The count-and-say sequence is the sequence of integers beginning as follows:
     * 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, ...
     *  1 is read off as "one 1" or 11.
     *  11 is read off as "two 1s" or 21.
     *  21 is read off as "one 2, then one 1" or 1211.
     * Given an integer n, generate the nth sequence.
     * Note: The sequence of integers will be represented as a string.
     *
     * http://oj.leetcode.com/problems/count-and-say/
     */
    static public String countAndSay(int n) {
        System.out.println("\nStart function countAndSay()");
        System.out.println("\tn = " + n);
        String str = "1";

        ArrayList<Integer> arr = new ArrayList<> ();
        arr.add(1);
        while (n-- > 1) {
            ArrayList<Integer> temp = (ArrayList<Integer>)arr.clone();
            arr.clear();
            for (int i = 0; i < temp.size(); i++) {
                int count = 0;
                while (i + count < temp.size()) {
                    if (temp.get(i+count) == temp.get(i))
                        count++;
                    else
                        break;
                }
                arr.add(count);
                arr.add(temp.get(i));
                i += (count-1);
            }
        }
        StringBuilder sb = new StringBuilder ();
        for (Integer i : arr)
            sb.append(i);
        System.out.println("\tResult = " + sb.toString());
        return sb.toString();
    }
    static public String countAndSay2(int n) {
        System.out.println("\nStart function countAndSay2()");
        System.out.println("\tn = " + n);
        ArrayList<Integer> ints = countAndSay2Helper(n);
        StringBuilder sb = new StringBuilder();
        for (Integer i : ints) sb.append(i);
        System.out.println("\tResult = " + sb.toString());
        return sb.toString();
    }
    private static ArrayList<Integer> countAndSay2Helper (int n) {
        assert n >= 1;
        ArrayList<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(1);
            return res;
        }
        ArrayList<Integer> lower = countAndSay2Helper(n - 1);
        int len = lower.size();
        int i = 0;
        while (i < len) {
            int curVal = lower.get(i);
            int curCount = 1;
            while (++i < len && lower.get(i) == curVal)
                curCount++;
            res.add(curCount);
            res.add(curVal);
        }
        return res;
    }

    /**
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     * The function prototype should be:
     *      bool isMatch(const char *s, const char *p)
     * Some examples:
     *      isMatch("aa","a") → false
     *      isMatch("aa","aa") → true
     *      isMatch("aaa","aa") → false
     *      isMatch("aa", "*") → true
     *      isMatch("aa", "a*") → true
     *      isMatch("ab", "?*") → true
     *      isMatch("aab", "c*a*b") → false
     *
     * https://leetcode.com/problems/wildcard-matching/
     */
    // DP Problem
    static public boolean isMatch(String s, String p) {
        System.out.println("\nStart function isMatch()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        int rows = s.length();
        int columns = p.length();

        boolean [][] match = new boolean [rows+1][columns+1];
//        Arrays.fill(match, false);
        match[0][0] = true;

        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= columns; ++j) {
                if ((p.charAt(j-1) == s.charAt(i-1)) || (p.charAt(j-1) == '?')) {
                    match[i][j] = match[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    // match[i][j] = match[i-1][j-1];
                    for (int t = 0; t <= i; ++t) {
                        match[i][j] |= match[t][j-1];
                    }
                }
            }
        }
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                System.out.print("\t" + (match[i][j]?"T":"F") + ", ");
            }
            System.out.println();
        }
        System.out.println("\tMatch = " + match[rows][columns]);
        return match[rows][columns];
    }
    // Similar to isMatch(), using rolling array
    static public boolean isMatch2(String s, String p) {
        System.out.println("\nStart function isMatch2()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        int rows = p.length();
        int columns = s.length();

        boolean [][] m = new boolean [2][columns+1];
        m[0][0] = true;
        for (int i = 0; i < rows; i++) {
            Arrays.fill (m[(i+1)%2], false);

            char cp = p.charAt(i);
            boolean cumulated = m[i%2][0];
            for (int j = 0; j < columns; i++) {
                cumulated |= m[i%2][j+1];
                if (cp == s.charAt(j) || cp == '?') {
                    m[(i+1)%2][j+1] = m[(i+1)%2][j];
                } else if (cp == '*') {
                    m[(i+1)%2][j+1] = cumulated;
                }
            }
        }
        System.out.println("\tMatch = " + m[rows%2][columns]);
        return m[rows%2][columns];
    }
    static public boolean isMatch3(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
    
        if(lenP==0) return lenS==0;
        
        int star = -1;
        int ss = 0;
        int si = 0;
        int pi = 0;
        while (si < lenS && pi < lenP) {
            if (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si)) {
                si++;
                pi++;
            } else if (p.charAt(pi) == '*') {
                star = pi++;
                ss = si;
            } else if (star >= 0) {
                pi = star + 1;
                si = ++ss;
            } else {
                return false;
            }
        }
        if (si == lenS) {
            while (pi < lenP && p.charAt(pi) == '*')
                pi++;
            return (pi == lenP);
        } else {
            if (star < 0)
                return false;
            else {
                while (star < lenP) {
                    if (p.charAt(star) != '*' && p.charAt(star) != '?')
                        return false;
                    star++;
                }
                return true;
            }
        }
    }
    // Similar to isMatch_WildCard_Iterative()
    static public boolean isMatch4(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
    
        if(lenP==0) return lenS==0;
        
        int star = -1;
        int ss = 0;
        int si = 0;
        int pi = 0;
        while (si < lenS) {
            if ((pi < lenP) && 
                (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si))) {
                si++;
                pi++;
            } else if ((pi < lenP) && 
                       (p.charAt(pi) == '*')) {
                star = pi++;
                ss = si;
            } else if (star >= 0) {
                pi = star + 1;
                si = ++ss;
            } else {
                return false;
            }
        }

        while (pi < lenP && p.charAt(pi) == '*')
            pi++;
        return (pi == lenP);
    }

    /**
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     * The function prototype should be:
     *      bool isMatch(const char *s, const char *p)
     * Some examples:
     *      isMatch("aa","a") → false
     *      isMatch("aa","aa") → true
     *      isMatch("aaa","aa") → false
     *      isMatch("aa", "*") → true
     *      isMatch("aa", "a*") → true
     *      isMatch("ab", "?*") → true
     *      isMatch("aab", "c*a*b") → false
     *
     * https://leetcode.com/problems/wildcard-matching/
     */
    // Recursive version works, but will be slower than interative version
    public static void isMatch_wildCard_Recursive_Demo (String s, String p) {
        System.out.println("\nStart function isMatch_wildCard_Recursive_Demo()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        System.out.println("\tMatch = " + isMatch_WildCard_Recursive(s, p));
    }
    public static boolean isMatch_WildCard_Recursive (String s, String p) {
        if (s == null) return p == null;
        int lenS = s.length();
        int lenP = p.length();
        int si = 0;
        int pi = 0;
        if (lenP == 0) return lenS == 0;
        if (lenS == 0) {
            while (pi < lenP && p.charAt(pi) == '*') {
                pi++;
            }
            return pi == lenP;
        }
        pi = 0;
        
        while (si < lenS && pi < lenP) {
            if (s.charAt(si) == p.charAt(pi) || p.charAt(si) == '?') {
                si++;
                pi++;
            } else if (p.charAt(pi) != '*') {
                return false;
            } else {
                while (pi < lenP && p.charAt(pi) == '*') {
                    pi++;
                }
                if (pi == lenP) {
                    return true;
                }
                while (si < lenS) {
                    if (isMatch_WildCard_Recursive(s.substring(si), p.substring(pi))) {
                        return true;
                    }
                    si++;
                }
                return false; // Without this line, the code still works, but will be slower
            }
        }
        
        return isMatch_WildCard_Recursive (s.substring(si), p.substring(pi));
    }
    // Iterative version passes Leetcode test
    public static void isMatch_WildCard_Iterative_Demo (String s, String p) {
        System.out.println("\nStart function isMatch_WildCard_Iterative_Demo()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        System.out.println("\tMatch = " + isMatch_WildCard_Iterative(s, p));
    }
    public static boolean isMatch_WildCard_Iterative (String s, String p) {
        if (s == null) return p == null;
        int lenS = s.length();
        int lenP = p.length();
        int si = 0;
        int pi = 0;
        if (lenP == 0) return lenS == 0;
        if (lenS == 0) {
            while (pi < lenP && p.charAt(pi) == '*') {
                pi++;
            }
            return pi == lenP;
        }
        
        pi = 0;
        int pre_s = 0;
        int pre_p = 0;
        boolean hasStar = false;
        
        while (si < lenS) {
            if (pi < lenP && (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')) {
                si++;
                pi++;
            } else if (pi < lenP && p.charAt(pi) == '*') {
                hasStar = true;
                while (pi < lenP && p.charAt(pi) == '*') {
                    pi++;
                }
                if (pi == lenP) {
                    return true;
                }
                pre_s = si;
                pre_p = pi;
            } else if (hasStar) {
                pre_s++;
                si = pre_s;
                pi = pre_p;
            } else {
                return false;
            }
        }
        while (pi < lenP && p.charAt(pi) == '*') {
            pi++;
        }
        return pi == lenP;
    }
    
    /* Regular Expression Matching - Accepted
     * Implement regular expression matching with support for '.' and '*'.
     *     '.' Matches any single character.
     *     '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * The function prototype should be:
     *     bool isMatch(const char *s, const char *p)
     * Some examples:
     *     isMatch("aa","a") → false
     *     isMatch("aa","aa") → true
     *     isMatch("aaa","aa") → false
     *     isMatch("aa", "a*") → true
     *     isMatch("aa", ".*") → true
     *     isMatch("ab", ".*") → true
     *     isMatch("aab", "c*a*b") → true
     *
     * isMatch_RegularExpression() passed LeetCode test
     * However, it may not be right.
     * For instance, it would mark S="aaabc", P="a*a.*" as TRUE;
     *
     * isMatch_RegularExpression2() should be the right solution
     */
    public static void isMatch_RegularExpression_Demo (String s, String p) {
        System.out.println("\nStart function isMatch_RegularExpression_Demo()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        System.out.println("\tMatch = " + isMatch_RegularExpression(s, p));
    }
    public static boolean isMatch_RegularExpression (String s, String p) {
        if (p == null) return s == null;

        int lenP = p.length();
        int lenS = s.length();
        
        if (lenP == 0) return lenS == 0;
        
        if (lenP > 1 && p.charAt(1) == '*') {
            int si = 0;
            while (si < lenS && (p.charAt(0) == s.charAt(si) || p.charAt(0) == '.')) {
                if (isMatch_RegularExpression(s.substring(si), p.substring(2)))
                    return true;
                si++;
            }
            return isMatch_RegularExpression(s.substring(si), p.substring(2));
        } else {
            return (lenS > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
                   isMatch_RegularExpression(s.substring(1), p.substring(1)));
        }
    }
    /* This version would mark:
     *     S="aaabc", P="a*a.*"   as FALSE;
     *     S="aaabc", P="a*a.*c*" as TRUE;
     */
    public static void isMatch_RegularExpression_Demo2 (String s, String p) {
        System.out.println("\nStart function isMatch_RegularExpression_Demo2()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        System.out.println("\tMatch = " + isMatch_RegularExpression2(s, p));
    }
    public static boolean isMatch_RegularExpression2 (String s, String p) {
        if (p == null) return s == null;

        int lenP = p.length();
        int lenS = s.length();

        if (lenP == 0)
            return lenS == 0;

        if (1 < lenP && p.charAt(1) == '*') {
            char sc = s.charAt(0);

            if (p.charAt(0) == sc || p.charAt(0) == '.') {
                int next = 1;
                for (; next < lenS; next++) {
                    if (s.charAt(next) != sc) {
                        break;
                    }
                }
                for (int i = 0; i <= next; i++) {
                    if (isMatch_RegularExpression2(s.substring(i), p.substring(2)))
                        return true;
                }
                return false;
            } else {
                // Skip: e.g.  s(ab) p(e*ab)
                return isMatch_RegularExpression2(s.substring(0), p.substring(2));
            }
        } else {
            return (lenS > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
                   isMatch_RegularExpression2(s.substring(1), p.substring(1)));
        }
    }
    // This version is identical to isMatch_RegularExpression2, but more readable
    public static void isMatch_RegularExpression_Demo3 (String s, String p) {
        System.out.println("\nStart function isMatch_RegularExpression_Demo3()");
        System.out.println("\ts = " + s);
        System.out.println("\tp = " + p);
        System.out.println("\tMatch = " + isMatch_RegularExpression3(s, p));
    }
    public static boolean isMatch_RegularExpression3 (String s, String p) {
        if (p == null) return s == null;

        int lenP = p.length();
        int lenS = s.length();

        if (lenP == 0) return lenS == 0;

        if (lenP > 1 && p.charAt(1) == '*') {
            char sc = s.charAt(0);
            if (p.charAt(0) == sc || p.charAt(0) == '.') {
                int si = 0;
                while (si < lenS && s.charAt(si) == sc) {
                    if (isMatch_RegularExpression3(s.substring(si), p.substring(2)))
                        return true;
                    si++;
                }
                return isMatch_RegularExpression(s.substring(si), p.substring(2));
            } else {
                // Skip: e.g.  s(ab) p(e*ab)
                return isMatch_RegularExpression3(s, p.substring(2));
            }
        } else {
            return (lenS > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') &&
                    isMatch_RegularExpression3(s.substring(1), p.substring(1)));
        }
    }

    /**
     * Palindrome Partitioning II
     *
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     *
     * Return the minimum cuts needed for a palindrome partitioning of s.
     *
     * For example, given s = "aab",
     * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     *
     * https://leetcode.com/problems/palindrome-partitioning-ii/
     */
    public static int minCut(String s) {
        System.out.println("\nStart function minCut()");
        System.out.println("\ts = " + s);
        if (s == null || s.length() == 0) {
            return 0;
        }

        int minCut = minCutHelper (s, 0, s.length()-1);
        System.out.println("\tMinCut = " + minCut);
        return minCut;
    }
    private static int minCutHelper(String s, int b, int e) {
        if (s == null || b < 0 || e >= s.length() || b >= e)
            return 0;
        String sub = s.substring(b, e+1);
        String subReverse = new StringBuffer(sub).reverse().toString();
        if (sub.equals(subReverse))
            return 0;
        
        Integer minCut = Integer.MAX_VALUE;
        for (int i = b+1; i <= e; i++) {
            int cut1 = minCutHelper(s, b, i-1);
            int cut2 = minCutHelper(s, i, e);
            int cut = cut1 + cut2 + 1;
            if (minCut > cut)
                minCut = cut;
        }
        return minCut;
    }
    public static int minCut2(String s) {
        System.out.println("\nStart function minCut2()");
        System.out.println("\ts = " + s);
        if (s == null || s.isEmpty()) return 0;

        int len = s.length();
        Boolean[][] DP = new Boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(DP[i], false);
        }
        Integer[] cut = new Integer[len+1];
        cut[len] = -1;
        for (int i = len - 1; i >= 0; i--) {
            cut[i] = cut[i+1] + 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || DP[i+1][j-1]) {
                        DP[i][j] = true;
                        cut[i] = Math.min(cut[i], cut[j+1]+1);
                    }
                }
            }
        }
        printTwoDimentinalArray(DP, "\tDP array:");
        printArray(cut, "\tCut array:");
        return cut[0];
    }
    public static int minCut3(String s) {
        System.out.println("\nStart function minCut3()");
        System.out.println("\ts = " + s);
        if (s == null || s.length() == 0) {
            return 0;
        }

        //ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> res = new PriorityQueue<>();
        minCutDFS (s, 0, -1, res);
        System.out.println("\tMinCut = " + res.peek());
        return res.peek();
    }
    public static void minCutDFS(String s, int start, int count, PriorityQueue<Integer> res) {
        if (s.length() == start) {
            res.add(count);
        } else {
            for (int cut = start + 1; cut <= s.length(); cut++) {
                String cur = s.substring(start, cut);
                if (isPalindrome(cur)) {
                    minCutDFS (s, cut, count + 1, res);
                }
            }
        }
    }

    /* Given a string containing only digits, restore it by returning all possible valid IP address combinations.
     * For example:
     * Given "25525511135",
     * 
     * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
     *
     * DFS
     *
     * https://leetcode.com/problems/restore-ip-addresses/
     */
    public static List<String> restoreIpAddresses(String s) {
        System.out.println("\nStart function restoreIpAddresses()");
        System.out.println("\ts = " + s);
        ArrayList<String> results = new ArrayList<> ();
        if (s == null || s.length() == 0) {
            return results;
        }
        restoreIpAddressesHelper(s, 0, 1, "", results);
        System.out.println("\tValid IPs: " + results);
        return results;
    }
    private static void restoreIpAddressesHelper (String str, int index, int seg, String cur, ArrayList<String> res) {
        if (index >= str.length()) {
            return;
        }
        if (seg == 4) {
            String sub = str.substring(index);
            if (isValidIPSegment(sub)) {
                res.add(cur + "." + sub);
            }
            return;
        }
        for (int i = 1; i < 4 && (i + index <= str.length()); i++) {
            String sub = str.substring(index, index + i);
            if (isValidIPSegment(sub)) {
                if (seg == 1) {
                    restoreIpAddressesHelper(str, index + i, seg+1, sub, res);
                } else {
                    restoreIpAddressesHelper(str, index + i, seg+1, cur + "." + sub, res);
                }
            }
        }
    }
    private static boolean isValidIPSegment (String ip) {
        if (ip == null || ip.length() > 3 || ip.length() == 0)
            return false;
        if (ip.charAt(0) == '0' && ip.length() > 1)
            return false;
        int num = Integer.parseInt(ip);
        if (num >= 0 && num <= 255)
            return true;
        return false;
    }

    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     * For example,
     *  S = "ADOBECODEBANC"
     *  T = "ABC"
     * Minimum window is "BANC".
     * Note:
     *  If there is no such window in S that covers all characters in T, return the emtpy string "".
     *  If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     *
     *  http://oj.leetcode.com/problems/minimum-window-substring/
     */
    public static String minWindow(String S, String T) {
        System.out.println("\nStart function minWindow()");
        System.out.println("\tS = " + S);
        System.out.println("\tT = " + T);
        if(S == null || T == null || S.length()==0 || T.length()==0)  
            return "";  
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
        for(int i=0;i<T.length();i++) {
            if(map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i))+1);  
            } else
                map.put(T.charAt(i), 1);  
        }  
        int count = 0;  
        int begin = 0;  
        String res = "";  
        int minLen = S.length()+1;  
        for(int end=0; end<S.length(); end++) {
            if(map.containsKey(S.charAt(end))) {
                map.put(S.charAt(end), map.get(S.charAt(end))-1);  
                if(map.get(S.charAt(end))>=0)  
                    count++;
                    
                if(count == T.length()) {
                    while (begin <= end && 
                           (!map.containsKey(S.charAt(begin)) ||
                            (map.containsKey(S.charAt(begin)) && map.get(S.charAt(begin)) < 0))) {
                        if (map.containsKey(S.charAt(begin)) && map.get(S.charAt(begin)) < 0) {
                            map.put(S.charAt(begin), map.get(S.charAt(begin)) + 1);
                        }
                        begin++;
                    }
                    if(minLen>end-begin+1) {
                        res = S.substring(begin,end+1);  
                        minLen = end-begin+1;  
                    }  
                }
            }  
        }
        System.out.println("\tminWin = " + res);
        return res;
    }
    // Similar to minWindow
    public static String minWindow2(String S, String T) {
        System.out.println("\nStart function minWindow2()");
        System.out.println("\tS = " + S);
        System.out.println("\tT = " + T);
        if (S == null || T == null || S.length() == 0 || T.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : T.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int lenS = S.length();
        int lenT = T.length();
        int count = 0;
        int minLen = lenS;
        String res = "";
        for (int end = 0, start = 0; end < lenS; end++) {
            Character newE = S.charAt(end);
            if (map.containsKey(newE)) {
                if (map.get(newE) > 0) {
                    count++;
                }
                map.put(newE, map.get(newE) - 1);
            }
            while (count == lenT && start < end) {
                Character newS = S.charAt(start);
                if (map.containsKey(newS) && map.get(newS) == 0)
                    break;
                if (map.containsKey(newS) && map.get(newS) < 0) {
                    map.put(newS, map.get(newS) + 1);
                }
                start++;
            }
            if (count == lenT && end - start + 1 < minLen) {
                minLen = end - start + 1;
                res = S.substring(start, end + 1);
            }
        }

        System.out.println("\tminWin = " + res);
        return res;
    }

    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
     * For example, given:
     *   s: "barfoothefoobarman"
     *   words: ["foo", "bar"]
     * You should return the indices: [0,9].
     * (order does not matter).
     *
     * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
     */
    // This version cannot handle duplicated word case
    public List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<> ();
        if (S == null || L == null || L.length <= 0)
            return res;
        int len = S.length();
        int minLen = L[0].length() * L.length;
        
        int startIndex = 0;
        while (startIndex < len - minLen) {
            String sub = S.substring(startIndex, startIndex+minLen);
            boolean valid = true;
            for (String str : L) {
                if (sub.indexOf(str) < 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res.add(startIndex);
                startIndex += minLen;
            } else {
                startIndex++;
            }
        }

        return res;
    }
    public static List<Integer> findSubstring2(String S, String[] L) {
        System.out.println("\nStart function findSubstring2()");
        System.out.println("\tS = " + S);
        System.out.println("\tT = " + Arrays.asList(L));
        ArrayList<Integer> res = new ArrayList<> ();
        if (S == null || L.length <= 0) return res;
        int len = S.length();
        int subLen = L[0].length();
        int minLen = subLen * L.length;
        
        HashMap<String, Integer> map = new HashMap<> ();
        for (String str : L) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else {
                map.put(str, 1);
            }
        }
        
        int startIndex = 0;
        while (startIndex < len - minLen) {
            boolean valid = true;
            HashMap<String, Integer> tempMap = new HashMap<> ();
            String sub = S.substring(startIndex, startIndex+minLen);
            for (int i = 0; i < L.length; i++) {
                String tempSub = sub.substring(i*subLen, (i+1)*subLen);
                
                if (!sub.contains(tempSub)) {
                    valid = false;
                    break;
                }
                
                if (tempMap.containsKey(tempSub)) {
                    tempMap.put(tempSub, tempMap.get(tempSub)+1);
                    if (tempMap.get(tempSub) > map.get(tempSub)) {
                        valid = false;
                        break;
                    }
                } else {
                    tempMap.put(tempSub, 1);
                }
            }
            
            if (valid && tempMap.equals(map)) {
                res.add(startIndex);
                startIndex += minLen;
            } else {
                startIndex++;
            }
        }
        System.out.println("\tResult = " + Arrays.asList(res));
        for (Integer i : res) {
            System.out.println("\tsub = " + S.substring(i, i + L.length * subLen));
        }
        return res;
    }

    public static void numDecodingDemo(String s) {
        System.out.println("\nStart function numDecodingDemo()");
        System.out.println("\tStr = " + s);
        System.out.println("\tNumber of decoding: " + numDecodings(s));
    }
    public static int numDecodings(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len <= 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (len == 1) return 1;

        return numDecodingsHelper(s);
    }
    private static int numDecodingsHelper(String s) {
        int len = s.length();
        if (len <= 0) return 1;
        if (s.charAt(0) == '0') return 0;
        if (len == 1) return 1;

        int subInt = Integer.parseInt(s.substring(0,2));
        if (subInt >= 10 && subInt <= 26) {
            return numDecodingsHelper(s.substring(1)) + numDecodingsHelper(s.substring(2));
        } else
            return numDecodingsHelper(s.substring(1));
    }
    public static void numDecodingDemo2(String s) {
        System.out.println("\nStart function numDecodingDemo2()");
        System.out.println("\tStr = " + s);
        System.out.println("\tNumber of decoding: " + numDecodings2(s));
    }
    public static int numDecodings2(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c))
                return 0;
        }

        int [] N = new int [len+1];
        N[0] = 1;
        N[1] = 1;
        for (int i = 2; i <= len; i++) {
            N[i] = 0;
            if (s.charAt(i-1) != '0') {
                N[i] += N[i-1];
            }
            int subInt = Integer.parseInt(s.substring(i-2,i));
            if (subInt >= 10 && subInt <= 26) {
                N[i] += N[i-2];
            }
        }
        return N[len];
    }

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     *      P   A   H   N
     *      A P L S I I G
     *      Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     *      string convert(string text, int nRows);
     * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     *
     * https://leetcode.com/problems/zigzag-conversion/
     */
    public static String zigZagConvert(String s, int nRows) {
        System.out.println("\nStart function zigZagConvert()");
        System.out.println("\tS = " + s);
        System.out.println("\tRows = " + nRows);
        if (s == null) return null;
        int len = s.length();
        if (len <= 1) return s;
        if (nRows <= 1) return s;
    
        //StringBuilder[] sbs = new StringBuilder[nRows];
        ArrayList<ArrayList<Character>> sbs = new ArrayList<> ();
        for (int i = 0; i < nRows; i++)
            sbs.add(new ArrayList<Character>());
        //Arrays.fill(sbs, new StringBuilder());
        int mod = nRows*2-2;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int index = i%mod;
            if (index >= nRows) {
                index = mod - index;
            }
            sbs.get(index).add(c);
        }
        StringBuilder res = new StringBuilder();
        for (ArrayList<Character> arr : sbs) {
            for (Character c : arr)
                res.append(c);
        }
        System.out.println("\tresult = " + res.toString());
        return res.toString();
    }
    
    /* Word Ladder
     * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
     *         1. Only one letter can be changed at a time
     *         2. Each intermediate word must exist in the dictionary
     * For example,
     *  Given:
     *      start = "hit"
     *      end = "cog"
     *      dict = ["hot","dot","dog","lot","log"]
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Note:
     *         • Return 0 if there is no such transformation sequence.
     *         • All words have the same length.
     *         • All words contain only lowercase alphabetic characters.
     *
     * https://leetcode.com/problems/word-ladder/
     */
    /* DFS - Timeout
     * Use DiffByOne. Does not have minLen for optimizing.
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
        System.out.println("\nStart function ladderLength()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        if (start == null || end == null || !dict.contains(start) || !dict.contains(end))
            return 0;
        HashSet<String> used = new HashSet<String> ();
        ArrayList<String> list = new ArrayList<> ();
        list.add(start);
        used.add(start);
        ArrayList<ArrayList<String>> res = new ArrayList<> ();
        
        ladderLengthDFS(end, (HashSet<String>)dict, used, list, res);
        int min = dict.size();
        for (ArrayList<String> arr : res) {
            System.out.println("\t" + arr);
            min = Math.min(min, arr.size());
        }
        System.out.println("\tmin = " + min);
        return min;
    }
    public static void ladderLengthDFS(String end, HashSet<String> dict, HashSet<String> used, ArrayList<String> list, ArrayList<ArrayList<String>> res) {
        for (String s : dict) {
            if (used.contains(s))
                continue;
                
            String last = list.get(list.size()-1);
            if (DiffByOne(last, s)) {
                list.add(s);
                if (s == null ? end == null : s.equals(end)) {
                    res.add((ArrayList<String>)list.clone());
                    list.remove(list.size()-1);
                    return;
                } else {
                    used.add(s);
                    ladderLengthDFS(end, dict, used, list, res);
                    used.remove(s);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    /* DFS - Timeout
     * Use DiffByOne()
     */
    public static int ladderLength2(String start, String end, Set<String> dict) {
        System.out.println("\nStart function ladderLength2()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return 0;
        HashSet<String> used = new HashSet<> ();
        LinkedList<String> list = new LinkedList<> ();
        list.add(start);
        used.add(start);

        LinkedList<String> shortestPath = ladderLengthDFS_2(end, (HashSet<String>)dict, used, list, Integer.MAX_VALUE);
        System.out.println("\tShortest ladder: " + shortestPath);
        System.out.println("\tmin = " + shortestPath.size());
        return shortestPath.size();
    }
    public static LinkedList<String> ladderLengthDFS_2(String end, HashSet<String> dict, HashSet<String> used, LinkedList<String> list, Integer minLen) {
        LinkedList<String> shortest = null;
        
        if (list.size() < minLen) {
            for (String s : dict) {
                if (used.contains(s)) {
                    continue;
                }
                String last = list.get(list.size()-1);
                if (DiffByOne(last, s)) {
                    list.add(s);
                    if (s == null ? end == null : s.equals(end)) {
                        shortest = (LinkedList<String>)list.clone();
                        minLen = Math.min(minLen, shortest.size());
                    } else {
                        used.add(s);
                        LinkedList<String> temp = ladderLengthDFS_2(end, dict, used, list, minLen);
                        if (temp != null) {
                            if ((shortest != null && shortest.size() > temp.size()) || 
                                shortest == null) {
                                shortest = (LinkedList<String>)temp.clone();
                                minLen = temp.size();
                            }
                        } 
                        used.remove(s);
                    }
                    list.remove(list.size()-1);
                }
            }
        }
        
        return shortest;
    }
    /* DFS
     * Similar to ladderLength2, but do not use DiffByOne()
     */
    public static List<String> ladderLength3(String start, String end, Set<String> dict) {
        System.out.println("\nStart function ladderLength3()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return null;
        HashSet<String> used = new HashSet<> ();
        LinkedList<String> tmpList = new LinkedList<> ();
        tmpList.add(start);
        used.add(start);
        
        LinkedList<String> res = ladderLengthDFS_3(end, dict, used, tmpList, Integer.MAX_VALUE);
        System.out.println("Shortest ladder: " + res);
        System.out.println("\tmin = " + res.size());
        return res;
    }
    private static LinkedList<String> ladderLengthDFS_3(String end, Set<String> dict, 
                                                      HashSet<String> used, LinkedList<String> list, Integer minLen) {
        LinkedList<String> shortest = null;
        
        if (list.size() < minLen) {
            String last = list.getLast();
            int wLen = last.length();

            for (int i = 0; i < wLen; i++) {
                char [] arr = last.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != arr[i]) {
                        arr[i] = c;
                        String tempWord = new String(arr);
                        if (dict.contains(tempWord) && !used.contains(tempWord)) {
                            list.add(tempWord);
                            if (tempWord.equals(end)) {
                                shortest = (LinkedList<String>)list.clone();
                                minLen = Math.min(minLen, shortest.size());
                            } else {
                                used.add(tempWord);
                                LinkedList<String> tmpRes = ladderLengthDFS_3(end, dict, used, list, minLen);
                                if (tmpRes != null && 
                                    (shortest == null || shortest.size() > tmpRes.size())) {
                                    shortest = (LinkedList<String>)tmpRes.clone();
                                    minLen = tmpRes.size();
                                }
                                used.remove(tempWord);
                            }
                            list.removeLast();
                        }
                    }
                }
            }
        }
        
        return shortest;
    }
    /* BFS - Optimal version
     * 
     */
    public static int ladderLength4 (String start, String end, HashSet<String> dict) {
        System.out.println("\nStart function ladderLength4()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        if (dict.isEmpty()) return 0;
        dict.add(start);
        dict.add(end);
        
        Queue<String> Q = new LinkedList<> ();
        Q.add(start);
        int len = 0;
        
        while (!Q.isEmpty()) {
            len++;
            int size = Q.size();
            while (size-- > 0) {
                String word = Q.poll();
                if (word == null ? end == null : word.equals(end)) {
                    System.out.println("\tmin = " + len);
                    return len;
                }
                
                int wLen = word.length();
                
                for (int i = 0; i < wLen; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, c);
                        String tempWord = sb.toString();
                        if (dict.contains(tempWord)) {
                            Q.add(tempWord);
                            dict.remove(tempWord);
                        }
                    }
                }
            }
        }
        System.out.println("\tmin = 0");
        return 0;
    }
    
    /* Word Ladder II
     * 
     * Total Accepted: 9371 Total Submissions: 83858My Submissions
     * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
     * 1. Only one letter can be changed at a time
     * 2. Each intermediate word must exist in the dictionary
     * For example,
     *  Given:
     *      start = "hit"
     *      end = "cog"
     *      dict = ["hot","dot","dog","lot","log"]
     * Return
     *   [
     *     ["hit","hot","dot","dog","cog"],
     *     ["hit","hot","lot","log","cog"]
     *   ]
     * Note:
     *      • All words have the same length.
     *      • All words contain only lowercase alphabetic characters.
     *
     * https://leetcode.com/problems/word-ladder-ii/
     */
    /* DFS - Timeout
     * Will return all possible ladders, but one the shortest ones.
     */
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        System.out.println("\nStart function findLadders()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        ArrayList<List<String>> results = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return results;
        dict.add(start);
        dict.add(end);
        HashSet<String> used = new HashSet<> ();
        LinkedList<String> tmpList = new LinkedList<> ();
        tmpList.add(start);
        used.add(start);

        findLaddersDFS(end, dict, used, tmpList, results);
        for (List<String> l : results)
            System.out.println("\t" + l);
        return results;
    }
    private static void findLaddersDFS(String end, Set<String> dict, 
                                                    HashSet<String> used, LinkedList<String> list, 
                                                    ArrayList<List<String>> res) {
        for (String s : dict) {
            if (!used.contains(s)) {
                String last = list.get(list.size()-1);
                if (DiffByOne(last, s)) {
                    list.add(s);
                    if (s.equals(end)) {
                        res.add((LinkedList<String>)list.clone());
                    } else {
                        used.add(s);
                        findLaddersDFS(end, dict, used, list, res);
                        used.remove(s);
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
    }
    /* DFS - Timeout
     * Similar to findLadders, but does not use DiffByOne. 
     */
    public static List<List<String>> findLadders1(String start, String end, Set<String> dict) {
        System.out.println("\nStart function findLadders1()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        ArrayList<List<String>> results = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return results;
        dict.add(start);
        dict.add(end);
        HashSet<String> used = new HashSet<> ();
        LinkedList<String> tmpList = new LinkedList<> ();
        tmpList.add(start);
        used.add(start);

        findLaddersDFS1(end, dict, used, tmpList, results);
        for (List<String> list : results)
            System.out.println("\t" + list);
        return results;
    }
    private static void findLaddersDFS1(String end, Set<String> dict, 
                                                    HashSet<String> used, LinkedList<String> list, 
                                                    ArrayList<List<String>> res) {
        String last = list.getLast();
        int wLen = last.length();
        
        for (int i = 0; i < wLen; i++) {
            char [] arr = last.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != arr[i]) {
                    arr[i] = c;
                    String tempWord = new String(arr);
                    if (dict.contains(tempWord) && !used.contains(tempWord)) {
                        list.add(tempWord);
                        if (tempWord.equals(end)) {
                            res.add((LinkedList<String>)list.clone());
                        } else {
                            used.add(tempWord);
                            findLaddersDFS1(end, dict, used, list, res);
                            used.remove(tempWord);
                        }
                    }
                }
            }
        }
    }
    /* BFS - Timeout
     * Does not use HashMap lowestLevel as in findLadders3
     */
    public static List<List<String>> findLadders2(String start, String end, Set<String> dict) {
        System.out.println("\nStart function findLadders2()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        ArrayList<List<String>> results = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return results;
        if (dict.isEmpty()) return results;
        dict.add(start);
        dict.add(end);

        Queue<List<String>> Q = new LinkedList<> ();
        Queue<Set<String>> Q2 = new LinkedList<> ();
        ArrayList<String> list = new ArrayList<> ();
        list.add(start);
        Q.add((ArrayList<String>)list.clone());
        HashSet<String> set = new HashSet<> ();
        set.add(start);
        Q2.add((HashSet<String>)set.clone());
        
        Integer minLen = Integer.MAX_VALUE;
        while (!Q.isEmpty()) {
            int size = Q.size();
            if (results.size() > 0) {
                for (List<String> l : results)
                    System.out.println("\t" + l);
                return results;
            }
            while (size > 0) {
                ArrayList<String> tempList = (ArrayList<String>)Q.poll();
                HashSet<String> tempSet = (HashSet<String>)Q2.poll();

                String word = tempList.get(tempList.size()-1);
                
                if (word.equals(end)) {
                    results.add((ArrayList<String>)tempList.clone());
                    size--;
                    continue;
                }
                
                int wLen = word.length();
                
                for (int i = 0; i < wLen; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) {
                            continue;
                        }
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, c);
                        String tempWord = sb.toString();
                        if (!tempSet.contains(tempWord) && dict.contains(tempWord)) {
                            tempList.add(tempWord);
                            tempSet.add(tempWord);
                            Q.add((ArrayList<String>)tempList.clone());
                            Q2.add((HashSet<String>)tempSet.clone());
                            tempList.remove(tempList.size()-1);
                            tempSet.remove(tempWord);
                        }
                    }
                }
                size--;
            }
        }
        for (List<String> l : results)
            System.out.println("\t" + l);
        return results;
    }
    /* BFS - Optimal solution
     * HashMap lowestLevel makes sure that: when handling one level, does not consider the words
     * in uppper level anymore, which will improve the performance a lot!
     */
    public static List<List<String>> findLadders3(String start, String end, Set<String> dict) {
        System.out.println("\nStart function findLadders3()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        ArrayList<List<String>> results = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return results;
        if (dict.isEmpty()) return results;
        dict.add(start);
        dict.add(end);

        Queue<LinkedList<String>> Q = new LinkedList<> ();
        LinkedList<String> list = new LinkedList<> ();
        list.add(start);
        Q.add(list);

        Integer level = 1;
        HashMap<String, Integer> lowestLevel = new HashMap<>();
        lowestLevel.put(start, level);
        
        while (!Q.isEmpty()) {
            if (results.size() > 0) {
                for (List<String> l : results)
                    System.out.println("\t" + l);
                return results;
            }
            level++;
            
            int size = Q.size();
            
            while (size-- > 0) {
                LinkedList<String> tempList = Q.poll();
                
                String word = tempList.getLast();
                
                if (word.equals(end)) {
                    results.add(tempList);
                    // size--;
                    continue;
                }
                
                int wLen = word.length();
                
                for (int i = 0; i < wLen; i++) {
                    char originalChar = word.charAt(i);
                    char [] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != originalChar) {
                            arr[i] = c;
                            String tempWord = new String(arr);
                            if (dict.contains(tempWord) && 
                                (!lowestLevel.containsKey(tempWord) || lowestLevel.get(tempWord) >= level)) {
                                lowestLevel.put(tempWord, level);
                                tempList.add(tempWord);
                                Q.add((LinkedList<String>)tempList.clone());
                                tempList.removeLast();
                            }
                        }
                    }
                }
            }
        }
        for (List<String> l : results)
            System.out.println("\t" + l);
        return results;
    }
    public static List<List<String>> findLadders4(String start, String end, Set<String> dict) {
        System.out.println("\nStart function findLadders4()");
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        System.out.println("\tdict = " + dict);
        ArrayList<List<String>> results = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.size() <= 0) 
            return results;
        if (dict.isEmpty()) return results;
        dict.add(start);
        dict.add(end);

        Queue<String> Q = new LinkedList<> ();
        Q.add(start);
        
        HashMap<String, List<List<String>>> paths = new HashMap<> ();
        LinkedList<String> list = new LinkedList<> ();
        list.add(start);
        LinkedList<List<String>> lists = new LinkedList<>();
        lists.add(list);
        paths.put(start, lists);
        
        Integer level = 1;
        HashMap<String, Integer> lowestLevel = new HashMap<>();
        lowestLevel.put(start, level);
        
        while (!Q.isEmpty()) {
            if (paths.containsKey(end)) {
                for (List<String> l : paths.get(end))
                    System.out.println("\t" + l);
                return paths.get(end);
            }
            level++;
            
            int size = Q.size();
            
            while (size > 0) {
                String word = (String)Q.poll();
                int wLen = word.length();
                
                LinkedList<List<String>> tempLists = (LinkedList<List<String>>)paths.get(word);
                
                for (int i = 0; i < wLen; i++) {
                    char [] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(i)) {
                            continue;
                        }
                        arr[i] = c;
                        String tempWord = new String(arr);
                        if ((!lowestLevel.containsKey(tempWord) || lowestLevel.get(tempWord) >= level) && 
                            dict.contains(tempWord)) {
                            lowestLevel.put(tempWord, level);
                            Q.add(tempWord);

                            LinkedList<List<String>> newLists = new LinkedList<> ();
                            for (List<String> tempList : tempLists) {
                                LinkedList<String> newList = new LinkedList<>(tempList);
                                newList.add(tempWord);
                                newLists.add(newList);
                            }
                            if (!paths.containsKey(tempWord)) {
                                paths.put(tempWord, new LinkedList<List<String>> ());
                            }
                            paths.get(tempWord).addAll(newLists);
                        }
                    }
                }
                size--;
            }
        }
        for (List<String> l : results)
            System.out.println("\t" + l);
        return results;
    }
    
    private static boolean DiffByOne(String s1, String s2) {
        int len = s1.length();
        if (s2.length() != len) return false;
        
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }
        return (diff == 1);
    }
        
    /*    
     * Simplify Path
     *  
     * Given an absolute path for a file (Unix-style), simplify it.
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * click to show corner cases.
     * Corner Cases:
     *     • Did you consider the case where path = "/../"?
     * In this case, you should return "/".
     *     • Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
     * In this case, you should ignore redundant slashes and return "/home/foo".
     */
    public static String simplifyPath(String path) {
        System.out.println("\nStart function simplifyPath()");
        System.out.println("\tpath = " + path);
        assert path != null;
        
        String []folder = path.split("/");
        Stack S = new Stack();
        
        for (String str : folder) {
            if (!str.isEmpty()) {
                switch (str) {
                    case ".":
                        continue;
                    case "..":
                        if (!S.isEmpty()) {
                            S.pop();
                        }
                        break;
                    default:
                        S.push(str);
                        break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!S.isEmpty()) {
            sb.insert(0, (String)S.pop()).insert(0, "/");
        }
        if (sb.length() == 0)
            sb.append("/");
        System.out.println("\tSimplified path = " + sb.toString());
        return sb.toString();
    }
    public static String simplifyPath2(String path) {
        System.out.println("\nStart function simplifyPath2()");
        System.out.println("\tpath = " + path);
        assert path != null;

        String[] folder = path.split("/");
        LinkedList<String> list = new LinkedList<>();

        for (String s : folder) {
            if (!s.isEmpty()) {
                switch (s) {
                    case ".":
                        break;
                    case "..":
                        if (!list.isEmpty())
                            list.removeLast();
                        break;
                    default:
                        list.add(s);
                        break;
                }
            }
        }

        String simplified = path;
        if (list.isEmpty()) {
            simplified = "/";
        } else {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append("/").append(s);
            }
            simplified = sb.toString();
        }
        System.out.println("\tSimplified path = " + simplified);
        return simplified;
    }

    /*
     * Reverse Words in a String - Accepted
     * 
     * Given an input string, reverse the string word by word. 
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the". 
     * 
     * Clarification: 
     *   What constitutes a word?
     *     A sequence of non-space characters constitutes a word.
     *   Could the input string contain leading or trailing spaces?
     *     Yes. However, your reversed string should not contain leading or trailing spaces.
     *   How about multiple spaces between two words?
     *     Reduce them to a single space in the reversed string.
     */
    public static String reverseWords(String s) {
        System.out.println("\nStart function reverseWords()");
        System.out.println("\ts = " + s);
        assert s != null;
        
        String []word = s.split(" ");
        Stack S = new Stack();
        
        for (String str : word) {
            if (!str.isEmpty()) {
                S.push(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!S.isEmpty()) {
            sb.append(S.pop()).append(" ");
        }
        System.out.println("\tresult = " + sb.deleteCharAt(sb.length() - 1).toString());
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    
    public static String longestCommonSubstring(String S, String T) {
        System.out.println("\nStart function longestCommonSubstring()");
        System.out.println("\tS = " + S);
        System.out.println("\tT = " + T);
        if (S == null || T == null) return null;
        int lenS = S.length(), lenT = T.length();
        if (lenS == 0 || lenT == 0) return "";
        
        int maxL = 0;
        int start = 0, end = 0;
        Integer [][] DP = new Integer [2][lenT + 1];
        Arrays.fill(DP[0], 0);
        System.out.println("\t" + Arrays.asList(DP[0]));
        for (int i = 1; i <= lenS; i++) {
            Arrays.fill(DP[i%2], 0);
            for (int j = 1; j <= lenT; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    DP[i%2][j] = DP[(i-1)%2][j-1] + 1;
                    if (DP[i%2][j] > maxL) {
                        maxL = DP[i%2][j];
                        end = j-1;
                        start = end - DP[i%2][j] + 1;
                    }
                }
            }
            System.out.println("\t" + Arrays.asList(DP[i%2]));
        }
        System.out.println("\tResult = " + T.substring(start, end+1));
        return T.substring(start, end+1);
    }

    /**
     * Given a string "       This  is a teapot plate   " and a Width, say 4. The output would be:
     *      "       "
     *      "This  "
     *      "is a "
     *      "teap"
     *      "ot "
     *      "plat"
     *      "e   "
     */
    public static List<String> textJustification (String str, int W) {
        System.out.println("\nStart function textJustification()");
        System.out.println("\tstr = \"" + str + "\"");
        System.out.println("\tW = " + W);
        List<String> res = new ArrayList<> ();
        if (str == null) return res;
        int len = str.length();
        if (len == 0) return res;
        char[] chars = str.toCharArray();
        
        int cur = 0;
        int start = 0;
        int nextStart = 0;
        
        while (cur < len ) {
            if (chars[cur] == ' ') {
                while (cur < len && chars[cur] == ' ') {
                    cur++;
                }
                if (cur - start >= W) {
                    res.add(str.substring(start, cur));
                    start = cur;
                    nextStart = cur;
                } else {
                    nextStart = cur;
                }
            } else {
                if (cur - start + 1 > W) {
                    if (nextStart == start) {
                        res.add(str.substring(start, cur));
                        start = cur;
                        nextStart = cur;
                    } else {
                        res.add(str.substring(start, nextStart));
                        start = nextStart;
                    }
                }
                cur++;
            }
        }
        if (start < len) {
            res.add(str.substring(start));
        }
        for (String s : res)
            System.out.println("\t\t\"" + s + "\"");
        return res;
    }

    /**
     * Given an array of words and a length L, format the text such that each line has exactly L characters
     * and is fully (left and right) justified.
     *
     * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
     * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
     *
     * Extra spaces between words should be distributed as evenly as possible.
     * If the number of spaces on a line do not divide evenly between words,
     * the empty slots on the left will be assigned more spaces than the slots on the right.
     *
     * For the last line of text, it should be left justified and no extra space is inserted between words.
     *
     * For example,
     *  words: ["This", "is", "an", "example", "of", "text", "justification."]
     *  L: 16.
     *
     * Return the formatted lines as:
     * [
     *  "This    is    an",
     *  "example  of text",
     *  "justification.  "
     * ]
     * Note: Each word is guaranteed not to exceed L in length.
     *
     * https://leetcode.com/problems/text-justification/
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        System.out.println("\nStart function fullJustify()");
        System.out.println("\twords = " + Arrays.asList(words));
        System.out.println("\tW = " + maxWidth);
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

        for (String s : res)
            System.out.println("\t\"" + s + "\"");
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

    // Optimal solution
    public static List<String> repeatedDNASubstring (String dna, int L) {
        System.out.println("\nStart function repeatedDNASubstring()");
        System.out.println("\tdna = " + dna);
        System.out.println("\tL = " + L);
        List<String> res = new ArrayList<> ();
        if (dna == null) return res;
        int len = dna.length();
        if (L >= len) return res;

        HashMap<Character, Integer> dnaToInt = new HashMap<> ();
        dnaToInt.put('A', 1);
        dnaToInt.put('T', 2);
        dnaToInt.put('C', 3);
        dnaToInt.put('G', 4);

        HashMap<Integer, Character> intToDna = new HashMap<> ();
        intToDna.put(1, 'A');
        intToDna.put(2, 'T');
        intToDna.put(3, 'C');
        intToDna.put(4, 'G');

        HashSet<Integer> exist = new HashSet<> ();

        int sum = 0;
        char [] chars = dna.toCharArray();
        for (int i = 0; i < L; i++) {
            sum *= 5;
            sum += dnaToInt.get(chars[i]);
        }
        exist.add(sum);
        int mod = (int) Math.pow(5, L-1);
        for (int i = L; i < len; i++) {
            sum %= mod;
            sum *= 5;
            sum += dnaToInt.get(chars[i]);
            if (!exist.contains(sum)) {
                exist.add(sum);
            } else {
                res.add(convertIntToDna(sum, intToDna));
            }
        }

        System.out.println("\tResult: " + res);
        return res;
    }
    private static String convertIntToDna(Integer sum, HashMap<Integer, Character> intToDna) {
        StringBuilder sb = new StringBuilder();
        while (sum > 0) {
            int digit = sum % 5;
            sum /= 5;
            sb.insert(0, intToDna.get(digit));
        }
        return sb.toString();
    }
    public static List<String> repeatedDNASubstring2 (String dna, int L) {
        System.out.println("\nStart function repeatedDNASubstring()");
        System.out.println("\tdna = " + dna);
        System.out.println("\tL = " + L);
        List<String> res = new ArrayList<> ();
        if (dna == null) return res;
        int len = dna.length();
        if (L >= len) return res;

        HashMap<Character, Integer> dnaToInt = new HashMap<> ();
        dnaToInt.put('A', 0);
        dnaToInt.put('T', 1);
        dnaToInt.put('C', 2);
        dnaToInt.put('G', 3);

        HashMap<Integer, Character> intToDna = new HashMap<> ();
        intToDna.put(0, 'A');
        intToDna.put(1, 'T');
        intToDna.put(2, 'C');
        intToDna.put(3, 'G');

        HashSet<Integer> once = new HashSet<> ();
        HashSet<Integer> dup  = new HashSet<> ();

        int sum = 0;
        char [] chars = dna.toCharArray();
        for (int i = 0; i < L; i++) {
            sum *= 4;
            sum += dnaToInt.get(chars[i]);
        }
        once.add(sum);
        for (int i = L; i < len; i++) {
            int mod = (int) Math.pow(4, L-1);
            sum %= mod;
            sum *= 4;
            sum += dnaToInt.get(chars[i]);
            if (!dup.contains(sum)) {
                if (once.contains(sum)) {
                    once.remove(sum);
                    dup.add(sum);
                } else {
                    once.add(sum);
                }
            }
        }

        for (int n : dup) {
            int mod = (int) Math.pow(4, L-1);
            StringBuilder sb = new StringBuilder();
            while (mod > 0) {
                int digit = n/mod;
                n %= mod;
                sb.append(intToDna.get(digit));
                mod /= 4;
            }
            res.add(sb.toString());
        }
        System.out.println("\tResult: " + res);
        return res;
    }

    /**
     * Compare Version Numbers My Submissions Question
     * Total Accepted: 37667 Total Submissions: 235168 Difficulty: Easy
     * Compare two version numbers version1 and version2.
     * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
     *
     * You may assume that the version strings are non-empty and contain only digits and the . character.
     * The . character does not represent a decimal point and is used to separate number sequences.
     *
     * For instance, 2.5 is not "two and a half" or "half way to version three",
     * it is the fifth second-level revision of the second first-level revision.
     *
     * Here is an example of version numbers ordering:
     *
     *      0.1 < 1.1 < 1.2 < 13.37
     *
     * https://leetcode.com/problems/compare-version-numbers/
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.length() == 0 && version2.length() == 0) return 0;
        if (version1.length() == 0) return -1;
        if (version2.length() == 0) return 1;
        String v1 = version1 + ".0";        // This is the point!
        String v2 = version2 + ".0";

        String[] n1 = v1.split("[.]");
        String[] n2 = v2.split("[.]");

        int len1 = n1.length;
        int len2 = n2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            int d1 = Integer.parseInt(n1[i++]);
            int d2 = Integer.parseInt(n2[j++]);
            if (d1 > d2) return 1;
            if (d1 < d2) return -1;
        }
        if (i == len1 && j == len2) return 0;
        if (i < len1) {
            while (i < len1) {
                if (Integer.parseInt(n1[i++]) > 0) return 1;
            }
            return 0;
        }
        if (j < len2) {
            while (j < len2) {
                if (Integer.parseInt(n1[j++]) > 0) return -1;
            }
            return 0;
        }
        return 0;
    }

    /**
     * Fraction to Recurring Decimal My Submissions Question
     * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
     *
     * If the fractional part is repeating, enclose the repeating part in parentheses.
     *
     * For example,
     *
     * Given numerator = 1, denominator = 2, return "0.5".
     * Given numerator = 2, denominator = 1, return "2".
     * Given numerator = 2, denominator = 3, return "0.(6)".
     *
     * https://leetcode.com/problems/fraction-to-recurring-decimal/
     */
    // Optimal solution
    public static String fractionToDecimal(int numerator, int denominator) {
        System.out.println("\nStart function fractionToDecimal()");
        System.out.println("\tnumerator = " + numerator);
        System.out.println("\tdenominator = " + denominator);
        if (denominator == 0) return null;
        if (numerator == 0) return "0";
        long n = numerator; // Math.abs(numerator);
        long d = denominator; // Math.abs(denominator);
        Boolean neg = n > 0 ? d < 0 : d > 0;
        n = n > 0 ? n : -n; // Math.abs(numerator);
        d = d > 0 ? d : -d; // Math.abs(denominator);

        StringBuilder sb = new StringBuilder();
        long res = n/d;
        long rem = (n - res * d) * 10;
        sb.append(res);
        if (rem != 0) {
            sb.append('.');
            HashMap<Long, Integer> map = new HashMap<>();
            while (rem > 0) {
                if (map.get(rem) != null) {
                    int lastIndex = map.get(rem);
                    sb.insert(lastIndex, '(');
                    sb.append(')');
                    break;
                }
                res = rem / d;
                sb.append(res);
                map.put(rem, sb.length() - 1);
                rem = (rem - res * d) * 10;
            }
        }
        String result = (neg ? "-" : "") + sb.toString();
        System.out.println("\tResult = " + result);
        return result;
    }
    public static String fractionToDecimal2(int numerator, int denominator) {
        System.out.println("\nStart function fractionToDecimal2()");
        System.out.println("\tnumerator = " + numerator);
        System.out.println("\tdenominator = " + denominator);
        assert denominator != 0;
        if (numerator == 0) return "0";
        long n = numerator; // Math.abs(numerator);
        long d = denominator; // Math.abs(denominator); // abs does not work for -2147483648
        Boolean neg = n > 0 ? d < 0 : d > 0;
        n = n > 0 ? n : -n; // Math.abs(numerator);
        d = d > 0 ? d : -d; // Math.abs(denominator);

        StringBuilder sb = new StringBuilder();
        long positiveRes = n/d;
        long remainer = n - positiveRes * d;
        sb.append(positiveRes);
        if (remainer != 0) {
            sb.append(".");

            HashMap<Long, Integer> remainerToIndex = new HashMap<>();
            ArrayList<Long> digits = new ArrayList<>();
            int index = 0;
            while (true) {
                remainer *= 10;
                long digit = remainer / d;
                remainer = remainer - digit * d;
                if (digit < 0) {
                    System.out.println("digit: " + digit);
                    System.out.println("d: " + d);
                }

                if (remainerToIndex.containsKey(remainer)) {
                    int loopStartIndex = remainerToIndex.get(remainer);
                    for (int i = 0; i < loopStartIndex; i++)
                        sb.append(digits.get(i));
                    sb.append("(");
                    for (int i = loopStartIndex; i < index; i++)
                        sb.append(digits.get(i));
                    sb.append(")");
                    break;
                } else if (index == 20 || remainer == 0) {
                    for (Long i : digits)
                        sb.append(i);
                    sb.append(digit);
                    break;
                } else {
                    remainerToIndex.put(remainer, index);
                    digits.add(digit);
                }
                index++;
            }
        }
        String result = (neg ? "-" : "") + sb.toString();
        System.out.println("\tResult = " + result);
        return result;
    }

    public static String convertToTitle (int n) {
        int input = n;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n - 26 * ((n-1)/26);
            n = (n-1)/26;
            sb.append((char)(64 + rem));
        }
        String result = sb.reverse().toString();
        System.out.println("\nStart function convertToTitle(): " + input + " => " + result);
        return result;
    }
    // More readable
    public static String convertToTitle2 (int n) {
        int input = n;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 26;
            n /= 26;
            if (rem == 0) {
                rem = 26;
                n--;
            }
            sb.insert(0, (char)('A' + rem - 1));
        }
        String result = sb.toString();
        System.out.println("\nStart function convertToTitle1(): " + input + " => " + result);
        return result;
    }

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
     *
     * For example,
     * Given "egg", "add", return true.
     *
     * Given "foo", "bar", return false.
     *
     * Given "paper", "title", return true.
     *
     * Note:
     * You may assume both s and t have the same length.
     *
     * https://leetcode.com/problems/isomorphic-strings/
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            if (s == null && t == null) return true;
            return false;
        }
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT) return false;
        if (lenS <= 1) return true;

        HashMap<Character, HashSet<Integer>> ms = new HashMap<>();
        HashMap<Character, HashSet<Integer>> mt = new HashMap<>();

        for (int i = 0; i < lenS; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (ms.containsKey(cs) || mt.containsKey(ct)) {
                if (ms.containsKey(cs) && mt.containsKey(ct)) {
                    HashSet ts = ms.get(cs);
                    HashSet tt = mt.get(ct);
                    if (ts.size() != tt.size()) return false;
                    if (!(ts.containsAll(tt) && tt.containsAll(ts))) {
                        return false;
                    } else {
                        ms.get(cs).add(i);
                        mt.get(ct).add(i);
                    }
                } else {
                    return false;
                }
            } else {
                HashSet<Integer> posS = new HashSet<Integer>();
                HashSet<Integer> posT = new HashSet<Integer>();
                posS.add(i);
                posT.add(i);
                ms.put(cs, posS);
                mt.put(ct, posT);
            }
        }
        return true;
    }

    // This version is wrong
    public static boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null) {
            if (s == null && t == null) return true;
            return false;
        }
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT) return false;
        if (lenS <= 1) return true;

        char s0 = s.charAt(0);
        char t0 = t.charAt(0);

        for (int i = 1; i < lenS; i++) {
            if ((s.charAt(i) - s0) != (t.charAt(i) -t0)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isIsomorphic3(String s, String t) {
        if (s == null || t == null) {
            if (s == null && t == null) return true;
            return false;
        }
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT) return false;
        if (lenS <= 1) return true;

        HashMap<Character, Character> M1 = new HashMap<>();
        HashMap<Character, Character> M2 = new HashMap<>();

        for (int i = 0; i < lenS; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (M1.containsKey(cs) || M2.containsKey(ct)) {
                if (M1.containsKey(cs) && M2.containsKey(ct)) {
                    if (!(M1.get(cs) == ct && M2.get(ct) == cs)) {
                        return false;
                    }
                } else  return false;
            } else {
                M1.put(cs, ct);
                M2.put(ct, cs);
            }
        }
        return true;
    }

    /**
     * Basic Calculator
     *
     * Implement a basic calculator to evaluate a simple expression string.
     * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
     * You may assume that the given expression is always valid.
     *
     * Some examples:
     *      "1 + 1" = 2
     *      " 2-1 + 2 " = 3
     *      "(1+(4+5+2)-3)+(6+8)" = 23
     * Note: Do not use the eval built-in library function.
     *
     * https://leetcode.com/problems/basic-calculator/
     */
    // Works, but "Time Limit Exceeded"
    public static int calculate (String s) {
        System.out.println("\nStart function calculate()");
        System.out.println("\ts = " + s);
        assert s != null;
        assert s.length() > 0;

        HashSet<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        Integer res = null;
        Character ops = null;
        Integer val = null;

        int start = 0, end = 0;
        int leftCount = 0;
        int leftBraceIndex = -1;
        int rightBraceIndex = -1;
        for (; end < s.length(); end++) {
            if (s.charAt(end) == '(') {
                leftBraceIndex = end;
                leftCount++;
                rightBraceIndex = leftBraceIndex+1;
                for (; rightBraceIndex < s.length(); rightBraceIndex++) {
                    if (s.charAt(rightBraceIndex) == '(') leftCount++;
                    else if (s.charAt(rightBraceIndex) == ')') {
                        leftCount--;
                        if (leftCount == 0)
                            break;
                    }
                }
                assert rightBraceIndex < s.length();
                val = calculate(s.substring(leftBraceIndex+1, rightBraceIndex));
                end = rightBraceIndex + 1;
                res = updateResult (ops, res, val);

                while (end < s.length() && !operators.contains(s.charAt(end)))
                    end++;
                start = end + 1;
                if (end < s.length()) {
                    ops = s.charAt(end);
                }
            } else {
                if (operators.contains(s.charAt(end))) {
                    val = Integer.parseInt(removeTrailingSpaces(s.substring(start, end)));
                    res = updateResult (ops, res, val);

                    ops = s.charAt(end);
                    start = end + 1;
                }
            }
        }
        System.out.println("\tstart = " + start);
        System.out.println("\tend = " + end);
        if (start < end && start < s.length()) {
            val = Integer.parseInt(removeTrailingSpaces(s.substring(start)));
            res = updateResult (ops, res, val);
        }
        System.out.println("\t" + s + " = " + res);
        return res;
    }
    private static Integer updateResult (Character ops, Integer res, Integer val) {
        if (ops == null) return val;
        switch (ops) {
            case '+':
                return res + val;
            case '-':
                return res - val;
            case '*':
                return res * val;
            case '/':
                return res / val;
            default:
                return res;
        }
    }
    private static String removeTrailingSpaces (String s) {
        int start = 0;
        while (start < s.length() && s.charAt(start) == ' ') start++;
        if (start == s.length()) return s;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        return s.substring(start, end + 1);
    }
    // Optimal solution
    public static int calculate2 (String s) {
        System.out.println("\nStart function calculate2()");
        //System.out.println("\ts = " + s);
        int res = 0;
        Stack<Integer> sign = new Stack<>();
        sign.add(1);
        sign.add(1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    num = 10 * num + s.charAt(i++) - '0';
                res += sign.pop() * num;
                --i;
            } else if (c == '+') {
                sign.push(sign.peek());
            } else if (c == ')') {
                sign.pop();
            } else if (c == '(') {
                sign.push(sign.peek());
            } else if (c == '-') {
                sign.push(-1 * sign.peek());
            }
        }
        System.out.println("\t" + s + " = " + res);
        return res;
    }
    // Optimal solution 2: This version also passed LeetCode test
    public static void calculatDemo3(String s) {
        System.out.println("\nStart function calculatDemo3()");
        System.out.println("\t" + s + " = " + calculate4(s));
    }
    public static int calculate3 (String s) {
        LinkedList<Integer> listNumb = new LinkedList<> ();
        LinkedList<Character> listOper = new LinkedList<> ();
        boolean getVal = true;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (getVal) {
                int num = 0;
                if (i < s.length() && s.charAt(i) == '(') {
                    String newStr = findNextBracedString(s, i);
                    num = calculate3(newStr);
                    i += newStr.length() + 1;
                } else {
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = 10 * num + s.charAt(i++) - '0';
                    }
                    i--;
                }
                listNumb.add(num);
            } else {
               if (i < s.length()) {
                   listOper.add(s.charAt(i));
               }
            }
            getVal = !getVal;
        }
        return calculateByOpsNumsList(listNumb, listOper);
    }
    public static int calculate4 (String s) {
        LinkedList<Integer> listNumb = new LinkedList<> ();
        LinkedList<Character> listOper = new LinkedList<> ();
        boolean getVal = true;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (getVal) {
                int num = 0;
                if (i < s.length() && s.charAt(i) == '(') {
                    String newStr = findNextBracedString(s, i);
                    num = calculate3(newStr);
                    i += newStr.length() + 2;
                } else {
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = 10 * num + s.charAt(i++) - '0';
                    }
                }
                listNumb.add(num);
            } else {
                if (i < s.length()) {
                    listOper.add(s.charAt(i++));
                }
            }
            getVal = !getVal;
        }
        return calculateByOpsNumsList(listNumb, listOper);
    }

    /**
     * Basic Calculator II
     *
     * Implement a basic calculator to evaluate a simple expression string.
     * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
     * You may assume that the given expression is always valid.
     * Some examples:
     *      "3+2*2" = 7
     *      " 3/2 " = 1
     *      " 3+5 / 2 " = 5
     * Note: Do not use the eval built-in library function.
     *
     * https://leetcode.com/problems/basic-calculator-ii/
     */
    public static void calculateIIDemo(String s) {
        System.out.println("\nStart function calculateIIDemo()");
        System.out.println("\t" + s + " = " + calculateII(s));
    }
    public static int calculateII(String s) {
        //System.out.println("\nStart function calculateII()");
        //System.out.println("\ts = " + s);
        int res = 0;

        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i++) - '0';
                }
                i--;
                nums.add(num);
            } else if (c == '+' || c == '-') {
                ops.add(c);
            } else if (c == '*' || c == '/') {
                int n1 = nums.removeLast();
                while (i < s.length() && !Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int n2 = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n2 = 10 * n2 + s.charAt(i++) - '0';
                }
                i--;

                nums.add((c == '*') ? (n1 * n2) : (n1 / n2));
            }
        }

        while (!ops.isEmpty()) {
            Character op = ops.removeFirst();
            int n1 = nums.removeFirst();
            int n2 = nums.removeFirst();
            int newN = op == '+' ? n1 + n2 : n1 - n2;
            nums.addFirst(newN);
        }
        res = nums.removeLast();
        //System.out.println("\t" + s + " = " + res);
        return res;
    }
    // Optimal solution
    public static void calculateIIDemo2(String s) {
        System.out.println("\nStart function calculateIIDemo2()");
        System.out.println("\t" + s + " = " + calculateII2(s));
    }
    public static int calculateII2(String s) {
        //System.out.println("\nStart function calculateII2()");
        //System.out.println("\ts = " + s);

        LinkedList<Integer> listNumb = new LinkedList<> ();
        LinkedList<Character> listOper = new LinkedList<> ();
        boolean getVal = true;
        for (int i = 0; i < s.length(); i++) {
            if (getVal) {
                while (i < s.length() && s.charAt(i) == ' ') i++;
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                listNumb.add(num);
                i--;
            } else {
                while (i < s.length() && s.charAt(i) == ' ') i++;
                if (i < s.length())
                    listOper.add(s.charAt(i));
            }
            getVal = !getVal;
        }
        //System.out.println("\tNums = " + listNumb);
        //System.out.println("\tOper = " + listOper);

        Iterator<Character> iterO = listOper.iterator();
        ListIterator<Integer> iterN = listNumb.listIterator();
        while (iterO.hasNext() && iterN.hasNext()) {
            Character ops = iterO.next();
            if (ops == '*' || ops == '/') {
                int n1 = iterN.next();
                int n2 = iterN.next();
                if (ops == '*') n1 *= n2;
                else n1 /= n2;

                // This sequence is very important! Attention !!!
                iterO.remove();
                iterN.previous();
                iterN.previous();
                iterN.set(n1);
                iterN.next();
                iterN.next();
                iterN.remove();
                iterN.previous();
            } else {
                iterN.next();
            }
        }

        //System.out.println("\tNums = " + listNumb);
        //System.out.println("\tOper = " + listOper);

        Integer res = listNumb.getFirst();
        iterO = listOper.iterator();
        iterN = listNumb.listIterator(1);
        while (iterO.hasNext() && iterN.hasNext()) {
            Integer n2 = iterN.next();
            if (iterO.next() == '+')
                res += n2;
            else
                res -= n2;
        }
        //System.out.println("\t" + s + " = " + res);
        return res;
    }
    /**
     * Basic Calculator III
     *
     * Implement a basic calculator to evaluate a simple expression string.
     * The expression string contains only non-negative integers, +, -, *, / operators, empty spaces, and open ( and closing parentheses ). The integer division should truncate toward zero.
     * You may assume that the given expression is always valid.
     * Some examples:
     *      (3+2)*2 = 10
     *      (1+(4+5*2)-3)*(6+8) = 168
     *      (1*(4+5+2)-3)-(6+8) = -6
     * Note: Do not use the eval built-in library function.
     */
    public static void calculateIIIDemo(String s) {
        System.out.println("\nStart function calculateIII()");
        System.out.println("\t" + s + " = " + calculateIII(s));
    }
    public static int calculateIII(String s) {
        int res = 0;

        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                String bracedString = findNextBracedString(s, i);
                int num = calculateIII(bracedString);
                nums.add(num);
                i += bracedString.length() + 1;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + s.charAt(i++) - '0';
                }
                i--;
                nums.add(num);
            } else if (c == '+' || c == '-') {
                ops.add(c);
            } else if (c == '*' || c == '/') {
                int n1 = nums.removeLast();
                i++;
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                int n2 = 0;
                if (s.charAt(i) == '(') {
                    String bracedString = findNextBracedString(s, i);
                    n2 = calculateIII(bracedString);
                    i += bracedString.length() + 1;
                } else {
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        n2 = 10 * n2 + s.charAt(i++) - '0';
                    }
                    i--;
                }
                if (c == '*') {
                    nums.add(n1 * n2);
                } else {
                    nums.add(n1 / n2);
                }
            }
        }

        while (!ops.isEmpty()) {
            Character op = ops.removeFirst();
            int n1 = nums.removeFirst();
            int n2 = nums.removeFirst();
            int newN = op == '+' ? n1 + n2 : n1 - n2;
            nums.addFirst(newN);
        }
        res = nums.removeLast();
        return res;
    }
    public static void calculateIIIDemo2(String s) {
        System.out.println("\nStart function calculateIIIDemo2()");
        System.out.println("\t" + s + " = " + calculateIII2(s));
    }
    public static int calculateIII2(String s) {
        int res = 0;

        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                ops.add(c);
            } else if (c == '*' || c == '/') {
                int n1 = nums.removeLast();
                i = findNextNum (s, ++i, nums);
                int n2 = nums.removeLast();

                if (c == '*') {
                    nums.add(n1 * n2);
                } else {
                    nums.add(n1 / n2);
                }
            } else if (c != ' ') {
                i = findNextNum (s, i, nums);
            }
        }

        while (!ops.isEmpty()) {
            Character op = ops.removeFirst();
            int n1 = nums.removeFirst();
            int n2 = nums.removeFirst();
            int newN = op == '+' ? n1 + n2 : n1 - n2;
            nums.addFirst(newN);
        }
        res = nums.removeLast();
        return res;
    }
    private static String findNextBracedString (String s, int i) {
        assert s.charAt(i) == '(';
        int leftBraceIndex = i;
        int leftCount = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftCount++;
            else if (s.charAt(i) == ')') {
                leftCount--;
                if (leftCount == 0)
                    break;
            }
        }
        return s.substring(leftBraceIndex+1, i);
    }
    private static int findNextNum (String s, int i, LinkedList<Integer> nums) {
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i >= s.length()) return i;

        char c = s.charAt(i);
        int num = 0;
        if (c == '(') {
            String bracedString = findNextBracedString(s, i);
            num = calculateIII(bracedString);
            nums.add(num);
            i += bracedString.length() + 1;
        } else if (Character.isDigit(c)) {
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = 10 * num + s.charAt(i++) - '0';
            }
            i--;
            nums.add(num);
        }
        return i;
    }
    /**
     * Optimal solution using calculateII2
     *
     * First remove the braces, then this question became same as calculateII
     *
     * UPDATE: this version has a hidden bug:
     *
     * For example: "2-(5-6)" would be transferred to "2--1"
     *
     * NEW UPDATE: this above problem can be solved by calling calculateIII3_Helper(), instead of calculateII2()
     */
    public static void calculateIIIDemo3(String s) {
        System.out.println("\nStart function calculateIIIDemo3()");
        System.out.printf("\t" + s + " = ");
        System.out.printf(calculateIII3(s) + "\n");
    }
    public static int calculateIII3(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                String bracedString = findNextBracedString(s, i);
                String newStr = s.substring(0, i) + calculateIII3(bracedString) + s.substring(i + bracedString.length()+2);
                return calculateIII3(newStr);
            }
        }
        // return calculateII2(s);
        return calculateIII3_Helper(s);
    }
    public static int calculateIII3_Helper(String s) {
        LinkedList<Integer> listNumb = new LinkedList<>();
        LinkedList<Character> listOper = new LinkedList<>();

        HashSet<Character> allOps = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

        boolean getVal = true;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (getVal) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i++) - '0';
                }
                listNumb.add(num);
                i--;
            } else {
                boolean neg = false;
                Character mul = null;
                while (i < s.length() && allOps.contains(s.charAt(i))) {
                    if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                        mul = s.charAt(i);
                    }
                    if (s.charAt(i) == '-') {
                        neg = !neg;
                    }
                    i++;
                }
                i--;
                if (mul == null) {
                    if (neg) {
                        listOper.add('-');
                    } else {
                        listOper.add('+');
                    }
                } else {
                    if (neg) {
                        listOper.add('*');
                        listNumb.add(-1);
                    }
                    listOper.add(mul);
                }
            }
            getVal = !getVal;
        }
        return calculateByOpsNumsList(listNumb, listOper);
    }

    /**
     * Optimal solution using calculateII2
     *
     * Similar as calculate4()
     */
    public static void calculateIIIDemo4(String s) {
        System.out.println("\nStart function calculateIIIDemo4()");
        System.out.println("\t" + s + " = " + calculateIII4(s));
    }
    public static int calculateIII4(String s) {
        LinkedList<Integer> listNumb = new LinkedList<> ();
        LinkedList<Character> listOper = new LinkedList<> ();
        boolean getVal = true;
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (getVal) {
                int num = 0;
                if (s.charAt(i) == '(') {
                    String bracedString = findNextBracedString(s, i);
                    num = calculateIII4(bracedString);
                    i += bracedString.length() + 1;
                } else {
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i++) - '0';
                    }
                    i--;
                }
                listNumb.add(num);
            } else {
                if (i < s.length()) {
                    listOper.add(s.charAt(i));
                }
            }
            getVal = !getVal;
        }

        return calculateByOpsNumsList(listNumb, listOper);
    }
    private static int calculateByOpsNumsList (LinkedList<Integer> listNumb, LinkedList<Character> listOper) {
        Iterator<Character> iterO = listOper.iterator();
        ListIterator<Integer> iterN = listNumb.listIterator();
        while (iterO.hasNext() && iterN.hasNext()) {
            Character ops = iterO.next();
            if (ops == '*' || ops == '/') {
                int n1 = iterN.next();
                int n2 = iterN.next();
                if (ops == '*') n1 *= n2;
                else n1 /= n2;

                // This sequence is very important! Attention !!!
                iterO.remove();
                iterN.previous();
                iterN.previous();
                iterN.set(n1);
                iterN.next();
                iterN.next();
                iterN.remove();
                iterN.previous();
            } else {
                iterN.next();
            }
        }

        Integer res = listNumb.getFirst();
        iterO = listOper.iterator();
        iterN = listNumb.listIterator(1);
        while (iterO.hasNext() && iterN.hasNext()) {
            Integer n2 = iterN.next();
            if (iterO.next() == '+')
                res += n2;
            else
                res -= n2;
        }
        return res;
    }
    private static long calculateByOpsNumsList2 (LinkedList<Long> listNumb, LinkedList<Character> listOper) {
        Iterator<Character> iterO = listOper.iterator();
        ListIterator<Long> iterN = listNumb.listIterator();
        while (iterO.hasNext() && iterN.hasNext()) {
            Character ops = iterO.next();
            if (ops == '*' || ops == '/') {
                long n1 = iterN.next();
                long n2 = iterN.next();
                if (ops == '*') n1 *= n2;
                else n1 /= n2;

                // This sequence is very important! Attention !!!
                iterO.remove();
                iterN.previous();
                iterN.previous();
                iterN.set(n1);
                iterN.next();
                iterN.next();
                iterN.remove();
                iterN.previous();
            } else {
                iterN.next();
            }
        }

        long res = listNumb.getFirst();
        iterO = listOper.iterator();
        iterN = listNumb.listIterator(1);
        while (iterO.hasNext() && iterN.hasNext()) {
            long n2 = iterN.next();
            if (iterO.next() == '+')
                res += n2;
            else
                res -= n2;
        }
        return res;
    }

    /**
     * Different Ways to Add Parentheses
     *
     * Given a string of numbers and operators, return all possible results
     * from computing all the different possible ways to group numbers and operators.
     * The valid operators are +, - and *.
     *
     * Example 1
     * Input: "2-1-1".
     *         ((2-1)-1) = 0
     *         (2-(1-1)) = 2
     * Output: [0, 2]
     *
     * Example 2
     * Input: "2*3-4*5"
     *         (2*(3-(4*5))) = -34
     *         ((2*3)-(4*5)) = -14
     *         ((2*(3-4))*5) = -10
     *         (2*((3-4)*5)) = -10
     *         (((2*3)-4)*5) = 10
     * Output: [-34, -14, -10, -10, 10]
     *
     * https://leetcode.com/problems/different-ways-to-add-parentheses/
     */
    public static List<Integer> diffWaysToCompute(String input) {
        System.out.println("\nStart function diffWaysToCompute()");
        System.out.println("\tinput = " + input);
        List<Integer> nums = new ArrayList<> ();
        List<Character> ops = new ArrayList<> ();
        boolean getVal = true;
        for (int i = 0; i < input.length(); i++) {
            while (i < input.length() && input.charAt(i) == ' ') i++;
            if (getVal) {
                int num = 0;
                while (i < input.length() && Character.isDigit(input.charAt(i))) {
                    num = num * 10 + input.charAt(i++) - '0';
                }
                nums.add(num);
                i--;
            } else {
                if (i < input.length()) {
                    ops.add(input.charAt(i));
                }
            }
            getVal = !getVal;
        }

//        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> res = diffWaysToComputeHelper(nums, ops);
//        diffWaysToComputeHelper2(nums, ops, res);
        System.out.println("\tres = " + res);
        return res;
    }
    public static List<Integer> diffWaysToComputeHelper(List<Integer> nums, List<Character> ops) {
        ArrayList<Integer> r = new ArrayList<>();
        if (ops.size() == 1) {
            assert nums.size() == 2;
            r.add(singleOperation(ops.get(0), nums.get(0), nums.get(1)));
        } else if (ops.size() == 0) {
            assert nums.size() == 1;
            r.add(nums.get(0));
        } else {

            for (int i = 0; i < ops.size(); i++) {
                List<Integer> preNums = nums.subList(0, i + 1);
                List<Integer> postNums = nums.subList(i + 1, nums.size());

                List<Character> preOps = ops.subList(0, i);
                List<Character> postOps = ops.subList(i + 1, ops.size());

                List<Integer> preRes = diffWaysToComputeHelper(preNums, preOps);
                List<Integer> postRes = diffWaysToComputeHelper(postNums, postOps);

                for (Integer pre : preRes) {
                    for (Integer post : postRes) {
                        r.add(singleOperation(ops.get(i), pre, post));
                    }
                }
            }
        }
        return r;
    }
    public static void diffWaysToComputeHelper2(ArrayList<Integer> nums, ArrayList<Character> ops, ArrayList<Integer> res) {
        if (ops.size() == 1) {
            assert nums.size() == 2;
            res.add(singleOperation(ops.get(0), nums.get(0), nums.get(1)));
            return;
        }

        for (int i = 0; i < ops.size(); i++) {
            int newNum = singleOperation(ops.get(i), nums.get(i), nums.get(i+1));
            ArrayList<Integer> newNums = new ArrayList<>(nums);
            newNums.remove(i);
            newNums.remove(i);
            newNums.add(i, newNum);
            ArrayList<Character> newOps = new ArrayList<>(ops);
            newOps.remove(i);
            diffWaysToComputeHelper2(newNums, newOps, res);
        }
    }
    private static Integer singleOperation(Character op, Integer n1, Integer n2) {
        if (op == '+') return n1 + n2;
        else if (op == '-') return n1 - n2;
        else return n1 * n2;
//        else if (op == '*') return n1 * n2;
    }

    /**
     * Integer to English Words
     *
     * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
     *
     * For example,
     * 123 -> "One Hundred Twenty Three"
     *         12345 -> "Twelve Thousand Three Hundred Forty Five"
     *         1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * Hint:
     *
     * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
     * Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
     * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
     */
    public static String numberToWords(int num) {
        System.out.println("\nStart function numberToWords()");
        System.out.println("\tnum = " + num);

        if (num == 0) return "Zero";

        Queue<Integer> scales = new LinkedList<>(Arrays.asList(new Integer[] {1000000000, 1000000, 1000}));
        HashMap<Integer, String> scaleStr = new HashMap<>();
        scaleStr.put(1, "One");
        scaleStr.put(2, "Two");
        scaleStr.put(3, "Three");
        scaleStr.put(4, "Four");
        scaleStr.put(5, "Five");
        scaleStr.put(6, "Six");
        scaleStr.put(7, "Seven");
        scaleStr.put(8, "Eight");
        scaleStr.put(9, "Nine");
        scaleStr.put(10, "Ten");
        scaleStr.put(11, "Eleven");
        scaleStr.put(12, "Twelve");
        scaleStr.put(13, "Thirteen");
        scaleStr.put(14, "Fourteen");
        scaleStr.put(15, "Fifteen");
        scaleStr.put(16, "Sixteen");
        scaleStr.put(17, "Seventeen");
        scaleStr.put(18, "Eighteen");
        scaleStr.put(19, "Nineteen");
        scaleStr.put(20, "Twenty");
        scaleStr.put(30, "Thirty");
        scaleStr.put(40, "Forty");
        scaleStr.put(50, "Fifty");
        scaleStr.put(60, "Sixty");
        scaleStr.put(70, "Seventy");
        scaleStr.put(80, "Eighty");
        scaleStr.put(90, "Ninety");
        scaleStr.put(100, "Hundred");
        scaleStr.put(1000, "Thousand");
        scaleStr.put(1000000, "Million");
        scaleStr.put(1000000000, "Billion");

        StringBuilder sb = new StringBuilder();
        while (!scales.isEmpty()) {
            int scale = scales.poll();
            int val = num / scale;
            num %= scale;
            if (val > 0) {
                sb.append(" " + parseThreeDigits(val, scaleStr) + " " + scaleStr.get(scale));
            }
        }
        if (num > 0) {
            sb.append(" " + parseThreeDigits(num, scaleStr));
        }

        while (sb.charAt(0) == ' ') sb.deleteCharAt(0);
        System.out.println("\tString = " + sb.toString());
        return sb.toString();
    }
    private static String parseThreeDigits(int num, HashMap<Integer, String> scaleStr) {
        assert num < 1000;
        if (num == 0) return "";
        StringBuilder sb = new StringBuilder();
        int hundreds = num/100;
        if (hundreds > 0) {
            sb.append(scaleStr.get(hundreds) + " Hundred");
        }
        num %= 100;
        if (num > 0) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            int tens = num/10;
            if (tens > 1) {
                sb.append(scaleStr.get(10 * tens));
                num %= 10;
                if (num > 0) {
                    sb.append(" " + scaleStr.get(num));
                }
            } else {
                sb.append(scaleStr.get(num));
            }
        }
        return sb.toString();
    }


    public static boolean wordPattern(String pattern, String str) {
        int len = pattern.length();
        String[] words = str.split(" ");
        if (len != words.length) return false;
        char[] chars = pattern.toCharArray();

        HashMap<Character, String> c2s = new HashMap<>();
        HashMap<String, Character> s2c = new HashMap<>();

        for (int i = 0; i < len; i++) {
            Character c = chars[i];
            String s = words[i];
            if (c2s.containsKey(c) && s2c.containsKey(s)) {
                if (!c2s.get(c).equals(s) || s2c.get(s) != c) {
                    return false;
                }
            } else if (!c2s.containsKey(c) && !s2c.containsKey(s)) {
                c2s.put(c, s);
                s2c.put(s, c);
            } else {
                return false;
            }
        }
        return true;
    }
    // Another version usiing one Map & one Set
    public static boolean wordPattern2(String pattern, String str) {
        int len = pattern.length();
        String[] words = str.split(" ");
        if (len != words.length) return false;
        char[] chars = pattern.toCharArray();

        HashMap<Character, String> c2s = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            Character c = chars[i];
            String s = words[i];
            if (set.contains(s)) {
                if (!s.equals(c2s.get(c))) {
                    return false;
                }
            } else {
                if (c2s.containsKey(c)) {
                    return false;
                }
                c2s.put(c, s);
                set.add(s);
            }
        }
        return true;
    }

    /**
     * Word Pattern II
     *
     * Given a pattern and a string str, find if str follows the same pattern.
     *
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
     *
     * Examples:
     * pattern = "abab", str = "redblueredblue" should return true.
     * pattern = "aaaa", str = "asdasdasdasd" should return true.
     * pattern = "aabb", str = "xyzabcxzyabc" should return false.
     *
     * Notes: You may assume both pattern and str contains only lowercase letters.
     */
    public static boolean wordPatternMatch(String pattern, String str) {
        System.out.println("\nStart function wordPatternMatch()");
        System.out.println("\tPattern = " + pattern + "; Str = " + str);

        HashMap<Character, String> c2s = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        boolean res = wordPatternMatchHelper(pattern, str, c2s, set, 0, 0);
        System.out.println("\tMatched: " + res);
        return res;
    }
    private static boolean wordPatternMatchHelper(String pattern, String str, HashMap<Character, String> c2s, HashSet<String> set, int i, int j) {
        if (i == pattern.length() && j == str.length()) {
            return true;
        }
        if (i == pattern.length() || j == str.length()) {
            return false;
        }
        Character c = pattern.charAt(i);
        for (int cut = j + 1; cut <= str.length(); cut++) {
            String s = str.substring(j, cut);
            if (set.contains(s) && s.equals(c2s.get(c))) {
                return wordPatternMatchHelper(pattern, str, c2s, set, i+1, cut);
            } else if (!set.contains(s) && !c2s.containsKey(c)) {
                c2s.put(c, s);
                set.add(s);
                if (wordPatternMatchHelper(pattern, str, c2s, set, i+1, cut)) {
                    return true;
                }
                c2s.remove(c);
                set.remove(s);
            }
        }
        return false;
    }

    /**
     * You are playing the following Flip Game with your friend: Given a string that contains only these two characters:+ and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
     *
     * Write a function to compute all possible states of the string after one valid move.
     *
     * For example, given s = "++++", after one move, it may become one of the following states:
     *
     *         [
     *         "--++",
     *         "+--+",
     *         "++--"
     *         ]
     * If there is no valid move, return an empty list [].
     */
    public static List<String> generatePossibleNextMoves(String s) {
        System.out.println("\nStart function generatePossibleNextMoves()");
        System.out.println("\tStr: " + s);
        List<String> res = new LinkedList<>();
        int len = s.length();
        if (len < 2) return res;

        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {
            if (chars[i] == '+' && chars[i-1] == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.setCharAt(i, '-');
                sb.setCharAt(i-1, '-');
                res.add(sb.toString());
            }
        }
        for (String r : res) {
            System.out.println("\t" + r);
        }
        return res;
    }

    /**
     * Flip Game II
     *
     * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
     *
     * Write a function to determine if the starting player can guarantee a win.
     *
     * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
     *
     * Follow up:
     * Derive your algorithm's runtime complexity.
     */
//    public static boolean canWin(String s) {
//        int len = s.length();
//        if (len < 5) return true;
//        return (len - 1) % 4 == 0;
//    }
    public static void canWinDemo(String s) {
        System.out.println("\nStart function Flip Game canWinDemo()");
        System.out.println("\tStr: " + s);
        System.out.println("\tCanWin = " + canWin(s));
    }
    public static boolean canWin(String s) {
        for (int i = -1; (i = s.indexOf("++", i+1)) >= 0;) {
            if (!canWin(s.substring(0, i) + "--" + s.substring(i+2))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Expression Add Operators
     *
     * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
     *
     * Examples:
     *         "123", 6 -> ["1+2+3", "1*2*3"]
     *         "232", 8 -> ["2*3+2", "2+3*2"]
     *         "105", 5 -> ["1*0+5","10-5"]
     *         "00", 0 -> ["0+0", "0-0", "0*0"]
     *         "3456237490", 9191 -> []
     *
     * https://leetcode.com/problems/expression-add-operators/
     */
    public static List<String> addOperators(String num, int target) {
        System.out.println("\nStart function addOperators()");
        System.out.println("\tnum: " + num);
        System.out.println("\ttarget = " + target);
        List<String> res = new ArrayList<> ();
        int len = num.length();
        if (len < 1) return res;

        List<LinkedList<Long>> numsList = getNums(num);
        System.out.println("\t" + numsList);
        LinkedList<Character> ops = new LinkedList<>();

        for (LinkedList<Long> nums : numsList) {
            addOperatorsHelper(nums, ops, target, res, 0);
        }
        for (String r : res) {
            System.out.println("\t\t" + r);
        }
        return res;
    }
    public static void addOperatorsHelper(LinkedList<Long> nums, LinkedList<Character> ops, int target, List<String> res, int index) {
        if (index == nums.size() - 1) {
            if (calculateByOpsNumsList2(new LinkedList<>(nums), new LinkedList<>(ops)) == target) {
                res.add(composeString(new LinkedList<>(nums), new LinkedList<>(ops)));
            }
        } else {
            ops.add('+');
            addOperatorsHelper(nums, ops, target, res, index + 1);
            ops.removeLast();
            ops.add('-');
            addOperatorsHelper(nums, ops, target, res, index + 1);
            ops.removeLast();
            ops.add('*');
            addOperatorsHelper(nums, ops, target, res, index + 1);
            ops.removeLast();
        }
    }
    private static List<LinkedList<Long>> getNums(String num) {
        List<LinkedList<Long>> res = new ArrayList<>();

        getNumsHelper(num, res, new LinkedList<>(), 0);

        return res;
    }
    private static void getNumsHelper(String num, List<LinkedList<Long>> res, LinkedList<Long> temp, int index) {
        if (index == num.length()) {
            res.add((LinkedList<Long>) temp.clone());
        } else {
            for (int cut = index + 1; cut <= num.length(); cut++) {
                String str = num.substring(index, cut);
                long val = Long.parseLong(str);
                if ((val > 0 && !str.startsWith("0")) ||
                    (val == 0 && str.length() == 1)) {
                    temp.add(Long.parseLong(str));
                    getNumsHelper(num, res, temp, cut);
                    temp.removeLast();
                }
            }
        }
    }
    private static String composeString(LinkedList<Long> nums, LinkedList<Character> ops) {
        StringBuilder sb = new StringBuilder();
        sb.append(nums.removeFirst());
        while (!nums.isEmpty()) {
            sb.append(ops.removeFirst());
            sb.append(nums.removeFirst());
        }
        return sb.toString();
    }


    public static List<String> addOperators2(String num, int target) {
        System.out.println("\nStart function addOperators2()");
        System.out.println("\tnum: " + num);
        System.out.println("\ttarget = " + target);
        List<String> res = new ArrayList<> ();
        int len = num.length();
        if (len < 1) return res;

        List<LinkedList<Long>> numsList = getNums(num);
        System.out.println("\t" + numsList);

        for (LinkedList<Long> nums : numsList) {
            List<LinkedList<Character>> opsList = getOps(nums.size() - 1);
//            System.out.println("\t" + opsList);

            for (LinkedList<Character> ops : opsList) {
                if (calculateByOpsNumsList2(new LinkedList<>(nums), new LinkedList<>(ops)) == target) {
                    res.add(composeString(new LinkedList<>(nums), new LinkedList<>(ops)));
                }
            }
        }
        for (String r : res) {
            System.out.println("\t\t" + r);
        }
        return res;
    }
    private static List<LinkedList<Character>> getOps(int len) {
        List<LinkedList<Character>> res = new ArrayList<>();

        getOpsHelper(len, res, new LinkedList<>(), 0);

        return res;
    }
    private static void getOpsHelper(int len, List<LinkedList<Character>> res, LinkedList<Character> temp, int index) {
        if (len == index) {
            res.add((LinkedList<Character>)temp.clone());
        } else {
            temp.add('+');
            getOpsHelper(len, res, temp, index + 1);
            temp.removeLast();
            temp.add('-');
            getOpsHelper(len, res, temp, index + 1);
            temp.removeLast();
            temp.add('*');
            getOpsHelper(len, res, temp, index + 1);
            temp.removeLast();
        }
    }
    public static List<String> addOperators3(String num, int target) {
        System.out.println("\nStart function addOperators3()");
        System.out.println("\tnum: " + num);
        System.out.println("\ttarget = " + target);
        List<String> res = new ArrayList<> ();
        int len = num.length();
        if (len < 1) return res;

        addOperatorsHelper3(num, target, 0, 0, "", res, 0);

        for (String r : res) {
            System.out.println("\t\t" + r);
        }
        return res;
    }
    private static void addOperatorsHelper3(String num, long target, long preNum, long tempSum, String tempStr, List<String> res, int index) {
        if (index == num.length() && tempSum == target) {
            res.add(tempStr);
            return;
        }

        for (int cut = index + 1; cut <= num.length(); cut++) {
            String str = num.substring(index, cut);
            long val = Long.parseLong(str);
            if (val == 0 && str.length() > 1) continue;
            if (val != 0 && str.startsWith("0")) continue;

            if (tempStr.isEmpty()) {
                addOperatorsHelper3(num, target, val, val, "" + val, res, cut);
            } else {
                addOperatorsHelper3(num, target, val, tempSum + val, tempStr + "+" + val, res, cut);
                addOperatorsHelper3(num, target, -val, tempSum - val, tempStr + "-" + val, res, cut);
                addOperatorsHelper3(num, target, preNum * val, tempSum - preNum + preNum * val, tempStr + "*" + val, res, cut);
            }
        }
    }

    /**
     * Bulls and Cows
     *
     * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
     *
     * For example:
     *
     * Secret number:  "1807"
     * Friend's guess: "7810"
     * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
     * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
     *
     * Please note that both secret number and friend's guess may contain duplicate digits, for example:
     *
     * Secret number:  "1123"
     * Friend's guess: "0111"
     * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
     * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
     */
    public String getHint(String secret, String guess) {
        int len = secret.length();
        assert len == guess.length();

        char[] ss = secret.toCharArray();
        char[] gs = guess.toCharArray();

        HashMap<Character, Integer> count = new HashMap<>();
        for (char sc : ss) {
            if (count.containsKey(sc)) {
                count.put(sc, count.get(sc) + 1);
            } else {
                count.put(sc, 1);
            }
        }
        int bull = 0, cow = 0;
        for (int i = 0; i < len; i++) {
            if (count.containsKey(gs[i]) && count.get(gs[i]) > 0) {
                cow++;
                count.put(gs[i], count.get(gs[i]) - 1);
            }
            if (ss[i] == gs[i]) {
                bull++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bull).append("A");
        sb.append((cow - bull) >= 0 ? (cow-bull) : 0).append("B");
        return sb.toString();
    }

    /**
     * Remove Invalid Parentheses
     *
     * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
     *
     * Note: The input string may contain letters other than the parentheses ( and ).
     *
     * Examples:
     *         "()())()" -> ["()()()", "(())()"]
     *         "(a)())()" -> ["(a)()()", "(a())()"]
     *         ")(" -> [""]
     */
    public static List<String> removeInvalidParentheses(String s) {
        System.out.println("\nStart function removeInvalidParentheses()");
        System.out.println("\tStr: " + s);

        ArrayList<Integer> ass = new ArrayList<>();
        int a = 1;
        ass.add(a);
        int len = s.length();
//        List<String> res = new ArrayList<>();
        HashMap<Integer, HashSet<String>> res = new HashMap<>();
        LinkedList<Character> Q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            Q.add(s.charAt(i));
        }

        removeInvalidParenthesesHelper(Q, "", 0, 0, res);

        int maxLen = 0;
        for (int l : res.keySet()) {
            maxLen = Math.max(maxLen, l);
            for (String r : res.get(l)) {
                System.out.println("\t\t" + r);
            }
        }
        return new ArrayList<String>(res.get(maxLen));
    }
    private static void removeInvalidParenthesesHelper(LinkedList<Character> Q, String temp, int left, int right, HashMap<Integer, HashSet<String>> res) {
        if (Q.isEmpty()) {
            if (left == right) {
                if (res.containsKey(temp.length())) {
                    if (!res.get(temp.length()).contains(temp)) {
                        res.get(temp.length()).add(temp);
                    }
                } else {
                    HashSet<String> newSet = new HashSet<>();
                    newSet.add(temp);
                    res.put(temp.length(), newSet);
                }
            }
        } else {
            Character c = Q.removeFirst();
            if (c == '(') {
                removeInvalidParenthesesHelper(Q, temp + c, left + 1, right, res);
                removeInvalidParenthesesHelper(Q, temp, left, right, res);
            } else if (c == ')'){
                if (left > right) {
                    removeInvalidParenthesesHelper(Q, temp + c, left, right + 1, res);
                }
                removeInvalidParenthesesHelper(Q, temp, left, right, res);
            } else {
                removeInvalidParenthesesHelper(Q, temp + c, left, right, res);
            }
            Q.addFirst(c);
        }
    }

    /**
     * Additive Number
     *
     * Additive number is a string whose digits can form additive sequence.
     *
     * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
     *
     * For example:
     *         "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
     *
     *         1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     *         "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
     *         1 + 99 = 100, 99 + 100 = 199
     * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
     *
     * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
     *
     * Follow up:
     * How would you handle overflow for very large input integers?
     */
    public static boolean isAdditiveNumber(String num) {
        System.out.println("\nStart function isAdditiveNumber()");
        System.out.println("\tnum: " + num);
        List<String> res = new ArrayList<> ();
        int len = num.length();
        if (len < 1) return true;

        boolean isAdditive = isAdditiveNumberHelper(num, null, null);

        System.out.println("\tisAdditive = " + isAdditive);
        return isAdditive;
    }
    private static boolean isAdditiveNumberHelper(String num, Long preTwo, Long preOne) {
        if (preOne == null) {
            if (num.isEmpty()) {
                return false;
            }
            if (num.charAt(0) == '0') {
                return isAdditiveNumberHelper(num.substring(1), null, 0L);
            }
            for (int cut = 1; cut <= num.length()-2; cut++) {
                String str = num.substring(0, cut);
                long val = Long.parseLong(str);
                if (isAdditiveNumberHelper(num.substring(cut), null, val)) {
                    return true;
                }
            }
            return false;
        }
        if (preTwo == null) {
            if (num.isEmpty()) {
                return false;
            }
            if (num.charAt(0) == '0') {
                return isAdditiveNumberHelper(num.substring(1), preOne, 0L);
            }
            for (int cut = 1; cut <= num.length()-1; cut++) {
                String str = num.substring(0, cut);
                long val = Long.parseLong(str);
                if (isAdditiveNumberHelper(num.substring(cut), preOne, val)) {
                    return true;
                }
            }
            return false;
        }

        Long curInt = preTwo + preOne;
        String curString = curInt.toString();
        if (!num.startsWith(curString)) {
            return false;
        }
        if (curString.equals(num)) {
            return true;
        } else {
            return isAdditiveNumberHelper(num.substring(curString.length()), preOne, curInt);
        }
    }
    private static boolean isAdditiveNumberHelper2(String num, Long preTwo, Long preOne) {
        if (num.isEmpty()) {
            return preTwo != null && preOne != null;
        }
        if (num.charAt(0) == '0') {
            if (preTwo == null || preOne == null) {
                String newStr = num.substring(1);
                if (newStr.isEmpty()) {
                    return false;
                } else {
                    return isAdditiveNumberHelper(num.substring(1), preOne, 0L);
                }
            } else {
                if (preTwo + preOne == 0) {
                    return isAdditiveNumberHelper(num.substring(1), preOne, 0L);
                } else {
                    return false;
                }
            }
        }
        if (preOne == null) {
            for (int cut = 1; cut <= num.length()-2; cut++) {
                String str = num.substring(0, cut);
                long val = Long.parseLong(str);
                if (isAdditiveNumberHelper(num.substring(cut), null, val)) {
                    return true;
                }
            }
            return false;
        }
        if (preTwo == null) {
            for (int cut = 1; cut <= num.length()-1; cut++) {
                String str = num.substring(0, cut);
                long val = Long.parseLong(str);
                if (isAdditiveNumberHelper(num.substring(cut), preOne, val)) {
                    return true;
                }
            }
            return false;
        }
        Long curInt = preTwo + preOne;
        String curString = curInt.toString();
        if (!num.startsWith(curString)) {
            return false;
        }
        if (curString.equals(num)) {
            return true;
        } else {
            return isAdditiveNumberHelper(num.substring(curString.length()), preOne, curInt);
        }
    }

    /**
     * Maximum Product of Word Lengths
     * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
     * Example 1:
     * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
     * Return 16
     * The two words can be "abcw", "xtfn".
     * Example 2:
     * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
     * Return 4
     * The two words can be "ab", "cd".
     * Example 3:
     * Given ["a", "aa", "aaa", "aaaa"]
     * Return 0
     * No such pair of words.
     */
    private static class WordHelper {
        int bitMap;
        int len;
        String word;
        public WordHelper(String w) {
            word = w;
            len = w.length();
            bitMap = 0;
            for (char c : w.toCharArray()) {
                int count = c - 'a';
                bitMap |= (0x1 << count);
            }
        }
    }
    public static int maxProduct(String[] words) {
        int len = words.length;
        if (len < 2) return 0;

        ArrayList<WordHelper> ws = new ArrayList<>();
        for (String w : words) {
            ws.add(new WordHelper(w));
        }

        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            WordHelper w1 = ws.get(i);
            for (int j = i + 1; j < len; j++) {
                WordHelper w2 = ws.get(j);
                if ((w1.bitMap & w2.bitMap) == 0) {
                    max = Math.max(w1.len * w2.len, max);
                }
            }
        }
        return max;
    }

    /**
     * Remove Duplicate Letters
     *
     * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
     * Example:
     * Given "bcabc"
     *    Return "abc"
     * Given "cbacdcbc"
     *    Return "acdb"
     */
    public static String removeDuplicateLetters(String s) {
        System.out.println("\nStart function isAdditiveNumber()");
        System.out.println("\ts: " + s);
        int len = s.length();
        if (len < 2) return s;

        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> visited = new HashSet<>();

        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for (Character c : chars) {
            map.put(c, map.get(c) - 1);
            if (visited.contains(c)) continue;
            while (c < sb.charAt(sb.length()-1) && map.get(sb.charAt(sb.length()-1)) > 0) {
                visited.remove(sb.charAt(sb.length()-1));
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
            visited.add(c);
        }
        System.out.println("\tres: " + sb.deleteCharAt(0).toString());
        return sb.deleteCharAt(0).toString();
    }

    public static void isValidSerializationDemo(String preorder) {
        System.out.println("\nStart function isAdditiveNumber()");
        System.out.println("\tpreorder: " + preorder);
        System.out.println("\tisValid: " + isValidSerialization(preorder));
    }
    public static boolean isValidSerialization(String preorder) {
        if (preorder.charAt(0) == '#') return false;
        int count = 0;
        String[] elements = preorder.split(",");
        for (String s : elements) {
            if (s.equals("#")) {
                if (count == 0) return false;
                else count--;
            } else {
                count++;
            }
        }
        return count != 0 ? false : elements[elements.length - 1].equals("#");
    }
    //    public static boolean isValidSerialization(String preorder) {
//        if (preorder.charAt(0) == '#') return false;
//        LinkedList<String> stack = new LinkedList<>();
//        int count = 0;
//        String[] elements = preorder.split(",");
//        for (String s : elements) {
//            if (!s.equals("#")) {
//                stack.addFirst(s);
//            } else {
//                count++;
//                if (count % 2 == 0) {
//                    if (stack.isEmpty()) {
//                        return false;
//                    }
//                    stack.removeFirst();
//                    if (!stack.isEmpty()) {
//                        stack.removeFirst();
//                    }
//                }
//            }
//        }
//        return stack.isEmpty();
//    }

    /**
     * Remove K Digits
     * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
     *         Note:
     *         • The length of num is less than 10002 and will be ≥ k.
  *	• The given num does not contain any leading zero.
     * Example 1:
     * Input: num = "1432219", k = 3
     * Output: "1219"
     * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
     * Example 2:
     * Input: num = "10200", k = 1
     * Output: "200"
     * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
     *         Example 3:
     * Input: num = "10", k = 2
     * Output: "0"
     * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
     */
    public static String removeKdigits(String num, int k) {
        System.out.println("\nStart function removeKdigits()");
        System.out.println("\tnum = " + num + "; k = " + k);
        int len = num.length();
        assert len >= k;
        if (len == k) return "0";

        ArrayList<Integer> res = new ArrayList<>();
        removeKdigits(num, k, 0, res);
        Integer min = Integer.MAX_VALUE;
        for (Integer i : res) {
            System.out.println("\t" + i);
            min = Math.min(min, i);
        }
        System.out.println("\tMin = " + min.toString());
        return min.toString();
    }
    private static void removeKdigits(String num, int k, int index, ArrayList<Integer> res) {
        if (k == 0 && index == num.length()) {
            res.add(Integer.parseInt(num));
        } else if (k > 0 && index < num.length()) {
            removeKdigits(num, k, index + 1, res);
            removeKdigits(num.substring(0, index) + num.substring(index + 1), k - 1, index, res);
        }
    }

    public static String removeKdigits2(String num, int k) {
        System.out.println("\nStart function removeKdigits()");
        System.out.println("\tnum = " + num + "; k = " + k);
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        int size = len - k;

        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length()-1) > c) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(c);
            System.out.println("\t\tsb = " + sb.toString());
        }
        sb.delete(size, sb.length());
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        String res = sb.length() == 0 ? "0" : sb.toString();
        System.out.println("\tMin = " + res);
        return res;
    }

    /**
     * Repeated Substring Pattern
     * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
     * Example 1:
     * Input: "abab"
     * Output: True
     * Explanation: It's the substring "ab" twice.
     * Example 2:
     * Input: "aba"
     * Output: False
     * Example 3:
     * Input: "abcabcabcabc"
     * Output: True
     * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
     */
    public static void repeatedSubstringPatternDemo(String str) {
        System.out.println("\nStart function repeatedSubstringPatternDemo()");
        System.out.println("\tstr = " + str);
        System.out.println("\tResult = " + repeatedSubstringPattern(str));
    }
    public static boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for (int cut = 1; cut <= len/2; cut++) {
            if (len % cut == 0) {
                String sub = str.substring(0, cut);
                int j = cut;
                for (; j < len; j += cut) {
                    String newSub = str.substring(j, j + cut);
                    if (!newSub.equals(sub)) {
                        break;
                    }
                }
                if (j == len) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Longest Substring with At Least K Repeating Characters
     * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
     *         Example 1:
     * Input:
     * s = "aaabb", k = 3
     * Output:
     *         3
     * The longest substring is "aaa", as 'a' is repeated 3 times.
     *         Example 2:
     * Input:
     * s = "ababbc", k = 2
     * Output:
     *         5
     * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */
    public static int longestSubstring(String s, int k) {
        System.out.println("\nStart function longestSubstring()");
        System.out.println("\tstr = " + s + ", k = " + k);
        int len = s.length();

        int res = 0;
        int start = 0;
        int i = 0;
        while(i + k < len) {
            int maxNext = i;
            int[] m = new int[26];
            int mask = 0;
            for (int j = i; j < len; j++) {
                int index = s.charAt(j) - 'a';
                m[index]++;
                if (m[index] < k) {
                    mask |= (0x1 << index);
                } else {
                    mask &= (~(0x1 << index));
                }
                if (mask == 0) {
                    if (j-i+1 > res) {
                        res = Math.max(res, j - i + 1);
                        start = i;
                    }
                    maxNext = j;
                }
            }
            i = maxNext + 1;
        }
        System.out.println("\tRes = " + s.substring(start, start + res));
        System.out.println("\tLength = " + res);
        return res;
    }
    public static int longestSubstring2(String s, int k) {
        System.out.println("\nStart function longestSubstring2()");
        System.out.println("\tstr = " + s + ", k = " + k);
        int len = s.length();
        HashMap<Character, Integer>[][] COUNT = new HashMap[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(COUNT[i], new HashMap<>());
        }

        for (int length = 1; length <= len; length++) {
            for (int i = 0; i < len - length + 1; i++) {
                for (int j = i + length - 1; j < len; j++) {
                    if (j == i) {
                        char c = s.charAt(i);
                        COUNT[i][j].put(c, 1);
                    } else {
                        COUNT[i][j] = (HashMap<Character, Integer>) COUNT[i][j-1].clone();
                        char c = s.charAt(j);
                        if (!COUNT[i][j-1].containsKey(c)) {
                            COUNT[i][j].put(c, 1);
                        } else {
                            COUNT[i][j].put(c, COUNT[i][j-1].get(c) + 1);
                        }
                    }
                }
            }
        }

        printTwoDimentinalArray(COUNT);

        System.out.println("\tLen = " + len);
        for (int length = len; length >= 1; length--) {
            for (int i = 0; i < len - length + 1; i++) {
                for (int j = i + length - 1; j < len; j++) {
                    System.out.println("\tLength = " + length);
                    System.out.println("\tI = " + i);
                    System.out.println("\tJ = " + j);
                    boolean valid = true;
                    for (Character c : COUNT[i][j].keySet()) {
                        if (COUNT[i][j].get(c) < k) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) {
                        System.out.println("\ti = " + i + "; j = " + j);
                        System.out.println("\tMax str = " + s.substring(i, j+1));
                        System.out.println("\tMax len = " + length);
                        return length;
                    }
                }
            }
        }
        System.out.println("\tMax len = " + 0);
        return 0;
    }

    /**
     * Is Subsequence
     * Given a string s and a string t, check if s is subsequence of t.
     * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
     * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     * Example 1:
     * s = "abc", t = "ahbgdc"
     * Return true.
     * Example 2:
     * s = "axc", t = "ahbgdc"
     * Return false.
     * Follow up:
     * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
     */
    public static boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS > lenT) return false;

        int i = 0, j = 0;
        while(i < lenS && j < lenT) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == lenS;
    }

    /**
     * First Unique Character in a String
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * Examples:
     * s = "leetcode"
     *         return 0.
     * s = "loveleetcode",
     *         return 2.
     * Note: You may assume the string contain only lowercase letters.
     */
    public static void firstUniqCharDemo(String s) {
        System.out.println("\nStart function firstUniqCharDemo()");
        System.out.println("\tstr = " + s);
        System.out.println("\tFirst Uniq Char's index = " + firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> once = new LinkedHashMap<>(s.length(), .75F, false);
        HashSet<Character> multiple = new HashSet<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = chars[i];
            if (!multiple.contains(c)) {
                if (once.containsKey(c)) {
                    once.remove(c);
                    multiple.add(c);
                } else {
                    once.put(c, i);
                }
            }
        }
        Iterator iter = once.entrySet().iterator();
        if (iter.hasNext()) {
            return (int)((Map.Entry)iter.next()).getValue();
        } else {
            return -1;
        }
    }

    /**
     * Find the Difference
     * Given two strings s and t which consist of only lowercase letters.
     * String t is generated by random shuffling string s and then add one more letter at a random position.
     * Find the letter that was added in t.
     *         Example:
     * Input:
     * s = "abcd"
     * t = "abcde"
     * Output:
     * e
     * Explanation:
     *         'e' is the letter that was added.
     */
    public static void findTheDifferenceDemo(String s, String t) {
        System.out.println("\nStart function findTheDifferenceDemo()");
        System.out.println("\ts = " + s);
        System.out.println("\tt = " + t);
        System.out.println("\tAdded char = " + findTheDifference(s, t));
    }
    public static char findTheDifference(String s, String t) {
        HashMap<Character, Integer> S = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (S.containsKey(c)) {
                S.put(c, S.get(c) + 1);
            } else {
                S.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (S.containsKey(c) && S.get(c) > 0) {
                S.put(c, S.get(c) - 1);
            } else {
                return c;
            }
        }

        return '0';
    }

    /**
     * Decode String
     * Given an encoded string, return it's decoded string.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
     *
     * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
     *
     *         Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
     *
     * Examples:
     *
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */
    public static void decodeStringDemo(String s) {
        System.out.println("\nStart function decodeString()");
        System.out.println("\ts = " + s);
        System.out.println("\tRes = " + decodeString(s));
    }
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int index = 0;
        while (index < len) {
            Character c = s.charAt(index);
            if (Character.isLetter(c)) {
                sb.append(c);
                index++;
            } else if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count *= 10;
                    count += s.charAt(index) - '0';
                    index++;
                }

                int cut = findNextBrace(s, index);
                assert cut > index && cut < s.length();

                String sub = decodeString(s.substring(index + 1, cut));
                for (int i = 0; i < count; i++) {
                    sb.append(sub);
                }
                index = cut+1;
            } else {
                return "";
            }
        }
        return sb.toString();
    }
    private static int findNextBrace(String s, int start) {
        assert s.charAt(start) == '[';
        int left = 1;
        int right = 0;
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                left++;
            } else if (s.charAt(i) == ']') {
                right++;
            }
            if (right == left) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Mini Parser
     * Given a nested list of integers represented as a string, implement a parser to deserialize it.
     * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
     * Note: You may assume that the string is well-formed:
     *         • String is non-empty.
  *	• String does not contain white spaces.
     *         • String contains only digits 0-9, [, - ,, ].
     * Example 1:
     * Given s = "324",
     * You should return a NestedInteger object which contains a single integer 324.
     * Example 2:
     * Given s = "[123,[456,[789]]]",
     * Return a NestedInteger object containing a nested list with 2 elements:
     *         1. An integer containing value 123.
     *         2. A nested list containing two elements:
     * i.  An integer containing value 456.
     * ii. A nested list with one element:
     * a. An integer containing value 789.
     *
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
//    public NestedInteger deserialize(String s) {
//        NestedInteger ni = new NestedInteger();
//        if (s.charAt(0) != '[') {
//            ni.setInteger(Integer.parseInt(s));
//        } else {
//            String newS = s.substring(1, s.length() - 1);
//            List<String> nis = splitNestedInteger(newS);
//            for (String n : nis) {
//                ni.add(deserialize(n));
//            }
//        }
//        return ni;
//    }
    public static List<String> splitNestedInteger(String s) {
        List<String> res = new ArrayList<>();
        int cur = 0;
        int start = 0;
        int left = 0;
        int right = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) == '[') {
                left++;
            } else if (s.charAt(cur) == ']') {
                right++;
            } else if (s.charAt(cur) == ',') {
                if (left == right && start < cur) {
                    res.add(s.substring(start, cur));
                    start = cur + 1;
                }
            }
            cur++;
        }
        if (start < s.length()) {
            res.add(s.substring(start, cur));
        }
        return res;
    }

    /**
     * Reverse Vowels of a String
     * Write a function that takes a string as input and reverse only the vowels of a string.
     *
     * Example 1:
     * Given s = "hello", return "holle".
     *
     * Example 2:
     * Given s = "leetcode", return "leotcede".
     */
    public static String reverseVowels(String s) {
        System.out.println("\nStart function reverseVowels()");
        System.out.println("\ts = " + s);
        char[] chars = s.toCharArray();
        int len = s.length();
        int left = 0, right = len - 1;

        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            if (left < right) {
                char t = chars[left];
                chars[left] = chars[right];
                chars[right] = t;
                left++;
                right--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        System.out.println("\tRes = " + sb.toString());
        return sb.toString();
    }
    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    /**
     * Fizz Buzz
     * Write a program that outputs the string representation of numbers from 1 to n.
     *
     * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
     *
     * Example:
     *
     * n = 15,
     *
     * Return:
     *         [
     *         "1",
     *         "2",
     *         "Fizz",
     *         "4",
     *         "Buzz",
     *         "Fizz",
     *         "7",
     *         "8",
     *         "Fizz",
     *         "Buzz",
     *         "11",
     *         "Fizz",
     *         "13",
     *         "14",
     *         "FizzBuzz"
     *         ]
     */
    public static List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (Integer i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                res.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                res.add("Buzz");
            } else if (i % 5 == 0 && i % 3 == 0) {
                res.add("FizzBuzz");
            } else {
                res.add(i.toString());
            }
        }
        return res;
    }

    /**
     * Add Strings
     * Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.
     *
     * Note:
     *
     * The length of both num1 and num2 is < 5100.
     * Both num1 and num2 contains only digits 0-9.
     * Both num1 and num2 does not contain any leading zero.
     * You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */
    public static String addStrings2(String num1, String num2) {
        System.out.println("\nStart function reverseVowels()");
        System.out.println("\tnum1 = " + num1);
        System.out.println("\tnum2 = " + num2);
        Stack S1 = new Stack();
        Stack S2 = new Stack();
        for (char c : num1.toCharArray()) {
            S1.push((Integer)(c - '0'));
        }
        for (char c : num2.toCharArray()) {
            S2.push((Integer)(c - '0'));
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (!S1.isEmpty() || !S2.isEmpty()) {
            int sum = carry + (S1.isEmpty() ? 0 : (int)S1.pop()) + (S2.isEmpty() ? 0 : (int)S2.pop());
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        System.out.println("\tRes = " + sb.toString());
        return sb.toString();
    }

    /**
     * Longest Repeating Character Replacement
     * Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
     *
     * Note:
     * Both the string's length and k will not exceed 104.
     *
     * Example 1:
     *
     * Input:
     * s = "ABAB", k = 2
     *
     * Output:
     *         4
     *
     * Explanation:
     * Replace the two 'A's with two 'B's or vice versa.
     * Example 2:
     *
     * Input:
     * s = "AABABBA", k = 1
     *
     * Output:
     *         4
     *
     * Explanation:
     * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     */
    public static int characterReplacement(String s, int k) {
        System.out.println("\nStart function characterReplacement()");
        System.out.println("\ts = " + s + "; k = " + k);

        int len = s.length();
        if (len < 2) return len;

        char[] chars = s.toCharArray();
        int maxL = 0;
        int tempK = k;
        int nextStart = -1;
        int curStart = 0;
        int cur = 1;
        while (cur < len) {
            if (chars[cur] == chars[curStart]) {
                cur++;
            } else {
                if (tempK > 0) {
                    if (nextStart == -1) {
                        nextStart = cur;
                    }
                    tempK--;
                    cur++;
                } else {
                    maxL = Math.max(maxL, cur - curStart);
                    curStart = nextStart == -1 ? cur : nextStart;
                    cur = curStart + 1;
                    nextStart = -1;
                    tempK = k;
                }
            }
        }
        if (curStart != len) {
            maxL = Math.max(maxL, Math.min(len, len - curStart + tempK));
        }
        System.out.println("\tMaxLength = " + maxL);
        return maxL;
    }

    public static String originalDigits2(String s) {
        System.out.println("\nStart function originalDigits()");
        System.out.println("\ts = " + s);
        HashMap<Character, Integer> input = new HashMap<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            res.put(i, 0);
        }
        for (char c : s.toCharArray()) {
            if (input.containsKey(c)) {
                input.put(c, input.get(c) + 1);
            } else {
                input.put(c, 1);
            }
        }
        HashMap<Integer, HashMap<Character, Integer>> dict = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            if (i == 0) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('z', 1);
                newMap.put('e', 1);
                newMap.put('r', 1);
                newMap.put('o', 1);
                dict.put(0, newMap);
            } else if (i == 1) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('o', 1);
                newMap.put('n', 1);
                newMap.put('e', 1);
                dict.put(1, newMap);
            } else if (i == 2) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('t', 1);
                newMap.put('w', 1);
                newMap.put('o', 1);
                dict.put(2, newMap);
            } else if (i == 3) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('t', 1);
                newMap.put('h', 1);
                newMap.put('r', 1);
                newMap.put('e', 2);
                dict.put(3, newMap);
            } else if (i == 4) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('f', 1);
                newMap.put('o', 1);
                newMap.put('u', 1);
                newMap.put('r', 1);
                dict.put(4, newMap);
            } else if (i == 5) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('f', 1);
                newMap.put('i', 1);
                newMap.put('v', 1);
                newMap.put('e', 1);
                dict.put(5, newMap);
            } else if (i == 6) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('s', 1);
                newMap.put('i', 1);
                newMap.put('x', 1);
                dict.put(6, newMap);
            } else if (i == 7) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('s', 1);
                newMap.put('e', 2);
                newMap.put('v', 1);
                newMap.put('n', 1);
                dict.put(7, newMap);
            } else if (i == 8) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('e', 1);
                newMap.put('i', 1);
                newMap.put('g', 1);
                newMap.put('h', 1);
                newMap.put('t', 1);
                dict.put(8, newMap);
            } else if (i == 9) {
                HashMap<Character, Integer> newMap = new HashMap<>();
                newMap.put('n', 2);
                newMap.put('i', 1);
                newMap.put('e', 1);
                dict.put(9, newMap);
            }
        }

        boolean valid = originalDigitsDFS2(s.length(), input, res, dict);
        if (valid) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= 9; i++) {
                int count = res.get(i);
                while (count-- > 0) {
                    sb.append(i);
                }
            }
            System.out.println("\tRes = " + sb.toString());
            return sb.toString();
        } else {
            System.out.println("NA");
            return "NA";
        }
    }
    private static boolean originalDigitsDFS2(int count, HashMap<Character, Integer> input, HashMap<Integer, Integer> res, HashMap<Integer, HashMap<Character, Integer>> dict) {
        if (count == 0) {
            return true;
        }
//        HashMap<Character, Integer> oInput = (HashMap<Character, Integer>)input.clone();
        for (int i = 0; i <= 9; i++) {
            HashMap<Character, Integer> tInput = (HashMap<Character, Integer>)(input.clone());
            int tCount = 0;
            boolean skip = false;
            for (Character c : dict.get(i).keySet()) {
                if (!tInput.containsKey(c) || dict.get(i).get(c) > tInput.get(c)) {
                    skip = true;
                    break;
                } else {
                    tCount += dict.get(i).get(c);
                    tInput.put(c, tInput.get(c) - dict.get(i).get(c));
                }
            }
            if (!skip) {
                res.put(i, res.get(i) + 1);
                if (originalDigitsDFS2(count - tCount, tInput, res, dict)) {
                    return true;
                }
                res.put(i, res.get(i) - 1);
            }
        }
        return false;
    }
}