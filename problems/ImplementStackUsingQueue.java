/*
Problem:
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a
normal stack (push, top, pop, and empty).

Link: https://leetcode.com/problems/implement-stack-using-queues/

Solution:
We can use 2 queues or 1 queue to manipulate the FIFO action of queue to act like LIFO of stack.
*/

public class ImplementStackUsingQueue {
    class MyStack {
        Queue<Integer> q;
        
        public MyStack() {
            q = new ArrayDeque<>();
        }
        
        public void push(int x) {
            // 1. add to q2
            // 2. add all elements of q1 to q2
            // 3. now swap q1 and q2
            q.add(x);
            int size = q.size();
            while(size > 1) {
                q.add(q.remove());
                size--;
            }
        }
        
        public int pop() {
            return q.remove();
        }
        
        public int top() {
            return q.peek();
        }
        
        public boolean empty() {
            return q.isEmpty();
        }
    }

    class MyStack_2Queue {
        Queue<Integer> q1, q2;
        
        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }
        
        public void push(int x) {
            // 1. add to q2
            // 2. add all elements of q1 to q2
            // 3. now swap q1 and q2
            q2.add(x);
            while(!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        
        public int pop() {
            return q1.remove();
        }
        
        public int top() {
            return q1.peek();
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }    
}