/*
Problem:
Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

Implementation the MyCircularQueue class:

MyCircularQueue(k) Initializes the object with the size of the queue to be k.
int Front() Gets the front item from the queue. If the queue is empty, return -1.
int Rear() Gets the last item from the queue. If the queue is empty, return -1.
boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
boolean isEmpty() Checks whether the circular queue is empty or not.
boolean isFull() Checks whether the circular queue is full or not.
You must solve the problem without using the built-in queue data structure in your programming language. 

Link: https://leetcode.com/problems/design-circular-queue/
*/

public class DesignCircularQueue {
    int[] queue;
    int front = 0, rear = -1, size = 0;
        
    public DesignCircularQueue(int k) {
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(!isFull()) {
            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            size += 1;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(!isEmpty()) {
            front = (front + 1) % queue.length;
            size -= 1;
            return true;
        }
        return false;
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}