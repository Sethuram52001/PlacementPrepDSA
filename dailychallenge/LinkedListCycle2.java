/*
Problem:
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). 
It is -1 if there is no cycle. Note that pos is not passed as a parameter.
Do not modify the linked list.

Link: https://leetcode.com/problems/linked-list-cycle-ii/

Solution:
check for the cycle if present then point a fast pointer to head and move both slow and fast one node at a time to find the intersection
*/

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        boolean cyclePresent = false;
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cyclePresent = true;
                break;
            }   
        }
        
        if(cyclePresent) {
            fast = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }    
}
