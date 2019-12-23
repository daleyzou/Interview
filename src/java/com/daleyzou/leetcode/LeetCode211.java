package com.daleyzou.leetcode;

/**
 * @Author: DaleyZou
 * @Description: 添加与搜索单词 - 数据结构设计
 *
 * 前缀树 + 回溯
 *
 * @Date: Created in 11:31 2019/2/26
 * @Modified By:
 */
public class LeetCode211 {
    class TrieNode{
        final int size = 26;
        TrieNode[] nodes;
        boolean isEnd;

        public TrieNode() {
            this.nodes = new TrieNode[size];
        }

        public void addNode(char ch, TrieNode trieNode){
            nodes[ch-'a'] = trieNode;
        }

        public TrieNode getNode(char ch){
            return nodes[ch-'a'];
        }

        public boolean containsNode(char ch){
            return nodes[ch-'a'] != null;
        }
        public void setIsEnd(boolean status){
            this.isEnd = status;
        }
    }
    class WordDictionary {
        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode begin = root;
            for (int i = 0; i < word.length(); i++){
                if (!begin.containsNode(word.charAt(i))){
                    begin.addNode(word.charAt(i), new TrieNode());
                }
                begin = begin.getNode(word.charAt(i));
            }
            begin.setIsEnd(true);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return find(root, word, 0);
        }

        private boolean find(TrieNode root, String word, int index) {
            if (index == word.length()){
                return root.isEnd;
            }
            if (word.charAt(index) == '.'){
                // 回溯该节点所有分支
                for (TrieNode node : root.nodes){
                    if (node != null && find(node, word, index+1)){
                        return true;
                    }
                }
                return false;
            }else {
                TrieNode node = root.getNode(word.charAt(index));
                if (node != null && find(node, word, index+1)){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args){
        System.out.println("hello");
    }
}
