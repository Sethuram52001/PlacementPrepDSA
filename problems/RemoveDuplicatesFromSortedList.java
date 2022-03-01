/*
Problem:
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
Return the linked list sorted as well.

Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Solution:
We can just remove the duplicates by traversing on this condition:
while(curr.next != null && curr.val == curr.next.val) {
	curr.next = curr.next.next;
}
*/

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
            while(curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        
        return dummyHead.next;
    }	
}