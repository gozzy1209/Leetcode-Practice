import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
        
    // then using bucket sort(List<Integer>[] bucket=new List[nums.length+1]) to sort
        List<Integer>[] bucket=new List[nums.length+1];
        for(int n:map.keySet()){
            int freq=map.get(n);//return n's value
            if(bucket[freq]==null){
                bucket[freq]=new LinkedList<>();
            }
            bucket[freq].add(n);
        }

        int[] res=new int[k];//add result
        for(int i=bucket.length-1, j=0;i>=0&&j<k;i--){
            if(bucket[i]!=null){
                for(int n:bucket[i]){
                    res[j++]=n;
                }
            }
        }
        return res;
        
    }
}
