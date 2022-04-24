/*
Problem:
An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t):
* A customer with a card ID equal to id, checks in at the station stationName at time t.
* A customer can only be checked into one place at a time.

void checkOut(int id, string stationName, int t)
* A customer with a card ID equal to id, checks out from the station stationName at time t.

double getAverageTime(string startStation, string endStation):
* Returns the average time it takes to travel from startStation to endStation.
* The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
* The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
* There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.

Link: https://leetcode.com/problems/design-underground-system/

Solution:
HashMap - one for keeping track of checkin and another for keeping track of route with 
time taken and number of trips taken in through that round
*/

import java.util.*;

public class DesignUndergroundSystem {
    class UndergroundSystem {
        HashMap<Integer, Pair<String, Integer>> checkInMap;
        HashMap<String, Pair<Double, Integer>> routeMap;

        public UndergroundSystem() {
            checkInMap = new HashMap<>();
            routeMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkIn = checkInMap.get(id);
            checkInMap.remove(id);

            String routeName = checkIn.getKey() + "To" + stationName;
            int totalTime = t - checkIn.getValue();

            Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));
            routeMap.put(routeName, new Pair<>(route.getKey() + totalTime, route.getValue() + 1));
        }

        public double getAverageTime(String startStation, String endStation) {
            String routeName = startStation + "To" + endStation;
            Pair<Double, Integer> travel = routeMap.get(routeName);
            return travel.getKey() / travel.getValue();
        }
    }

    /**
     * Your UndergroundSystem object will be instantiated and called as such:
     * UndergroundSystem obj = new UndergroundSystem();
     * obj.checkIn(id,stationName,t);
     * obj.checkOut(id,stationName,t);
     * double param_3 = obj.getAverageTime(startStation,endStation);
     */
}