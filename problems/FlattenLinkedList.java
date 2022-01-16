import java.util.PriorityQueue;

/*
Problem:
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Link: https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
*/

public class FlattenLinkedList {

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flattenExtraSpace(Node root) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Node curr = root;
        while (curr != null) {
            Node temp = curr;
            while (temp != null) {
                pq.add(temp.data);
                temp = temp.bottom;
            }
            curr = curr.next;
        }

        Node dummyHead = new Node(-1);
        curr = dummyHead;
        while (!pq.isEmpty()) {
            curr.bottom = new Node(pq.remove());
            curr = curr.bottom;
        }

        return dummyHead.bottom;
    }

    Node merge(Node a, Node b) {
        Node res = new Node(-1), curr = res;
        while (a != null && b != null) {
            if (a.data < b.data) {
                curr.bottom = a;
                curr = curr.bottom;
                a = a.bottom;
            } else {
                curr.bottom = b;
                curr = curr.bottom;
                b = b.bottom;
            }
        }

        if (a != null) {
            curr.bottom = a;
        } else {
            curr.bottom = b;
        }
        return res.bottom;
    }

    Node flatten(Node root) {
        // Your code here
        if (root == null || root.next == null) {
            return root;
        }

        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }
}
