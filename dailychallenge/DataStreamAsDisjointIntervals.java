/*
Problem:
Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a 
list of disjoint intervals.

Implement the SummaryRanges class:

SummaryRanges() Initializes the object with an empty stream.
void addNum(int value) Adds the integer value to the stream.
int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint 
intervals [starti, endi]. The answer should be sorted by starti.

Link: https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/

Solution:
We can use a sorted set to maintain values in ascending order, and iterate over it every time to find
disjoint sets.
*/

public class DataStreamAsDisjointIntervals {
class SummaryRanges {
    Set<Integer> values;
    public SummaryRanges() {
        values = new TreeSet<>();
    }
    
    public void addNum(int value) {
        values.add(value);
    }
    
    public int[][] getIntervals() {
        if(values.isEmpty()) {
            return new int[0][2];
        }

        List<int[]> intervals = new ArrayList<>();
        int left = -1, right = -1;
        for(Integer value : values) {
            if(left < 0) {
                left = right = value;
            } else if(right + 1 == value) {
                right = value;
            } else {
                intervals.add(new int[]{left, right});
                left = right = value;
            }
        }
        intervals.add(new int[]{left, right});

        return intervals.toArray(new int[0][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
}
