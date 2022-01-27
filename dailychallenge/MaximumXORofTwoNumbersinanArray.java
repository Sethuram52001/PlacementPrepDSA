/*
Problem:
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Solution:
Insert all elements in the trie(bit wise).
Now find max for each number by iterating throught the trie.
*/

class Node {
    Node[] links;
    
    Node() {
        links = new Node[2];
    }
    
    public boolean containsKey(int bit) {
        return links[bit] != null;
    }
    
    public void put(int bit, Node node) {
        links[bit] = node;
    }
    
    public Node get(int bit) {
        return links[bit];
    }
}

class Trie {
    static Node root;
    
    Trie() {
        root = new Node();
    }
    
    public static void insert(int num) {
        Node node = root;
        for(int i = 31; i >= 0; i--) {
            int setBit = (num >> i) & 1;
            if(!node.containsKey(setBit)) {
                node.put(setBit, new Node());
            }
            node = node.get(setBit);
        }
    }
    
    public static int getMax(int num) {
        Node node = root;
        int max = 0;
        
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)) {
                max = max | (1 << i);
                node = node.get(1 - bit);
            }
            else {
                node = node.get(bit);
            }
        }
        
        return max;
    }
}

public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int max = 0;

        for (int num : nums) {
            trie.insert(num);
        }

        for (int num : nums) {
            max = Math.max(max, trie.getMax(num));
        }

        return max;
    }
}