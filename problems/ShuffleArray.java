/*
Problem:
Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the 
array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

Link: https://leetcode.com/problems/shuffle-an-array/

Solution:
Fisher-Yates Algorithm:
The Fisher-Yates algorithm is remarkably similar to the brute force solution. On each iteration of the 
algorithm, we generate a random integer between the current index and the last index of the array. Then, 
we swap the elements at the current index and the chosen index - this simulates drawing (and removing) 
the element from the hat, as the next range from which we select a random index will not include the most 
recently processed one. One small, yet important detail is that it is possible to swap an element with 
itself - otherwise, some array permutations would be more likely than others. 

Reference: https://leetcode.com/problems/shuffle-an-array/solution/
*/

public class ShuffleArray {
    private int[] array;
    private int[] original;
    Random rand;

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
        rand = new Random();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            int randIdx = randRange(i, array.length);
            swap(i, randIdx);
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */