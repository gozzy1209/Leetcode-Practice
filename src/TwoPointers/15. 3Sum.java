package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.NumberOfDocuments;
/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets. */
class Solution {
    三指针过于复杂，没搞懂，关键是边界和重复值情况搞不懂
    public List<List<Integer>> threeSum(int[] nums) {
        List res=new ArrayList<ArrayList<Integer>>();
        int right=nums.length-1;
        Arrays.sort(nums);
        for(int left=0;left<nums.length-2;left++){
            if(left == 0 || (left > 0 && nums[left] != nums[left-1])) {
			int mid = left + 1; right = nums.length-1;
            while(mid<right){
                if(nums[left]+nums[mid]+nums[right]==0){
                    List res1=new ArrayList<Integer>();
                    res1.add(nums[left]);
                    res1.add(nums[mid]);
                    res1.add(nums[right]);
                    res.add(res1);
                    while(mid<right&&nums[mid]==nums[mid]+1){mid++;}
                    while(mid<right&&nums[right]==nums[right]-1){right--;}
                    mid++;
                    right--;
            }    
            else if(nums[left]+nums[mid]+nums[right]<0){mid++;}
            else{right--;}
        }
    }
    }
        return res;
    
}}

