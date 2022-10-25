package Greedy;
//53Maximum Subarray
public class MaximumSubarray {
    
}
class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        int presum=Integer.MIN_VALUE;
        int cursum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            max=Math.max(max, nums[i]);
            if(cursum+nums[i]>=0){
                cursum+=nums[i];
                presum=Math.max(presum, cursum); 
            }
            else{
                cursum=0;
            }
        }
        return Math.max(max, presum);
    }
}