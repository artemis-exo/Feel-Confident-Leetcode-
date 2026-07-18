// // ** Using  Binary Search And DFS
// class Solution {
//     int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
//     int m , n;
//     public int minimumEffortPath(int[][] heights) {
//         n=heights.length;
//         m=heights[0].length;
//         int low=0, high=1000000;
//         while(low<=high){
//             boolean [][] visit=new boolean[n][m];
//             int mid=low+(high-low)/2;
//             if(Effort(0,0,heights,mid,visit)){
//                 high=mid-1;
//             }
//             else{
//                 low=mid+1;
//             }
//         }
//           return low;
//     }
//      public boolean Effort(int r, int c, int height[][], int mid,boolean[][]visit){
//        if(r==n-1 && c==m-1)
//        return true;
//        visit[r][c]=true;
//        for(int it[]:dir){
//         int nr=it[0]+r;
//         int nc=it[1]+c;
//         if(nr>=0 && nc>=0 && nr<n && nc<m && !visit[nr][nc]){
//             if(Math.abs(height[nr][nc]-height[r][c])<=mid){
//                 if(Effort(nr,nc,height,mid,visit))
//                 return true;
//             }
//         }
//        }
//        return false;
//      }
// }

// ** Optimization Using Dijstra Algo
class Solution {
    int [][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int [][] dist=new int[n][m];
        for(int i[]:dist){
            Arrays.fill(i,(int)1e9);
        }
        pq.offer(new int[]{0,0,0});
        dist[0][0]=0;
        while(!pq.isEmpty()){
            int [] curr=pq.poll();
            int effort=curr[0];
            int row=curr[1];
            int col=curr[2];
            if(row==n-1 && col==m-1)
            return effort;
            if(dist[row][col]<effort)
            continue;
            for(int it[]:dir){
                int nr=row+it[0];
                int nc=col+it[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int AbsEffort=Math.abs(heights[nr][nc]-heights[row][col]);
                    int max=Math.max(AbsEffort,effort);
                    if(max<dist[nr][nc]){
                        dist[nr][nc]=max;
                        pq.offer(new int[]{max,nr,nc});
                    }
                }
            }
        }
        return -1;
    }
}