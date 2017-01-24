package testing.lib.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun.li on 1/16/17.
 */
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int len = s.length();
            sb.append(len).append("/").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        ArrayList<String> res = new ArrayList<>();
        String t = s;
        while (!t.isEmpty()) {
            int cnt = 0;
            int idx = 0;
            while (idx < t.length() && Character.isDigit(t.charAt(idx))) {
                cnt *= 10;
                cnt += Integer.parseInt(t.charAt(idx++) + "");
            }
            res.add(t.substring(idx + 1, idx + 1 + cnt));
            t = t.substring(idx + cnt + 1);
        }
        return res;
    }

//    // Encodes a list of strings to a single string.
//    public String encode(List<String> strs) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : strs) {
//            int len = s.length();
//            sb.append("/").append(len).append(":").append(s);
//        }
//        return sb.toString();
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        ArrayList<String> res = new ArrayList<>();
//        String t = s;
//        while (!t.isEmpty()) {
//            assert t.startsWith("/");
//            int cnt = 0;
//            int idx = 1;
//            while (idx < t.length() && Character.isDigit(t.charAt(idx))) {
//                cnt *= 10;
//                cnt += Integer.parseInt(t.charAt(idx++) + "");
//            }
//            res.add(t.substring(idx + 1, idx + 1 + cnt));
//            t = t.substring(idx + cnt + 1);
//        }
//        return res;
//    }
}
