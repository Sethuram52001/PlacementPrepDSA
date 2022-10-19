
/*
Problem:
Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with 
the same frequency by their lexicographical order.

Link: https://leetcode.com/problems/top-k-frequent-words/

Solution:
1. We can use heap to sort them by frequency and lexicographical order.
2. We can use bucket sort; each frequency in different bucket and to maintain the
lexicographically order, we will use a trie to store the words in each frequency bucket.
*/
import java.util.*;
import javafx.util.Pair;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        Trie[] buckets = new Trie[words.length];
        for(String word : freqMap.keySet()) {
            int freq = freqMap.get(word);
            if(buckets[freq] == null) {
                buckets[freq] = new Trie();
            }
            buckets[freq].add(word);
        }
        
        List<String> res = new ArrayList<>();
        
        for(int i = buckets.length - 1; i >= 0; i--) {
            if(buckets[i] == null) {
                continue;
            }
            
            List<String> wordList = new LinkedList<>();
            buckets[i].getWords(buckets[i].root, wordList);
            if(wordList.size() < k) {
                res.addAll(wordList);
                k -= wordList.size();
            } else {
                for(int j = 0; j < k; j++) {
                    res.add(wordList.get(j));
                }   
                break;
            }
        }
        
        return res;
    }
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    
    class Trie {
        TrieNode root = new TrieNode();

        public void add(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        public void getWords(TrieNode node, List<String> res) {
            if (node == null) {
                return;
            }

            if (node.word != null) {
                res.add(node.word);
            }

            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    getWords(node.children[i], res);
                }
            }
        }
    }
    
    public List<String> topKFrequent_(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((a,
                b) -> b.getValue() == a.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (String word : freqMap.keySet()) {
            Pair<String, Integer> pair = new Pair<>(word, freqMap.get(word));
            pq.add(pair);
        }

        List<String> topKWords = new ArrayList<>();
        while (k-- > 0) {
            Pair<String, Integer> pair = pq.remove();
            topKWords.add(pair.getKey());
        }

        return topKWords;
    }
}
