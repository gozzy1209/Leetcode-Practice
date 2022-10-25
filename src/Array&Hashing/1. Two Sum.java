import java.util.Arrays;
import java.util.HashMap;
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
        
    }
}