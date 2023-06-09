/*
Problem:
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. 
There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character 
does not exist, return the first character in letters.

Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

Solution: 
* Perform binary search.
*/

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right--;
            } else {
                left++;
            }
        }

        return left == letters.length ? letters[0] : letters[left];
    }
}