/*
Problem:
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Link: https://leetcode.com/problems/lru-cache/

Solution:
We can use hashmap and doubly linked list
*/

import java.util.*;

public class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        
        Node() {
            this.key = 0;
            this.value = 0;
        }
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private Node head, tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
        
        else {
            node.value = value;
            update(node);
        }
        
        if(map.size() > capacity) {
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
        }
    }
    
    private void update(Node node) {
        remove(node);
        add(node);
    }
    
    private void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }    
}