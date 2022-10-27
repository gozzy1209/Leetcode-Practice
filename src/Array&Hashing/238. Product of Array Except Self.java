class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        for(int i:res){
            i=1;
        }
        int left=1;
        int right=1;
        //把该元素左边全乘一遍（不包括该元素）
        for(int i=0;i<nums.length;i++){
            res[i]=left;
            left=left*nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            //把该元素右边全乘一遍，同样不包括该元素
            res[i]=res[i]*right;
            //然后左右再相乘得到的结果就是除该元素之外的其他元素的乘积
            right=right*nums[i];
        }
        return res;
    }
}
class Solution_2nd {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        for(int i=0,temp=1;i<nums.length;i++){
            res[i]=temp;
            temp*=nums[i];
        }
        for(int i=nums.length,temp=1;i>=0;i--){
            res[i]*=temp;
            temp*=nums[i];
        }
        return res;
    }
}