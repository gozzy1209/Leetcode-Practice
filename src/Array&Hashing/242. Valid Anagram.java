import java.util.HashMap;

class Solution {
    /*Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
    typically using all the original letters exactly once. */
    public boolean isAnagram(String s, String t) {
        //设置一个26长度的数组
        //每个索引代表一个字母char at-‘a'
        //s字符串每次++
        //t字符串每次--
        //最后如果不一样那就是false
        if(s.length()!= t.length()){
            return false;
        }
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            //最关键的一步思路，没有想到可以用字符值来做索引，用出现次数来做数值
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        for(int n:arr){
            if(n!=0){
                return false;
            }
        }
        //我不太懂为啥不用判断字符串是否重复？？
        return true;
        
        
        
    }
}
class Solution_2 {
    public boolean isAnagram(String s, String t) {
        //using map xxx no!!! using int[]
        int[] res=new int[26];
        for(int i=0;i<s.length();i++){
            res[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            res[t.charAt(i)-'a']--;
        }
        //the two loops can be menged into one
        for(int i:res){
            if(i!=0)return false;
        }
        return true;

    }
}
