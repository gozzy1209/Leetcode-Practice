package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//3. Longest Substring Without Repeating Characters
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        lengthOfLongestSubstring("112");
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        int len=0;
        int maxlen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(arr[i])){
                //this step is important
                i=i-len+1;
                len=0;
                map.clear();
            }else{
                map.put(arr[i], 1);
                len++;
                maxlen=Math.max(maxlen, len);
             }
        }
        return maxlen;
    }
}
class LongestSubstringWithoutRepeatingCharacters_2nd {
    public int lengthOfLongestSubstring(String s) {
        //using set
        Set<Character> set=new HashSet<>();
        int index=0;
        int removeindex=0;
        int maxsize=0;
        while(index<s.length()){
            if(!set.contains(s.charAt(index))){
                set.add(s.charAt(index++));
                maxsize=Math.max(maxsize, set.size());
            }
            else{
                set.remove(s.charAt(removeindex++));
            }
        }
        return maxsize;
    }
}
