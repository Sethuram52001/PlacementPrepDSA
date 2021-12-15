/*
Problem:
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously 
following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer 
is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Link: https://leetcode.com/problems/linked-list-cycle-ii/

Solution:
Let's say the distance from head to intersection as L1 and distance from intersection to collision point
as L2.
The distance travelled by slow pointer is (L1 + L2).
The distance travelled by fast pointer is (L1 + L2 + n*C), where C is the length of cycle
We can say that since fast pointer moves twice as fast slow:
2*(L1+L2) = (L1 + L2 + nC)
=> L1 = nC - L2
*/

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
