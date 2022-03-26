/*
Problem:
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Solution:
DFS
*/

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Integer, String> digitToLetter = new HashMap<>();
        digitToLetter.put(2, "abc");
        digitToLetter.put(3, "def");
        digitToLetter.put(4, "ghi");
        digitToLetter.put(5, "jkl");
        digitToLetter.put(6, "mno");
        digitToLetter.put(7, "pqrs");
        digitToLetter.put(8, "tuv");
        digitToLetter.put(9, "wxyz");

        List<String> combinations = new ArrayList<>();
        dfs(digits, 0, digitToLetter, new StringBuilder(), combinations);
        return combinations;
    }

    private void dfs(String digits, int idx, HashMap<Integer, String> digitToLetter, StringBuilder sb,
            List<String> combinations) {
        if (idx == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        String letters = digitToLetter.get(digits.charAt(idx) - '0');
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            dfs(digits, idx + 1, digitToLetter, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}