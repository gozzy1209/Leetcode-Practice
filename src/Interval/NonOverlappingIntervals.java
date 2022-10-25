package Interval;

import java.util.Arrays;

//435Non-overlapping Intervals
public class NonOverlappingIntervals {
    
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        //排序后，让每个元素的结尾都尽可能远离下个元素的开头
        int start=intervals[0][0];
        int end=intervals[0][1];
        int res=0;
        for(int[] i:intervals){
            if(end>i[0]){
                res++;
                //下面这行代码非常关键
                end=Math.min(end, i[1]);
            }
            else{
                end=i[1];
            }
        }
        return res-1;
    }
}