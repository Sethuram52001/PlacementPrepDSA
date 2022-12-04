/*
Problem:
You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. 
Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams 
such that the total skill of each team is equal.

Link: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/

Solution:
sorting + 2 pointers

Reference:
1. https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/solutions/2875305/sorting-2-pointer-approach/?orderBy=most_votes
*/

import java.util.*;

public class DividePlayersInToTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        long res = 0;
        Arrays.sort(skill);
        int pairValue = skill[0] + skill[skill.length - 1];

        int l = 0, r = skill.length - 1;
        while (l < r) {
            int pair = skill[l] + skill[r];
            if (pair != pairValue) {
                return -1;
            }
            res += skill[l] * skill[r];
            l++;
            r--;
        }

        return res;
    }
}
