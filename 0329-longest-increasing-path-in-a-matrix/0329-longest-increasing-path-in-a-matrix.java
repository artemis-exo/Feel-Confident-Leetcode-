// // ** Simple Multisource BFS - It will give TLE;
// class Solution {
//     int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
//     public int longestIncreasingPath(int[][] matrix) {
//         int n=matrix.length;
//         int m=matrix[0].length;
//         if(n==0 && m==0)return 0;
//         if(n==1 && m==1)return 1;
//         int max=1;
//         for(int i=0;i<n; i++){
//             for(int j=0;j<m;j++){
//                max=Math.max(max,bfs(i,j,matrix));
//             }
//         }
//         return max;
//     }
//     public int bfs(int i, int j, int [][] matrix){
//         Queue<int[]>pq=new LinkedList<>();
//         pq.offer(new int[]{i,j});
//         int res=0;
//         while(!pq.isEmpty()){
//             int size=pq.size();
//             res++;
//             while(size-->0){
//                 int curr[]=pq.poll();
//                 int row=curr[0];
//                 int col=curr[1];
//                 for(int k=0;k<4;k++){
//                     int nr=row+dir[k][0];
//                     int nc=col+dir[k][1];

//                     if(nr<0 || nc<0 || nr>=matrix.length || nc>=matrix[0].length)
//                     continue;
//                     if(matrix[nr][nc]<=matrix[row][col])
//                     continue;
//                     pq.offer(new int[]{nr,nc});
//                 }
//             }
//         }
//         return res;
//     }
// }

// Using DFS + DP(Memoization)
class Solution {
    int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        if(n==0 && m==0)return 0;
        if(n==1 && m==1)return 1;
        int max=1;
        int [][] dp=new int[n][m];
        for(int i=0;i<n; i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]==0){
                   max=Math.max(max,dfs(i,j,matrix,dp));
                }
            }
        }
        return max;
    }
    public int dfs(int i, int j, int [][] matrix, int [][] dp){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j]=1;
        for(int it[] :dir){
            int nr=i+it[0];
            int nc=j+it[1];
            if(nr<0 || nc<0 || nr>=matrix.length || nc>=matrix[0].length)
            continue;
            if(matrix[nr][nc]<=matrix[i][j])
            continue;
            dp[i][j]=Math.max(dp[i][j],1+dfs(nr,nc,matrix,dp));
        }
        return dp[i][j];
    }
}