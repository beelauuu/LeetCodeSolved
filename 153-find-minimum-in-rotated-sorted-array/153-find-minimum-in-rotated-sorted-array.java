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
        
        //Modified binary search
        while(left < right) {
            int mid = (left+right)/2;  
            //If the middle is greater than the right-most element, we know that the right is the smaller, unsorted side. We can do mid+1 because we know that the mid is not the smallest element
            if(nums[mid] > nums[right]) {
                left = mid+1;
            }
            //Else we know the smallest element is going to be on the left side
            else {
                right = mid;
            }
        }
        
        //Return the left pointer
        return nums[left];
    }
}