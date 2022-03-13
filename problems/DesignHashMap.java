/*
Problem:
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, 
update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.

Link: https://leetcode.com/problems/design-hashmap/

Solution:
The general implementation of HashMap uses bucket which is basically a chain of linked lists and each node containing <key, value> pair.
*/

public class DesignHashMap {
    class MyHashMap {
        class Node {
            int key, val;
            Node next;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node[] map;

        public MyHashMap() {
            map = new Node[1000000];
        }

        public void put(int key, int value) {
            int idx = getIdx(key);
            Node prev = findElement(idx, key);

            if (prev.next == null) {
                prev.next = new Node(key, value);
            }

            else {
                prev.next.val = value;
            }
        }

        public int get(int key) {
            int idx = getIdx(key);
            Node prev = findElement(idx, key);
            return prev.next == null ? -1 : prev.next.val;
        }

        public void remove(int key) {
            int idx = getIdx(key);
            Node prev = findElement(idx, key);

            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }

        private int getIdx(int key) {
            return Integer.hashCode(key) % map.length;
        }

        private Node findElement(int idx, int key) {
            if (map[idx] == null) {
                map[idx] = new Node(-1, -1);
                return map[idx];
            }

            Node prev = map[idx];

            while (prev.next != null && prev.next.key != key) {
                prev = prev.next;
            }

            return prev;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
}