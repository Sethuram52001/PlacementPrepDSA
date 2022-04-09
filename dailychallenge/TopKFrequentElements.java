/*
Problem:
Given an integer array nums and an integer k, return the k most frequent elements. 
You may return the answer in any order.

Link: https://leetcode.com/problems/top-k-frequent-elements/

Solution: 
Bucket sort - add the elements to a bucket denoting their frequencies
*/

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] buckets = new List[n + 1];

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        List<Integer> topK = new ArrayList<>();
        for (int freq = n; freq >= 0 && topK.size() < k; freq--) {
            if (buckets[freq] != null) {
                for (int i = 0; i < buckets[freq].size() && topK.size() < k; i++)
                    topK.add(buckets[freq].get(i));
            }
        }

        int[] ans = topK.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}