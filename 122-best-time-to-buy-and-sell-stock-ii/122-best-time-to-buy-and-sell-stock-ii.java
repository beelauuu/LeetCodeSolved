class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        } 
        
        int toReturn = 0;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; i++)
        {
            int curr = prices[i];
            if(curr > min) {
                toReturn += curr-min;
                min = curr; 
            }
            else {
                min = curr;
            }
        }
        return toReturn;
    }
}