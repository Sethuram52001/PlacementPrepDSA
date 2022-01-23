/*
Logic: backtracking and swaping

Time Complexity: O(N! X N)

Space Complexity: O(1)
*/

import java.util.*;

public class PermutationString {
    public static List<String> findPermutations(String s) {
        // Write your code here.
        char[] word = s.toCharArray();
        List<String> permutations = new ArrayList<>();
        backtrack(word, 0, permutations);
        return permutations;
    }

    private static void backtrack(char[] word, int idx, List<String> permutations) {
        if (idx == word.length - 1) {
            permutations.add(new String(word));
            return;
        }

        for (int i = idx; i < word.length; i++) {
            swap(word, i, idx);
            backtrack(word, idx + 1, permutations);
            swap(word, i, idx);
        }
    }

    private static void swap(char[] word, int i, int j) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }
}
