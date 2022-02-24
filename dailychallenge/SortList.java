/*
Problem:
Given the head of a linked list, return the list after sorting it in ascending order.

Link: https://leetcode.com/problems/sort-list/

Solution:
merge sort
*/

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        curr.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while(head != null && head.next != null) {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}