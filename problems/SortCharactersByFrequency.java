/*
Problem:
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of 
times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Link: https://leetcode.com/problems/sort-characters-by-frequency/

Solution:
We can use a hashmap as a frequency map and priority queue to sort it.
*/

public class SortCharactersByFrequency {
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