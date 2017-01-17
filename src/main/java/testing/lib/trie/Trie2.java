package testing.lib.trie;

import testing.lib.node.TrieNode;

/**
 * Created by yun.li on 1/9/17.
 */
public class Trie2 {
    public TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    public void insert (String word) {
        insert(word, 0, root);
    }
    private void insert (String word, int index, TrieNode node) {
        if (word == null || index >= word.length()) {
            return;
        }
        char[] chars = word.toCharArray();
        for (; index < word.length(); index++) {
            if (!node.children.containsKey(chars[index])) {
                node.children.put(chars[index], new TrieNode());
            }
            node = node.children.get(chars[index]);
        }
        if (!node.children.containsKey(null)) {
            // Used (null, null). Can cause exception
            node.children.put(null, new TrieNode());
        }
    }

    public boolean search (String word) {
        return search(word, 0, root);
    }
    private boolean search (String word, int index, TrieNode node) {
        if (word == null || index >= word.length()) {
            return node.children.containsKey(null);
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (!node.children.containsKey(c)) {
                return false;
            } else {
                return search(word, index+1, node.children.get(c));
            }
        } else {
            // Cannot be "char nc", since char cannot be null. Only Character can be null.
            for (Character nc : node.children.keySet()) {
                if (search(word, index+1, node.children.get(nc))) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean startsWith (String word) {
        return startsWith(word, 0, root);
    }
    private boolean startsWith (String word, int index, TrieNode node) {
        if (word == null || index >= word.length()) {
            return true;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (!node.children.containsKey(c)) {
                return false;
            } else {
                return startsWith(word, index+1, node.children.get(c));
            }
        } else {
            // Cannot be "char nc", since char cannot be null. Only Character can be null.
            for (Character nc : node.children.keySet()) {
                if (startsWith(word, index+1, node.children.get(nc))) {
                    return true;
                }
            }
            return false;
        }
    }
}
