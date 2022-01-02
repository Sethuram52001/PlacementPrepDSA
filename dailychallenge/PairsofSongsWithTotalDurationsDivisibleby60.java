/*
Problem: 
You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, 
we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

Link: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

Solution:
We can just use mod concept hashing
*/

public class PairsofSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] modFreq = new int[60];
        int n = time.length;
        
        for(int i = 0; i < n; i++) {
            modFreq[time[i] % 60]++;
        }
        
        int count = modFreq[0]*(modFreq[0] - 1) / 2;
        count += modFreq[30]*(modFreq[30] - 1) / 2;
        
        for(int i = 1; i <= 29; i++) {
            count += modFreq[i]*modFreq[60 - i];
        }
        
        return count;
    }
}
