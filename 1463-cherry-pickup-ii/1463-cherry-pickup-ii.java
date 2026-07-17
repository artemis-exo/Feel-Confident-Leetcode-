class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
       Integer dp[][][]=new Integer[n][m][m];
       return Cherry(0,0,m-1,m,grid,dp); 
    }
    public int Cherry(int i, int j1, int j2, int col, int[][] grid, Integer dp[][][]){
        if(j1<0 || j2<0 || j1>=col || j2>=col){
            return (int)-1e8;
        }
        if(i==grid.length-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=null){
            return dp[i][j1][j2];
        }
        int max=(int)-1e8;
        for(int d1=-1; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                int val=0;
                if(j1==j2){
                    val=grid[i][j1];
                }
                else{
                    val=grid[i][j1]+grid[i][j2];
                }
                val+=Cherry(i+1,j1+d1,j2+d2,col,grid,dp);
                max=Math.max(max,val);
            }
        }
        return dp[i][j1][j2]=max;
    }
}