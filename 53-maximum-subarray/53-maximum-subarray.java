class Solution {
    public int maxSubArray(int[] nums) {
        /*
        -Kadane's Algorithm, has maxendingati and maxoverall
        -Check if maxendingati + current element is < current element. If it is just start over.
        -Then check if the maxoverall is currently greater than the maxendingati
        */
        int maxOverall = nums[0];
        int maxendingati = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxendingati = Math.max(maxendingati + nums[i], nums[i]);
            maxOverall = Math.max(maxOverall, maxendingati);
        }
        return maxOverall;
    }
    
}