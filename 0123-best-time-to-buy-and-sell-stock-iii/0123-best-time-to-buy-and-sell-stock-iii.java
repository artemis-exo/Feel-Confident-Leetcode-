class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
        for(int i[][]:dp){
            for(int [] j:i){
                Arrays.fill(j,-1);
            }
        }
        return Stock(0,1,2,prices,dp);
    }
    public int Stock(int idx, int CanBuy , int cap, int [] prices, int [][][]dp){
        if(cap==0 || idx==prices.length )return 0;
        if(dp[idx][CanBuy][cap]!=-1){
            return dp[idx][CanBuy][cap];
        }
        if(CanBuy==1){
            return dp[idx][CanBuy][cap]=Math.max(-prices[idx]+Stock(idx+1,0,cap,prices,dp),0+Stock(idx+1,1,cap,prices,dp));
        }
        return dp[idx][CanBuy][cap]=Math.max(prices[idx]+Stock(idx+1,1,cap-1,prices,dp),0+Stock(idx+1,0,cap,prices,dp));
    }
}