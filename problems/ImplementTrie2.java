class Node {
    Node[] links;
    int countEndWith;
    int countPrefix;
    
    Node() {
        links = new Node[26];
        countEndWith = 0;
        countPrefix = 0;
    }
    
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    Node get(char ch) {
        return links[ch - 'a'];
    }
    
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    
    int getEnd() {
        return countEndWith;
    }
    
    int getPrefix() {
        return countPrefix;
    }
    
    void increaseEnd() {
        countEndWith++;
    }
    
    void increasePrefix() {
        countPrefix++;
    }
    
    void deleteEnd() {
        countEndWith--;
    } 
    
    void reducePrefix() {
        countPrefix--;
    }
}

class Trie {
    Node root;

    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }

}