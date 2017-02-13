package testing.lib.node;

import java.util.HashMap;

/**
 * Created by Yun on 2/3/2017.
 */
public class TrieNode3 {
    public Character v;
    public HashMap<Character, TrieNode3> children;
    public Boolean hasEnd;
    public TrieNode3(Character c) {
        v = c;
        children = new HashMap<>();
        hasEnd = false;
    }
}
