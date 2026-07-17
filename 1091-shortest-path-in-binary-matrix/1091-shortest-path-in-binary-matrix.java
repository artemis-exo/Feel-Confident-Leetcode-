class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)
        return -1;
        if(n==1)return 1;
        Queue<int[]>pq=new LinkedList<>();
        pq.offer(new int[]{0,0,1});
        grid[0][0]=1;
        int dir[][]={{-1,-1},{1,1},{-1,1},{1,-1},{1,0},{0,1},{-1,0},{0,-1}};
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            int row=curr[0];
            int col=curr[1];
            int dis=curr[2];
            for(int i[]:dir){
                int nr=row+i[0];
                int nc=col+i[1];
            
            if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0){
                if(nr==n-1 && nc==n-1)
                return dis+1;
                grid[nr][nc]=1;
                pq.offer(new int[] {nr,nc,dis+1});
            }
            }
        }
        return -1;
    }
}