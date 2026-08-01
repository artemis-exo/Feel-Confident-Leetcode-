// Using NEGAMAX MEMOIZATION
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n][n];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
       return Game(0,n-1,nums,dp)>=0;
    }
    public int Game(int i, int j ,int nums[], int dp[][]){
        if(i==j)
        return nums[i];
        if(dp[i][j]!=-1)return dp[i][j];
        int pickLeft=nums[i]-Game(i+1,j,nums,dp);
        int pickRight=nums[j]-Game(i,j-1,nums,dp);
        return dp[i][j]=Math.max(pickLeft,pickRight);
    }
}