package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

//424. Longest Repeating Character Replacement
/*You are given a string s and an integer k. 
You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get 
after performing the above operations. */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

    }
    public static int characterReplacement(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        int left=0,maxrepeat=0,maxwindow=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch, 0);
            }
            map.put(ch,map.get(ch)+1);

            //key part
            maxrepeat=Math.max(maxwindow, map.get(ch));
            //count un_repeat number
            if((right-left+1-maxrepeat)>k){
                char remove=s.charAt(left);
                map.put(remove, map.get(remove)-1);
                left++;
            }
            maxwindow=Math.max(maxwindow, right-left+1);
        }
        return maxwindow;
}
}
