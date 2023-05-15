/*
Problem:
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and 
the kth node from the end (the list is 1-indexed).

Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

Solution:
* We can have 3 pointers => curr, first, second.
* First, let's traverse k nodes using first and second.
* Now, travel until end using curr and second(second starts from head).
* Second pointer traverses len - k nodes
*/

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode first = dummyHead, curr = dummyHead;
        while (k-- > 0) {
            curr = curr.next;
            first = first.next;
        }

        ListNode second = dummyHead;
        while (curr != null) {
            curr = curr.next;
            second = second.next;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return dummyHead.next;
    }
}
