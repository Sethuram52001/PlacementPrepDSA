/*
Problem:
You are given an array people where people[i] is the weight of the ith person, and an infinite number of 
boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the 
same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Link: https://leetcode.com/problems/boats-to-save-people/

Solution:
Greedy - 2 pointer
Always try to pair the heaviest person with lighest person
*/

import java.util.*;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, count = 0;
        while (i <= j) {
            count++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return count;
    }
}