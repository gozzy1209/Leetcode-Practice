package BinarySearch;
//二分查找最大的特点就是时间度是log n
//二分查找的特点就是利用left mid right指针在条件下的变动最终找到某一个值
//153. Find Minimum in Rotated Sorted Array
/*Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time. */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(left<=right){
            if(nums[left]<nums[right]){
                min=Math.min(min, nums[left]);
                break;
            }
            int mid=(left+right)/2;
            min=Math.min(min, nums[mid]);
            //in left sorted portion
            if(nums[mid]>=nums[left]){
                left=mid+1;}
            //in right sorted portion
            else {
                right=mid-1;
            }
        }
        return min;
    }
    public int findMin_2nd(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(left<=right){
            if(nums[left]<nums[right]){
                min=Math.min(nums[left], min);
                break;
            }
            int mid= left+(right-left)/2;
            min=Math.min(min, nums[mid]);
            if(nums[mid]>=nums[left]){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return min;
    }
}
