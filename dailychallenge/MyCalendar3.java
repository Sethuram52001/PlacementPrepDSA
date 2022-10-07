/*
Problem:
A k-booking happens when k events have some non-empty intersection (i.e., there is some time that is common to all k events.)

You are given some events [start, end), after each given event, return an integer k representing the maximum k-booking between all the previous events.

Implement the MyCalendarThree class:

MyCalendarThree() Initializes the object.
int book(int start, int end) Returns an integer k representing the largest integer such that there exists a k-booking in the calendar.

Link: https://leetcode.com/problems/my-calendar-iii/

Solution:
Sweep-line Algorithm:
Intuition:
If we look at each time point separately, our task is to find out how many events are going on at this time point and find the time 
point of the max number of events. Every time we book a new event [start, end), what we actually do is add 1 to the event counts to 
all time points in the range [start, end). The final result of each book call is exactly the max count of a single time in the whole 
range of [1, 1e9).

For such kind of problem that increases all counts in some ranges by some constant values several times and asks to obtain all 
counts for those time points, we have a very classic solution called sweep-line algorithm: instead of keeping all values of 
counts in a traditional way, we use a differential array to represent the change that occurs at each time point. In this problem, we will increase 
the count by 1 at point start and decrease the count by 1 at point end. After enumerating all booked events and updating the 
differential array, we can simulate scanning the differential array with a vertical sweep-line from the origin time point 0 to 
the maximum 1e9 and obtain the prefix sum at each time point t, which is also the event count of time t. All we need to do now 
is find the maximum value of such counts when we scan the array.

Reference:
1. https://leetcode.com/problems/my-calendar-iii/solution/
2. https://leetcode.com/problems/my-calendar-iii/discuss/109556/JavaC%2B%2B-Clean-Code
*/

import java.util.*;

public class MyCalendar3 {
    Map<Integer, Integer> calendar;
    public MyCalendar3() {
        this.calendar = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        this.calendar.put(start, this.calendar.getOrDefault(start, 0) + 1);
        this.calendar.put(end, this.calendar.getOrDefault(end, 0) - 1);
        int k = 0, liveEvents = 0;
        
        for(int events : this.calendar.values()) {
            liveEvents += events;
            k = Math.max(liveEvents, k);
        }
        
        return k;
    }    
}
