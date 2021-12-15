/*
Problem:
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
If the two linked lists have no intersection at all, return null.

Link: https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/

Solution:
A->B->C->D->E
X->C->D->E

intersection it at C, so what we can do is similar to find the starting point of a loop in floyd and tortoise we move the currA
to headB and currB to headA once once complete iteration is complete.
We can prove mathematically that the meeting point is the intersection point, in case of no intersection both end up as null.

*/

public class IntersectionOfTwoLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;

        while (currA != currB) {
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }

        return currA;
    }
}
