class Solution {
    public int maxProfit(int[] prices) {
        
        //Checking edge cases
        if (prices == null || prices.length <= 1) {
            return 0;
        } 
        
        //Setting up toReturn and the minimum stock price
        int toReturn = 0;
        int min = prices[0];
        
        //Looping through the prices array
        for (int i = 1; i < prices.length; i++)
        {
            int curr = prices[i];
            
            //If the current stock price is greater than your minimum, sell for a profit
            if(curr > min) {
                toReturn += curr-min;
                min = curr; 
            }
            //Otherwise, if curr is < min then set your new minimum
            else {
                min = curr;
            }
        }
        
        return toReturn;
    }
}