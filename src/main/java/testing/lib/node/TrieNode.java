package testing.lib.node;

import java.util.*;

/**
 * Created by Yun on 11/28/2015.
 */
public class TrieNode {
    public Character v;
    public HashMap<Character, TrieNode> children;

    public TrieNode () {
        this(null, new HashMap<Character, TrieNode>());
    }
    public TrieNode (Character d) {
        this(d, new HashMap<Character, TrieNode>());
    }
    public TrieNode (Character d, HashMap<Character, TrieNode> c) {
        v = d;
        children = (HashMap<Character, TrieNode>)(c.clone());
    }
}
