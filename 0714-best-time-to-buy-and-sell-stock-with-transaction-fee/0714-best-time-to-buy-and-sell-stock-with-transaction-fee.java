// ** MEMOIZATION --> SAME BUY AND SELL STOCKS 2 KI TRH HAI BS TRANSACTION COMPLETE KE BAD FEE DENI HAI
class Solution {
    public int maxProfit(int[] prices, int fee) {
         int n=prices.length;
        int [][] dp=new int[n+2][2];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }
        return Cooldown(0,1,fee,dp,prices);
    }
    
 public int Cooldown(int idx, int canBuy, int fee, int dp[][], int [] prices){
        if(idx==prices.length)
        return 0;
        if(dp[idx][canBuy]!=-1)
        return dp[idx][canBuy];
        if(canBuy==1){
            return dp[idx][canBuy]= Math.max(-prices[idx]+Cooldown(idx+1,0,fee,dp,prices),0+Cooldown(idx+1,1,fee,dp,prices));
        }
        return dp[idx][canBuy]= Math.max(prices[idx]-fee+Cooldown(idx+1,1,fee,dp,prices),0+Cooldown(idx+1,0,fee,dp,prices));
    }
}