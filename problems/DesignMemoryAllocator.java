/*
Problem:
You are given an integer n representing the size of a 0-indexed memory array. All memory units are initially free.

You have a memory allocator with the following functionalities:

Allocate a block of size consecutive free memory units and assign it the id mID.
Free all memory units with the given id mID.
Note that:

Multiple blocks can be allocated to the same mID.
You should free all the memory units with mID, even if they were allocated in different blocks.
Implement the Allocator class:

Allocator(int n) Initializes an Allocator object with a memory array of size n.
int allocate(int size, int mID) Find the leftmost block of size consecutive free memory units and allocate it with the id mID. Return the block's first index. If such a block does not exist, return -1.
int free(int mID) Free all memory units with the id mID. Return the number of memory units you have freed.

Link: https://leetcode.com/problems/design-memory-allocator/description/

Solution:
i. Simulation using brute force
ii. efficient solution: 
a. https://leetcode.com/problems/design-memory-allocator/solutions/2899668/two-maps/?orderBy=most_votes
b. https://leetcode.com/problems/design-memory-allocator/solutions/2899607/java-solution-treemap/?orderBy=most_votes

References:
1. https://leetcode.com/problems/design-memory-allocator/solutions/2899668/two-maps/?orderBy=most_votes
2. https://leetcode.com/problems/design-memory-allocator/solutions/2899607/java-solution-treemap/?orderBy=most_votes

*/
import java.util.*;

public class DesignMemoryAllocator {
    class Allocator {
        boolean[] memory;
        Map<Integer, List<Integer>> map;
        int cap;

        public Allocator(int n) {
            memory = new boolean[n];
            cap = n;
            map = new HashMap<>();
        }

        public int allocate(int size, int mID) {
            boolean flag = false;
            int i = 0;
            for (i = 0; i <= cap - size; i++) {
                if (isFree(i, i + size)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                if (!map.containsKey(mID)) {
                    map.put(mID, new ArrayList<>());
                }
                for (int j = i; j < size + i; j++) {
                    memory[j] = true;
                    map.get(mID).add(j);
                }
            }

            return flag ? i : -1;
        }

        public int free(int mID) {
            if (map.containsKey(mID)) {
                int size = map.get(mID).size();
                List<Integer> spaces = map.get(mID);
                for (Integer i : spaces) {
                    memory[i] = false;
                }

                map.remove(mID);
                return size;
            }

            return 0;
        }

        private boolean isFree(int start, int end) {
            for (int i = start; i < end; i++) {
                if (memory[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}


/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */   
