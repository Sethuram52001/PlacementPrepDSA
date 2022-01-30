/*
Problem:
The hash of a 0-indexed string s of length k, given integers p and m, is computed using the following function:

hash(s, p, m) = (val(s[0]) * p0 + val(s[1]) * p1 + ... + val(s[k-1]) * pk-1) mod m.
Where val(s[i]) represents the index of s[i] in the alphabet from val('a') = 1 to val('z') = 26.

You are given a string s and the integers power, modulo, k, and hashValue. Return sub, the first substring of s of length k such that hash(sub, power, modulo) == hashValue.

The test cases will be generated such that an answer always exists.

A substring is a contiguous non-empty sequence of characters within a string.

Link: https://leetcode.com/problems/find-substring-with-given-hash-value/

Solution:
Reverse-rabin-karp algorithm => sliding window + rolling hash
leetcode discussion link: https://leetcode.com/problems/find-substring-with-given-hash-value/discuss/1730321/JavaC%2B%2BPython-Sliding-Window-%2B-Rolling-Hash
Youtube link(Abdul Bari - Rabin-Karp algo)https://www.youtube.com/watch?v=qQ8vS2btsxI&t=1092s
*/

public class FindSubstringWithGivenHashValue {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long curr = 0, powerK = 1;
        int res = 0, n = s.length();
        
        for(int i = n - 1; i >= 0; i--) {
            curr = (curr*power + s.charAt(i) - 'a' + 1) % modulo;
            if(i + k >= n) {
                powerK = powerK * power % modulo;
            }
            else {
                curr = (curr - (s.charAt(i + k) - 'a' + 1)*powerK % modulo + modulo) % modulo;
            }
            
            if(curr == hashValue) {
                res = i;
            }
        }
        
        return s.substring(res, res + k);
    }
}
