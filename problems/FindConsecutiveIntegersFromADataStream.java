/*
Problem:
For a stream of integers, implement a data structure that checks if the last k integers parsed in the stream are equal to value.

Implement the DataStream class:

DataStream(int value, int k) Initializes the object with an empty integer stream and the two integers value and k.
boolean consec(int num) Adds num to the stream of integers. Returns true if the last k integers are equal to value, and false otherwise.
If there are less than k integers, the condition does not hold true, so returns false.

Link: https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/description/

Solution:
Keep track of the previous value and frequency of current streak.
*/

public class FindConsecutiveIntegersFromADataStream {
    class DataStream {
        int prevValue, freq, size;

        public DataStream(int value, int k) {
            prevValue = value;
            size = k;
        }

        public boolean consec(int num) {
            if (num == prevValue) {
                freq++;
            } else {
                freq = 0;
            }

            return freq >= size;
        }
    }
}
