// class Solution {
//     public int minDistance(String word1, String word2) {
//         int n=word1.length();
//         int m=word2.length();
//         int dp[][]=new int[n+1][m+1];
//         for(int i[]:dp){
//             Arrays.fill(i,-1);
//         }
//         return Edit(word1,word2,n,m,dp);
//     }
//     public int Edit(String s, String t, int i, int j, int [][] dp){
//         if(j==0)return i;
//         if(i==0) return j;
//         if(dp[i][j]!=-1)
//         return dp[i][j];
//         if(s.charAt(i-1)==t.charAt(j-1)){
//             dp[i][j]=0+Edit(s,t,i-1,j-1,dp);
//         }
//         else{
//             int replace=1+Edit(s,t,i-1,j-1,dp);
//             int delete=1+Edit(s,t,i-1,j,dp);
//             int insert=1+Edit(s,t,i,j-1,dp);
//              dp[i][j]=Math.min(replace,Math.min(delete,insert));
//         }
//         return dp[i][j];
        
//     }
// }

// ** TABULATION

class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0; i<=n;i++){
            dp[i][0]=i;
        }
          for(int j=0; j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n; i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int replace=1+dp[i-1][j-1];
                   int delete=1+dp[i-1][j];
                   int insert=1+dp[i][j-1];
                   dp[i][j]=Math.min(replace,Math.min(delete,insert));
                }
            }
        }
        return dp[n][m];
    }
}