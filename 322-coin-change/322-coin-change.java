class Solution {
    public int coinChange(int[] coins, int amount) {
        //Creating a new int array for each amount (0 to the actual amount)
        int[] dp = new int[amount+1];
        //Sorting it to optimize
        Arrays.sort(coins);
        
        
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        
        //Loop through each amount
        for(int i = 1; i < dp.length; i++) {
            //Loop through each coin
            for(int j = 0; j < coins.length; j++) {
                //Check if the coin is less than the amount, if it is, basically check first
                //to see if that amount - coins[j] is even possible (i-coins[j]) and if it
                //is then  update the amount of coins by 1, otherwise don't do anything
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
                //Since it is sorted, we know once the coins is > the other ones won't be
                else {
                    break;
                }
            }
        }
        
        //Check the amount of coins in the amount, if it's greater than the initial set value of amount + 1, return -1
        if(dp[amount] > amount) {
            return -1;
        }
        else {
            return dp[amount];
        }
    }
}