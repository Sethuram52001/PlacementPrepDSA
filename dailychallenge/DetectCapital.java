/*
Problem:
We define the usage of capitals in a word to be right when one of the following cases holds:
-All letters in this word are capitals, like "USA".
-All letters in this word are not capitals, like "leetcode".
-Only the first letter in this word is capital, like "Google".
-Given a string word, return true if the usage of capitals in it is right.

Link: https://leetcode.com/problems/detect-capital/

Solution:
The pattern of case 1 in regex is [A-Z]*[A−Z]∗, where [A-Z][A−Z] matches one char from 'A' to 'Z', *∗ represents repeat the pattern before it at least 0 times. Therefore, this pattern represents "All capital".

The pattern of case 2 in regex is [a-z]*[a−z]∗, where similarly, [a-z][a−z] matches one char from 'a' to 'z'. Therefore, this pattern represents "All not capital".

Similarly, the pattern of case 3 in regex is [A-Z][a-z]*[A−Z][a−z]∗.

Take these three pattern together, we have [A-Z]*|[a-z]*|[A-Z][a-z]*[A−Z]∗∣[a−z]∗∣[A−Z][a−z]∗, where "|" represents "or".

Still, we can combine case 2 and case 3, and we get .[a-z]*.[a−z]∗, where "." can matches any char.

Therefore, the final pattern is [A-Z]*|.[a-z]*[A−Z]∗∣.[a−z]∗.
*/

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }

    public boolean detectCapitalUse_(String word) {
        String wordU = word.toUpperCase();
        String wordL = word.toLowerCase();

        boolean res = true;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                res = false;
                break;
            }
        }
        return res || wordU.equals(word) || wordL.equals(word);
    }
    
        public boolean detectCapitalUse_AnotherMethod(String word) {
        int capitalCount = 0;
        for(char ch : word.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                capitalCount++;
            }
        }

        return capitalCount == 0 ? true : capitalCount == 1 && Character.isUpperCase(word.charAt(0)) ? true : capitalCount == word.length();
    }
}