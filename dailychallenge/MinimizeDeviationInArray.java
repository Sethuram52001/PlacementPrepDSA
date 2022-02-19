/*
Problem:
You are given an array nums of n positive integers.

You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.

Link: https://leetcode.com/problems/minimize-deviation-in-array/

Solution:
We have two types of operations: double odd numbers, and halve even numbers. We can try to sort all numbers, and increase the smallest number 
(if it's odd) and decrease the largest number (if it's even). This can get quite complicated.

Intuition 1: we can divide even numbers multiple times - till we get an odd number, but we can only double odd numbers once. After that, it will
become an even number.

Intuition 2: Even numbers never increase.

Flip: we can double all odd numbers first, so we can get forget of the second operation. Now, we only need to decrease the 
largest number - while it's even, which results a very simple solution.

Double odd numbers and put all numbers into a max heap. Track the smallest number. Track the minimum difference between the top of 
the heap and the smallest number. While the top of the heap is even, remove it, divide, and put back to the heap.
*/

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            num = num % 2 == 1 ? num*2 : num;
            min = Math.min(num, min);
            pq.add(num);
        }
        
        int minDeviation = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int max = pq.remove();
            minDeviation = Math.min(max - min, minDeviation);
            if(max % 2 == 1) {
                break;
            }
            min = Math.min(min, max / 2);
            pq.add(max / 2);
        }    
        
        return minDeviation;
    }  
}