/*
Problem:
Alice and Bob are traveling to Rome for separate business meetings.
You are given 4 strings arriveAlice, leaveAlice, arriveBob, and leaveBob. Alice will be in the city 
from the dates arriveAlice to leaveAlice (inclusive), while Bob will be in the city from the dates 
arriveBob to leaveBob (inclusive). Each will be a 5-character string in the format "MM-DD", corresponding 
to the month and day of the date.

Return the total number of days that Alice and Bob are in Rome together.
You can assume that all dates occur in the same calendar year, which is not a leap year. Note that the 
number of days per month can be represented as: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31].


Link: https://leetcode.com/problems/count-days-spent-together/

*/

public class CountDaysSpentTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String startDate = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String endDate = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;
        if(startDate.compareTo(endDate) > 0) {
            return 0;
        }
        int startMonth = Integer.parseInt(startDate.substring(0, 2));
        int startDay = Integer.parseInt(startDate.substring(3));
        int endMonth = Integer.parseInt(endDate.substring(0, 2));
        int endDay = Integer.parseInt(endDate.substring(3));
        
        if(startMonth == endMonth) {
            return endDay - startDay + 1;
        } else { 
            int daysSpentTogether = daysInMonth[startMonth - 1] - startDay;
            for(int month = startMonth + 1; month < endMonth; month++) {
                daysSpentTogether += daysInMonth[month - 1];
            }
            daysSpentTogether += endDay + 1;
            return daysSpentTogether;
        }
    }
}