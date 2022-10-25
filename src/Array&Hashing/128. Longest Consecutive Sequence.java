import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        //先ARRAYS SORT排序
        //找每个索引值和索引的差
        //通过Boolean判断之前连续状态，如果差值继续一样那就连续长度加1
        int ans=1;
        int max=ans;
        Arrays.sort(nums);
        //boolean consecutive=true;
        if(nums.length==0){return 0;}
        int gap=nums[0];
        int index=1;
        while(index<nums.length){
            if(nums[index]==nums[index-1]){
                index++;
                continue;
            }
            else if(nums[index]==(nums[index-1]+1)){
                ans++;
                index++;
                if(ans>max){max=ans;}
            }
            else{
                ans=1;
                index++;
            }

        }
        return max;
    }
}