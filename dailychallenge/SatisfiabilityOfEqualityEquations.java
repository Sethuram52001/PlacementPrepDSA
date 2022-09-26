/*
Problem:
You are given an array of strings equations that represent relationships between variables where each 
string equations[i] is of length 4 and takes one of two different forms: "xi==yi" or "xi!=yi".Here, 
xi and yi are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if it is possible to assign integers to variable names so as to satisfy all the given equations, or false otherwise.

Link: https://leetcode.com/problems/satisfiability-of-equality-equations/

Solution:
Union-find, first join every equality equations; now check
for each inequality equations if the variables belongs in the
same set then there is conflict.

The idea is that equality and inequality can be represented by a 
disjoint set.
*/

public class SatisfiabilityOfEqualityEquations {
    int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int idx = 0; idx < 26; idx++) {
            uf[idx] = idx;
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                uf[find(eq.charAt(0) - 'a')] = find(eq.charAt(3) - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!' && find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    private int find(int idx) {
        if (uf[idx] != idx) {
            uf[idx] = find(uf[idx]);
        }

        return uf[idx];
    }
}