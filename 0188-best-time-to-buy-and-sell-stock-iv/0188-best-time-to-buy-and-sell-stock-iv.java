// ** MEMOIZATION
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n= prices.length;
        int dp[][][]=new int[n][2][k+1];
        for(int i[][]:dp){
            for(int it[]:i){
                Arrays.fill(it,-1);
            }
        }
        return Stock(0,1,k,prices,dp);
    }
    public int Stock(int i, int canBuy, int k, int [] prices, int [][][]dp){
        if(i==prices.length || k==0)return 0;
        if(dp[i][canBuy][k]!=-1)return dp[i][canBuy][k];
        if(canBuy==1){
            return dp[i][canBuy][k]= Math.max(-prices[i]+Stock(i+1,0,k,prices,dp),0+Stock(i+1,1,k,prices,dp));
        }
        else{
            return dp[i][canBuy][k]= Math.max(prices[i]+Stock(i+1,1,k-1,prices,dp),0+Stock(i+1,0,k,prices,dp));
        }
    }
}