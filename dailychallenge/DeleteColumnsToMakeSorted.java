/*
Problem:
You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid. 
For example, strs = ["abc", "bce", "cae"] can be arranged as:

abc
bce
cae
You want to delete the columns that are not sorted lexicographically. In the above example 
(0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') 
is not, so you would delete column 1.

Return the number of columns that you will delete.

Link: https://leetcode.com/problems/delete-columns-to-make-sorted/

Solution:
Matrix traversal
*/

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int size = strs[0].length();
        int deletions = 0;
        for(int c = 0; c < size; c++) {
            for(int r = 1; r < strs.length; r++) {
                if(strs[r].charAt(c) - strs[r - 1].charAt(c) < 0) {
                    System.out.println(strs[r - 1].charAt(c) + " " + strs[r].charAt(c));
                    deletions++;
                    break;
                }
            }
        }

        return deletions;
    }
}
