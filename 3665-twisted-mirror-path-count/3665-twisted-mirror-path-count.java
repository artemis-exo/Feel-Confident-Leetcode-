// JAVA MEMOIZATION --- >> dir is used just for toggling the direction if a Mirror comes , rest all just the implemenatation of Unique path question
class Solution {
    int MOD=(int)1e9+7;
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n+1][m+1][2];

        for(int i[][]:dp){
            for(int it[]:i){
                Arrays.fill(it,-1);
            }
        }
        return mirror(0,0,0,dp,grid);
    }
    public int mirror(int i, int j, int dir, int [][][]dp, int [][] grid){
        if(i>=grid.length || j>=grid[0].length){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j][dir]!=-1){
            return dp[i][j][dir];
        }
        if(grid[i][j]==1){
            if(dir==1){
                dp[i][j][dir]=mirror(i+1,j,0,dp,grid);
            }
            else{
                dp[i][j][dir]=mirror(i,j+1,1,dp,grid);
            }
        }
        else{
            dp[i][j][dir]=(mirror(i,j+1,1,dp,grid)+mirror(i+1,j,0,dp,grid))%MOD;
        }
        return dp[i][j][dir];
    }
}