/*
Problem:
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

Link: https://leetcode.com/problems/fruit-into-baskets/description/

Solution:
Longest subarray containing 2 elements - sliding window.
*/

import java.util.*;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, maxWindow = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(; right < fruits.length; right++) {
            freqMap.put(fruits[right], freqMap.getOrDefault(fruits[right], 0) + 1);
            while(freqMap.size() > 2) {
                freqMap.put(fruits[left], freqMap.get(fruits[left]) - 1);
                if(freqMap.get(fruits[left]) == 0) {
                    freqMap.remove(fruits[left]);
                }
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return maxWindow;
    }
}
