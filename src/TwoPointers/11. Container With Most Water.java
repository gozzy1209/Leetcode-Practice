package TwoPointers;
/*You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container. */
class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
                int container=(right-left)*Math.min(height[left], height[right]);
                if(container>max){max=container;}
                //这里是最关键的地方，用了左右双指针
                //更关键的是，哪边指针高度少就移动谁。为什么？
                //因为既然每次宽度要减少1，那就尽量找长度最大的，所以谁长度低就移动谁
                if(height[left]<height[right]){left++;}
                else if(height[left]>=height[right]){right--;}
        }
        return max;
    }
}
class Solution_2nd {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxres=0;
        while(left<right){
            int temp=(right-left)*(Math.min(height[left], height[right]));
            maxres=Math.max(maxres, temp);
            if(height[left]<=height[right]) left++;
            else{right--;}
        }
        return maxres;
    }
}
