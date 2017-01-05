/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.library;

import java.util.HashMap;

/**
 *
 * @author mithr_000
 */
public class CalculatorLogic {
    public CalculatorLogic (String f1, String f2) {
        formulor1 = "A|B&(C^D)&E".toUpperCase();
        formulor2 = "(A|D)^B&E^C".toUpperCase();
        map = new HashMap<> ();
    }
    private boolean calculate(boolean a, boolean b, Character o) {
        if (o == '|')
            return a|b;
        else if (o == '&')
            return a&b;
        else if (o == '^')
            return a^b;
        else
            return false;
    }

    public boolean getResult(Boolean a, Boolean b, Boolean c, Boolean d, Boolean e) {
        map.put('A', a);
        map.put('B', b);
        map.put('C', c);
        map.put('D', d);
        map.put('E', e);

        boolean e1 = evaluate(formulor1);
        System.out.println("e1: " + e1);
        System.out.println(a|b&(c^d)&e);
        
        boolean e2 = evaluate(formulor2);
        System.out.println("e2: " + e2);
        System.out.println((a|d)^b&e^c);
//        return calculate(e1, e2, '&');
        return e2;
    }

    class Result {
        Result(boolean v, int n) {
            val = v;
            nextStart = n;
        }
        public boolean val;
        public int nextStart;
    }
    private Result getNextVal(String formulor) {
        int len = formulor.length();
        if (0 >= len) {
            return null;
        }
        boolean revert = false;
        if (formulor.charAt(0) == '!') {
            revert = true;   
        }
        int nextStart = 0;
        boolean tempRes;
        if (formulor.charAt(revert?1:0) == '(') {
            int lastRight = formulor.lastIndexOf(')');
            tempRes = evaluate(formulor.substring(revert?2:1, lastRight));
            nextStart = lastRight+1;
        } else {
            tempRes = map.get(formulor.charAt(revert?1:0));
            nextStart = revert?2:1;
        }
        if (revert) {
            tempRes = !tempRes;
        }
        return new Result(tempRes, nextStart);
    }
    private Character getNextOpt(String formulor) {
        int len = formulor.length();
        if (0 >= len) {
            return null;
        }
        char c = formulor.charAt(0);
        if (c == '&' || c == '|' || c == '^') {
            return c;
        } else {
            return null;
        }
    }
    private boolean evaluate (String str) {
        Boolean res = null;
        Boolean nextVal = null;
        Character operator = null;
        
        int len = str.length();
        int index = 0;
        while (index < len) {
            Character tmpOpt = getNextOpt(str.substring(index));
            if (tmpOpt == null) {
                Result tmp = getNextVal(str.substring(index));
                if (res == null) {
                    res = tmp.val;
                } else {
                    nextVal = tmp.val;
                }
                index += tmp.nextStart;
            } else {
                operator = tmpOpt;
                index++;
            }
            if (res != null && nextVal != null && operator != null) {
                res = calculate(res, nextVal, operator);
                nextVal = null;
                operator = null;
            }
        }
        return res;
    }

    public String formulor1;
    public String formulor2;
    public HashMap<Character, Boolean> map;
}