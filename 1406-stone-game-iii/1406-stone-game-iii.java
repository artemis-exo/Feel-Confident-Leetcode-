// ** MEMOIZATION
class Solution {
    int dp[];
    public String stoneGameIII(int[] stoneValue) {
        dp=new int[stoneValue.length];
        Arrays.fill(dp,-1);
        int res=Game(0,stoneValue);
        if(res>0)return "Alice";
        if(res<0)return "Bob";
        else
        return "Tie";

    }
    public int Game(int i, int [] stone){
        if(i>=stone.length)
        return 0;
        if(dp[i]!=-1)return dp[i];
        int max=Integer.MIN_VALUE;
        int Sum=0;
        Sum+=stone[i];
        max=Math.max(max,Sum-Game(i+1,stone));
        if(i+1<stone.length){
            Sum+=stone[i+1];
            max=Math.max(max,Sum-Game(i+2,stone));
        }
        if(i+2<stone.length){
            Sum+=stone[i+2];
            max=Math.max(max,Sum-Game(i+3,stone));
        }
        return dp[i]=max;
    }
}