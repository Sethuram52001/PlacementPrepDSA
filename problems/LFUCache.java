/*
Problem:
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

Link: https://leetcode.com/problems/lfu-cache/

Solution:
We need 2 hashmaps.
One hashmap for caching in the (key, node) pair.
Another hashmap for storing the (freq, list) pairs.
We'll have to implement a doubly linkedlist(DLL) and group the nodes in to DLL according their frequencies.

detailed explaination:
i. https://www.youtube.com/watch?v=0PSB9y8ehbk&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=79
ii. https://leetcode.com/problems/lfu-cache/discuss/94547/Java-O(1)-Solution-Using-Two-HashMap-and-One-DoubleLinkedList
*/

import java.util.*;

public class LFUCache {
    private class Node {
        int key, value, freq;
        Node prev, next;
        
        Node() {
            key = 0;
            value = 0;
            this.freq = 1;
        }
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    
    private class DLL {
        Node head, tail;
        int size;
        
        DLL() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        
        void add(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
            size++;
        }
        
        void remove(Node node) {
            Node before = node.prev;
            Node after = node.next;
            before.next = after;
            after.prev = before;
            size--;
        }
        
        Node removeLast() {
            if(size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    int capacity, size, minFreq;
    HashMap<Integer, Node> cache;
    HashMap<Integer, DLL> freqMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        
        Node node = cache.get(key);
        if(node != null) {
            node.value = value;
            update(node);
        }
        else {
            node = new Node(key, value);
            cache.put(key, node);
            if(size == capacity) {
                DLL lastList = freqMap.get(minFreq);
                cache.remove(lastList.removeLast().key);
                size--;
            }
            size++;
            minFreq = 1;
            DLL newList = freqMap.getOrDefault(node.freq, new DLL());
            newList.add(node);
            freqMap.put(node.freq, newList);
        }
    }
    
    private void update(Node node) {
        DLL oldList = freqMap.get(node.freq);
        oldList.remove(node);
        if(node.freq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }    
}