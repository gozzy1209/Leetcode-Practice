package Interval;

import java.util.Arrays;
import java.util.LinkedList;

//56Merge Intervals
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res=new LinkedList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int i=1;
        int start=intervals[0][0];
        int end=intervals[0][1];
        while(i<intervals.length){
            if(intervals[i-1][1]>=intervals[i][0]){
                end=Math.max(end, intervals[i][1]);
            }
            else{
                res.add(new int[]{start,end});
                end=intervals[i][1];
                start=intervals[i][0];
            }
            i++;
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
}

