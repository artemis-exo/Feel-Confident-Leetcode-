class Solution {
    int [][]  dirs={{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n= grid.length;
      int low=0, high=n*n-1;
      while(low<=high){
        int mid=low+(high-low)/2;
        boolean visit[][]=new boolean[n][n];
        if(LevelTak(0,0,mid,grid,visit)){
            high=mid-1; // Aur chota do if satify bhi hogya hai toh (Lowest possible)
        }
        else{
            low=mid+1;
        }
      }
      return low;  // Low issliye kyuki hum  BS mey opposite polarity pe end karte hain toh depending on situation we can return either low/ high.. 
    }
    public boolean LevelTak(int i, int j, int mid, int[][] grid,boolean[][] visit){
        if(i<0 || j<0 || i>=grid.length||j>=grid.length || visit[i][j] ||  grid[i][j]>mid)
        return false;
        visit[i][j]=true;
        if(i==grid.length-1 && j==grid.length-1)
        return true;
        for(int it[]:dirs){
            int nr=it[0]+i;
            int nc=it[1]+j;
            if(LevelTak(nr,nc,mid,grid,visit))
            return true;
        }
        return false;
    }
}