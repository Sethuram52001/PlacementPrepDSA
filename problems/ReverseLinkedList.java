/*
Problem:
Given the head of a singly linked list, reverse the list, and return the reversed list.

Link: https://leetcode.com/problems/reverse-linked-list/

Solution:
Try to manipulate the pointers in such a way that we can change A -> B -> C
to A <- B <- C
*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {
    private static ListNode reverseRec(ListNode head) {
        return reverseRec(head, null);
    }

    private static ListNode reverseRec(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }

        ListNode next = curr.next;
        curr.next = prev;
        return reverseRec(next, curr);
    }

    private static ListNode reverseIt(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;

        ListNode reversedHead = reverseRec(head);
        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
        System.out.println(); 
    }
}
