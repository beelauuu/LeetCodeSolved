class Solution {
    public int maxProduct(int[] nums) {
        //Like Kadanes except we need to keep track of min too for negatives
        int maxendingati = nums[0];
        int minendingati = nums[0];
        int maxoverall = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            //Store the max of the current number and the current total
           int temp = Math.max(nums[i], Math.max(maxendingati*nums[i],minendingati*nums[i]));
          //Update the minimum if possible
            minendingati = Math.min(nums[i], Math.min(maxendingati*nums[i],minendingati*nums[i]));
          //Now update the possible max
           maxendingati = temp;
          //Now update the overall
           maxoverall = Math.max(maxoverall, Math.max(maxendingati, minendingati));
        }
        return maxoverall;
    }
}