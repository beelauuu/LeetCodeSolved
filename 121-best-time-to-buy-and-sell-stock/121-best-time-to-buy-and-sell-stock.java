class Solution {
    public int maxProfit(int[] prices) {
    int minimum = Integer.MAX_VALUE;
    int toReturn = 0;
    
    //Loop through the prices
    for(int i = 0; i < prices.length; i++) {
        //If there is a smaller value set it equal
        if(prices[i] < minimum) {
            minimum = prices[i];
        }
        //Otherwise check to see if the current profit is greater than prices[i]-minimum
        else {
            toReturn = Math.max(toReturn, prices[i]-minimum);
        }
    }
        
    return toReturn;
    
        
}
}