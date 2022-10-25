import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    /*Given an integer array nums and an integer k, 
    return the k most frequent elements. 
    You may return the answer in any order. */

    //第一步：建map，放元素，相同元素的话value值加1
    //第二步：看哪个key的value排在前k位
    //新建长度为k的数组，返回k个key元素的数组
    
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int s:nums){
            if(map.containsKey(s)){
                int temp=map.get(s)+1;
                //这步很妙
                map.put(s, temp);
            }
            else{
                map.put(s, 1);
            }
        }
        //666
        //上面都是对的，但是下面还没解决
        //现在的问题是：如何识别出出现频率前k高的key，并放到数组中
        List<Integer> arr=new ArrayList<>();
        for(int x:map.values()){
            arr.add(x);
        }
        Collections.sort(arr);//xxx
        int[] brr=new int[k];
        int indexnow=0;
        for(int i=arr.size()-1;i>=arr.size()-k;i--){
            Set<Map.Entry<Integer,Integer>> entry = map.entrySet();
            Object key=((java.util.Map.Entry<Integer, Integer>) entry).getKey();
            int keykey=Integer.parseInt(String.valueOf(key));
            brr[indexnow]=keykey;
            indexnow++;
        }
        return brr;
        
    }
}
