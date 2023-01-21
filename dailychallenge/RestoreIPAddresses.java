/*
Problem:
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 
and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" 
and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting 
dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Link: https://leetcode.com/problems/restore-ip-addresses/description/

Solution: 
Backtracking
*/

import java.util.*;

public class RestoreIPAddresses {
    List<String> validIpAddresses;

    public List<String> restoreIpAddresses(String s) {
        validIpAddresses = new ArrayList<>();
        backtrack(s, 0, "", 0);
        return validIpAddresses;
    }

    private boolean isValid(String ip) {
        if (ip.length() > 3 || ip.length() == 0) {
            return false;
        }
        if (ip.length() > 1 && ip.charAt(0) == '0') {
            return false;
        }
        if (ip.length() > 0 && Integer.parseInt(ip) > 255) {
            return false;
        }

        return true;
    }

    private void backtrack(String s, int idx, String ip, int dots) {
        if (dots == 3) {
            if (isValid(s.substring(idx))) {
                ip += s.substring(idx);
                validIpAddresses.add(ip);
            }
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isValid(s.substring(idx, i + 1))) {
                int len = s.substring(idx, i + 1).length();
                ip += s.substring(idx, i + 1) + ".";
                backtrack(s, i + 1, ip, dots + 1);
                ip = ip.substring(0, ip.length() - len - 1);
            }
        }
    }
}
