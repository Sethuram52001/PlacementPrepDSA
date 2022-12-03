/*
Problem:
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of 
times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Link: https://leetcode.com/problems/sort-characters-by-frequency/

Solution:
We can use a hashmap as a frequency map and priority queue to sort it.
*/

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort_NoPQ(String s) {
        int len = s.length();
        List<Character> buckets[] = new ArrayList[len + 1];
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : freqMap.keySet()) {
            int freq = freqMap.get(ch);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (int freq = len; freq > 0; freq--) {
            if (buckets[freq] == null) {
                continue;
            }

            for (Character ch : buckets[freq]) {
                sb.append(String.valueOf(ch).repeat(freq));
            }
        }

        return sb.toString();
    }
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        heap.addAll(freqMap.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(!heap.isEmpty()) {
            char ch = heap.remove();
            int freq = freqMap.get(ch);
            while(freq-- > 0) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }   
}