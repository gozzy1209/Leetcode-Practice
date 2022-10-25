package SlidingWindow;

import java.util.HashMap;
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
