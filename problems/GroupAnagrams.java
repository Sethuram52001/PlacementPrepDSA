/*
Problem:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Link: https://leetcode.com/problems/group-anagrams/

Solution:
Anagrams - same when sorted, we can map each of the word to its sorted word key in a hashmap
*/

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String keyStr = new String(strArray);
            
            if(!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            
            map.get(keyStr).add(str);
        }
        
        List<List<String>> anagrams = new ArrayList<>();
        for(List<String> anagramList : map.values()) {
            anagrams.add(anagramList);
        }
        
        return anagrams;
    }
}