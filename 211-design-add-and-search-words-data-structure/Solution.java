import java.util.Set;

class WordDictionary {
    private Node dict;
    private Set<String> words;

    public WordDictionary() {
        this.dict = new Node();
        this.words = new HashSet<>();
    }
    
    public void addWord(String word) {
        if (words.contains(word)) {
            return;
        }
        // add to set
        words.add(word);
        
        // add to dictionary
        Node root = dict;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // NOTICE:
            // ```root = root.getChildren()[c - 'a']; root = new Node();```
            // will not work! because array reference is passed by value
            // ```array[i] = new Node();```  must directly assgin a value to array element!
            if (root.getChildren()[c - 'a'] == null) {
                root.getChildren()[c - 'a'] = new Node();
                root.getChildren()[c - 'a'].setVal(c);
            }
            root = root.getChildren()[c - 'a'];
        }
        root.getChildren()[26] = new Node();
        root.getChildren()[26].setVal('1'); // the end of this word. indicating there exist this word with no further tails
    }
    
    public boolean search(String word) {
        if (word.indexOf(".") < 0) {
            return words.contains(word);
        }

        Node root = dict;
        return search(word, root);
    }

    private boolean search(String word, Node root) {
        // 1 <= word.length() <= 25 in this question
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            //System.out.println("current: " + c);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (root.getChildren()[j] != null) {
                        boolean b = search(word.substring(i + 1), root.getChildren()[j]);
                        if (b) return true;
                    }
                }
                return false;
            } else {
                root = root.getChildren()[c - 'a'];
                if (root == null) {
                    //System.out.println("this char is null in tree: " + c);
                    return false;
                }
            }
        }
        char last = word.charAt(word.length() - 1);
        Node[] arr = root.getChildren();
        if (last == '.') {
            for (int i = 0; i < 26; i++) {
                if (arr[i] != null && arr[i].getChildren()[26] != null) {
                    return true;
                } 
            }
        } else if (arr[last - 'a'] != null && arr[last - 'a'].getChildren()[26] != null) {
            return true; 
        }
        return false;
    }
}
// Trie
class Node {
    char val;
    Node[] children;
    public Node() {
        this.val = '0'; // set a default char
        this.children = new Node[27]; // 27th slot is for the last char of a word
    }
    public char getVal() {return this.val;}
    public Node[] getChildren() {return this.children;}
    public void setVal(char c) {this.val = c;}
    // public void printChildren() {
    //     System.out.println("print children...");
    //     for (int i = 0; i < 26; i++) {
    //         if (children[i] != null) System.out.print(children[i].getVal() + " ");
    //     }
    // }
}


