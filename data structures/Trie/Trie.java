/**
 * Time complexity: 
 * The complexity of creating a trie is O(W*L), where W is the number of words, and L is an average length of the word: 
 * you need to perform L lookups on the average for each of the W words in the set.
 * Same goes for looking up words later: you perform L steps for each of the W words.
 */

class TrieNode {
    TrieNode[] links;
    boolean flag;

    TrieNode() {
        links = new TrieNode[26];
        flag = false;
    }

    boolean containsKey(char ch) {
        return links[ch] != null;
    }

    void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }
}

public class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    public boolean startWith(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }
}