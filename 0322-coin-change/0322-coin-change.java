class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp=new int[n][amount+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
      int ans= minCoins(n-1,amount,dp,coins);
      if(ans>=(int)1e9/2){
        return -1;
      }
      return ans;
    }
    public int minCoins(int idx, int amount, int[][] dp, int [] coins){
        if(idx==0){
            if(amount==0)
            return 0;
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            return (int)1e9/2;
        }
        if(dp[idx][amount]!=-1){
            return dp[idx][amount];
        }
        int NotTake=0+minCoins(idx-1,amount, dp,coins);
        int take=(int)1e9/2;
        if(coins[idx]<=amount){
            take=1+minCoins(idx,amount-coins[idx],dp,coins);
        }
        return dp[idx][amount]=Math.min(take,NotTake);
    }
}