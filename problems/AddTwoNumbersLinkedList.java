/*
Problem: 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of 
their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Link: https://leetcode.com/problems/add-two-numbers/

Solution:
usually we add numbers from right to left, so it makes sense the linkedlist is reversed

*/

public class AddTwoNumbersLinkedList {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = sum / 10;
            sum %= 10;
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
