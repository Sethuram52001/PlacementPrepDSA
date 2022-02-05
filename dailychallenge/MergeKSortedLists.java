/*
Problem:
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Link: https://leetcode.com/problems/merge-k-sorted-lists/solution/

Solution:
i. We can use a min heap and store all the values present in the list. Now we can create a new list by removing elements from the min heap.
ii. Divide and conquere
*/

import java.util.*;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;

        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = new ListNode(a.val);
                a = a.next;
            } else {
                curr.next = new ListNode(b.val);
                b = b.next;
            }
            curr = curr.next;
        }

        if (a == null) {
            curr.next = b;
        }

        if (b == null) {
            curr.next = a;
        }
        return dummyHead.next;
    }

    public ListNode mergeKListsMinHeap(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (ListNode listHead : lists) {
            while (listHead != null) {
                minHeap.add(listHead.val);
                listHead = listHead.next;
            }
        }

        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        while (!minHeap.isEmpty()) {
            curr.next = new ListNode(minHeap.remove());
            curr = curr.next;
        }
        return dummyHead.next;
    }
}