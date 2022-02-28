/*
Problem:
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of 
the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Link: https://leetcode.com/problems/summary-ranges/

Solution:
2 pointers
*/

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRanges = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0, end = 0;
        
        for(int i = 0; i < nums.length; i++) {
            while(i + 1 < nums.length && nums[i + 1] - 1 == nums[i]) {
                i++;
                end++;
            }    
            
            if(start == end) {
                sb.append(nums[start]);
            }
            else {
                sb.append(nums[start]);
                sb.append("->");
                sb.append(nums[end]);
            }
            
            summaryRanges.add(sb.toString());
            sb.setLength(0);
            end++;
            start = end;
        }
        
        return summaryRanges;
    }
}