/*
Problem:
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ 
denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

Link: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Solution:
Slow and fast pointers, have a previous node to keep track of the slow node's previous node, when
the fast pointer reaches the end, the slow pointer will be pointing to the middle of the linked list.
Now, 
prev.next = slow.next
*/

public class DeleteTheMiddleNodeOfLinkedList {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = head, fast = head, prev = dummyHead;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        
        return dummyHead.next;
    }    
}
