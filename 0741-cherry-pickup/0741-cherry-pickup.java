class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int [][][] dp=new int[n][n][n];
        for(int i[][]:dp){
            for(int r[]:i){
                Arrays.fill(r,-1);
            }
        }
        int res=Math.max(0,Cherry(0,0,0,grid,dp,n));
        return res;
    }
    public int Cherry(int r1, int c1, int r2, int grid[][],int dp[][][], int n){
        int c2=r1+c1-r2;
        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return (int)-1e8;
        }
        if(r1==n-1 && c1==n-1)
        return grid[r1][c1];

        if(dp[r1][c1][r2]!=-1){
            return dp[r1][c1][r2];
        }
        int cherry=0;
        if(r1==r2 && c1==c2){
            cherry=grid[r2][c2];
        }
        else{
            cherry=grid[r2][c2]+grid[r1][c1];
        }
        int max=Math.max(
            (Math.max(Cherry(r1+1,c1,r2+1,grid,dp,n),Cherry(r1+1,c1,r2,grid,dp,n))),
            (Math.max(Cherry(r1,c1+1,r2,grid,dp,n),Cherry(r1,c1+1,r2+1,grid,dp,n)))
            );

        return dp[r1][c1][r2]=max+cherry;
    }
}