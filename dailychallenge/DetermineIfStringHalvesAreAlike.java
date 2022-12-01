/*
Problem:
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase 
and lowercase letters.
Return true if a and b are alike. Otherwise, return false.

Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/description/
*/

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int count1 = 0, count2 = 0;
        int len = s.length();
        for (int idx = 0; idx < len / 2; idx++) {
            char c1 = Character.toLowerCase(s.charAt(idx));
            char c2 = Character.toLowerCase(s.charAt(idx + len / 2));

            if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                count1++;
            }

            if (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') {
                count2++;
            }
        }

        return count1 == count2;
    }
}
