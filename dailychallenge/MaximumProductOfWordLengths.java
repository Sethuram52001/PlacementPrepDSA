/*
Problem:
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where 
the two words do not share common letters. If no such two words exist, return 0.

Link: https://leetcode.com/problems/maximum-product-of-word-lengths/

Solution:
We can use bit masking to create an unique hash of each word:
for: char ch in word:
    hash[word] |= 1 << (ch - 'a') 

Now, we can just use bitwise 'AND' to check for any common letter between any 2 words.
*/

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                hash[i] |= 1 << (ch - 'a');
            }
        }

        int maxProd = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].length() * words[j].length() < maxProd) {
                    continue;
                }
                if ((hash[i] & hash[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }

        return maxProd;
    }
}