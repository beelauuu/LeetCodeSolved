class Solution {
    public int maxProfit(int[] prices) {
        
//        if(prices.length <= 1 || prices == null) {
//            return 0;
//        }
//        int minimum = prices[0];
//        int toReturn = 0;
        
//        for(int i = 1; i < prices.length; i++) {
//            minimum = Math.min(minimum, prices[i]);
//            toReturn = Math.max(toReturn, prices[i]-minimum);
//        }
//        return toReturn;
    int minimum = Integer.MAX_VALUE;
    int toReturn = 0;
    
    //Loop through the prices
    for(int i = 0; i < prices.length; i++) {
        //If there is a smaller value set it equal
        if(prices[i] < minimum) {
            minimum = prices[i];
        }
        toReturn = Math.max(toReturn, prices[i]-minimum);
        }
    
        
    return toReturn;

    
        
}
}