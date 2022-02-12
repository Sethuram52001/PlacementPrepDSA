public class StackArray {
    int top;
    final int max = 1000;
    int[] st;

    StackArray() {
        top = -1;
        st = new int[max];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void push(int val) {
        if (top == max - 1) {
            System.out.println("Can't insert stack is full");
        } else {
            st[++top] = val;
        }
    }
    
    private int pop() {
        if (top == -1) {
            System.out.println("Can't use pop on empty stack");
            return -1;
        } else {
            int poppedValue = st[top--];
            return poppedValue;
        }
    }
    
    private int peek() {
        if (top == -1) {
            System.out.println("Stack is emtpy!");
            return -1;
        } else {
            return st[top];
        }
    }
    
    private void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(st[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        System.out.println("is stack empty?: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(2);
        System.out.println("popped:" + stack.pop());
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.peek();
        stack.print();
    }
}