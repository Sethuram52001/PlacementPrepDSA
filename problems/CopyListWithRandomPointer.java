/*
Problem:
A  linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of 
its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the 
pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the 
original list.

Link: https://leetcode.com/problems/copy-list-with-random-pointer/

Solution:
We can use 2 pointer approach
*/

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node front = head;
        
        while(curr != null) {
            front = curr.next;
            
            Node temp = new Node(curr.val);
            curr.next = temp;
            temp.next = front;
            
            curr = front;
        }
        
        curr = head;
        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node dummyHead = new Node(-1);
        Node copy = dummyHead;
        
        while(curr != null) {
            front = curr.next.next;
            
            copy.next = curr.next;
            copy = copy.next;
            
            curr.next = front;
            
            curr = front;
        }
        
        return dummyHead.next;
    }
}