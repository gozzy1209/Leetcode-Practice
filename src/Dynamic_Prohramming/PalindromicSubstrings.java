package Dynamic_Prohramming;
//647. Palindromic Substrings
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        int res=0;
        for(int right_temp=0;right_temp<len;right_temp++){
            for(int left_temp=0;left_temp<=right_temp;left_temp++){
                //下面的判断条件很关键，记住，和5. Longest Palindromic Substring的思路一样
                if(s.charAt(left_temp)==s.charAt(right_temp)&&(right_temp-left_temp<=2||dp[left_temp+1][right_temp-1]==true)){
                    dp[left_temp][right_temp]=true;
                    res++;
                }
            }
        }
        return res;
    }
}
