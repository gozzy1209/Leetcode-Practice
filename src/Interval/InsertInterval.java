package Interval;

import java.util.LinkedList;
import java.util.List;

//57Insert Interval
public class InsertInterval {
    
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new LinkedList<>();
        int i=0;
        //add all the intervals ending before newInterval starts
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //merge all overlapping intervals to one considering newinterval
        //执行过上一个while时就已经把intervals[i][1]<newInterval[0]过滤了
        while(i<intervals.length&&intervals[i][0]<=newInterval[1]){
            //we could mutate newinterval here also
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        //add the union of interval we got
        res.add(newInterval);

        //add all the rest
        while(i<intervals.length){
            res.add(intervals[i]);
            i++;
        }

        //这一步想不到
        return res.toArray(new int[res.size()][]);
    }
}
