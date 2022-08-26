class Solution {
    public int climbStairs(int n) {
        //1 2 3 5 8 13
        //1 1 2 3 5
        //4 steps
        //1+1+1+1
        //2+2
        //1+2+1
        //2+1+2
        //1+1+2 (5)
        
        //5 steps
        //1+1+1+1+1
        //2+2+1
        //2+1+2
        //1+2+2
        //1+1+1+2
        //1+1+2+1
        //1+2+1+1
        //2+1+1+1 (8)
        
        int value1 = 1;
        int value2 = 1;
        
        //It's just the Fibonacci numbers
        for(int i = 0; i < n-1; i++) {
            int temp = value1;
            value1 = value1+value2;
            value2 = temp;
        }
        
        return value1;
    }
}