/*
Problem:
You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 
of the actual answer will be accepted.

Link: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/

Solution:
Keep track of the minimum and maximum salary while summing up all the salaries.
Now subtract the minimum and maximum salaries from the total and calculate the average.
*/

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        double avg = 0;
        for(int sal : salary) {
            sum += sal;
            min = Math.min(sal, min);
            max = Math.max(sal, max);
        }

        avg = (double)(sum - min - max) / (salary.length - 2);
        return avg;
    }    
}
