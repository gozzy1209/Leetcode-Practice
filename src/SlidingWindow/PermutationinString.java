package SlidingWindow;

import java.util.HashMap;

//567Permutation in String
public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1==null||s1.length()==0||s2==null||s2.length()<s1.length()){
            return false;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        //add s1 to map
        for(Character ch:s1.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }
        //scan s2 with map(s1)' elements
        int left=0,right=0,counter=map.size();
        while(right<s2.length()){
            char rightchar=s2.charAt(right);
            if(map.containsKey(rightchar)){
                map.put(rightchar, map.get(rightchar)-1);
                if(map.get(rightchar)==0){
                    counter--;
                }
            }
        }
        right++;
        while(counter==0)
        // this means sliding window has all the characters needed from the target string
        {
            char beginchar=s2.charAt(left);
            if(map.containsKey(beginchar)){
                 // reset the char count
                map.put(beginchar, map.get(beginchar)+1);
                if(map.get(beginchar)>0){
                 // this means sliding window no more contains all the valid characters, so increment the counter and thereafter move the sliding window    
                    counter++;
                }
            }
            if(right-left==s1.length()){
                return true;
            }
            left++;
        }
        return false;

    }
}
