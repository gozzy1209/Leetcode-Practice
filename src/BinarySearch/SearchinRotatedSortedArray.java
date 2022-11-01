package BinarySearch;
//33. Search in Rotated Sorted Array

/*There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity. */
public class SearchinRotatedSortedArray {
    //二分查找
    //binary search 最关键的就是要有left，mid，right指针
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        //left<=right
        while(left<=right){
            int mid=(right+left)/2;
            if(nums[mid]==target){return mid;}
            //left sorted portion
            //下面这个if是为了判断mid值到底是左边顺序还是属于右边顺序子数组
            if(nums[left]<=nums[mid]){
                //target>nums[mid]很容易理解
                //target<nums[left]其实是target《nums[mid]&&target<nums[left]可以多体会几次，画个图就懂
                if(target>nums[mid]||target<nums[left]){
                    left=mid+1;
                }
                else{right=mid-1;}
            }
            //right sorted portion
            else{
                if(target<nums[mid]||target>nums[right]){
                    right=mid-1;
                }
                else{left=mid+1;}
            }

        }
        return -1;
    }
}
class SearchinRotatedSortedArray_2nd {
    
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){return mid;}
            if(nums[left]<=nums[mid]){
              if(nums[mid]<target||nums[left]>target){
                  left=mid+1;
              }
              else {
                  right=mid-1;
              }
            }
            else{
                if(target<nums[mid]||target>nums[right]){
                    right=mid-1;
                }
                else{left=mid+1;}
            }
            }
        return -1;
    }
    
}
