// ** MEMOIZATION --> JUST COOLDOWN(SELL --> idx+2) IN THIS SAME AS OF BUY AND SELL STOCK 2
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][] dp=new int[n+2][2];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }
        return Cooldown(0,1,dp,prices);
    }
    public int Cooldown(int idx, int canBuy, int dp[][], int [] prices){
        if(idx>=prices.length)
        return 0;
        if(dp[idx][canBuy]!=-1)
        return dp[idx][canBuy];
        if(canBuy==1){
            return dp[idx][canBuy]= Math.max(-prices[idx]+Cooldown(idx+1,0,dp,prices),0+Cooldown(idx+1,1,dp,prices));
        }
        return dp[idx][canBuy]= Math.max(prices[idx]+Cooldown(idx+2,1,dp,prices),0+Cooldown(idx+1,0,dp,prices));
    }
}