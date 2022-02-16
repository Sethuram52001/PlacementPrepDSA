/*
Problem:
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the 
list's nodes (i.e., only nodes themselves may be changed.)

Link: https://leetcode.com/problems/swap-nodes-in-pairs/

Solution:
2 pointers
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class SwapNodesInPair {
        public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        
        while(prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            first.next = second.next;
            prev.next = second;
            second.next = first;
            prev = prev.next.next;
        }
        
        return dummyHead.next;
    }
}