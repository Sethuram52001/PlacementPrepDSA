/*
Problem:
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current 
node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous 
node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

* MyLinkedList() Initializes the MyLinkedList object.
* int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
* void addAtHead(int val) Add a node of value val before the first element of the linked list. 
  After the insertion, the new node will be the first node of the linked list.
* void addAtTail(int val) Append a node of value val as the last element of the linked list.
* void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. 
  If index equals the length of the linked list, the node will be appended to the end of the linked list. 
  If index is greater than the length, the node will not be inserted.
* void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

Link: https://leetcode.com/problems/design-linked-list/

Solution:
Basic linked list implementation
*/

public class DesignLinkedList {
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {
        Node head, tail;
        int size = 0;

        public MyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public int get(int index) {
            Node node = getNode(index);
            return node == null ? -1 : node.val;
        }

        private Node getNode(int index) {
            if (index < 0 || index >= this.size) {
                return null;
            }

            Node curr = this.head;
            while (index-- > 0) {
                curr = curr.next;
            }

            return curr;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
            this.size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            if (this.size == 0) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
                this.tail.next = null;
            }
            this.size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > this.size) {
                return;
            }

            if (index == 0) {
                addAtHead(val);
            } else if (index == this.size) {
                addAtTail(val);
            } else {
                Node prev = getNode(index - 1);
                Node next = prev.next;
                prev.next = new Node(val);
                prev = prev.next;
                prev.next = next;
                this.size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (this.size == 0 || index < 0 || index >= this.size) {
                return;
            }

            if (index == 0) {
                deleteHead();
            } else if (index == this.size - 1) {
                deleteTail();
            } else {
                Node prev = getNode(index - 1);
                Node next = prev.next.next;
                prev.next = next;
                this.size--;
            }
        }

        private void deleteHead() {
            Node head = this.head;
            Node newHead = head.next;
            head.next = null;
            this.head = newHead;
            this.size--;
        }

        private void deleteTail() {
            Node secondLast = getNode(this.size - 2);
            secondLast.next = null;
            this.tail = secondLast;
            this.size--;
        }
    }
}