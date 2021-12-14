/*
Problem:
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Link: https://leetcode.com/problems/merge-two-sorted-lists/

Solution:
To achieve O(1) space, we have to change the links in the given lists instead of creating a new list 
*/

public class MergeTwoSortedLinkedLists {
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        
        if(list2 == null) {
            return list1;
        }
        
        ListNode l1 = list1, l2 = list2;
        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        ListNode res = l1;
        while(l1 != null && l2 != null) {
            ListNode prev = null;
            while(l1 != null && l1.val <= l2.val) {
                prev = l1;
                l1 = l1.next;
            }
            
            prev.next = l2;
            
            // swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        
        return res;
    }
}
