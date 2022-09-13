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
        
        while(left < right) {
            int mid = (left+right)/2;
            
            if(nums[mid] > nums[right]) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        
        //Return the left pointer
        return nums[left];
    }
}