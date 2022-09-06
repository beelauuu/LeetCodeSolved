class Solution {
    public int findMin(int[] nums) {
        //Checking for length 0 && 1 cases
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        
        //Left and right pointers
        int left = 0;
        int right = nums.length-1;
        
        //Basic binary search
        while(left < right) {
            int mid = (left+right)/2;
            
            //Else we haven't found it yet, check if the left is less than the middle.
            //We know then that the left is sorted. Check the right also to see if it is
            //the unsorted part
            if(nums[mid] > nums[right]) {
                left = mid+1;
            }
            //Otherwise, it's either perfectly sorted or the right is out of order, in both
            //cases, the right pointer will move to mid-1
            else {
                right = mid;
            }
        }
        //Return the left pointer
        return nums[left];
    }
}