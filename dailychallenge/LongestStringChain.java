/*
Problem:
You are given an array of words where each word consists of lowercase English letters.

wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without 
changing the order of the other characters to make it equal to wordB.

For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor 
of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

Return the length of the longest possible word chain with words chosen from the given list of words.

Link: https://leetcode.com/problems/longest-string-chain/

Solution:
Instead of adding a character, try deleting a character to form a chain in reverse.
So, we traverse the word list in such a way that we search the group of words who's length is 1 less of
the current word and it a correct predecessor.

This can be done using a simple DFS, but to eliminate TLE, we can simply use a hashmap to cache in the 
intermediate results(top-down dp).
*/

public class LongestStringChain {
    private HashMap<String, Integer> dp;

    public int longestStrChain(String[] words) {
        dp = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        HashMap<Integer, List<String>> lenStrings = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!lenStrings.containsKey(words[i].length())) {
                lenStrings.put(words[i].length(), new ArrayList<>());
            }
            lenStrings.get(words[i].length()).add(words[i]);
        }

        int longestChain = 1;
        for (int i = words.length - 1; i >= 0; i--) {
            if (longestChain > words[i].length() - words[0].length()) {
                break;
            }
            int chainLen = computeChain(words[i], lenStrings, 1);
            longestChain = Math.max(chainLen, longestChain);
        }

        return longestChain;
    }

    private int computeChain(String word, HashMap<Integer, List<String>> lenStrings, int chainLen) {
        if (dp.containsKey(word)) {
            return dp.get(word);
        }
        List<String> possibleStrings = lenStrings.get(word.length() - 1);
        int max = chainLen;
        if (possibleStrings == null) {
            return chainLen;
        }

        for (int i = 0; i < word.length(); i++) {
            String prev = word.substring(0, i) + word.substring(i + 1);
            if (possibleStrings.contains(prev)) {
                max = Math.max(computeChain(prev, lenStrings, chainLen + 1), max);
            }
        }

        dp.put(word, max);
        return max;
    }
}