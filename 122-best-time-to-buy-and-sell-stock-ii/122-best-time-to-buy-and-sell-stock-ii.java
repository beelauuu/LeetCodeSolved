class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int profit = 0, minStockPriceSoFar = prices[0];
        
        for (int day = 1; day < prices.length; day++)
        {
            int currentDayStockPrice = prices[day];
            if (currentDayStockPrice > minStockPriceSoFar)
            {
                profit += currentDayStockPrice - minStockPriceSoFar;
                minStockPriceSoFar = currentDayStockPrice;
            }
            else minStockPriceSoFar = currentDayStockPrice;
        }
        return profit;
    }
}