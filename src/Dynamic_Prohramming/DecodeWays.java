package Dynamic_Prohramming;
//91. Decode Ways
public class DecodeWays {
    
}
class Solution {
    public int numDecodings(String s) {
        //动态规划就就先设dp数组，然后确定前几个状态，然后后续状态分别是之前状态相加相乘这样
        if(s==null||s.length()==0){
            return 0;
        }
        int len=s.length();
        //这里数组长度要多1是未来dp【2】要是dp【1】＋dp【0】，而dp【0】是我们自己设的，只用这一次，也相当于是初始化
        int[] dp=new int[len+1];
        dp[0]=1;
        if(s.charAt(0)!='0')dp[1]=1;
        for(int i=2;i<len+1;i++){
            if(s.charAt(i-1)!='0')
              dp[i]+=dp[i-1];
            int val=Integer.valueOf(s.substring(i-2, i));
            if(val>=10&&val<=26)
              dp[i]+=dp[i-2];
        }
        //返回数组最后一个值，即结果
        return dp[len];
    }
}
