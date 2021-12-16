/*
Problem:
Given the head of a singly linked list, return true if it is a palindrome.

Link: https://leetcode.com/problems/palindrome-linked-list/

Solution:
We can reverse the 2nd half of linked list and then compare
*/

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;

        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
