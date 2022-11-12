/*
Problem:
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, 
and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

Link: https://leetcode.com/problems/find-median-from-data-stream/description/

Solution:
We can have 2 heaps, one with the smaller elements and another with the larger elements.
By doing so, we can always keep track of the median elements easily, the median is going to be either:
i. if size is odd, the largest element in the small elements collection,
ii. or if the side is even, the average of largest elements from both collections.
(This is logic is based on the assumption that the small elements collection always has the extra element
in case of odd number of elements)
*/

import java.util.*;

public class FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> min, max;

        public MedianFinder() {
            min = new PriorityQueue<>((a, b) -> b - a);
            max = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            min.offer(num);
            max.offer(min.remove());
            if (min.size() < max.size()) {
                min.offer(max.remove());
            }
        }

        public double findMedian() {
            if (min.size() == max.size()) {
                return (min.peek() + max.peek()) / 2.0;
            } else {
                return min.peek();
            }
        }
    }
}
