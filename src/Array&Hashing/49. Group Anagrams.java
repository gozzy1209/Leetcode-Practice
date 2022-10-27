import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*Given an array of strings strs, group the anagrams together. 
        You can return the answer in any order.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
        typically using all the original letters exactly once. */
        //第一步，如果字符串长度是0，返回空的arraylisted（list只是接口，不能是对象）
        //第二步，把每个字符串转成数组，对数组排序，如果排序后数组一样那就是anagram
        //第三步，通过map把anagram放进同一个key值的value中，value是list

        //List是一个接口，而ArrayList是List接口的一个实现类
        //没有List list=new List();
        if(strs.length==0) return new ArrayList<>();
        HashMap<String,List> map=new HashMap<>();
        for(String s: strs){
            //toCharArray()是关键
            char[] arr=s.toCharArray();
            //对数组排序，找出anagram
            Arrays.sort(arr);
            //把排序后数组转回字符串，这里的字符串key实际上是s的变体
            String key=String.valueOf(arr);
            //判断map中是否已经存在key，是否存在anagram
            //有的话就把s加到对应位置
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            //没有已有key的话就自己创建一个新list，然后put进map
            else{
                List<String> temp=new ArrayList<>();
                temp.add(s);
                //一开始把下面的key写成s，要注意
                map.put(key, temp);
            }
        }
        return new ArrayList(map.values());
    }
}
class Solution_2nd {
    public List<List<String>> groupAnagrams(String[] strs) {
        //tochararray() and valueof() are important
        if(strs.length==0) return new ArrayList<>();
        // create HashMap<String,List> is important, especially about the "List"
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String temp=String.valueOf(arr);
            if(map.containsKey(temp)) map.get(temp).add(s);
            else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(temp, list);
            }
        }
        List<List<String>> res=new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}
