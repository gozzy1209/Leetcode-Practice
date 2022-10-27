package TwoPointers;
import java.util.ArrayList;
import java.util.LinkedList;
//先用strip方法把前后空白删除
//把剩下的中间空白和符号删除（怎么删？）
//用left，right指针一一比较，不一样直接返回false
class Solution {
    public static void main(String[] args) {
        String s = "0P";
        isPalindrome(s);
    }
    public static boolean isPalindrome(String s) {
        s.strip();
        String ss=s.toLowerCase();
        char[] arr=ss.toCharArray();
        boolean ans=true;
        int left=0;
        int right=arr.length-1;
        while(ans==true&&left<=right){
            if(arr[left]>='a'&&arr[left]<='z'||arr[left]>='0'&&arr[left]<='9'){
            }
            else {
                left++;
                continue;
            }
            if(arr[right]>='a'&&arr[right]<='z'||arr[right]>='0'&&arr[right]<='9'){
            }
            else {
                right--;
                continue;
            }
            if(arr[left]!=arr[right]){
                ans=false;
                }
                else{
                    left++;
                    right--;
                }
        }
        return ans;
    }
}
class Solution_2nd {
    public boolean isPalindrome(String s) {
        //remove the characters that i don't need
        s.strip();
        char[] arr=s.toLowerCase().toCharArray();
        //using two pointers(left and right) to judge if they are equal
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            if(arr[left]>='a'&&arr[left]<='z'||arr[left]>='0'&&arr[left]<='9'){
            }
            else {
                left++;
                continue;
            }
            if(arr[right]>='a'&&arr[right]<='z'||arr[right]>='0'&&arr[right]<='9'){
            }
            else {
                right--;
                continue;
            }
            if(arr[left]!=arr[right]){
                return false;
                }
                else{
                    left++;
                    right--;
                }
        }
        return true;
    }
}