public class ImplementQueueUsingStack {
    class MyQueue_Amortized {
        Stack<Integer> input, output;

        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }
        
        public void push(int x) {
            input.push(x);
        }
        
        public int pop() {
            if(output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }
        
        public int peek() {
            if(output.isEmpty()) {
                while(!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }
        
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
    class MyQueue {
        Stack<Integer> st1, st2;

        public MyQueue() {
            st1 = new Stack<>();
            st2 = new Stack<>();
        }
        
        public void push(int x) {
            // swap
            // add
            // swap
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            
            st1.push(x);
            
            while(!st2.isEmpty()) {
                st1.push(st2.pop());
            }
        }
        
        public int pop() {
            return st1.pop();
        }
        
        public int peek() {
            return st1.peek();
        }
        
        public boolean empty() {
            return st1.isEmpty();
        }
    }   
}
