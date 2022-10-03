class Solution {
    public int maxProfit(int[] prices) {
    int minimum = Integer.MAX_VALUE;
    int toReturn = 0;
        
    for(int i = 0; i < prices.length; i++) {
        if(prices[i] < minimum) {
            minimum = prices[i];
        }
        else {
            toReturn = Math.max(toReturn, prices[i]-minimum);
        }
    }
        
    return toReturn;
    
        
}
}