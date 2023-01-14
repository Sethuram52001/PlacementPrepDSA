/*
Problem:
You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" 
are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information 
from s1 and s2.

Link: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/

Solution:
Union-Find
*/

public class LexicographicallySmallestEquivalentString {
    class UF {
        int[] rank;

        UF(int size) {
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                rank[i] = i;
            }
        }

        void union(char a, char b) {
            int find_a = find(a - 'a');
            int find_b = find(b - 'a');
            if (find_a == find_b) {
                return;
            }

            if (find_a > find_b) {
                rank[find_a] = find_b;
            } else {
                rank[find_b] = find_a;
            }
        }

        int find(int val) {
            if (val == rank[val]) {
                return rank[val];
            }

            return find(rank[val]);
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UF uf = new UF(26);
        for (int idx = 0; idx < s1.length(); idx++) {
            char ch1 = s1.charAt(idx), ch2 = s2.charAt(idx);
            if (ch1 == ch2) {
                continue;
            } else {
                uf.union(ch1, ch2);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            sb.append((char) (97 + uf.find(ch - 'a')));
        }

        return sb.toString();
    }
}
