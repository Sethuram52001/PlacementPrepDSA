/*
Problem:
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,
    * G[i] for an element A[i] = an element A[j] such that 
    * j is maximum possible AND 
    * j < i AND
    * A[j] < A[i]

Elements for which no smaller element exist, consider next smaller element as -1.

Link: https://www.interviewbit.com/problems/nearest-smaller-element/

Solution:
Similar to next greater element, we can use a stack.
*/

public class NextSmallerElement {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            while(!st.isEmpty() && st.peek() >= A[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                pse[i] = -1;
            }
            else {
                pse[i] = st.peek();
            }
            st.push(A[i]);
        }
        return pse;
    }   
}