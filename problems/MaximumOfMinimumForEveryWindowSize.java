/*
Problem:
Given an integer array. The task is to find the maximum of the minimum of every window size in the array.
Note: Window size varies from 1 to the size of the Array.

Link: https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1/#

Solution:
i. O(n^2): We can use the algo of sliding window max problem for every window size.
ii. O(N): https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
*/

public class MaximumOfMinimumForEveryWindowSize {
    public static int[] maxOfMin(int[] arr, int n) {
        // Your code here
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                left[i] = st.peek();
            }
            st.push(i);
        }
        
        st.clear();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                right[i] = st.peek();
            }
            st.push(i);
        }
    
        int[] ans = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int idx = right[i] - left[i] - 1;
            ans[idx] = Math.max(ans[idx], arr[i]);
        }
        
        for(int i = n - 1; i>=1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        int[] maxOfMin = new int[n];
        for(int i = 1; i <=n; i++) {
            maxOfMin[i - 1] = ans[i];
        }
        return maxOfMin;
    }   
}