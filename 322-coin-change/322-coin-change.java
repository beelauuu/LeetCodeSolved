class Solution {
    public int coinChange(int[] coins, int amount) {
        //Creating a new int array for each amount (0 to the actual amount)
        int[] dp = new int[amount+1];
        //Sorting it to optimize
        Arrays.sort(coins);
        
        
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
                else {
                    break;
                }
            }
        }
        
        if(dp[amount] > amount) {
            return -1;
        }
        else {
            return dp[amount];
        }
    }
}