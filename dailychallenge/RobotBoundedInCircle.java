/*
Problem:
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Link: https://leetcode.com/problems/robot-bounded-in-circle/

Solution:
We can iterate throught the instructions only once.
If we end up in the same position or facing any other direction other than north we can say that it 
is caught in a loop, this can be proved.
*/

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        char direction = 'N';
        char[] directions = instructions.toCharArray();

        int x = 0, y = 0;
        for (char instruction : directions) {
            if (instruction == 'G') {
                if (direction == 'N') {
                    y++;
                } else if (direction == 'E') {
                    x++;
                } else if (direction == 'S') {
                    y--;
                } else {
                    x--;
                }
            } else if (instruction == 'R') {
                if (direction == 'N') {
                    direction = 'E';
                } else if (direction == 'E') {
                    direction = 'S';
                } else if (direction == 'S') {
                    direction = 'W';
                } else {
                    direction = 'N';
                }
            } else {
                if (direction == 'N') {
                    direction = 'W';
                } else if (direction == 'E') {
                    direction = 'N';
                } else if (direction == 'S') {
                    direction = 'E';
                } else {
                    direction = 'S';
                }
            }
        }

        return (x == 0 && y == 0) || direction != 'N';
    }
}
