class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int n=mat.length;
        int dp[][]=new int[n+1][5000+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return Mini(0,0,mat,target,dp);
    }
    public int Mini(int i, int val, int [][] mat, int target, int [][]dp){
        if(i==mat.length){
            return Math.abs(val-target); // jaisi  hi last row ke col pe pucho jo val bani uska Abs diff lelo target se aur return krdo
        }
        if(dp[i][val]!=-1){
            return dp[i][val];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=0; j<mat[0].length;j++){
            ans=Math.min(ans,Mini(i+1,val+mat[i][j],mat,target,dp)); // yhn ayegi woh val return hoke tab har baar min Calculate hoga
        }
        return dp[i][val]=ans;
    }
}