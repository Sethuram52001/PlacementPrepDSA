
/*
Problem:
You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, 
where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

numberOfBoxesi is the number of boxes of type i.
numberOfUnitsPerBoxi is the number of units in each box of the type i.
You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. 
You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

Return the maximum total number of units that can be put on the truck.

Link: https://leetcode.com/problems/maximum-units-on-a-truck/

Solution:
1. greedy + sorting: We can sort the boxes according to the number of units packed into it. Next, now we can greedily select the 
boxes with higher number of units first and move it into the truck.
time complexity: O(N*log(N))
space complexity: O(N)

2. greedy + counting sort: We can use counting sort to create a mapping from the number of units to number of boxes. Next, now we can
iterate from the boxes with highest number of units to the boxes with lowest number of units - greedily select the boxess and move 
it into the truck.
time complexity: O(N)
space complexity: O(N)

*/
import java.util.*;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] countBoxes = new int[1001];
        for (int[] box : boxTypes) {
            countBoxes[box[1]] += box[0];
        }

        int maxUnits = 0;
        for (int i = 1000; i >= 0 && truckSize > 0; i--) {
            int boxes = (truckSize < countBoxes[i]) ? truckSize : countBoxes[i];
            maxUnits += boxes * i;
            truckSize -= boxes;
        }

        return maxUnits;
    }

    public int maximumUnits_Greedy(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int boxes = (boxTypes[i][0] > truckSize) ? truckSize : boxTypes[i][0];
            maxUnits += boxes * boxTypes[i][1];
            truckSize -= boxes;
        }

        return maxUnits;
    }
}