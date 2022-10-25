import java.util.Arrays;

class Solution {
    /*Given an integer array nums, 
    return true if any value appears at least twice in the array, 
    and return false if every element is distinct. */
    
    public boolean containsDuplicate(int[] nums) {
        //问题的关键是没有想到可以直接用arrays.sort()
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len-1;i++){
                if(nums[i]==nums[i+1]){
                    return true;
                }
        }
        return false;
    }
   
}
class Solution_2 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}