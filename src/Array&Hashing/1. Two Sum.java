import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            int remain=target-nums[i];
            if(map.containsKey(remain)){
                int remainIndex=map.get(remain);
                return new int[]{i,remainIndex};
            }
        }
        return new int[]{-1,-1};
}
}
class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        for(int i=0;i<nums.length;i++){
            int right=nums.length-1;
            while(i<right){
                if(nums[i]+nums[right]==target){
                    res[0]=i;
                    res[1]=right;
                }
            }
            right--;
        }
        return res;
    }
}