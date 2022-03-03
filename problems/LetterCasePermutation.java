/*
Problem:
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create. Return the output in any order.

Link: https://leetcode.com/problems/letter-case-permutation/

Solution:
DFS and BFS
*/

import java.util.*;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        char[] temp = s.toCharArray();
        List<String> permutations = new ArrayList<>();
        solve(temp, 0, permutations);
        return permutations;
    }
    
    private void solve(char[] s, int idx, List<String> permutations) {
        if (idx == s.length) {
            permutations.add(new String(s));
            return;
        }

        if (!Character.isLetter(s[idx])) {
            solve(s, idx + 1, permutations);
            return;
        }

        s[idx] = Character.toUpperCase(s[idx]);
        solve(s, idx + 1, permutations);

        s[idx] = Character.toLowerCase(s[idx]);
        solve(s, idx + 1, permutations);
    }
    
    public List<String> letterCasePermutationBFS(String s) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add(s);
        
        for(int i = 0; i < s.length(); i++) {
            if(!Character.isLetter(s.charAt(i))) {
                continue;
            }
            
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                String curr = queue.remove();
                char[] chs = curr.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.add(new String(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.add(new String(chs));
            }
        }
        
        return new ArrayList<>(queue);
    }
}