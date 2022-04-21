/*
Problem:
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

* void add(key) Inserts the value key into the HashSet.
* bool contains(key) Returns whether the value key exists in the HashSet or not.
* void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

Link: https://leetcode.com/problems/design-hashset/

Solution:
Idea:
LoadFactor tells when to perform re-hashing. I set it to 75% meaning if we have filled 75% of the container, we need to perform rehash. 
The reason for doing this is to "shorten" the individual chains at each bucket. That way, we reduce the time for contains and remove in 
the average case.
*/

import java.util.*;

class MyHashSet {
    List<Integer>[] buckets = null;
    int capacity = 1000;
    double loadFactor = 0.75;
    int count = 0;

    public MyHashSet() {
        buckets = new LinkedList[capacity];       
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }

        if (loadFactor * capacity == count) {
            count = 0;
            capacity *= 2;
            List<Integer>[] oldBuckets = buckets;
            buckets = new LinkedList[capacity];

            for (int i = 0; i < oldBuckets.length; i++) {
                List<Integer> oldBucket = oldBuckets[i];
                if (oldBucket != null) {
                    for (int el : oldBucket) {
                        add(el);
                    }
                }
            }
        }

        int hashKey = key % capacity;
        if (buckets[hashKey] == null) {
            buckets[hashKey] = new LinkedList<>();
        }
        buckets[hashKey].add(key);
    }

    public void remove(int key) {
        int hashKey = key % capacity;
        List<Integer> bucket = buckets[hashKey];
        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i++) {
                if (bucket.get(i) == key) {
                    bucket.remove(i);
                }
            }
        }
    }

    public boolean contains(int key) {
        int hashKey = key % capacity;
        List<Integer> bucket = buckets[hashKey];
        if (bucket != null) {
            for (Integer el : bucket) {
                if (el == key) {
                    return true;
                }
            }
        }

        return false;
    }
}