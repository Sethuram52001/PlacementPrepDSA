/*
Problem:
You are given two positive integer arrays spells and potions, of length n and m respectively, 
where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the 
product of their strengths is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will 
form a successful pair with the ith spell.

Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

Solution:
Binary search / tree map
*/

import java.util.*;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        treeMap.put(Long.MAX_VALUE, potions.length);
        for (int i = potions.length - 1; i >= 0; i--) {
            treeMap.put((long) potions[i], i);
        }

        for (int idx = 0; idx < spells.length; idx++) {
            long need = success % spells[idx] == 0 ? success / spells[idx] : success / spells[idx] + 1;
            res[idx] = potions.length - treeMap.ceilingEntry(need).getValue();
        }
        return res;
    }
}
