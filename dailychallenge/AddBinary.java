/*
Problem: Given two binary strings a and b, return their sum as a binary string.

Link: https://leetcode.com/problems/add-binary/

*/

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int idxA = a.length() - 1, idxB = b.length() - 1;
        int carry = 0;
        while(idxA >= 0 || idxB >= 0) {
            int sum = carry;
            if(idxA >= 0) {
                sum += a.charAt(idxA--) - '0';
            }
            if(idxB >= 0) {
                sum += b.charAt(idxB--) - '0';
            }
            carry = sum / 2;
            sum %= 2;
            sb.append(sum);
        }
        
        if(carry > 0) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }   
}
