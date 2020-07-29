package medium;

import java.util.ArrayList;

/**
 * 208Implement Trie (Prefix Tree)
 */
public class ImplementTrie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode temp = root;
        for (int i = 0; i < chars.length; i++) {

            if (temp.children[chars[i] - 'a'] == null) {
                temp.children[chars[i] - 'a'] = new TrieNode(chars[i]);

            }
            temp = temp.children[chars[i] - 'a'];
        }
        temp.children[26] = new TrieNode();

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode temp = root;
        for (char aChar : chars) {
            if (temp.children[aChar - 'a'] == null) {
                return false;
            }
            temp = temp.children[aChar - 'a'];
        }

        return temp.children[26] != null;


    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode temp = root;
        for (char aChar : chars) {
            if (temp.children[aChar - 'a'] == null) {
                return false;
            }
            temp = temp.children[aChar - 'a'];
        }
        return true;
    }

    class TrieNode {
        public char val;
        public TrieNode[] children = new TrieNode[27];

        public TrieNode() {
        }

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }
}
