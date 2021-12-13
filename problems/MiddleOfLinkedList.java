/*
problem:
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Link: https://leetcode.com/problems/middle-of-the-linked-list/

Solution:
We can use a slow and fast pointer to find the middle node

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

public class MiddleOfLinkedList {
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode mid = middleNode(head);
        while (mid != null) {
            System.out.print(mid.val + " ");
            mid = mid.next;
        }
        System.out.println();
    }
}
