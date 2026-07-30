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

//  ** TABULATION

// ** SPACE OPTIMIZATION
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int curr[][]=new int[2][k+1]; // curr abhi value store kara hai
        int ahead[][]=new int[2][k+1];  // dp[i+1] ka kam kara hai lob=gback se value lake dera hai (i+1)
        for(int i=n-1; i>=0; i--){
            for(int buy=0;buy<=1;buy++){
                for(int p=1;p<=k;p++){
                    if(buy==1){
                        curr[buy][p]=Math.max(-prices[i]+ahead[0][p],0+ahead[1][p]);
                    }
                    else{
                        curr[buy][p]=Math.max(prices[i]+ahead[1][p-1],0+ahead[0][p]);
                    }
                }
            }
            int temp[][]=ahead;// Aaj ka kaam hogya then ab agle loop ke liye curr banega ahead(copy ki jagh reference use for fast processing) 
            ahead=curr;
            curr=temp;
        }
        return ahead[1][k];

    }
}
