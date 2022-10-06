/*
Problem:
Design a time-based key-value data structure that can store multiple values for the same key at different time stamps 
and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. 
If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".

Link: https://leetcode.com/problems/time-based-key-value-store/

Solution:
1. We can two maps, one key based indexed and another time based indexed which can be a sorted map to make our jobs easier in 
searching for the required time key satisfying the condition.

2. We can use map along with an array consisting of pair values - <timestamp, value>; now we do a binary search on the array when retrieve the
required value, this approach is based on the constraint given in the question:
 ****All the timestamps timestamp of set are strictly increasing.****
*/

import java.util.*;

public class TimeBasedKeyValueStore {
    class TimeMap {
        Map<String, ArrayList<Pair<Integer, String>>> timeMap;

        public TimeMap() {
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!timeMap.containsKey(key)) {
                timeMap.put(key, new ArrayList<>());
            }
            timeMap.get(key).add(new Pair(timestamp, value));
        }

        public String get(String key, int timestamp) {
            if (!timeMap.containsKey(key)) {
                return "";
            }

            if (timestamp < timeMap.get(key).get(0).getKey()) {
                return "";
            }

            int left = 0;
            int right = timeMap.get(key).size();

            while (left < right) {
                int mid = (left + right) / 2;
                if (timeMap.get(key).get(mid).getKey() <= timestamp) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return right == 0 ? "" : timeMap.get(key).get(right - 1).getValue();
        }
    }

    class TimeMap_TreeMap_Approach {
    Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap_TreeMap_Approach() {
        this.timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        
        Integer timeKey = timeMap.get(key).floorKey(timestamp);
        return timeKey == null ? "" : timeMap.get(key).get(timeKey);
    }
}
}
