package testing.lib.trie;

import java.util.*;
import testing.lib.node.*;

/**
 * Created by Yun on 11/28/2015.
 */
public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) return;
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
               cur.children.put(c, new TrieNode(c));
            }
            cur = cur.children.get(c);
        }
        if (!cur.children.containsKey(null)) {
            cur.children.put(null, null);
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) return true;
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.children.containsKey(null);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) return true;
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
