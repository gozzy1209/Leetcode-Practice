package LinkedList;
//287Find the Duplicate Number
public class FindtheDuplicateNumber {
    class Solution {
        public int findDuplicate(int[] nums) {
            int[] res=new int[nums.length];
            for(int i:nums){
                res[i]+=1;
            }
            for(int index=0;index<res.length;index++){
                if(res[index]>1) return index;
            }
            return -1;
        }
    }
}
