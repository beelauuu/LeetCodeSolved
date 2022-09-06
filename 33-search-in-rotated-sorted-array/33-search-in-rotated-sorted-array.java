class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 0 || nums == null) {
            return -1;
        }
        if(nums.length == 1 && nums[0] == target) {
            return 0;
        }
        if(nums.length == 1 && nums[0] != target) {
            return -1;
        }
        
        int l = 0;
        int r = nums.length-1;
        
        
        while(l < r) {
            int mid = (l+r)/2;
            
            if(nums[mid] > nums[r]) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }
        
        int start = l;
        l = 0;
        r = nums.length-1;
        
        if(target >= nums[start] && target <= nums[r]) {
            l = start;
        }
        else {
            r = start; 
        }
        
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