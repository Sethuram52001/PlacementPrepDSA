/*
Problem:
Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

Link: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

Solution:
Greedily select value/weight 

time complexity: O(n log n + n). O(n log n) to sort the items and O(n) to iterate through all the items for calculating the answer.

space complexity: O(1), no additional data structure has been used.
*/

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}


class ValuePerWeightComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double vwa = (double) a.value / a.weight;
        double vwb = (double) b.value / b.weight;
        if (vwa < vwb) {
            return 1;
        } else if (vwa > vwb) {
            return -1;
        }
        return 0;
    }
}

public class FractionalKnapsack {
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, new ValuePerWeightComparator());
        double maxValue = 0;
        int currWeight = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].weight + currWeight <= W) {
                currWeight += arr[i].weight;
                maxValue += arr[i].value;
            } else {
                int remWeight = W - currWeight;
                maxValue += ((double) remWeight / arr[i].weight) * arr[i].value;
                break;
            }
        }

        return maxValue;
    }
}