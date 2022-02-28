/*
Problem:
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Link: https://leetcode.com/problems/remove-linked-list-elements/

Solution:
We can iterate over the list by checking the condition:
if(curr.next.val == val)
    curr.next = curr.next.next
*/

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        curr.next = head;
        
        while(curr != null && curr.next != null) {
            while(curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        
        return dummyHead.next;
    }
}