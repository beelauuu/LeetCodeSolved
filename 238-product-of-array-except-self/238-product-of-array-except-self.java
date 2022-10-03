class Solution {
    public int[] productExceptSelf(int[] nums) {
         int[] leftProducts = new int[nums.length];
         leftProducts[0] = 1;
         int[] rightProducts = new int[nums.length];
         rightProducts[nums.length-1] = 1;
        
         int[] output = new int[nums.length]; 
            
         for(int i = 1; i < nums.length; i++) {
             leftProducts[i] = nums[i-1] * leftProducts[i-1];
         }
        
        for(int i = nums.length-2; i >= 0; i--) {
            rightProducts[i] = nums[i+1]*rightProducts[i+1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            output[i] = leftProducts[i]*rightProducts[i];
        }
        
        return output;
        
        //[1,1,2,6]
        //[24,12,4,1]
    }
}