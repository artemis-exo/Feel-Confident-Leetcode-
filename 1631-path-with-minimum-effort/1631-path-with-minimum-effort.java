// ** Using  Binary Search And DFS
class Solution {
    int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    int m , n;
    public int minimumEffortPath(int[][] heights) {
        n=heights.length;
        m=heights[0].length;
        int low=0, high=1000000;
        while(low<=high){
            boolean [][] visit=new boolean[n][m];
            int mid=low+(high-low)/2;
            if(Effort(0,0,heights,mid,visit)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
          return low;
    }
     public boolean Effort(int r, int c, int height[][], int mid,boolean[][]visit){
       if(r==n-1 && c==m-1)
       return true;
       visit[r][c]=true;
       for(int it[]:dir){
        int nr=it[0]+r;
        int nc=it[1]+c;
        if(nr>=0 && nc>=0 && nr<n && nc<m && !visit[nr][nc]){
            if(Math.abs(height[nr][nc]-height[r][c])<=mid){
                if(Effort(nr,nc,height,mid,visit))
                return true;
            }
        }
       }
       return false;
     }
}