package Greedy;
//55 Jump Game
public class JumpGame {
    public void test() {
        int[] nums={2,3,1,1,4};
        boolean res=canJump(nums);
        System.out.println(res);
    }

    boolean canJump(int[] nums) {
        int reach_index=0;
        for(int i=0;i<nums.length;i++){
            if(i>reach_index) return false;
            reach_index=Math.max(reach_index, i+nums[i]);
        }
        return true;
    }
}
