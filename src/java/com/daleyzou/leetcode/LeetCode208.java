package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * LeetCode208
 * @Description: 实现 Trie (前缀树)
 * @Date: Created in 11:29 2019/2/26
 * @Modified By:
 */
public class LeetCode208 {
    class TrieNode {
        final int length = 26;

        TrieNode[] nodes;

        boolean isEnd;

        public TrieNode() {
            this.nodes = new TrieNode[length];
        }

        public TrieNode getTrieNode(char ch) {
            return nodes[ch - 'a'];
        }

        public void setTrieNode(char signal, TrieNode trieNode) {
            nodes[signal - 'a'] = trieNode;
        }

        public boolean isEnd(char signal) {
            return isEnd;
        }

        public void setIsEnd(boolean status) {
            this.isEnd = status;
        }

        public boolean containsKey(char signal) {
            return nodes[signal - 'a'] != null;
        }
    }

    public class Trie {
        /** Initialize your data structure here. */
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode begin = root;
            for (int i = 0; i < word.length(); i++) {
                char signal = word.charAt(i);
                if (!begin.containsKey(signal)) {
                    begin.setTrieNode(signal, new TrieNode());
                }
                begin = begin.getTrieNode(signal);
            }
            begin.setIsEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode begin = root;
            for (int i = 0; i < word.length(); i++) {
                char signal = word.charAt(i);
                if (begin == null) {
                    return false;
                }
                if (!begin.containsKey(signal)) {
                    return false;
                }
                begin = begin.getTrieNode(signal);
            }
            if (begin == null || !begin.isEnd) {
                return false;
            }
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode begin = root;
            for (int i = 0; i < prefix.length(); i++) {
                char signal = prefix.charAt(i);
                if (begin == null) {
                    return false;
                }
                if (!begin.containsKey(signal)) {
                    return false;
                }
                begin = begin.getTrieNode(signal);
            }
            if (begin == null) {
                return false;
            }
            return true;
        }
    }

    public void test() {
        Trie obj = new Trie();
        obj.insert("word");
        boolean param_2 = obj.search("word");
        System.out.println(param_2);
        boolean param_3 = obj.startsWith("wor");
        System.out.println(param_3);
    }

    public static void main(String[] args) {
        /**
         * Your Trie object will be instantiated and called as such:
         * Trie obj = new Trie();
         * obj.insert(word);
         * boolean param_2 = obj.search(word);
         * boolean param_3 = obj.startsWith(prefix);
         */
        LeetCode208 leetCode208 = new LeetCode208();
        leetCode208.test();
    }
}
