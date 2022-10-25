package Dynamic_Prohramming;

import java.util.Arrays;

//322Coin Change
public class CoinChange {
    
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<0) {
            return -1;}
        if(amount==0) {
            return 0;}
        Arrays.sort(coins);
        //想一下为什么是amount+1，而不是len+1
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;i<coins.length;j++){
                //coins[j] is sub_problem
                if(coins[j]>i){
                    break;
                }
                if(dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }
        //if dp[amount]!=Integer.MAX_VALUE and then return dp[amount], else return -1
        return dp[amount] !=Integer.MAX_VALUE? dp[amount] : -1;
    }
}