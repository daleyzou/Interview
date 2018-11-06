package com.daleyzou.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: DaleyZou
 * @Description: 使用java实现一个哈夫曼编码的小程序
 * @Date: Created in 19:45 2018-9-27
 * @Modified By:
 */
public class HuffmanCode {
    private class Node implements Comparable<Node>{
        char ch;  // 字符
        int freq; // 权值
        boolean isLeaf;  // 是否是叶子节点
        Node left, right;  // 父节点的左节点和右节点

        // 初始化一个带权值的叶子节点
        public Node(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
            this.isLeaf = true;
        }

        // 构建一个节点，带左右节点
        public Node(Node left, Node right, int freq){
            this.left = left;
            this.right = right;
            this.freq = freq;
            this.isLeaf = false;
        }

        @Override
        public int compareTo(Node node) {
            return this.freq - node.freq;
        }
    }

    // 构建一颗哈夫曼树
    public Map<Character, String> encode(Map<Character, Integer> frequencyForChar){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        for (Character ch : frequencyForChar.keySet()){
            priorityQueue.add(new Node(ch,frequencyForChar.get(ch)));
        }
        while (priorityQueue.size() != 1){ // 构建小根堆
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            priorityQueue.add(new Node(left, right, left.freq + right.freq));
        }
        return encode(priorityQueue.poll());
    }

    public Map<Character, String> encode(Node root){
        HashMap<Character, String> hashMap = new HashMap<>();
        encode(root, "", hashMap);
        return hashMap;
    }

    public void encode(Node root, String encoding, HashMap<Character,String> hashMap) {
        if (root.isLeaf){ // 已经到叶子节点，递归结束
            hashMap.put(root.ch, encoding);
            return;
        }
        encode(root.left, encoding + "0" ,hashMap);     // 编码左节点
        encode(root.right, encoding + "1", hashMap);    // 编码右节点
    }

    // 测试结果是否正确
    public static void main(String[] args){
        Map<Character, Integer> frequencyForChar = new HashMap<>();
        frequencyForChar.put('a', 10);
        frequencyForChar.put('b', 20);
        frequencyForChar.put('c', 40);
        frequencyForChar.put('d', 80);

        HuffmanCode huffmanCode = new HuffmanCode();
        Map<Character, String> encode = huffmanCode.encode(frequencyForChar);
        for (Character ch : encode.keySet()){
            System.out.println(ch + " : " + encode.get(ch));
        }
    }

}
