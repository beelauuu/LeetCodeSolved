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
        while(left <= right) {
            int mid = (left+right)/2;
            
            //We know that if nums[mid] is less than the element before it, that it is
            //the splitting point of the array and that mid is the minimum element
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            //Else we haven't found it yet, check if the left is less than the middle.
            //We know then that the left is sorted. Check the right also to see if it is
            //the unsorted part
            else if(nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid+1;
            }
            //Otherwise, it's either perfectly sorted or the right is out of order, in both
            //cases, the right pointer will move to mid-1
            else {
                right = mid-1;
            }
        }
        //Return the left pointer
        return nums[left];
    }
}