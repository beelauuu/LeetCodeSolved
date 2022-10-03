class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //Array of products to the left of elements
         int[] leftProducts = new int[nums.length];
         leftProducts[0] = 1;
        //Array of products to the right of elements
         int[] rightProducts = new int[nums.length];
         rightProducts[nums.length-1] = 1;
        
         int[] output = new int[nums.length]; 
        
        //For the left one, take [1,2,3,4] as an example
        //To the left of 1 is just going to be nothing (1)
        //To the left of 2 is just going to be 1*1
        //To the left of 3 is going to be 2*1*1
        //To the left of 4 is going to be 3*2*1*1
        //[1,1,2,6]
         for(int i = 1; i < nums.length; i++) {
             leftProducts[i] = nums[i-1] * leftProducts[i-1];
         }
        
        //To the right of 4 is just going to be nothing (1)
        //To the right of 3 is just going to be 4*1 
        //To the right of 2 is going to be 3*4*1
        //To the right of 1 is going to be 2*3*4*1
        //[24,12,4,1]
        for(int i = nums.length-2; i >= 0; i--) {
            rightProducts[i] = nums[i+1]*rightProducts[i+1];
        }
        
        //Combining the multiples on the left of each value and right of each value to get the total
        //minus
        for(int i = 0; i < nums.length; i++) {
            output[i] = leftProducts[i]*rightProducts[i];
        }
        
        return output;
        
        //[1,1,2,6]
        //[24,12,4,1]
    }
}