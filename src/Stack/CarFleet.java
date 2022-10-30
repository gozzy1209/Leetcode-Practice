package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//853. Car Fleet
public class CarFleet {
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len=position.length;
        int[] distance=new int[len];
        double[] time=new double[len];
        HashMap<Integer,Double> map=new HashMap<>();
        for(int i=0;i<len;i++){
            distance[i]=target-position[i];
            //why (double)？ ans:forcely change强制转换
            time[i]=(double)distance[i]/(double)speed[i];
            map.put(distance[i], time[i]);
        }
        Arrays.sort(distance);
        List<Double> time_different=new ArrayList<>();
        for(int i=0;i<len;i++){
            Double time_remain= map.get(distance[i]);
            int fleet_size=time_different.size();
            if(fleet_size==0||time_remain>time_different.get(fleet_size-1)){
                time_different.add(time_remain);
            }
        }
        return time_different.size();
    }
}