class Solution {
    public int[] productExceptSelf(int[] nums) {
        //把该元素左边全乘一遍（不包括该元素）
        //把该元素右边全乘一遍，同样不包括该元素
        //然后左右再相乘得到的结果就是除该元素之外的其他元素的乘积

        // 问题的关键是，你怎么想得到左边乘一遍，右边乘一遍，再相乘
        int[] res=new int[nums.length];
        for(int i:res){
            i=1;
        }
        int left=1;
        int right=1;
        for(int i=0;i<nums.length;i++){
            res[i]=left;
            left=left*nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[i]*right;
            right=right*nums[i];
        }
        return res;
    }
}