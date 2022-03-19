/*
Problem:
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

* FreqStack() constructs an empty frequency stack.
* void push(int val) pushes an integer val onto the top of the stack.
* int pop() removes and returns the most frequent element in the stack.
* If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

Link: https://leetcode.com/problems/maximum-frequency-stack/

Solution:
We can maintain 2 hashmaps:
1. one hashmap as a freqmap
2. another hashmap for grouping the values with the same frequencies
*/

public class MaximumFrequencyStack {
    class FreqStack {
        HashMap<Integer, Integer> freqMap;
        HashMap<Integer, Stack<Integer>> groups;
        int maxFreq;

        public FreqStack() {
            this.freqMap = new HashMap<>();
            this.groups = new HashMap<>();
            this.maxFreq = 0;
        }

        public void push(int val) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            if (freqMap.get(val) > maxFreq) {
                maxFreq = freqMap.get(val);
            }

            if (!groups.containsKey(freqMap.get(val))) {
                groups.put(freqMap.get(val), new Stack<>());
            }

            groups.get(freqMap.get(val)).push(val);
        }

        public int pop() {
            int freq = groups.get(maxFreq).pop();
            freqMap.put(freq, freqMap.get(freq) - 1);
            if (groups.get(maxFreq).size() == 0) {
                maxFreq--;
            }
            return freq;
        }
    }

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */
}