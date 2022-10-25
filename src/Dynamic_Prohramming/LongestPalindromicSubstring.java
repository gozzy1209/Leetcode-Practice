package Dynamic_Prohramming;
//5. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    int low;
    int maxlen;
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        for(int i=0;i<s.length();i++){
            //for odd length
            palindrome_extend(s, i, i);
            //for even length
            palindrome_extend(s, i, i+1);
        }
        return s.substring(low, low+maxlen);
    }
    private void palindrome_extend(String s, int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
        if(maxlen<right-left-1){
            low=left+1;
            maxlen=right-left-1;
        }
        }
    
    // DP method
    public String longestPalindrome_DP(String s) {
        if(s==null||s.length()==0) return s;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        int left=0;
        int right=0;
        int max=0;
        for(int right_temp=0;right_temp<len;right_temp++){
            for(int left_temp=0;left_temp<=right_temp;left_temp++){
                if(s.charAt(left_temp)==s.charAt(right_temp)&&(right_temp-left_temp<=2||dp[left_temp+1][right_temp-1]==true)){
                    dp[left_temp][right_temp]=true;
                }
                if(dp[left_temp][right_temp]&&max<right_temp-left_temp+1){
                    //单纯记录长度，作为后续判断依据
                    max=right_temp-left_temp+1;
                    //作为索引，作为return依据
                    left=left_temp;
                    right=right_temp;
                }
            }
        }
        return s.substring(left, right+1);
    }


        
    }

