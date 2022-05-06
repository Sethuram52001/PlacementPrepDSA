/*
Problem:
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and 
equal letters from s and removing them, causing the left and the right side of the deleted substring 
to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the 
answer is unique.

Link: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

Solution:
We can use stack and pair class to update the frequency 
based on the previous elements, and remove if it reaches threshold k.
*/

public class RemoveAllAdjacentDuplicatesInString2 {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair<Character, Integer>> st = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peekLast().getKey() == ch) {
                Pair<Character, Integer> top = st.removeLast();
                st.add(new Pair<>(ch, top.getValue() + 1));
            }

            else {
                st.add(new Pair<>(ch, 1));
            }

            if (st.peekLast().getValue() == k) {
                st.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            Pair<Character, Integer> top = st.removeLast();
            sb.append(String.valueOf(top.getKey()).repeat(top.getValue()));
        }

        return sb.reverse().toString();
    }
}