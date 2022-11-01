package BinarySearch;

import java.util.HashMap;
import java.util.TreeMap;

//981Time Based Key-Value Store
public class TimeBasedKeyValueStore {
    class TimeMap {
        //create this kind of map is important 
        HashMap<String,TreeMap<Integer,String>> map;
        public TimeMap() {
            map=new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }
        
        public String get(String key, int timestamp) {
            if(map.containsKey(key)){
                //floorKey is important 
                Integer index=map.get(key).floorKey(timestamp);
                if(index!=null){
                    return map.get(key).get(index);
                }
            }
            return "";
        }
    }
}

