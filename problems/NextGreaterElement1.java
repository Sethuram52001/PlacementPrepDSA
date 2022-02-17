/*
Problem:
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Another version:
There is only array, perform the same task on the array.

Link: 
i. 2 arrays: https://leetcode.com/problems/next-greater-element-i/
ii. 1 array: https://www.codingninjas.com/codestudio/problems/799354?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

Solution:
We can use a stack and hashmap to cache in the greater element of particular element of the 2nd array.
Now, we can use the hashed value to determine the next greater element of the nums1 array.
*/

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int num : nums2) {
            while(!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }
        
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], - 1);
        }
        
        return nums1;
    }   

    public static int[] nextGreater(int[] arr, int n) {	
		//Write Your code here
		Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            //System.out.println(st.toString());
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            int val = arr[i];
            arr[i] = st.isEmpty() ? -1 : st.peek();
            st.push(val);
        }
        return arr;
    }
}