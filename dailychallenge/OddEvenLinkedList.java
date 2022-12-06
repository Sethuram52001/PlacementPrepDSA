/*
Problem:
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, 
and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Link: https://leetcode.com/problems/odd-even-linked-list/description/

Solution:
We can 2 pointers - for odd indices and even indices and traverse the list.
At last we can just join the odd list's tail to even list's head.
*/

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode oddL = head, evenL = head.next, evenHead = evenL;
        while(evenL != null && evenL.next != null) {
            oddL.next = evenL.next;
            oddL = oddL.next;
            evenL.next = oddL.next;
            evenL = evenL.next;
        }

        oddL.next = evenHead;
        return head;
    }
}