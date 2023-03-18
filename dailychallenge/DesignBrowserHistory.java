/*
Problem:
You have a browser of one tab where you start on the homepage and you can visit another url, 
get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the 
history and steps > x, you will return only x steps. Return the current url after moving back 
in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in 
the history and steps > x, you will forward only x steps. Return the current url after forwarding 
in history at most steps.

Link: https://leetcode.com/problems/design-browser-history/description/

Solution:
Maintain 2 stacks, one for history and another for future reference(for forward operation), and 
current url variable.

When visit:
* Push current into stack, and store the new url in current variable.
* Clear the future stack.

When back:
* Pop it from history stack and push it into future stack.

When forward:
* Pop it from future stack and push it into history stack.
*/

import java.util.*;

public class DesignBrowserHistory {
    class BrowserHistory {
        Stack<String> history, future;
        String current;

        public BrowserHistory(String homepage) {
            history = new Stack<>();
            future = new Stack<>();
            current = homepage;
        }

        public void visit(String url) {
            history.push(current);
            current = url;
            future = new Stack<>();
        }

        public String back(int steps) {
            while (steps > 0 && !history.isEmpty()) {
                future.push(current);
                current = history.pop();
                steps--;
            }
            return current;
        }

        public String forward(int steps) {
            while (steps > 0 && !future.isEmpty()) {
                history.push(current);
                current = future.pop();
                steps--;
            }
            return current;
        }
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */
}
