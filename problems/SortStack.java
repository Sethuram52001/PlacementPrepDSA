/*
Problem:
You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.

Link: 
i. https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
ii. https://www.geeksforgeeks.org/sort-a-stack-using-recursion/

Solution:
algorithm:
sortStack(stack S)
    if stack is not empty:
        temp = pop(S);  
        sortStack(S); 
        sortedInsert(S, temp);

sortedInsert(Stack S, element)
    if stack is empty OR element > top element
        push(S, elem)
    else
        temp = pop(S)
        sortedInsert(S, element)
        push(S, temp)
*/

public class SortStack {
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
		if(!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            sortedInsert(stack, temp);
        }
    }
    
    private static void sortedInsert(Stack<Integer> stack, int val) {
        if(stack.isEmpty() || stack.peek() < val) {
            stack.push(val);
        }
        else {
            int temp = stack.pop();
            sortedInsert(stack, val);
            stack.push(temp);
        }
    }   
}