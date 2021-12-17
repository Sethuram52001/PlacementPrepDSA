/*
Problem:
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k 
then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Link: https://leetcode.com/problems/reverse-nodes-in-k-group/

Solution:
We can split the ll into len/k groups and reverse them each one
*** needs revision
*/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1), prev = dummyHead;
        dummyHead.next = head;

        int len = 0;
        while (head != null) {
            len++;
            if (len % k == 0) {
                prev = reverse(prev, head.next);
                head = prev.next;
            } else {
                head = head.next;
            }
        }

        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode pre, ListNode end) {
        ListNode prev = pre, curr = pre.next, first = pre.next, next = null;

        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        pre.next = prev;
        first.next = curr;
        return first;
    }
}
