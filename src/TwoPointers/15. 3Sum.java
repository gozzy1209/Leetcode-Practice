package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets. */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;right--;
                  while(left<right && nums[left]==nums[left-1]) left++;//to avoid duplicates
                  while(left<right && nums[right]==nums[right+1]) right--;//to avoid duplicates
                }
                else if(sum<0){
                    left++;
                    while(nums[left]==nums[left-1]&&left<right){
                        left++;
                    }  
                }
                else if(sum>0){
                    right--;
                    while(nums[right]==nums[right+1]&&left<right){
                        right--;
                    }
                }
            }
            while(nums[i]==nums[i+1]&&i<nums.length-2){
                i++;
            }
        }
        return res;
}
}

