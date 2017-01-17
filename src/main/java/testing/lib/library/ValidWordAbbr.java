package testing.lib.library;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Yun on 1/16/2017.
 */
public class ValidWordAbbr {

    HashMap<String, HashSet<String>> dict;

    public ValidWordAbbr(String[] dictionary) {
        dict = new HashMap<>();
        for (String str : dictionary) {
            if (str.length() > 2) {
                String key = new StringBuilder().append(str.charAt(0)).append(str.length() - 2).append(str.charAt(str.length() - 1)).toString();
                if (dict.containsKey(key)) {
                    dict.get(key).add(str);
                } else {
                    HashSet<String> newSet = new HashSet<>();
                    newSet.add(str);
                    dict.put(key, newSet);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        if (word.length() <= 2) return true;
        String key = new StringBuilder().append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1)).toString();
        return !dict.containsKey(key) ||
                (dict.containsKey(key) && dict.get(key).size() == 1 && dict.get(key).contains(word));
    }
}
