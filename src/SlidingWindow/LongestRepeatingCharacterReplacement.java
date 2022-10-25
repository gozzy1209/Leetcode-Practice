package SlidingWindow;
//424. Longest Repeating Character Replacement
/*You are given a string s and an integer k. 
You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get 
after performing the above operations. */
public class LongestRepeatingCharacterReplacement {
    //循环遍历元素，len++，当遇见不同元素时换成相同元素同时k--；
    //当k=0时，从上一个不同元素索引开始新的遍历
    //记录当k=0时的len，然后Math.max(lemmax,len)
    public static void main(String[] args) {
        int res=characterReplacement("BAAA", 0);
        System.out.println(res);
    }
    public static int characterReplacement(String s, int k) {
        //细节处解决不了，大部分例子能过，但是特殊情况过不了
        char[] arr=s.toCharArray();
        int lenmax=1;
        int res_k=k;
        for(int i=0;i<arr.length;i++){
            char temp=arr[i];
            int len=0;
            k=res_k;
            int tempint=i;
            while(i<arr.length){
                if(k<=0&&arr[i]!=temp){
                    k--;
                    break;
                }
                else if(k>0&&arr[i]!=temp){
                k--;
                len++;
                i++;
                }
                else{
                    len++;
                    i++;
                }
            }
            lenmax=Math.max(lenmax, len);
            i=tempint;
        }

        return lenmax;
    }
}
