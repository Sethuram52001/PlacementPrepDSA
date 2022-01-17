/*
Problem:
You are given the schedule of N meetings with their start time Start[i] and end time End[i]. But you have only 1 meeting room. 
So, you need to tell the meeting numbers you can organize in the given room, such that the number of meetings organized is maximum.

Link: https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

Solution:
Greedily sort the meetings according to their ending time and compare them 
*/

import java.util.*;

class Meeting {
    int idx;
    int start;
    int end;

    Meeting(int idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }
}

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting a, Meeting b) {
        if (a.end < b.end) {
            return -1;
        } else if (a.end > b.end) {
            return 1;
        } else if (a.idx < b.idx) {
            return -1;
        }
        return 1;
    }
}

public class NMeetingsInOneRoom {

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        //Write your code here
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(i, start[i], end[i]));
        }

        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings, mc);

        List<Integer> ans = new ArrayList<>();
        ans.add(meetings.get(0).idx + 1);
        int limit = meetings.get(0).end;
        for (Meeting meeting : meetings) {
            if (meeting.start > limit) {
                ans.add(meeting.idx + 1);
                limit = meeting.end;
            }
        }

        /*for(Meeting meeting : meetings) {
            System.out.println("idx : " + meeting.idx + " start: " + meeting.start + " end: " + meeting.end);
        }*/

        return ans;
    }
}