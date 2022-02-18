/*
Problem:
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Link: https://leetcode.com/problems/remove-k-digits/

Solution: 
We can plot the digits on a graph and we can get the idea to remove the peaks from the string.
For this we can use a stack.
*/

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) {
            return "0";
        }
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while(k > 0) {
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        while(sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.reverse().toString();
    }
}