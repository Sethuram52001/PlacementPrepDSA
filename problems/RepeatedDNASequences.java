/*
Problem:
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) 
that occur more than once in a DNA molecule. You may return the answer in any order.

Link: https://leetcode.com/problems/repeated-dna-sequences/

Solution: 
We can either use a hashmap or 2 hashsets
*/

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) {
            return new ArrayList<>();
        }
        
        int win = 10, n = s.length();
        Set<String> seen = new HashSet<>(), repeatedSeq = new HashSet<>();
        
        for(int i = 0; i <= n - win; i++) {
            String word = s.substring(i, i + win);
            if(seen.contains(word)) {
                repeatedSeq.add(word);
            }
            seen.add(word);
        }
        
        return new ArrayList<>(repeatedSeq);
    }   
}