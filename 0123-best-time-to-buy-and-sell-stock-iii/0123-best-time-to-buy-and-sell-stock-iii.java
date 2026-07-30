// // ** MEMOIZATION
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

// *** TABULATION (53ms)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];
        for(int i=n-1; i>=0; i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        dp[i][buy][cap]=Math.max(-prices[i]+dp[i+1][0][cap],0+dp[i+1][1][cap]);
                    }
                    else{
                        dp[i][buy][cap]=Math.max(prices[i]+dp[i+1][1][cap-1],0+dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}

// ** SPACE OPTIMIZATION
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int curr[][]=new int[2][3]; // curr abhi value store kara hai
        int ahead [][]=new int[2][3]; // dp[i+1] ka kam kara hai lob=gback se value lake dera hai (i+1)
        for(int i=n-1; i>=0; i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        curr[buy][cap]=Math.max(-prices[i]+ahead[0][cap],0+ahead[1][cap]);
                    }
                    else{
                        curr[buy][cap]=Math.max(prices[i]+ahead[1][cap-1],0+ahead[0][cap]);
                    }
                }
            }
            int temp[][]=ahead; // Aaj ka kaam hogya then ab agle loop ke liye curr banega ahead(copy ki jagh reference use for fast processing) 
            ahead=curr;
            curr=temp;
        }
        return ahead[1][2];
    }
}
