/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

* WordDictionary() Initializes the object.
* void addWord(word) Adds word to the data structure, it can be matched later.
* bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may 
  contain dots '.' where dots can be matched with any letter.


Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/

Solution:
We can use trie for the word data structure, and use backtracking to guess the correct character for the '.' character which can match anything.
*/

class TrieNode {
    TrieNode links[];
    boolean flag;
    
    TrieNode() {
        links = new TrieNode[26];
        flag = false;
    }
    
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    
    TrieNode get(char ch) {
        return links[ch - 'a'];
    }
    
    void setEnd() {
        flag = true;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        return match(word, 0, node);
    }

    private boolean match(String word, int idx, TrieNode node) {
        if (idx == word.length()) {
            return node.flag;
        }

        if (word.charAt(idx) != '.') {
            char ch = word.charAt(idx);
            return node.containsKey(ch) && match(word, idx + 1, node.get(ch));
        }

        else {
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 97);
                if (node.containsKey(ch) && match(word, idx + 1, node.get(ch))) {
                    return true;
                }
            }
        }
        return false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */