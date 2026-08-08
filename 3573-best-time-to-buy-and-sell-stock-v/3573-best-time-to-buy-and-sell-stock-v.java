class Solution {
    long [][][]dp;
    // 0 -> You have not bought anything and you have not short-sold anything --> in this Case will Buy and Short Sell.
    // 1 -> Normal transaction - you had bought, now you will sell normally
    // 2 -> Short selling transaction - you had sold, now you will buy back
    public long maximumProfit(int[] prices, int k) {
        int n=prices.length;
       dp=new long[n][k+1][3];
       for(long i [][]:dp){
         for(long it[]:i){
            Arrays.fill(it, Long.MIN_VALUE);
         }
       }
       return Short(0,k,0,prices); 
    }
    public long Short(int idx, int k, int Case, int [] prices){
        if(idx==prices.length){
            if(Case==0)
            return 0;
            return Long.MIN_VALUE/2;
            // Unfinised Transaction
        }
          if(dp[idx][k][Case]!=Long.MIN_VALUE){
            return dp[idx][k][Case];
          }
          long dontTake=Short(idx+1,k,Case,prices);
          long Take=Long.MIN_VALUE;
          if(k>0){
            if(Case ==1){ // Sell Today Complete Normal Transaction
                Take=prices[idx]+Short(idx+1,k-1,0,prices);
            }
            else if(Case ==2){ // Buy Back today (Complete Shhort Transaction)
               Take=-prices[idx]+Short(idx+1,k-1,0,prices);
            }
            else{  // CASE--> 0 -- Start a Transaction (Buy-- Normal, Sell --Short)
                Take=Math.max(-prices[idx]+Short(idx+1,k,1,prices),prices[idx]+Short(idx+1,k,2,prices));
            }
          }
          return dp[idx][k][Case]=Math.max(Take,dontTake);
    }
}