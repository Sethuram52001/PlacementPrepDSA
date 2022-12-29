/*
Problem:
You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = 
[enqueueTimei, processingTimei] means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and
will take processingTimei to finish processing.

You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
* If the CPU is idle and there are no available tasks to process, the CPU remains idle.
* If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. 
If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
* Once a task is started, the CPU will process the entire task without stopping.
* The CPU can finish a task then start a new one instantly.

Return the order in which the CPU will process the tasks.

Link: https://leetcode.com/problems/single-threaded-cpu/description/

Solution:
* To simulate the problem we first need to note that if at any point in time there are no enqueued tasks we need 
to wait to the smallest enqueue time of a non-processed element.
* We need a data structure like a min-heap to support choosing the task with the smallest processing time from 
all the enqueued tasks.

Reference:
1. https://leetcode.com/problems/single-threaded-cpu/solutions/2216661/single-threaded-cpu/?orderBy=most_votes
*/

import java.util.*;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks = new int[tasks.length][3];
        PriorityQueue<int[]> nextTasks = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

        for (int idx = 0; idx < tasks.length; idx++) {
            sortedTasks[idx][0] = tasks[idx][0];
            sortedTasks[idx][1] = tasks[idx][1];
            sortedTasks[idx][2] = idx;
        }

        Arrays.sort(sortedTasks, (a, b) -> a[0] - b[0]);
        int[] order = new int[tasks.length];
        int currTime = 0, taskIdx = 0, resIdx = 0;

        while (!nextTasks.isEmpty() || taskIdx < tasks.length) {
            if (nextTasks.isEmpty() && currTime < sortedTasks[taskIdx][0]) {
                currTime = sortedTasks[taskIdx][0];
            }

            while (taskIdx < tasks.length && currTime >= sortedTasks[taskIdx][0]) {
                nextTasks.add(sortedTasks[taskIdx]);
                taskIdx++;
            }

            int[] task = nextTasks.remove();
            int processingTime = task[1];
            currTime += processingTime;
            order[resIdx++] = task[2];
        }

        return order;
    }
}
