public class MinStack {
    Stack<Integer> st, minStack;

    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        if(!st.isEmpty() && !minStack.isEmpty()) {
            if(minStack.peek().equals(st.peek()))
                minStack.pop();
            st.pop();
        }
    }
    
    public int top() {
        return st.isEmpty() ? -1 : st.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }   
}