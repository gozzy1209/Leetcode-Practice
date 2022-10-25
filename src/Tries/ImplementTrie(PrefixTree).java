package Tries;

import Trees.TreeNode;

//208. Implement Trie (Prefix Tree)
/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 */
class TrieNode{
    public boolean isword;
    public TrieNode[] children=new TrieNode[26];
    public TrieNode(){};
}

class Trie {
    private TrieNode root;
    public Trie(){
        //root是一个空结点，不代表任何字母，只是word的children有a-z26个字母
        root=new TrieNode();
    }
    
    
    public void insert(String word) {
        //why set cur as root?because root is defined previously 
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            //下面这几步很关键，不太懂
            //每一个cur（结点）所包含的children【】属性中，都有一个数组中特定索引要new，因为这是insert
            //children【】表示发散的数，每个结点下面都有26个子结点
            if(cur.children[c-'a']==null){
                //too abstract，cur.children[c-'a'] is still trienode
                cur.children[c-'a']=new TrieNode();
            }
            //update cur
            cur=cur.children[c-'a'];
        }
        //insert finished and mark last element as true(end mark)
        cur.isword=true;
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.children[c-'a']==null){return false;}
            cur=cur.children[c-'a'];
        }
        //to judge if this is the last element of the trie tree
        return cur.isword;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(cur.children[c-'a']==null){return false;}
            cur=cur.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
