package Dynamic_Prohramming;
//70. Climbing Stairs
/*
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    
}
class Solution {
    public int climbStairs(int n) {
		if(n == 0 || n == 1 || n == 2){return n;}
		int[] res=new int[n+1];
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];

	}
}
