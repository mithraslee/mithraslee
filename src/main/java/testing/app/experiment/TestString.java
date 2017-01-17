package testing.app.experiment;

import testing.lib.string.StringTest;

import java.util.*;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestString {
    @SuppressWarnings("empty-statement")
    public static void run() {
        String s1 = "01aba56abcd123.";
        String s2_1 = "abcd";
        String s2_2 = "abcw";
        StringTest.strStrDemo(s1, s2_1);
        StringTest.strStrDemo(s1, s2_2);

        String s3 = "abcd";
        String s4 = "abcde";
        StringTest.reverseDemo(s3);
        StringTest.reverseDemo(s4);

        System.out.println("\tA" + " <=> " + StringTest.mergeReverse("A"));
        System.out.println("\tAB" + " <=> " + StringTest.mergeReverse("AB"));
        System.out.println("\tABC" + " <=> " + StringTest.mergeReverse("ABC"));
        System.out.println("\tABCD" + " <=> " + StringTest.mergeReverse("ABCD"));

        String s5 = "123456789";
        int k = (int)(Math.random() * s5.length()) + 1;
        StringTest.rightShift(s5, k);

        String s6 = "I have a dream that one day";
        StringTest.reverseByWord(s6);
        StringTest.reverseByWord2(s6);

        String s7 = "123 45 67 890";
        String s8 = "12 345 678";
        StringTest.reverseByDoubleWord(s7);
        StringTest.reverseByDoubleWord(s8);

        String s9 = "abcdefg";
        String s10 = "cdg";
        StringTest.strCom(s9, s10);

        String s13 = "abcdefg";
        String s14 = "cdg";
        System.out.println("\nStrDisCom(\"" + s13 + "\", \"" + s14 + "\") = \"" + StringTest.strDisCom(s13, s14) + "\"");
        System.out.println("\nstrDisComInOrder(\"" + s13 + "\", \"" + s14 + "\") = \"" + StringTest.strDisComInOrder(s13, s14) + "\"");

        String s11 = "abc";
        StringTest.printWithAllUpperLowerCases(s11);

        int size = 2;
        Integer [] num = new Integer[size];
        for (int i = 0; i < size; i++) {
            num[i] = (int)(Math.random() * 10);
        }
        StringTest.telephoneOutput(num);

        StringTest.letterCombinations("25");

        StringTest.printSubSet(s11);

        StringTest.printSubSetByBitmap(s11);

        StringTest.printSubSetOfSizeK(s11, 2);

        StringTest.getPermutationsDemo(s11);

        StringTest.getPermutationsWithDupCharacterDemo(s11);
        StringTest.getPermutationsWithDupCharacterDemo("aabbc");

        StringTest.printSubSetPermution(s11);

        StringTest.printPar(3);

        Integer [] a = {5, 7, 3, -8, 1};
        StringTest.findSigns(a);

        String s12 = "123456";
        StringTest.strToInt(s12);

        int n1 = 321;
        StringTest.intToStr(n1);

        String s15 = "abcdef";
        String s16 = "cd";
        String s17 = "_C_D_";
        StringTest.replaceSubstring(s15, s16, s17);

        String s18 = "abcdefghijklmnop";
        String s19 = "abc defg hijkl klmnop mnop";
        StringTest.longestDupDemo(s18, s19);

        String s20 = "fabajtejetaddfafgffgfadf";
        StringTest.longestPalindrome(s20);
        StringTest.longestPalindromeDP(s20);
        StringTest.longestPalindromeDP2(s20);

        StringTest.shortestPalindrome("aacecaaa");

        StringTest.longestPalindromePossible("bb");
        StringTest.longestPalindromePossible("abccccdd");
        StringTest.longestPalindromePossible("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");

        StringTest.generatePalindromesDemo("aabb");
        StringTest.generatePalindromesDemo("aabbbbc");
        StringTest.generatePalindromesDemo("abc");

        String s21 = "fabajtejetaddfafgffgfadf";
        String s22 = "aaaaaa";
        String s23 = "abcabce";
        String s24 = "aabbcc";
        StringTest.removeDuplicates(s21);
        StringTest.removeDuplicates(s22);
        StringTest.removeDuplicates(s23);
        StringTest.removeDuplicates(s24);

        String s25 = "abc";
        String s26 = "123";
        String s27 = "1ab23c";
        StringTest.isShuffled(s25, s26, s27);
        StringTest.isInterleave("aa", "ab", "abaa");
        StringTest.isInterleave2("aa", "ab", "abaa");

        String s28 = "catsanddog";
        HashSet<String> dict = new HashSet<> (Arrays.asList("cat", "cats", "and", "sand", "dog"));
        StringTest.wordBreak(s28, dict);
        StringTest.wordBreak2(s28, dict);
        StringTest.wordBreak3(s28, dict);
        StringTest.wordBreak4(s28, dict);

        StringTest.findAllConcatenatedWordsInADict(new String[]{
                "cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"
        });

        String s29 = "aabbaa";
        StringTest.PalindromePartitioning(s29);

        String s30 = "ab";
        String s31 = "ba";
        StringTest.isScrambleDemo(s30, s31);
        StringTest.isScrambleDemo("grate", "rgtae");
        StringTest.isScrambleDemo("great", "rgeat");

        Character[][] board = new Character[][] {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        StringTest.exist(board, "ABCCED");
        StringTest.exist2(board, "ABCCED");
        StringTest.exist(board, "SEE");
        StringTest.exist2(board, "SEE");
        StringTest.exist(board, "ABCB");
        StringTest.exist2(board, "ABCB");
        StringTest.exist(board, "CFBASADEESE");
        StringTest.exist2(board, "CFBASADEESE");

        Character[][] board2 = new Character[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[] {"oath","oathk","pea","eat","rain"};
        StringTest.findWords(board2, words);
        StringTest.findWords2(board2, words);

        StringTest.multiply("123", "456");
        StringTest.multiply("0", "52");

        String ms1 = "634";
        String ms2 = "1332";
        StringTest.multiplyStrings(ms1, ms2);
        StringTest.multiplyStrings("0", "52");

        String[] strs = new String[] {"abs", "sab", "tee", "loag", "shirt", "thirs", "bas", "goal"};
        StringTest.anagrams(strs);
        StringTest.anagrams2(strs);

        StringTest.countAndSay(8);
        StringTest.countAndSay2(5);

        StringTest.isMatch("aa","a");
        //StringTest.isMatch2("aa","a");
        StringTest.isMatch("aaa","aa*");
        //StringTest.isMatch2("aaa","aa*");
        StringTest.isMatch("aa","a*");
        //StringTest.isMatch2("aa","a*");
        StringTest.isMatch("aa",".*");
        //StringTest.isMatch2("aa",".*");
        StringTest.isMatch("aab", "c*a*b");
        //StringTest.isMatch2("aab", "c*a*b");

        StringTest.isMatch_wildCard_Recursive_Demo("aa", "*");
        StringTest.isMatch_wildCard_Recursive_Demo("aa", "aaa");
        StringTest.isMatch_wildCard_Recursive_Demo("ab", "?*");
        StringTest.isMatch_wildCard_Recursive_Demo("aab", "c*a*b");
        StringTest.isMatch_WildCard_Iterative_Demo("aa", "*");
        StringTest.isMatch_WildCard_Iterative_Demo("aa", "aaa");
        StringTest.isMatch_WildCard_Iterative_Demo("ab", "?*");
        StringTest.isMatch_WildCard_Iterative_Demo("aab", "c*a*b");

        StringTest.isMatch_RegularExpression_Demo("aaabc", "a*a.*");
        StringTest.isMatch_RegularExpression_Demo2("aaabc", "a*a.*");
        StringTest.isMatch_RegularExpression_Demo3("aaabc", "a*a.*");
        StringTest.isMatch_RegularExpression_Demo("aaabc", "a*a.*c*");
        StringTest.isMatch_RegularExpression_Demo2("aaabc", "a*a.*c*");
        StringTest.isMatch_RegularExpression_Demo3("aaabc", "a*a.*c*");

        StringTest.minCut("ab");
        StringTest.minCut2("ab");
        StringTest.minCut3("ab");
        StringTest.minCut("abadef");
        StringTest.minCut2("abadef");
        StringTest.minCut3("abadef");
        StringTest.minCut("aacaabee");
        StringTest.minCut2("aacaabee");
        StringTest.minCut3("aacaabee");

        StringTest.restoreIpAddresses("25525511135");

        StringTest.minWindow("bba", "ab");
        StringTest.minWindow2("bba", "ab");
        StringTest.minWindow("bba", "aabccc");
        StringTest.minWindow2("bba", "aabccc");
        StringTest.minWindow("aabcbcc", "bba");
        StringTest.minWindow2("aabcbcc", "bba");
        StringTest.minWindow("cfcccbbeeetacaahibjka", "aabcc");
        StringTest.minWindow2("cfcccbbeeetacaahibjka", "aabcc");
        StringTest.minWindow("ADOBECODEBANC", "ABC");
        StringTest.minWindow2("ADOBECODEBANC", "ABC");

        String Input = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String [] Input2 = new String [] {"fooo","barr","wing","ding","wing"};
        StringTest.findSubstring2(Input, Input2);
        StringTest.findSubstring2("barfoothefoobarman", new String [] {"foo", "bar"});

        StringTest.numDecodingDemo("12");
        StringTest.numDecodingDemo2("12");
        StringTest.numDecodingDemo("124");
        StringTest.numDecodingDemo2("124");
        StringTest.numDecodingDemo("12920123810524");
        StringTest.numDecodingDemo2("12920123810524");

        String zigZagTest = "ABCDEFGHIJKLMNOPQRSTUV";
        int nRows = 4;
        StringTest.zigZagConvert(zigZagTest, nRows);
        StringTest.zigZagConvert("PAYPALISHIRING", 3);

        HashSet<String> set = new HashSet<> ();
        set.add("a");
        set.add("b");
        set.add("c");
        StringTest.ladderLength("a", "c", set);

        String start = "hit";
        String end = "cog";
        HashSet<String> dict2 = new HashSet<>();
        dict2.add("hot");
        dict2.add("dot");
        dict2.add("dog");
        dict2.add("lot");
        dict2.add("log");
        dict2.add("low");
        dict2.add("cow");
        dict2.add("con");
        dict2.add("hat");
        dict2.add("cog");

        StringTest.ladderLength(start, end, (HashSet<String>)dict2.clone());
        StringTest.ladderLength2(start, end, (HashSet<String>)dict2.clone());
        StringTest.ladderLength3(start, end, (HashSet<String>)dict2.clone());
        StringTest.ladderLength4(start, end, (HashSet<String>)dict2.clone());

        StringTest.findLadders(start, end, (HashSet<String>)dict2.clone());
        StringTest.findLadders1(start, end, (HashSet<String>)dict2.clone());
        StringTest.findLadders2(start, end, (HashSet<String>)dict2.clone());
        StringTest.findLadders3(start, end, (HashSet<String>)dict2.clone());
        StringTest.findLadders4(start, end, (HashSet<String>)dict2.clone());

//        try {
//            int M = 1;
////            long []runningTime1 = new long[M];
////            List<List<String>> res1 = (List<List<String>>)TestUtility.callMethodWithTimeReturn(StringTest.class.getDeclaredMethod("findLadders", String.class, String.class, Set.class), new Object[]{null, start, end, (HashSet<String>)dict2.clone(), runningTime1});
////            System.out.println("\nBy findLadders DFS DiffByOne: There are " + res1.size() + " ladders from " + start + " to " + end + ":");
//////            for (List<String> list : res1) {
//////                System.out.println("\t" + list);
//////            }
////
////            long []runningTime1_2 = new long[M];
////            List<List<String>> res1_2 = (List<List<String>>)TestUtility.callMethodWithTimeReturn(StringTest.class.getDeclaredMethod("findLadders1", String.class, String.class, Set.class), new Object[]{null, start, end, (HashSet<String>)dict2.clone(), runningTime1_2});
////            System.out.println("\nBy findLadders1 DFS Non-DiffByOne: There are " + res1_2.size() + " ladders from " + start + " to " + end + ":");
//////            for (List<String> list : res1) {
//////                System.out.println("\t" + list);
//////            }
//
////            long []runningTime2 = new long[M];
////            List<List<String>> res2 = (List<List<String>>)TestUtility.callMethodWithTimeReturn(StringTest.class.getDeclaredMethod("findLadders2", String.class, String.class, Set.class), new Object[]{null, start, end, (HashSet<String>)dict2.clone(), runningTime2});
////            System.out.println("\nBy findLadders2 BFS No lowestLevel: There are " + res2.size() + " ladders from " + start + " to " + end + ":");
////            for (List<String> list : res2) {
////                System.out.println("\t" + list);
////            }
//
//            long []runningTime3 = new long[M];
//            List<List<String>> res3 = (List<List<String>>)TestUtility.callMethodWithTimeReturn(StringTest.class.getDeclaredMethod("findLadders3", String.class, String.class, Set.class), new Object[]{null, start, end, (HashSet<String>)dict2.clone(), runningTime3});
//            System.out.println("\nBy findLadders3 BFS lowestLevel: There are " + res3.size() + " ladders from " + start + " to " + end + ":");
//            Iterator<List<String>> iter = res3.iterator();
//            while (iter.hasNext()) {
//                System.out.println("\t" + iter.next());
//            }
//
//            long []runningTime4 = new long[M];
//            List<List<String>> res4 = (List<List<String>>)TestUtility.callMethodWithTimeReturn(StringTest.class.getDeclaredMethod("findLadders4", String.class, String.class, Set.class), new Object[]{null, start, end, (HashSet<String>)dict2.clone(), runningTime4});
//            System.out.println("\nBy findLadders4 BFS lowestLevel: There are " + res4.size() + " ladders from " + start + " to " + end + ":");
//            for (List<String> list : res4) {
//                System.out.println("\t" + list);
//            }
//
////            long TN1_Average = runningTime1[0];
////            long TN1_2_Average = runningTime1_2[0];
////            long TN2_Average = runningTime2[0];
//            long TN3_Average = runningTime3[0];
//            long TN4_Average = runningTime4[0];
//            for (int i = 1; i < M; i++) {
////                TN1_Average = (long)((double)i/(i+1) * (double)runningTime1[i] + 1.0/(double)(i+1) * (double)runningTime1[i]);
////                TN1_2_Average = (long)((double)i/(i+1) * (double)runningTime1_2[i] + 1.0/(double)(i+1) * (double)runningTime1_2[i]);
////                TN2_Average = (long)((double)i/(i+1) * (double)runningTime2[i] + 1.0/(double)(i+1) * (double)runningTime2[i]);
//                TN3_Average = (long)((double)i/(i+1) * (double)runningTime3[i] + 1.0/(double)(i+1) * (double)runningTime3[i]);
//                TN4_Average = (long)((double)i/(i+1) * (double)runningTime4[i] + 1.0/(double)(i+1) * (double)runningTime4[i]);
//            }
////            System.out.println("Average time for findLadders:  " + TN1_Average);
////            System.out.println("Average time for findLadders1: " + TN1_2_Average);
////            System.out.println("Average time for findLadders2: " + TN2_Average);
//            System.out.println("Average time for findLadders3: " + TN3_Average);
//            System.out.println("Average time for findLadders4: " + TN4_Average);
//        } catch (NoSuchMethodException | SecurityException ex) {
//            Logger.getLogger(TestApp.class.getName()).log(Level.SEVERE, null, ex);
//        }

        String path1 = "/home/";
        String path2 = "/a/./b/../../c/";
        String path3 = "/../";
        String path4 = "/home//foo/";
        StringTest.simplifyPath(path1);
        StringTest.simplifyPath2(path1);
        StringTest.simplifyPath(path2);
        StringTest.simplifyPath2(path2);
        StringTest.simplifyPath(path3);
        StringTest.simplifyPath2(path3);
        StringTest.simplifyPath(path4);
        StringTest.simplifyPath2(path4);

        String testStr = "   the    sky   is  blue  ";
        StringTest.reverseWords(testStr);
        StringTest.reverseWords(testStr.toCharArray());
        String testStr1 = "the    sky   is  blue";
        StringTest.reverseWords(testStr1);
        StringTest.reverseWords(testStr1.toCharArray());

        String S1 = "ABABC";
        String T1 = "ABCBA";
        StringTest.longestCommonSubstring(S1, T1);

        String strToBeAdjust = "       This  is a teapot plate   ";
        StringTest.textJustification(strToBeAdjust, 4);

        String [] words1 = new String[]{"This", "is", "an", "example", "of", "text", "justification.", "func", "usage"};
        StringTest.fullJustify(words1, 16);

        HashMap<Integer, Character> intToDna = new HashMap<> ();
        intToDna.put(0, 'A');
        intToDna.put(1, 'T');
        intToDna.put(2, 'C');
        intToDna.put(3, 'G');
        StringBuilder dna = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            int n = (int)(Math.random() * 4);
            dna.append(intToDna.get(n));
        }
        StringTest.repeatedDNASubstring(dna.toString(), 10);
        StringTest.repeatedDNASubstring("ATCGACGACTTGAATGTGTTACCTTG", 3);
        StringTest.repeatedDNASubstring("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", 10);

        StringTest.fractionToDecimal(1, 1000);
        StringTest.fractionToDecimal2(1, 1000);
        StringTest.fractionToDecimal(20, 6);
        StringTest.fractionToDecimal2(20, 6);
        StringTest.fractionToDecimal(1, 2);
        StringTest.fractionToDecimal2(1, 2);
        StringTest.fractionToDecimal(2, 1);
        StringTest.fractionToDecimal2(2, 1);
        StringTest.fractionToDecimal(2, 3);
        StringTest.fractionToDecimal2(2, 3);
        StringTest.fractionToDecimal(-2, 3);
        StringTest.fractionToDecimal2(-2, 3);
        StringTest.fractionToDecimal(-1, -2147483648);
        StringTest.fractionToDecimal2(-1, -2147483648);

        StringTest.convertToTitle(26);
        StringTest.convertToTitle2(26);
        StringTest.convertToTitle(27);
        StringTest.convertToTitle2(27);
        StringTest.convertToTitle(30);
        StringTest.convertToTitle2(30);
        StringTest.convertToTitle(51);
        StringTest.convertToTitle2(51);
        StringTest.convertToTitle(52);
        StringTest.convertToTitle2(52);
        StringTest.convertToTitle(53);
        StringTest.convertToTitle2(53);
        StringTest.convertToTitle(1000);
        StringTest.convertToTitle2(1000);

        String s = "abacb";
        String t = "xmxum";
        System.out.println("\n" + s + " & " + t + " isIsomorphic? " + StringTest.isIsomorphic(s, t));
        System.out.println("\n" + s + " & " + t + " isIsomorphic2? " + StringTest.isIsomorphic2(s, t));
        System.out.println("\n" + s + " & " + t + " isIsomorphic3? " + StringTest.isIsomorphic3(s, t));

        String f1 = "1 + 1";
        String f2 = " 2-1 + 2 ";
        String f3 = "(1+(4+5+2)-3)+(6+8)";
        String f4 = "2-(5-6)";
        StringTest.calculate2(f1);
        StringTest.calculate2(f2);
        StringTest.calculate2(f3);
        StringTest.calculate2(f4);

        StringTest.calculatDemo3(f1);
        StringTest.calculatDemo3(f2);
        StringTest.calculatDemo3(f3);
        StringTest.calculatDemo3(f4);

        String f11 = "3+2*2";
        String f12 = " 3/2 ";
        String f13 = " 3/ 2 ";
        String f14 = " 3+5 / 2 ";
        String f15 = " 3 +5 / 2 ";
        String f16 = "2*3*4";
        StringTest.calculateIIDemo(f11);
        StringTest.calculateIIDemo(f12);
        StringTest.calculateIIDemo(f13);
        StringTest.calculateIIDemo(f14);
        StringTest.calculateIIDemo(f15);
        StringTest.calculateIIDemo(f16);

        StringTest.calculateIIDemo2(f11);
        StringTest.calculateIIDemo2(f12);
        StringTest.calculateIIDemo2(f13);
        StringTest.calculateIIDemo2(f14);
        StringTest.calculateIIDemo2(f15);
        StringTest.calculateIIDemo2(f16);

        String f31 = "(3+2)*2";
        String f32 = "3+(2*2)";
        String f33 = "(3+2*2)";
        String f34 = " 3/2 ";
        String f35 = " 3+5 / 2 ";
        String f36 = "(1 +(4+ 5 *2 ) -3)* ( 6+8)";
        String f37 = " ( 1* (4 + 5 + 2 ) -3) -(6 +8 )  ";
        String f38 = "2-(5-6)";
        String f39 = "2*(5-6)";
        StringTest.calculateIIIDemo2(f31);
        StringTest.calculateIIIDemo2(f32);
        StringTest.calculateIIIDemo2(f33);
        StringTest.calculateIIIDemo2(f34);
        StringTest.calculateIIIDemo2(f35);
        StringTest.calculateIIIDemo2(f36);
        StringTest.calculateIIIDemo2(f37);
        StringTest.calculateIIIDemo2(f38);
        StringTest.calculateIIIDemo2(f39);

        StringTest.calculateIIIDemo3(f31);
        StringTest.calculateIIIDemo3(f32);
        StringTest.calculateIIIDemo3(f33);
        StringTest.calculateIIIDemo3(f34);
        StringTest.calculateIIIDemo3(f35);
        StringTest.calculateIIIDemo3(f36);
        StringTest.calculateIIIDemo3(f37);
        StringTest.calculateIIIDemo3(f38);
        StringTest.calculateIIIDemo3(f39);

        StringTest.calculateIIIDemo4(f31);
        StringTest.calculateIIIDemo4(f32);
        StringTest.calculateIIIDemo4(f33);
        StringTest.calculateIIIDemo4(f34);
        StringTest.calculateIIIDemo4(f35);
        StringTest.calculateIIIDemo4(f36);
        StringTest.calculateIIIDemo4(f37);
        StringTest.calculateIIIDemo4(f38);
        StringTest.calculateIIIDemo4(f39);

        StringTest.diffWaysToCompute("2-1-1");
        StringTest.diffWaysToCompute("2*3-4*5");

        StringTest.numberToWords(12345);
        StringTest.numberToWords(1234567);
        StringTest.numberToWords(1000010);

        StringTest.wordPattern("abba", "dog cat cat dog");
        StringTest.wordPatternMatch("aba", "xxyyyxx");
        StringTest.wordPatternMatch("abab", "redblueredblue");
        StringTest.wordPatternMatch("aaaa", "asdasdasdasd");
        StringTest.wordPatternMatch("aabb", "xyzabcxzyabc");

        StringTest.generatePossibleNextMoves("++");
        StringTest.generatePossibleNextMoves("+++");
        StringTest.generatePossibleNextMoves("++++");

        StringTest.canWinDemo("+++");
        StringTest.canWinDemo("++++");
        StringTest.canWinDemo("+++++");
        StringTest.canWinDemo("+++-++");

        StringTest.addOperators("123", 6);
        StringTest.addOperators("232", 8);
        StringTest.addOperators("105", 5);
        StringTest.addOperators("00", 0);
        StringTest.addOperators("3456237490", 9191);

        StringTest.addOperators2("123", 6);
        StringTest.addOperators2("232", 8);
        StringTest.addOperators2("105", 5);
        StringTest.addOperators2("00", 0);
        StringTest.addOperators2("3456237490", 9191);

        StringTest.addOperators3("123", 6);
        StringTest.addOperators3("232", 8);
        StringTest.addOperators3("105", 5);
        StringTest.addOperators3("00", 0);
        StringTest.addOperators3("3456237490", 9191);

        StringTest.removeInvalidParentheses("()())");
        StringTest.removeInvalidParentheses("()())()");
        StringTest.removeInvalidParentheses("(a)())()");
        StringTest.removeInvalidParentheses(")(");
        StringTest.removeInvalidParentheses("(r(()()(");

        StringTest.isAdditiveNumber("112358");
        StringTest.isAdditiveNumber("199100199");
        StringTest.isAdditiveNumber("1023");
        StringTest.isAdditiveNumber("101");
        StringTest.isAdditiveNumber("0");
        StringTest.isAdditiveNumber("10");
        StringTest.isAdditiveNumber("123");

        StringTest.removeDuplicateLetters("cbacdcbc");

        StringTest.isValidSerializationDemo("9,3,4,#,#,1,#,#,2,#,6,#,#");
        StringTest.isValidSerializationDemo("1,#");
        StringTest.isValidSerializationDemo("9,#,#,1");
        StringTest.isValidSerializationDemo("9,19,#,#,9,19,#,9,9,#,9,#,#,9,#,9,#,#,39,#,#");

        StringTest.removeKdigits("1432219", 3);
        StringTest.removeKdigits2("1432219", 3);

        StringTest.repeatedSubstringPatternDemo("abab");
        StringTest.repeatedSubstringPatternDemo("bb");
        StringTest.repeatedSubstringPatternDemo("aba");
        StringTest.repeatedSubstringPatternDemo("aabaaba");

        StringTest.longestSubstring("aaabb", 3);
        StringTest.longestSubstring("aaabbb", 3);
        StringTest.longestSubstring("abcdedghijklmnopqrstuvwxyz", 1);
        StringTest.longestSubstring("aaabb", 4);
        StringTest.longestSubstring("ababbc", 2);
        StringTest.longestSubstring("acbaabe", 2);

        StringTest.firstUniqCharDemo("leetcode");
        StringTest.firstUniqCharDemo("loveleetcode");

        StringTest.findTheDifferenceDemo("abcd", "bdaec");

        StringTest.decodeStringDemo("3[a]2[bc]");
        StringTest.decodeStringDemo("3[a2[c]]");
        StringTest.decodeStringDemo("2[abc]3[cd]ef");
        StringTest.decodeStringDemo("100[leetcode]");

        System.out.println("0".compareTo("01"));

        System.out.println("splitNestedInteger(\"123,[456,[789]]\" = " + StringTest.splitNestedInteger("123,[456,[789]]"));

        StringTest.reverseVowels("leetcode");

        StringTest.addStrings2("1234", "567");

        StringTest.characterReplacement("ABAB", 2);
        StringTest.characterReplacement("AABABBA", 1);
        StringTest.characterReplacement("ABABB", 2);
        StringTest.characterReplacement("AAAB", 0);

        StringTest.frequencySort("tree");
        StringTest.frequencySort2("tree");
        StringTest.frequencySort("Aabb");
        StringTest.frequencySort2("Aabb");

        StringTest.findAnagrams("cbaebabacd", "abc");
        StringTest.findAnagrams("abab", "ab");

        StringTest.countSegments("Hello, my name is John k");
        StringTest.countSegments(" Hello, my name is John k ");
        StringTest.countSegments(" Hello, my name is John k  ");

        StringTest.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");

        StringTest.validIPAddressDemo("172.16.254.1");
        StringTest.validIPAddressDemo("172.16.254.01");
        StringTest.validIPAddressDemo("256.256.256.256");
        StringTest.validIPAddressDemo("2001:0db8:85a3:0:0:8A2E:0370:7334");
        StringTest.validIPAddressDemo("2001:0db8:85a3:0000:0000:8A2E:0370:7334");
        StringTest.validIPAddressDemo("2001:0db8:85a3::8A2E:0370:7334");
        StringTest.validIPAddressDemo("02001:0db8:85a3:0000:0000:8a2e:0370:7334");
        StringTest.validIPAddressDemo("02001:0db8:85a3:0000:0000:8a2e:0370:7334");
        StringTest.validIPAddressDemo("2001:0db8:85a3:0:0:8A2E:0370:7334:");

//        StringTest.originalDigits("owoztneoer");
//        StringTest.originalDigits2("owoztneoer");
        StringTest.originalDigits("fviefuro");
//        StringTest.originalDigits2("fviefuro");

        StringTest.encodeDecodeStringsDemo(new ArrayList<String>(Arrays.asList(new String[]{"Hello", "my name", "is", "John", "k"})));

        StringTest.magicalString(6);

        StringTest.validWordSquareDemo(new ArrayList<>(Arrays.asList(new String[]{
                "ball",
                "area",
                "read",
                "lady"
        })));
        StringTest.validWordSquareDemo(new ArrayList<>(Arrays.asList(new String[]{
                "abcd",
                "bnrt",
                "crm",
                "dt"
        })));

        StringTest.wordSquares(new String[]{
                "abat","baba","atan","atal"
        });
        StringTest.wordSquares(new String[]{
                "area","lead","wall","lady","ball"
        });
        StringTest.wordSquares(new String[]{
                "abaa","aaab","baaa","aaba"
        });

//        StringTest.validWordAbbreviationDemo("internationalization", "i12iz4n");
        StringTest.validWordAbbreviationDemo("internationalization", "i5a11o1");
//        StringTest.validWordAbbreviationDemo("apple", "a2e");

        StringTest.generateAbbreviations2("word");
        StringTest.generateAbbreviations3("word");

        StringTest.licenseKeyFormattingDemo("abcd", 3);
        StringTest.licenseKeyFormattingDemo("abcd", 4);
        StringTest.licenseKeyFormattingDemo("ab-cd-ef", 3);
        StringTest.licenseKeyFormattingDemo("abc-def", 4);
        StringTest.licenseKeyFormattingDemo("2-4A0r7-4k", 3);
        StringTest.licenseKeyFormattingDemo("2-4A0r7-4k", 4);

        StringTest.lengthOfLongestSubstringTwoDistinct("");
        StringTest.lengthOfLongestSubstringTwoDistinct("e");
        StringTest.lengthOfLongestSubstringTwoDistinct("ee");
        StringTest.lengthOfLongestSubstringTwoDistinct("eec");
        StringTest.lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
