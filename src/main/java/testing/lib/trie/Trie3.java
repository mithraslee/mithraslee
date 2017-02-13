package testing.lib.trie;

import testing.lib.node.TrieNode;
import testing.lib.node.TrieNode3;

/**
 * Created by Yun on 2/3/2017.
 */
public class Trie3 {
    public TrieNode3 root;
    public Trie3() {
        root = new TrieNode3(null);
    }

    public void insert(String word) {
        if (word == null) return;
        char[] chars = word.toCharArray();
        TrieNode3 cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode3(c));
            }
            cur = cur.children.get(c);
        }
        cur.hasEnd = true;
    }

    public boolean search(String word) {
        if (word == null) return root.hasEnd;
        char[] chars = word.toCharArray();
        TrieNode3 cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.hasEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) return true;
        char[] chars = prefix.toCharArray();
        TrieNode3 cur = root;
        for (char c : chars) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
