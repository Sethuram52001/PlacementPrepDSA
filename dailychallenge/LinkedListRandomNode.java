/*
Problem:
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.

Link: https://leetcode.com/problems/linked-list-random-node/

Solution:
Reservoir Sampling algorithm - In order to do random sampling over a population of unknown size with constant space, the answer is reservoir sampling.
The reservoir sampling algorithm is intended to sample k elements from an population of unknown size. In our case, the k happens to be one.

reservoir algo => k/i
select the element if Math.random() < k/i
k is the number of elements to be chosen
*/

public class LinkedListRandomNode {
    ListNode head;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int n = 1;
        int chosenValue = 0;
        ListNode curr = this.head;
        
        while(curr != null) {
            if(Math.random() < 1.0/n) {
                chosenValue = curr.val;
            }
            n++;
            curr = curr.next;
        }
        return chosenValue;
    }
}
