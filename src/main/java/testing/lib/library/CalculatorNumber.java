/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author yunl
 */
public class CalculatorNumber {
    // TODO: This question's implementation & test is moved to StringTest module

    private static class Result {
        Result(Integer v, Integer n) {
            val = new Integer(v);
            nextStart = new Integer(n);
        }
        
        Integer val;
        Integer nextStart;
    }
    
    private static Result getNextNumber(String str) {
        int len = str.length();
        if (str.charAt(0) == '(') {
            int leftCount = 1;
            int rightCount = 0;
            int index = 1;
            while (index < len) {
                if (str.charAt(index) == '(')
                    leftCount++;
                else if (str.charAt(index) == ')')
                    rightCount++;
                
                if (leftCount == rightCount)
                    break;
                index++;
            }
            return new Result(evaluate(str.substring(1, index)), index+1);
        } else {
            int end = 1;
            Integer tempRes = Character.getNumericValue(str.charAt(0));
            while (end < len) {
                Character tmpC = str.charAt(end);
                if (tmpC >= '0' && tmpC <= '9') {
                    end++;
                    tempRes *= 10;
                    tempRes += tmpC-'0';
                } else
                    break;
            }
            return new Result(tempRes, end);
        }
    }
  
    public static Integer evaluate(String str) {
        assert str != null : "Input str is null";
        int len = str.length();
        if (len == 0) return 0;
        
        if (str.charAt(0) == '-')
            return evaluate("0"+str);
        
        LinkedList<Integer> listNumb = new LinkedList<> ();
        LinkedList<Character> listOper = new LinkedList<> ();
        boolean getVal = true;
        int index = 0;
        while (index < len) {
            if (getVal) {
                Result tmpResult = getNextNumber(str.substring(index));
                listNumb.add(tmpResult.val);
                index += tmpResult.nextStart;
            } else {
                listOper.add(str.charAt(index));
                index++;
            }
            getVal = !getVal;
        }
        
        Iterator<Character> iterO = listOper.iterator();
        ListIterator<Integer> iterN = listNumb.listIterator();
        while (iterO.hasNext() && iterN.hasNext()) {
            Character oper = iterO.next();
            if (oper == '*' || oper == '/') {
                Integer n1 = iterN.next();
                Integer n2 = iterN.next();
                if (oper == '*')
                    n1 *= n2;
                else
                    n1 /= n2;
                
                iterO.remove();
                Integer nn1 = iterN.previous();
                Integer nn2 = iterN.previous();
                iterN.set(n1);
                Integer nn3 = iterN.next();
                Integer nn4 = iterN.next();
                iterN.remove();
            } else {
                iterN.next();
            }
        }
        
        Integer res = listNumb.getFirst();
        iterO = listOper.iterator();
        iterN = listNumb.listIterator(1);
        while (iterO.hasNext() && iterN.hasNext()) {
            Integer n2 = iterN.next();
            if (iterO.next() == '+') {
                res += n2;
            } else {
                res -= n2;
            }
        }
        
        return res;
    }
    
//    public static Integer evaluate(String str) {
//        assert str != null : "Input str is null";
//        int len = str.length();
//        if (len == 0) return 0;
//        
//        if (str.charAt(0) == '-')
//            return evaluate("0"+str);
//        
//        LinkedList<Integer> listNumb = new LinkedList<> ();
//        LinkedList<Character> listOper = new LinkedList<> ();
//        boolean getVal = true;
//        int index = 0;
//        while (index < len) {
//            if (getVal) {
//                Result tmpResult = getNextNumber(str.substring(index));
//                listNumb.add(tmpResult.val);
//                index += tmpResult.nextStart;
//            } else {
//                listOper.add(str.charAt(index));
//                index++;
//            }
//            getVal = !getVal;
//        }
//        
//        for (int io = 0, in = 0; io < listOper.size() && in < listNumb.size(); io++, in++) {
//            Character oper = listOper.get(io);
//            if (oper == '*' || oper == '/') {
//                Integer n1 = listNumb.get(in);
//                Integer n2 = listNumb.get(in+1);
//                if (oper == '*')
//                    n1 *= n2;
//                else
//                    n1 /= n2;
//                
//                listNumb.set(in, n1);
//                listNumb.remove(in+1);
//                listOper.remove(io);
//                in--;
//                io--;
//            }
//        }
//        
//        Integer res = listNumb.getFirst();
//        for (int i = 0; i < listOper.size(); i++) {
//            Integer v2 = listNumb.get(i+1);
//            if (listOper.get(i) == '+') {
//                res += v2;
//            } else {
//                res -= v2;
//            }
//        }
//        
//        return res;
//    }
    
//    public static Integer evaluate(String str) {
//        assert str != null : "Input str is null";
//        int len = str.length();
//        if (len == 0) return 0;
//        
//        if (str.charAt(0) == '-')
//            return evaluate("0"+str);
//        
//        LinkedList<Object> list = new LinkedList<> ();
//        boolean getVal = true;
//        int index = 0;
//        while (index < len) {
//            if (getVal) {
//                Result tmpResult = getNextNumber(str.substring(index));
//                list.add(tmpResult.val);
//                getVal = false;
//                index += tmpResult.nextStart;
//            } else {
//                list.add(str.charAt(index));
//                getVal = true;
//                index++;
//            }
//        }
//        
//        for (int i = 1; i+1 < list.size(); i+=2) {
//            if ((Character)list.get(i) == '*' || (Character)list.get(i) == '/') {
//                Integer v1 = (Integer)list.get(i-1);
//                Integer v2 = (Integer)list.get(i+1);
//                if ((Character)list.get(i) == '*')
//                    v1 *= v2;
//                else
//                    v1 /= v2;
//                
//                list.set(i-1, v1);
//                list.remove(i+1);
//                list.remove(i);
//                i-=2;
//            }
//        }
//        
//        Integer res = (Integer)list.getFirst();
//        for (int i = 1; i+1 < list.size(); i+=2) {
//            Integer v2 = (Integer)list.get(i+1);
//            if ((Character)list.get(i) == '+') {
//                res += v2;
//            } else {
//                res -= v2;
//            }
//        }
//        
//        return res;
//    }
}
