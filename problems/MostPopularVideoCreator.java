/*
Problem:
You are given two string arrays creators and ids, and an integer array views, all of length n. The ith video on a platform was created by creator[i], has an id of ids[i], 
and has views[i] views.

The popularity of a creator is the sum of the number of views on all of the creator's videos. Find the creator with the highest popularity and the id of their most viewed video.

If multiple creators have the highest popularity, find all of them.
If multiple videos have the highest view count for a creator, find the lexicographically smallest id.
Return a 2D array of strings answer where answer[i] = [creatori, idi] means that creatori has the highest popularity and idi is the id of their most popular video. 
The answer can be returned in any order.

Link: https://leetcode.com/problems/most-popular-video-creator/

Solution:
We can maintain a 2 hashmaps.
i. First hashmap, to map the user with number of views.
ii. Second hashmap, to map the user with his most popular video.
*/

import java.util.*;
import javafx.util.Pair;

public class MostPopularVideoCreator {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> popularCreators = new ArrayList<>();
        Map<String, Long> creatorToViews = new HashMap<>();
        Map<String, Pair<String, Integer>> popVideo = new HashMap<>();
        long maxViews = Integer.MIN_VALUE;

        for (int i = 0; i < creators.length; i++) {
            creatorToViews.put(creators[i], creatorToViews.getOrDefault(creators[i], 0L) + views[i]);
            maxViews = Math.max(maxViews, creatorToViews.get(creators[i]));

            if (popVideo.containsKey(creators[i])) {
                if ((popVideo.get(creators[i]).getValue() < views[i])
                        || (popVideo.get(creators[i]).getValue() == views[i]
                                && popVideo.get(creators[i]).getKey().compareTo(ids[i]) > 0)) {
                    popVideo.put(creators[i], new Pair(ids[i], views[i]));
                }
            } else {
                popVideo.put(creators[i], new Pair(ids[i], views[i]));
            }
        }

        for (String key : creatorToViews.keySet()) {
            if (creatorToViews.get(key) == maxViews) {
                List<String> temp = new ArrayList<>();
                temp.add(key);
                temp.add(popVideo.get(key).getKey());
                popularCreators.add(new ArrayList<>(temp));
            }
        }
        return popularCreators;
    }
}
