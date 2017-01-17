package testing.lib.library;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Yun on 1/14/2017.
 */

/**
 *Shortest Word Distance II 最短单词距离之二
 *
 *
 *        This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 *
 *        Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 *
 *        For example,
 *        Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 *        Given word1 = “coding”, word2 = “practice”, return 3.
 *        Given word1 = "makes", word2 = "coding", return 1.
 *
 *        Note:
 *        You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class WordDistance {

    private HashMap<String, ArrayList<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(words[i], newList);
            }
        }
    }
    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        ArrayList<Integer> idxs1 = map.get(word1);
        ArrayList<Integer> idxs2 = map.get(word2);
        int idx1 = 0, idx2 = 0;
        while (idx1 < idxs1.size() && idx2 < idxs2.size()) {
            res = Math.min(res, Math.abs(idxs1.get(idx1) - idxs2.get(idx2)));
            if (idxs1.get(idx1) < idxs2.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return res;
    }
}
