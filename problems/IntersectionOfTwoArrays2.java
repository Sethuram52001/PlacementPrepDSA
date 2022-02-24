/*
Problem: 
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times 
as it shows in both arrays and you may return the result in any order.

Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/

Solution:
ref: i. https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions
     ii. https://leetcode.com/problems/intersection-of-two-arrays-ii/discuss/282372/Java-solution-with-all-3-follow-up-questions


Follow up:
i. What if the given array is already sorted? How would you optimize your algorithm?
ii. What if nums1's size is small compared to nums2's size? Which algorithm is better?
iii. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

i. What if the given array is already sorted? How would you optimize your algorithm?
Classic two pointer iteration, i points to nums1 and j points to nums2. Because a sorted array is in ascending order, so if nums1[i] > nums[j], 
we need to increment j, and vice versa. Only when nums1[i] == nums[j], we add it to the result array. Time Complexity O(max(N, M)). Worst case, 
for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }. We will always iterate the longest array.

ii. What if nums1's size is small compared to nums2's size? Which algorithm is better?
This one is a bit tricky. Let's say nums1 is K size. Then we should do binary search for every element in nums1. Each lookup is O(log N), and if 
we do K times, we have O(K log N).
If K this is small enough, O(K log N) < O(max(N, M)). Otherwise, we have to use the previous two pointers method.
let's say A = [1, 2, 2, 2, 2, 2, 2, 2, 1], B = [2, 2]. For each element in B, we start a binary search in A. To deal with duplicate entry, once 
you find an entry, all the duplicate element is around that that index, so you can do linear search scan afterward.

Time complexity, O(K(logN) + N). Plus N is worst case scenario which you have to linear scan every element in A. But on average, that shouldn't 
be the case. so I'd say the Time complexity is O(K(logN) + c), c (constant) is number of linear scan you did.

iii. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
This one is open-ended. But Map-Reduce I believe is a good answer.
* If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the 
  intersections.
* If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at 
  a time in memory, record intersections.
*/

import java.util.*;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> temp = new ArrayList<>();
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
            else {
                temp.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] res = new int[temp.size()];
        for(int idx = 0; idx < res.length; idx++) {
            res[idx] = temp.get(idx);
        }
        
        return res;
    }

    public int[] intersect_HashMap(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> temp = new ArrayList<>();
        for(int num : nums2) {
            if(freqMap.containsKey(num) && freqMap.get(num) > 0) {
                temp.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }
        
        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        
        return res;
    }
}