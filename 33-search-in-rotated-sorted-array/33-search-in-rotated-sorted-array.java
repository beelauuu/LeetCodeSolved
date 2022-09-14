class Solution {
    public int search(int[] nums, int target) {
        
        //Check for error cases
        if(nums.length == 0 || nums == null) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length-1;
        
        
        //Leetcode from Find Minimum of Rotated Sorted Array
        while(l < r) {
            int mid  = (l+r)/2;
            
            if(nums[mid] > nums[r]) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        
        //At this point l points to the smallest element in the array
        
        int start = l;
        l = 0;
        r = nums.length-1;
        
        //Checking which side of the array it's on
        if(target >= nums[start] && target <= nums[r]) {
            l = start;
        }
        else {
            r = start; 
        }
        
        
        //Normal binary search at this point
        while(l <= r) {
            int mid = (l+r)/2;
            
            if(target == nums[mid]) {
                return mid;
            }
            else if(target < nums[mid]) {
                r = mid-1;
            } 
            else {
                l = mid+1;
            }
        }
        
        return -1;
    }
}