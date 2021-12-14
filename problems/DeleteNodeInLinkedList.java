/*
Problem:
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given 
access to the node to be deleted directly.It is guaranteed that the node to be deleted is not a tail node in the list.

Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

Solution:
We can't just delete the address of the given node since we don't have access to the prev node.
So, what we can do instead is to copy the values of the next node until we reach the final node and we delete the final node
and we're guaranteed that the node to be deleted is not the final node.

(or)

just copy the value of the next node and delete the next node
*/

public class DeleteNodeInLinkedList {
    private static void deleteNodeN(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                break;
            }
            node = node.next;
        }
        node.next = null;
    }
    
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}