package Dynamic_Prohramming;
//213. House Robber II
public class HouseRobberII {
}
class Solution {
    public int rob(int[] nums) {
    //最关键的点在于，数组的最后一个实际上是和数组的第一个相连，邻居（闭环）
    //把一个复制问题分为两个简单问题：如果抢了第一个，就不抢最后一个；如果抢了最后一个，就不抢第一个，通过循环边界来设置
    if(nums.length==1)return nums[0];
    return Math.max(rob_sub(nums, 0, nums.length-1), rob_sub(nums, 1, nums.length));
        
    }

    //这是rob I的方法，改都没改过
    public int rob_sub(int[] nums,int low,int high) {
        int rob=0;
        int notrob=0;
        for(int i=low;i<high;i++){
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
