/*
Problem:
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and 
upper cases, more than once.

Link: https://leetcode.com/problems/reverse-vowels-of-a-string/description/

Solution:
2 pointers
*/

public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        Set<Character> vowels = Stream.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
                .collect(Collectors.toCollection(HashSet::new));

        int left = 0, right = s.length() - 1;
        char[] str = s.toCharArray();
        while (left < right) {
            while (left < right && !vowels.contains(str[left])) {
                left++;
            }
            while (left < right && !vowels.contains(str[right])) {
                right--;
            }
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }

        return new String(str);
    }
}
