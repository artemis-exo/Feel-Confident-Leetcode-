// JAVA MEMOIZATION --- >> dir is used just for toggling the direction if a Mirror comes , rest all just the implemenatation of Unique path question
// class Solution {
//     int MOD=(int)1e9+7;
//     public int uniquePaths(int[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int dp[][][]=new int[n+1][m+1][2];

//         for(int i[][]:dp){
//             for(int it[]:i){
//                 Arrays.fill(it,-1);
//             }
//         }
//         return mirror(0,0,0,dp,grid);
//     }
//     public int mirror(int i, int j, int dir, int [][][]dp, int [][] grid){
//         if(i>=grid.length || j>=grid[0].length){
//             return 0;
//         }
//         if(i==grid.length-1 && j==grid[0].length-1){
//             return 1;
//         }
//         if(dp[i][j][dir]!=-1){
//             return dp[i][j][dir];
//         }
//         if(grid[i][j]==1){
//             if(dir==1){
//                 dp[i][j][dir]=mirror(i+1,j,0,dp,grid);
//             }
//             else{
//                 dp[i][j][dir]=mirror(i,j+1,1,dp,grid);
//             }
//         }
//         else{
//             dp[i][j][dir]=(mirror(i,j+1,1,dp,grid)+mirror(i+1,j,0,dp,grid))%MOD;
//         }
//         return dp[i][j][dir];
//     }
// }


class Solution {
    int MOD=(int)1e9+7;
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n+1][m+1][2];

        dp[n-1][m-1][0]=1;
        dp[n-1][m-1][1]=1;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    continue;
                }
                for(int dir=0; dir<2;dir++){
                    if(grid[i][j]==1){
                        if(dir==1){
                           dp[i][j][dir]=dp[i+1][j][0]; 
                        }
                        else{
                             dp[i][j][dir]=dp[i][j+1][1]; 
                        }
                    }
                    else{
                        dp[i][j][dir]=(dp[i+1][j][0]+dp[i][j+1][1])%MOD;
                    }
                }
            }
        }
       return dp[0][0][0];

    }
}