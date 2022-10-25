package Dynamic_Prohramming;
//198. House Robber
/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    
}
class Solution {
    public int rob(int[] nums) {
        int rob=0;
        int notrob=0;
        for(int i=0;i<nums.length;i++){
            //现在rob=上一间没rob+现在这间的值
            int currob=notrob+nums[i];
            //第i间不rob的值=上一间i-1间rob和不rob的最大值
            notrob=Math.max(notrob, rob);
            //把rob变成currob，为下一次循环做准备
            rob=currob;
        }
        //返回抢或者不抢最后一间的值
        //最后的状态：抢或者不抢最后一间
        return Math.max(rob, notrob);
    }
}
