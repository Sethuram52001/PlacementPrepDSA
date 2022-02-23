/*
Problem:
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

Link: https://leetcode.com/problems/clone-graph/

Solution:
We can use a hashmap to store the copy of each node, and use bfs to 
to connect all the cloned nodes.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node neighbour : curr.neighbors) {
                if(!map.containsKey(neighbour)) {
                    map.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }
                map.get(curr).neighbors.add(map.get(neighbour));
            }
        }
        
        return map.get(node);
    }
}