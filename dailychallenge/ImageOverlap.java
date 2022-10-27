/*
Problem:
You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. We then place it on top 
of the other image. We can then calculate the overlap by counting the number of positions that have a 1 in both images.
Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
Return the largest possible overlap.

Link: https://leetcode.com/problems/image-overlap/

Solution:
Store the indices where we encounter 1's in both image matrices in two separate lists.
Now, iterate over the each combination of coordinates and store the frequency of encounters
for comman shifts which can be tracked by (img1[0] - img2[0]) + " " + (img1[1] - img2[1]) as the 
key. We can use a hash table to keep track of the frequencies of such occurences and find
the maximum of those values.
*/

import java.util.*;

public class ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]> setImg1 = new ArrayList<>(), setImg2 = new ArrayList<>();
        for(int r = 0; r < img1.length; r++) {
            for(int c = 0; c < img1[0].length; c++) {
                if(img1[r][c] == 1) {
                    setImg1.add(new int[]{r, c});
                }
                if(img2[r][c] == 1) {
                    setImg2.add(new int[]{r, c});
                }
            }
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(int[] s1 : setImg1) {
            for(int[] s2 : setImg2) {
                String key = (s1[0] - s2[0]) + " " + (s1[1] - s2[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        int maxOverLap = 0;
        for(Integer overlap : map.values()) {
            maxOverLap = Math.max(maxOverLap, overlap);
        }
        
        return maxOverLap;
    }    
}
