package testing.lib.library;

import testing.lib.trie.Trie2;

/**
 * Created by yun.li on 1/9/17.
 */
public class WordDictionary {
    private Trie2 dict;

    public WordDictionary() {
        dict = new Trie2();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        dict.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dict.search(word);
    }

    public boolean startsWith(String word) {
        return dict.startsWith(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");