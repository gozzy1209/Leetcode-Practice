package Tries;
//Design Add and Search Words Data Structure
/* Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.*/

//this problem like trietree
class word{
    public boolean endword;
    public word[] wordchildren=new word[56];
    public word(){};
}
class WordDictionary {
    private word root;

    public WordDictionary() {
        //root是一个空结点，不代表任何字母，只是word的children有a-z26个字母
        root=new word();
    }
    
    public void addWord(String word) {
        word cur=root;
        for(int i=0;i<word.length();i++){
            char s=word.charAt(i);
            if(cur.wordchildren[s-'a']==null){
                cur.wordchildren[s-'a']=new word();
            }
            cur=cur.wordchildren[s-'a'];
        }
        cur.endword=true;

    }
    
    //search isn't written by me
    //https://leetcode.com/problems/design-add-and-search-words-data-structure/solutions/59673/simple-java-solution-trie-dfs-recursion/?languageTags=java
    public boolean search(String word) {
        return match(word, 0, root);
    }
    
    private boolean match(String word, int step, word node) {
        if (word.length() == step) return node.endword;
        char c = word.charAt(step);
        if (c != '.') {
            return node.wordchildren[c-'a'] != null && match(word, step+1, node.wordchildren[c-'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.wordchildren[i] != null && match(word, step+1, node.wordchildren[i])) return true;
            }
            return false;
        }
}
}
